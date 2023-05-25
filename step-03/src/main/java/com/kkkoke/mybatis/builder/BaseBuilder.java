package com.kkkoke.mybatis.builder;

import com.kkkoke.mybatis.session.Configuration;

/**
 * @author KeyCheung
 * @date 2023/05/25
 * @desc
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
