package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JenkinsSpringBootApplicationTests {
	public static Logger logger = LoggerFactory.getLogger(JenkinsSpringBootApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Test Case Executing...");

		assertEquals(true, true);
		logger.info("Text Completed....");
	}

}
