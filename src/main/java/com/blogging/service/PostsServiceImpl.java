package com.blogging.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blogging.model.Posts;

/**
 * Service for Invoking the Post's API
 * 
 * @author rk105670
 *
 */
@Service
public class PostsServiceImpl implements PostsService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${resource.posts}")
	private String postsResourceUrl;
	
	/**
	 * Method will invoke the Post's API and returns the Posts Info
	 * 
	 * @return ist<Posts>
	 * @throws IOException
	 */
	public List<Posts> findAllPosts() throws IOException{
		return Arrays.stream(restTemplate.getForObject(postsResourceUrl, Posts[].class)).collect(Collectors.toList());
	}

}
