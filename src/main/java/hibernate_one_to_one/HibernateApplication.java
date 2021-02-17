package hibernate_one_to_one;


import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(hibernate_one_to_one.entity.Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                                                    .addAnnotatedClass(Detail.class)
                                                    .buildSessionFactory();//метод который строит фабрику сеесий

        Session session = null;

        try {
            session = factory.getCurrentSession(); // session это обертка вокруг подкл-я к БД
//            Employee employee = new Employee("Oleg", "Smirnov", "Pirate", 100);
//            Detail detail = new Detail("NoN", "777", "freepirates@gmail.com");
//            employee.setEmpDetail(detail);
            //Employee employee = new Employee("Денис", "Gaw", "Таможня", 123321);

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            System.out.println(employee.getEmpDetail());
            session.delete(employee);
//            session.save(employee);
            //session.save(employee);
            session.getTransaction().commit();

            System.out.println("Done!");
            //System.out.println(employee);
        } finally {
            session.close();
            factory.close();
        }


    }

}
