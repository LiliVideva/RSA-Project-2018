package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.ParseException;

public class MultiplicatorStarter {
	private String[] args;
	
	public MultiplicatorStarter(String[] args){
		this.args = args;
	}
	
	public void start(){
		List<String> argsList = Arrays.asList(args);
		if(argsList.contains("-q")) {
			startConsole(false);
		}
		else {
			if (argsList.contains("-desktop")) {
				startGui();
			} else{
				startConsole(true);
			}
		}
	}

	private void startGui() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MatrixMultiplicatorGui frame = new MatrixMultiplicatorGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	private void startConsole(boolean printDetails) {
		ArgumentsParser parser = new ArgumentsParser(args);
		MatrixesBuilder builder = new MatrixesBuilder(parser);
		try {
			if (builder.build()) {
				MatrixesMultiplicator multiplicator = new MatrixesMultiplicator(parser, printDetails);
				long result = multiplicator.multiply();
				System.out.println("Execution time: " +  result + " mills.");
			}
		}catch (IOException e) {
			System.err.println("Error while reading input file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Error while parsing to int an argument: " + e.getMessage());
		} catch (ParseException e) {
			System.err.println("Error while parsing an argument: " + e.getMessage());
		}
	}
}
