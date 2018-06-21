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

	private JPanel contentPane;
	private JTextField matrixARows;
	private JTextField matrixAColumnsBRows;
	private JTextField matrixBColumns;
	private JTextField inputFile;
	private JTextField outputFile;
	private JTextField threads;
	
	public MatrixMultiplicatorGui() {
		setTitle("Matrix Multiplicator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);

		matrixARows = new JTextField();
		matrixARows.setHorizontalAlignment(SwingConstants.CENTER);
		matrixARows.setBounds(450, 43, 215, 31);
		contentPane.add(matrixARows);
		matrixARows.setColumns(3);

		matrixAColumnsBRows = new JTextField();
		matrixAColumnsBRows.setHorizontalAlignment(SwingConstants.CENTER);
		matrixAColumnsBRows.setBounds(450, 92, 215, 33);
		contentPane.add(matrixAColumnsBRows);
		matrixAColumnsBRows.setColumns(3);

		matrixBColumns = new JTextField();
		matrixBColumns.setHorizontalAlignment(SwingConstants.CENTER);
		matrixBColumns.setBounds(450, 148, 215, 31);
		contentPane.add(matrixBColumns);
		matrixBColumns.setColumns(3);

		inputFile = new JTextField();
		inputFile.setHorizontalAlignment(SwingConstants.CENTER);
		inputFile.setBounds(450, 201, 215, 31);
		contentPane.add(inputFile);
		inputFile.setColumns(30);

		outputFile = new JTextField();
		outputFile.setHorizontalAlignment(SwingConstants.CENTER);
		outputFile.setBounds(450, 260, 215, 33);
		contentPane.add(outputFile);
		outputFile.setColumns(30);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(79, 43, 333, 31);
		contentPane.add(panel_1);
		
				JLabel matrixARowsLabel = new JLabel("Matrix A Rows");
				panel_1.add(matrixARowsLabel);
				matrixARowsLabel.setForeground(Color.WHITE);
				matrixARowsLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));

		JLabel label = new JLabel("");
		panel_1.add(label);

		JLabel result_Label = new JLabel("");
		result_Label.setFont(new Font("Rockwell Condensed", Font.PLAIN, 30));
		result_Label.setBounds(204, 441, 430, 58);
		contentPane.add(result_Label);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBounds(77, 92, 335, 31);
		contentPane.add(panel_4);
		
		JLabel matrixAColumnsBRowsLabel = new JLabel("Matrix A Columns & Matrix B Rows");
		panel_4.add(matrixAColumnsBRowsLabel);
		matrixAColumnsBRowsLabel.setBackground(Color.GRAY);
		matrixAColumnsBRowsLabel.setForeground(Color.WHITE);
		matrixAColumnsBRowsLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		
		JLabel label_2 = new JLabel("");
		panel_4.add(label_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GRAY);
		panel_5.setBounds(77, 148, 335, 31);
		contentPane.add(panel_5);
		
		JLabel label_1 = new JLabel("Matrix B Columns");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 17));
		panel_5.add(label_1);
		
		JLabel label_3 = new JLabel("");
		panel_5.add(label_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(79, 203, 335, 31);
		contentPane.add(panel);
		
		JLabel inputFileLabel = new JLabel("Input File");
		panel.add(inputFileLabel);
		inputFileLabel.setForeground(Color.WHITE);
		inputFileLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		
		JLabel label_5 = new JLabel("");
		panel.add(label_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.GRAY);
		panel_6.setBounds(79, 262, 335, 31);
		contentPane.add(panel_6);
		
		JLabel outputFileLabel = new JLabel("Output File");
		panel_6.add(outputFileLabel);
		outputFileLabel.setForeground(Color.WHITE);
		outputFileLabel.setFont(new Font("Rockwell Condensed", Font.BOLD, 17));
		
		JLabel label_6 = new JLabel("");
		panel_6.add(label_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.GRAY);
		panel_7.setBounds(79, 321, 335, 31);
		contentPane.add(panel_7);
		
		JLabel lblThreads = new JLabel("Threads");
		lblThreads.setForeground(Color.WHITE);
		lblThreads.setFont(new Font("Dialog", Font.BOLD, 17));
		panel_7.add(lblThreads);
		
		JLabel label_8 = new JLabel("");
		panel_7.add(label_8);
		
				JButton btnCalculate = new JButton("Multiply");
				btnCalculate.setBounds(324, 384, 129, 45);
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
						if (( inputFile.getText().equals("") && (matrixARows.getText().equals("") || matrixAColumnsBRows.getText().equals(""))
								|| matrixBColumns.getText().equals(""))) {
							JOptionPane.showMessageDialog(null, "Please, fill the required fields.");
							return;
						}

						try {
							String matrixARowsCount = matrixARows.getText();
							String matrixAColumnsBRowsCount = matrixAColumnsBRows.getText();
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
									MatrixesMultiplicator multiplicator = new MatrixesMultiplicator(parser);
									long result = multiplicator.multiply();
									result_Label.setText("Result: " +  result + " mills.Hooray! ");
								}
							}catch (IOException ex) {
								System.err.println("Error while reading input file: " + ex.getMessage());
							} catch (NumberFormatException ex) {
								System.err.println("Error while parsing to int an argument: " + ex.getMessage());
							} catch (ParseException ex) {
								System.err.println("Error while parsing an argument: " + ex.getMessage());
							}
						} catch (IllegalArgumentException exc) {
							JOptionPane.showMessageDialog(null, "Not valid kilograms.");
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
							if (( inputFile.getText().equals("") && (matrixARows.getText().equals("") || matrixAColumnsBRows.getText().equals(""))
									|| matrixBColumns.getText().equals(""))) {
								JOptionPane.showMessageDialog(null, "Please, fill the required fields.");
								return;
							}

							try {
								String matrixARowsCount = matrixARows.getText();
								String matrixAColumnsBRowsCount = matrixAColumnsBRows.getText();
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
										MatrixesMultiplicator multiplicator = new MatrixesMultiplicator(parser);
										long result = multiplicator.multiply();
										result_Label.setText("Result: " +  result + " mills.Hooray! ");
									}
								}catch (IOException ex) {
									System.err.println("Error while reading input file: " + ex.getMessage());
								} catch (NumberFormatException ex) {
									System.err.println("Error while parsing to int an argument: " + ex.getMessage());
								} catch (ParseException ex) {
									System.err.println("Error while parsing an argument: " + ex.getMessage());
								}
							} catch (IllegalArgumentException exc) {
								JOptionPane.showMessageDialog(null, "Not valid kilograms.");
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
				btnCalculate.setFont(new Font("Segoe Marker", Font.PLAIN, 17));
				
				threads = new JTextField();
				threads.setHorizontalAlignment(SwingConstants.CENTER);
				threads.setColumns(30);
				threads.setBounds(450, 321, 215, 33);
				contentPane.add(threads);
				
				JLabel lblMatrixMultiplicator = new JLabel("Matrix Multiplicator");
				lblMatrixMultiplicator.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				lblMatrixMultiplicator.setHorizontalAlignment(SwingConstants.CENTER);
				lblMatrixMultiplicator.setBounds(280, 6, 242, 25);
				contentPane.add(lblMatrixMultiplicator);
	}
}

