package com.blogging;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.blogging.service.PostsServiceImpl;
import com.blogging.service.UsersServiceImpl;

@Profile("test")
@Configuration
public class AdminServiceTestConfiguration {
	
	
	@Bean
	@Primary
	public UsersServiceImpl userService() {
		return Mockito.mock(UsersServiceImpl.class);
	}
	
	@Bean
	@Primary
	public PostsServiceImpl postsService() {
		return Mockito.mock(PostsServiceImpl.class);
	}
}


