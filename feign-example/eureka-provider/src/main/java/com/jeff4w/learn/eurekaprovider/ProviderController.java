package com.jeff4w.learn.eurekaprovider;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lu Weijian
 * @description 备注
 * @email lwj@kapark.cn
 * @date 2019-02-24 14:04
 */
@RestController
public class ProviderController {
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String sayHello(@PathVariable String name){
        return "hello " + name + ", I'm glad to see you.";
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person searchPerson(@PathVariable Integer id, HttpServletRequest request){
        Person person = new Person();
        person.setId(id);
        person.setName("Spirit");
        person.setInfo(request.getRequestURL().toString());
        return person;
    }


}
