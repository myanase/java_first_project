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
	
	public List<Product> search(String sort, String genre, String keyword) throws Exception{
		List<Product> list = new ArrayList<>();
		
		/*
		 * 絞り込み検索
		 *  null：絞り込みなし
		 *  sort:新着順(new)、価格順(price)、人気順(popular)
		 *  genre：1.食事パン(normal) 2.惣菜(souzai) 3.菓子(desert)
		 *  keyword:フリーワード検索
		 */
		String sen = "select * from product ";
		//genre,keyword
		if(genre != null && keyword != null) {
			sen = sen + "where genre = ? and name like ? ";
		}else if(genre != null && keyword == null) {
			sen = sen + "where genre = ? ";
		}else if(genre == null && keyword != null) {
			sen = sen + "where name like ? ";
		}
		
		//sort
		if(sort == "price") {
			sen = sen + "order by price";
		}else if(sort == "popular") {
			sen = sen + "order by image desc";
		}
		
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sen);
			//genre,keyword
			if(genre != null && keyword != null) {
				statement.setInt(1, Integer.parseInt(genre));
				statement.setString(2, "%"+keyword+"%");
			}else if(genre != null && keyword == null) {
				statement.setInt(1, Integer.parseInt(genre));
			}else if(genre == null && keyword != null) {
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
