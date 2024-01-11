package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import util.Factory;
import util.LockedProgressBar;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 100);
			
			List<String> links = getLinks();
			int total = links.size();
			
			Lock lock = new ReentrantLock();
			final Condition update = lock.newCondition();
			final Condition updated = lock.newCondition();
			
			LockedProgressBar pb = new LockedProgressBar(total, 50, "Loading pages", lock, update, updated);
			
			new Thread(pb).start();
			Label l = Factory.label("Loading...");
			
			root.setCenter(pb);
			root.setBottom(l);
			
			new Thread(() -> {
				lock.lock();
				try {	
					for(String link : links) {
						Jsoup.connect(link).get();
						// here we "download" the pages from the navigation links
						// avoided saving to not litter the env.
						log("Loaded %s\n", link);
						
						update.signal();
						updated.await();
					}
				} catch (IOException | InterruptedException e) {
					log("Failed downloading");
				} finally {
					lock.unlock();
					System.out.println("\nComplete!");
					
					Platform.runLater(() -> l.setText("Complete"));
				}
			}).start();
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
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
