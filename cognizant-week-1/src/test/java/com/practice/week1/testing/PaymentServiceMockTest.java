package com.practice.week1.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * MOCKITO — Java's equivalent of Moq.
 * We mock the PaymentGateway dependency so the test doesn't call a real payment API.
 */
@ExtendWith(MockitoExtension.class)
class PaymentServiceMockTest {

    @Mock
    private PaymentService.PaymentGateway gateway;

    @Test
    void processPayment_returnsSuccess_whenGatewayChargesSuccessfully() {
        when(gateway.charge("4111111111111111", 500.0)).thenReturn(true);

        PaymentService service = new PaymentService(gateway);
        String result = service.processPayment("4111111111111111", 500.0);

        assertEquals("SUCCESS", result);
        verify(gateway, times(1)).charge("4111111111111111", 500.0);
    }

    @Test
    void processPayment_returnsFailed_whenGatewayDeclines() {
        when(gateway.charge(anyString(), anyDouble())).thenReturn(false);

        PaymentService service = new PaymentService(gateway);
        String result = service.processPayment("4111111111111111", 500.0);

        assertEquals("FAILED", result);
    }

    @Test
    void processPayment_throwsException_forNonPositiveAmount() {
        PaymentService service = new PaymentService(gateway);
        assertThrows(IllegalArgumentException.class, () -> service.processPayment("card", -10));
        verifyNoInteractions(gateway);
    }
}
