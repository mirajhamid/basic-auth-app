package com.miraj.basicauthapp;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api", produces = {APPLICATION_JSON_VALUE})
public class BasicAuthController {

	@GetMapping(value = "/test",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<OurResponse> getUser() {
		
		Random random = new Random();
		int x =  random.nextInt(10);
	    
		if( x > 5) {
		   
		    User responseUser1 = new User("name1", "address1", 12);
		    User responseUser2 = new User("name2", "address2", 20);
		    User responseUser3 = new User("name3", "address3", 11);
		    
		    List<User> userList = new ArrayList<User>();
		    userList.add(responseUser1);
		    userList.add(responseUser2);
		    userList.add(responseUser3);
		    
		    OurResponse response = new OurResponse();
		    response.setUserList(userList);
		    response.setMessage("Success");
			response.setStatus("200");
	    	return new ResponseEntity<OurResponse>(response, HttpStatus.OK);
	   
		}else {
		   
			OurResponse response = new OurResponse();
			response.setMessage("error message");
			response.setStatus("500");
			return new ResponseEntity<OurResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		   
	}

}
