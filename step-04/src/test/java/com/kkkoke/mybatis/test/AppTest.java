package com.kkkoke.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.kkkoke.mybatis.building.xml.XMLConfigBuilder;
import com.kkkoke.mybatis.io.Resources;
import com.kkkoke.mybatis.session.Configuration;
import com.kkkoke.mybatis.session.SqlSession;
import com.kkkoke.mybatis.session.SqlSessionFactory;
import com.kkkoke.mybatis.session.SqlSessionFactoryBuilder;
import com.kkkoke.mybatis.session.defaults.DefaultSqlSession;
import com.kkkoke.mybatis.test.dao.IUserDao;
import com.kkkoke.mybatis.test.po.User;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

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

    public void testSelectOne() throws IOException {
        // 解析 XML
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        Configuration configuration = xmlConfigBuilder.parse();

        // 获取 DefaultSqlSession
        SqlSession sqlSession = new DefaultSqlSession(configuration);

        // 执行查询：默认是一个集合参数
        Object[] req = {1L};
        Object res = sqlSession.selectOne("com.kkkoke.mybatis.test.dao.IUserDao.queryUserInfoById", req);
        logger.info("测试结果：{}", JSON.toJSONString(res));
    }
}
