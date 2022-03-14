package com.perscholas.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.perscholas.model.Employee;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class EmployeeController {
    public void createEmployeeTable()
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();
        Employee uone = new Employee();
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
    public void findEmployeeByName(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery q = session.getNamedQuery("findEmployeeByName");
        q.setParameter("name", "Tom Thele");
        List<Employee> employees = q.getResultList();
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee e = itr.next();
            System.out.println(e);
        }
        factory.close();
        session.close();
    }

    public void findEmployeeById(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery q = session.getNamedQuery("get_Emp_name_by_id");
        q.setParameter("id", 3);
        List<Object[]> emName = q.getResultList();
        Iterator<Object[]> itr = emName.iterator();
        while(itr.hasNext()){
            Object[] e = itr.next();
            System.out.println("Employee name: " +e[0] +" | Employee Salary: "+ e[1] +" | Emp Job Title: "+ e[2]);
        }
        factory.close();
        session.close();
    }

    public void showOfficeCodes_AsDepartment(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery query = session.getNamedQuery("empDepAlias");
        List<Object[]> list = query.getResultList();
        for(Object[] e : list) {
            System.out.println("OfficeCode: " + e[1] + " | Dep Name: " +e[3]+ " | Employee Name: " + e[2]);
        }
        factory.close();
        session.close();
    }


}