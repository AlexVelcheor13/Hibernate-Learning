package hiber_one_to_many;


import hiber_one_to_many.entity.Department;
import hiber_one_to_many.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Employee.class)// указываем класс котор имеет спец аннотации для работы с бд
                                                    .addAnnotatedClass(Department.class)
                                                    .buildSessionFactory();//метод который строит фабрику сеесий

        Session session = null;

        try {
            session = factory.getCurrentSession(); // session это обертка вокруг подкл-я к БД
//            Department department = new Department("IT", 333, 1233);
//            Employee employee1 = new Employee("Zaur", "Tregulov", 444);
//            Employee employee2 = new Employee("Oleg", "Turov", 1222);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);

            session.beginTransaction();
//            session.save(department);

//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmps());

            Employee employee = session.get(Employee.class, 3);
//            System.out.println(employee.getDepartment());
            session.delete(employee);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }


    }

}
