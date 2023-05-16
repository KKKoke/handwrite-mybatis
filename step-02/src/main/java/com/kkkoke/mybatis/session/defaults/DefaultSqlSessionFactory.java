package com.kkkoke.mybatis.session.defaults;

import com.kkkoke.mybatis.binding.MapperRegistry;
import com.kkkoke.mybatis.session.SqlSession;
import com.kkkoke.mybatis.session.SqlSessionFactory;

/**
 * @author KeyCheung
 * @date 2023/05/16
 * @desc 默认的 DefaultSqlSessionFactory
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
