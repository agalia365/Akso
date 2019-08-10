# 						Spring Cloud

# 1. 微服务发展史-架构的演变过程

**架构的演变过程:**

单体架构——>垂直架构——>soa面向服务架构——>微服务架构

**单体架构：**

![img](单体架构.png)

**特点：**

​    ①所有功能集中在一个项目中

​    ②所有功能都要打成war包部署到服务器

​    ③ 通过集群(session共享集群)来提高服务器的性能

**优点:**
    ①.项目架构简单,前期开发的成本低,周期短,小型企业首先.
**缺点:**
    ①全部的功能都集中在一个项目中完成,对于大型项目来说,开发难度高,不容易开发及扩展和维护.



**垂直架构**

![img](重置架构.png)

特点:
    ①.以单体架构为单位进行系统的划分,划分成一个个系统.
    ②.项目与项目之间存在数据冗余,耦合度高.
    ③.项目是以接口调用为主,存在数据同步问题.
优点:
    ①.项目架构简单,前期开发的成本低,周期短,小型企业首先.
    ②.垂直架构进行mvc分层设计,针对分层做相应的处理做到集群(10~1000)
    ③.不同的项目采用不同的技术实现.
缺点:
    ①.全部的功能都集中在一个项目中完成,对于大型项目来说,开发难度高,不容易开发及扩展和维护.
    ②.集群扩展有瓶颈集群(10~1000)针对分层做了优化.

 

**SOA服务架构**

 ![img](soa.png)

特点:
    ①.基于soa服务思想进行功能的抽取(重复代码问题解决),以服务为中心来管理项目.
    ②.各个系统之间要进行调用,所以出现ESB来管理项目(可以使用各种技术实现:webservice,rpc等)
    ③.ESB是作为系统与系统之间桥梁,很难进行统一管理.
优点:
    ①.重复代码进行了抽取,提高了开发效率,提高了系统的可维护性.
    ②.可以针对某个系统进行扩展,做集群更容易.
    ③.采用ESB来管理服务组件,有利于降低企业开发项目难度 
缺点:
    ①.系统与服务的界限模糊的,不利于设计.
    ②.ESB是作为系统与系统之间桥梁,没有统一标准,种类很多,不利于维护.

    抽取项目的粒度大,系统与服务之间解耦问题.

**微服务架构**

 

![](微服务.png)

 

特点:
    ①.把系统的服务层完全独立出来,有利于资源的重复利用,提高开发效率.
    ②.微服务遵守单一原则
    ③.微服务与微服务之间的调用使用restful轻量级调用.
优点:
    ①.微服务拆分更细,有利于资源的重复利用,提高开发效率
    ②.可以更加精准针对某个服务做方案
    ③.微服务去中心化,使用restful轻量级通信协议比使用ESB企业服务总线更容易维护
    ④.适应市场更容易,产品迭代周期更短.
缺点:
    ①.微服务量多,服务治理成本高,不利于系统维护.
    分布式系统架构且是微服务架构,技术成本高(容错,分布式事务等),对团队高挑战.

# 2. Spring Cloud 及相关技术

![1564890981881](SpringCloud.png)



# 3. Spring API 网关



![1564893530620](apigateway.png)

# 4.服务注册与发现Eureka 

在Spring Cloud里我们可以使用它的Eureka模块来实现服务注册与发现，Spring Cloud Eureka是基于Netflix Eureka做了二次封装，它主要负责完成各个微服务实例的自动化注册和发现功能。

Eureka由两个组件组成：

- Eureka Server（注册中心）

- Eureka Client （服务注册）

  Eureka服务治理体系如下：

  ![img](eureka.png)

## 4.1 Eureka server 的使用

创建Eureka Server application， 引入eureka的依赖：

```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

项目创建好后，我们可以试着启动看看，但是在启动之前需要在启动类中加上`@EnableEurekaServer`注解，表示启用Eureka Server

注意： Eureka Server既是server的同时，也是一个client，它也是需要把自己注册到一个注册中心去的。如果没有配置注册中心的地址，所以它没办法注册自己就会报这个错误 ： Cannot execute request on any known server

既然如此，我们只需配置一下注册中心的地址即可，编辑application.yml配置文件内容如下

```yml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/  # 指定注册中心的url
    register-with-eureka: false  # 指定不进行注册操作，默认为true，若进行注册的话，会显示在Eureka信息面板上
  server:
    enable-self-preservation: false  # 禁用eureka server的自我保护机制，建议在生产环境下打开此配置
