package junitTest;

import org.apache.log4j.Logger;

public class LogTest {
	
	static Logger log = Logger.getLogger(LogTest.class.getName());

	public static void main(String[] args) {
		log.debug("Hello this is a debug message");
	      log.info("Hello this is an info message");

	}

}
