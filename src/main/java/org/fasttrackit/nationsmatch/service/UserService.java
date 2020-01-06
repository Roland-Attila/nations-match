package org.fasttrackit.nationsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.nationsmatch.domain.User;
import org.fasttrackit.nationsmatch.exeption.ResourceNotFoundException;
import org.fasttrackit.nationsmatch.persistance.UserRepository;
import org.fasttrackit.nationsmatch.transfer.SaveUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserService(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    public User createUser(SaveUserRequest request) {
        LOGGER.info("Creating user: {}", request);
        User user = objectMapper.convertValue(request, User.class);

        return userRepository.save(user);
    }

    public User getUser(long id) {
        LOGGER.info("Retrieving user {}", id);

        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("User " + id + " does not exist."));
    }

//    @Transactional
//    public Page<UserResponse> getUsers(UserResponse request, Pageable pageable) {
//        LOGGER.info("Retrieving Users {}", request);
//        Page<User> users;
//        if (request != null && request.getFirstName() != null && request.getLastName() != null
//                && request.getAge() != null && request.getNationality() != null) {
//            users = userRepository.findAll(pageable);
//        }
//
//        List<UserResponse> userResponses = new ArrayList<>();
//        for (User user : users.getContent()) {
//            UserResponse userResponse = new UserResponse();
//            userResponse.setId(request.getId());
//            userResponse.setFirstName(request.getFirstName());
//            userResponse.setLastName(request.getLastName());
//            userResponse.setAge(request.getAge());
//            userResponse.setDescription(request.getDescription());
//            userResponse.setNationality(request.getNationality());
//            userResponse.setImageUrl(request.getImageUrl());
//
//            userResponses.add(userResponse);
//        }
//        return new PageImpl<>(userResponses, pageable, users.getTotalElements());
//    }

    public User updateUser(long id, SaveUserRequest request) {
        LOGGER.info("Updating user {}: {}", id, request);
        User user = getUser(id);
        BeanUtils.copyProperties(request, user);
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
        LOGGER.info("Deleting user {}", id);
        userRepository.deleteById(id);
        LOGGER.info("Deleted user {}", id);
    }
}
