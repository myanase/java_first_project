package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Product;
import tool.DBConnection;

public class CartDAO{
	private static Connection getConnection() {
		try {
			Class.forName(DBConnection.RDB_DRIVE);
            return DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASSWD);
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	private static void allClose(PreparedStatement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }		
	}
	
	static Connection connection = null;
	static PreparedStatement statement = null;
	
	public List<Product> search(String[] checkid) throws Exception{
		List<Product> list = new ArrayList<>();
		
		String s = null;
		for(int i = 1; i <= checkid.length; i++){
			if(i == 1) {
				s = "?,";
			}else if(i == checkid.length) {
				s = s + "?"; 
			}else {
				s = s + "?,";
			}
		}
		try {
			connection = getConnection();
			statement = connection.prepareStatement("select * from product where id in ("+s+")");
			int n = 1;
			for(String id : checkid) {
				statement.setInt(n, Integer.parseInt(id));
				n++;
			}
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
	            Product p = new Product();
	            p.setId(resultSet.getInt("id"));
	            p.setName(resultSet.getString("name"));
	            p.setPrice(resultSet.getInt("price"));
	            p.setImage(resultSet.getString("image"));
	            p.setDetail(resultSet.getString("detail"));
	            p.setGenre(resultSet.getInt("genre"));
	            list.add(p);
	        }			
		} catch (SQLException e) {
            e.printStackTrace();
        } finally {
            allClose(statement, connection);
        } 
		return list;
	}	
}
