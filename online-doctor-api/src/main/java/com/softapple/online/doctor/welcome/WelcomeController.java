package com.softapple.online.doctor.welcome;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	 
    private final String WELCOME_MESSAGE = "Welcome to  Online-Doctor.";
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String welcome() {
        
        return this.WELCOME_MESSAGE;
        
    }
}
