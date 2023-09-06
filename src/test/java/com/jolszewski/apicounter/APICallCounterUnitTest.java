package com.jolszewski.apicounter;

import com.jolszewski.TestConst;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APICallCounterUnitTest {

    @Test
    void shouldInitAPICallCount() {
        APICallCounter apiCallCounter = new APICallCounter(TestConst.EXISTING_USER_LOGIN);
        assertEquals(1, apiCallCounter.getRequestCount());
    }

    @Test
    void shouldIncrementAPICallCount() {
        APICallCounter apiCallCounter = new APICallCounter(TestConst.EXISTING_USER_LOGIN);
        apiCallCounter.incrementRequestCount();
        assertEquals(2, apiCallCounter.getRequestCount());
    }
}
