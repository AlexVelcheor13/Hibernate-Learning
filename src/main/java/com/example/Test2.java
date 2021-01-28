package com.example;

import com.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                .buildSessionFactory();//метод который строит фабрику сеесий

        try {

            //получаем объект из БД по id
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Oleg", "Dubov", "sales", 222);

            session.beginTransaction();
            session.save(employee);
           // session.getTransaction().commit();// закрываем ранзакцию

            int myId = employee.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, myId);// запрашиваем работника по id
            session.getTransaction().commit();
            System.out.println(employee1);

            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }
}
