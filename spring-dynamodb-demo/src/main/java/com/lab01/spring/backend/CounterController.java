package com.lab01.spring.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/counter")
public class CounterController {


    private final DynamoDBService dynamoDBService;

    public CounterController(DynamoDBService counterService) {
        this.dynamoDBService = counterService;
    }

    @GetMapping
    public int increment() {
        return dynamoDBService.incrementAndReturnCounter();
    }

}
