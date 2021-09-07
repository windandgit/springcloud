package com.clf.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)    //链式写法，默认为false
public class Dept implements Serializable {

    private Long id;
    private String dname;
    private String dbSource;

    public Dept(String dname) {
        this.dname = dname;
    }
}
