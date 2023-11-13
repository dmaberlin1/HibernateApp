package com.dmadev;

import com.dmadev.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

end in 8 video


public class App 
{
    public static void main( String[] args ) {
        Configuration configuration=new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Animal.class)
                .addAnnotatedClass(Car.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
//            addUsers(session)
//            setUserParams(session);
//            createQueryChangeParams(session);
//            getFromPerson(session);
//            CRUDWithHibernate(session);
            session.beginTransaction();

            Person personTestCascading = new Person("Test cascading", 25, "esp", true, Gender.male);
            personTestCascading.addCar(new Car("BMW",2,"black",false,true,TypeBodyCar.wagon));
            personTestCascading.addAnimal(new Animal("Wolf",3,false,Gender.female,true));
            personTestCascading.addItem(new Item("Iphone"));
            session.save(personTestCascading);

            //cascade

//            Person personCascade1 = new Person("Cascade person 1", 20, "ru", false, Gender.male);
////            Item testCascadingItem = new Item("Test cascading item", personCascade1);
////            personCascade1.setItems(new ArrayList<>(Collections.singletonList(testCascadingItem)));


//            new Person("Cascade person 2",22,"esp",true,Gender.male);
//            для метода каскадирования персист
//            session.persist(personCascade1);


//            session.save(personCascade1);
            session.getTransaction().commit();


        }
        finally {
            sessionFactory.close();
        }
    }

//    private static void CRUDWithHibernate(Session session) {
//        session.beginTransaction();
//        Item itemId1 = session.get(Item.class, 1);
//        Car carId2 = session.get(Car.class, 2);
//        Animal animalId3 = session.get(Animal.class, 3);
//        Person personId1 = session.get(Person.class, 1);
//        Person personId2 = session.get(Person.class, 2);
//        Person personId3 = session.get(Person.class, 3);
//
//        Person itemId1Owner = itemId1.getOwner();
//        Person carId2Owner = carId2.getOwner();
//        Person animalId3PetOwner = animalId3.getPetOwner();
//
//        Item itemFromHibernate = new Item("Item from hibernate", personId1);
//        Item secondItemFromHibernate = new Item("Second item from hibernate", personId2);
//        Animal dogFromHibernate = new Animal("Dog from hibernate", personId1, 3, false, Gender.female, false);
//        Car carBentley = new Car(personId1, "Bentley", 4, "white", false,false ,TypeBodyCar.coupe);
//        Car carSkoda = new Car(personId2, "Skoda", 2, "black", true,false, TypeBodyCar.CoupeSUV);
//
//
//        //            создать нового человека с новым заказом, животным, машиной
//        Person personFromHibernate = new Person("Person from hibernate", 25, "en", true, Gender.male);
//        Animal tigerFromHibernate = new Animal("Tiger from hibernate", personFromHibernate, 4, false, Gender.male, true);
//        Car bmwFromHibernate = new Car(personFromHibernate, "Bmw from hibernate", 2, "Green", false, true, TypeBodyCar.sedan);
//        personFromHibernate.setAnimals(new ArrayList<Animal>(Collections.singletonList(tigerFromHibernate)));
////            помещаем список из одного элема, но чтобы он стал изменяемым, помещаем его в конструктор  ArrayList, создается динам. список с 1 элемом
//        personFromHibernate.setCars(new ArrayList<Car>(Collections.singletonList(bmwFromHibernate)));
//
//        session.save(personFromHibernate);
//        session.save(tigerFromHibernate);
//        session.save(bmwFromHibernate);
//
//
//        //удалим товары у персоны с id 2
//        List<Item> personId2Items = personId2.getItems();
//
////            порождает sql
//        for (Item personId2Item : personId2Items) {
//            session.remove(personId2Item);
//        }
//        // теперь так же очистим список в сущности, чтобы не было проблемы с кешем, в разнице бд и хибера
//        // не порождает sql, но необходимо чтобы в кеше всё было верно
//        personId2.getItems().clear();
//
//
//            /*хибер создал новый товар, животное, машину с новым ключом person_id
//            //указали связь только на стороне item , animal,car
//            // если нас интересует только бд , то код со второй стороны писать не надо , хибер заботит только то что делаем на овнинг сайд
//            //если мы не добавим код на стороне человека, возможно что на стороне бд всё будет правильно , но если получать из хибернейта-
//            // то будет выдаваться старая версия человека , и хибер будет выдавать человека  со страрым списком товаром
//            //поэтому чтобы кеши товара друг друга соответствовали, хорошей практикой считается задавать отношения с двух сторон
//            hibernate кеширует обьекты в своей памяти, каждый раз когда мы получаем обьекты какого то человека -
//            хибер НЕ каждый раз делает запросы, он эти обьекты кеширует в своей памяти, чтобы оптимизировать затраты по времени ,
//            и если не установим двойную связь и на человеке ,  то возможно в таблицах всё будет ок, а в хибере старая версия
//            */
//
//        personId1.getItems().add(itemFromHibernate);
//        personId1.getAnimals().add(dogFromHibernate);
//        personId1.getCars().add(carBentley);
//        personId2.getItems().add(secondItemFromHibernate);
//        personId2.getCars().add(carSkoda);
//        //после операций с person мы будем уверены что в кеше хибернейта всё будет так же как и в бд
////            session.remove(personId3);
//        //с помощью лямбды прошлись по всем item,animal ,cars
////            )
//
//
//        session.save(itemFromHibernate);
//        session.save(secondItemFromHibernate);
//        session.save(dogFromHibernate);
//        session.save(carBentley);
//
//
//        //сменим владельца у товара Table, с айди 1
//        Person personId6 = session.get(Person.class, 6);
//        Item itemId5 = session.get(Item.class, 5);
//
//        Item itemId16 = session.get(Item.class, 16);
//
////            для кеша hibernate
//        itemId16.getOwner().getItems().remove(itemId16);
//        //sql
//        itemId16.setOwner(personId6);
//        itemId5.setOwner(personId6);
//        itemId5.setItemName("Table setted from hibernate");
//        personId6.getItems().add(itemId5);
//
////            System.out.println("itemId1Owner = " + itemId1Owner);
////            System.out.println("carId2Owner = " + carId2Owner);
////            System.out.println("animalId3PetOwner = " + animalId3PetOwner);
//        session.getTransaction().commit();
//    }

