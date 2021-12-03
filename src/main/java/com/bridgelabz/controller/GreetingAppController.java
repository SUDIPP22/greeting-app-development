package com.bridgelabz.controller;

import com.bridgelabz.dto.GreetingAppDto;
import com.bridgelabz.entity.GreetingAppEntity;
import com.bridgelabz.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/greeting5/{name}")
    public String getMessageUsingPathVariable(
            @PathVariable String name
    ) {
        return name + " , " + greetingAppService.getMessage();
    }

    @GetMapping("/greeting6")
    public String getMessageUsingQueryParameter(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return greetingAppService.getMessage() + " , " + firstName + " " + lastName;
    }

    @PostMapping("/greeting-message")
    public GreetingAppEntity saveGreetingMessage(
            @RequestBody GreetingAppDto greetingAppDto
    ) {
        return greetingAppService.saveMessage(greetingAppDto);
    }

    @GetMapping("/greetingMessage/{id}")
    public String findGreetingMessageById(
            @PathVariable int id
    ) {
        return greetingAppService.findMessageById(id);
    }

    @GetMapping("/greetingListMessage")
    public List<GreetingAppEntity> greetingMessagesByList() {
        return greetingAppService.messagesByList();
    }
}
