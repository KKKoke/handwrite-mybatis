package com.kkkoke.mybatis.session;

/**
 * @author KeyCheung
 * @date 2023/05/16
 * @desc SqlSession 用来执行 SQL，获取映射器，管理事务。
 * ps：通常情况下，我们在应用程序中使用的 MyBatis 的 API 就是这个接口定义的方法
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
}
