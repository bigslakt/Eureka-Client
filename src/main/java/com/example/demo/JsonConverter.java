package com.example.demo;

import com.google.gson.Gson;

import java.util.ArrayList;

public class JsonConverter {

    private Gson gson = new Gson();
    private Object o;
    private ArrayList<Person> persons;

    public JsonConverter(ArrayList<Person> persons) {
        this.persons = persons;
    }


    public String personToJsonString(){

        if(o != null)
            return gson.toJson(o);

        else
            return gson.toJson(persons);
    }
}
