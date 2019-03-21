package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Database implements DataStorage{

    private ArrayList<Person> persons;

    public Database() {

        persons = new ArrayList<>();
    }


    @Override
    public void addStorageObject(DatabaseObject databaseObject) {
        persons.add((Person) databaseObject);
    }

    @Override
    public ArrayList getStorageObjects() {
        return persons;
    }
}
