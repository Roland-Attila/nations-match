package org.fasttrackit.nationsmatch.service;

import org.fasttrackit.nationsmatch.domain.User;
import org.fasttrackit.nationsmatch.persistance.UserRepository;
import org.fasttrackit.nationsmatch.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(SaveUserRequest request) {
        LOGGER.info("Creating user: {}", request);
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());
        user.setDescription(request.getDescription());
        user.setNationality(request.getNationality());
        user.setImageUrl(request.getImageUrl());

        return userRepository.save(user);
    }
}
