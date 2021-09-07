package com.cfl.springcloud.controller;

import ch.qos.logback.core.util.FileUtil;
import com.clf.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" +id,Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.patchForObject(REST_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping("")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/getAll",List.class);
    }
//
//    @PostMapping("/wenjian/upload")
//    public void upload(MultipartFile multipartFile) throws IOException {
//        String originalFilename = multipartFile.getOriginalFilename();
//        String filename = multipartFile.getResource().getFilename();
//        String name = multipartFile.getName();
//
//        File file = new File(System.getProperty("user.dir") + "\\temp\\111" + "\\" + multipartFile.getOriginalFilename());
//        if(!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//        multipartFile.transferTo(file);
//        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
//        param.add("file", new FileSystemResource(file));
//        HttpHeaders headers=new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        HttpEntity<MultiValueMap<String, Object>> httpEntity=new HttpEntity<>(param, headers);
//        restTemplate.postForEntity(REST_URL_PREFIX + "/daoru", httpEntity, Object.class).getBody();
////        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/getAll",multipartFile);
////        return null;
//    }


}
