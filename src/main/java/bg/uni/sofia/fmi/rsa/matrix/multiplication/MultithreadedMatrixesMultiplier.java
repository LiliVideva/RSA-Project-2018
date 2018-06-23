package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class MultithreadedMatrixesMultiplier {

	private ExecutorService executor;
	private int threadsNumber;
	private boolean printDetails;
	
	public MultithreadedMatrixesMultiplier(int threadsNumber, boolean printDetails) {
		executor = Executors.newFixedThreadPool(threadsNumber);
		this.threadsNumber = threadsNumber;
		this.printDetails = printDetails;
		
	}

	public long[][] multiply(Matrix matrixA, Matrix matrixB) {
		long[][] resultMatrix = new long[matrixA.getRows()][matrixB.getCols()];
		AtomicBoolean[] reservedRows = new AtomicBoolean[matrixA.getRows()];
		for (int j = 0; j < reservedRows.length; j++) {
			reservedRows[j] = new AtomicBoolean(false);
		}
		for (int i = 0; i < threadsNumber; i++) {
			executor.submit(new MultithreadedMultiplyTask(matrixA, matrixB, resultMatrix, reservedRows, this.printDetails));
		}
		
		try {
			executor.shutdown();
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			System.err.println("Execution interrupted: " + e.getMessage());
			return null;
		}
		return resultMatrix;
	}

}
