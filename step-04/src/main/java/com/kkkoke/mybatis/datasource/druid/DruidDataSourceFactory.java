package com.kkkoke.mybatis.datasource.druid;

import com.kkkoke.mybatis.datasource.DataSourceFactory;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties props;

    @Override
    public void setProperties(Properties props) {
        this.props = props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));
        return dataSource;
    }
}
