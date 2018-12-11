package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T>{
	
	protected Connection connection;
	
	public DAO() {
		try {
			Class.forName("com.maridb.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306?user=root&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected boolean create(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		statement.close();
		return true;
	}
	
	protected T getObjectByPrimaryKey(String query) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		T object = null;
		if (resultSet.next()) {
			object = instantiateObject(resultSet);
		} 
		statement.close();
		return object;
	}
	
	public List<T> getAll(String query) throws SQLException {
		List<T> objectList = new ArrayList<>();
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while(resultSet.next()) {
			T object = instantiateObject(resultSet);

			objectList.add(object);
		}
		statement.close();
		
		return objectList;
	}
	
	protected abstract T instantiateObject(ResultSet resultSet) throws SQLException;
}
