package com.example.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import org.springframework.cloud.client.serviceregistry.Registration;


@RestController
public class HelloController {
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private Registration registration;
	
	@GetMapping("/hello")
	public String index() {
//		List<ServiceInstance> instances = client.getInstances("eureka-client-service-provider");
		JSONObject jsonTemp = new JSONObject();

        jsonTemp.put("ServiceId", registration.getServiceId());
        jsonTemp.put("ServiceUri", registration.getUri());
        jsonTemp.put("ServiceHost", registration.getHost());
        jsonTemp.put("ServiceSchema", registration.getScheme());
        jsonTemp.put("ServicePort", registration.getPort());
        jsonTemp.put("ServiceMetadata", registration.getMetadata());
        return jsonTemp.toJSONString();
//		return "Welcome to the home page!" + registration.getHost() + registration.getPort();
	}
	
	@RequestMapping("/helloUser")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }
}
