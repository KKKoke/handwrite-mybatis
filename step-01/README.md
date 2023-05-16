## 核心设计
step-01 的核心类就只有 MapperProxy 和 MapperProxyFactory。

其中 MapperProxyFactory 的主要作用就是创建接口（mapperInterface）的代理类。采用的是 JDK 动态代理。Proxy 创建代理所需要的参数为类加载器，目标类所实现的接口，以及 InvocationHandler，方法拦截处理器。

而 MapperProxy 便是实现了 InvocationHandler 接口，重写了 invoke 方法，在代理类被调用的时候会执行 invoke 方法中的逻辑。 
这个代理类中包含 sqlSession，可以通过这个代理类对数据库进行操作。