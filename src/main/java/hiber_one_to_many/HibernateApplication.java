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
//            Department department = new Department("Sales", 555, 5555);
//            Employee employee1 = new Employee("Zaur", "Tregulov", 555);
//            Employee employee2 = new Employee("Ivan", "Ivanov", 1000);
//            Employee employee3 = new Employee("Alex", "Dunduk", 5555);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);

            session.beginTransaction();
//            session.save(department);

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(department);

//            System.out.println("Show employees of the department");
//            System.out.println(department.getEmps());

//            Employee employee = session.get(Employee.class, 3);
//            System.out.println(employee.getDepartment());
//            session.delete(employee);

            session.getTransaction().commit();

//            System.out.println("Show employees of the department");
//            System.out.println(department.getEmps());

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }


    }

}
