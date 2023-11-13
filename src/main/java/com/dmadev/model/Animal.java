package com.dmadev.model;

import com.dmadev.model.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "Animal")
public class Animal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //хибер не трогает колонку, геренарция на стороне psql
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person petOwner;

    @Column(name="age")
    private int age;

    @Column(name="aquatic")
    private boolean aquatic;

    @Enumerated(EnumType.STRING)
    @Column(name="gender")
    private Gender gender;

    @Column(name="wild")
    private boolean wild;

    public Person getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(Person petOwner) {
        this.petOwner = petOwner;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petOwner='" + petOwner + '\'' +
                ", age=" + age +
                ", aquatic=" + aquatic +
                ", gender=" + gender +
                ", wild=" + wild +
                '}';
    }


    public Animal(String name, int age, boolean aquatic, Gender gender, boolean wild) {
        this.name = name;
        this.age = age;
        this.aquatic = aquatic;
        this.gender = gender;
        this.wild = wild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Animal() {

    }





    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public void setAquatic(boolean aquatic) {
        this.aquatic = aquatic;
    }



    public boolean isWild() {
        return wild;
    }

    public void setWild(boolean wild) {
        this.wild = wild;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}


