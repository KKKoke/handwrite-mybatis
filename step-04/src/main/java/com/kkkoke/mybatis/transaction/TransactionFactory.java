package com.kkkoke.mybatis.transaction;

import com.kkkoke.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public interface TransactionFactory {

    Transaction newTransaction(Connection connection);

    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);
}
