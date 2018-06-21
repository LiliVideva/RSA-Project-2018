package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.apache.commons.cli.ParseException;

public class MatrixesBuilder {
	private Matrix matrixA;
	private Matrix matrixB;
	private ArgumentsParser parser;

	public MatrixesBuilder(ArgumentsParser parser) {
		this.parser = parser;
	}
	
	public boolean build() throws ParseException, NumberFormatException, IOException {
		return parser.isInputFileGiven() ? this.buildMatrixesFromFile() : this.buildRandomMatrixes();
	}
	
	private boolean buildMatrixesFromFile() throws IOException, ParseException{
		Optional<String> filename = parser.getArgumentValue("i");
		Path inputFilePath = Paths.get(filename.get());
	
		List<String> lines = Files.lines(inputFilePath).collect(Collectors.toList());
		String headLine = lines.remove(0);
		initializeMatrixes(headLine);
		readRowValues(lines, this.matrixA.getRows(), this.matrixB.getRows());
		return true;
	}
	


	private void initializeMatrixes(String line) {
		String[] splittedHeadLine = line.split(" ");
		int matrixARows = Integer.parseInt(splittedHeadLine[0]);
		int matrixACols = Integer.parseInt(splittedHeadLine[1]), matrixBRows = Integer.parseInt(splittedHeadLine[1]);
		int matrixBCols = Integer.parseInt(splittedHeadLine[2]);
		long[][] matrixAArray = new long[matrixARows][matrixACols];
		long[][] matrixBArray = new long[matrixBRows][matrixBCols];	
		this.matrixA = new Matrix(matrixAArray);
		this.matrixB = new Matrix(matrixBArray);
	}

	private void readRowValues(List<String> lines, int rowsA, int rowsB) {
		long[][] matrixAArray = matrixA.getMatrix();
		for (int i = 0; i < rowsA; i++) {
			String line = lines.remove(0);
			String[] splittedLine = line.split(" ");
			long[] arrayInts = Arrays.asList(splittedLine).stream().mapToLong(Long::parseLong).toArray();
			matrixAArray[i] = arrayInts;
		}
		matrixA.setMatrix(matrixAArray);
		
		long[][] matrixBArray = matrixB.getMatrix();
		for (int j = 0; j < rowsB; j++) {
			String line = lines.remove(0);
			String[] splittedLine = line.split(" ");
			long[] arrayInts = Arrays.asList(splittedLine).stream().mapToLong(Long::parseLong).toArray();
			matrixBArray[j] = arrayInts;
		}
		matrixB.setMatrix(matrixBArray);
	}


	private boolean buildRandomMatrixes() throws NumberFormatException, ParseException{
		Optional<String> mValue = parser.getArgumentValue("m");
		Optional<String> nValue = parser.getArgumentValue("n");
		Optional<String> kValue = parser.getArgumentValue("k");
		if (!mValue.isPresent() || !nValue.isPresent() || !kValue.isPresent()) {
			return false;
		}
		
		int matrixARows = Integer.parseInt(mValue.get());
		int matrixACols = Integer.parseInt(nValue.get()), matrixBRows = Integer.parseInt(nValue.get());
		int matrixBCols = Integer.parseInt(kValue.get());
		long[][] matrixAArray = fillRandomMatrix(matrixARows, matrixACols);
		long[][] matrixBArray = fillRandomMatrix(matrixBRows, matrixBCols);
		this.matrixA = new Matrix(matrixAArray);
		this.matrixB = new Matrix(matrixBArray);

		return true;
	}
	
	private long[][] fillRandomMatrix(int matrixRows, int matrixCols) {
		long[][] matrixArray = new long[matrixRows][matrixCols];
		for (int i = 0; i < matrixArray.length; i++) {
			for (int j = 0; j < matrixArray[i].length; j++) {
				matrixArray[i][j] = ThreadLocalRandom.current().nextInt();				
			}
		}
		return matrixArray;
	}
	
	public Matrix getMatrixA() {
		return matrixA;
	}

	public Matrix getMatrixB() {
		return matrixB;
	}

	public ArgumentsParser getParser() {
		return parser;
	}

}
