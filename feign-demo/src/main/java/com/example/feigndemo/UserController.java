package com.example.feigndemo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFeignClient userFeignClient;

    @GetMapping("/users-using-feign")
    public List<User> getUsersUsingFeign(){
        List<User> users = userFeignClient.getUsers(1, 1, "email");
        if(!CollectionUtils.isEmpty(users) && users.size() == 1 ){
            return users;
        }
        throw new RuntimeException("No Users received from Users API");
    }

}
