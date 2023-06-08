package com.kkkoke.mybatis.test.dao;

import com.kkkoke.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
