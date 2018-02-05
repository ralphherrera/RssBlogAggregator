package com.rpcherrera.blogs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.entity.User;
import com.rpcherrera.blogs.repository.BlogRepository;
import com.rpcherrera.blogs.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void saveBlog(Blog blog, String userEmail) {
		User user = userRepository.findByEmail(userEmail);
		blog.setUser(user);
		blogRepository.save(blog);
	}

	
}
