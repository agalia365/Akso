面试基础题：

１．String,StringBuffer, StringBuilder 的区别是什么？String为什么是不可变的？

1. String是字符串常量，StringBuffer和StringBuilder是字符串变量。StringBuffer是线程安全的，StringBuilder是非线程安全的。具体来说String是一个不可变的对象，每次修改String对象实际上是创新新对象，并将引用指向新对象。效率很低。StringBuffer

   是可变的，即每次修改只是针对其本身，大部分情况下比String效率高，StringBuffer保证同步（synchronized），所以线程安全。StringBuilder没有实现同步，所以非线程安全。但效率应该比StringBuffer高。StringBuffer使用时最好指定容量，这样会比不指定容量快30%-40%，甚至比不指定容量的StringBuilder还快。