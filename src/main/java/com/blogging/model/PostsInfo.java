package com.blogging.model;

import lombok.Data;

@Data
public class PostsInfo {

	public String title;
	public String body;

	public PostsInfo(){
		
	}

	//Added for Unit testing
	public PostsInfo(String title, String comment) {
		this.title = title;
		this.body = comment;
	}


}
