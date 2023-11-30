package database;

import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import util.Config;

public class DatabaseConnector {
	private ConnectionSource connectionSource;
	private String databaseUrl;
	
	public DatabaseConnector() {
		this(Config.DATABASE_URL);
	}
	
	public DatabaseConnector(String databaseUrl) {
		this.databaseUrl = databaseUrl;
		try {
			this.connectionSource = new JdbcConnectionSource(this.databaseUrl);
			((JdbcConnectionSource)this.connectionSource).setUsername("root");
			((JdbcConnectionSource)this.connectionSource).setPassword("root");
			
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database");
			e.printStackTrace();
		}
		
	}
	
	private Dao<User, String> userDao;
	public Dao<User, String> getUserDao() {
		if(this.userDao == null) {
			try {
				this.userDao = DaoManager.createDao(this.connectionSource, User.class);
				TableUtils.createTableIfNotExists(this.connectionSource, User.class);
			} catch (SQLException e) {
				System.out.println("Failed to retrieve userDao");
				e.printStackTrace();
			}	
		}
		
		return this.userDao;
	}
	
	private Dao<Performance, String> performanceDao;
	public Dao<Performance, String> getPerformanceDao() {
		if(this.performanceDao == null) {
			try {
				this.performanceDao = DaoManager.createDao(this.connectionSource, Performance.class);
				TableUtils.createTableIfNotExists(this.connectionSource, Performance.class);
			} catch (SQLException e) {
				System.out.println("Failed to retrieve userDao");
				e.printStackTrace();
			}	
		}
		
		return this.performanceDao;
	}
}
