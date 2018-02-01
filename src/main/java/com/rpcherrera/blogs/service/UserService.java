package com.rpcherrera.blogs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.entity.Item;
import com.rpcherrera.blogs.entity.Role;
import com.rpcherrera.blogs.entity.User;
import com.rpcherrera.blogs.repository.BlogRepository;
import com.rpcherrera.blogs.repository.ItemRepository;
import com.rpcherrera.blogs.repository.RoleRepository;
import com.rpcherrera.blogs.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired 
	private ItemRepository itemRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 5, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void saveUser(User user) {
		user.setEnabled(true);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);
	}
}
