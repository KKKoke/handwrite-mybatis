package com.kkkoke.mybatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public interface DataSourceFactory {

    void setProperties(Properties props);

    DataSource getDataSource();
}
