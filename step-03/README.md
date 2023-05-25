## 核心设计
step-03 中新增了很多内容，如：Configuration，SqlSessionFactoryBuilder, XmlConfigBuilder，MappedStatement，MappedMethod，Resources。

其中 Configuration 是配置类，也就是串联整个 MyBatis 流程的核心，所有内容存放和读取都离不开这个类。Configuration 类中包含 MapperRegistry，
MappedStatements 这两个类也是 MyBatis 流程的核心。Configuration 还提供了一系列方法去操作这两个类。MapperRegistry 的作用是注册映射器代理工厂，
方便之后用来构建 mapperInterface 的代理类。 MappedStatements 则是用来缓存映射语句 MappedStatement 的，也就是在 XML 配置中的 SELECT 等语句的
标签与 MappedStatement 会进行对应。 如：SQL 语句标签中常见的属性，id，parameterType，resultType，sql，parameter 等。同时 MappedStatement
与 MapperRegistry 的内部也同样包含 Configuration。

SqlSessionFactoryBuilder 以工厂建造者模式构建 SqlSessionFactory ，然后再通过 SqlSessionFactory 去构造 SqlSession。

XmlConfigBuilder 的作用便是通过 XML 文件来构建 Configuration。Resources 类便是通用 IO 工具类。

MapperMethod 的作用是用来根据自身属性 SqlCommand 来调度 SqlSession 执行对应的 sql 语句。
