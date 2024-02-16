package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crud.model.User;

public class UserDao {
	
	private String jdbcURL = "jdbc:mysql//localhost:3306/cruddb?useSSL=false";
	private String jdbcUserName = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
	        " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public void insertUser(User user) throws SQLException {
		try (
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement(INSERT_USERS_SQL)	
			)
		{
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getCountry());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/* folder structure */
//	simple-crud-java-servlet-jsp-mysql
//	  -src
//	    -main
//	      -java
//	        -com.crud.dao
//	          -UserDao.java
//	        -com.crud.model
//	          -User.java
//	        -com.crud.web
//	          -UserServlet.java
//	      -webapp
//	        -META-INF
//	          -MANIFEST.MF
//	        -WEB-INF
//	          -lib
//	          -web.xml
//	        -user-form.jsp
//	 -build

}
