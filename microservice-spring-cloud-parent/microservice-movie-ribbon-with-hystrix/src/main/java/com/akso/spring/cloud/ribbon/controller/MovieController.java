package com.akso.spring.cloud.ribbon.controller;

import com.akso.spring.cloud.ribbon.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@RestController
@EnableHystrix
public class MovieController {
    private Logger logger = Logger.getLogger(MovieController.class.getName());
    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.servicePath}")
    private String userServicePath;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(userServicePath + id, User.class);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }

//    @GetMapping("/log-user-instance")
//    public void logUserInstance() {
//        ServiceInstance instance = this.loadBalancerClient.choose("microservice-provider-user");
//        logger.info("instance ==> serviceId :[" + instance.getServiceId() + "], host: [" +  instance.getHost() + "], port: [" + instance.getPort() + "].");
//    }
}
