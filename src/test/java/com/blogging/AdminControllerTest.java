package com.blogging;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.blogging.controller.AdminController;
import com.blogging.model.PostsInfo;
import com.blogging.model.UserPosts;
import com.blogging.service.AdminService;


@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc
@AutoConfigureWebClient
public class AdminControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminService adminService;

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void shouldReturnListOfUsersAndRelatedPosts() throws Exception {
		List<UserPosts> userPostsList = Arrays.asList(new UserPosts(1, "sam","Samantha","Nathan@yesenia.net", "ramiro.info", Arrays.asList(new PostsInfo("Test12345","Post comment description"))));
		
		when(adminService.getPostsRelatedToUsers()).thenReturn(userPostsList);

		mockMvc.perform( MockMvcRequestBuilders
				.get("/getblogdetails")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());	      
	}

	@Test
	void shouldReturnNoContentIfPostsareNotAvailable() throws Exception {

		when(adminService.getPostsRelatedToUsers()).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/getblogdetails")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isNoContent());

	}
	
	@Test
	void shouldReturnNotFound() throws Exception {

		when(adminService.getPostsRelatedToUsers()).thenThrow(IOException.class);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/getblogdetails")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isNotFound());

	}
	
	@Test
	void shouldReturnException() throws Exception {

		when(adminService.getPostsRelatedToUsers()).thenThrow(NullPointerException.class);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/getblogdetails")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isInternalServerError());

	}
	
}