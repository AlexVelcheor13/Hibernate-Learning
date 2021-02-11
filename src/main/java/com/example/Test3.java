package com.example;

import com.example.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Test3 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                .buildSessionFactory();//метод который строит фабрику сеесий

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//получаем всех работников
//            List<Employee> employees = session.createQuery("from Employee")//делаем запрос и пишем не имя таблицы а имя класса
//                    .getResultList();
            //получим работников по имени
            List<Employee> employees = session.createQuery("from Employee where name = 'Alex' AND salary>499")
                    .getResultList();
            for (Employee e: employees){
//                e.setSalary(1001);
                System.out.println(e);
            }

            session.getTransaction().commit();


            System.out.println("Done!");

        } finally {
            factory.close();
        }


    }
}
