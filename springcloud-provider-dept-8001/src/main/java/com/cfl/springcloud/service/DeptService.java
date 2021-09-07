package com.cfl.springcloud.service;

import com.clf.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept queryDeptById(Long id);

    public List<Dept> queryDeptAll();
}
