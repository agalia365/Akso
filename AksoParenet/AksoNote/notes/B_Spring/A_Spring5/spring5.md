# Spring 注解驱动开发

Spring5 是一个重要的版本，距离SpringFramework4差不多四年。在此期间，大多数增强都是在 SpringBoot 项目中完成的。在本文中，我们将很快了解到Spring5发行版中的一些令人兴奋的特性。

\1. 基准升级

要构建和运行 Spring5 应用程序，你至少需要 J2EE7 和 JDK8。以前的 JDK 和 JavaEE 版本不再支持。 JavaEE7 包含：

- Servlet 3.1
- JMS 2.0
- JPA 2.1
- JAX-RS 2.0
- Bean Validation 1.1

与 Java 基准类似，许多其他框架的基准也有变化。例如：

- Hibernate 5
- Jackson 2.6
- EhCache 2.10
- JUnit 5
- Tiles 3

另外，请记下各种服务器最低支持版本。

- Tomcat 8.5+
- Jetty 9.4+
- WildFly 10+
- Netty 4.1+
- Undertow 1.4+

\2. 兼容 JDK9 运行时

Spring5 发行版与 JDK9 发行日期非常接近。目标是让 Spring Framework5 在 JDK9 的 GA 之后正确运行。 Spring5 版本的候选版本已经在 classpath 和 modulepath 上支持 Java9 了。

GA版本中你可以期待良好的 JDK9 支持。

\3. 使用 JDK8 特性

获取免费Spring 5 新特性视频详解可以群：554355695

在 Spring4.3 之前，JDK基准版本是6。所以 Spring4 必须支持 Java6,7 和8，为了保持向后兼容性， Spring 框架没有适应 Java8 带来的许多新特性，比如 lambda 表达式。

Spring5 的基准版本为8，因此它使用了 Java8 和9的许多新特性。例如：

- Spring 接口中的默认方法
- 基于 Java8 反射增强的内部代码改进
- 在框架代码中使用函数式编程 - lambda表达式 和 stream流

\4. 响应式编程支持

响应式编程是 SpringFramework5.0 最重要的特性之一。响应式编程提供了另一种编程风格，专注于构建对事件做出响应的应用程序。 SpringFramework5 包含响应流（定义响应性API的语言中立尝试）和 Reactor（由Spring Pivotal团队提供的 Reactive Stream 的Java实现）， 以用于其自身的用途以及其许多核心API。

Spring Web Reactive 在 spring-webmvc 模块中现有的（而且很流行）Spring Web MVC旁边的新的 spring-web-reactive 模块中。 请注意，在 Spring5 中，传统的 SpringMVC 支持 Servlet3.1 上运行，或者支持 JavaEE7 的服务器。

\5. 函数式web框架

除了响应式功能之外，Spring5 还提供了一个函数式Web框架。它提供了使用函数式编程风格来定义端点的特性。 该框架引入了两个基本组件：HandlerFunction 和 RouterFunction。

HandlerFunction 表示处理接收到的请求并生成响应的函数。 RouterFunction 替代了 @RequestMapping 注解。它用于将接收到的请求路由到处理函数。例如：

> RouterFunction<String> route =
>
> route(GET("/hello-world"),
>
> request -> Response.ok().body(fromObject("Hello World")));

\6. Kotlin支持

Kotlin 是一种静态类型的JVM语言，它让代码具有表现力，简洁性和可读性。 Spring5.0 对 Kotlin 有很好的支持。

\7. 移除的特性

随着 Java、JavaEE 和其他一些框架基准版本的增加，SpringFramework5 取消了对几个框架的支持。例如:

- Portlet
- Velocity
- JasperReports
- XMLBeans
- JDO
- Guava

# 1.容器

## 1.1 AnnotationConfigApplicaitonContext

使用AnnotationConfigApplicationContext可以实现基于Java的配置类加载Spring的应用上下文.避免使用application.xml进行配置。在使用spring框架进行服务端开发时，注解配置在便捷性，和操作上都优于是使用XML进行配置;

​	配置类

​	包扫描

## 1.2 组件添加

​	@ComponentScan 定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中

​	@Bean  作为这个Spring容器中的Bean

​	@Configuration 把一个类作为一个IoC容器

​	@Component 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。

​	@Service 是@Component的特例，用于标注业务层组件

​	@Repository 用于标注数据访问组件，即DAO组件

​	@Conditional Spring4新提供的注解，它的作用是按照一定的条件进行判断，满足条件给容器注册bean

​	@Controller 用于标注控制层组件

​	@Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配。

​	@Primary 自动装配时当出现多个Bean候选者时，被注解为@Primary的Bean将作为首选者，否则将抛出异常

​	@Lazy 表示延迟初始化

​	@Scope 用于指定scope作用域的（用在类上）， 默认为单例singleton

​	@Import 注解把用到的bean导入到了当前容器中

