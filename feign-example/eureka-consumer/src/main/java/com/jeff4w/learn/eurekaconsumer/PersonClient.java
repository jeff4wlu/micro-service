package com.jeff4w.learn.eurekaconsumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lu Weijian
 * @description 备注
 * @email lwj@kapark.cn
 * @date 2019-02-24 14:17
 */
@FeignClient("eureka-provider")
public interface PersonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/hello/{name}")
    String sayHello(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "/search/{id}")
    Person getPersonById(@PathVariable("id") Integer id);


}

