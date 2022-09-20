package com.blogging.model;

import lombok.Data;

@Data
public class Posts {
	
	
	public int userId;
    public int id;
    public String title;
    public String body;
    
    public Posts() {
		
	}
	
    //Added for Unit Testing
	public Posts(int userId, int id, String postTitle, String postComment) {
		this.userId = userId;
		this.id = id;
		this.title = postTitle;
		this.body = postComment;
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer();
		builder.append("Posts [userId=");
		builder.append(userId);
		builder.append(", id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", body=");
		builder.append(body);
		builder.append("]");
		return builder.toString();
	}
	
	
}
