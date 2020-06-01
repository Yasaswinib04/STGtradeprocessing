package com.citi.stg.Microservice1.TestService;

import com.citi.stg.Microservice1.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
    @Autowired
    private Converter converter;

    @RequestMapping(method=RequestMethod.POST, value = "/test")
    public String test(@RequestBody String s){
        return converter.convertXmlfiletoString(s);
    }
}
