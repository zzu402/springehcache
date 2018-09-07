package com.hzz.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzz
 * @since 2018-09-07
 */
@TableName("test_user")
public class TestUser extends Model<TestUser> {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer age;
    /**
     * 0-男 1-女
     */
    private Integer sex;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TestUser{" +
        ", id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", sex=" + sex +
        "}";
    }
}
