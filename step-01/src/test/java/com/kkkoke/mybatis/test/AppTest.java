package com.kkkoke.mybatis.test;

import com.kkkoke.mybatis.binding.MapperProxyFactory;
import com.kkkoke.mybatis.test.dao.IUserDao;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private final Logger logger = LoggerFactory.getLogger(AppTest.class);

    public void testMapperProxyFactory() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("com.kkkoke.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.kkkoke.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);

        String res = userDao.queryUserName("100001");
        logger.info(res);
    }

    public void testProxyClass() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, ((proxy, method, args) -> "你被代理了！"));
        String res = userDao.queryUserName("100001");
        System.out.println("测试结果：" + res);
    }
}
