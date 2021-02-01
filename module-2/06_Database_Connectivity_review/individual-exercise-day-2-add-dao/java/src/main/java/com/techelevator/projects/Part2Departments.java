package com.techelevator.projects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.models.Department;
import com.techelevator.projects.models.dao.DepartmentDAO;
import com.techelevator.projects.models.jdbc.JDBCDepartmentDAO;

public class Part2Departments
{
    JdbcTemplate jdbcTemplate;
	DepartmentDAO dao = new JDBCDepartmentDAO();
	
	public Part2Departments()
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
	    dataSource.setPassword("postgres1");
	    
	    jdbcTemplate = new JdbcTemplate(dataSource);
	}

    public void run()
    {
    	// *********************************
        // Part 2 - Working with departments
    	// *********************************
    	
    	// 2.1 - add all departments to the database
    	System.out.println("*** 2.1 Adding departments ***\n");
        addDepartment(1, "Department of Redundancey Department"); // misspelled on purpose
        addDepartment(2, "Network Administration");      
        addDepartment(3, "Research and Development");      
        addDepartment(4, "Store Support");        
        // TODO: add the remaining departments to the database        
        // TODO: add some of your own deparments - any name will do :)
        addDepartment(5, "Software Engineering");
        addDepartment(82, "Team Party Planners");
        
        
        // 2.2 - select all departments from the database
        System.out.println("\n*** 2.2 Displaying departments from the database ***\n");
        getAllDepartments();
        
        
        // 2.3 - find a department by id
        System.out.println("\n*** 2.3 Get department by Id ***\n");
        getDepartmentById(1);
        getDepartmentById(18);
        getDepartmentById(82);
        // try searching for some of your own
        getDepartmentById(2);
        getDepartmentById(3);
        getDepartmentById(4);
        getDepartmentById(5);//edge test
        getDepartmentById(0);//edge test
        
        // 2.4 - search for department by name
        System.out.println("\n*** 2.4 Search for department by name ***\n");
        searchForDepartmentByName("red");
        searchForDepartmentByName("Redundant");
        // try some other name searches
        searchForDepartmentByName("Network");
        searchForDepartmentByName("network");
        searchForDepartmentByName("NETWORK");
        searchForDepartmentByName("work");
        
        
        // 2.5
        System.out.println("\n*** 2.5 Modify a department name (UPDATE)***\n");
        updateDepartment(1, "Department of Redundancy Department");
        //verify that the update worked
        getDepartmentById(1);       

        
        // 2.6
        System.out.println("\n*** 2.6 Delete the Party department***\n");
        deleteDepartment(82);
        //verify that the delete worked
        getDepartmentById(82);

    	
    }

    private void addDepartment(int departmentId, String departmentName)
    {
    	try
		{				

        	String SQL = "INSERT INTO department (department_id, name)\r\n" + 
        							"VALUES (?,?);";
        	jdbcTemplate.update(SQL, departmentId, departmentName);
		} 
    	catch (Exception e)
		{
    		System.err.println("There was an error adding the following department --> " + departmentId + ": " + departmentName);
		}

    }
    
    private void getAllDepartments()
    {
    	String SQL = "SELECT department_id, name\r\n" + 
    			"FROM department;";
    	SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL);
    	while (rows.next())
    	{
    		int departmentId = rows.getInt("department_id");
    		String departmentName = rows.getString("name");
    		
    		System.out.println(departmentId + ": " + departmentName);
    		
    	}	       	
       
    }

    private void getDepartmentById(int departmentId)
    {
    	String SQL = "SELECT department_id, name\r\n" + 
    			"FROM department\r\n" + 
    			"WHERE department_id = ?; ";
       SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL, departmentId);
       
        if (rows.next())
        	{
        		String departmentName = rows.getString("name");
        	
        		System.out.println(departmentId+ ": " + departmentName);
        	}
        else 
        {
			System.out.println("There is no department with id: " + departmentId);
		}
    }

    private void searchForDepartmentByName(String name)
    {
    	String SQL = "SELECT name, department_id\r\n" + 
    			"FROM department\r\n" + 
    			"WHERE name ILIKE ?; ";
    	
    	SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL, "%" + name + "%");
    	while (rows.next())
    	{
    		int departmentId = rows.getInt("department_id");
    		String departmentName = rows.getString("name");
    		
    		System.out.println(departmentId + ": " + departmentName);
    		
    	}
        
    }
    
    private void updateDepartment(int departmentId, String departmentName)
    {
    	try
	    	
    	{
    		String SQL = "UPDATE department\r\n" + 
    	
    			"SET name = ? \r\n" + 
    			"WHERE department_id = ?;";
    			jdbcTemplate.update(SQL, departmentName, departmentId);
    		
    	}
     
    	catch (Exception e)
		{
    		System.err.println("There was an error updating the following department --> " + departmentId);
		}

    }

    private void deleteDepartment(int departmentId)
    {
    	try
		{		
    		String SQL = "DELETE FROM department\r\n" + 
    				"WHERE department_id = ?;";
    		jdbcTemplate.update(SQL,departmentId);
		} 
    	catch (Exception e)
		{
    		System.err.println("There was an error deleting department --> " + departmentId);
		}
    }
    
  
}
