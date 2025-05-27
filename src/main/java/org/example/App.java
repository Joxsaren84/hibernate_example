package org.example;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            /*
            Person person1 = new Person("Alex", 25);
            Person person2 = new Person("Eva", 23);
            Person person3 = new Person("Bob", 32);

            session.save(person1);
            session.save(person2);
            session.save(person3);
            */

            /*
            Person getPerson = session.get(Person.class, 1);
            getPerson.setName("Alexander");
            System.out.println(getPerson.getName() + " " + getPerson.getAge());
            */

            /*
            Person getPerson = session.get(Person.class, 2);
            session.delete(getPerson);
            */

            Person person = new Person("Nusha", 18);
            session.save(person);
            session.getTransaction().commit();
            System.out.println(person.getId());

        } finally {
            sessionFactory.close();
        }
    }
}
