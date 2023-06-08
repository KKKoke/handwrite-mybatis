package com.kkkoke.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
