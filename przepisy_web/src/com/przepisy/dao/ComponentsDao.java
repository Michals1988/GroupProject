package com.przepisy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.przepisy.connection.ConnectionMySQLExceptHandler;
import com.przepisy.connection.ConnectionMysql;
import com.przepisy.models.Components;

public class ComponentsDao {
	public static int CheckIfComponentExist (String componentCode) {
		
		int result =0;
		
		String QUERY_CODE_EXIST = "select count(id) as xx from components where code = ?"; 
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_CODE_EXIST)) {
                preparedStatement.setString(1, componentCode);

                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  result = resultSet.getInt("xx");                 	
                	}

            } catch (SQLException e) {           	
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }
		return result;
	}
	
	public static void AddNewComponent(Components component) {
		
		
		String ADD_COMPONENT_QUERY = "insert into components values(?,?,?,?,?)";
		
		Connection con = ConnectionMysql.getCon();
		
		try (        		
                PreparedStatement preparedStatement = con.prepareStatement(ADD_COMPONENT_QUERY)) {
                preparedStatement.setString(1, component.getGeneratedId());
                preparedStatement.setString(2, component.getId_unit());
                preparedStatement.setString(3, component.getCode());
                preparedStatement.setString(4, component.getDescription());                
                preparedStatement.setString(5, "0");

                System.out.println(preparedStatement);
                       
                preparedStatement.executeUpdate();
                
             

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }			
	}
	
	public static List<Components> listAllActiveComponents()  {
		
		List<Components> listComponents = new ArrayList<>();
         
        String SELECT_ACTIVE_COMPONENTS = "select a.id, a.id_unit, b.code as unit_descr,a.code, a.description,a.active from components as a"
        									+ " left join units as b"
        									+ " on a.id_unit = b.id";
         
        Connection con = ConnectionMysql.getCon();
        
        try (        		
                PreparedStatement preparedStatement = con.prepareStatement(SELECT_ACTIVE_COMPONENTS)) {
          
                System.out.println(preparedStatement);
                       
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                	  String id = resultSet.getString("id"); // id komponentu 
                	  String id_unit = resultSet.getString("id_unit"); // id jednostki
                	  String unit_code = resultSet.getString("unit_descr"); // kod/opis jednostki
                	  String code = resultSet.getString("code"); // kod komponentu
                	  String description = resultSet.getString("description");
                	  int active = resultSet.getInt("active"); 
                	  
                	  System.out.println(id);
                	  System.out.println(description);
                	  
                	  Components component = new Components();
                	  component.setId(id);
                	  component.setId_unit(id_unit);
                	  component.setUnit_descr(unit_code); // to jest kod ale w komponencie uznawany jako opis
                	  component.setCode(code);
                	  component.setDescription(description);
                	  component.setActive(active);
                	  listComponents.add(component);               	
                	}

            } catch (SQLException e) {
            	ConnectionMySQLExceptHandler.printSQLException(e);
            }		         
        return listComponents;
    }
	
	public static Components LoadComponentById  (String id) {


        Components component = new Components();

        String QUERY_COMPONENT_LOAD = "select id,id_unit,code,description,active from components where id =?"; 

        Connection con = ConnectionMysql.getCon();

        try (
                PreparedStatement preparedStatement = con.prepareStatement(QUERY_COMPONENT_LOAD)) {
                preparedStatement.setString(1, id);

                System.out.println(preparedStatement);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                      component.setId(resultSet.getString("id"));         
                      component.setId_unit(resultSet.getString("id_unit"));
                      component.setCode(resultSet.getString("code"));
                      component.setDescription(resultSet.getString("description"));
                      component.setActive(resultSet.getInt("active"));
                    }

            } catch (SQLException e) {
                ConnectionMySQLExceptHandler.printSQLException(e);
            }
        return component;
    }

}
