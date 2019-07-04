
                                               Java 8 新特性

# 1 Java 8 新特性简介

# 2 Lambda 表达式
    目标：
    什么是闭包？
    Lambda表达式如何写？
    什么是函数接口？
    类型推断在Lambda中的体现。
## 1. 定义： 

    Lambda: In programming languages such as Lisp, Python and Ruby lambda is an operator used to denote anonymous functions or closures,
    following the usage of lambda calculus.
    
    Lambda表达式为java添加了缺失的函数式编程特性， 使我们能将函数当做一等公民看
    在将函数作为一等公民的语言中， Lambda 表达式的类型是函数。 但是在java 中， Lambda表达式是对象， 他们
    必须依附于一类特别的对象类型---函数式接口（functional interface）
##2. Lambda 表达式的作用 ： 
    传递行为， 而不仅仅是值， 提升抽象层次， API 重用性更好， 更加灵活 

##3. lambda表达式的语法

    由参数列表->和函数体组成。函数体既可以是一个表达式，也可以是一个语句块：
    
    表达式：表达式会被执行然后返回执行结果。
    语句块：语句块中的语句会被依次执行，就像方法中的语句一样
    return语句会把控制权交给匿名方法的调用者
    break和continue只能在循环中使用
    如果函数体有返回值，那么函数体内部的每一条路径都必须返回值
    表达式函数体适合小型lambda表达式，它消除了return关键字，使得语法更加简洁。
    
     a. Lambda表达式不包含参数，使用空括号 ()表示没有参数。
        （） -> System.out.println("hello world"); 
     b. 包含一个参数且主体为表达式 
        (x) -> x + 2;
     c. 包含多个参数且主体为表达式
        (x, y) -> x + y;
     d. 包含多个参数且主体为代码段
        (x, y) -> {
                if (x > y) {
                    return x;
                } else {
                    return y;
                }
            };
     e. 包含多个参数，指定参数类型且主体为代码段
        (int x, int y) -> x - y;
### 4. 引用值， 而不是变量
     在使用内部类时，我们总是碰到这种情况，需要引用内部类外面的变量，
     比如其所在方法内的变量，或者该类的全局变量。
     当使用方法内的变量时，需要将变量声明为final。
     此时，将变量声明为final， 意味着不能为其重复赋值，
     同时在匿名内部，实际上是用的使用赋给该变量的一个
     特定的值。
     在Lambda表达式中，也是同样的问题，对于其方法体内引用的外部变量，在Lambda表达式所在方法内对变量再次赋值时，
     编译器会报同样的错误。也就是意味着，换句话说，Lambda表达式引用的是值，而不是变量
     
     这种行为也解释了为什么Lambda表达式也被称为闭包。未赋值的变量与周边环境隔离起来，
     进而被绑定到一个特定的值。在Java 8中引入了闭包这一概念，并将其使用在了Lambda表达式中。
     众说纷纭的计算机编程语言圈子里，Java是否拥有真正的闭包一直备受争议，因为在 Java 中只能引用既成事实上的final变量。
     可以肯定的是，Lambda表达式都是静态类型。
            
## 2. 关于函数式接口：
    函数式接口是什么呢？函数式接口(Functional Interface)是Java 8对一类特殊类型的接口的称呼。这类接口只定义了唯一的抽象方法的接口（除了隐含的Object对象的公共方法），用作Lambda表达式的类型。
   
    1. 如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口
    2. 如果我们在某个接口上声明了FunctionalInterface注解，那么编译器就会按照函数式接口定义来要求该接口
    3. 如果某个接口只有一个抽象方法， 但是我们并没有给该接口声明FunctionalInterface注解，那么编译器依旧会将该接口看作是函数式接口

    高阶函数： -高阶函数英文叫Higherorder function ，如果一个函数接受一个函数作为参数，或者返回一个函数作为返回值，这样的函数称为高阶函数
    函数式编程就是指这种高度抽象的编程范式。
    
    Suppplier 接口，　
    
## 3. Function 与 BiFunction
       
    

## 4. 
    

# 3 方法引用与构造器引用　method reference

    方法引用实际上是ｌａｍｂｄａ　表达式的一种语法糖
    我们可以将方法引用看做是一个【函数指针】，　function point
    
    方法引用一共分为四类：
    
    １．　类名：：静态方法名
          classname::staticmethod // 方法应用的方式， 不需要传入任何参数
          classname.staticmethod // 原来的静态方法调用方式， 可传入参数
    2. 引用名（对象名） :: 实例方法名
    
    3. 类名::实例方法名
    
    4. 构造方法引用： 类名::new
# 4 Stream流【】

流本身不存储值， 通过管道的方式获取值
本质是函数式的， 对流的操作会生成一个结果， 不过并不会修改底层的数据源，集合可以作为流的底层数据源
延迟查找，很多流查找（过滤，映射， 排序等） 都可以延迟实现。