spring:
  application:
    name: eureka  # 指定应用的名称
server:
  port: 8761  # 指定项目的端口号
```

由于server和client是采用心跳机制来确认存活的，所以在启动项目的过程可能依旧会报错。但是只要启动后不是一直报错，并且能正常访问Eureka信息面板页面的话，则代表项目是在正常运行的

## 4.2 Eureka Client

创建eureka client 项目 引入依赖：

```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```

项目的依赖都加载完成后，在启动类中加上@EnableEurekaClient`，声明这是一个eureka client，否则不会进行服务注册.

接着就是在application.yml配置文件中，配置注册中心即eureka server的地址，以及项目的名称和启动端口号。如下：

```yml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
spring:
  application:
    name: eureka-client
server:
  port: 9088
```

## 4.3 Eureka的高可用

高可用是在服务架构设计中，频繁出现的词汇。微服务架构里自然也一样需要保证服务的高可用性.

在实际生产环境中服务器是很脆弱的，单台服务器肯定是无法满足高可用的需求，为了保证高可用性我们通常会准备多台服务器。但可以发现上文中所搭建的eureka server是单机的，若这个eureka server宕机，则会导致与之关联的全部微服务发生故障。

既然单机无法保证高可用，那么我们就加多一台机器好了，然后让这两个eureka server互相进行关联。例如我现在有两台eureka server。一台名叫eureka-server01跑在8761端口上，另一台名叫eureka-server02跑在8762端口上。然后只需要两个步骤即可实现高可用：

- 1.编辑这两台eureka server的配置文件，让它们的注册地址互相指向，即可关联在一起
- 2.在eureka client的配置文件中，配置上这两台eureka server的地址，让client能够同时注册到这两台eureka server上。这样即便其中一台eureka server挂掉，另一台依旧可以继续工作

1.编辑两台eureka server的配置文件，

eureka-server01：

```yml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8762/eureka/  # 指向eureka-server02的url
    register-with-eureka: false
  server:
    enable-self-preservation: false 
spring:
  application:
    name: eureka-server01 
server:
  port: 8761
```

eureka-server02：

```yml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/  # 指向eureka-server01的url
    register-with-eureka: false
  server:
    enable-self-preservation: false
spring:
  application:
    name: eureka-server02 
server:
  port: 8762 
```

2.编辑eureka client的配置文件，多个url使用英文逗号分隔：

```yml
eureka:
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/,http://localhost:8762/eureka/
spring:
  application:
    name: eureka-client
server:
  port: 9088
```

如果项目规模比较大，有两个以上的eureka server，那该如何在配置文件中配置呢？其实只需要每台eureka server分别配置除自己之外的eureka server机器，然后eureka client则配置所有的eureka server地址即可。如下图：

![img](eurekas.png)









# 5. Ribbon

在`SpringCloud`体系中，我们知道服务之间的调用是通过`http`协议进行调用的。而注册中心的主要目的就是维护这些服务的服务列表。我们知道，在`Spring`中，提供了`RestTemplate`。`RestTemplate`是`Spring`提供的用于访问Rest服务的客户端。而在`SpringCloud`中也是使用此服务进行服务调用的。

同时在微服务中，一般上服务都不会进行单点部署的，都会至少部署2台及以上的。现在我们有了注册中心进行服务列表的维护，就需要一个客户端负载均衡来进行动态服务的调用。

## 5.1 何为负载均衡

负载均衡(Load Balance)是分布式系统架构设计中必须考虑的因素之一，它通常是指，将请求/数据**【均匀】分摊**到多个操作单元上执行，负载均衡的关键在于【均匀】。

1.HTTP重定向负载均衡

根据用户的http请求计算出一个真实的web服务器地址，并将该web服务器地址写入http重定向响应中返回给浏览器，由浏览器重新进行访问

**优缺点：实现起来很简单，而缺点也显而易见了：请求两次才能完成一次访问；性能差;重定向服务器会成为瓶颈**

2.DNS域名解析负载均衡

在DNS服务器上配置多个域名对应IP的记录。例如一个域名`www.baidu.com`对应一组web服务器IP地址，域名解析时经过DNS服务器的算法将一个域名请求分配到合适的真实服务器上。

