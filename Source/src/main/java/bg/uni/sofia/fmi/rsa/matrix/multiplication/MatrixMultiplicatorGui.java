package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.commons.cli.ParseException;

public class MatrixMultiplicatorGui extends JFrame {
	
	public static final long serialVersionUID = 1;

	private JPanel contentPane;
	private JTextField matrixARows;
	private JTextField matrixAColumns;
	private JTextField matrixBRows;
	private JTextField matrixBColumns;
	private JTextField inputFile;
	private JTextField outputFile;
	private JTextField threads;
	
	public MatrixMultiplicatorGui() {
		setTitle("Matrix Multiplicator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		matrixARows = new JTextField();
		matrixARows.setHorizontalAlignment(SwingConstants.CENTER);
		matrixARows.setBounds(250, 70, 150, 30);
		contentPane.add(matrixARows);
		matrixARows.setColumns(3);

		matrixAColumns = new JTextField();
		matrixAColumns.setHorizontalAlignment(SwingConstants.CENTER);
		matrixAColumns.setBounds(250, 120, 150, 30);
		contentPane.add(matrixAColumns);
		matrixAColumns.setColumns(3);
		
		matrixBRows = new JTextField();
		matrixBRows.setHorizontalAlignment(SwingConstants.CENTER);
		matrixBRows.setBounds(620, 70, 150, 30);
		contentPane.add(matrixBRows);
		matrixBRows.setColumns(3);
		
		matrixBColumns = new JTextField();
		matrixBColumns.setHorizontalAlignment(SwingConstants.CENTER);
		matrixBColumns.setBounds(620, 120, 150, 30);
		contentPane.add(matrixBColumns);
		matrixBColumns.setColumns(3);

		inputFile = new JTextField();
		inputFile.setHorizontalAlignment(SwingConstants.CENTER);
		inputFile.setBounds(250, 200, 150, 30);
		contentPane.add(inputFile);
		inputFile.setColumns(30);

		outputFile = new JTextField();
		outputFile.setHorizontalAlignment(SwingConstants.CENTER);
		outputFile.setBounds(620, 200, 150, 30);
		contentPane.add(outputFile);
		outputFile.setColumns(30);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 70, 190, 30);
		panel_1.setBackground(Color.BLUE);
		contentPane.add(panel_1);
		
		JLabel matrixARowsLabel = new JLabel("Rows in matrix A");
		matrixARowsLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		matrixARowsLabel.setForeground(Color.WHITE);
		panel_1.add(matrixARowsLabel);
		
		JLabel label = new JLabel("");
		panel_1.add(label);

		JLabel result_Label = new JLabel("");
		result_Label.setFont(new Font("Calibri", Font.BOLD, 30));
		result_Label.setBounds(350, 350, 300, 30);
		contentPane.add(result_Label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(50, 120, 190, 30);
		panel_4.setBackground(Color.BLUE);
		contentPane.add(panel_4);
		
		JLabel matrixAColumnsLabel = new JLabel("Columns in matrix A");
		matrixAColumnsLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		matrixAColumnsLabel.setForeground(Color.WHITE);
		panel_4.add(matrixAColumnsLabel);
		
		JLabel label_2 = new JLabel("");
		panel_4.add(label_2);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(420, 70, 190, 30);
		panel_10.setBackground(Color.BLUE);
		contentPane.add(panel_10);
		
		JLabel matrixBRowsLabel = new JLabel("Rows in matrix B");
		matrixBRowsLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		matrixBRowsLabel.setForeground(Color.WHITE);
		panel_10.add(matrixBRowsLabel);
		
		JLabel label_10 = new JLabel("");
		panel_10.add(label_10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(420, 120, 190, 30);
		panel_5.setBackground(Color.BLUE);
		contentPane.add(panel_5);
		
		JLabel matrixBColumnsLabel = new JLabel("Columns in matrix B");
		matrixBColumnsLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		matrixBColumnsLabel.setForeground(Color.WHITE);
		panel_5.add(matrixBColumnsLabel);
		
		JLabel label_3 = new JLabel("");
		panel_5.add(label_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 200, 190, 30);
		panel.setBackground(Color.GREEN);
		contentPane.add(panel);
		
		JLabel inputFileLabel = new JLabel("Input file");
		inputFileLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		panel.add(inputFileLabel);
		
		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(420, 200, 190, 30);
		panel_6.setBackground(Color.GREEN);
		contentPane.add(panel_6);
		
		JLabel outputFileLabel = new JLabel("Output file");
		panel_6.add(outputFileLabel);
		outputFileLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JLabel label_6 = new JLabel("");
		panel_6.add(label_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(50, 280, 190, 30);
		panel_7.setBackground(Color.RED);
		contentPane.add(panel_7);
		
		JLabel lblThreads = new JLabel("Threads");
		lblThreads.setFont(new Font("Calibri", Font.BOLD, 20));
		lblThreads.setForeground(Color.WHITE);
		panel_7.add(lblThreads);
		
		JLabel label_8 = new JLabel("");
		panel_7.add(label_8);
		
				JButton btnCalculate = new JButton("Multiply");
				btnCalculate.setBounds(620, 280, 150, 40);
				btnCalculate.setFont(new Font("Calibri", Font.PLAIN, 30));
				contentPane.add(btnCalculate);
				btnCalculate.setToolTipText("Multiply matrixes");
				btnCalculate.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if (inputFile.getText().equals("") && (matrixARows.getText().equals("") || matrixAColumns.getText().equals("")
								|| matrixBRows.getText().equals("") || matrixBColumns.getText().equals(""))) {
							JOptionPane.showMessageDialog(null, "Please, fill the required fields.");
							return;
						}
						
						if(!matrixAColumns.getText().equals("") && !matrixBRows.getText().equals("") && !matrixBRows.getText().equals(matrixAColumns.getText()))
						{
							JOptionPane.showMessageDialog(null, "Please, enter the same number of rows in B as number of columns in A.");
							return;
						}

						try {
							String matrixARowsCount = matrixARows.getText();
							String matrixAColumnsBRowsCount = matrixAColumns.getText();
							String matrixBColumnsCount = matrixBColumns.getText();
							String inputFilename = inputFile.getText();
							String outputFilename = outputFile.getText();
							String threadsNumber = threads.getText();
							String[] args = buildArgs(matrixARowsCount, matrixAColumnsBRowsCount, matrixBColumnsCount, inputFilename, outputFilename, threadsNumber);
							ArgumentsParser parser = new ArgumentsParser(args);
							MatrixesBuilder builder = new MatrixesBuilder(parser);
							try {
								if (builder.build()) {
									//System.out.println(builder.getMatrixA());
									//System.out.println(builder.getMatrixB());
									MatrixesMultiplicator multiplicator = new MatrixesMultiplicator(parser, true);
									long result = multiplicator.multiply();
									result_Label.setText("Execution time: " +  result + " mills. ");
								}
							}catch (IOException ex) {
								System.err.println("Error while reading input file: " + ex.getMessage());
							} catch (NumberFormatException ex) {
								System.err.println("Error while parsing to int an argument: " + ex.getMessage());
							} catch (ParseException ex) {
								System.err.println("Error while parsing an argument: " + ex.getMessage());
							}
						} catch (IllegalArgumentException exc) {
							JOptionPane.showMessageDialog(null, "Not valid arguments.");
							return;
						}
						
					}
					
					private String[] buildArgs(String matrixARowsCount, String matrixAColumnsBRowsCount, String matrixBColumnsCount, String inputFilename, String outputFilename, String threadsNumber) {
						List<String> resultList = new ArrayList<>();
						if(!isArgEmpty(matrixARowsCount)){
							resultList.add("-m");
							resultList.add(matrixARowsCount);
						}
						if(!isArgEmpty(matrixAColumnsBRowsCount)){
							resultList.add("-n");
							resultList.add(matrixAColumnsBRowsCount);
						}
						if(!isArgEmpty(matrixBColumnsCount)){
							resultList.add("-k");
							resultList.add(matrixBColumnsCount);
						}
						if(!isArgEmpty(inputFilename)){
							resultList.add("-i");
							resultList.add(inputFilename);
						}
						if(!isArgEmpty(outputFilename)){
							resultList.add("-o");
							resultList.add(outputFilename);
						}
						if(!isArgEmpty(threadsNumber)){
							resultList.add("-t");
							resultList.add(threadsNumber);
						}
						String[] resultArgsArray = new String[resultList.size()];
						resultArgsArray = resultList.toArray(resultArgsArray);
						return resultArgsArray;
					}

					private boolean isArgEmpty(String arg) {
						return arg.length() == 0;
					}

				});
				btnCalculate.addKeyListener(new KeyListener() {

					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							if (inputFile.getText().equals("") && (matrixARows.getText().equals("") || matrixAColumns.getText().equals("")
									|| matrixBRows.getText().equals("") || matrixBColumns.getText().equals(""))) {
								JOptionPane.showMessageDialog(null, "Please, fill the required fields.");
								return;
							}
							
							if(!matrixAColumns.getText().equals("") && !matrixBRows.getText().equals("") && !matrixBRows.getText().equals(matrixAColumns.getText()))
							{
								JOptionPane.showMessageDialog(null, "Please, enter the same number of rows in B as number of columns in A.");
								return;
							}

							try {
								String matrixARowsCount = matrixARows.getText();
								String matrixAColumnsBRowsCount = matrixAColumns.getText();
								String matrixBColumnsCount = matrixBColumns.getText();
								String inputFilename = inputFile.getText();
								String outputFilename = outputFile.getText();
								String threadsNumber = threads.getText();
								String[] args = buildArgs(matrixARowsCount, matrixAColumnsBRowsCount, matrixBColumnsCount, inputFilename, outputFilename, threadsNumber);
								ArgumentsParser parser = new ArgumentsParser(args);
								MatrixesBuilder builder = new MatrixesBuilder(parser);
								try {
									if (builder.build()) {
										MatrixesMultiplicator multiplicator = new MatrixesMultiplicator(parser, true);
										long result = multiplicator.multiply();
										result_Label.setText("Execution time: " +  result + " mills.");
									}
								}catch (IOException ex) {
									System.err.println("Error while reading input file: " + ex.getMessage());
								} catch (NumberFormatException ex) {
									System.err.println("Error while parsing to int an argument: " + ex.getMessage());
								} catch (ParseException ex) {
									System.err.println("Error while parsing an argument: " + ex.getMessage());
								}
							} catch (IllegalArgumentException exc) {
								JOptionPane.showMessageDialog(null, "Not valid arguments.");
								return;
							}
						}
					}

					private String[] buildArgs(String matrixARowsCount, String matrixAColumnsBRowsCount, String matrixBColumnsCount, String inputFilename, String outputFilename, String threadsNumber) {
						List<String> resultList = new ArrayList<>();
						if(!isArgEmpty(matrixARowsCount)){
							resultList.add("-m");
							resultList.add(matrixARowsCount);
						}
						if(!isArgEmpty(matrixAColumnsBRowsCount)){
							resultList.add("-n");
							resultList.add(matrixAColumnsBRowsCount);
						}
						if(!isArgEmpty(matrixBColumnsCount)){
							resultList.add("-k");
							resultList.add(matrixBColumnsCount);
						}
						if(!isArgEmpty(inputFilename)){
							resultList.add("-i");
							resultList.add(inputFilename);
						}
						if(!isArgEmpty(outputFilename)){
							resultList.add("-o");
							resultList.add(outputFilename);
						}
						if(!isArgEmpty(threadsNumber)){
							resultList.add("-t");
							resultList.add(threadsNumber);
						}
						String[] resultArgsArray = new String[resultList.size()];
						resultArgsArray = resultList.toArray(resultArgsArray);
						return resultArgsArray;
					}

					private boolean isArgEmpty(String arg) {
						return arg.length() == 0;
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub

					}
				});
				btnCalculate.setFont(new Font("Calibri", Font.BOLD, 20));
				
				threads = new JTextField();
				threads.setHorizontalAlignment(SwingConstants.CENTER);
				threads.setColumns(30);
				threads.setBounds(250, 280, 150, 30);
				contentPane.add(threads);
				
				JLabel lblMatrixMultiplicator = new JLabel("Matrix Multiplicator");
				lblMatrixMultiplicator.setFont(new Font("Calibri", Font.BOLD, 30));
				lblMatrixMultiplicator.setHorizontalAlignment(SwingConstants.CENTER);
				lblMatrixMultiplicator.setBounds(280, 10, 300, 40);
				contentPane.add(lblMatrixMultiplicator);
	}
}

