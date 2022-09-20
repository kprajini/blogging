package com.blogging;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.blogging.controller.AdminController;
import com.blogging.controller.WelcomeController;
import com.blogging.model.UserPosts;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminBlogApplicationTests {

	@Autowired
	private WelcomeController welcomeController;

	@Autowired
	private AdminController adminController;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		assertThat(welcomeController).isNotNull();
		assertThat(adminController).isNotNull();
	}

	@Test
	public void testGetBlogDetailsCall() throws Exception {

		List<UserPosts> responseEntity = Arrays.stream(this.restTemplate
				.getForObject("http://localhost:" + port + "/getblogdetails", UserPosts[].class)).collect(Collectors.toList());

		assertThat(responseEntity).isNotNull();
	}

}