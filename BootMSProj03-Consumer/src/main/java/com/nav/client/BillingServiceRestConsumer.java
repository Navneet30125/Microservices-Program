package com.nav.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceRestConsumer {
	@Autowired
	public DiscoveryClient client; //client component come through AutoConfiguration
	public String getBillingInfo() {
		//get and found Service Instances of producer by service id
		List<ServiceInstance> listSI = client.getInstances("BILLING-SERVICE"); //UPPERCASE
		if (listSI == null || listSI.isEmpty()) {
		    throw new RuntimeException("No Billing-Service instances available");
		}
		//first service Instance from the list of Instances
		ServiceInstance SI = listSI.get(0);
		//get MS URI and make it as URL
		String url = SI.getUri()+"/billing/info";
        //create rest Template
		RestTemplate rs = new RestTemplate();
		//invoke Producer MS Service method or operation by generating by Http call
		String res = rs.getForObject(url, String.class);
		return res;
		
	}
}
