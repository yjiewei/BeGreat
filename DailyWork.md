# 知识星球-猿灯塔-每日一题

# June

## 6.1

下面有关java final的基本规则，描**述错误**的是？ 

A、final修饰的类不能被继承 

**B、final修饰的成员变量只允许赋值一次，且只能在类方法赋值** 

C、final修饰的局部变量即为常量，只能赋值一次。 

D、final修饰的方法不允许被子类覆盖 

**答案：B** 

final修饰的成员变量为基本数据类型是，在赋值之后无法改变。一次赋值

当final修饰的成员变量为引用数据类型时，在赋值后其指向地址无法改变，但是对象内容还是可以改变的。 

final修饰的成员变量在赋值时可以有三种方式。

1、在声明时直接赋值。

2、在构造器中赋值。

3、在初始代码块中进行赋值。



## 6.2

如果一个list初始化为{5，3，1}，执行以下代码后，其结果为（）？ 

nums.add(6); 

nums.add(0,4); 

nums.remove(1);    **1号索引 不是数字1**

A、 [5, 3, 1, 6] 

**B、 [4, 3, 1, 6]** 

C、 [4, 3, 6] 

D、 [5, 3, 6] 

答案：**B** 

初始化为{5,3,1} 

nums.add(6)后list为{5,3,1,6}

nums.add(0,4)是在0号索引上添加数字4得到list为{4,5,3,1,6} 

nums.remove(1)是将**1号索引**上的5进行remove得到list为{4,3,1,6}



## 6.3

在创建派生类对象，构造函数的执行顺序（） 

**A.基类构造函数，派生类对象成员构造函数，派生类本身的构造函数** 

B.派生类本身的构造函数，基类构造函数，对象成员构造函数 

C.基类构造函数，派生类本身的构造函数，派生类对象成员构造函数

D.对象成员构造函数，基类构造函数，派生类本身的构造函数 

答案: **A** 

对象创建时代码的加载顺序为：静态代码 --> 非静态代码 --> 构造方法。若继承了父类，则加载顺序为：父类的静态的代码 --> 子类的静态的代码 --> 父类内部非静态代码 --> 父类的构造方法 --> 子类的非静态代码 --> 子类的构造方法。



## 6.4

**关于protected 修饰的成员变量，以下说法正确的是** 

**A、**可以被该类自身、与它在同一个包中的其它类、在其它包中的该类的子类所访问

B、只能被该类本身和该类的所有的子类访问 

C、只能被该类自身所访问   

D、只能被同一个包中的类访问 

**答案：A** 

1、protected访问控制符能被用于方法和成员变量。 

2、声明为protected的方法和成员变量能被同一个包里的所有类所访问，就像默认修饰符package一样。 

3、能被该类的子类所访问，子类可以和父类不在一个包中。

