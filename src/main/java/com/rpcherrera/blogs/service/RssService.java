package com.rpcherrera.blogs.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import com.rpcherrera.blogs.entity.Item;
import com.rpcherrera.blogs.exception.RssException;
import com.rpcherrera.blogs.rss.ObjectFactory;
import com.rpcherrera.blogs.rss.TRss;
import com.rpcherrera.blogs.rss.TRssChannel;
import com.rpcherrera.blogs.rss.TRssItem;

@Service
public class RssService {

	public List<Item> getBlogItems(File file) throws RssException {
		return getBlogItems(new StreamSource(file));
	}

	public List<Item> getBlogItems(String url) throws RssException {
		return getBlogItems(new StreamSource(url));
	}

	private List<Item> getBlogItems(Source source) throws RssException {
		List<Item> blogItemList = new ArrayList<>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
			TRss rss = jaxbElement.getValue();

			List<TRssChannel> tRssChannels = rss.getChannel();
			for (TRssChannel tRssChannel : tRssChannels) {
				List<TRssItem> tRssItems = tRssChannel.getItem();
				for (TRssItem tRssItem : tRssItems) {
					Item item = new Item();
					item.setTitle(tRssItem.getTitle());
					item.setDescription(tRssItem.getDescription());
					item.setLink(tRssItem.getLink());
					Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)
							.parse(tRssItem.getPubDate());
					item.setPublishedDate(pubDate);
					blogItemList.add(item);
				}
			}

		} catch (JAXBException | ParseException e) {
			throw new RssException(e);
		}
		return blogItemList;
	}
}
