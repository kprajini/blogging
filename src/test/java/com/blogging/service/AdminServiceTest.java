package com.blogging.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.blogging.model.Posts;
import com.blogging.model.UserPosts;
import com.blogging.model.Users;


@ActiveProfiles("test")
@SpringBootTest
class AdminServiceTest {

	@Autowired
	private UsersServiceImpl userService;

	@Autowired
	private PostsServiceImpl postsService;

	@Autowired
	private AdminService adminService;


	@BeforeEach
	void setUp() throws IOException {
		List<Users> usersList = Arrays.asList(new Users(1, "sam","Samantha","Nathan@yesenia.net", "0410000000","ramiro.info"));
		List<Posts> postsList = Arrays.asList(new Posts(1, 1, "Test12345","Post comment description"));

		Mockito.when(userService.findAllUsers()).thenReturn(usersList);
		Mockito.when(postsService.findAllPosts()).thenReturn(postsList);
	}

	@Test
	void testGetPostsRelatedToUsers() throws IOException {

		List<Users> usersList = Arrays.asList(new Users(1, "sam","Samantha","Nathan@yesenia.net", "0410000000","ramiro.info"));
		List<Posts> postsList = Arrays.asList(new Posts(1, 1, "Test12345","Post comment description"));

		Mockito.when(userService.findAllUsers()).thenReturn(usersList);
		Mockito.when(postsService.findAllPosts()).thenReturn(postsList);

		List<UserPosts> userPostsList = adminService.getPostsRelatedToUsers();
		assertThat(userPostsList).isNotNull();
		assertThat(userPostsList.size()).isEqualTo(1);
	}

	@Test
	void testGetPostsRelatedToUsers_WhenNoUsers() throws IOException {

		Mockito.when(userService.findAllUsers()).thenReturn(null);
		List<UserPosts> userPostsList = adminService.getPostsRelatedToUsers();
		assertThat(userPostsList).isNull();
	}

	@Test
	void testGetPostsRelatedToUsers_WhenNoPostsAvailableForUsers() throws IOException {

		List<Users> usersList = Arrays.asList(new Users(1, "sam","Samantha","Nathan@yesenia.net", "0410000000","ramiro.info"));
		Mockito.when(userService.findAllUsers()).thenReturn(usersList);
		Mockito.when(postsService.findAllPosts()).thenReturn(null);
		List<UserPosts> userPostsList = adminService.getPostsRelatedToUsers();
		assertThat(userPostsList).isNotNull();
		assertThat(userPostsList.size()).isEqualTo(1);
	}

}