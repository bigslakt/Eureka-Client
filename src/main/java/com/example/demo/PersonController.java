package com.example.demo;

import java.util.ArrayList;

public class PersonController {

    private DataStorage database;

    public PersonController(DataStorage database)
    {
        this.database = database;
        createPerson("robin", "hansson", 26);
        createPerson("larsa", "seddu", 58);
    }


    public void createPerson(String firstName, String lastName, int age)
    {
        Person person = new Person(firstName, lastName, age);
        database.addStorageObject(person);
    }

    public void addPerson(Person person)
    {
        database.addStorageObject(person);
    }


    public ArrayList listPersons()
    {
        ArrayList<Person> persons = (ArrayList<Person>) database.getStorageObjects();

        return persons;
    }


}
