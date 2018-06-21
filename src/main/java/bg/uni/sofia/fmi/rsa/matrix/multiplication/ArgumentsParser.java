package bg.uni.sofia.fmi.rsa.matrix.multiplication;

import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ArgumentsParser {
	private Options options;
	private String[] args;
	private CommandLineParser parser;
    
	public ArgumentsParser(String[] args){
		this.options = new Options();
		this.parser = new DefaultParser();
		this.args = args;
		this.loadCommandOptions();
	}

    
    private void loadCommandOptions() {
    	options.addOption(Option.builder().longOpt("m").argName("m").hasArg().numberOfArgs(1).type(Integer.class).build());
        options.addOption(Option.builder().longOpt("n").argName("n").hasArg().numberOfArgs(1).type(Integer.class).build());
        options.addOption(Option.builder().longOpt("k").argName("k").hasArg().numberOfArgs(1).type(Integer.class).build());
        options.addOption(Option.builder().longOpt("i").argName("i").hasArg().numberOfArgs(1).type(String.class).build());
        options.addOption(Option.builder().longOpt("t").argName("t").hasArg().numberOfArgs(1).type(Integer.class).build());
        options.addOption(Option.builder().longOpt("o").argName("o").hasArg().numberOfArgs(1).type(String.class).build());
        options.addOption(Option.builder().longOpt("desktop").argName("desktop").build());
        
    }

    private CommandLine getCommandLine() throws ParseException{
    	return this.parser.parse(options, args);
    }
    
    public Optional<String> getArgumentValue(String arg) throws ParseException{
    	CommandLine commandLine = this.getCommandLine();
        
        if (!commandLine.hasOption(arg)) {
        	return Optional.empty();
        } 
        return Optional.of(commandLine.getOptionValue(arg));
      
    }
    
    public boolean isInputFileGiven() throws ParseException{
    	return this.getCommandLine().hasOption("i");
    }

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}
    
}
