package hiber_many_to_many;

import hiber_many_to_many.entity.Child;
import hiber_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//          session = sessionFactory.getCurrentSession();
//
//          Section section1 = new Section("Music");
//          Child child1 = new Child("Olya", 11);
//          Child child2 = new Child("Rita", 12);
//          Child child3 = new Child("Kirill", 13);
//
//          section1.addChildToSection(child1);
//          section1.addChildToSection(child2);
//          section1.addChildToSection(child3);
//
//          session.beginTransaction();
//
//          session.persist(section1);
//
//
//          session.getTransaction().commit();
//
//            System.out.println("Done!!!");
          //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//            session = sessionFactory.getCurrentSession();
//
//            Section section1 = new Section("Football");
//            Section section2 = new Section("Dance");
//            Section section3 = new Section("Hokey");
//
//            Child child1 = new Child("Alex", 7);
//
//
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!!!");
            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!!!");

            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 5);
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!!!");

            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Section section = session.get(Section.class, 1);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!!!");

            //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

//            Section section = session.get(Section.class, 4);
            Child child = session.get(Child.class, 5);
            session.delete(child);

            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
