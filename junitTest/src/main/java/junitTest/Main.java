package junitTest;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static int add(int a, int b)	{
		ConsoleAppender append = new ConsoleAppender();
		append.setThreshold(Level.WARN);
		append.setLayout(new PatternLayout(""));
		append.activateOptions();
		LogManager.getRootLogger().addAppender(append);
		logger.debug("Hello this is a debug message");
		logger.info("Hello this is a info message");
		return a + b;
	}

	public static void main(String[] args) {
		add(5, 7);
	}

}
