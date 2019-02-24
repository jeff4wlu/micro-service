package com.jeff4w.learn.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lu Weijian
 * @description 备注
 * @email lwj@kapark.cn
 * @date 2019-02-24 14:18
 */

@RestController
public class ConsumerController {
    @Autowired PersonClient PersonClient;

    @RequestMapping(method = RequestMethod.GET, value = "/router/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String router(@PathVariable String name){
        return PersonClient.sayHello(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonById(@PathVariable Integer id){
        return PersonClient.getPersonById(id);
    }


}
