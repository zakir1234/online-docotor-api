/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softapple.online.doctor.common.exception;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.softapple.online.doctor.common.response.ErrorResponse;

/**
 *
 * @author Md. Zakir Hossain
 */
@ControllerAdvice
public class GlobalExceptionHandler { 
    
    final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), e.getClass().getName(), "Failed for Bad Request, Missing Data",  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), e.getClass().getName(), "Failed for Invalid Data or Unauthorized",  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name(), e.getClass().getName(), "Failed For Data Integrity Violation",  req.getRequestURL().toString());
        logger.info("Error Status "+HttpStatus.CONFLICT.value()+" Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        
    }
    
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getClass().getName(), e.getMessage(),  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), e.getClass().getName(), e.getMessage(),  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleHttpAccessDeniedException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.name(), e.getClass().getName(), e.getMessage(),  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getClass().getName(), e.getMessage(),  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(HttpServletRequest req, Exception e) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE.name(), e.getClass().getName(), "Failed",  req.getRequestURL().toString());
        logger.info("Error URL: "+req.getRequestURL().toString()+"...Error Class: "+e.getClass().getName()+"...Message: "+e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }
}
