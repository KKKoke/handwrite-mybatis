package com.kkkoke.mybatis.test;

import com.kkkoke.mybatis.binding.MapperRegistry;
import com.kkkoke.mybatis.session.SqlSession;
import com.kkkoke.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.kkkoke.mybatis.test.dao.IUserDao;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(AppTest.class);

    public void testMapperProxyFactory() {
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.kkkoke.mybatis.test.dao");

        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        String res = userDao.queryUserName("10001");
        System.out.println(res);
    }
}
