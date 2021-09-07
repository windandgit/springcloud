package com.cfl.springcloud.mapper;

import com.clf.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    public boolean addDept(Dept dept);

    public Dept queryDeptById(Long id);

    public List<Dept> queryDeptAll();



}
