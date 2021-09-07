package com.cfl.springcloud.controller;

import com.cfl.springcloud.service.DeptService;
import com.clf.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        boolean b = deptService.addDept(dept);
        return b;
    }

    @GetMapping("/dept/get/{id}")
    public Dept queryDeptById(@PathVariable Long id) {
        Dept dept = deptService.queryDeptById(id);
        return dept;
    }

    @GetMapping("/dept/getAll")
    public List<Dept> queryDeptAll() {
        List<Dept> depts = deptService.queryDeptAll();
        return depts;
    }

    @PostMapping("/daoru")
    public void aaa(@RequestPart("file")MultipartFile file) throws IOException {
        System.out.println(111);
        System.out.println(file.getOriginalFilename());
    }

    @GetMapping("/discorvery")
    public Object discorvery(){
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-provider-dept");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t"
            );
        }
        return this.discoveryClient;
    }


}