**优缺点：加快访问速度,改善性能。同时由于DNS解析是多级解析，每一级DNS都可能化缓存记录A，当某一服务器下线后，该服务器对应的DNS记录A可能仍然存在，导致分配到该服务器的用户访问失败，而且DNS负载均衡采用的是简单的轮询算法，不能区分服务器之间的差异，不能反映服务器当前运行状态。**

3.反向代理负载均衡

反向代理处于web服务器这边，反向代理服务器提供负载均衡的功能，同时管理一组web服务器，它根据负载均衡算法将请求的浏览器访问转发到不同的web服务器处理，处理结果经过反向服务器返回给浏览器。

**优缺点：实现简单，可利用反向代理缓存资源(这是最常用的了)及改善网站性能。同时因为是所有请求和响应的中转站，所以反向代理服务器可能成为瓶颈。**

![img](反向代理负载均衡.jpg)



## 5.2 客户端和服务端的负载均衡

实现负载均衡也又区分客户端和服务端之分，`Ribbon`就是基于客户端的负载均衡。 

**客户端负载均衡：**

![客户端负载均衡](客户端负载均衡.jpg)

**服务端负载均衡：**

![服务端负载均衡](服务端负载均衡.jpg)

## 5.3 RestTemplate简单介绍

`RestTemplate`是`Spring`提供的用于访问`Rest服务`的客户端，`RestTemplate`提供了多种便捷访问远程Http服务的方法，能够大大提高客户端的编写效率。

简单来说，`RestTemplate`采用了`模版设计`的设计模式，将过程中与特定实现相关的部分委托给接口,而这个接口的不同实现定义了接口的不同行为,所以可以很容易的使用不同的第三方http服务，如`okHttp`、`httpclient`等。

`RestTemplate`定义了很多的与REST资源交互

## 5.4 客户端负载均衡Ribbon实例

`Spring Cloud Ribbon`是一个基于Http和TCP的客服端负载均衡工具，它是基于`Netflix Ribbon`实现的。与`Eureka`配合使用时，`Ribbon`可自动从`Eureka Server (注册中心)`获取服务提供者地址列表，并基于`负载均衡`算法，通过在客户端中配置`ribbonServerList`来设置服务端列表去轮询访问以达到均衡负载的作用

![Ribbon](ribbon.jpg)

## 5.5 LoadBalanced注解

```java
@Bean
@LoadBalanced
public RestTemplate restTemplate(RestTemplateBuilder builder) {
    // Do any additional configuration here
    return builder.build();
}
```

`@LoadBalanced`注解修饰`RestTemplate`bean类，就实现了服务的调用

首先，此类生效的条件是

- `RestTemplate`类必须存在于当前工程的环境中。
- 在Spring的Bean工程中有必须有`LoadBalancerClient`的实现Bean。

该自动化配置类中，主要做了几件事情：

- 维护了一个被@LoadBalanced注解修饰的RestTemplate对象列表

**总体来说，就是通过为加入@LoadBalanced注解的RestTemplate添加一个请求拦截器，在请求前通过拦截器获取真正的请求地址，最后进行服务调用。**

## 5.6 负载均衡器

![负载均衡器](负载均衡器.jpg)

## 5.7  使用java 代码自定义Ribbon 配置

## 5.8， 使用属性自定义Ribbon配置

## 5.9, 脱离Eureka使用Ribbon



# 6. 使用Feign实现声明式REST调用

`Feign`是`Netflix`开发的声明式、模块化的HTTP客户端。`Feign`可帮助我们更好更快的便捷、优雅地调用`HTTP API`。

在`Spring Cloud`中，使用`Feign`非常简单——创建一个接口，并在接口上添加一些注解。`Feign`支持多种注释，例如Feign自带的注解或者JAX-RS注解等 Spring Cloud对Feign进行了增强，使Feign支持了Spring MVC注解，并整合了Ribbon和 Eureka,从而让Feign 的使用更加方便。**只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。**

### Feign继承特性

`Feign`支持继承，**但不支持多继承**。使用继承，可将一些公共操作分组到一些父类接口中，从而简化Feign的开发。

**所以在实际开发中，调用服务接口时，可直接按接口类和实现类进行编写，调用方引入接口依赖，继承一个本地接口，这样接口方法默认都是定义好的，也少了很多编码量。用起来就更爽了，就是有点依赖性，对方服务修改后需要同步更新下，但这个团队内部约定下问题不大的**