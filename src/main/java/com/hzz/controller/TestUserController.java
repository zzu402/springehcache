package com.hzz.controller;


import com.hzz.entity.TestUser;
import com.hzz.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hzz
 * @since 2018-09-07
 */
@Controller
@RequestMapping("/user")
public class TestUserController {
    @Autowired
    private ITestUserService userService;

    @RequestMapping("add")
    @ResponseBody
    public Map<String, Object> add(String name, Integer age, Integer sex) {
        Map<String, Object> map = new HashMap<>();
        TestUser user = new TestUser();
        user.setAge(age);
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setSex(sex);
        if (userService.insert4Caching(user)) {
            map.put("result", "success");
        } else {
            map.put("result", "failure");
        }
        return map;
    }

    @RequestMapping("update")
    @ResponseBody
    public Map<String, Object> update(String  id, String name, Integer age, Integer sex) {
        Map<String, Object> map = new HashMap<>();
        TestUser condition = new TestUser();
        condition.setId(id);
        TestUser update = new TestUser();
        update.setAge(age);
        update.setName(name);
        update.setSex(sex);
        if (userService.update4Caching(update, condition)) {
            map.put("result", "success");
        } else {
            map.put("result", "failure");
        }
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> delete(String id) {
        Map<String, Object> map = new HashMap<>();
        TestUser condition = new TestUser();
        condition.setId(id);
        if (userService.delete4Caching(condition)) {
            map.put("result", "success");
        } else {
            map.put("result", "failure");
        }
        return map;
    }

    @RequestMapping("getByCondition")
    @ResponseBody
    public Map<String, Object> getByCondition(String name, Integer age, Integer sex) {
        Map<String, Object> map = new HashMap<>();
        TestUser condition = new TestUser();
        condition.setAge(age);
        condition.setName(name);
        condition.setSex(sex);
        map.put("list", userService.getByCondition(condition));
        return map;
    }

    @RequestMapping("getById")
    @ResponseBody
    public Map<String, Object> getById(String id) {
        Map<String, Object> map = new HashMap<>();
        TestUser condition = new TestUser();
        condition.setId(id);
        map.put("user", userService.getById(condition));
        return map;
    }


    @RequestMapping("getAll")
    @ResponseBody
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("list", userService.getAll());
        return map;
    }


}