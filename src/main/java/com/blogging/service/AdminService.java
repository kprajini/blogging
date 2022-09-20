package com.blogging.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.model.Posts;
import com.blogging.model.PostsInfo;
import com.blogging.model.UserPosts;
import com.blogging.model.Users;

@Service
public class AdminService {

	private static final Logger logger = LogManager.getLogger(AdminService.class);

	@Autowired
	private UsersServiceImpl usersServiceImpl;

	@Autowired
	private PostsServiceImpl postsServiceImpl;

	/** 
	 * This method iterates the User's list and get the related posts related to that user. 
	 * @see IOException  
	 * @return List<UserPosts> This returns the List of users and related posts information. 
	 */ 
	public List<UserPosts> getPostsRelatedToUsers() throws IOException{

		logger.info("Entry >>> getPostsRelatedToUsers ");
		List<UserPosts> userPostsList = null;
		List<Users> usersList = usersServiceImpl.findAllUsers();

		List<Posts> postsList = postsServiceImpl.findAllPosts();

		if (usersList == null || usersList.isEmpty()) {
			logger.info("The User list is empty. No Users Found!!!");
		}else {
			userPostsList = usersList.stream().map(user -> {

				UserPosts obj = new UserPosts();

				obj.id=user.id;
				obj.name= user.name;
				obj.userName = user.username;
				obj.website=user.website;
				obj.email=user.email;
				try {
					obj.posts =  getRelatedPosts(user.id,postsList);
				} catch (IOException e) {
					logger.error("IOException occurred while invoking the User Posts "+e.getMessage(),e);
					obj.posts = null;
				}
				return obj;
			}).collect(Collectors.toList());
		}
		logger.info("Exit <<<< getPostsRelatedToUsers : "+userPostsList);
		return userPostsList;
	}

	/** 
	 * This method traverses the posts list and get the related posts based on UserId. 
	 * @param args id , postsList
	 * @see IOException  
	 * @return List<PostsInfo> This returns the List of related posts based on UserId 
	 */ 
	public List<PostsInfo> getRelatedPosts(int id,List<Posts> postsList) throws IOException {
		
		List<Posts> targetPostsList = null;
		List<PostsInfo> postsInfoList = null;

		if (postsList == null || postsList.isEmpty()) {
			logger.info("The Posts list is empty. No Posts Found for UserId: "+id);
		}else {
			
			targetPostsList = postsList.stream().filter(p -> p.userId == id).collect(Collectors.toList());

			if(targetPostsList!=null && targetPostsList.size()>0) {

				postsInfoList = new ArrayList<>(targetPostsList.size());

				for(Posts postObj :targetPostsList) {

					PostsInfo postsInfoObj = new PostsInfo();
					postsInfoObj.body = postObj.body;
					postsInfoObj.title = postObj.title;
					postsInfoList.add(postsInfoObj);
				}

			}

		}
		return postsInfoList;
	}
	
	
	//Added for UI
	/** 
	 * This method traverses the posts list and get the related posts based on UserId. 
	 * @param args userId 
	 * @see IOException  
	 * @return List<PostsInfo> This returns the List of related posts based on UserId 
	 */ 
	public List<PostsInfo> getRelatedPostsBasedOnUserId(int id) throws IOException {
		
		logger.info("Entry >>> getRelatedPostsBasedOnUserId(id):"+id);
		
		List<Posts> postsList = postsServiceImpl.findAllPosts();
		List<Posts> targetPostsList = null;
		List<PostsInfo> postsInfoList = null;

		if (postsList == null || postsList.isEmpty()) {
			logger.info("The Posts list is empty. No Posts Found for UserId:"+id);
		}else {
			
			targetPostsList = postsList.stream().filter(p -> p.userId == id).collect(Collectors.toList());

			if(targetPostsList!=null && targetPostsList.size()>0) {

				postsInfoList = new ArrayList<>(targetPostsList.size());

				for(Posts postObj :targetPostsList) {

					PostsInfo postsInfoObj = new PostsInfo();
					postsInfoObj.body = postObj.body;
					postsInfoObj.title = postObj.title;
					postsInfoList.add(postsInfoObj);
				}

			}

		}
		return postsInfoList;
	}
}
