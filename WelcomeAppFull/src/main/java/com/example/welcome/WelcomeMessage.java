package com.example.welcome;

import java.time.LocalDateTime;

public class WelcomeMessage {
    private String message;
    private LocalDateTime time;

    public WelcomeMessage(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }
}