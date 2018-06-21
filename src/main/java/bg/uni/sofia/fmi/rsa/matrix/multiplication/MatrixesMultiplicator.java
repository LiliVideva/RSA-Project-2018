package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.apache.commons.cli.ParseException;

public class MatrixesMultiplicator {
	private MatrixesBuilder builder;

	public MatrixesMultiplicator(ArgumentsParser parser) {
		this.builder = new MatrixesBuilder(parser);
	}

	public long multiply() throws NumberFormatException, IOException, ParseException {
		boolean build = this.builder.build();
		if (!build) {
			throw new IllegalArgumentException("Invalid number of arguments");
		}
		int threadsNumber = 1;
		ArgumentsParser parser = this.builder.getParser();
		Optional<String> argumentValueOptional = parser.getArgumentValue("t");
		if (argumentValueOptional.isPresent()) {
			threadsNumber = Integer.parseInt(argumentValueOptional.get());
		}

		Matrix matrixA = builder.getMatrixA();
		Matrix matrixB = builder.getMatrixB();
		
		long startTime = System.currentTimeMillis();
		long[][] result =  threadsNumber == 1 ? multiplySingleThreaded(matrixA, matrixB)
				: multiplyMultiThreaded(matrixA, matrixB, threadsNumber);
		long endTime = System.currentTimeMillis() - startTime;
		Optional<String> argumentOOptional = parser.getArgumentValue("o");
		if (argumentOOptional.isPresent()) {
			try {
				this.writeArrayToFile(argumentOOptional.get(), result);
			} catch (IOException e) {
				System.err.println("Cannot write result matrix to the file: " + argumentOOptional.get() + " - " + e.getMessage());
				return 0L;
			}
		}
		return endTime;
	}

	private long[][] multiplySingleThreaded(Matrix matrixA, Matrix matrixB) {
		int aRows = matrixA.getRows();
		int aColumns = matrixA.getCols();
		int bColumns = matrixB.getCols();
		long[][] matrixAArray = matrixA.getMatrix();
		long[][] matrixBArray = matrixB.getMatrix();

		long[][] result = new long[aRows][bColumns];
		for (int i = 0; i < aRows; i++) {
			for (int j = 0; j < bColumns; j++) {
				for (int k = 0; k < aColumns; k++) {
					result[i][j] += matrixAArray[i][k] * matrixBArray[k][j];
				}
			}
		}
		return result;
	}

	private long[][] multiplyMultiThreaded(Matrix matrixA, Matrix matrixB, int threadsNumber) {
		MultithreadedMatrixesMultiplier mmm = new MultithreadedMatrixesMultiplier(threadsNumber);
		return mmm.multiply(matrixA, matrixB);
	}

	private void writeArrayToFile (String filename, long[][] array) throws IOException{
		try(BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filename));){
			  outputWriter.write(Arrays.deepToString(array));
			  outputWriter.newLine();
			  outputWriter.flush();  
		  }
		}
}
