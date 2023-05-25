package com.kkkoke;

import com.kkkoke.mybatis.io.Resources;
import com.kkkoke.mybatis.session.SqlSession;
import com.kkkoke.mybatis.session.SqlSessionFactory;
import com.kkkoke.mybatis.session.SqlSessionFactoryBuilder;
import com.kkkoke.mybatis.test.dao.IUserDao;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }
}
