package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultithreadedMultiplyTask implements Callable<long[][]> {

	private long[][] matrixA;
	private long[][] matrixB;
	private long[][] resultMatrix;
	private AtomicBoolean[] reservedRows;
	private boolean printDetails;
	
	public MultithreadedMultiplyTask(Matrix matrixA, Matrix matrixB, long[][] resultMatrix, AtomicBoolean[] reservedRows, boolean printDetails) {
		this.matrixA = matrixA.getMatrix();
		this.matrixB = matrixB.getMatrix();
		this.resultMatrix = resultMatrix;
		this.reservedRows = reservedRows;
		this.printDetails = printDetails;
	}

	@Override
	public long[][] call() throws Exception {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < matrixA.length; i++) {
			if (reservedRows[i].compareAndSet(false, true)) {
				if (printDetails) {
				System.out.println(Thread.currentThread().getName() + " processing row: " + i);
				}
				for (int j = 0; j < matrixB[0].length; j++) {
					long res=0;
					for (int k = 0; k < matrixA[0].length; k++) {
						res += matrixA[i][k] * matrixB[k][j];
					}
				resultMatrix[i][j]=res;
				}
			}
		}
		if (printDetails) {
			System.out.println(Thread.currentThread().getName() + " finished for: " + (System.currentTimeMillis() - startTime) + " mills.");
		}
		return resultMatrix;
	}

}
