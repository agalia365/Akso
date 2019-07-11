# 					JDK10 新特性

# 1. 局部变量类型推断

var：保留类型。不是关键字

```java
	/**
     * 该特性注意点：
     * 1. 只针对局部变量
     * 2. var 是保留类型不是关键字，意味着我们还可以用var来定义变量名和方法名
     * 3. var 不允许赋值null
     * @param args
     */
    public static void main(String[] args) {
        var i = 10;
        var str = "abc";
        var list = new ArrayList<>();
        list.add("tom");
        var set = new HashSet<>();
        set.add("Jim");
        var map = new HashMap<String, String>();
        map.put("name", "Lee");

        System.out.println(i);
        System.out.println(str);
        System.out.println(list);
        System.out.println(set);
        map.forEach((k, v) -> System.out.println(k + " -" + v));

        for(Map.Entry<String, String> entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            System.out.println(key + "-" + value);
        }
    }
```



# 2. 垃圾收集器的优化

jdk9: 新生代： ParNew收集器。 老年代：Parallel Old收集器

Stop The World

JDK10： G1 收集器（Garbage—First) = 全收集器



# 3. 新增了73个新功能扩展API类库

在java.util.List, java.util.Set, java.util.Map 新增加了一个copyOf

## 3.1 CopyOf 返回的新的集合是不可修改的

```java
public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        var list2 = List.copyOf(list);
        list2.stream().forEach(System.out::println);

        var set = new HashSet<>();
        set.add("a");
        set.add("b");

        var set2 = Set.copyOf(set);
        System.out.println(set2);

        var map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");

        var map2 = Map.copyOf(map);
        System.out.println(map2);
    }
```



## 3.2 java.io.ByteArrayOutputStream:toString(CharSet)

重载toString()方法， 通过使用指定的字符集编码字节， 将缓冲区的内容转换为字符串

```java
	/**
 	* java.io.ByteArrayOutputStream.toString(charset)
 	*/
	public static void main(String[] args) throws UnsupportedEncodingException {
        var str = "我是中国人";

        ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("gbk"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int c = 0;
        while((c = bis.read()) != -1) {
            bos.write(c);
        }
        // bos.toString()默认使用的是UTF-8
        System.out.println(bos.toString("gbk"));
    }
```

## 3.3 java.io.PrintStream, java.io.PrintWriter

这2个类新增了3个新的构造方法， 他们需要额外的参数 charset

```java
/**
 * java.io.PrintStream, java.io.PrintWriter 新增了构造方法
 */
public class CharSetTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        var str = "我是中国人";
        var p = new PrintStream("D:/aa.txt", "UTF-8");
        p.print(str);
        p.flush();
        p.close();
    }
}
```

## 3.4 java.io.Reader.transferTo方法

从这个Reader中读取所有的字符串， 并按照所读取的顺序将字符串写入给指定的writer

```java
/**
 * Reader.transferTo方法
 */
public class ReaderTest {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:/aa.txt"), "UTF-8"));
        var p = new PrintWriter(new FileOutputStream("D:/cc.txt"));
        reader.transferTo(p);
        p.flush();
        p.close();
        reader.close();
    }
}
```

3.5 java.util.Formatter, java.util.Scanner

新增3个构造方法， 除了其他参数以外，都需要一个charset参数

```java
/**
 * java.util.Formatter, java.util.Scanner
 */
public class ScannerTest {
    public static void main(String[] args) throws FileNotFoundException {
        var scan = new Scanner(new FileInputStream(new File("D:/aa.txt")), "UTF-8");
//        while(scan.hasNext()) {
//            System.out.println(scan.nextLine());
//        }
        scan.useDelimiter(",| ");
        while(scan.hasNext()) {
            System.out.println(scan.next());
        }
    }
}
```