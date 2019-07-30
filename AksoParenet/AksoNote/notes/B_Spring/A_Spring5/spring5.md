# Spring 注解驱动开发



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



## 1.4 组件注入

​	方法参数

​	构造器注入

​	ApplicaitonContextAware, ApplicationContextAwareProcessor

xxxAware

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

@Profile : 指定组件在哪个环境的情况下才能被注册到容器， 不指定，任何环境下都能注册这个组件

（1） 加了环境标识的bean， 只有这个环境被激活的时候才能注册到容器中， 默认是default 环境

（2） 写在配置类上， 只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效

（3） 没有标注环境的bean ，在任何环境下都是加载的

