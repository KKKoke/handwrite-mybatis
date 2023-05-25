package com.kkkoke.mybatis.session;

/**
 * @author KeyCheung
 * @date 2023/05/25
 * @desc
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