![img](https://iknow-pic.cdn.bcebos.com/cdbf6c81800a19d865fd770a3efa828ba71e46c7?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1)

------

## 6.5

**问：以下哪个区域不属于新生代？** 

A、eden区 

B、from区 

**C**、元数据区 

D、to区 

**答案：C** 

eden : from : to =8:1:1，用于新生代垃圾回收。

元数据区是用来替换永久代的，大概那个意思。

引入元数据区的意义：JDK8引入了一个新的native的内存区块，Metaspace（也就是题主所说的“元数据”区域）。也就是说，之后你在调优或者调查JVM问题的时候就不用和PermGen区域打交道了，也不会有java.lang.OutOfMemoryError: PermGen 这种内存不足的问题来骚扰你。



------

## 6.6

**开闭原则相关的面向对象设计原则（）多选题哦** 

A、里氏代换原则(Liskov Substitution Principle LSP) 

B、依赖倒转原则（Dependence Inversion Principle） 

C、接口隔离原则（Interface Segregation Principle） 

D、复用原则 

答案: A B C 

面向对象共有六大原则：开闭原则、单一职责原则、里式替换原则、依赖倒置原则、接口隔离原则、迪米特法则。 

开闭原则：开闭原则的定义是软件中的对象(类，模块，函数等)应该对于扩展是开放的，但是对于修改是关闭的。

 单一职责原则：就一个类而言，应该仅有一个引起他变化的原因。也就是说一个类应该只负责一件事情。 

里式替换原则：“子类能够替换基类，否则不应当设计为其子类。”也就是说，子类只能去扩展基类，而不是隐藏或覆盖基类。 

依赖倒置原则：模块间的依赖是通过抽象来发生的，实现类之间不发生直接的依赖关系，其依赖关系是通过接口是来实现的。 

接口隔离原则：客户端不应该依赖他不需要的接口。 

迪米特法则：一个对象应该对其他对象保持最小的了解。

------



## 6.7

**哪个存储引擎执行 select count(*) 更快，为什么?**  MyISAM 还是InnoDB

 答：MyISAM更快，因为MyISAM内部维护了一个计数器，可以直接调取。 **在 MyISAM 存储引擎中，把表的总行数存储在磁盘上**，当执行 select count(*) from t 时，直接返回总数据。 在 InnoDB 存储引擎中，跟 MyISAM 不一样，没有将总行数存储在磁盘上，当执行 select count(*) from t 时，会先把数据读出来，一行一行的累加，最后返回总数量。 **InnoDB 中 count(*) 语句是在执行的时候，全表扫描统计总数量**，所以当数据越来越大时，语句就越来越耗时了，为什么 InnoDB 引擎不像 MyISAM 引擎一样，将总行数存储到磁盘上？这跟 InnoDB 的事务特性有关，由于多版本并发控制（MVCC）的原因，InnoDB 表“应该返回多少行”也是不确定的



## 6.8

以下选项中哪些是使用消息中间件后带来的问**题(缺点)？** 

A.应用解耦 

**B.增加系统的复杂性** 

C.消息处理异步 

**D.消息不一致** 

答案：**B,D** 加入消息中间件后，增加了模块，并且消息中间件的可用和稳定性都需要维护，所以提高了了系统的复杂度。 如果当消费者成功从消息中间件中接收到消息，但是在消息的处理过程中出现了异常，则会出现数据丢失，从而导致了消息不一致。



## 6.9

**下面有关java threadlocal说法正确的有？ 全部**

A、ThreadLocal存放的值是线程封闭，线程间互斥的，主要用于线程内共享一些数据，避免通过参数来传递 

B、线程的角度看，每个线程都保持一个对其线程局部变量副本的隐式引用，只要线程是活动的并且 ThreadLocal 实例是可访问的；在线程消失之后，其线程局部实例的所有副本都会被垃圾回收 

C、在Thread类中有一个Map，用于存储每一个线程的变量的副本。 

D、对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式 

**答案：A B C D** 

ThreadLocal类用于创建一个线程本地变量 

在Thread中有一个成员变量ThreadLocals，该变量的类型是ThreadLocalMap,也就是一个Map，它的键是threadLocal，值就是变量的副本，ThreadLocal为每一个使用该变量的线程都提供了一个变量值的副本，每一个线程都可以独立地改变自己的副本，是线程隔离的。通过ThreadLocal的get()方法可以获取该线程变量的本地副本，在get方法之前要先set,否则就要重写initialValue()方法。 

ThreadLocal不是用来解决对象共享访问问题的，而主要是提供了保持对象的方法和避免参数传递的方便的对象访问方式。一般情况下，通过ThreadLocal.set() 到线程中的对象是该线程自己使用的对象，其他线程是不需要访问的，也访问不到的。各个线程中访问的是不同的对象。



## 6.10

下面字段声明中哪一个在interface主体内是合法的? （） 

A、 private final static int answer = 42; 

**B、 public static int answer = 42;** 

C、 final static answer = 42; 

D、 int answer; 

答案**：B** 

接口中的属性在不提供修饰符修饰的情况下，会自动加上public static final 注意（在1.8的编译器下可试）： （1）属性不能用private，protected,default 修饰，因为默认是public 

（2）如果属性是基本数据类型，需要赋初始值，若是引用类型，也需要初始化，因为**默认有final修饰，必须赋初始值；** 

（3）接口中常规的来说不能够定义方法体，所以无法通过get和set方法获取属性值，所以属性不属于对象，属于类（接口），因为默认使用static修饰。



## 6.11

以下代码的输出结果是？ 

```java
/*
 * @author yangjiewei
 * @date 2020/6/11 10:02
 */
package yangjiewei.volatile1;

public class B
{
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        B t = new B();
    }
}

```

A.静态块 构造块 构造块 构造块 

B.构造块 静态块 构造块 构造块 

**C.构造块 构造块 静态块 构造块** 

D.构造块 构造块 构造块 静态块

**答：**开始时JVM加载B.class，对所有的静态成员进行声明，t1 t2被初始化为默认值，为null，又因为t1 t2需要被显式初始化，所以对t1进行显式初始化，初始化代码块→构造函数（没有就是调用默认的构造函数），咦！静态代码块咋不初始化？因为在开始时已经对static部分进行了初始化，虽然只对static变量进行了初始化，但在初始化t1时也不会再执行static块了，因为JVM认为这是第二次加载类B了，所以static会在t1初始化时被忽略掉，所以直接初始化非static部分，也就是构造块部分（输出''构造块''）接着构造函数（无输出）。接着对t2进行初始化过程同t1相同（输出'构造块'），此时就对所有的static变量都完成了初始化，接着就执行static块部分（输出'静态块'），接着执行，main方法，同样也，new了对象，调用构造函数输出（'构造块'）



**静态块是加载类的时候加载，只加载一次。构造快创建对象就会调用一次**



## 6.12

在java中，已定义两个接口B和C，要定义一个实现这两个接口的类，以下语句正确的是（） 

A、 interface  A extends B，C   **这个是继承接口,但是不能多继承**

B、 interface  A implements  B，C 

**C、 class  A implements  B，C** 

D、 class  A implements  B，implements C



## 6.13

以下代码执行的结果显示是多少？ 

```java
public class IncTest {    
    public static void main(String args[]){        
        IncTest inc = new IncTest ();        
        int i = 0;        
        inc.add(i);        
        i = i++;      // 自增之前赋值所以不变  
        System.out.println(i);    
    }    
    void add(int i)  // 基本类型是值传递
    {        
        i++;    
    } 
} 
```



**A. 0**  

B. 1 

C. 2  

D. 3 

答案：**A** 这道题主要考了两个知识点：1、基本数据类型是值传递，所以代码inc.add(i)；执行后并不会影响main方法中变量i的值； 2、代码i=i++执行后，复制给等号左边i的是右边i自增之前的值，也就是说i的值不变。



## 6.14

一张表，里面有ID自增主键，当insert了17条记录之后，删除了第15,16,17条记录，再把Mysql重启，再insert一条记录，这条记录的ID是18还是15 ？   

 **答案：** 如果表的类型是**MyISAM，那么是18。**因为MyISAM表会把自增主键的最大ID 记录到数据文件中，重启MySQL自增主键的最大ID也不会丢失； 

​	如果表的类型是**InnoDB，那么是15。**因为InnoDB 表只是把自增主键的最大ID记录到内存中，所以重启数据库或对表进行OPTION操作，都会导致最大ID丢失。



## 6.15

下列哪一项叙述是正确的？ 

char型字符在Unicode表中的位置范围是0~32767。 

**char型字符在Unicode表中的位置范围是0~65535。** 

char型字符在Unicode表中的位置范围是0~65536。 

char型字符在Unicode表中的位置范围是-32768~32767。

**答案:B**



## 6.16

假设一个 list初始化为{2，9，5，4，8，1}。 在第一次冒泡排序后，list变成了（）? 

A:2, 9, 5, 4, 8, 1 

B:2, 9, 5, 4, 1, 8 

C:2, 5, 9, 4, 8, 1 

**D:2, 5, 4, 8, 1, 9** 

**正确答案：D** 第一次排序后最大的数,转移到数组最后,空位索引后的索引依次-1,结果为D



## 6.17

如果进栈序列为e1，e2，e3，e4，则可能的出栈序列是() 

注：一个元素进栈后可以马上出栈，不用等全部进栈 

A.e3，e1，e4，e2 

B.e2，e4，e3，e1

 C.e2，e3，e4，e1 

D.任意顺序都有可能 

**正确答案：B C** 

栈的规则：先进后出 例如进栈序列为：1，2，3，4 全部进栈完成再出栈的序列则为：4，3，2，1 

注：一个元素进栈后可以马上出栈，不用等全部进栈 

例如：2这个元素一进就想出了，后面的3，4正常进栈再出栈。 那么出栈顺序就是：2，4，3，1  

(1是第一个进的，进的时候也没有立刻出去，所以被压在栈底，最后才能出去） 

例如：2这个元素一进就想出了，后面的3一进也想立刻想出去了，后面的4跟着进栈 

那么出栈顺序就是：2，3，4，1  

(2，3都进了立刻出 所以这时4压着的是1，所以出栈顺序是4在前面）



## 6.18

关于java中的数组，下面的一些描述，哪些描述是准确的：（） 

A.数组是一个对象，不同类型的数组具有不同的类 

B.数组长度是可以动态调整的   **错**

C.数组是一个连续的存储结构 

D.一个固定长度的数组可类似这样定义：int array[100] 

E.两个数组用equals方法比较时，会逐个便利其中的元素，对每个元素进行比较 

F.可以二维数组，且可以有多维数组，都是在java中合法的。 

**答案：ACF**  

数组的长度是固定的，不可动态扩充，虽然可以扩容但是也是重新申请一个新的数组，以此达到扩容的目的。

固定长度的数组定义：int[] arr = new int[];

基本数据类型的数组的equals方法没有重载Object的equals方法，所以跟“==”效果一样,(比较的是两个数组的内存地址)

如果想要比较内容相同，可以使用Arrays.equals(ch,c)，或者将数组转换成string后在用equlas方法进行比较.





## String

==是比较对象的引用地址，如果要比较对象的值的话用equal

![img](https://iknow-pic.cdn.bcebos.com/574e9258d109b3deb5afbf73c3bf6c81800a4c9c?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1)

s1 和s2的引用地址是相同的，所s1==s2为true    s1==s3为false



## 6.19

4、关于java集合下列说法不正确的有哪些（）

**正确答案: A B D**  
A、HashSet 它是线程安全的，不允许存储相同的对象
B、ConcurrentHashMap 它是线程安全的，其中存储的键对象可以重复，值对象不能重复
**C、Collection接口是List接口和Set接口的父接口，通常情况下不被直接使用**
D、ArrayList线程安全的，允许存放重复对象

解析：线程安全(Thread-safe)的集合对象：Vector 线程安全，HashTable 线程安全，StringBuffer 线程安全，

非线程安全的集合对象：ArrayList ：LinkedList：HashMap：HashSet：TreeMap：TreeSet：StringBulider



## 6.20

下列容器中，哪些容器按 key 查找的复杂度为 O(log(n)) （） 

A:std::unordered_set 

B:std::multimap 

C:std::map 

D:std::deque 

**正确答案：B C** 

STL库中，map和multimap底层都是红黑树实现的，两者的不同在于multimap允许重复的可以，而map中不行。 

红黑树的查找复杂度为O(log(n)) 

unodered_map/_set底层是哈希表实现的，查找复杂度为O(1)



## 6.21

已知有下列Test类的说明，在该类的main方法内，则下列哪个语句是正确的？（） 

public class Test { 

​	private float f = 1.0f;

 int m = 12;

static int n = 1;     

public static void main (String args[]) { 

Test t = new Test();

} } 

A：t.f; 

B：this.n; 

C：Test.m 

D：Test.f 

**正确答案: A** 

**默念三遍static静态成员变量不能使用this关键字！**

**f虽然是private，但main还是在Test类中，所以A是可以的。**

**m 和 f 都是普通成员属性，而 “类名.” 方式只能调用静态成员属性，CD都不对。**



## 6.22

OSI七层模型中,物理层，数据链路层，网络层，传输层的单位是什么（）

```
比特bit，帧frame，包packet，段segment
```

比特成帧，帧成报文，报文成包，包成段



## Java修饰符

```java
final: 最终类型；不可以被修改，也就是常量的意思；
private: 私有的；只有类 内部才可以访问；
默认类型：它的访问权限是只有在同包和类内部可以访问；
protected: 保护的 ；在子类，同包，类内部都可以访问；
public: 公共的；任意的都可以访问
```

![权限修饰符](https://img-blog.csdnimg.cn/20200109210358463.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1lhcm9Eb25n,size_16,color_FFFFFF,t_70)



## 6.23

下列语句序列执行后，输出结果是（） 

public class ex{ 

​	public static void main(String[]args){ 

​		int a=13; 

​		a=a/5； 

​		System.out.println(a); 

} } 

A：1 

B：2 

C：3 

D：4 

**正确答案 B** 

a是int类型,13/5得到一个浮点类型,浮点类型转成整数类型的原则是,不四舍五入,直接截断小数点后的部分



## 6.24

关于下面的程序，说法正确的是： 

```java
public class test {
    static int x = 10;
    static {x+=5;}

    public static void main(String[] args) {
        System.out.println(x);
    }
    static {x/=3;}
}

```

A：第5行和12行不能编译，因为该方法没有方法名和返回值。 

B ：第12 行不能编译，因为只能有一个static初始化块。

C ：代码编译并执行，输出结果x = 10. 

**D：代码编译并执行，输出结果 x = 5.** 

E：代码编译并执行，输出结果 x = 15. 

**D** 

执行顺序为： 

父类静态代码块、静态变量 ps:按声明顺序执行 

子类静态代码块、静态变量 ps:按声明顺序执行 

父类局部代码块、成员变量 ps:按声明顺序执行 

父类构造函数 

子类局部代码块、成员变量 ps:按声明顺序执行 

子类构造函数

## 6.27

```java
public class Person{
    private String name = "Person";
    int age=0;
}
public class Child extends Person{
    public String grade;
    public static void main(String[] args){
        Person p = new Child();
        System.out.println(p.name);
    }
}
```

输出什么？**编译出错，子类访问不到private**



## 6.29

```java
 public static void main (String[] args) { 
    String classFile = "com.jd.". replaceAll(".", "/") + "MyClass.class";
    System.out.println(classFile);
}

 A：com. jd
 B：com/jd/MyClass.class
 C：///////MyClass.class
 D：com.jd.MyClass
```

**答案是C**

由于replaceAll方法的第一个参数是一个**正则表达式**，而"."在正则表达式中表示任何字符，所以会把前面字符串的所有字符都替换成"/"。

如果想替换的只是"."，那么久要写成"\\."



## 6.30

```java 
以下程序的输出结果为
class Base{
    public Base(String s){
        System.out.print("B");
    }
}
public class Derived extends Base{
    public Derived (String s) {
        System.out.print("D");
    }
    public static void main(String[] args){
        new Derived("C");
    }
}
 A：BD
 B：DB
 C：C
 D：编译错误
```

**答案是：编译错误** 

**因为创建子类，默认会调用父类的无参构造函数，没有定义**



# July

## 7.1

```java
问：以下程序运行的结果为 (   )
public class Example extends Thread{
  @Override
  public void run(){
        try{
            Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.print( "run" );
    }
    public static void main(String[] args){
        Example example= new Example();
        example.run();
        System.out.print( "main" );
    }
 A：run main
 B：main run
 C：main
 D：run
 E：不能确定
```

正确答案 选A。

**考察的run()方法作为普通方法的调用和通过线程start的启动调用的区别。**

对象.start()属于对线程的启动调用run()方法。 

题目给出的example.run();

是对象对普通方法的调用，所以由上到下依次执行输出：run main。



## 7.2

```java
问：若有定义语句： int a=10 ; double b=3.14 ; 则表达式 'A'+a+b 值的类型是（）
 A：char
 B：int
 C：double
 D：float
```

正确答案: C    

1. 在表达式中，char 和 short 类型的值，无论有符号还是无符号，都会自动转换成 int 或者 unsigned int（如果 short 的大小和 int 一样，unsigned short 的表示范围就大于 int，在这种情况下，unsigned short 被转换成 unsigned int）。因为它们被转换成表示范围更大的类型，故而把这种转换称为“升级（promotion）”。 
2.  按照从高到低的顺序给各种数据类型分等级，依次为：long double, double, float, unsigned long long, long long, unsigned long, long, unsigned int 和 int。这里有一个小小的例外，如果 long 和 int 大小相同，则 unsigned int 的等级应位于 long 之上。char 和 short 并没有出现于这个等级列表，是因为它们应该已经被升级成了 int 或者 unsigned int。 
3. 在任何涉及两种数据类型的操作中，它们之间**等级较低的类型会被转换成等级较高的类型**。



## 7.3

```java
问：下列语句序列执行后，输出结果是（）
public class ex{
    public static void main(String[]args){
        int a=13;
        a=a/5；
        System.out.println(a);
    }
}
 A：1
 B：2
 C：3
 D：4
```

B



## 7.4

```JAVA
问：有一张表user，innodb引擎，分别针对以下字段建立了主键或者索引。
主键-id、联合索引-name,phoneNum、唯一索引-userNum
问题：下面哪些SQL用到了覆盖索引？
A、select userNum from user where userNum = ?;
B、select * from user where name = ?;
C、select id,userNum from user where userNum = ?;
D、select name,phoneNum from user where userNum=?;
E、select phoneNum from user where name = ?;
```

**参考答案：ACE** 

A肯定会用到。自己查自己，这个程序员脑子瓦特了 

B没有。触发了回表操作 

C用到。在userNum字段的索引树的叶子节点，除了本字段的值，还记录了主键的值。 

D没有。在userNum字段的索引树的叶子节点，只有userNum字段和主键，其他列的值均需要触发回表操作进行查询。 

E用到。联合索引-name,phoneNum，在叶子节点会记录name,phoneNum以及主键的值，查询这些字段，不会触发回表操作。



**覆盖索引是select的数据列只用从索引中就能够取得，不必读取数据行，换句话说查询列要被所建的索引覆盖。**



## 7.6

```java
问：Java Application 中的主类需包含main方法，以下哪项是main方法的正确形参？（    ）
 A：String  args
 B：String[] args
 C：Char  arg
 D：StringBuffer[] args

```

正确答案: B
main函数的形式为public static void main(String[] args)



## 7.7

```java
问：AccessViolationException异常触发后，下列程序的输出结果为（      ）
static void Main(string[] args)  
{  
    try  
    {  
        throw new AccessViolationException();  
        Console.WriteLine("error1");  
    }  
    catch (Exception e)  
    {  
        Console.WriteLine("error2");  
    }  
    Console.WriteLine("error3");  
} 
A：error2
   error3
B： error3
C： error2
D： error1
```

**正确答案: A** 

try{ //正常执行的代码 }

catch (Exception e){ //出错后执行的代码 }

finally{ //无论正常执行还是出错,之后都会执行的代码 } 

//跟上面try catch无关的代码 正常执行的代码如果出现异常,就不会执行出现异常语句后面的所有正常代码.



## 7.8

```java
问：关于Java中的ClassLoader下面的哪些描述是错误的：(         )
A：默认情况下，Java应用启动过程涉及三个ClassLoader: Boostrap, Extension, System
B：一般的情况不同ClassLoader装载的类是不相同的，但接口类例外，对于同一接口所有类装载器装载所获得的类是相同的
C：类装载器需要保证类装载过程的线程安全
D：ClassLoader的loadClass在装载一个类时，如果该类不存在它将返回null
E：ClassLoader的父子结构中，默认装载采用了父优先
F：所有ClassLoader装载的类都来自CLASSPATH环境指定的路径
    
正确答案: B D F  错误的
    
A、java中类的加载有5个过程，加载、验证、准备、解析、初始化；这便是类加载的5个过程，而类加载器的任务是根据一个类的全限定名来读取此类的二进制字节流到JVM中，然后转换为一个与目标类对应的java.lang.Class对象实例，在虚拟机提供了3种类加载器，引导（Bootstrap）类加载器、扩展（Extension）类加载器、系统（System）类加载器（也称应用类加载器）。A正确
    
B、一个类，由不同的类加载器实例加载的话，会在方法区产生两个不同的类，彼此不可见，并且在堆中生成不同Class实例。所以B前面部分是正确的，后面接口的部分真的没有尝试过，等一个大佬的讲解吧；
    
C、类加载器是肯定要保证线程安全的；C正确
    
D、装载一个不存在的类的时候，因为采用的双亲加载模式，所以强制加载会直接报错，D错误
java.lang.SecurityException: Prohibited package name: java.lang
    
E、双亲委派模式是在Java 1.2后引入的，其工作原理的是，如果一个类加载器收到了类加载请求，它并不会自己先去加载，而是把这个请求委托给父类的加载器去执行，如果父类加载器还存在其父类加载器，则进一步向上委托，依次递归，请求最终将到达顶层的启动类加载器，如果父类加载器可以完成类加载任务，就成功返回，倘若父类加载器无法完成此加载任务，子加载器才会尝试自己去加载，这就是双亲委派模式，即每个儿子都很懒，每次有活就丢给父亲去干，直到父亲说这件事我也干不了时，儿子自己想办法去完成，所以默认是父装载，E正确
    
F、自定义类加载器实现 继承ClassLoader后重写了findClass方法加载指定路径上的class，F错误
```



## 7.9

```java
问：Integer i = 42;
Long l = 42l;
Double d = 42.0;

下面为true的是

A： (i == l) // Operator '==' cannot be applied to 'java.lang.Integer', 'java.lang.Double'
B：(i == d)
C：(l == d)
D：i.equals(d)
E：d.equals(l)
F：i.equals(l)
G：l.equals(42L)
```

G对.　　 

首先A,B,C都错,因为不同数据类型不能用"=="比较("=="比较的是对象的引用)；

对于D和E,F,先假设程序所在的系统中int型为4字节,long为6字节,double为8字节,那么对于D来说其意思为：32位的int数据是否等于48位的long数据,所以D错,同理E/F也错



## 7.10

```java
问：main()
{  
    int m=12,n=34;

    printf("%d%d",m++,++n);

    printf("%d%d\n",n++,++m);
}
程序运行后的输出结果是（）

 A：12353514
 B：12353513
 C：12343514
 D：12343513
```

A



## 7.11

![img](https://images.zsxq.com/FpZcDojnL0Gy6C1xgKNaJiWNJ7ma?e=1598889599&token=kIxbL07-8jAj8w1n4s9zv64FuZZNEATmlU_Vm6zD:c6_wpIFg1MBkOKfhJi3vuDqJ8Yo=)



答案：0  问题在count = count++;



## 7.13

```java
问：程序读入用户输入的一个值，要求创建一个自定义的异常，如果输入值大于 10 ，使用 throw 语句显式地引发异常，异常输出信息为 ”something’swrong!” ，语句为（）
 A：if(i>10)throw new Exception("something’swrong!");
 B：if(i>10)throw Exception e("something’swrong!");
 C：if(i>10) throw new Exception e("something’swrong!");
 D：if(i>10)throw Exception( "something’swrong!");
```

A



## 7.14

```java
问：如果定义一种表达式结构：(+ 6 3)的值为9，(- 6 3)的值为3，(* 6 3)的值为18，(/ 6 3)的值为2；那么对于表达式(* (- 16 (* 3 2 2 )) (+ 5 (/ 6 (- 5 3))))输出的结果为____。
 A：44
 B：40
 C：40
 D：32
 E：24
 F：21
```

**D 前缀表达式**

```java
(* (- 16 (* 3 2 2 )) (+ 5 (/ 6 (- 5 3)))) 
(* (- 16 (* 3 2 2 )) (+ 5 (/ 6 2))) 
(* (- 16 (* 3 2 2 )) (+ 5 3)) 
(* (- 16 (* 3 2 2 )) 8) 
(* (- 16 12) 8) 
(* 4 8) 
32
```



## 7.15

```java
问：假设如下代码中，若t1线程在t2线程启动之前已经完成启动。代码的输出是（）
public static void main(String[]args)throws Exception {
    final Object obj = new Object();
    Thread t1 = new Thread() {
        public void run() {
            synchronized (obj) {
                try {
                    obj.wait();
                    System.out.println("Thread 1 wake up.");
                } catch (InterruptedException e) {
                }
            }
        }
    };
    t1.start();
    Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
    Thread t2 = new Thread() {
        public void run() {
            synchronized (obj) {
                obj.notifyAll();
                System.out.println("Thread 2 sent notify.");
            }
        }
    };
    t2.start();
}

A：Thread 1 wake up
      Thread 2 sent notify.

B：Thread 2 sent notify.
      Thread 1 wake up

C： A、B皆有可能

D： 程序无输出卡死
```

```java
正确答案: B
1、在本题中，Thread1 先执行，因为有 synchronized， 所以它拿到了 obj 的对象锁，然后它执行到了 obj.wait() 的时候，它就释放了拿到了的 obj 的锁，并且进入阻塞。
2、然后就等到 Thread2 执行了， 因为 Thread1 已经释放了锁， 所以这个时候 Thread2 可以进入 synchronized， 然后就执行到了 obj.notify(), 关于 notify 官方文档是这样子描述的
     *Wakes up a single thread that is waiting on this object's
     * monitor. If any threads are waiting on this object, one of them
     * is chosen to be awakened. The choice is arbitrary and occurs at
     * the discretion of the implementation. A thread waits on an object's
     * monitor by calling one of the {@code wait} methods.
     * <p>
     * The awakened thread will not be able to proceed until the current
     * thread relinquishes the lock on this object. The awakened thread will
     * compete in the usual manner with any other threads that might be
     * actively competing to synchronize on this object; for example, the
     * awakened thread enjoys no reliable privilege or disadvantage in being
     * the next thread to lock this object.
    1、因为两个synchronized 的参数都是 obj ，也就是说它们的 mointor 是一样的， Thread2 执行了 notify 之后，会去唤醒同一个 monitor 下正在等待 obj 的线程， 这个时候只有 thread 一个线程在等待，所以 thread1 就被唤醒了。
    2、Thread1 被唤醒之后还不能马上执行，必须等到当前线程（也就是 Thread2 ） 释放锁后才获得执行的机会。
```



## 7.16

```java
问：运行下面代码，输出的结果是（）
class A {
    public A() {
        System.out.println("class A");
    }
    { System.out.println("I'm A class"); } 
    static { System.out.println("class A static"); }
}
public class B extends A {
    public B() {
        System.out.println("class B");
    }
    { System.out.println("I'm B class"); }
    
    static { System.out.println("class B static"); }

    public static void main(String[] args) { 
        new B(); 
    }
}
```

```
class A static
class B static
I'm A class
class A
I'm B class
class B
```

正确答案：A 

加载初始化顺序： 

1、父类静态代码块 

2、子类静态代码块 

3、父类普通代码块 

4、父类构造代码块 

5、子类普通代码块 

6、子类构造代码块



## 7.17

```java
问：以下代码的结果是什么？
enum AccountType
{
    SAVING, FIXED, CURRENT;
    private AccountType()
    {
        System.out.println(“It is a account type”);
    }
}
class EnumOne
{
    public static void main(String[]args)
    {
        System.out.println(AccountType.FIXED);
    }
}
 
 A：编译正确并输出为打印“这是一种帐户类型”，其次是“ FIXED”
 B：编译正确，输出为打印“这是一个帐户类型”两次，然后是“ FIXED”
 C：编译良好，输出为打印“这是一个帐户类型”，然后是“ FIXED”，三次
 D：编译好并输出打印“这是一个帐户类型”，四次后跟“ FIXED”
 E：编译失败
```

正确答案: C   

枚举类有三个实例，故调用三次构造方法，打印三次It is a account type

It is a account type
It is a account type
It is a account type
FIXED



## 7.18

```java
以下代码执行后输出结果为（ ）
public class Test {
    public static void main(String[] args) {
        System.out.println("return value of getValue(): " +getValue());
    }
     public static int getValue() {
         try {
             return 0;
         } finally {
             return 1;
         }
     }
 }
A： return value of getValue(): 1
B：return value of getValue(): 0
C：return value of getValue(): 0return value of getValue(): 1
D：return value of getValue(): 1return value of getValue(): 0
```

本题选A。 

根据官方的JVM规范： 如果try语句里有return，返回的是try语句块中变量值。 

详细执行过程如下： 如果有返回值，就把返回值保存到局部变量中； 

执行jsr指令跳到finally语句里执行； 

执行完finally语句后，返回之前保存在局部变量表里的值。 

**如果try，finally语句里均有return，忽略try的return，而使用finally的return.**



## 7.19

```java
问：下面程序的输出结果是什么。这是归并排序  从大到小的排序
public class A2{ 
    public static void main(String[] args){
        int[] a={2,4,6,8,3,6,9,12};
        doSomething(a,0,a.length-1);
        for(int i=0;i<=a.length-1;i++)
        System.out.print(a[i]+" ");
    } 
    private static void doSomething(int[] a,int start,int end){
        if(start<end){
            int p=core(a,start,end);
            doSomething(a,start,p-1);
            doSomething(a,p+1,end);
        }
    }
    private static int core(int[] a,int start,int end)
    {
        int x=a[end];
        int i=start;
        for(int j=start;j<=end-1;j++){
            if(a[j]>=x){
                swap(a,i,j);
                i++;//交换了几次 
            }
        }//把最大的放到最后
        swap(a,i,end);//把最大的放到i的位置 
        return i;
    } 

    private static void swap(int[] a,int i,int j) 
    {
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
```



## 7.20

```java
问：以下哪些jvm的垃圾回收方式采用的是复制算法回收
 A：新生代串行收集器
 B：老年代串行收集器
 C：并行收集器
 D：新生代并行回收收集器
 E：老年代并行回收收集器
 F：cms收集器
    
正确答案: A D
两个最基本的java回收算法：复制算法和标记清理算法 还有一个标记整理
复制算法：两个区域A和B，初始对象在A，继续存活的对象被转移到B。此为新生代最常用的算法
标记清理：一块区域，标记可达对象（可达性分析），然后回收不可达对象，会出现碎片，那么引出
标记-整理算法：多了碎片整理，整理出更大的内存放更大的对象
两个概念：新生代和年老代
新生代：初始对象，生命周期短的
永久代：长时间存在的对象
整个java的垃圾回收是新生代和年老代的协作，这种叫做分代回收。
P.S：Serial New收集器是针对新生代的收集器，采用的是复制算法
Parallel New（并行）收集器，新生代采用复制算法，老年代采用标记整理
Parallel Scavenge（并行）收集器，针对新生代，采用复制收集算法
Serial Old（串行）收集器，新生代采用复制，老年代采用标记整理
Parallel Old（并行）收集器，针对老年代，标记整理
CMS收集器，基于标记清理
G1收集器：整体上是基于标记 整理 ，局部采用复制

综上：新生代基本采用复制算法，老年代采用标记整理算法。cms采用标记清理。
```



## 7.22

```java
java8中，下面哪个类用到了解决哈希冲突的开放定址法 
 A：LinkedHashSet
 B：HashMap
 C：ThreadLocal
 D：TreeMap
```

```java
正确答案: C
threadlocalmap使用开放定址法解决haah冲突，hashmap使用链地址法解决hash冲突

散列表之开放定址法 
   在链接法中，如果不同键值却将有相同的映射值，即有不同键值的元素却映射到散列表中的同一位置，那么就采用链表的方法，将映射到同一位置的元素插入到同一个链表之中，当需要删除， 查询元素时，只需要遍历该链表即可，链接法在最坏情况下删除和查询元素的时间代价为O(n) 
   今天我们来讲散列表中另外一种解决冲突的方法，那就是开放定址法(open addressing)。 假如你在外面旅游时，吃坏东西，急需上厕所，当你好不容易找到一件洗手间的时候，发现排了好多人，这时你会怎么做？ 
   如果是链接法:排队不就行了，我就在外面等，迟早会排到我的 
   如果是开放定址法:直接放弃现有厕所，去寻找新的厕所 
   没错，放弃已被占用的位置，寻找新的插入位置就是开放定址法的思想，开放定址法中的开放二字指的是没有被占用的位置，定址指的是确定位置。开放定址法中，所有的元素都放在散列表中(链接法放在链表中)。也就是说散列表中的每一个位置，要么有元素，要么没有元素。当需要删除，查询元素时，我们从某一个位置开始，按照某种特定的确定下一个位置的方法来检查所有表项，直到找到目标元素，或者没有找到。
```



## 7.23

```java
关于AOP错误的是？
A：AOP将散落在系统中的“方面”代码集中实现
B：AOP有助于提高系统可维护性
C：AOP已经表现出将要替代面向对象的趋势
D：AOP是一种设计模式，Spring提供了一种实现
```

```JAVA
正确答案: C 
AOP 和 OOP的区别：
1. 面向方面编程 AOP 偏重业务处理过程的某个步骤或阶段，强调降低模块之间的耦合度，使代码拥有更好的移植性。
2. 面向对象编程 (oop) 则是对业务分析中抽取的实体进行方法和属性的封装。
也可以说 AOP 是面向业务中的动词领域， OOP 面向名词领域。
AOP 的一个很重要的特点是源代码无关性，也就是说如果我们的系统中引用了 AOP 组件，即使我们把该组件去掉，系统代码也应该能够编译通过。要实现这一点，可以使用动态 proxy 模式。
```



## 7.24

```JAVA
问：通常情况，JVM中使用类加载器的优先级是
A：BootstrapClassLoader > ExtensionClassLoader > ApplicationClassLoader > UserClassLoader
B：ExtensionClassLoader > BootstrapClassLoader > ApplicationClassLoader > UserClassLoader
C：BootstrapClassLoader > ExtensionClassLoader > UserClassLoader > ApplicationClassLoader
D：ExtensionClassLoader > BootstrapClassLoader > UserClassLoader > ApplicationClassLoader
```

```
正确答案 A
根类加载器（bootstrap class loader）扩展类加载器（extensions class loader）系统类加载器（system class loader）用户类加载器（user class loader）

考点：Java虚拟机-双亲委派模型

类加载器工作过程:
1. 类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器去完成；
2. 所有的加载请求最终都应该传送到最顶层的启动类加载器中； 
3. 只有当父加载器反馈自己无法完成这个加载请求（它的搜索范围中没有找到所需的类）时，子加载器才会尝试自己去完成加载。

题目当中，提到“通常情况”是因为这个双亲委派模型并不是一个具有强制性约束力的模型，而是Java设计者们推荐给开发者的一种类加载器实现的最佳实践
```



## 7.25

```JAVA
问：jvm中垃圾回收分为scanvenge gc和full GC，其中full GC触发的条件可能有哪些：【多选】（ ）
A：栈空间满
B：年轻代空间满
C：年老代满
D：持久代满
E：system.gc
```

```JAVA
答案：CDE
年轻代引起scanvenge young gc 
栈空间满不会 也没有 gc
```



## 7.27

```java
问：运用下列哪个命令能够获取JVM的内存映像
A：jinfo
B：jmap
C：jhat
D：jstat

```

```java
正确答案：B

1、jps：查看本机java进程信息。

2、jstack：打印线程的栈信息，制作线程dump文件。

3、jmap：打印内存映射，制作堆dump文件

4、jstat：性能监控工具

5、jhat：内存分析工具

6、jconsole：简易的可视化控制台

7、jvisualvm：功能强大的控制台
```



## 7.28

```java
问：下面有关 Spring DAO，描述错误的是？（）
A：方便的事务管理：Spring 的声明式事务管理力度是类级别  // 方法级别
B：Spring 提供的 DAO 支持了 JDBC，JDO 和 Hibernate
C：异常包装：Spring 能够包装 Hibernate 异常，把它们从 CheckedException 变为 RuntimeException ；开发者可选择在恰当的层处理数据中不可恢复的异常，从而避免烦琐的  catch / throw 及异常声明
D：Spring 提供的 DAO （数据访问对象）支持主要的目的是便于以标准的方式使用不同的数据访问技术
```

```java
正确答案：A
    
1、Spring 的声明式事务管理在底层是建立在 AOP 的基础上。其本质是在方法前后进行拦截，然后在目标方法开始之前创建一个事务，在执行这目标方法结束后，根据执行情况提交或进行回滚事务。

2、声明式事务最大的优点就是不需通过编程的方式而进行管理事务，这样就不需要在业务逻辑代码中掺杂事务管理的代码，只需在配置文件中做相关的事务规则声明，便可将事务规则应用到业务逻辑中。

3、声明式事务不足的地方在于，与编程式事务相比，只能作用到方法级别，无法像编程式事务那样可以作用到代码块级别。
```



## 7.29

```java
问：对于Spring Boot项目，下列关于设置日志级别的描述中，正确的是（）
A：可以在application.properties中设置日志级别
B：可以在xml中设置logback的日志级别
C：可以按照日志级别，拆分logback的日志
D：不能把所有级别的日志，打印到同一个日志文件里

正确答案 A B C
```



## 7.30

```java
下面列举的组件中，哪些会被Spring Boot自动装配到Spring容器中（）
A：JavaMailSender
B：MimeMessage
C：MimeMessageHelper
D：TemplateEngine

正确答案 A D
```



## 7.31

```
问：下面有关spring DAO，描述错误的是？
A：Spring提供的DAO(数据访问对象)支持主要的目的是便于以标准的方式使用不同的数据访问技术。
B：方便的事务管理: Spring的声明式事务管理力度是类级别
C：异常包装:Spring能够包装Hibernate异常，把它们从CheckedException变为RuntimeException; 开发者可选择在恰当的层处理数据中不可恢复的异常，从而避免烦琐的 catch/throw 及异常声明
D：Spring提供的DAO支持了JDBC、JDO和Hibernate
```

```
正确答案：B
Spring提供的DAO(数据访问对象)支持主要的目的是便于以标准的方式使用不同的数据访问技术。 简化 DAO 组件的开发。 Spring提供了一套抽象DAO类供你扩展。这些抽象类提供了一些方法，用来简化代码开发。 IoC 容器的使用，提供了 DAO 组件与业务逻辑组件之间的解耦。所有的 DAO 组件，都由容器负责注入到业务逻辑组件中，其业务组件无须关心 DAO 组件的实现。 面向接口编程及 DAO 模式的使用，提高了系统组件之间的解耦，降低了系统重构的成本。 方便的事务管理: Spring的声明式事务管理力度是方法级。 异常包装:Spring能够包装Hibernate异常，把它们从CheckedException变为RuntimeException; 开发者可选择在恰当的层处理数据中不可恢复的异常，从而避免烦琐的 catch/throw 及异常声明。
```

















