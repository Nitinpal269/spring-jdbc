package com.spring.jdbc;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program started" );
        
        //spring jdbc=>jdbc Template
        
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        
        //insert 
		
		 Student student=new Student(); 
		 student.setId(9944); 
		 student.setName("abcdfd");
		 student.setCity("delhiiii");
		 
		 int result=studentDao.insert(student);
		 System.out.println("student added"+result);
		 
        
        //update
		
		  Student st=new Student(); 
		 st.setId(123);
		 st.setName("rajkumar"); 
		 st.setCity("Lucknow"); 
		  int r=studentDao.change(st); 
		 System.out.println("data changed"+r);
		 
        
		
		 //delete 
		 Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter id of student"); 
		 int value=sc.nextInt(); 
		 
		 int re=studentDao.delete(value); 
		 System.out.println("deleted "+re);
		 
        
		/*
		 * //select one student 
		 * Student student=studentDao.getStudent(222);
		 * System.out.println(student);
		 */
        List<Student> students=studentDao.getAllStudents();
        for(Student s : students)
        {
        	System.out.println(s);
        	
        }
        		
        
    }
}
