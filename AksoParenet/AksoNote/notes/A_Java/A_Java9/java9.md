# 			Java 9 新特性

# １．　Java9 新特性简介

Java 9 发布于 2017 年 9 月 22 日，带来了很多新特性，其中最主要的变化是已经实现的模块化系统。

- **模块系统**：模块是一个包的容器，Java 9 最大的变化之一是引入了模块系统（Jigsaw 项目）。
- **REPL工具 (JShell)**：交互式编程环境。
- **HTTP 2 客户端**：HTTP/2标准是HTTP协议的最新版本，新的 HTTPClient API 支持 WebSocket 和 HTTP2 流以及服务器推送特性。
- **改进的 Javadoc**：Javadoc 现在支持在 API 文档中的进行搜索。另外，Javadoc 的输出现在符合兼容 HTML5 标准。
- **多版本兼容 JAR 包**：多版本兼容 JAR 功能能让你创建仅在特定版本的 Java 环境中运行库程序时选择使用的 class 版本。
- **集合工厂方法**：List，Set 和 Map 接口中，新的静态工厂方法可以创建这些集合的不可变实例。
- **私有接口方法**：在接口中使用private私有方法。我们可以使用 private 访问修饰符在接口中编写私有方法。
- **进程 API**: 改进的 API 来控制和管理操作系统进程。引进 java.lang.ProcessHandle 及其嵌套接口 Info 来让开发者逃离时常因为要获取一个本地进程的 PID 而不得不使用本地代码的窘境。
- **改进的 Stream API**：改进的 Stream API 添加了一些便利的方法，使流处理更容易，并使用收集器编写复杂的查询。
- **改进 try-with-resources**：如果你已经有一个资源是 final 或等效于 final 变量,您可以在 try-with-resources 语句中使用该变量，而无需在 try-with-resources 语句中声明一个新变量。
- **改进的弃用注解 @Deprecated**：注解 @Deprecated 可以标记 Java API 状态，可以表示被标记的 API 将会被移除，或者已经破坏。
- **改进钻石操作符(Diamond Operator)** ：匿名类可以使用钻石操作符(Diamond Operator)。
- **改进 Optional 类**：java.util.Optional 添加了很多新的有用方法，Optional 可以直接转为 stream。
- **多分辨率图像 API**：定义多分辨率图像API，开发者可以很容易的操作和展示不同分辨率的图像了。
- **改进的 CompletableFuture API** ： CompletableFuture 类的异步机制可以在 ProcessHandle.onExit 方法退出时执行操作。
- **轻量级的 JSON API**：内置了一个轻量级的JSON API
- **响应式流（Reactive Streams) API**: Java 9中引入了新的响应式流 API 来支持 Java 9 中的响应式编程。

# ２．模块系统

```java
// export the module in java project AksoDemo :
module AksoDemo {
    requires junit;
    exports com.akso.java9.bean;
    exports  com.akso.java9.entity;
}

// import the module where we need to invoke them in the project AskoDemoTest
module AksoDemoTest {
    requires AksoDemo;
}
```

# ３．REPL (JShell)

java9 提供了JShell ，可以进行交互式编程，在Java9之前Java 是无法进行交互式编程的。

C:\Program Files\Java\jdk-9.0.1\bin\jshell.exe， 启动Jshell命令窗口

Java 9 中终于拥有了 REPL工具：jShell。利用jShell在没有创建类的情况下直接声明变量，计算表达式，执行语句。即开发时可以在命令行里直接运行java的代码，而无需创建Java文件，无需跟人解释”public static void main(String[] args)”这句废话。
jShell也可以从文件中加载语句或者将语句保存到文件中。
 jShell也可以是tab键进行自动补全和自动添加分号

Tips：在 JShell 环境下，语句末尾的“;” 是可选的。但推荐还是最好加上。提高代码可读性。

默认已经导入如下的所有包：（包含java.lang包）

# ４．多版本兼容 jar 包

当一个新版本的Java出现的时候，你的库用户要花费数年时间才会切换到这个新的版本。这就意味着库得去向后兼容你想要支持的最老的Java版本（许多情况下就是Java 6 或者 Java7）。这实际上意味着未来的很长一段时间，你都不能在库中运用Java 9所提供的新特性。幸运的是，多版本兼容jar功能能让你创建仅在特定版本的Java环境中运行库程序选择使用的class版本。

# 5．私有接口方法

在Java 9中，接口更加的灵活和强大，连方法的访问权限修饰符都可以声明为private的了，此时方法将不会成为你对外暴露的API的一部分。

```java
/**
 * 1.
 * 类： 人
 * 接口： 兽 --》 半兽人
 *
 * 2. 面试题： 抽象类 和接口的异同？
 * a. 二者的定义：声明的方式， 内部结构（jdk7， jdk8， jdk9）
 * b. 共同点： 不能实例化； 以多态的方式使用
 * c. 不同点： 单继承， 多实现
 */
public interface MyInterface {
    // jdk7 : 只能声明全局常量(public static final )和抽象方法（abstract)
    public static final String C_VALUE = "123";
    public void method1();

    // jdk8 : 声明静态方法和默认方法
    public static void method2() {
        System.out.println("method2");
    }

    default void method3() {
        System.out.println("default method : method3");
    }

    // jdk 9 : 声明私有方法
    private void method4() {
        System.out.println("private method in JDK 9.");
    }

}
```

# 6．钻石操作符(Diamond Operator)

我们将能够与匿名实现类共同使用钻石操作符（diamond operator）

```java
public void diamondOperator() {
//      Set<String> set = new HashSet<>(); // 类型推断 JDK 9 之前的
        Set<String> set = new HashSet<>(){}; // JDK9 才可以编译通过，创建一个继承于HashSet的匿名子类的对象。
        set.add("hello");
        set.add("hi");
        set.add("nihao");

        set.stream().forEach(System.out::println);
    }
```



# 7．改进的 try-catch-finally

java 9 中，用资源语句编写try将更容易，我们可以在try子句中使用已经初始化过的资源，此时的资源是final的

```java
package com.akso.java9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TryTest {

    /**
     * case1 ： 传统的try catch 语句写法
     */
    @Test
    public void testTry1() {
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            // 读取过程。。。。。。。
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Case 2： 在case1 的基础上的升级写法，不需要显实的处理资源的关闭
     * java8 要求资源对象的实例化， 必须放在try 的一对（）内完成
     * java9 中： 可以在try（）中调用已经实例化的资源对象
     *
     */
    @Test
    public void testTry2() {
        try (InputStreamReader reader = new InputStreamReader(System.in)){
            // 读取过程。。。。。。。
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        } // JDK9 不再需要编写finally，即不再需要显式的关闭，但是前提是，要求
    }

    /**
     * JDK9 中的写法, 如下的写法在JDK9之前是不可以使用的
     */
    @Test
    public void testTry3() {
        InputStreamReader reader = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try(reader; writer) { // 处理多个资源时，中间使用分号隔开
            // 此刻reader , writer 默认为final 的， 不可以对reader再次赋值
            // 读取过程。。。。。。。
            reader.read();
            writer.write(1);
        } catch (Exception e) {

        }
    }
}
```

# 8. 语法改进：Under Score(下划线)使用的限制

在java 8 中，标识符可以独立使用“_”来命名：



# １０．改进的 @Deprecated 注解

# １２．改进的 Optional 类

# １３．多分辨率图像 API

# １４．改进的 CompletableFuture API