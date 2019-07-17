# 1. Java ConcurrentModificationException异常原因和解决方法

​    https://www.cnblogs.com/dolphin0520/p/3933551.html
​    

    Tips: 并行环境下，对于集合的操作，只针对当前集合进行单一操作。避免产生ConcurrentModificationException

## 2. 抽象类 和接口的异同？

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
# 3.面试题：String， StringBuffer， StringBuilder 异同

​    /**
​      * String : JDK8 及之前： 底层使用char[]来存储， JDK9:底层使用byte[] + (encoding flag) 方式
​      * StringBuffer: JDK8 及之前：底层使用char[]来存储，JDK9:底层使用byte[] + (encoding flag)方式
​      * StringBuilder: JDK8 及之前：底层使用char[]来存储，JDK9:底层使用byte[] + (encoding flag)方式
​      * String : 不可变的字符序列
​      * StringBuffer: 可变的字符序列， 线程安全的， 效率低 (多线程情况下使用）
​      * StringBuilder: 可变的字符序列， 线程不安全的， 效率高(jdk5.0) （单线程情况下使用）
​      */
​      

#  4. Stream的理解

 

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

对局部变量有要求具体如下：

(1)内部类里面使用外部类的局部变量时，其实就是内部类的对象在使用它，内部类对象生命周期中都可能调用它， 而内部类试图访问外部方法中的局部变量时，外部方法的局部变量很可能已经不存在了，那么就得延续其生命， 拷贝到内部类中，而拷贝会带来不一致性，从而需要使用final声明保证一致性。说白了，内部类会自动拷贝外部变量 的引用，为了避免：

外部方法修改引用，而导致内部类得到的引用值不一致
内部类修改引用，而导致外部方法 的参数值在修改前和修改后不一致。于是就用 final 来让该引用不可改变。

(2)内部类通常都含有回调，引用那个匿名内部类的函数执行完了就没了，所以内部类中引用外面的局部变量需要 是final的，这样在回调的时候才能找到那个变量，而如果是外部类的成员变量就不需要是final的，因为内部类本身 都会含有一个外部类的引用（外部类.this），所以回调的时候一定可以访问到