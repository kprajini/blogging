package com.blogging.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.client.RestTemplate;

import com.blogging.model.Users;

@WebMvcTest(PostsServiceImpl.class)
@AutoConfigureWebClient
class UserServiceTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	void findAllUsers() {

		List<Users> postsList = Arrays.stream(this.restTemplate
				.getForObject("https://jsonplaceholder.typicode.com/users", Users[].class)).collect(Collectors.toList());

		assertThat(postsList).isNotNull();
		assertThat(postsList.size()).isEqualTo(10);

	}
}