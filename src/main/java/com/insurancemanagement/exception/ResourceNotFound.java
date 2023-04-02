/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.insurancemanagement.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author saksh
 */
@ResponseStatus
public class ResourceNotFound extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFound(String message) {
        super(message);
    }
    
    public ResourceNotFound(String message, Throwable throwable) {
        super(message, throwable);
        
    }

}
