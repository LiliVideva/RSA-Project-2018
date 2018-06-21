package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultithreadedMultiplyTask implements Callable<long[][]> {

	private long[][] matrixA;
	private long[][] matrixB;
	private long[][] resultMatrix;
	private AtomicBoolean[] reservedRows;
	
	public MultithreadedMultiplyTask(Matrix matrixA, Matrix matrixB, long[][] resultMatrix, AtomicBoolean[] reservedRows) {
		this.matrixA = matrixA.getMatrix();
		this.matrixB = matrixB.getMatrix();
		this.resultMatrix = resultMatrix;
		this.reservedRows = reservedRows;
	}

	@Override
	public long[][] call() throws Exception {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < matrixA.length; i++) {
			if (reservedRows[i].compareAndSet(false, true)) {
				System.out.println(Thread.currentThread().getName() + " processing row: " + i);
				for (int j = 0; j < matrixB[0].length; j++) {
					for (int k = 0; k < matrixA[0].length; k++) {
						resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
					}
				}
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished for: " + (System.currentTimeMillis() - startTime) + " mills.");
		return resultMatrix;
	}

}
