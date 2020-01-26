package org.fasttrackit.nationsmatch.web;

import org.fasttrackit.nationsmatch.domain.Test;
import org.fasttrackit.nationsmatch.service.TestService;
import org.fasttrackit.nationsmatch.transfer.TestRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody @Valid TestRequest request) {
        Test test = testService.createTest(request);
        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Test>> getTests(Pageable pageable) {
        Page<Test> tests = testService.getTests(pageable);
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }
}
