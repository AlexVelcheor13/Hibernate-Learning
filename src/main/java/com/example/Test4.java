package com.example;

import com.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Test4 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                .buildSessionFactory();//метод который строит фабрику сеесий

        try {


            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 13);
            employee.setSalary(1500);
            session.createQuery("update Employee set salary = 1411 where name = 'Денис'")
                    .executeUpdate();//запускаем с помощью этого метода


            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }
}
