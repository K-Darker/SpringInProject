package com.dn.ribbon.controller;

import com.dn.ribbon.domain.Teacher;
import com.ribbon.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController extends BaseController {

    @GetMapping("/abc")
    public Object index(@RequestParam("id")String id){
//        return restTemplate.getForObject("http://localhost:8001/user?id="+id+"",Object.class);
        return restTemplate.getForObject("http://helloclient/user?id="+id+"",Object.class);
    }

    @GetMapping("/get-teacher")
    public ResponseEntity<Teacher> getTeacher(){
//        return restTemplate.getForEntity("http://localhost:8001",Teacher.class);
        //return restTemplate.getForEntity("http://helloclient",Teacher.class);
        Teacher teacher = new Teacher();
        return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
    }

    @GetMapping("/get-for-teacher")
    public String getStringForTeacher(){
        Teacher teacher = new Teacher();
        teacher.setAge(17);
        teacher.setName("nick");
        teacher.setPassWord("1234");
        teacher.setHeader("good");
        return restTemplate.postForObject("http://localhost:8001/get-teather",teacher,String.class);
//        return restTemplate.postForObject("http://spring-cloud-ribbon-provider/get-teather",teacher,String.class);
    }


}
