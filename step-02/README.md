## 核心设计
step-02 中新增了 SqlSessionFactory，SqlSession 及 SqlSessionFactory 的默认实现类，同时还新增了 MapperRegistry。

在本步中进一步完善了 SqlSession 的内容。SqlSession 的作用是执行 SQL 语句，获取映射器，管理事务。SqlSession 新增了模拟查询 SQL 语句的
执行方法和一个映射器获取方法。也就是由 SqlSession 定义数据库处理接口和 Mapper 对象的获取操作。

SqlSession 可以理解为一种功能服务，那么功能服务的获取就需要工厂来提供获取方法。这就引入了 SqlSessionFactory，通过该接口的 openSession()
方法就可以获取 SqlSession。

MapperRegistry 的作用是提供包路径的扫描和映射器代理类注册机服务，完成接口对象的代理类注册处理。SqlSession 的实现类中就包含 MapperRegistry，
用来实现 getMapper() 方法。