package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(hibernate_one_to_one.entity.Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession(); // session это обертка вокруг подкл-я к БД
//            Employee employee = new Employee("Nick", "Wazowski", "Lego", 1001);
//            Detail detail = new Detail("Las Vegas", "990909", "nick@gmail.com");
//
//            employee.setEmpDetail(detail);
//            detail.setEmployee(employee);

            session.beginTransaction();
//            Detail detail = session.get(Detail.class, 4);
//            System.out.println(detail.getEmployee());
//            System.out.println(detail);
//            session.save(detail);
//            session.delete(detail);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }


    }
}
