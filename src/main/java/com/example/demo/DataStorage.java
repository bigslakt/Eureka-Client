package com.example.demo;

import java.util.ArrayList;

public interface DataStorage {

    void addStorageObject(DatabaseObject databaseObject);

    ArrayList getStorageObjects();
}