//    private static void getFromPerson(Session session) {
//        session.beginTransaction();
//
//        Person person1 = session.get(Person.class, 1);
//        Person person2 = session.get(Person.class, 2);
//
//        System.out.println("person1 = " + person1);
//        System.out.println("person2 = " + person2);
//
//        List<Car> person1Cars = person1.getCars();
//        List<Animal> person1Animals = person1.getAnimals();
//        List<Item> person1Items = person1.getItems();
//        System.out.println("person1Cars = " + person1Cars);
//        System.out.println("person1Animals = " + person1Animals);
//        System.out.println("person1Items = " + person1Items);
//
//        session.getTransaction().commit();
//    }

//    private static void createQueryUpdate(Session session) {
//        session.beginTransaction();
//        //hql не знает про таблицы в бд он, работает с сущностями , после получения, положим в резалт лист
//        List<Person> fromPerson = session.createQuery("FROM Person where married =false").getResultList();
//        List<Person> fromPerson1 = session.createQuery("FROM Person where name like 'T%'").getResultList();
//        Query sessionQuery = session.createQuery("update Person set name='Happy married' where married=true");
//        List<Person> fromPersonMarried = session.createQuery("FROM Person where married=true").getResultList();
//        List<Animal> fromAnimal = session.createQuery("from Animal where wild=true").getResultList();
//
//        System.out.println("***result from App:");
//        for (Person person : fromPerson) {
//            System.out.println("person = " + person);
//        }
//        System.out.println("name like T%");
//        for (Person person : fromPerson1) {
//            System.out.println("person = " + person);
//        }
//        for (Animal animal : fromAnimal) {
//            System.out.println("animal = " + animal);
//        }
//
//        session.getTransaction().commit();
//    }

//    private static void setUserParams(Session session) {
//        session.beginTransaction();
//        Person person1 = session.get(Person.class, 1);
//        Animal animal1 = session.get(Animal.class, 1);
//
//        person1.setLang("esp");
//        animal1.setWild(true);
//
//        session.getTransaction().commit();
//    }

//    private static void addUsers(Session session) {
//        session.beginTransaction();
////            Person person = session.get(Person.class, 1);
////            Animal animal = session.get(Animal.class, 1);
////            System.out.println("animal+ " + animal);
////            System.out.println("animal.getName()+animal.getGender() = " + animal.getName() + animal.getGender());
////            System.out.println("person = " + person);
////            System.out.println("person.getName()+person.getGender() = " + person.getName() + person.getGender());
//
//        Person personName0 = new Person("Name0", 30, "en", false, Gender.male);
//        Person personName1 = new Person("Name1", 35, "fr", true, Gender.male);
//
//        Animal animalBeta = new Animal("Beta", "Name0", 2, false, Gender.female, false);
//        Animal animalZeta = new Animal("Zeta", "Name0", 2, false, Gender.female, false);
//
//        session.save(personName0);
//        session.save(personName1);
//        session.save(animalBeta);
//        session.save(animalZeta);
//
//        session.getTransaction().commit();
//    }
}