​	ImportSelector

​	工厂模式 --》 FactoryBean --》 &beanName获取Factory本身

​	@Scope spring中scope是一个非常关键的概念，简单说就是对象在spring容器（IOC容器）中的生命周期，也可以理解为对象在spring容器中的创建方式。

​		1）singleton （单一实例）

 此取值时表明容器中创建时只存在一个实例，所有引用此bean都是单一实例。如同每个国家都有一个总统，国家的所有人共用此总统，而这个国家就是一个spring容器，总统就是spring创建的类的bean，国家中的人就是其它调用者，总统是一个表明其在spring中的scope为singleton，也就是单例模型。

此外，singleton类型的bean定义从容器启动到第一次被请求而实例化开始，只要容器不销毁或退出，该类型的bean的单一实例就会一直存活，典型单例模式，如同servlet在web容器中的生命周期。

 

2）prototype

spring容器在进行输出prototype的bean对象时，会每次都重新生成一个新的对象给请求方，虽然这种类型的对象的实例化以及属性设置等工作都是由容器负责的，但是只要准备完毕，并且对象实例返回给请求方之后，容器就不在拥有当前对象的引用，请求方需要自己负责当前对象后继生命周期的管理工作，包括该对象的销毁。也就是说，容器每次返回请求方该对象的一个新的实例之后，就由这个对象“自生自灭”，最典型的体现就是spring与struts2进行整合时，要把action的scope改为prototype。

如同分苹果，将苹果的bean的scope属性声明为prototype，在每个人领取苹果的时候，我们都是发一个新的苹果给他，发完之后，别人爱怎么吃就怎么吃，爱什么时候吃什么时候吃，但是注意吃完要把苹果核扔到垃圾箱！对于那些不能共享使用的对象类型，应该将其定义的scope设为prototype。

 

3）request

再次说明request，session和global session类型只实用于web程序，通常是和XmlWebApplicationContext共同使用。

<bean id ="requestPrecessor" class="...RequestPrecessor"   scope="request" />

Spring容器，即XmlWebApplicationContext 会为每个HTTP请求创建一个全新的RequestPrecessor对象，当请求结束后，该对象的生命周期即告结束，**如同java web中request的生命周期**。当同时有100个HTTP请求进来的时候，容器会分别针对这10个请求创建10个全新的RequestPrecessor实例，且他们相互之间互不干扰，简单来讲，request可以看做prototype的一种特例，除了场景更加具体之外，语意上差不多。

 

4）session

对于web应用来说，放到session中最普遍的就是用户的登录信息，对于这种放到session中的信息，我们可以使用如下形式的制定scope为session：

<bean id ="userPreferences" class="...UserPreferences"   scope="session" />

Spring容器会为每个独立的session创建属于自己的全新的UserPreferences实例，比request scope的bean会存活更长的时间，其他的方面没区别，**如果java web中session的生命周期**。

 

5）global session

<bean id ="userPreferences" class="...UserPreferences"   scope="globalsession" />

global session只有应用在基于porlet的web应用程序中才有意义，它映射到porlet的global范围的session，如果普通的servlet的web 应用中使用了这个scope，容器会把它作为普通的session的scope对待。



## 1.3 组件赋值

​	@Value 

​	用@Value 对属性赋值* 

			1. 可以使用基本数值 @Value("XXXXX")* 
   2. 可以使用SpEL表达式 @Value("#{100 -20 }")*
   3. 可以使用配置文件中的值 @Value("${propertyKey}")

​	

​	@Autowired 默认按类型装配，如果我们想使用按名称装配，可以结合@Qualifier注解一起使用 	

​	@Qualifier("personDaoBean") 存在多个实例配合使用

​	@PropertySources --》 @PropertySource

​	@Profile ==》 Environment ==》 -DSpring.profiles.active=test

​	@Profile : 指定组件在哪个环境的情况下才能被注册到容器， 不指定，任何环境下都能注册这个组件

（1） 加了环境标识的bean， 只有这个环境被激活的时候才能注册到容器中， 默认是default 环境

（2） 写在配置类上， 只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效

（3） 没有标注环境的bean ，在任何环境下都是加载的

## 1.4 组件注入

​	方法参数

​	构造器注入

​	ApplicaitonContextAware, ApplicationContextAwareProcessor

​	xxxAware

## 1.5 AOP

​	@EnableAspectJAutoProxy

​	@Before/@After/@AfterReturing/@AfterThrowing/@Around

@PointCut

## 1.6 声明式事务

@EnableTransactionManagement

@Transactional

1. 扩展原理

   2.1 BeanFactoryPostProcessor

   2.2 BeanDefinitionRegistryPostProcessfor

   2.3 ApplicationListener

   2.4 Spring 容器创建过程

2. web

   3.1 Servlet3.0

   3.2 异步请求

1. 组件注册





2. Bean 的生命周期

3. 自动装配
4. profile



