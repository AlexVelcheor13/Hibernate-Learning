package com.example;

import com.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                .buildSessionFactory();//метод который строит фабрику сеесий

        try {
            Session session = factory.getCurrentSession(); // session это обертка вокруг подкл-я к БД

            Employee employee = new Employee("Денис", "Gaw", "Таможня", 123321);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("Done!");
            System.out.println(employee);
        } finally {
            factory.close();
        }


    }

}
