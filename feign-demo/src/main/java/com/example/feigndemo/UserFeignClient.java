package com.example.feigndemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user-feign-client", url = "http://localhost:8080")
public interface UserFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<User> getUsers(@RequestParam("offset") int offset,
                        @RequestParam("page_size") int pagesize,
                        @RequestParam("sort_by") String field);

//    @RequestMapping(method = RequestMethod.GET, value = "/users")
//    List<User> getUsers(@RequestParam("offset") int offset,
//                        @RequestParam("page_size") int pagesize,
//                        @RequestParam("sort_by") String field,
//                        @RequestHeader("key-list") Object keylist);
}

