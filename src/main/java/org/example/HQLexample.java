package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HQLexample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("update Person set name = 'Hrusha' where name like 'N%'").executeUpdate();
            session.createQuery("delete Person where age <= 18").executeUpdate();

            //List<Person> list = session.createQuery("FROM Person WHERE name LIKE 'A%'").getResultList();
            List<Person> list = session.createQuery("FROM Person").getResultList();

            for(Person person : list){
                System.out.println(person);
            }

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
