package com.przepisy.dao;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.Premium;
import com.przepisy.models.Units;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitsDao {
	
	public static int CheckIfUnitExist (String unit_code) {
		
		int result =0;
		
		String QUERY_CODE_EXIST = "select count(id) as xx from units where code = ?"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_CODE_EXIST)) {
                preparedStatement.setString(1, unit_code);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  result = resultSet.getInt("xx");                 	
                	}

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler sql_handler = new ConnectionMySQLExceptHandler();
            	sql_handler.printSQLException(e);
            }
		return result;
	}
	
	public static void AddNewUnit(Units unit) {
		
		int result =0;
		
		String ADD_UNIT_QUERY = "insert into units values(?,?,?)";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(ADD_UNIT_QUERY)) {
                preparedStatement.setString(1, unit.getGeneratedId());
                preparedStatement.setString(2, unit.getCode());
                preparedStatement.setString(3, unit.getDescription());

                System.out.println(preparedStatement);
                       
                result = preparedStatement.executeUpdate();
                
             

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler sql_handler = new ConnectionMySQLExceptHandler();
            	sql_handler.printSQLException(e);
            }			
	}
	
	public static List<Units> listAllActiveUnits()  {
		
		List<Units> listUnits = new ArrayList<>();
         
        String SELECT_ACTIVE_UNITS = "SELECT id,code,description FROM units order by code";
         
        Connection con = ConnectionMysql.getCon();
        
        try (        		
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_ACTIVE_UNITS)) {
          
                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  String id = resultSet.getString("id");
                	  String code = resultSet.getString("code");
                	  String description = resultSet.getString("description");
                	  
                	  Units unit = new Units();
                	  unit.setId(id);
                	  unit.setCode(code);
                	  unit.setDescription(description);
                	  listUnits.add(unit);               	
                	}

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler sql_handler = new ConnectionMySQLExceptHandler();
            	sql_handler.printSQLException(e);
            }		         
        return listUnits;
    }

}
