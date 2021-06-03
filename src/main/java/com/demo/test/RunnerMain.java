package com.demo.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.demo.entity.Address;
import com.demo.entity.Department;
import com.demo.entity.Employee;

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
        
        
        // mapping configuration
        // annotation
        
        
        //
		// factory --> one object
        // 
        // -> creational design pattern
        // new
	}

}
