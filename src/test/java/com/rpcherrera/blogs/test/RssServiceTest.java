package com.rpcherrera.blogs.test;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.rpcherrera.blogs.entity.Item;
import com.rpcherrera.blogs.exception.RssException;
import com.rpcherrera.blogs.service.RssService;

public class RssServiceTest {

	private RssService rssService;
	
	@Before
	public void setUp() {
		rssService = new RssService();
	}
	
	@Test
	public void testGetBlogItemsFile() throws RssException {
		List<Item> itemList = rssService.getBlogItems(new File("test-rss/reddit-android.xml"));
		
//		List<Item> itemList = rssService.getBlogItems("http://feeds.feedburner.com/javavids?format=xml");
		System.out.println(itemList.size());
		
		Item itemOne = itemList.get(0);
		System.out.println(itemOne.getTitle());
		System.out.println(itemOne.getDescription());
		System.out.println(itemOne.getLink());
		System.out.println(itemOne.getPublishedDate());
	}

}
