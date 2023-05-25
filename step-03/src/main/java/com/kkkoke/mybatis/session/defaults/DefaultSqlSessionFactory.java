package com.kkkoke.mybatis.session.defaults;

import com.kkkoke.mybatis.session.Configuration;
import com.kkkoke.mybatis.session.SqlSession;
import com.kkkoke.mybatis.session.SqlSessionFactory;

/**
 * @author KeyCheung
 * @date 2023/05/25
 * @desc
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
