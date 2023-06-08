package com.kkkoke.mybatis.session;

/**
 * @author KeyCheung
 * @date 2023/05/26
 * @desc
 */
public interface SqlSession {

    /**
     * 根据指定的 SqlID 获取一条记录的封装对象
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的 SqlID 获取一条记录的封装对象，只不过这个方法容许我们可以给 sql 传递一些参数
     * 一般在实际使用中，这个参数传递的是 pojo，或者 Map 或者 ImmutableMap
     */
    <T> T selectOne(String statement, Object parameter);

    Configuration getConfiguration();

    /**
     * 得到映射器，这个巧妙地使用了泛型，使得类型安全
     */
    <T> T getMapper(Class<T> type);
}
