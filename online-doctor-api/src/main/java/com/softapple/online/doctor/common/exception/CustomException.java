/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softapple.online.doctor.common.exception;

import org.springframework.web.bind.ServletRequestBindingException;

/**
 *
 * @author riad
 */
public class CustomException extends ServletRequestBindingException{

    public CustomException(String msg) {
        super(msg);
    }
    
   
    
    
    
}
