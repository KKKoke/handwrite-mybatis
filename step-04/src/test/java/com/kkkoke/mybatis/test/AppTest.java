package com.kkkoke.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.kkkoke.mybatis.io.Resources;
import com.kkkoke.mybatis.session.SqlSession;
import com.kkkoke.mybatis.session.SqlSessionFactory;
import com.kkkoke.mybatis.session.SqlSessionFactoryBuilder;
import com.kkkoke.mybatis.test.dao.IUserDao;
import com.kkkoke.mybatis.test.po.User;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    public void testSqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }
}
