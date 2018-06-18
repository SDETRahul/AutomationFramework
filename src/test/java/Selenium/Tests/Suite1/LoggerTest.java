package Selenium.Tests.Suite1;

import org.apache.log4j.Logger;
import org.junit.Test;

import Base.TestBase;

public class LoggerTest extends TestBase{
	
	final static Logger logger=Logger.getLogger(LoggerTest.class);
	
	@Test
	public void testLogging()
	{
		logger.info("-----Entering Logging Message----");
		System.out.println("Testing Scripts in Between");
		logger.info("---Ending Logger-----------");
	}
	
	@Test
	public void testLoggingError()
	{
		logger.info("-----Entering Logging Message----");
		System.out.println("Testing Scripts in Between");
		logger.warn("Inserting in Void Object");
		logger.error("---Error in Logging Message-----------");
	}
	

}
