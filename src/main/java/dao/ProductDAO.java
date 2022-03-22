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

public class ProductDAO{
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
	
	public List<Product> search(String focus, String keyword) throws Exception{
		List<Product> list = new ArrayList<>();
		
		/*
		 * 絞り込み検索
		 *  null：絞り込みなし
		 *  genre：1.ノーマル 2.惣菜 3.菓子
		 *  freeword:フリーワード検索
		 *  price：○○円以下
		 */
		String sen = "select * from product ";
		if(focus == "genre") {
			sen = sen + "where genre = ?";
		}else if(focus == "freeword"){
			sen = sen + "where name like ?";
		}else if(focus == "price"){
			sen = sen + "where price <= ?";
		}
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sen);
			if(focus == "genre" || focus == "price") {
				statement.setInt(1, Integer.parseInt(keyword));
			}else if(focus == "freeword"){
				statement.setString(1, "%"+keyword+"%");
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
