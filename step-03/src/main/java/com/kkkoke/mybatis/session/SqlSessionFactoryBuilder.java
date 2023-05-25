package com.kkkoke.mybatis.session;

import com.kkkoke.mybatis.builder.xml.XmlConfigBuilder;
import com.kkkoke.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author KeyCheung
 * @date 2023/05/25
 * @desc
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
