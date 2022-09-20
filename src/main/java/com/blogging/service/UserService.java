package com.blogging.service;

import java.io.IOException;
import java.util.List;

import com.blogging.model.Users;

public interface UserService {
	
	List<Users> findAllUsers() throws IOException;

}
