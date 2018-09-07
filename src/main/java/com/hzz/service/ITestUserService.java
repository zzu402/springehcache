package com.hzz.service;

import com.hzz.entity.TestUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2018-09-07
 */
public interface ITestUserService extends IService<TestUser> {

    List<TestUser> getAll();

    boolean insert4Caching(TestUser user);

    List<TestUser> getByCondition(TestUser user);

    TestUser getById(TestUser user);

    TestUser getOneByCondition(TestUser user);

    boolean delete4Caching(TestUser user);

    boolean update4Caching(TestUser updateUser, TestUser conditionUser);
}