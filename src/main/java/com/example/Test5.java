package com.example;

import com.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test5 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                .buildSessionFactory();//метод который строит фабрику сеесий

        try {


            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 8);
//            session.delete(employee);
            session.createQuery("delete Employee where surname = 'Gaw'").executeUpdate();

            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }
}
