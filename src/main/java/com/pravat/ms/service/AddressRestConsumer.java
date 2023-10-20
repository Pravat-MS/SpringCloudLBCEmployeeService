package com.pravat.ms.service;

import java.net.URI;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressRestConsumer {
	
	//get Instance Loadebalancing 
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public String getAddress() {
		try {
			//get one service Instance object using SID 
			ServiceInstance serviceInstance=loadBalancerClient.choose("LBC-ADDRESS-SERVICE");
			
			//get URI from SI
			URI uri=serviceInstance.getUri();
			
			//add path to SI
			String url=uri+"/api/address/data";
			
			//Take Rest Template Object 
			RestTemplate rt=new RestTemplate();
			
			//Make HttpCalled 
			ResponseEntity<String> responseEntity=rt.getForEntity(url, String.class);
			
			//Return body Data 
			return responseEntity.getBody();
			
		}catch (Exception e) {
			Logger.getLogger("Exception"+e.toString());
			return "Failed";
		}
		
	}

}
