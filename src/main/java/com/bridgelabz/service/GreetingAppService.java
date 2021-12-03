package com.bridgelabz.service;

import com.bridgelabz.dto.GreetingAppDto;
import com.bridgelabz.entity.GreetingAppEntity;
import com.bridgelabz.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    private static final String GREETING_MESSAGES_NOT_FOUND = "Greeting Message is not found by the id";
    private static final String GREETING_MESSAGE_EDITED = "Greeting Message is edited";
    private static final String GREETING_MESSAGE_DELETED = "Greeting Message is successfully deleted";
    private static final String GREETING_MESSAGES_FOUND = "Greeting Message is found by the id";
    @Autowired
    private GreetingAppRepository greetingAppRepository;

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
    public GreetingAppEntity saveMessages(GreetingAppDto greetingAppDto) {
        GreetingAppEntity greetingAppEntity = new GreetingAppEntity();
        greetingAppEntity.setMessage(greetingAppDto.getMessage());
        return greetingAppRepository.save(greetingAppEntity);
    }

    /**
     * Purpose : To find the greeting message by id
     *
     * @param id : provided greeting message by unique id
     * @return greeting message is found by id or not
     */
    public String findMessagesById(int id) {
        Optional<GreetingAppEntity> greetingMessageById = greetingAppRepository.findById(id);
        if (greetingMessageById.isPresent()) {
            return GREETING_MESSAGES_FOUND + " : " + id;
        }
        return GREETING_MESSAGES_NOT_FOUND + " : " + id;
    }

    /**
     * Purpose : To list all the greeting messages in the greeting repository
     *
     * @return the list of all messages
     */
    public List<GreetingAppEntity> getMessagesByList() {
        return greetingAppRepository.findAll();
    }

    /**
     * Purpose : To edit the greeting messages in the greeting app repository
     *
     * @param id             : unique id of the greeting message
     * @param greetingAppDto : greeting app data from the client
     * @return updated greeting message
     */
    public String editGreetingMessages(int id, GreetingAppDto greetingAppDto) {
        Optional<GreetingAppEntity> greetingMessageById = greetingAppRepository.findById(id);
        if (greetingMessageById.isPresent()) {
            GreetingAppEntity greetingAppEntity = greetingMessageById.get();
            greetingAppEntity.setMessage(greetingAppDto.getMessage());
            greetingAppRepository.save(greetingAppEntity);
            return GREETING_MESSAGE_EDITED;
        }
        return GREETING_MESSAGES_NOT_FOUND;
    }

    /**
     * Purpose : To delete the greeting messages in the greeting app repository by providing the unique id
     *
     * @param id : unique id of the greeting message
     * @return status of the deleted message
     */
    public String deleteGreetingMessages(int id) {
        Optional<GreetingAppEntity> greetingMessage = greetingAppRepository.findById(id);
        if (greetingMessage.isPresent()) {
            greetingAppRepository.delete(greetingMessage.get());
            return GREETING_MESSAGE_DELETED;
        }
        return GREETING_MESSAGES_NOT_FOUND;
    }
}
