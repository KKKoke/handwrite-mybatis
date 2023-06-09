package com.kkkoke.mybatis.session.defaults;

import com.kkkoke.mybatis.binding.MapperRegistry;
import com.kkkoke.mybatis.session.SqlSession;

/**
 * @author KeyCheung
 * @date 2023/05/16
 * @desc 默认 SqlSession 实现类
 */
public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
