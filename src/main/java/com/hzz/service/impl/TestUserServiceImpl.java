package com.hzz.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hzz.entity.TestUser;
import com.hzz.dao.TestUserMapper;
import com.hzz.service.ITestUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2018-09-07
 */
@Service
@CacheConfig(cacheNames = {"testCache"})
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {

    private static final String ALL_USER_LIST="all_user_list";


    @Override
    @Cacheable(key = ALL_USER_LIST)
    public List<TestUser> getAll() {
        return selectList(null);
    }

    @Override
    @Cacheable(key="#user.id")
    @CacheEvict(key = ALL_USER_LIST)
    public boolean insert4Caching(TestUser user) {
        return insert(user);
    }

    @Override
    public List<TestUser> getByCondition(TestUser user) {
        EntityWrapper<TestUser> entityWrapper=new EntityWrapper<TestUser>();
        entityWrapper.setEntity(user);
        return selectList(entityWrapper);
    }

    @Override
    @Cacheable(key="#user.id")
    public TestUser getById(TestUser user) {
        return selectById(user.getId());
    }

    @Override
    public TestUser getOneByCondition(TestUser user) {
        EntityWrapper<TestUser> entityWrapper=new EntityWrapper<TestUser>();
        entityWrapper.setEntity(user);
        return selectOne(entityWrapper);
    }

    @Override
    @CacheEvict(key=ALL_USER_LIST)
    public boolean delete4Caching(TestUser user) {
        if(user.getId()!=null&&!user.getId().equals("")){
            return  deleteById(user.getId());
        }
        EntityWrapper<TestUser> entityWrapper=new EntityWrapper<TestUser>();
        entityWrapper.setEntity(user);
        return  delete(entityWrapper);
    }

    @Override
    @CacheEvict(key=ALL_USER_LIST)
    public boolean update4Caching(TestUser updateUser,TestUser conditionUser) {
        EntityWrapper<TestUser> entityWrapper=new EntityWrapper<TestUser>();
        entityWrapper.setEntity(conditionUser);
        return update(updateUser,entityWrapper);
    }


}