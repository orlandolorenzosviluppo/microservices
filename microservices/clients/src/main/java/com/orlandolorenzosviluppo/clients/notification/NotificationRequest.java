package com.orlandolorenzosviluppo.clients.notification;

import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

public record NotificationRequest (
        Integer toCustomerId,
        String toCustomerEmail,
        String sender,
        String message,
        LocalDateTime sentAt
) {}
