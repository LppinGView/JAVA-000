#作业在test中进行测试

学习笔记
1.spring的控制反转Ioc和依赖注入DI，是通过装配bean，将bean的整个生命周期交由spring容器去管理，然后用户只要使用就行了。

－－例如，可以使用xml配置的方式，配置bean的相关属性和需要的对象(依赖注入)。
－－再者可以使用注解的方式，比如利用@Compent+@Value配置bean(类似xml方式)＋@Autowired注入对象，再通过@CompentScan去扫描这些组件包，交由spring去加载。
－－再者，通过@Configuration+@Bean的方式，配置bean。
－－还有，通过@ConfigurationProperties将配置文件中的参数，实例化为对象属性;

2.以上的方式，spring都是通过该类的类型，进行反射，再调用构造函数和setter、getter方法，进行对象属性赋值，并实例化对象。

3.但以上都是半自动的装配方式，怎么实现自动装配呢?spring按需生成bean?

－－1.从配置文件中获取参数，如使用@ConfigurationProperties，将配置文件中的参数加载为属性值。
－－2.按需对类进行组装并实例化，@Configuration、@ConditionalOnClass、@EnableConfigurationProperties,@Resource,@ConditionnalMissingBean、@ConditionalOnProperty,对bean进行自动装配
－－此时对该项目打包做成starter,其他项目引入，并在其配置文件配置相应的参数时，如果spring没有装配过这个bean,在启动时就会自动装载这个bean了，实现了自动装配!



－－－－－分割符－－－－－
备注：
JDBC和数据库连接池学习总结，还没来得急弄...会补上的



