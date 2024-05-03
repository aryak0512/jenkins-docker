package com.aryak.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class JenkinsDockerApplicationTests {

	@Test
	 void applicationContextTest() {
		JenkinsDockerApplication.main(new String[] {});
		assertTrue(true);
	}

	@Test
	void test_getMessage_is_not_null() {

		JenkinsDockerApplication app = new JenkinsDockerApplication();
		assertNotNull(app.getMessage());
	}

}
