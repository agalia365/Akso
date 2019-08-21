# 1. Java ConcurrentModificationException异常原因和解决方法

​    https://www.cnblogs.com/dolphin0520/p/3933551.html
​    

    Tips: 并行环境下，对于集合的操作，只针对当前集合进行单一操作。避免产生ConcurrentModificationException

# 2. 抽象类 和接口的异同？

    a. 二者的定义：声明的方式， 内部结构（jdk7， jdk8， jdk9）
    b. 共同点： 不能实例化； 以多态的方式使用
    c. 不同点： 单继承， 多实现
    
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
# 3. 面试题：String， StringBuffer， StringBuilder 异同

​    /**
​      * String : JDK8 及之前： 底层使用char[]来存储， JDK9:底层使用byte[] + (encoding flag) 方式
​      * StringBuffer: JDK8 及之前：底层使用char[]来存储，JDK9:底层使用byte[] + (encoding flag)方式
​      * StringBuilder: JDK8 及之前：底层使用char[]来存储，JDK9:底层使用byte[] + (encoding flag)方式
​      * String : 不可变的字符序列
​      * StringBuffer: 可变的字符序列， 线程安全的， 效率低 (多线程情况下使用）
​      * StringBuilder: 可变的字符序列， 线程不安全的， 效率高(jdk5.0) （单线程情况下使用）
​      */
​      

# 4. Stream的理解

 

```java
public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hell", "world", "hello world");

//        list.stream().mapToInt(x -> x.length()).filter(x -> x == 5).findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(x -> {
            System.out.println(x);
            return x.length();
        }).filter( x -> x== 5).findFirst().ifPresent(System.out::println);
        /*** 
         * 输出：　
         * hell
         * world
         * 5
         */
    }

    @Test
    public void test() {
        Stream.generate(() -> 1).limit(10).forEach(System.out::println);
        Stream.iterate(0, (x) -> x + 1);
    }

    @Test
    public void test2() {
// 无限流，因为先做了distinct(), 得到了1, 0，　limit无法终止操作
IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println);


// 先得到6个元素值，　然后进行distinct操作，得到1, 0
IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println);
        
// 输出　0-9 , 10个数字
IntStream.iterate(0, i -> i + 1).limit(10).limit(15).forEach(System.out::println);
        
// 输出 0,1,2 共3个数字
IntStream.iterate(0, i -> i +1).limit(10).limit(15).limit(3).forEach(System.out::println);
        
    }
}
```

5 对局部变量有要求具体如下：

(1)内部类里面使用外部类的局部变量时，其实就是内部类的对象在使用它，内部类对象生命周期中都可能调用它， 而内部类试图访问外部方法中的局部变量时，外部方法的局部变量很可能已经不存在了，那么就得延续其生命， 拷贝到内部类中，而拷贝会带来不一致性，从而需要使用final声明保证一致性。说白了，内部类会自动拷贝外部变量 的引用，为了避免：

外部方法修改引用，而导致内部类得到的引用值不一致
内部类修改引用，而导致外部方法 的参数值在修改前和修改后不一致。于是就用 final 来让该引用不可改变。

(2)内部类通常都含有回调，引用那个匿名内部类的函数执行完了就没了，所以内部类中引用外面的局部变量需要 是final的，这样在回调的时候才能找到那个变量，而如果是外部类的成员变量就不需要是final的，因为内部类本身 都会含有一个外部类的引用（外部类.this），所以回调的时候一定可以访问到

6. final , finally , finalize
在java中，final可以用来修饰类，方法和变量（成员变量或局部变量）
1.1 修饰类

　　当用final修饰类的时，表明该类不能被其他类所继承。当我们需要让一个类永远不被继承，此时就可以用final修饰，但要注意：

final类中所有的成员方法都会隐式的定义为final方法。

1.2 修饰方法

使用final方法的原因主要有两个：

　　(1) 把方法锁定，以防止继承类对其进行更改。

　　(2) 效率，在早期的java版本中，会将final方法转为内嵌调用。但若方法过于庞大，可能在性能上不会有多大提升。因此在最近版本中，不需要final方法进行这些优化了。

final方法意味着“最后的、最终的”含义，即此方法不能被重写。
注意：若父类中final方法的访问权限为private，将导致子类中不能直接继承该方法，因此，此时可以在子类中定义相同方法名的函数，此时不会与重写final的矛盾，而是在子类中重新地定义了新方法。

