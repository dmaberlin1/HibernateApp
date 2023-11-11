package com.dmadev.model;

import jakarta.persistence.*;

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

    @Column(name="lang")
    private String lang;

    @Column(name = "married")
    private boolean married;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    public Person() {
    }

    public Person(String name, int age, String lang, boolean married, Gender gender) {
        this.name = name;
        this.age = age;
        this.lang = lang;
        this.married = married;
        this.gender = gender;
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
