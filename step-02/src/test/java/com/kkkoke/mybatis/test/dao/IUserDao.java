package com.kkkoke.mybatis.test.dao;

/**
 * @author KeyCheung
 * @date 2023/05/16
 * @desc
 */
public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
