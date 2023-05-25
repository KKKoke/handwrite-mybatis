package com.kkkoke.mybatis.session;

/**
 * @author KeyCheung
 * @date 2023/05/22
 * @desc SqlSession 用来执行SQL，获取映射器，管理事务。
 */
public interface SqlSession {

    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    Configuration getConfiguration();

    <T> T getMapper(Class<T> type);
}
