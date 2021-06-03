package com.demo.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.demo.entity.Address;
import com.demo.entity.Department;
import com.demo.entity.Employee;
import com.demo.entity.Project;

public class RunnerMain {

	public static void main(String[] args) {
		// configure --> hibernate
		// configuration.xml --> database configuration --> xml
		// object mapping to database table  --> annotation
		
		// start the hibernate
		// save emp object
	
		Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistryObj = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry(); 
        // Creating Hibernate SessionFactory Instance
     
        // singleton 
        // HibernateUtil
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistryObj);

        // connection pool
        // heavy 
        // 
        // connection
        // String --> Date object
        // "2014/01/34"
                
        Employee emp=new Employee();
        emp.setName("suresh");
        emp.setDob(new Date());
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(emp);
        //session.update(emp);
        //session.delete(emp);
        session.getTransaction().commit();
        session.close();
        
        
        
        session=sessionFactory.openSession();
        session.beginTransaction();
        Department javaDepartment=new Department();
        javaDepartment.setDeptName("Java");
        session.save(javaDepartment);
        session.getTransaction().commit();
        session.close();
        
        
        session=sessionFactory.openSession();
        session.beginTransaction();
        emp.setDepartment(javaDepartment);
        session.update(emp);
        session.getTransaction().commit();
        session.close();
        
        Address address=new Address();
        address.setCity("bangalore");
        address.setAddress("address1");
        address.setEmployeeId(1);
        
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
        session.close();
        
        
        
        Project project=new Project();
        Project project1=new Project();
        project.setId(1);
        project1.setId(2);

        project.setVertical("Insurance");
        project1.setVertical("Banking");
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(project);
        session.save(project1);
        session.getTransaction().commit();
        session.close();
        
        
        session=sessionFactory.openSession();
        session.beginTransaction();
        Employee ramesh=(Employee) session.get(Employee.class, 1);  
        ramesh.setName("new Ramesh");
        Department d=ramesh.getDepartment();
        d.setDeptName("Full Stack Java");
        ramesh.setDepartment(d);
        session.update(ramesh);
        
        
        System.out.println(d);
        // Eager --> manytoone onetoone  -> lazy
        
        // onetoone manytoone eager
        // onetomany manytomany lazy
      
        // cascade
        // insert employee --> department
        // ca
        //employee container department --> save(emp)
        
        
        
        
        List <Project> projects=new ArrayList<Project>();
        projects.add(project);
        projects.add(project1);

        ramesh.setProjects(projects);
        session.save(ramesh);
        System.out.println(ramesh);
        
        
        session.getTransaction().commit();
        session.close();
        
        // mapping configuration
        // annotation
        
        
        //
		// factory --> one object
        // 
        // -> creational design pattern
        // new
	}

}
