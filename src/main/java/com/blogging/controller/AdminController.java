package com.blogging.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogging.model.UserPosts;
import com.blogging.service.AdminService;

@RestController
public class AdminController {

	private static final Logger logger = LogManager.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;


	@RequestMapping(value = "/getblogdetails", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getUserPosts() {
		long beginTime = System.currentTimeMillis();
		ResponseEntity<List<UserPosts>> entity = null;
		
		try {
			List<UserPosts> userRelatedPostsList = adminService.getPostsRelatedToUsers();

			if (userRelatedPostsList!=null && userRelatedPostsList.size() > 0) {
				entity = new ResponseEntity<>(userRelatedPostsList,HttpStatus.OK);  
			}else {
				entity = new ResponseEntity<>(userRelatedPostsList,HttpStatus.NO_CONTENT);
			}			
		}
		catch(IOException ioe){
			return new ResponseEntity<>("IOException occurred !!!!", HttpStatus.NOT_FOUND);
		}
		catch (Exception e){
			return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		long responseTime = System.currentTimeMillis() - beginTime;
		logger.info("Total Time taken to process the API is "+responseTime +"ms");
		return entity;
	}

}
