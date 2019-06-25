
                                               Java 8 新特性

# 1 Java 8 新特性简介

# 2 Lambda 表达式
    ## 1. 定义： Lambda: In programming languages such as Lisp, Python and Ruby lambda is an operator used to denote anonymous functions or closures, following the usage of lambda calculus.
    
    Lambda表达式为java添加了缺失的函数式编程特性， 使我们能将函数当做一等公民看
    
    在将函数作为一等公民的语言中， Lambda 表达式的类型是函数。 但是在java 中， Lambda表达式是对象， 他们
    必须依附于一类特别的对象类型---函数式接口（functional interface）

    
## 2. 关于函数式接口：
    1. 如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口
    2. 如果我们在某个接口上声明了FunctionalInterface注解，那么编译器就会按照函数式接口定义来要求该接口
    3. 如果某个接口只有一个抽象方法， 但是我们并没有给该接口声明FunctionalInterface注解，那么编译器依旧会将该接口看作是函数式接口




# 3 方法引用与构造器引用

# 4 Stream流

# 5 Optional容器类
    Optional<T> 类(java.util.Optional) 是一个容器类，代表一个值存在或不存在，原来用null 表示一个值不存在，现在Optional 可以更好的表达这个概念。并且可以避免空指针异常。
    常用方法：
    Optional.of(T t) : 创建一个Optional 实例
    Optional.empty() : 创建一个空的Optional 实例
    Optional.ofNullable(T t):若t 不为null,创建Optional 实例,否则创建空实例
    isPresent() : 判断是否包含值
    orElse(T t) : 如果调用对象包含值，返回该值，否则返回t
    orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回s 获取的值
    map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
    flatMap(Function mapper):与map 类似，要求返回值必须是Optional

# 6 接口中的默认方法和静态方法

## 1. 介绍

    在Java8以前，接口中只能有抽象方法(public abstract 修饰的方法)跟全局静态常量(public static final 常量  )；
    但是在Java8中，允许接口中包含具有具体实现的方法，该方法称为 “默认方法”，默认方法使用 default 关键字修饰，
    其次，Java8中，接口中还允许添加静态方法
  
## 2. 接口中的默认方法

    第一种情况：接口默认方法的”类优先”原则         
        若一个接口中定义了一个默认方法，而另外一个父类或接口中 又定义了一个同名的方法时，先调用类中的同名方法
   
    第二种情况： 接口冲突。
        如果一个父接口提供一个默认方法，而另一个接 口也提供了一个具有相同名称和参数列表的方法（不管方法 是否是默认方法），那么必须覆盖该方法来解决冲突，
       （接口中是可以多实现的）
        如果一个类实现多个接口。并且这些接 口提供了一个具有相同名称和参数列表的方法（不管方法 是否是默认方法），那么必须覆盖该方法来解决冲突。子类必须指定覆盖哪个父类接口中的方法。
   
## 3. 接口中的静态方法
   
    调用方式：接口名.方法名();
    
    
# 7 新时间日期API

    Joda Time 第三方时间日期API， 相较于jdk1.7 和之前的日期API， 提供了很多实用的接口和功能， 导致于很少有人实用jdk 自身的日期API，
    从JDK1.8开始， 全新设计的时间日期API， 类似于Joda Time, 提供了很多实用的接口函数。
    
    传统的时间 API 存在线程安全的问题，在多线程开发中必须要上锁，所以 java8 现在为我们提供了一套全新的时间日期 API，
    新的日期API每次改变都是一个新的实例，每个实例都是不可变的，所以新的日期API 是线程安全的

## 1. 使用 LocalDate、LocalTime、LocalDateTime
    
    LocalDate、LocalTime、LocalDateTime类的实例是不可变的对象，分别表示使用 ISO-8601 （ISO-8601 日历系统是国际化组织制定的现代化
    公民的日期和时间的表达法）日历系统的日期、时间、日期和时间。它们提供了简单的日期或时间，并不包含当前时间的时间信息。
    也不包含与时区相关的信息。
    
    LocalDate LocalTime LocalDateTime 三个类的使用方式一样，只是代表的含义不同而已。
    
## 2. 使用 Instant ： 时间戳（以Unix 元年 ： 1970-01-01 00：00：00 到某个时间之间的毫秒数）

   
## 3. Duration 计算两个时间之间的间隔   

## 4. Period 计算两个日期之间的间隔

## 5. 时间校正器

## 6. 时间、日期格式化 DateTimeFormatter

### 6.1 时间转字符串
### 6.2 字符串转时间
   
# 8 重复注解和类型注解
    Java 8对注解处理提供了两点改进：可重复的注解及可用于类型的注解。

