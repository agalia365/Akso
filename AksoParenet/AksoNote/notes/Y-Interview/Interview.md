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