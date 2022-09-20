package com.blogging.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blogging.model.Users;
/**
 * Service for Invoking the User's API
 * 
 * @author rk105670
 *
 */
@Service
public class UsersServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;

	@Value("${resource.users}")
	private String usersResourceUrl;

	/**
	 * Method will invoke the User's API and return the List of User's Info
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<Users> findAllUsers() throws IOException{

		return Arrays.stream(restTemplate.getForObject(usersResourceUrl, Users[].class)).collect(Collectors.toList());

	}

}
