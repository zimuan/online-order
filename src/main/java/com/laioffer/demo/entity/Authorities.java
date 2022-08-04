package com.laioffer.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {
    // serializable: 我们要将当前内存的数据存到硬盘上，要做序列化。
    //               不序列化数据库不认识你.
    // 存到数据库的数据都有版本号，用于验证匹配，分别独立。
    // 再修改column的时候，版本号需要修改
    // 读的时候发现版本号不一致，会检查哪里修改了。
    // deserialize的时候
    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private String email;

    private String authorities;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

}
