package com.kkkoke.mybatis.transaction.jdbc;

import com.kkkoke.mybatis.session.TransactionIsolationLevel;
import com.kkkoke.mybatis.transaction.Transaction;
import com.kkkoke.mybatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public class JdbcTransactionFactory implements TransactionFactory {

    @Override
    public Transaction newTransaction(Connection connection) {
        return new JdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
