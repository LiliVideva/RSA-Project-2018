package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.util.Arrays;

public class Matrix {
	private int rows;
	private int cols;
	private long[][] matrix;
	
	public Matrix(long[][] matrixArray) {
		this.rows = matrixArray.length;
		this.cols = matrixArray[0].length;
		this.matrix = matrixArray;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public long[][] getMatrix() {
		return Arrays.copyOf(matrix, matrix.length);
	}

	public void setMatrix(long[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	public String toString() {
		return "Matrix [rows=" + rows + ", cols=" + cols + ", matrix=" + Arrays.deepToString(matrix) + "]";
	}
	
}
