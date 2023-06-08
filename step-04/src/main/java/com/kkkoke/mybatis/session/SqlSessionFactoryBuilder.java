package com.kkkoke.mybatis.session;

import com.kkkoke.mybatis.building.xml.XMLConfigBuilder;
import com.kkkoke.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
