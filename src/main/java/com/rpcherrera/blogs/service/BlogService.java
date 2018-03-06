package com.rpcherrera.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.rpcherrera.blogs.entity.Blog;
import com.rpcherrera.blogs.entity.Item;
import com.rpcherrera.blogs.entity.User;
import com.rpcherrera.blogs.exception.RssException;
import com.rpcherrera.blogs.repository.BlogRepository;
import com.rpcherrera.blogs.repository.ItemRepository;
import com.rpcherrera.blogs.repository.UserRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RssService rssService;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public void saveBlogItems(Blog blog) {
		try {
			List<Item> blogItems = rssService.getBlogItems(blog.getUrl());
			for (Item item : blogItems) {
				Item savedItem = itemRepository.findByBlogAndLink(blog, item.getLink());
				if (savedItem == null) {
					item.setBlog(blog);
					itemRepository.save(item);
				}
			}
		} catch (RssException e) {
			e.printStackTrace();
		}
	}

	public void saveBlog(Blog blog, String userEmail) {
		User user = userRepository.findByEmail(userEmail);
		blog.setUser(user);
		blogRepository.save(blog);
		saveBlogItems(blog);
	}
	
	@PreAuthorize("#blog.user.email == authentication.name or hasRole('ROLE_ADMIN')")
	public void deleteBlog(Blog blog) {
		blogRepository.delete(blog);
	}

	public Blog findOne(int id) {
		return blogRepository.findOne(id);
	}

}
