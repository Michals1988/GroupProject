package com.przepisy.user.dao;

import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.Premium;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PremiumDao {
	
	public static void LoadPremiumInfo (Premium premium,String user_id) {
		
		String LOADINFO = " select id,id_user,day_start,day_end,level from premium" +
				 				 "  where id_user = ? "
				 				 + "and day_start<now() "
				 				 + "and day_end >now()"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(LOADINFO)) {
                preparedStatement.setString(1, user_id);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  premium.setId(resultSet.getString("id")); 
                	  premium.setId_user(resultSet.getString("id_user"));
                	  premium.setDay_start(resultSet.getString("day_start"));
                	  premium.setDay_end(resultSet.getString("day_end"));
                	  premium.setLevel(resultSet.getInt("level"));
                	}

            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
		
	}
	
	private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
