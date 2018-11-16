## 说明
* annotation
    * 基于注解的配置 context:component-scan
* aop
    * 1、基于Java动态代理 classLoader、invocationHandler
    * 2、基于Aspect的方式 \<aop:aspectj-autoproxy/\>
* base
    * 1、普通Bean配置
    * 2、constructor-arg
    * 3、property
    * 4、property的简化方式 **p:**
    * 5、集合属性的配置 list、map、props
* cycle
    * 生命周期 constructor -> set method -> init-method -> destory-method
    * Bean 的后置处理器 BeanPostProcessor，在init前后分别增加 postProcessBeforeInitialization 和 postProcessAfterInitialization
* factory
    * 静态工厂配置
    * 实例工厂配置
* factorybean 返回的不是factorybean本身，而是factory产生的Bean
* tx （**编程式事务** 和 **声明式事务**）
    * Spring提供两种方式的编程式事务管理，分别是：使用**TransactionTemplate**和直接使用**PlatformTransactionManager**。
    * propagation 事务的传播性
    * isolation 事务的隔离性
        * 隔离级别定义了一个事务可能受其他并发事务影响的程度
            * 脏读（Dirty reads）——脏读发生在一个事务读取了另一个事务改写但尚未提交的数据时。如果改写在稍后被回滚了，那么第一个事务获取的数据就是无效的。
            * 不可重复读（Nonrepeatable read）——不可重复读发生在一个事务执行相同的查询两次或两次以上，但是每次都得到不同的数据时。这通常是因为另一个并发事务在两次查询期间进行了更新。
            * 幻读（Phantom read）——幻读与不可重复读类似。它发生在一个事务（T1）读取了几行数据，接着另一个并发事务（T2）插入了一些数据时。在随后的查询中，第一个事务（T1）就会发现多了一些原本不存在的记录。
        * 1、DEFAULT 使用后端数据库默认的隔离级别
        * 2、READ_UNCOMMITTED 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
        * 3、READ_COMMITTED 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
        * 4、REPEATABLE_READ 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生
        * 5、SERIALIZABLE 最高的隔离级别，完全服从ACID的隔离级别，确保阻止脏读、不可重复读以及幻读，也是最慢的事务隔离级别，因为它通常是通过完全锁定事务相关的数据库表来实现的
    * timeout 超时时间
    * readOnly 是否只读
    * rollbackFor/noRollbackFor