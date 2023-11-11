package com.dmadev;

import com.dmadev.model.Animal;
import com.dmadev.model.Gender;
import com.dmadev.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class App 
{
    public static void main( String[] args ) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Animal.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
//            addUsers(session)
//            setUserParams(session);
            session.beginTransaction();
            //hql не знает про таблицы в бд он, работает с сущностями , после получения, положим в резалт лист
            List<Person> fromPerson = session.createQuery("FROM Person where married =false").getResultList();
            List<Person> fromPerson1 = session.createQuery("FROM Person where name like 'T%'").getResultList();
            Query sessionQuery = session.createQuery("update Person set name='Happy married' where married=true");
            List<Person> fromPersonMarried = session.createQuery("FROM Person where married=true").getResultList();
            List<Animal> fromAnimal = session.createQuery("from Animal where wild=true").getResultList();

            System.out.println("***result from App:");
            for (Person person : fromPerson) {
                System.out.println("person = " + person);
            }
            System.out.println("name like T%");
            for (Person person : fromPerson1) {
                System.out.println("person = " + person);
            }
            for (Animal animal : fromAnimal) {
                System.out.println("animal = " + animal);
            }

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }

    private static void setUserParams(Session session) {
        session.beginTransaction();
        Person person1 = session.get(Person.class, 1);
        Animal animal1 = session.get(Animal.class, 1);

        person1.setLang("esp");
        animal1.setWild(true);

        session.getTransaction().commit();
    }

    private static void addUsers(Session session) {
        session.beginTransaction();
//            Person person = session.get(Person.class, 1);
//            Animal animal = session.get(Animal.class, 1);
//            System.out.println("animal+ " + animal);
//            System.out.println("animal.getName()+animal.getGender() = " + animal.getName() + animal.getGender());
//            System.out.println("person = " + person);
//            System.out.println("person.getName()+person.getGender() = " + person.getName() + person.getGender());

        Person personName0 = new Person("Name0", 30, "en", false, Gender.male);
        Person personName1 = new Person("Name1", 35, "fr", true, Gender.male);

        Animal animalBeta = new Animal("Beta", "Name0", 2, false, Gender.female, false);
        Animal animalZeta = new Animal("Zeta", "Name0", 2, false, Gender.female, false);

        session.save(personName0);
        session.save(personName1);
        session.save(animalBeta);
        session.save(animalZeta);

        session.getTransaction().commit();
    }
}
