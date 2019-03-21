package com.example.demo;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RequestController {

    private RestTemplate restTemplate;
    private Database database;
    private PersonController personController;

    public RequestController(RestTemplate restTemplate){

        this.restTemplate = restTemplate;
        database = new Database();
        personController = new PersonController(database);

    }

    @GetMapping("/persons")
    public ArrayList persons()
    {
        return personController.listPersons();
    }

    /*@GetMapping("/persons")
    public byte[] persons()
    {
       return personController.listPersons();
    }*/

    @PostMapping("/persons")
    public void addPerson(@RequestBody Person person) {

        personController.addPerson(person);
    }

    @GetMapping("/randomhello")
    public String randomHello() {

        return restTemplate.getForObject("http://greeting-app/hello", String.class);
    }

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/clients")
    public List<InstanceInfo> clients()
    {
        Application application = eurekaClient.getApplication("greeting-app");
        return application.getInstances();
    }
}
