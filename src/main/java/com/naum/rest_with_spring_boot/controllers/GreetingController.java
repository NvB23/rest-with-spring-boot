package com.naum.rest_with_spring_boot.controllers;

import com.naum.rest_with_spring_boot.models.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final AtomicLong id = new AtomicLong();

    @RequestMapping(name = "/greeting")
    private Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name
    ){
        String template = "Hello, %s!";
        return new Greeting(id, String.format(template, name));
    }
}
