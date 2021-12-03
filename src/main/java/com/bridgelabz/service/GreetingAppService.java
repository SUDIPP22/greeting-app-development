package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingAppDto;
import com.bridgelabz.entity.GreetingAppEntity;
import com.bridgelabz.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Purpose : To demonstrate business logic
 * which implements all the methods in controller layer
 *
 * @author SUDIP PANJA
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
@Service
public class GreetingAppService {

    @Autowired
    GreetingAppRepository greetingAppRepository;

    /**
     * Purpose : To invoke a simple message
     *
     * @return a simple welcome message
     */
    public String getMessage() {
        return "Hello World";
    }

    /**
     * Purpose : To save the greeting message to the database
     *
     * @param greetingAppDto : greeting data from client
     * @return greeting message to the repository
     */
    public GreetingAppEntity saveMessage(GreetingAppDto greetingAppDto) {
        GreetingAppEntity greetingAppEntity = new GreetingAppEntity();
        greetingAppEntity.setMessage(greetingAppDto.getMessage());
        return greetingAppRepository.save(greetingAppEntity);
    }
}
