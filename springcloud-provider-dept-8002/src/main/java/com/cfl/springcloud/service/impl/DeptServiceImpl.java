package com.cfl.springcloud.service.impl;

import com.cfl.springcloud.mapper.DeptMapper;
import com.cfl.springcloud.service.DeptService;
import com.clf.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public boolean addDept(Dept dept) {
        boolean b = deptMapper.addDept(dept);
        return b;
    }

    public Dept queryDeptById(Long id) {
        Dept dept = deptMapper.queryDeptById(id);
        return dept;
    }

    public List<Dept> queryDeptAll() {
        List<Dept> depts = deptMapper.queryDeptAll();
        return depts;
    }
}
