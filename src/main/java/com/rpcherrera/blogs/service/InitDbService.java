package com.rpcherrera.blogs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEmail("usertest@mail.com");
		userAdmin.setFirstname("firstuserfirstname");
		userAdmin.setLastname("firstuserlastname");
		userAdmin.setPassword("`");
		List<Role> roles = new ArrayList<>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userNormal = new User();
		userNormal.setEmail("usertest@mail.com");
		userNormal.setFirstname("firstuserfirstname");
		userNormal.setLastname("firstuserlastname");
		userNormal.setPassword("`");
		List<Role> roler = new ArrayList<>();
		roler.add(roleAdmin);
		roler.add(roleUser);
		userNormal.setRoles(roler);
		userRepository.save(userNormal);
		
		Blog blogah = new Blog();
		blogah.setName("TestBlog");
		blogah.setUrl("http://www.reddit.com/.rss");
		blogah.setUser(userNormal);
		blogRepository.save(blogah);
		
		Item itemOne = new Item();
		itemOne.setTitle("test item");
		itemOne.setDescription("reddit desc");
		itemOne.setPublishedDate(new Date());
		itemOne.setBlog(blogah);
		itemRepository.save(itemOne);
		
		Item itemTwo = new Item();
		itemTwo.setTitle("test item two");
		itemTwo.setDescription("reddit desc");
		itemTwo.setPublishedDate(new Date());
		itemTwo.setBlog(blogah);
		itemRepository.save(itemTwo);
		
		List<Item> items = new ArrayList<>();
		items.add(itemOne);
		items.add(itemTwo);
		blogah.setItems(items);
	}
}