1.3 修饰变量

 　　final成员变量表示常量，只能被赋值一次，赋值后其值不再改变。类似于C++中的const。

　　当final修饰一个基本数据类型时，表示该基本数据类型的值一旦在初始化后便不能发生变化；如果final修饰一个引用类型时，则在对其初始化之后便不能再让其指向其他对象了，但该引用所指向的对象的内容是可以发生变化的。本质上是一回事，因为引用的值是一个地址，final要求值，即地址的值不发生变化。　

　　final修饰一个成员变量（属性），必须要显示初始化。这里有两种初始化方式，一种是在变量声明的时候初始化；第二种方法是在声明变量的时候不赋初值，但是要在这个变量所在的类的所有的构造函数中对这个变量赋初值。

 

　　当函数的参数类型声明为final时，说明该参数是只读型的。即你可以读取使用该参数，但是无法改变该参数的值。
　在java中，String被设计成final类，那为什么平时使用时，String的值可以被改变呢？

　　字符串常量池是java堆内存中一个特殊的存储区域，当我们建立一个String对象时，假设常量池不存在该字符串，则创建一个，若存在则直接引用已经存在的字符串。当我们对String对象值改变的时候，例如 String a="A"; a="B" 。a是String对象的一个引用（我们这里所说的String对象其实是指字符串常量），当a=“B”执行时，并不是原本String对象("A")发生改变，而是创建一个新的对象("B")，令a引用它。

2. finally

 　　finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。（×）（这句话其实存在一定的问题）

 只有与finally对应的try语句块得到执行的情况下，finally语句块才会执行。以上两种情况在执行try语句块之前已经返回或抛出异常，所以try对应的finally语句并没有执行。

 当一个线程在执行 try 语句块或者 catch 语句块时被打断（interrupted）或者被终止（killed），与其相对应的 finally 语句块可能不会执行。还有更极端的情况，就是在线程运行 try 语句块或者 catch 语句块时，突然死机或者断电，finally 语句块肯定不会执行了。


finalize()是在java.lang.Object里定义的，也就是说每一个对象都有这么个方法。这个方法在gc启动，该对象被回收的时候被调用。其实gc可以回收大部分的对象（凡是new出来的对象，gc都能搞定，一般情况下我们又不会用new以外的方式去创建对象），所以一般是不需要程序员去实现finalize的。 
特殊情况下，需要程序员实现finalize，当对象被回收的时候释放一些资源，比如：一个socket链接，在对象初始化时创建，整个生命周期内有效，那么就需要实现finalize，关闭这个链接。 
　　使用finalize还需要注意一个事，调用super.finalize();

　　一个对象的finalize()方法只会被调用一次，而且finalize()被调用不意味着gc会立即回收该对象，所以有可能调用finalize()后，该对象又不需要被回收了，然后到了真正要被回收的时候，因为前面调用过一次，所以不会调用finalize()，产生问题。 所以，推荐不要使用finalize()方法，它跟析构函数不一样。

# 5.  算法

1、排序都有哪几种方法？

2、会写常用的排序算法，如快排，归并等。

3、各种排序算法的时间复杂度和稳定性

5、和广度优先搜索

6、最小生成树

7、常见Hash算法，哈希的原理和代价

8、全排列、贪心算法、KMP算法、hash算法

9、一致性Hash算法



# 6. 数据库

2、数据库事务和隔离级别

3、为什么需要锁，锁定分类，锁粒度

4、乐观锁，悲观锁的概念及实现方式5、分页如何实现（Oracle，MySql）

6、Mysql引擎

7、MYSQL语句优化

8、从一张大表读取数据，如何解决性能问题

9、内连接，左连接，右连接作用及区别

10、索引以及索引的实现(B+树介绍、和B树、R树区别

# 7. 多线程

1、进程和线程的区别

2、并行和并发的区别和联系

3、同步与异步

5、什么叫守护线程

6、如何停止一个线程？

7、什么是线程安全？synchronized和 lock的区别synchronized

8、启动一个线程是用run还是start?

9、wait和sleep的区别

10、notify和notifyAll的区别

11、线程池的作用

12、Java中线程池相关的类



# ８．web安全

1、什么是SQL注入 ，如何避免。

2、什么是XSS攻击，如何避免

3、什么是CSRF攻击，如何避免

# 9. 动态代理

1、Java的动态代理的概念

2、Java的动态代理的实现

# 10. 编码问题

1、常用的字符编码

2、如何解决中文乱码问题

https://blog.csdn.net/zzhuan_1/article/details/82584684