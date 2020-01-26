package org.fasttrackit.nationsmatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.nationsmatch.domain.Test;
import org.fasttrackit.nationsmatch.exeption.ResourceNotFoundException;
import org.fasttrackit.nationsmatch.persistance.TestRepository;
import org.fasttrackit.nationsmatch.transfer.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);
    private final TestRepository testRepository;
    private final ObjectMapper objectMapper;

    List<Test> tests = new ArrayList<>();

    @Autowired
    public TestService(TestRepository testRepository, ObjectMapper objectMapper) {
        this.testRepository = testRepository;
        this.objectMapper = objectMapper;
    }

    public Test createTest(TestRequest request) {
        Test test = objectMapper.convertValue(request, Test.class);
        return testRepository.save(test);
    }

    public Test getTest(long id) {
     return testRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doesn't exist"));
    }

    public Page<Test> getTests(Pageable pageable) {
        return testRepository.findAll(pageable);
    }
}
