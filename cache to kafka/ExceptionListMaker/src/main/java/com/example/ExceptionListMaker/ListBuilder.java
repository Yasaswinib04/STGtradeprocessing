package com.example.ExceptionListMaker;

import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;

@Component
public class ListBuilder {

	@Autowired
	TradeRepository tradeRepository;

	String tradeId;

	public void buildList()  {
		
		//List<Trade> tradeList=(List)tradeRepository.findAll();
	    
		try(
			
			FileReader	idFileReader=new FileReader("input.txt");
		    BufferedReader inputStream=new BufferedReader(idFileReader);
				
				
			FileWriter idFileWriter=new FileWriter("output.txt")	;
			PrintWriter outputStream=new PrintWriter(idFileWriter);	
				
		){
			
			
			
			while((tradeId=inputStream.readLine()) !=null ) {
				
				//BookMark-1
		
				
				boolean res=tradeRepository.existsByTradeId(tradeId);
				
				//System.out.println(res);
				if(res==true) {
					System.out.println(tradeId);
				    outputStream.println(tradeId);
				}
			}
			
		}
		
		catch(FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch(IOException e) {
			System.out.println("Can't read or write to file");
		}
		
		
	}

}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------

//BookMark-1:

/*

  System.out.println(tradeId);
  
  // Finds if tradeId of current trade is already present in database or not 
 boolean res=false; 
 for(int i=0;i<tradeList.size();i++) { 
  System.out.println("tradeId: "+tradeList.get(i).getTradeId()); 
  if(tradeList.get(i).getTradeId().equals(tradeId)) { 
     System.out.println("match found!   "+tradeId); 
     res=true;
  }
 } 
 
 
*/



 
