## 核心设计

在这一步中引入了数据源配置，事务框架以及 Druid 连接池。这里的核心思路是，建立数据源连接池和 JDBC 事务工厂操作，并以 xml 的配置数据源信息为入口，在 XMLConfigBuilder 中添加数据源解析和构建操作，向配置类 Configuration 添加 JDBC 操作环境信息。以便在 DefaultSqlSession 完成对JDBC 执行 SQL 的操作。

事务类模块主要组成为 Transaction、TransactionFactory、JdbcTransaction、JdbcTransactionFactory。JdbcTransaction 封装的是 JDBC 的
事务操作，包括链接、提交、回滚、关闭操作。TransactionFactory 则是提供对应事务工厂的创建接口。

为了方便后续使用需要一个环境对象 Environment 来串联事务工厂 TransactionFactory 和数据源 DataSource，同时 Environment 对象的创建还
使用的是建造者模式。

在 mapping 包下还有一些重要的类，包括：BoundSql、MappedStatement、ParameterMapping。其中 BoundSql 便是存储 SQL 语句的各种信息，包括，
SQL 语句本身，参数类型，返回值类型，以及待替换参数的映射。MappedStatement 便是对 BoundSql 的进一步封装，新增了 SQL 语句的类型   SqlCommandType，同时引入了 Configuration，将该语句与整个流程串联起来。

在这一步中还提供了一个别名注册器 TypeAliasRegistry，它的作用是对各种我们需要的基本类型、数组类型的别名进行注册，以便后续的使用。

接下来便是核心的 Configuration 类，该类现在拓展了更多的属性，包括 Environment、MapperRegistry、mappedStatements、TypeAliasRegistry。
它提供了很多方法来封装其内部各种属性的操作。Configuration 于整个 MyBatis 来说是至关重要的，MyBatis 的所有操作都是使用 Configuration 配置
项进行串联流程，所以所有内容都会在 Configuration 中进行链接。

为了获取响应的配置就需要用到配置解析类 BaseBuilder，其具体实现类为 XMLConfigBuilder。BaseBuilder 的核心属性有 Configuration 类，用来
串联流程，同时还有 TypeAliasRegistry 类，用来存储解析后对应别名的注册。XMLConfigBuilder 的解析主要分为两部分，一部分是解析 Environment，
另一部分是解析映射器 Mapper。分别对应 XML 文件中的 environments 和 mappers 标签。

下一步便是解决 SQL 执行和结果封装，SQL 的执行主要依靠的是 SqlSession，与之相关的接口和类为，SqlSessionFactory、DefaultSqlSession、DefaultSqlSessionFactory 以及 SqlSessionFactoryBuilder。

SqlSessionFactoryBuilder 借助 Configuration 或者直接利用 XMLConfigBuidler 来构建出 SqlSessionFactory。

在 DefaultSqlSession 中，每一个执行方法封装就是 JDBC 的操作。先通过 Configuration 获取映射的语句，同时获取 Environment，再通过 Environment 获取 Connection，通过 Connection 去执行对应的 SQL 语句，再通过 ResultSet 去接收执行的结果。