package com.jolszewski.apicounter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class APICallCounterServiceIntegrationTest {

    @Autowired
    APICallCounterRepository apiCallCounterRepository;

    @Autowired
    APICallCounterService apiCallCounterService;

    @Test
    void shouldCreateNewLoginRequestWhenItDoesNotExist() {
        apiCallCounterService.callOccurred("test");
        Optional<APICallCounter> testLogin = apiCallCounterRepository.findById("test");
        assertTrue(testLogin.isPresent());
        assertEquals(1, testLogin.get().getRequestCount());
    }

    @Test
    void shouldIncrementRequestCount() {
        apiCallCounterService.callOccurred("increment-test");
        apiCallCounterService.callOccurred("increment-test");
        Optional<APICallCounter> testLogin = apiCallCounterRepository.findById("increment-test");
        assertTrue(testLogin.isPresent());
        assertEquals(2, testLogin.get().getRequestCount());
    }
}
