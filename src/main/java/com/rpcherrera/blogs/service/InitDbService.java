package com.rpcherrera.blogs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEmail("userAdmin@mail.com");
		userAdmin.setFirstname("Admin User");
		userAdmin.setLastname("Admin Ako");
		userAdmin.setPassword(encoder.encode("zxca123"));
		userAdmin.setEnabled(true);
		userAdmin.setDateRegistered(new Date());
		List<Role> roles = new ArrayList<>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		User userNormal = new User();
		userNormal.setEmail("userNormal@mail.com");
		userNormal.setFirstname("Normal User");
		userNormal.setLastname("Normal ako");
		userNormal.setPassword(encoder.encode("zxca123"));
		userNormal.setEnabled(true);
		userNormal.setDateRegistered(new Date());
		List<Role> roler = new ArrayList<>();
		roler.add(roleUser);
		userNormal.setRoles(roler);
		userRepository.save(userNormal);
		
		Blog blogah = new Blog();
		blogah.setName("Reddit Main Feed");
		blogah.setUrl("http://www.reddit.com/.rss");
		blogah.setUser(userAdmin);
		blogRepository.save(blogah);
		
		Blog blogar = new Blog();
		blogar.setName("Tipid pc");
		blogar.setUrl("http://www.reddit.com/.rss");
		blogar.setUser(userNormal);
		blogRepository.save(blogar);
		
		Item itemOne = new Item();
		itemOne.setTitle("/r/Philippines");
		itemOne.setDescription("Subreddit for the Philippines and all things Filipino!");
		itemOne.setPublishedDate(new Date());
		itemOne.setBlog(blogah);
		itemOne.setLink("https://www.reddit.com/r/Philippines/");
		itemRepository.save(itemOne);
		
		Item itemTwo = new Item();
		itemTwo.setTitle("/r/aww");
		itemTwo.setDescription("Things that make you go AWW! -- like puppies, bunnies, babies, and so on...");
		itemTwo.setPublishedDate(new Date());
		itemTwo.setBlog(blogah);
		itemTwo.setLink("https://www.reddit.com/r/aww/");
		itemRepository.save(itemTwo);
		
		Item itemThree = new Item();
		itemThree.setTitle("TipidPC");
		itemThree.setDescription("tpc");
		itemThree.setPublishedDate(new Date());
		itemThree.setBlog(blogar);
		itemThree.setLink("https://tipidpc.com/");
		itemRepository.save(itemThree);
		
		List<Item> itemListOne = new ArrayList<>();
		itemListOne.add(itemOne);
		itemListOne.add(itemTwo);
		blogah.setItems(itemListOne);
		
		List<Item> itemListTwo = new ArrayList<>();
		itemListTwo.add(itemThree);
		blogar.setItems(itemListTwo);
	}
}
