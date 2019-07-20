package com.example.consumer01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerHello {

    @Autowired
    RestTemplate template;

    @Autowired
    DiscoveryClient discoveryClient;


    @Autowired
    Registration registration;

    @GetMapping("/index")
    public String index() {

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }

        String host = registration.getHost();
        System.out.println("host = " + host);

        String body = template.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
        System.out.println(body);

        return "这是消费的:";
    }

}