map - flatmap
map - reduce
collectors
无限流，

IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(6).forEach(System.out::println); // 无限流， 程序一直运行，不会退出
IntStream.iterate(0, i -> (i + 1) % 2).limit(6).distinct().forEach(System.out::println); // 程序被限制为取6个元素， 程序会正常结束

内部迭代和外部迭代

集合关注的是数据与数据存储本身
流关注的则是对数据的计算
流与迭代器类似的一点事： 流是无法重复使用或消费的。

中间操作都会返回一个Stream 对象，比如说返回Stream<Student>, Stream<Integer>, Stream<String> ...
终止操作都不会返回Stream对象。可能不返回值, 也可能返回其他类型的的单个值, 例如，min，max，count， reduce.....

区分中间操作还是终止操作的主要判断依据就是看返回值类型，如果是Stream 类型的，那必定是中间操作。

Collector 接口源码: 
    
    /**
     * A <a href="package-summary.html#Reduction">mutable reduction operation</a> that
     * accumulates input elements into a mutable result container, optionally transforming
     * the accumulated result into a final representation after all input elements
     * have been processed.  Reduction operations can be performed either sequentially
     * or in parallel.
     *
     * <p>Examples of mutable reduction operations include:
     * accumulating elements into a {@code Collection}; concatenating
     * strings using a {@code StringBuilder}; computing summary information about
     * elements such as sum, min, max, or average; computing "pivot table" summaries
     * such as "maximum valued transaction by seller", etc.  The class {@link Collectors}
     * provides implementations of many common mutable reductions.
     *
     * <p>A {@code Collector} is specified by four functions that work together to
     * accumulate entries into a mutable result container, and optionally perform
     * a final transform on the result.  They are: <ul>
     *     <li>creation of a new result container ({@link #supplier()})</li>
     *     <li>incorporating a new data element into a result container ({@link #accumulator()})</li>
     *     <li>combining two result containers into one ({@link #combiner()})</li>
     *     <li>performing an optional final transform on the container ({@link #finisher()})</li>
     * </ul>
     *
     * <p>Collectors also have a set of characteristics, such as
     * {@link Characteristics#CONCURRENT}, that provide hints that can be used by a
     * reduction implementation to provide better performance.
     *
     * <p>A sequential implementation of a reduction using a collector would
     * create a single result container using the supplier function, and invoke the
     * accumulator function once for each input element.  A parallel implementation
     * would partition the input, create a result container for each partition,
     * accumulate the contents of each partition into a subresult for that partition,
     * and then use the combiner function to merge the subresults into a combined
     * result.
     *
     * <p>To ensure that sequential and parallel executions produce equivalent
     * results, the collector functions must satisfy an <em>identity</em> and an
     * <a href="package-summary.html#Associativity">associativity</a> constraints.
     *
     * <p>The identity constraint says that for any partially accumulated result,
     * combining it with an empty result container must produce an equivalent
     * result.  That is, for a partially accumulated result {@code a} that is the
     * result of any series of accumulator and combiner invocations, {@code a} must
     * be equivalent to {@code combiner.apply(a, supplier.get())}.
     *
     * <p>The associativity constraint says that splitting the computation must
     * produce an equivalent result.  That is, for any input elements {@code t1}
     * and {@code t2}, the results {@code r1} and {@code r2} in the computation
     * below must be equivalent:
     * <pre>{@code
     *     A a1 = supplier.get();
     *     accumulator.accept(a1, t1);
     *     accumulator.accept(a1, t2);
     *     R r1 = finisher.apply(a1);  // result without splitting
     *
     *     A a2 = supplier.get();
     *     accumulator.accept(a2, t1);
     *     A a3 = supplier.get();
     *     accumulator.accept(a3, t2);
     *     R r2 = finisher.apply(combiner.apply(a2, a3));  // result with splitting
     * } </pre>
     *
     * <p>For collectors that do not have the {@code UNORDERED} characteristic,
     * two accumulated results {@code a1} and {@code a2} are equivalent if
     * {@code finisher.apply(a1).equals(finisher.apply(a2))}.  For unordered
     * collectors, equivalence is relaxed to allow for non-equality related to
     * differences in order.  (For example, an unordered collector that accumulated
     * elements to a {@code List} would consider two lists equivalent if they
     * contained the same elements, ignoring order.)
     *
     * <p>Libraries that implement reduction based on {@code Collector}, such as
     * {@link Stream#collect(Collector)}, must adhere to the following constraints:
     * <ul>
     *     <li>The first argument passed to the accumulator function, both
     *     arguments passed to the combiner function, and the argument passed to the
     *     finisher function must be the result of a previous invocation of the
     *     result supplier, accumulator, or combiner functions.</li>
     *     <li>The implementation should not do anything with the result of any of
     *     the result supplier, accumulator, or combiner functions other than to
     *     pass them again to the accumulator, combiner, or finisher functions,
     *     or return them to the caller of the reduction operation.</li>
     *     <li>If a result is passed to the combiner or finisher
     *     function, and the same object is not returned from that function, it is
     *     never used again.</li>
     *     <li>Once a result is passed to the combiner or finisher function, it
     *     is never passed to the accumulator function again.</li>
     *     <li>For non-concurrent collectors, any result returned from the result
     *     supplier, accumulator, or combiner functions must be serially
     *     thread-confined.  This enables collection to occur in parallel without
     *     the {@code Collector} needing to implement any additional synchronization.
     *     The reduction implementation must manage that the input is properly
     *     partitioned, that partitions are processed in isolation, and combining
     *     happens only after accumulation is complete.</li>
     *     <li>For concurrent collectors, an implementation is free to (but not
     *     required to) implement reduction concurrently.  A concurrent reduction
     *     is one where the accumulator function is called concurrently from
     *     multiple threads, using the same concurrently-modifiable result container,
     *     rather than keeping the result isolated during accumulation.
     *     A concurrent reduction should only be applied if the collector has the
     *     {@link Characteristics#UNORDERED} characteristics or if the
     *     originating data is unordered.</li>
     * </ul>
     *
     * <p>In addition to the predefined implementations in {@link Collectors}, the
     * static factory methods {@link #of(Supplier, BiConsumer, BinaryOperator, Characteristics...)}
     * can be used to construct collectors.  For example, you could create a collector
     * that accumulates widgets into a {@code TreeSet} with:
     *
     * <pre>{@code
     *     Collector<Widget, ?, TreeSet<Widget>> intoSet =
     *         Collector.of(TreeSet::new, TreeSet::add,
     *                      (left, right) -> { left.addAll(right); return left; });
     * }</pre>
     *
     * (This behavior is also implemented by the predefined collector
     * {@link Collectors#toCollection(Supplier)}).
     *
     * @apiNote
     * Performing a reduction operation with a {@code Collector} should produce a
     * result equivalent to:
     * <pre>{@code
     *     R container = collector.supplier().get();
     *     for (T t : data)
     *         collector.accumulator().accept(container, t);
     *     return collector.finisher().apply(container);
     * }</pre>
     *
     * <p>However, the library is free to partition the input, perform the reduction
     * on the partitions, and then use the combiner function to combine the partial
     * results to achieve a parallel reduction.  (Depending on the specific reduction
     * operation, this may perform better or worse, depending on the relative cost
     * of the accumulator and combiner functions.)
     *
     * <p>Collectors are designed to be <em>composed</em>; many of the methods
     * in {@link Collectors} are functions that take a collector and produce
     * a new collector.  For example, given the following collector that computes
     * the sum of the salaries of a stream of employees:
     *
     * <pre>{@code
     *     Collector<Employee, ?, Integer> summingSalaries
     *         = Collectors.summingInt(Employee::getSalary))
     * }</pre>
     *
     * If we wanted to create a collector to tabulate the sum of salaries by
     * department, we could reuse the "sum of salaries" logic using
     * {@link Collectors#groupingBy(Function, Collector)}:
     *
     * <pre>{@code
     *     Collector<Employee, ?, Map<Department, Integer>> summingSalariesByDept
     *         = Collectors.groupingBy(Employee::getDepartment, summingSalaries);
     * }</pre>
     *
     * @see Stream#collect(Collector)
     * @see Collectors
     *
     * @param <T> the type of input elements to the reduction operation
     * @param <A> the mutable accumulation type of the reduction operation (often
     *            hidden as an implementation detail)
     * @param <R> the result type of the reduction operation
     * @since 1.8
     */
    public interface Collector<T, A, R> {
        /**
         * A function that creates and returns a new mutable result container.
         *
         * @return a function which returns a new, mutable result container
         */
        Supplier<A> supplier();
    
        /**
         * A function that folds a value into a mutable result container.
         *
         * @return a function which folds a value into a mutable result container
         */
        BiConsumer<A, T> accumulator();
    
        /**
         * A function that accepts two partial results and merges them.  The
         * combiner function may fold state from one argument into the other and
         * return that, or may return a new result container.
         *
         * @return a function which combines two partial results into a combined
         * result
         */
        BinaryOperator<A> combiner();
    
        /**
         * Perform the final transformation from the intermediate accumulation type
         * {@code A} to the final result type {@code R}.
         *
         * <p>If the characteristic {@code IDENTITY_TRANSFORM} is
         * set, this function may be presumed to be an identity transform with an
         * unchecked cast from {@code A} to {@code R}.
         *
         * @return a function which transforms the intermediate result to the final
         * result
         */
        Function<A, R> finisher();
    
        /**
         * Returns a {@code Set} of {@code Collector.Characteristics} indicating
         * the characteristics of this Collector.  This set should be immutable.
         *
         * @return an immutable set of collector characteristics
         */
        Set<Characteristics> characteristics();
    
        /**
         * Returns a new {@code Collector} described by the given {@code supplier},
         * {@code accumulator}, and {@code combiner} functions.  The resulting
         * {@code Collector} has the {@code Collector.Characteristics.IDENTITY_FINISH}
         * characteristic.
         *
         * @param supplier The supplier function for the new collector
         * @param accumulator The accumulator function for the new collector
         * @param combiner The combiner function for the new collector
         * @param characteristics The collector characteristics for the new
         *                        collector
         * @param <T> The type of input elements for the new collector
         * @param <R> The type of intermediate accumulation result, and final result,
         *           for the new collector
         * @throws NullPointerException if any argument is null
         * @return the new {@code Collector}
         */
        public static<T, R> Collector<T, R, R> of(Supplier<R> supplier,
                                                  BiConsumer<R, T> accumulator,
                                                  BinaryOperator<R> combiner,
                                                  Characteristics... characteristics) {
            Objects.requireNonNull(supplier);
            Objects.requireNonNull(accumulator);
            Objects.requireNonNull(combiner);
            Objects.requireNonNull(characteristics);
            Set<Characteristics> cs = (characteristics.length == 0)
                                      ? Collectors.CH_ID
                                      : Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.IDENTITY_FINISH,
                                                                               characteristics));
            return new Collectors.CollectorImpl<>(supplier, accumulator, combiner, cs);
        }
    
        /**
         * Returns a new {@code Collector} described by the given {@code supplier},
         * {@code accumulator}, {@code combiner}, and {@code finisher} functions.
         *
         * @param supplier The supplier function for the new collector
         * @param accumulator The accumulator function for the new collector
         * @param combiner The combiner function for the new collector
         * @param finisher The finisher function for the new collector
         * @param characteristics The collector characteristics for the new
         *                        collector
         * @param <T> The type of input elements for the new collector
         * @param <A> The intermediate accumulation type of the new collector
         * @param <R> The final result type of the new collector
         * @throws NullPointerException if any argument is null
         * @return the new {@code Collector}
         */
        public static<T, A, R> Collector<T, A, R> of(Supplier<A> supplier,
                                                     BiConsumer<A, T> accumulator,
                                                     BinaryOperator<A> combiner,
                                                     Function<A, R> finisher,
                                                     Characteristics... characteristics) {
            Objects.requireNonNull(supplier);
            Objects.requireNonNull(accumulator);
            Objects.requireNonNull(combiner);
            Objects.requireNonNull(finisher);
            Objects.requireNonNull(characteristics);
            Set<Characteristics> cs = Collectors.CH_NOID;
            if (characteristics.length > 0) {
                cs = EnumSet.noneOf(Characteristics.class);
                Collections.addAll(cs, characteristics);
                cs = Collections.unmodifiableSet(cs);
            }
            return new Collectors.CollectorImpl<>(supplier, accumulator, combiner, finisher, cs);
        }
    
        /**
         * Characteristics indicating properties of a {@code Collector}, which can
         * be used to optimize reduction implementations.
         */
        enum Characteristics {
            /**
             * Indicates that this collector is <em>concurrent</em>, meaning that
             * the result container can support the accumulator function being
             * called concurrently with the same result container from multiple
             * threads.
             *
             * <p>If a {@code CONCURRENT} collector is not also {@code UNORDERED},
             * then it should only be evaluated concurrently if applied to an
             * unordered data source.
             */
            CONCURRENT,
    
            /**
             * Indicates that the collection operation does not commit to preserving
             * the encounter order of input elements.  (This might be true if the
             * result container has no intrinsic order, such as a {@link Set}.)
             */
            UNORDERED,
    
            /**
             * Indicates that the finisher function is the identity function and
             * can be elided.  If set, it must be the case that an unchecked cast
             * from A to R will succeed.
             */
            IDENTITY_FINISH
        }
    }


    当结果容器和中间容器一直的时候，ｆｉｎｉｓｈｅｒ方法不被执行，程序直接返回中间容器类型

    ### 6 Comparator
    
    thenComparing，　只有当前一个比较器比较结果相等的时候才会去执行thenComparing的比较，　
    换句话说，当第一个比较器已经能确定比较顺序的时候，不需要去执行第二个比较器
    
    
    



# 5 Optional容器类

    Optional 没有序列化，　不要将optional 作为参数或者成员变量来使用
    Optional value-based 没有公有的构造器方法，　只有私有的构造器。
    
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
        如果一个父接口提供一个默认方法，而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法 是否是默认方法），那么必须覆盖该方法来解决冲突，
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

