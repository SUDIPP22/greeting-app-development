package com.bridgelabz.controller;

import com.bridgelabz.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Purpose : To demonstrate different HTTP methods
 *
 * @author SUDIP PANJA
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
@RestController
public class GreetingAppController {

    @Autowired
    private GreetingAppService greetingAppService;

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome To This Server!!!";
    }

    @GetMapping("/greeting2/{name}")
    public String greetingUsingGetMethod(
            @PathVariable String name
    ) {
        return "Welcome " + name + " to this Server!!!";
    }

    @PutMapping("/greeting3")
    public String greetingUsingPutMethod(
            @RequestParam String name
    ) {
        return "Welcome " + name + " to this Server!!!";
    }

    @GetMapping("/greeting4")
    public String getMessage() {
        return greetingAppService.getMessage();
    }
}
