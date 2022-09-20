package com.blogging.service;

import java.io.IOException;
import java.util.List;

import com.blogging.model.Posts;

public interface PostsService {
	
	List<Posts> findAllPosts() throws IOException;

}
