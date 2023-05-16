package com.kkkoke.mybatis.session;

/**
 * @author KeyCheung
 * @date 2023/05/16
 * @desc 工厂模式接口，构建 SqlSession 的工厂
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
