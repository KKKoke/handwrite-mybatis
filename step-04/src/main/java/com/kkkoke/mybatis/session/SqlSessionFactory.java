package com.kkkoke.mybatis.session;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
