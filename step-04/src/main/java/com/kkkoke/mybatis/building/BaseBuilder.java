package com.kkkoke.mybatis.building;

import com.kkkoke.mybatis.session.Configuration;
import com.kkkoke.mybatis.type.TypeAliasRegistry;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
