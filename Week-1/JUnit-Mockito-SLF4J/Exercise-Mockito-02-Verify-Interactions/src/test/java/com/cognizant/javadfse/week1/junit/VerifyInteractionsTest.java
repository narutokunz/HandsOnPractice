package com.cognizant.javadfse.week1.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VerifyInteractionsTest {
    @Mock private ExternalApi externalApi;
    @InjectMocks private MyService myService;

    @Test
    void shouldVerifyExternalApiInteraction() {
        when(externalApi.getData()).thenReturn("Verified");
        myService.process();
        verify(externalApi).getData();
    }
}
