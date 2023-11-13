package com.dmadev.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //хибер не трогает колонку, геренарция на стороне psql
    private Integer id;
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "lang")
    private String lang;

    @Column(name = "married")
    private boolean married;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    //при сохранении человека будут автоматически сохранятся связанные с ним товары
    //чтобы это каскадирование работало , надо юзать метод персист
//    @OneToMany(mappedBy = "owner",cascade = CascadeType.PERSIST)


    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    //refresh будут автоматически обновлять связанные сущности
    //save update самая полезная, еще норм ALL, но надо быть осторожным
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.REFRESH})
    private List<Item> items;

    @OneToMany(mappedBy = "owner")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Car> cars;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "petOwner")
    private List<Animal> animals;

    public Person() {
    }

    public Person(String name, int age, String lang, boolean married, Gender gender) {
        this.name = name;
        this.age = age;
        this.lang = lang;
        this.married = married;
        this.gender = gender;
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        item.setOwner(this);
        //назначим в качестве ownera текущий обьект this, тот обьект на котором вызывается метод setOwner
    }

    public void addCar(Car car) {
        if (this.cars == null) {
            this.cars = new ArrayList<>();
        }
        this.cars.add(car);
        car.setOwner(this);
    }

    public void addAnimal(Animal animal) {
        if (this.animals == null) {
            this.animals = new ArrayList<>();
        }
        this.animals.add(animal);
        animal.setPetOwner(this);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Item> getItems() {
        return items;
    }


    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", lang='" + lang + '\'' +
                ", married=" + married +
                ", gender=" + gender +
                '}';
    }
}
