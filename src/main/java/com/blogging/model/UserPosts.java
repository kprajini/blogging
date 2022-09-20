package com.blogging.model;

import java.util.List;

import lombok.Data;

@Data
public class UserPosts {
	
	public int id;
    public String name;
    public String userName;
    public String email;
    public String website;
    public List<PostsInfo> posts;
	
 
	public UserPosts() {
		
	}
	
	//Added for Unit Testing
	public UserPosts(int i, String name, String userName, String email, String website, List<PostsInfo> asList) {
		this.id = i;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.website = website;
		this.posts = asList;
	}
	
}
