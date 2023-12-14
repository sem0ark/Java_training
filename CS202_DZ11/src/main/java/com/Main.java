package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cli.ProgressBar;


/**
 * 
 * @author Arkadii Semenov 5833 SI FIT
 * @description Create a JavaFX application that loads all tutorial sections from https://www.tutorialspoint.com/python/.
 * 			   During the duration of the download, the application should display a progress bar that updates as the tutorials are downloaded. 
 * 			   Use separate threads to download and update progress bar.
 */
public class Main {
	
	public static void main(String ...args) throws IOException {
		List<String> links = getLinks();
		int total = links.size();
		
		Lock lock = new ReentrantLock();
		final Condition update = lock.newCondition();
		final Condition updated = lock.newCondition();
		ProgressBar pb = new ProgressBar(total, 50, "Loading pages", lock, update, updated);
		
		new Thread(pb).start();
		new Thread(() -> {
			lock.lock();
			try {	
				for(String link : links) {
					Jsoup.connect(link).get();
					// here we "download" the pages from the navigation links
					// avoided saving to not litter the env.
					update.signal();
					updated.await();
				}
			} catch (IOException | InterruptedException e) {
				log("Failed downloading");
			} finally {
				lock.unlock();
				System.out.println("\nComplete!");
			}
		}).start();
	}
	
	public static List<String> getLinks() throws IOException {
		Document doc = Jsoup.connect("https://www.tutorialspoint.com/python/index.htm").get();
		Elements links = doc.select("div.toc-nav ul.toc.chapters li a");
		
		List<String> result = new ArrayList<String>(); 
		
		for (Element link : links) result.add(link.absUrl("href"));
		return result;
	}
	
	public static void log(String format, Object... args) {
		System.out.printf(format, args);
	}
	
	public static void log(String str) {
		System.out.println(str);
	}
}
