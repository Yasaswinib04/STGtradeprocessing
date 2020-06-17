package com.example.RuleEngineTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.helger.schematron.ISchematronResource;
import com.helger.schematron.pure.SchematronResourcePure;

import java.io.File;
import java.util.Iterator;

import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import java.nio.file.*;
import java.time.Instant;


@Component
public class controller implements ApplicationRunner {
	
	
	@Value("${path.TradeFolder}") 
    private  String xmlpath;
	
	@Value("${path.SchemaFolder}")
	private String schemapath;

	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	 ISchematronResource aResPure = SchematronResourcePure.fromFile (new File(schemapath));
	 if (!aResPure.isValidSchematron ()) 
		    throw new IllegalArgumentException ("Invalid Schematron!"); 
	 
		
		File f;
		Iterator<File> iterator = FileUtils.iterateFiles(new File(xmlpath), null, false);
		
		Long start=Instant.now().toEpochMilli();
        while (iterator.hasNext()) {
            f = iterator.next();      
            boolean res=aResPure.getSchematronValidity(new StreamSource(f)).isValid (); 
            System.out.println(res);
        }
        
       Long end=Instant.now().toEpochMilli();
       
       System.out.println("Average time to validate one xml file is: "+(end-start)/10);
		
		
	}
	
	
	
	
	
	
	
}

