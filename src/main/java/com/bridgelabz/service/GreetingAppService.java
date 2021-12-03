package com.bridgelabz.service;

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

    /**
     * Purpose : To invoke a simple message
     *
     * @return a simple welcome message
     */
    public String getMessage() {
        return "Hello World";
    }
}
