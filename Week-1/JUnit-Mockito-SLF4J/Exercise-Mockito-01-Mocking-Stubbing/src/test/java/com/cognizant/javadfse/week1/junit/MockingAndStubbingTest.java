package com.cognizant.javadfse.week1.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MockingAndStubbingTest {
    @Mock private ExternalApi externalApi;
    @InjectMocks private MyService myService;

    @Test
    void shouldReturnStubbedDataFromMock() {
        when(externalApi.getData()).thenReturn("Mocked Cognizant Data");
        assertEquals("Mocked Cognizant Data", myService.process());
    }
}
