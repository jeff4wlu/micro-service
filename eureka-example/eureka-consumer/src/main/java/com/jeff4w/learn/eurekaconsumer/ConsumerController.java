package com.jeff4w.learn.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Lu Weijian
 * @description 备注
 * @email lwj@kapark.cn
 * @date 2019-02-21 16:36
 */
@Controller
@Configuration
public class ConsumerController {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping(value = "/router")
    @ResponseBody
    public String router(){
        RestTemplate temp = getRestTemplate();
        return temp.getForObject("http://eureka-provider/search/1", String.class);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/count")
    @ResponseBody
    public String countService(){
        List<String> services = discoveryClient.getServices();
        for (String string : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(string);
            System.out.println("服务名称："+string+",服务数量："+instances.size());
        }
        return "success";
    }


}

