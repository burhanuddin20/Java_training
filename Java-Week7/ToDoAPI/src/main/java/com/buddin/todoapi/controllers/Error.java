
package com.buddin.todoapi.controllers;

import java.time.LocalDateTime;

/**
 *
 * @author burhan
 * @date 8 Sep 2021
 * @email burhan.u6@hotmail.co.uk
 * purpose:
 */
public class Error {
    
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
