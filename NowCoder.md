# 牛客网刷题整理

## Java

### 7月

#### 7.31

```
1.构造方法用于创建类的实例对象，构造方法名应与类名相同，返回类型为void。

错误，构造方法没有返回值。
```



```
2.下列类定义中哪些是合法的抽象类的定义？（）
abstract Animal{abstract void growl();}
class abstract Animal{abstract  void growl();}
abstract class Animal{abstract  void growl();}  ✔
abstract class Animal{abstract  void growl(){System.out.println( “growl”);};}
```



```
3.在一个基于分布式的游戏服务器系统中，不同的服务器之间，哪种通信方式是不可行的（）？
管道  ✖
消息队列
高速缓存数据库
套接字

对于管道，有下面这几种类型：
①普通管道（PIPE）：通常有两种限制，一是单工，即只能单向传输；二是血缘，即常用于父子进程间（或有血缘关系的进程间）。
②流管道（s_pipe）：去除了上述的第一种限制，实现了双向传输。
③命名管道（name_pipe）：去除了上述的第二种限制，实现了无血缘关系的不同进程间通信。

显然，要求是对于不同的服务器之间的通信，是要要求全双工形式的，而管道只能是半双工，虽然可以双向，但是同一时间只能有一个方向传输
```



```
4.对于子类的构造函数说明，下列叙述中错误的是（ ）。
子类不能继承父类的无参构造函数。
子类可以在自己的构造函数中使用super关键字来调用父类的含参数构造函数，但这个调用语句必须是子类构造函数的第一个可执行语句。
在创建子类的对象时，若不含带参构造函数，将先执行父类的无参构造函数，然后再执行自己的无参构造函数。
子类不但可以继承父类的无参构造函数，也可以继承父类的有参构造函数。  ✖

解析：构造函数不能被继承，构造方法只能被显式或隐式的调用。super关键字
```



```
5.在Jdk1.7中，下述说法中抽象类与接口的区别与联系正确的有哪些？ ABCD
抽象类中可以有普通成员变量，接口中没有普通成员变量。
抽象类和接口中都可以包含静态成员常量。
一个类可以实现多个接口，但只能继承一个抽象类
抽象类中可以包含非抽象的普通方法，接口中的方法必须是抽象的，不能有非抽象的普通方法。

解析：接口（interface）可以说成是抽象类的一种特例，接口中的所有方法都必须是抽象的。接口中的方法定义默认为public abstract类型，接口中的成员变量类型默认为public static final。另外，接口和抽象类在方法上有区别：    
    1.抽象类可以有构造方法，接口中不能有构造方法。  
    2.抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方法。
    3.抽象类中可以有普通成员变量，接口中没有普通成员变量 
    4. 抽象类中的抽象方法的访问类型可以是public，protected和默认类型
    5. 抽象类中可以包含静态方法，接口中不能包含静态方法
    6. 抽象类和接口中都可以包含静态成员变量，抽象类中的静态成员变量的访问类型可以任意，但接口中定义的变量只能是public static final类型，并且默认即为public static final类型
    7. 一个类可以实现多个接口，但只能继承一个抽象类。二者在应用方面也有一定的区别：接口更多的是在系统架构设计方法发挥作用，主要用于定义模块之间的通信契约。而抽象类在代码实现方面发挥作用，可以实现代码的重用，例如，模板方法设计模式是抽象类的一个典型应用，假设某个项目的所有Servlet类都要用相同的方式进行权限判断、记录访问日志和处理异常，那么就可以定义一个抽象的基类，让所有的Servlet都继承这个抽象基类，在抽象基类的service方法中完成权限判断、记录访问日志和处理异常的代码，在各个子类中只是完成各自的业务逻辑代码。
```



```
6.下列容器中，哪些容器按 key 查找的复杂度为 O(log(n)) （）
A:std::unordered_set
B:std::multimap  ✔
C:std::map		 ✔
D:std::deque

STL库中，map和multimap底层都是红黑树实现的，两者的不同在于multimap允许重复的可以，而map中不行。
红黑树的查找复杂度为O(log(n))
unodered_map/_set底层是哈希表实现的，查找复杂度为O(1)
```

![img](https://uploadfiles.nowcoder.com/images/20190726/753849801_1564111940385_E7803B33BF59797D22BDDEB129CEB83C)

```
7.
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
Which four statements are true ?

①The type List<A>is assignable to List.
②The type List<Object>is assignable to List<?>.
③The type List<D>is assignable to List<?extends B>.
④The type List<?extends B>is assignable to List<?extends A>.

解答：
1. 只看尖括号里边的！！明确点和范围两个概念
2. 如果尖括号里的是一个类，那么尖括号里的就是一个点，比如List<A>,List<B>,List<Object>
3. 如果尖括号里面带有问号，那么代表一个范围，<? extends A> 代表小于等于A的范围，<? super A>代表大于等于A的范围，<?>代表全部范围
4. 尖括号里的所有点之间互相赋值都是错，除非是俩相同的点
5. 尖括号小范围赋值给大范围，对，大范围赋值给小范围，错。如果某点包含在某个范围里，那么可以赋值，否则，不能赋值
6. List<?>和List 是相等的，都代表最大范围
7.List既是点也是范围，当表示范围时，表示最大范围

public static void main(String[] args) {
        List<A> a;
        List list;
        list = a;   //A对，因为List就是List<?>，代表最大的范围，A只是其中的一个点，肯定被包含在内
        List<B> b;
        a = b;      //B错，点之间不能相互赋值
        List<?> qm;
        List<Object> o;
        qm = o;     //C对，List<?>代表最大的范围，List<Object>只是一个点，肯定被包含在内
        List<D> d;
        List<? extends B> downB;
        downB = d;  //D对，List<? extends B>代表小于等于B的范围，List<D>是一个点，在其中
        List<?extends A> downA;
        a = downA;  //E错，范围不能赋值给点
        a = o;      //F错，List<Object>只是一个点
        downA = downB;  //G对，小于等于A的范围包含小于等于B的范围，因为B本来就比A小，B时A的子类嘛
    }
    
    
另外：
大概有个观点就是：java数组具有协变性，而java集合不是协变的；
什么意思呢？我举几个例子：
1. 假设有一个函数 fun（Animal animal），如果我们传入一个Dog d 对象进去，编译器是不会报错的，这是多态的概念；
2. 假设有一个函数 fun（Animal[] animals），如果我们传如一个Dog[] dogs数组进去，编译器也不会报错，这就是数组的协变性；
3. 假设有一个函数 fun（List<Animal>  animal）， 如果我们传如一个List <Dog>  dog 集合进去，编译器就会报错了，这就是集合泛型的不变性；
那么该怎么办呢？我们可以将泛型改成这样 fun (List <? extends Animal> )，这样之后，当我们再 传入一个List <Dog>  dog 集合进去，编译器就就不会报错了。也就是说可以传入包含Animal的子类的List了。
```



### 8月

#### 8.1

```
1.执行下列代码的输出结果是(30 )
public class Demo{
　public static void main(String args[]){
　　　int num = 10;
　　　System.out.println(test(num));
}
public static int test(int b){
　　　try{
       b += 10;
　　　　return b;
　　　}
　　　catch(RuntimeException e){}
　　　catch(Exception e2){}
　　　finally{
　　　　b += 10;
　　　　return b;
　　　}
　　}
}

关于try catch 知识：
    程序运行到 try块，b=20;
	并没有发生异常，不运行catch块，运行到return b;
	因为finally块无论如何都要运行，因此并不发生返回动作，进行运行finally块，b=30;
	进行程序返回输出；
        
结论一：
return语句并不是函数的最终出口，如果有finally语句，这在return之后还会执行finally（return的值会暂存在栈里面，等待finally执行后再返回）
结论二：
finally里面不建议放return语句，根据需要，return语句可以放在try和catch里面和函数的最后。可行的做法有四：
（1）return语句只在函数最后出现一次。
（2）return语句仅在try和catch里面都出现。
（3）return语句仅在try和函数的最后都出现。
（4）return语句仅在catch和函数的最后都出现。
注意，除此之外的其他做法都是不可行的，编译器会报错
```



```
2.下面关于Java package的描述，哪个是正确的:（）
I. 包不提供将所有类名分区为更易管理的块的机制.
II. 包提供可见性控制机制.  ✔
III. 包的一个重要属性是包内定义的所有类都可以通过该包外的代码访问.
IV. 声明为包的一部分的类的.class文件可以存储在多个目录中.


为了更好地组织类，Java 提供了包机制，用于区别类名的命名空间。
包的作用：
1、把功能相似或相关的类或接口组织在同一个包中，方便类的查找和使用。

2、如同文件夹一样，包也采用了树形目录的存储方式。同一个包中的类名字是不同的，不同的包中的类的名字是可以相同的，当同时调用两个不同包中相同类名的类时，应该加上包名加以区别。因此，包可以避免名字冲突。

3、包也限定了访问权限，拥有包访问权限的类才能访问某个包中的类。

Java 使用包（package）这种机制是为了防止命名冲突，访问控制，提供搜索和定位类（class）、接口、枚举（enumerations）和注释（annotation）等。
```



```
3.下面赋值语句中正确的是（）
double d=5.3e12; ✔
float f=11.1;
int i=0.0;
Double oD=3;

java中整型默认的是int,浮点默认的是double.
B: double类型的11.1 转成 float，是需要强制转换的
C: double类型的0.0 转成 int，也是需要强制转换的
D: int 转为 封装类型Double，是无法编译的
    Double oD = 3.0， 会把double类型的3.0自动装箱为Double，没有问题
    
double d = 5.3e12; 相当于 5.3*10的12次方，科学计数法
double d = 3;  对  （自动转换类型）
Double d = 3; 错  （自动装箱的目标必须严格对应它拆箱后的类型）
Double d = 3.0;对 （自动装箱）
自动装箱和类型的自动转换不能同时进行，这告诉我们偷一个懒可以，多了就过分了。
小数默认为double类型的，所以要用小数表示float的话要加上f或者F后缀；同理，整数默认为int型，用整数表示long的话需要加上l后者L后缀
占用字节空间少的类型可以向占用字节多的类型自动转换。反之则不行，需要强转确保用户明确精度丢失的风险
```



```
4.下面哪个不属于HttpServletResponse接口完成的功能？
答案：C
A：设置HTTP头标  
response.setHeader("Refresh","3"); //三秒刷新页面一次

B：设置cookie
Cookie c1 = new Cookie("username","only");
response.addCookie(c1);

C（错误）：读取路径信息,request读取路径信息
从request获取各种路径总结
request.getRealPath("url"); // 虚拟目录映射为实际目录
request.getRealPath("./");    // 网页所在的目录
request.getRealPath("../"); // 网页所在目录的上一层目录
request.getContextPath();    // 应用的web目录的名称

D：输出返回数据
HttpServleteResponse.getOutputStream().write();
```

```java
5.
public interface Status {
 /*INSERT CODE HERE*/  int MY_VALUE=10;
 }

接口中字段的修饰符：public static final（默认不写）
接口中方法的修饰符：public abstract（默认不写）
```



#### 8.2

```
1.注释不会被编译，只是给程序员看。
```

```
2.&&与操作，||或操作都是短路操作符，即与操作时一旦遇到false就停止执行后当前关系式中的后续代码，同理或操作时一旦遇到true也停止执行
```

```
3.“类名.” 方式只能调用 静态成员属性
```

```
4.在类方法中调用本类的类方法可直接调用。 实例方法也叫做对象方法。
类方法是属于整个类的，而实例方法是属于类的某个对象的。
由于类方法是属于整个类的，并不属于类的哪个对象，所以类方法的方法体中不能有与类的对象有关的内容。即类方法体有如下限制： 
(1) 类方法中不能直接引用对象变量；
(2) 类方法中不能直接调用类的对象方法；
(3) 在类方法中不能使用super、this关键字。
(4)类方法不能被覆盖。 
如果违反这些限制，就会导致程序编译错误。

与类方法相比，对象方法几乎没有什么限制：
(1) 对象方法中可以引用对象变量，也可以引用类变量；
(2) 对象方法中可以调用类方法；
(3) 对象方法中可以使用super、this关键字。
```

```
5.构造函数不能被继承，构造方法只能被显式或隐式的调用。
```

```
6.java中的i++和++i在java语言层面上来看使用中间量机制，i=i++，i不变，i=++i相当于++i，而结合在一个语句里使用则会报错，因为++后应该跟变量。同理，i=(++i)++也是不对的
```

7.![img](https://uploadfiles.nowcoder.com/images/20180316/8955099_1521189690989_0BB28C2A1ECCC47EC020E89E8A554BBC)



```
8.java采用的uincode编码，两个字节表示一个字符，因此 char型在java中占两个字节，而int型占四个字节，故总共占四个字节
```



```
9.使用泛型的好处
1.类型安全。 
	泛型的主要目标是提高 Java 程序的类型安全。通过知道使用泛型定义的变量的类型限制，编译器可以在一个高得多的程度上验证类型假设。没有泛型，这些假设就只存在于程序员的头脑中（或者如果幸运的话，还存在于代码注释中）。
 
2.消除强制类型转换。 泛型的一个附带好处是，消除源代码中的许多强制类型转换。这使得代码更加可读，并且减少了出错机会。

3.潜在的性能收益。 泛型为较大的优化带来可能。在泛型的初始实现中，编译器将强制类型转换（没有泛型的话，程序员会指定这些强制类型转换）插入生成的字节码中。但是更多类型信息可用于编译器这一事实，为未来版本的 JVM 的优化带来可能。由于泛型的实现方式，支持泛型（几乎）不需要 JVM 或类文件更改。所有工作都在编译器中完成，编译器生成类似于没有泛型（和强制类型转换）时所写的代码，只是更能确保类型安全而已。

所以泛型只是提高了数据传输安全性，并没有改变程序运行的性能
```



```\
10.反射指的是在运行时能够分析类的能力的程序。
反射机制可以用来：
    1.在运行时分析类的能力--检查类的结构--所用到的就是java.lang.reflect包中的Field、Method、Constructor，分别用于描述类的与、方法和构造器。A中的Class类在java.lang中。
    2.在运行时查看对象。
    3.实现通用的数组操作代码。
    
反射机制的功能：
    在运行时判断任意一个对象所属的类；在运行时构造任意一个类的对象；在运行时判断任意一个类所具有的成员变量和方法；在运行时调用任意一个对象的方法；生成动态。
    
反射机制常见作用：
    动态加载类、动态获取类的信息（属性、方法、构造器）；动态构造对象；动态调用类和对象的任意方法、构造器；动态调用和处理属性；获取泛型信息（新增类型：ParameterizedType,GenericArrayType等）；处理注解（反射API:getAnnotationsdeng等）。
    
反射机制性能问题：
    反射会降低效率。
    void setAccessible(boolean flag):是否启用访问安全检查的开关，true屏蔽Java语言的访问检查，使得对象的私有属性也可以被查询和设置。禁止安全检查，可以提高反射的运行速度。
    可以考虑使用：cglib/javaassist操作。
```



#### 8.3

```
1.以下哪项不属于java类加载过程？
正确答案: B   你的答案: C (错误)
 A.生成java.lang.Class对象
 B.int类型对象成员变量赋予默认值
 C.执行static块代码
 D.类方法解析

类加载过程
类从被加载到虚拟机内存中开始，到卸载出内存为止，它的整个生命周期包括：加载（Loading）、验证（Verification）、准备(Preparation)、解析(Resolution)、初始化(Initialization)、使用(Using)和卸载(Unloading)7个阶段。其中准备、验证、解析3个部分统称为连接（Linking）。如图所示。

加载、验证、准备、初始化和卸载这5个阶段的顺序是确定的，类的加载过程必须按照这种顺序按部就班地开始，而解析阶段则不一定：它在某些情况下可以在初始化阶段之后再开始，这是为了支持Java语言的运行时绑定（也称为动态绑定或晚期绑定）。以下陈述的内容都已HotSpot为基准。

加载
在加载阶段（可以参考java.lang.ClassLoader的loadClass()方法），虚拟机需要完成以下3件事情：

1.通过一个类的全限定名来获取定义此类的二进制字节流（并没有指明要从一个Class文件中获取，可以从其他渠道，譬如：网络、动态生成、数据库等）；
2.将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构；
3.在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口；
加载阶段和连接阶段（Linking）的部分内容（如一部分字节码文件格式验证动作）是交叉进行的，加载阶段尚未完成，连接阶段可能已经开始，但这些夹在加载阶段之中进行的动作，仍然属于连接阶段的内容，这两个阶段的开始时间仍然保持着固定的先后顺序。

验证
验证是连接阶段的第一步，这一阶段的目的是为了确保Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
验证阶段大致会完成4个阶段的检验动作：

1.文件格式验证：验证字节流是否符合Class文件格式的规范；例如：是否以魔术0xCAFEBABE开头、主次版本号是否在当前虚拟机的处理范围之内、常量池中的常量是否有不被支持的类型。
2.元数据验证：对字节码描述的信息进行语义分析（注意：对比javac编译阶段的语义分析），以保证其描述的信息符合Java语言规范的要求；例如：这个类是否有父类，除了java.lang.Object之外。
3.字节码验证：通过数据流和控制流分析，确定程序语义是合法的、符合逻辑的。
4.符号引用验证：确保解析动作能正确执行。
验证阶段是非常重要的，但不是必须的，它对程序运行期没有影响，如果所引用的类经过反复验证，那么可以考虑采用-Xverifynone参数来关闭大部分的类验证措施，以缩短虚拟机类加载的时间。

准备
准备阶段是正式为类变量分配内存并设置类变量初始值的阶段，这些变量所使用的内存都将在方法区中进行分配。这时候进行内存分配的仅包括类变量（被static修饰的变量），而不包括实例变量，实例变量将会在对象实例化时随着对象一起分配在堆中。其次，这里所说的初始值“通常情况”下是数据类型的零值，假设一个类变量的定义为：
                publicstaticintvalue=123;        
                
那变量value在准备阶段过后的初始值为0而不是123.因为这时候尚未开始执行任何java方法，而把value赋值为123的putstatic指令是程序被编译后，存放于类构造器()方法之中，所以把value赋值为123的动作将在初始化阶段才会执行。
至于“特殊情况”是指：public static final int value=123，即当类字段的字段属性是ConstantValue时，会在准备阶段初始化为指定的值，所以标注为final之后，value的值在准备阶段初始化为123而非0.

解析
解析阶段是虚拟机将常量池内的符号引用替换为直接引用的过程。解析动作主要针对类或接口、字段、类方法、接口方法、方法类型、方法句柄和调用点限定符7类符号引用进行。

初始化
类初始化阶段是类加载过程的最后一步，到了初始化阶段，才真正开始执行类中定义的java程序代码。在准备极端，变量已经付过一次系统要求的初始值，而在初始化阶段，则根据程序猿通过程序制定的主管计划去初始化类变量和其他资源，或者说：初始化阶段是执行类构造器<clinit>()方法的过程.
<clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块static{}中的语句合并产生的，编译器收集的顺序是由语句在源文件中出现的顺序所决定的，静态语句块只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的静态语句块可以赋值，但是不能访问
```

![这里写图片描述](http://img.blog.csdn.net/20160308184325593)

```JAVA
2.输出什么？ 编译出错
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        empID = id;
    }
}
public class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}

子类的构造方法总是先调用父类的构造方法，如果子类的构造方法没有明显地指明使用父类的哪个构造方法，子类就调用父类不带参数的构造方法。
而父类没有无参的构造函数，所以子类需要在自己的构造函数中显示的调用父类的构造函数。使用super调用构造器的语句必须是子类构造器的第一条语句。
```



```java
3.Java体系结构包括四个独立但相关的技术：
Java程序设计语言
Java.class文件格式
Java应用编程接口（API）
Java虚拟机
我们再在看一下它们四者的关系：
    当我们编写并运行一个Java程序时，就同时运用了这四种技术，用Java程序设计语言编写源代码，把它编译成Java.class文件格式，然后再在Java虚拟机中运行class文件。当程序运行的时候，它通过调用class文件实现了Java API的方法来满足程序的Java API调用
```



```java
4.ACD
public class Test {
    private synchronized void a() {
    }
    private void b() {
        synchronized (this) {
        }
    }
    private synchronized static void c() {
    }
    private void d() {
        synchronized (Test.class) {
        }
    }
}

A.同一个对象，分别调用方法a和b，锁住的是同一个对象
B.同一个对象，分别调用方法a和c，锁住的是同一个对象
C.同一个对象，分别调用方法b和c，锁住的不是同一个对象
D.同一个对象，分别调用方法a、b、c，锁住的不是同一个对象
    
修饰非静态方法 锁的是this 对象
修饰静态方法 锁的是class对象
    方法a为同步方法，方法b里面的是同步块，同步方法使用的锁是固有对象this，同步块使用的锁可以是任意对象，但是方法b里面的同步块使用的锁是对象this，所以方法a和方法b锁住的是同一个对象。方法 c为静态同步方法，使用的锁是该类的字节码文件，也就是Test.class。方法d里面的也是同步块，只不过使用的锁是Test.class，所以方法c和方法d锁住的是同一个对象。
```



#### 8.4

```java
1.修饰符的作用域
```

![img](http://uploadfiles.nowcoder.com/images/20151012/458054_1444618871663_E93E59ACFE1791E0A5503384BEBDC544)

```
2.一个类中，有两个方法名、形参类型、顺序和个数都完全一样，返回值不一样的方法,这种现象叫覆盖。（ ✖ ）
覆盖是存在于子类和父类之间的。
重载（overload）和重写（override）的区别： 
	重载就是同一个类中，有多个方法名相同，但参数列表不同（包括参数个数和参数类型），与返回值无关，与权限修饰符也无关。
	调用重载的方法时通过传递给它们不同的参数个数和参数类型来决定具体使用哪个方法，这叫多态。 
	重写就是子类重写基类的方法，方法名，参数列表和返回值都必须相同，否则就不是重写而是重载。权限修饰符不能小于被重写方法的修饰符。
	重写方法不能抛出新的异常或者是比被重写方法声明更加宽泛的检查型异常。
```



```
3.以下 b 的值是： byte b = (byte)129;
	答案：-127

这题考察的就两个知识点：
一、强制转换（主要涉及各个类型占几个字节，这里我只简单说一下byte型占一个字节，也就是8位，int型4个字节，32位）；
二、在计算机系统中，数值一律用补码来表示（存储）
    正数：补码=反码=原码（当然以二进制形式表达）
    129 int类型（4个字节）二进制： 00000000 00000000 00000000 10000001
    强制转换byte型后，只有一个字节即 10000001（注意这里从二进制角度看，第一位是符号位，即求负数的补码接下来）
    只要求出上面原码对应的补码就行了，然后再转换对应的int型数值（因为题干所给的答案都是比较int型）
    10000001（原码） 对应的反码为1111 1110
    又补码等于反码+1
    即1111 1111  该二进制转换int型刚好是-127（1+2+4+8+16+32+64）

普及一下：正数原码，反码，补码相同
负数反码除了符号位不变，其他位取反，补码=反码+1；
```



```
4.Java数据库连接库JDBC用到哪种设计模式?
答案：桥接模式

桥接模式：
定义 ：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
意图 ：将抽象与实现解耦。
桥接模式所涉及的角色
1.  Abstraction ：定义抽象接口，拥有一个Implementor类型的对象引用
2.  RefinedAbstraction ：扩展Abstraction中的接口定义
3.  Implementor ：是具体实现的接口，Implementor和RefinedAbstraction接口并不一定完全一致，实际上这两个接口可以完全不一样Implementor提供具体操作方法，而Abstraction提供更高层次的调用
4.  ConcreteImplementor ：实现Implementor接口，给出具体实现
Jdk中的桥接模式：JDBC
JDBC连接 数据库 的时候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不动，原因就是JDBC提供了统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了
```



```
5.volatile关键字：变量线程可见，禁止指令重排序。不能保证线程安全，因为它不能保证原子性
1.java的内存模型
    java 内存模型规定了所有的变量都存储在主内存中，但是每个线程会有自己的工作内存，线程的工作内存保存了该线程中使用了的变量（从主内存中拷贝的），
    线程对变量的操作都必须在工作内存中进行，不同线程之间无法直接访问对方工作内存中的变量，线程间变量值从传递都要经过主内存完成

2.什么是原子性
	一个操作是不可中断的，要么全部执行成功要么全部执行失败，比如银行转账

3.什么是可见性
	当多个线程访问同一变量时，一个线程修改了这个变量的值，其他线程就能够立即看到修改的值

4.什么是有序性
    程序执行的顺序按照代码的先后顺序执行
    int a = 0; //1
    int b = 2; //2

    像这2句代码1会比2先执行，但是jvm在正真执行时不一定是1在2之前，这里涉及一个概念叫做指令重排，处理器为了提高程序运行效率，可能会对输入代码进行优化。
    它不保证程序中各个语句的执行先后顺序同代码中的顺序一致，但是它会保证程序最终执行结果和代码顺序执行的结果是一致的。
    比如上面的代码语句1和语句2谁先执行对最终的程序结果并没有影响，那么就有可能在执行过程中，语句2先执行而语句1后执行。
    在指令重排时会考虑指令之间的数据依赖性，比如2依赖了1的数值，那么处理器会保证1在2之前执行。
    但是在多线程的情况下，指令重排就会有影响了。

5.volatile到底做了什么
    禁止了指令重排
    保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量值，这个新值对其他线程是立即可见的
    不保证原子性（线程不安全）
```

![](C:\Users\yangjiewei\Desktop\公众号\pic\多线程.png)



```
6.
以下关于final关键字说法错误的是（）
正确答案: A C   你的答案: C D (错误)
A.final是java中的修饰符，可以修饰类、接口、抽象类、方法和属性
B.final修饰的类不能被继承
C.final修饰的方法不能被重载
D.final修饰的变量不允许被再次赋值

1.final修饰变量，则等同于常量
2.final修饰方法中的参数，称为最终参数。
3.final修饰类，则类不能被继承 
4.final修饰方法，则方法不能被重写。

 final 不能修饰抽象类 A
final修饰的方法可以被重载 但不能被重写 C
```



```
7.
1. 静态代码块；
2. 普通代码块；
3. 构造函数。
```



```
8.下列哪些操作会使线程释放锁资源？
正确答案: B C   你的答案: C D (错误)
sleep()
wait()
join()
yield()

所谓的释放锁资源实际是通知对象内置的monitor对象进行释放，而只有所有对象都有内置的monitor对象才能实现任何对象的锁资源都可以释放。
又因为所有类都继承自Object，所以wait(）就成了Object方法，
也就是通过wait()来通知对象内置的monitor对象释放，而且事实上因为这涉及对硬件底层的操作，所以wait()方法是native方法，底层是用C写的。
其他都是Thread所有，所以其他3个是没有资格释放资源的
而join()有资格释放资源其实是通过调用wait()来实现的

1.sleep()方法
    在指定时间内让当前正在执行的线程暂停执行，但不会释放“锁标志”。不推荐使用。
    sleep()使当前线程进入阻塞状态，在指定时间内不会执行。

2.wait()方法
    在其他线程调用对象的notify或notifyAll方法前，导致当前线程等待。线程会释放掉它所占有的“锁标志”，从而使别的线程有机会抢占该锁。
    当前线程必须拥有当前对象锁。如果当前线程不是此锁的拥有者，会抛出IllegalMonitorStateException异常。
    唤醒当前对象锁的等待线程使用notify或notifyAll方法，也必须拥有相同的对象锁，否则也会抛出IllegalMonitorStateException异常。
    waite()和notify()必须在synchronized函数或synchronized　block中进行调用。如果在non-synchronized函数或non-synchronized　block中进行调用，
    虽然能编译通过，但在运行时会发生IllegalMonitorStateException的异常。

3.yield方法
    暂停当前正在执行的线程对象。
    yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
    yield()只能使同优先级或更高优先级的线程有执行的机会。 

4.join方法
    join()等待该线程终止。
    等待调用join方法的线程结束，再继续执行。如：t.join();//主要用于等待t线程运行结束，若无此句，main则会执行完毕，导致结果不可预测
```



```
9.关于Java中的ClassLoader下面的哪些描述是错误的：( )
正确答案: B D F   你的答案: D (错误)
默认情况下，Java应用启动过程涉及三个ClassLoader: Boostrap, Extension, System
一般的情况不同ClassLoader装载的类是不相同的，但接口类例外，对于同一接口所有类装载器装载所获得的类是相同的
类装载器需要保证类装载过程的线程安全
ClassLoader的loadClass在装载一个类时，如果该类不存在它将返回null
ClassLoader的父子结构中，默认装载采用了父优先
所有ClassLoader装载的类都来自CLASSPATH环境指定的路径

    A.Java系统提供3种类加载器：启动类加载器（Bootstrap ClassLoader）  扩展类加载器（Extension ClassLoader） 应用程序类加载器（Application ClassLoader）. A正确

    B.《深入理解Java虚拟机》P228：对于任意一个类，都需要由加载它的类加载器和这个类本身一同确立其在Java虚拟机中的唯一性，每一个类加载器，都拥有一个独立的类名称空间。这句话可以表达得更通俗一些：比较两个类是否“相等”，只有在这两个类是由同一个类加载器加载的前提下才有意义，否则，即使这两个类来源于同一个Class文件，被同一个虚拟机加载，只要加载它们的类加载器不同，那么这两个类必定不相等。接口类是一种特殊类，因此对于同一接口不同的类装载器装载所获得的类是不相同的。B错误

    C.类只需加载一次就行，因此要保证类加载过程线程安全，防止类加载多次。C正确

    D. Java程序的类加载器采用双亲委派模型，实现双亲委派的代码集中在java.lang.ClassLoader的loadClass()方法中，此方法实现的大致逻辑是：先检查是否已经被加载，若没有加载则调用父类加载器的loadClass()方法，若父类加载器为空则默认使用启动类加载器作为父类加载器。如果父类加载失败，抛出ClassNotFoundException异常。D错误

    E.双亲委派模型的工作过程：如果一个类加载器收到了类加载的请求，它首先不会自己去尝试加载这个类，而是把这个请求委派给父类加载器去完成，每一个层次的类加载器都是如此，因此所有的加载请求最终都应该传送到顶层的启动类加载器中，只有当父加载器反馈自己无法完成这个加载请求时，子加载器才会尝试自己去加载。E正确

    F.应用程序类加载器（Application ClassLoader）负责加载用户类路径（ClassPath）上所指定的类库，不是所有的ClassLoader都加载此路径。F错误
```



#### 8.5

```java
1.
class HasStatic{
    private static int x = 100;
    public static void main(String args[ ]){
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1=new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println( "x=" +x);
    }
}

可以编译通过，静态变量即类变量可以通过类名访问，以及对象访问。
```



**方法重写**

- 参数列表必须完全与被重写方法的相同；
- 返回类型必须完全与被重写方法的返回类型相同；
- 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为public，那么在子类中重写该方法就不能声明为protected。
- 父类的成员方法只能被它的子类重写。
- 声明为final的方法不能被重写。
- 声明为static的方法不能被重写，但是能够被再次声明。
- 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为private和final的方法。
- 子类和父类不在同一个包中，那么子类只能够重写父类的声明为public和protected的非final方法。
- 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
- 构造方法不能被重写。
- 如果不能继承一个方法，则不能重写这个方法。

**方法重载**

- 被重载的方法必须改变参数列表(参数个数或类型或顺序不一样)；
- 被重载的方法可以改变返回类型；
- 被重载的方法可以改变访问修饰符；
- 被重载的方法可以声明新的或更广的检查异常；
- 方法能够在同一个类中或者在一个子类中被重载。
- 无法以返回值类型作为重载函数的区分标准。



```java
2.有关finally语句块说法正确的是（ ）
正确答案: A B C   你的答案: A C D (错误)
不管catch是否捕获异常，finally语句块都是要被执行的
在try语句块或catch语句块中执行到System.exit(0)直接退出程序
finally块中的return语句会覆盖try块中的return返回
finally 语句块在 catch语句块中的return语句之前执行
    
也就是说退出语句就直接退出了
D.不是return之前，是return执行完成之前，return表达式的结果会暂时保存起来，不会被改变
```



8.6

```java
1.假设num已经被创建为一个ArrayList对象，并且最初包含以下整数值：[0，0，4，2，5，0，3，0]。 执行下面的方法numQuest(),最终的输出结果是什么？
private List<Integer> nums;
        //precondition: nums.size() > 0
        //nums contains Integer objects
        public void numQuest() {
        int k = 0;
        Integer zero = new Integer(0);
        while (k < nums.size()) {
        if (nums.get(k).equals(zero))
        nums.remove(k); // 移除了一个第二个0变成了第一个就不会删除了
        k++;
    }
}

[0, 4, 2, 5, 3]
```



```
2.下面哪段程序能够正确的实现了GBK编码字节流到UTF-8编码字节流的转换：
byte[] src,dst;
正确答案: B   你的答案: D (错误)
dst=String.fromBytes(src，"GBK").getBytes("UTF-8")
dst=new String(src，"GBK").getBytes("UTF-8")
dst=new String("GBK"，src).getBytes()
dst=String.encode(String.decode(src，"GBK"))，"UTF-8" ) // 没有这个方法

答案：B
操作步骤就是先解码再编码
用new String(src，"GBK")解码得到字符串
用getBytes("UTF-8")得到UTF8编码字节数组
```



```
3.输出结果是 null
public class Base
{
    private String baseName = "base";
    public Base()
    {
        callName();
    }

    public void callName()
    {
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}

答案：A
 new Sub();在创造派生类的过程中首先创建基类对象，然后才能创建派生类。
创建基类即默认调用Base()方法，在方法中调用callName()方法，由于派生类中存在此方法，则被调用的callName（）方法是派生类中的方法，此时派生类还未构造，所以变量baseName的值为null

1.首先，需要明白类的加载顺序。
类加载
(1) 父类静态代码块(包括静态初始化块，静态属性，但不包括静态方法)
(2) 子类静态代码块(包括静态初始化块，静态属性，但不包括静态方法 )
对象创建
(3) 父类非静态代码块( 包括非静态初始化块，非静态属性 )
(4) 父类构造函数
(5) 子类非静态代码块 ( 包括非静态初始化块，非静态属性 )
(6) 子类构造函数
其中：类中静态块按照声明顺序执行，并且(1)和(2)不需要调用new类实例的时候就执行了(意思就是在类加载到方法区的时候执行的)
2.其次，需要理解子类覆盖父类方法的问题，也就是方法重写实现多态问题。
Base b = new Sub();它为多态的一种表现形式，声明是Base,实现是Sub类， 理解为 b 编译时表现为Base类特性，运行时表现为Sub类特性。
当子类覆盖了父类的方法后，意思是父类的方法已经被重写，题中 父类初始化调用的方法为子类实现的方法，子类实现的方法中调用的baseName为子类中的私有属性。
由1.可知，此时只执行到步骤4.,子类非静态代码块和初始化步骤还没有到，子类中的baseName还没有被初始化。所以此时 baseName为空。 所以为null。
```



```
4.要导入java/awt/event下面的所有类，叙述正确的是？()
正确答案: C   你的答案: A (错误)
import java.awt.*和import java.awt.event.*都可以
只能是import java.awt.*
只能是import java.awt.event.*
import java.awt.*和import java.awt.event.*都不可以

导包只可以导到当前层，不可以再导入包里面的包中的类。你说你吃了晚饭，我怎么知道你有没有吃午饭
```



```
5.关于异常的编程，以下描述错误的是：（ ）
正确答案: A   你的答案: C (错误)
在有除法存在的代码处，为了防止分母为零，必须抛出并捕获异常
int i=Integer.parseInt(”123a”);将产生NumberFormatException
int a[]=null; a[0]=1; 将产生NullPointerException
输入输出流编程中，读和写时都要抛出IOException

Java的异常分为两种，一种是运行时异常（RuntimeException），一种是非运行异常也叫检查式异常（CheckedException）。
1、运行时异常不需要程序员去处理，当异常出现时，JVM会帮助处理。常见的运行时异常有：
    ClassCastException(类转换异常)
    ClassNotFoundException
    IndexOutOfBoundsException(数组越界异常)
    NullPointerException(空指针异常)
    ArrayStoreException(数组存储异常，即数组存储类型不一致)
    还有IO操作的BufferOverflowException异常
2、非运行异常需要程序员手动去捕获或者抛出异常进行显示的处理，因为Java认为Checked异常都是可以被修复的异常。常见的异常有：
    IOException
    SqlException
```



```
6.在Java中，对于不再使用的内存资源，如调用完成的方法，“垃圾回收器”会自动将其释放。（ ✖ ）
正确答案: B   你的答案: A (错误)
```



#### 8.7

```
1.关于继承和实现说法正确的 是 ？ (  A  )
正确答案: A   你的答案: B (错误)
类可以实现多个接口，接口可以继承（或扩展）多个接口
类可以实现多个接口，接口不能继承（或扩展）多个接口
类和接口都可以实现多个接口
类和接口都不可以实现多个接口

1.类与类之间的关系为继承，只能单继承，但可以多层继承。
2.类与接口之间的关系为实现，既可以单实现，也可以多实现。 
3.接口与接口之间的关系为继承，既可以单继承，也可以多继承。 故为A
```



```
2.TCP/IP是远程通讯的主要手段
```



```
3.关于Java的一些概念，下面哪些描述是正确的：(    )
正确答案: B F   你的答案: B D F (错误)
A.所有的Java异常和错误的基类都是java.lang.Exception, 包括java.lang.RuntimeException
B.通过try … catch … finally语句，finally中的语句部分无论发生什么异常都会得到执行
C.java中所有的数据都是对象
D.Java通过垃圾回收回收不再引用的变量，垃圾回收时对象的finallize方法一定会得到执行
E.Java是跨平台的语言，无论通过哪个版本的Java编写的程序都能在所有的Java运行平台中运行
F.Java通过synchronized进行访问的同步，synchronized作用非静态成员方法和静态成员方法上同步的目标是不同的

A、java异常和错误的基类Throwable,包括Exception和Error
B、try...catch...finally finally不管什么异常都会执行
C、java是面向对象的，但是不是所有的都是对象，基本数据类型就不是对象，所以才会有封装类的；
D、如果是等待清理队列中如果又被调用，则不会执行finallize方法
E、JAVA跨平台性    实现在任意平台的java程序都可以在其他平台运行
F、synchronized实现方式：三种
```



#### 8.8

```java
1.变量a是一个64位有符号的整数，初始值用16进制表示为：0Xf000000000000000； 
  变量b是一个64位有符号的整数，初始值用16进制表示为：0x7FFFFFFFFFFFFFFF。 则a-b的结果用10进制表示为多少？（）
正确答案: C   你的答案: B (错误)
A.1
B.-(2^62+2^61+2^60+1)
C.2^62+2^61+2^60+1
D.2^59+(2^55+2^54+…+2^2+2^1+2^0)
    
0x7FFFFFFFFFFFFFFF+1=0X8000000000000000，那么
a-b=0Xf000000000000000-0X8000000000000000+1
=0X7000000000000001
=16^15*7+16^0*1
=2^60*7+1
=2^60*(2^2+2^1+2^0)+1
=2^62+2^61+2^60+1
```



```
2.这里会输出0，全局变量初始化了。
package test;
public class test4 {
    static int c;
    public static void main(String[] args) {
        int a;
        int b;
        System.out.println(c);
    }
}
如果直接输出a,b会编译出错，因为没有初始化。
a和b是定义在类中的main()方法中，是局部变量，在使用之前必须进行初始化，否则会出现错误。
如果c定义在方法之外，类中。c就是全局变量，java中对全局变量是进行默认初始化的。
```



3.StringBuffer a = newStringBuffer("A"); 

  StringBuffer b = newStringBuffer("B"); 

此时内存中的状态如下图所示：

![img](http://uploadfiles.nowcoder.com/images/20150814/415611_1439558987237_A7EE56745585A55A4703BAADFBD9F5C1)

public static void operator(StringBuffer x, StringBuffer y) { 

  x.append(y);

 y = x; 

}

进入如下方法后,内存中的状态为：

![img](http://uploadfiles.nowcoder.com/images/20150814/415611_1439559059477_45ED3E5A1E47DEB9C5C01FDC9389CC03)

 x.append(y);

这条语句执行后,内存的状态为：

![img](http://uploadfiles.nowcoder.com/images/20150814/415611_1439559131687_7D30FC34FEAD9F1AC3DDA8174994CBEC)

 y = x; 

这条语句执行后,内存的状态为：

![img](http://uploadfiles.nowcoder.com/images/20150814/415611_1439559183891_96F90E110CE3F53E13D9B0C6A2E3FFF8)

当operator方法执行完毕后内存中的状态为：因为方法执行完毕，局部变量消除。

![img](http://uploadfiles.nowcoder.com/images/20150814/415611_1439559443024_63C85D8FEA3A65F4A0888E30607C53A7)

有内存中的状态,可以知道最后的结果。



#### 8.9

```
1.下列关于继承的描述正确的是（）
正确答案: C   你的答案: A (错误)
A 在Java中允许定义一个子类的引用，指向父类的对象。
B 在Java中一个子类可以继承多个抽象类，在extends关键字后依次列出，用逗号隔开。✖
C 在Java中继承是通过extends关键字来描述的，而且只允许继承自一个直接父类。
D 在Java中抽象类之间不允许出现继承关系，所有的抽象类都相互独立。 ✖

A 说反了，应该是父类的引用指向子类对象。
C 应该也是错的，因为接口可以多继承。
```



**2.分类**

Java语言提供了很多修饰符，大概分为两类： 

1. 访问权限修饰符 

2. 非访问权限修饰符



访问权限修饰符

1. public：共有访问。对所有的类都可见。
2. protected：保护型访问。对同一个包可见，对不同的包的子类可见。
3. default：默认访问权限。只对同一个包可见，注意对不同的包的子类不可见。
4. private：私有访问。只对同一个类可见，其余都不见。



 

非访问权限修饰符

1. static 修饰符，用来创建类方法和类变量。
2. final 修饰符，用来修饰类、方法和变量，final 修饰的类不能够被继承，修饰的方法不能被继承类重新定义，修饰的变量为常量，是不可修改的。
3. abstract 修饰符，用来创建抽象类和抽象方法。
4. synchronized 用于多线程的同步。
5. volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
6. transient：序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。



**类**

外部类修饰符

- public（访问控制符），将一个类声明为公共类，它可以被任何对象访问，一个程序的主类必须是公共类。
- default（访问控制符），类只对包内可见，包外不可见。
- abstract（非访问控制符），将一个类声明为抽象类，抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充，抽象类可以包含抽象方法和非抽象方法。。
- final（非访问控制符），将一个类生命为最终（即非继承类），表示它不能被其他类继承。 

 注意： 

1. protected 和 private 不能修饰外部类，是因为外部类放在包中，只有两种可能，包可见和包不可见。 

2. final 和 abstract不能同时修饰外部类，因为该类要么能被继承要么不能被继承，二者只能选其一。 

3. 不能用static修饰类，因为类加载后才会加载静态成员变量。所以不能用static修饰类和接口，因为类还没加载，无法使用static关键字。

 

内部类修饰符

​    内部类与成员变量地位一直，所以可以public,protected、default和private，同时还可以用static修饰，表示嵌套内部类，不用实例化外部类，即可调用。

方法修饰符

1. public（公共控制符），包外包内都可以调用该方法。

2. protected（保护访问控制符）指定该方法可以被它的类和子类进行访问。

   具体细节可参考：http://blog.csdn.net/dawn_after_dark/article/details/74453915

3. default(默认权限），指定该方法只对同包可见，对不同包（含不同包的子类）不可见。

4. private（私有控制符）指定此方法只能有自己类等方法访问，其他的类不能访问（包括子类），非常严格的控制。

5. final ,指定方法已完备，不能再进行继承扩充。

6. static，指定不需要实例化就可以激活的一个方法，即在内存中只有一份，通过类名即可调用。

7. synchronize，同步修饰符，在多个线程中，该修饰符用于在运行前，对它所属的方法加锁，以防止其他线程的访问，运行结束后解锁。

8. native，本地修饰符。指定此方法的方法体是用其他语言在程序外部编写的。

9. abstract ,抽象方法是一种没有任何实现的方法，该方法的的具体实现由子类提供。抽象方法不能被声明成 final 和 static。 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。 如果一个类包含若干个抽象方法，那么该类必须声明为抽象类。抽象类可以不包含抽象方法。 抽象方法的声明以分号结尾，例如：public abstract sample();。

 

成员变量修饰符

- public（公共访问控制符），指定该变量为公共的，它可以被任何对象的方法访问。
- protected（保护访问控制符）指定该变量可以别被自己的类和子类访问。在子类中可以覆盖此变量。
- default(默认权限），指定该变量只对同包可见，对不同包（含不同包的子类）不可见。
- private（私有访问控制符）指定该变量只允许自己的类的方法访问，其他任何类（包括子类）中的方法均不能访问。
- final，最终修饰符，指定此变量的值不能变。
- static（静态修饰符）指定变量被所有对象共享，即所有实例都可以使用该变量。变量属于这个类。
- transient（过度修饰符）指定该变量是系统保留，暂无特别作用的临时性变量。不持久化。
- volatile（易失修饰符）指定该变量可以同时被几个线程控制和修改，保证两个不同的线程总是看到某个成员变量的同一个值。 

 final 和 static 经常一起使用来创建常量。

 

局部变量修饰符

only final is permitted。 

为什么不能赋予权限修饰符？ 

因为局部变量的生命周期为一个方法的调用期间，所以没必要为其设置权限访问字段，既然你都能访问到这个方法，所以就没必要再为其方法内变量赋予访问权限，因为该变量在方法调用期间已经被加载进了虚拟机栈，换句话说就是肯定能被当前线程访问到，所以设置没意义。 

为什么不能用static修饰 

我们都知道静态变量在方法之前先加载的，所以如果在方法内设置静态变量，可想而知，方法都没加载，你能加载成功方法内的静态变量？

 

**接口（interface）可以说成是抽象类的一种特例，接口中的所有方法都必须是抽象的。**

**接口中的方法定义默认为public abstract类型，接口中的成员变量类型默认为public static final。**



---

```
3.character流和byte流的区别不包括（）
正确答案: A B D   你的答案: B D (错误)
每次读入的字节数不同  (可能相同，可能不同)
前者带有缓冲，后者没有。
前者是字符读入，后者是字节读入。
二者没有区别，可以互换。
=======================================================================================
Java的流操作分为字节流和字符流两种。
字节流与字符流主要的区别是他们的处理方式
字节流是最基本的，所有的InputStream和OutputStream的子类都是,主要用在处理二进制数据，它是按字节来处理的。但实际中很多的数据是文本，又提出了字符流的概念，它是按虚拟机的encode来处理，也就是要进行字符集的转化
这两个之间通过 InputStreamReader,OutputStreamWriter来关联，实际上是通过byte[]和String来关联。

在实际开发中出现的汉字问题实际上都是在字符流和字节流之间转化不统一而造成的。
字节流---->字符流
字节流转化为字符流，实际上就是byte[]转化为String时，
public String(byte bytes[], String charsetName)
有一个关键的参数字符集编码，通常我们都省略了，那系统就用操作系统的lang
字符流---->字节流
字符流转化为字节流，实际上是String转化为byte[]时，byte[] String.getBytes(String charsetName)也是一样的道理至于java.io中还出现了许多其他的流，按主要是为了提高性能和使用方便，如BufferedInputStream,PipedInputStream等
常识：

对于GBK编码标准，英文占用1个字节，中文占用2个字节
对于UTF-8编码标准，英文占用1个字节，中文占用3个字节
对于Unicode编码标准，英文中文都是2个字节。这也是为什么叫做unicode
```



---

---

#### 8.10

````
1.用户不能调用构造方法，只能通过new关键字自动调用。（）

正确答案: B   你的答案: B (正确)
正确
错误

选B。
- 在类内部可以用户可以使用关键字this.构造方法名()调用（参数决定调用的是本类对应的构造方法）
- 在子类中用户可以通过关键字super.父类构造方法名()调用（参数决定调用的是父类对应的构造方法。）
- 反射机制对于任意一个类，都能够知道这个类的所有属性和方法，包括类的构造方法。
````



```
2.关于Float，下列说法错误的是()
正确答案: C   你的答案: C (正确)
Float是一个类
Float在java.lang包中
Float a=1.0是正确的赋值方法
Float a= new Float(1.0)是正确的赋值方法
```

1. Float是类，float不是类.
2. 查看JDK源码就可以发现Byte，Character，Short，Integer，Long，Float，Double，Boolean都在java.lang包中.
3. Float正确复制方式是Float f=1.0f,若不加f会被识别成double型,double无法向float隐式转换.
4. Float a= new Float(1.0)是正确的赋值方法，但是在1.5及以上版本引入自动装箱拆箱后，会提示这是不必要的装箱的警告，通常直接使用Float f=1.0f.



```
3.下列有关Servlet的生命周期，说法不正确的是？
正确答案: A   你的答案: D (错误)
在创建自己的Servlet时候，应该在初始化方法init()方法中创建Servlet实例 ✖是创建阶段
在Servlet生命周期的服务阶段，执行service()方法，根据用户请求的方法，执行相应的doGet()或是doPost()方法
在销毁阶段，执行destroy()方法后会释放Servlet 占用的资源
destroy()方法仅执行一次，即在服务器停止且卸载Servlet时执行该方法

Servlet的生命周期
1.加载：容器通过类加载器使用Servlet类对应的文件来加载Servlet
2.创建：通过调用Servlet的构造函数来创建一个Servlet实例
3.初始化：通过调用Servlet的init()方法来完成初始化工作，这个方法是在Servlet已经被创建，但在向客户端提供服务之前调用。
4.处理客户请求：Servlet创建后就可以处理请求，当有新的客户端请求时，Web容器都会创建一个新的线程来处理该请求。接着调用Servlet的Service()方法来响应客户端请求（Service方法根据请求的method属性来调用doGet（）和doPost（））
5.卸载：容器在卸载Servlet之前需要调用destroy()方法，让Servlet释放其占用的资源。
```



```
4.
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

输出结果是：
构造块
构造块
静态块
构造块

为什么？？？？不是静态代码块，然后代码块，然后构造函数吗
开始时JVM加载B.class，对所有的静态成员进行声明，t1 t2被初始化为默认值，为null
又因为t1 t2需要被显式初始化，所以对t1进行显式初始化，初始化代码块→构造函数（没有就是调用默认的构造函数）
咦！静态代码块咋不初始化？因为在开始时已经对static部分进行了初始化
虽然只对static变量进行了初始化，但在初始化t1时也不会再执行static块了
因为JVM认为这是第二次加载类B了，所以static会在t1初始化时被忽略掉
所以直接初始化非static部分，也就是构造块部分（输出''构造块''）接着构造函数（无输出）
接着对t2进行初始化过程同t1相同（输出'构造块'），此时就对所有的static变量都完成了初始化
接着就执行static块部分（输出'静态块'），接着执行，main方法，同样也，new了对象，调用构造函数输出（'构造块'）
```

![](C:\Users\yangjiewei\Downloads\静态类变量与静态代码块.png)



```
5.对于java类型变量char c,short s,float f,double d,表达式c*s+f+d的结果类型为（）
正确答案: D   你的答案: D (正确)
float
char
short
double

自动类型转换遵循下面的规则：
1.若参与运算的数据类型不同，则先转换成同一类型，然后进行运算。
2.转换按数据长度增加的方向进行，以保证精度不降低。例如int型和long型运算时，先把int量转成long型后再进行运算。
3.所有的浮点运算都是以双精度进行的，即使仅含float单精度量运算的表达式，也要先转换成double型，再作运算。
4.char型和short型参与运算时，必须先转换成int型。
5.在赋值运算中，赋值号两边的数据类型不同时，需要把右边表达式的类型将转换为左边变量的类型。如果右边表达式的数据类型长度比左边长时，将丢失一部分数据，这样会降低精度。
下图表示了类型自动转换的规则：
```

![img](http://uploadfiles.nowcoder.com/images/20150917/415611_1442458661106_F4A62FDD254F710F39378C754ED65E61)



#### 8.11

```
1.下面哪个不是标准Statement类？
正确答案: D   你的答案: C (错误)
Statement
PreparedStatement
CallableStatement
BatchedStatement

答案：D
Statement在JDBC中相当于SQL语句的载体
A，Statement是最基本的用法，采用字符串拼接的方式，存在注入漏洞
B，PreparedStatement对Statement中的SQL语句进行预编译，同时检查合法性，效率高
C，CallableStatement接口扩展 PreparedStatement，用来调用存储过程,它提供了对输出和输入/输出参数的支持。CallableStatement 接口还具有对 PreparedStatement 接口提供的输入参数的支持。
D，不是标准的Statement类
```



```
2.以下代码执行的结果显示是多少（ ）？
Integer i1 = 128;
Integer i2 = 128;
i1 == i2; false

String i3 = "100";
String i4 = "1" + new String("00");
i3 == i4; false;  得看是什么时候生成的？运行还是编译的时候

Integer i5 = 100;
Integer i6 = 100;
i5 == i6; true

正确答案: D   你的答案: D (正确)
true,false,true
false,true,false
true,true,false
false,false,true
```

其实当我们在为Integer赋值的时候，java编译器会将其翻译成调用valueOf()方法。比如Integer i=127翻译为Integer i=Integer.valueOf(127)

然后我们来看看valueOf()函数的源码：

public static Integer valueOf(int i)
    {
        //high为127
        if(i >= -128 && i <= IntegerCache.high)
            return IntegerCache.***[i + 128];
        else
            return new Integer(i);
    }

**可以看出，对于-128到127之间的数，Java会对其进行缓存。而超出这个范围则新建一个对象。**

所以现在回到这道问题

i1和i2为128，超出范围，所以都需要新建对象，对象比较为false；

i5和i6为100，在范围之内，在执行Integer i5=100时，就会直接缓存到内存中，但执行执行Integer i6=100时，就直接从缓存里取，而不需要新建对象，所以为true。

```
String str1=”java”;    //指向字符串池
String str2=”blog”;   //指向字符串池

String s=str1+str2;   //s是指向堆中值为"javablog"的对象，+运算符会在堆中建立来两个String对象，这两个对象的值分别是"java" "blog". 也就是说从字符串池中复制这两个值，然后在堆中创建两个对象，然后再建立对象s,然后将"javablog"的堆地址赋给s.    这句共创建了?个String 对象！

System.out.println(s==”javablog”);   //结果是false。
Jvm确实对型如String str1=”java”;的String对象放在常量池里，但是它是在编译时那么做的，而String s=str1+str2;是在运行时刻才能知道，也就是说str1+str2是在堆里创建的，所以结果为false了
```



```
3.关于访问权限说法正确 的是 ？ ( )
正确答案: B   你的答案: A (错误)
外部类前面可以修饰public,protected和private
成员内部类前面可以修饰public,protected和private
局部内部类前面可以修饰public,protected和private
以上说法都不正确
```

|            | private | default | protected | public |
| :--------: | ------- | ------- | --------- | ------ |
| 同一个类中 | √       | √       | √         | √      |
| 同一个包中 |         | √       | √         | √      |
|   子类中   |         |         | √         | √      |
| 全局范围内 |         |         |           | √      |

（ 1 ）对于外部类而言，它也可以使用访问控制符修饰，但外部类只能有两种访问控制级别： public 和默认。

​			因为外部类没有处于任何类的内部，也就没有其所在类的内部、所在类的子类两个范围，因此 private 和 protected 访问控制符对外部类没有意义。

（ 2 ）内部类的上一级程序单元是外部类，它具有 4 个作用域：同一个类（ private ）、同一个包（ protected ）和任何位置（ public ）。

（ 3 ） 因为局部成员的作用域是所在方法，其他程序单元永远不可能访问另一个方法中的局部变量，所以所有的局部成员都不能使用访问控制修饰符修饰。



```
4.在java7中，下列不能做switch()的参数类型是？
正确答案: D   你的答案: D (正确)
int型
枚举类型
字符串
浮点型
switch语句后的控制表达式只能是short、char、int、long整数类型和枚举类型，不能是float，double和boolean类型。String类型是java7开始支持。
```





#### 8.12

```
1.下面关于垃圾收集的说法正确的是
正确答案: D   你的答案: B (错误)
一旦一个对象成为垃圾，就立刻被收集掉。
对象空间被收集掉之后，会执行该对象的finalize方法  ||| 回收之前执行才有意义
finalize方法和C++的析构函数是完全一回事情
一个对象成为垃圾是因为不再有引用指着它，但是线程并非如此

    1、在java中，对象的内存在哪个时刻回收，取决于垃圾回收器何时运行。
    2、一旦垃圾回收器准备好释放对象占用的存储空间，将首先调用其finalize()方法， 并且在下一次垃圾回收动作发生时，才会真正的回收对象占用的内存（《java 编程思想》）
    3、在C++中，对象的内存在哪个时刻被回收，是可以确定的，在C++中，析构函数和资源的释放息息相关，能不能正确处理析构函数，关乎能否正确回收对象内存资源。
    在java中，对象的内存在哪个时刻回收，取决于垃圾回收器何时运行，在java中，所有的对象，包括对象中包含的其他对象，它们所占的内存的回收都依靠垃圾回收器，因此不需要一个函数如C++析构函数那样来做必要的垃圾回收工作。当然存在本地方法时需要finalize()方法来清理本地对象。在《java编程思想》中提及，finalize()方法的一个作用是用来回收“本地方法”中的本地对象
    4、线程在其run()方法执行完以后就会释放掉内存，但是其引用不一定不存在了
```



```
2.假设 a 是一个由线程 1 和线程 2 共享的初始值为 0 的全局变量，则线程 1 和线程 2 同时执行下面的代码，最终 a 的结果不可能是（）

boolean isOdd = false;
for(int i=1;i<=2;++i)
{
    if（i%2==1）isOdd = true；
    else isOdd = false；
    a+=i*(isOdd?1:-1)；
}
正确答案: D   你的答案: B (错误)
-1
-2
0
1

易知：每个线程对a 均做了两次读写操作，分别是 “ +1 ” 和 “ -2 ”
而题目问了是最终a 的结果，所以 a 的结果取决于各自线程对 a 的先后读写的顺序
结论：a的可能取值为-1、0、-2
```

![img](https://uploadfiles.nowcoder.com/images/20170701/995326_1498884304176_23ACE3CCE24ADA857BC64F71F3A561F0)



```
3.题目：什么操作会使得当前线程停止。
A：一个InterruptedException 异常被捕获  大家都知道的嘛 （一般通过interrupt方法 中断线程）  如果抓到一个线程  都会关紧catch里面 然后中断当前操作，A正确。
B：线程执行了wait()方法。   线程使用了wait方法，会强行打断当前操作，（暂停状态，不会中断线程） 进入阻塞（暂停）状态，然后需要notify方法或notifyAll方法才能进入就绪状态。 B 正确。
C：当前线程创建了一个新的线程。   新创建的线程不会抢占时间片，只有等当前线程把时间片用完，其他线程才有资格拿到时间片去执行。
D：一个高优先级别的线程就绪。  如C相同，你优先级别再高 也待等我现在弄完才会给你。（就像我们玩游戏，会员虽然有排队优先权，但是还是要等正在登陆的用户进去游戏之后才能抢到他原来那个位置，不能说我在过关卡的过程中你一脚把我踢开，然后霸占我的位置吧，我原来的那些数据咋办！！！）
E：线程在MediaTracker上执行了waitforID（）调用。  
这个应该大家也不太熟悉。这个类是awt里面的，我查API才知道。
然后他的功能是加载图像，直到完成之前，该方法一直等待！这个方法是必须要抛出A选项的InterruptedException 异常的  说明这玩意会让其他线程 wait他完成！   所以会暂停当前线程~~大概是这样吧哈哈哈！ E选项我没选对！ 这还是真的！。！
```



```
4.假如某个JAVA进程的JVM参数配置如下：
-Xms1G -Xmx2G -Xmn500M -XX:MaxPermSize=64M -XX:+UseConcMarkSweepGC -XX:SurvivorRatio=3,
请问eden区最终分配的大小是多少？
正确答案: C   你的答案: C (正确)
64M
500M
300M
100M

Xms 起始内存
Xmx 最大内存
Xmn 新生代内存
Xss 栈大小。 就是创建线程后，分配给每一个线程的内存大小
-XX:NewRatio=n:设置年轻代和年老代的比值。如:为3，表示年轻代与年老代比值为1：3，年轻代占整个年轻代年老代和的1/4
-XX:SurvivorRatio=n:年轻代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：3，表示Eden：Survivor=3：2，一个Survivor区占整个年轻代的1/5
-XX:MaxPermSize=n:设置持久代大小

收集器设置
-XX:+UseSerialGC:设置串行收集器
-XX:+UseParallelGC:设置并行收集器
-XX:+UseParalledlOldGC:设置并行年老代收集器
-XX:+UseConcMarkSweepGC:设置并发收集器

垃圾回收统计信息
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintGCTimeStamps
-Xloggc:filename

并行收集器设置
-XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数。并行收集线程数。
-XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
-XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)

并发收集器设置
-XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
-XX:ParallelGCThreads=n:设置并发收集器年轻代收集方式为并行收集时，使用的CPU数。并行收集线程数。
```



```
5.
A，start是开启线程，run是线程的执行体，run是线程执行的入口。
B，CyclicBarrier和CountDownLatch都可以让一组线程等待其他线程。前者是让一组线程相互等待到某一个状态再执行。后者是一个线程等待其他线程结束再执行。
C，Callable中的call比Runnable中的run厉害就厉害在有返回值和可以抛出异常。同时这个返回值和线程池一起用的时候可以返回一个异步对象Future。
D，start是把线程从new变成了runnable
```



#### 8.13

```
1.有关线程的叙述正确的是()
正确答案: C   你的答案: C (正确)
可以获得对任何对象的互斥锁定。
通过继承Thread类或实现Runnable接口，可以获得对类中方法的互斥锁定。
线程通过使用synchronized关键字可获得对象的互斥锁定。
线程的创建只能通过继承Thread类来实现。

 采用synchronized修饰符实现的同步机制叫做互斥锁机制，它所获得的锁叫做互斥锁。每个对象都有一个monitor(锁标记)，当线程拥有这个锁标记时才能访问这个资源，没有锁标记便进入锁池。任何一个对象系统都会为其创建一个互斥锁，这个锁是为了分配给线程的，防止打断原子操作。每个对象的锁只能分配给一个线程，因此叫做互斥锁。
```



```
2.Java中基本的编程单元为：类，基本存储单元是变量。
```



```
3.以下 _____ 不是 Object 类的方法

正确答案: D   你的答案: C (错误)
clone（）   object没有copy() 但是有clone()
finalize()
toString()
hasNext()  ✖ 这个是遍历器的一个方法。
```



```
4.下面有关servlet的层级结构和常用的类，说法正确的有?

正确答案: A B C D   你的答案: 空 (错误)
GenericServlet类：抽象类，定义一个通用的、独立于底层协议的Servlet。
大多数Servlet通过从GenericServlet或HttpServlet类进行扩展来实现
ServletConfig接口定义了在Servlet初始化的过程中由Servlet容器传递给Servlet得配置信息对象
HttpServletRequest接口扩展ServletRequest接口，为HTTP Servlet提供HTTP请求信息
```

![img](https://uploadfiles.nowcoder.com/images/20170518/1562929_1495091266467_AA89EDF1B0D43CAA9A893C73A1615398)

```
5.往OuterClass类的代码段中插入内部类声明, 哪一个是错误的:
public class OuterClass{
    private float f=1.0f;
    //插入代码到这里
}

正确答案: A B C D   你的答案: B D (错误)

class InnerClass{
	public static float func(){return f;}
}

abstract class InnerClass{
	public abstract float func(){}
}

static class InnerClass{
	protected static float func(){return f;}
}

public class InnerClass{
 	static float func(){return f;}
}

主要考核了这几个知识点：
1.静态内部类才可以声明静态方法 A
2.静态方法不可以使用非静态变量 C D
3.抽象方法不可以有函数体 B
```



#### 8.14

**堆区：只存放类对象，线程共享；**

**方法区：又叫静态存储区，存放class文件和静态数据，线程共享;**

**栈区：存放方法局部变量，基本类型变量区、执行环境上下文、操作指令区，线程不共享;**

```
1.
package algorithms.com.guan.javajicu;  
public class Inc {  
    public static void main(String[] args) {  
       Inc inc = new Inc();  
       int i = 0;  
       inc.fermin(i);  
       i= i ++;  
       System.out.println(i); 
   
    }  
    void fermin(int i){   // 值传递 不是引用传递（应用就会改变啊）
       i++;  
    }  
}  

如果你理解JVM的内存模型，就不难理解为什么答案返回的是0，而不是1。
我们单独看问题中的这两句代码。

int i = 0; i = i++;
Java虚拟机栈（JVM Stack）描述的是Java方法执行的内存模型，而JVM内存模型是基于“栈帧”的，每个栈帧中都有 局部变量表 和 操作数栈 （还有动态链接、return address等），那么JVM是如何执行这个语句的呢？通过javap大致可以将上面的两行代码翻译成如下的JVM指令执行代码。
0: iconst_0
1: istore_1
2: iload_1
3: iinc          1, 1
6: istore_1
7: iload_1

接下来分析一下JVM是如何执行的:
第0：将int类型的0入栈，就是放到操作数栈的栈顶
第1：将操作数栈栈顶的值0弹出，保存到局部变量表 index （索引）值为1的位置。（局部变量表也是从0开始的，0位置一般保存当前实例的this引用，当然静态方法例外，因为静态方法是类方法而不是实例方法）
第2：将局部变量表index 1位置的值的副本入栈。（这时局部变量表index为1的值是0，操作数栈顶的值也是0）
第3：iinc是对int类型的值进行自增操作，后面第一个数值1表示，局部变量表的index值，说明要对此值执行iinc操作，第二个数值1表示要增加的数值。（这时局部变量表index为1的值因为执行了自增操作变为1了，但是操作数栈中栈顶的值仍然是0）
第6：将操作数栈顶的值弹出（值0），放到局部变量表index为1的位置（旧值：1，新值：0），覆盖了上一步局部变量表的计算结果。
第7：将局部变量表index 1位置的值的副本入栈。（这时局部变量表index为1的值是0，操作数栈顶的值也是0）

总结：从执行顺序可以看到，这里第1和第6执行了2次将0赋值给变量i的操作（=号赋值），i++操作是在这两次操作之间执行的，自增操作是对局部变量表中的值进行自增，而栈顶的值没有发生变化，这里需要注意的是保存这个初始值的地方是操作数栈而不是局部变量表，最后再将栈顶的值覆盖到局部变量表i所在的索引位置中去。

有兴趣的同学可以去了解一下JVM的栈帧（Stack Frame）

关于第二个陷阱（为什么 fermin方法没有影响到i的值 ）的解答看下面。
复制代码
1
inc.fermin(i);
1. java方法之间的参数传递是 值传递 而不是 引用传递
2. 每个方法都会有一个栈帧，栈帧是方法运行时的数据结构。这就是说每个方法都有自己独享的局部变量表。（更严谨的说法其实是每个线程在执行每个方法时都有自己的栈帧，或者叫当前栈帧 current stack frame）
3. 被调用方法fermin()的形式参数int i 实际上是调用方法main()的实际参数 i 的一个副本。
4. 方法之间的参数传递是通过局部变量表实现的，main()方法调用fermin()方法时，传递了2个参数：
第0个隐式参数是当前实例（Inc inc = new Inc(); 就是inc引用的副本，引用/reference 是指向对象的一个地址，32位系统这个地址占用4个字节，也就是用一个Slot来保存对象reference，这里传递的实际上是reference的一个副本而不是 reference本身 ）；
第1个显示参数是 i 的一个副本。所以 fermin()方法对 i 执行的操作只限定在其方法独享或可见的局部变量表这个范围内，main()方法中局部变量表中的i不受它的影响；

如果main()方法和fermin()方法共享局部变量表的话，那答案的结果就会有所不同。 其实你自己思考一下，就会发现， JVM虚拟机团队这么设计是有道理的。
```



```
封装主要是隐藏内部代码；
继承主要是复用现有代码；
多态主要是改写对象行为。
```

```
2.下列不属于算法结构的是（）
正确答案: C   你的答案: D (错误)
输入数据
处理数据
存储数据
输出结果

只有输入输出 存储过程是
```



#### 8.15

```java
1.
public abstract class Test {
    public static void main(String[] args) {
        System.out.println(beforeFinally());
    }
    
    public static int beforeFinally(){
        int a = 0;
        try{
            a = 1;
            return a;
        }finally{
            a = 2;
            // return a;
        }
    }
}

从结果上看，貌似`finally` 里的语句是在`return` 之后执行的，其实不然，实际上`finally` 里的语句是在在`return` 之前执行的。那么问题来了，既然是在之前执行，那为什么`a` 的值没有被覆盖了？
实际过程是这样的：当程序执行到try{}语句中的return方法时，它会干这么一件事，将要返回的结果存储到一个临时栈中，然后程序不会立即返回，而是去执行finally{}中的程序， 在执行`a = 2`时，程序仅仅是覆盖了a的值，但不会去更新临时栈中的那个要返回的值 。执行完之后，就会通知主程序“finally的程序执行完毕，可以请求返回了”，这时，就会将临时栈中的值取出来返回。这下应该清楚了，要返回的值是保存至临时栈中的。
    
如果把注释内容打开
    在这里，finally{}里也有一个return，那么在执行这个return时，就会更新临时栈中的值。同样，在执行完finally之后，就会通知主程序请求返回了，即将临时栈中的值取出来返回。故返回值是2.
```



```
2.ResultSet跟普通的数组不同，索引从1开始而不是从0开始.
```



#### 8.16

```
1.下面关于变量及其范围的陈述哪些是不正确的（）

A.类的成员变量包括实例变量和类变量（静态变量）,成员方法包括实例方法和类方法（静态方法）。 A正确
B.类变量（静态变量）用关键字static声明，B错误
C.方法中的局部变量在方法被调用加载时开始入栈时创建，方法入栈创建栈帧包括局部变量表操作数栈，局部变量表存放局部变量，并非在执行该方法时被创建，C错误
D.局部变量被使用前必须初始化，否则程序报错。D正确
```



```
2.下面哪种情况会导致持久区jvm堆内存溢出？

正确答案: C   你的答案: D (错误)
循环上万次的字符串处理
在一段代码内申请上百M甚至上G的内存
使用CGLib技术直接操作字节码运行，生成大量的动态类 - 永久代存放类信息
不断创建对象  - 这个不是在永久代

简单的来说 java的堆内存分为两块:permantspace（持久带） 和 heap space。
持久带中主要存放用于存放静态类型数据，如 Java Class, Method 等， 与垃圾收集器要收集的Java对象关系不大。
而heapspace分为年轻带和年老带 
年轻代的垃圾回收叫 Young GC， 年老代的垃圾回收叫 Full GC。
在年轻代中经历了N次（可配置）垃圾回收后仍然存活的对象，就会被复制到年老代中。因此，可以认为年老代中存放的都是一些生命周期较长的对象
年老代溢出原因有  循环上万次的字符串处理、创建上千万个对象、在一段代码内申请上百M甚至上G的内存，既A B D选项
持久代溢出原因  动态加载了大量Java类而导致溢出
```



```
3.基本类型之间的比较会将低精度转换成高精度。
public class test5 {
    public static void main(String[] args){
        int i=42;
        double d=42.0000;
        long l=42;
        float f=42.0f;
        float f2=42.00f;
        System.out.println(d==i);
        System.out.println(f==i);
        System.out.println(f==f2);
        System.out.println(l==i);
        System.out.println(d==f);
    }
}
```

------



#### 8.17

```
1.下面论述正确的是（）？
正确答案: D   你的答案: C (错误)
如果两个对象的hashcode相同，那么它们作为同一个HashMap的key时，必然返回同样的值
如果a,b的hashcode相同，那么a.equals(b)必须返回true
对于一个类，其所有对象的hashcode必须不同
如果a.equals(b)返回true，那么a,b两个对象的hashcode必须相同
-----------------------------------------------------------------------------------------------------------------------------
    hashCode()方法和equals()方法的作用其实是一样的，在Java里都是用来对比两个对象是否相等一致。
	那么equals()既然已经能实现对比的功能了，为什么还要hashCode()呢？因为重写的equals()里一般比较的比较全面比较复杂，这样效率就比较低，而利用hashCode()进行对比，则只要生成一个hash值进行比较就可以了，效率很高。
	那么hashCode()既然效率这么高为什么还要equals()呢？ 因为hashCode()并不是完全可靠，有时候不同的对象他们生成的hashcode也会一样（生成hash值得公式可能存在的问题），所以hashCode()只能说是大部分时候可靠，并不是绝对可靠，
所以我们可以得出：
1.equals()相等的两个对象他们的hashCode()肯定相等，也就是用equals()对比是绝对可靠的。

2.hashCode()相等的两个对象他们的equal()不一定相等，也就是hashCode()不是绝对可靠的。

所有对于需要大量并且快速的对比的话如果都用equals()去做显然效率太低，所以解决方式是，每当需要对比的时候，首先用hashCode()去对比，如果hashCode()不一样，则表示这两个对象肯定不相等（也就是不必再用equal()去再对比了）,如果hashCode()相同，此时再对比他们的equals()，如果equals()也相同，则表示这两个对象是真的相同了，这样既能大大提高了效率也保证了对比的绝对正确性！

所以选D
```



```
2.代码行float t=5.1; int i=t; ,不正确的是
正确答案: B   你的答案: B (正确)
代码不能编译
代码编译, i被设置为5
第二行若改为 int i=(byte)t ，并结合D选项，则可编译
第一行若改为 float t=5.1f ，并结合C选项，则可编译

正确的写法应该是：float t = 5.1f;int i = (int)t;
```



```
3.执行如下程序代码
char chr = 127;
int sum = 200;
chr += 1;
sum += chr;
后，sum的值是   ; （  java-328  c/c++-72 ）
备注：同时考虑c/c++和Java的情况的话
正确答案: A C   你的答案: C (错误)
72
99
328
327

对java来说，char基本类型占用两个字节，所以不会溢出
但是c/c++来说，char只有一个字节，也就在范围 -128~127 加上1之后就溢出了0111 1111 --> 1000 0000, 补码1000 0000代表-128, 所以结果为200-128=72
```



```
4.类之间存在以下几种常见的关系：
USES-A：依赖关系，A类会用到B类，这种关系具有偶然性，临时性。但B类的变化会影响A类。这种在代码中的体现为：A类方法中的参数包含了B类。
	   关联关系：A类会用到B类，这是一种强依赖关系，是长期的并非偶然。在代码中的表现为：A类的成员变量中含有B类。
HAS-A：聚合关系，拥有关系，是关联关系的一种特例，是整体和部分的关系。比如鸟群和鸟的关系是聚合关系，鸟群中每个部分都是鸟。
IS-A：表示继承。父类与子类，这个就不解释了。
要注意：还有一种关系：组合关系也是关联关系的一种特例，它体现一种contains-a的关系，这种关系比聚合更强，也称为强聚合。它同样体现整体与部分的关系，但这种整体和部分是不可分割的。
```



```
5.若所用变量都已正确定义，以下选项中，非法的表达式是（'a'是字符常量，常量不能赋值）

正确答案: C   你的答案: C (正确)
a!= 4||b==1
’a’ % 3
’a’ = 1/3
’A’ + 32
```



```
6.以下说法错误的是（）

正确答案: D   你的答案: D (正确)
虚拟机中没有泛型，只有普通类和普通方法
所有泛型类的类型参数在编译时都会被擦除
创建泛型对象时请指明类型，让编译器尽早的做参数检查
泛型的类型擦除机制意味着不能在运行时动态获取List<T>中T的实际类型

1、创建泛型对象的时候，一定要指出类型变量T的具体类型。争取让编译器检查出错误，而不是留给JVM运行的时候抛出类不匹配的异常。 
2、JVM如何理解泛型概念 —— 类型擦除。事实上，JVM并不知道泛型，所有的泛型在编译阶段就已经被处理成了普通类和方法。 
	处理方法很简单，我们叫做类型变量T的擦除(erased) .
	总结：泛型代码与JVM 
	① 虚拟机中没有泛型，只有普通类和方法。 
	② 在编译阶段，所有泛型类的类型参数都会被Object或者它们的限定边界来替换。(类型擦除) 
	③ 在继承泛型类型的时候，桥方法的合成是为了避免类型变量擦除所带来的多态灾难。 
	无论我们如何定义一个泛型类型，相应的都会有一个原始类型被自动提供。原始类型的名字就是擦除类型参数的泛型类型的名字。
```



#### 8.18

```
1.下面赋值语句中正确的是（）

正确答案: A   你的答案: A (正确)
double d=5.3e12; 科学计数法 没问题
float f=11.1; 需要强制转换
int i=0.0;    需要强制转换
Double oD=3;  会转换成double，但是不会自动装箱，两个只能帮你一个
```



```
2.
public class CharToString {
 public static void main(String[] args)
 {
  char myChar = 'g';
  String myStr = Character.toString(myChar);
  System.out.println("String is: "+myStr);
  myStr = String.valueOf(myChar);
  System.out.println("String is: "+myStr);
 }
}

String is: g
String is: g

返回值是String
```



```
3.
A，java的内存回收是自动的，Gc在后台运行，不需要用户手动操作
B，java中不允许使用指针
C,内存回收线程负责释放无用内存
D，内存回收线程可以释放无用的对象内存
```



```
4.在各自最优条件下,对N个数进行排序,哪个算法复杂度最低的是? （）

正确答案: A   你的答案: D (错误)
插入排序
快速排序
堆排序
归并排序
```

![img](https://uploadfiles.nowcoder.com/images/20190727/5227440_1564208997208_C0C78CE31C2575E39A0EE7AE31E20FB8)



```
5.关于ThreadLocal类 以下说法正确的是
正确答案: D E   你的答案: D E (正确)
ThreadLocal继承自Thread  没有，他只是一个普通类
ThreadLocal实现了Runnable接口  没有
ThreadLocal重要作用在于多线程间的数据共享
ThreadLocal是采用哈希表的方式来为每个线程都提供一个变量的副本
ThreadLocal保证各个线程间数据安全，每个线程的数据不会被另外线程访问和破坏

1、ThreadLocal的类声明：
public class ThreadLocal<T>
可以看出ThreadLocal并没有继承自Thread，也没有实现Runnable接口。所以AB都不对。

2、ThreadLocal类为每一个线程都维护了自己独有的变量拷贝。每个线程都拥有了自己独立的一个变量。
所以ThreadLocal重要作用并不在于多线程间的数据共享，而是数据的独立，C选项错。
由于每个线程在访问该变量时，读取和修改的，都是自己独有的那一份变量拷贝，不会被其他线程访问，
变量被彻底封闭在每个访问的线程中。所以E对。

3、ThreadLocal中定义了一个哈希表用于为每个线程都提供一个变量的副本：
 static class ThreadLocalMap {

        static class Entry extends WeakReference<ThreadLocal> {
            /** The value associated with this ThreadLocal. */
            Object value;

            Entry(ThreadLocal k, Object v) {
                super(k);
                value = v;
            }
        }

        /**
         * The table, resized as necessary.
         * table.length MUST always be a power of two.
         */
        private Entry[] table;
}
所以D对。
```



#### 8.19

```
1.下列说法正确的是( )
正确答案: C   你的答案: A (错误)
volatile,synchronized 都可以修改变量，方法以及代码块
volatile，synchronized 在多线程中都会存在阻塞问题
volatile能保证数据的可见性，但不能完全保证数据的原子性，synchronized即保证了数据的可见性也保证了原子性
volatile解决的是变量在多个线程之间的可见性、原子性，而sychroized解决的是多个线程之间访问资源的同步性

volatile -禁止指令重排序 -变量线程可见性 -不能保证原子性
synchronized 可见性。原子性。有序性。

volatile是轻量级的线程同步，volatile只能用于变量。而synchronized可以用在方法和代码块。

volatile在多线程下不会阻塞，synchronized可能会阻塞。
```



```
2.0可以作为除数，不能作为被除数....搞错了这个我
public class Test
{  
    public static int aMethod(int i)throws Exception
    {
        try{
            return i/10; // 这里会正常执行
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a aMethod");
        }finally{
      		System.out.printf("finally");
        }
	} 
    public static void main(String[] args){
        try
        {
            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
}

finally exception in main finished 如果函数那里有问题。
```



```
3.自动转型 问题。
byte a = 3;
byte b = 2;
//b = (byte) (a+b); // 需要手动强转
a += b; // 自动强转

byte c = 126;
byte d = 127;
//c += d;

System.out.println(c+d);


byte类型的变量在做运算时被会转换为int类型的值，故A、B左为byte，右为int，会报错；
而C、D语句中用的是a+=b的语句，此语句会将被赋值的变量自动强制转化为相对应的类型。
```



```
4.下面有关java object默认的基本方法，说法错误的是？
正确答案: B   你的答案: B (正确)
equals(Object obj) 指示某个其他对象是否与此对象“相等”
copy() 创建并返回此对象的一个副本 ✖ 只有clone方法
wait() 导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法
toString() 返回该对象的字符串表示
```



```
5.下列有关JAVA异常处理的叙述中正确的是（）

正确答案: A B D   你的答案: A B C D (错误)
finally是为确保一段代码不管是否捕获异常都会被执行的一段代码
throws是用来声明一个成员方法可能抛出的各种非运行异常情况
final用于可以声明属性和方法，分别表示属性的不可变及方法的不可继承 ✖
throw是用来明确地抛出一个异常情况

C：final用于可以声明属性和方法，分别表示属性的不可变及方法的不可覆盖。不是方法的不可继承
```



#### 8.20

```
1.下面叙述那个是正确的？（）
正确答案: B   你的答案: A (错误)
java中的集合类（如Vector）可以用来存储任何类型的对象，且大小可以自动调整。但需要事先知道所存储对象的类型，才能正常使用。
在java中，我们可以用违例（Exception）来抛出一些并非错误的消息，但这样比直接从函数返回一个结果要更大的系统开销。
java接口包含函数声明和变量声明。
java中，子类不可以访问父类的私有成员和受保护的成员。

A.vector是线程安全的ArrayList，在内存中占用连续的空间。初始时有一个初始大小，当数据条数大于这个初始大小后会重写分配一个更大的连续空间。如果Vector定义为保存Object则可以存放任意类型。

B.try{}catch{}会增加额外的开销
选项说的情况就是我们自定义异常的情况，请仔细读：
我们可以用违例（Exception）来抛出一些并非错误的消息，可以，并非错误的消息。
比如我自定义一个异常，若一个变量大于10就抛出一个异常，这样就对应了B选项说的情况，我用抛出异常说明这个变量大于10，而不是用一个函数体（函数体内判断是否大于10，然后返回true或false）判断，因为函数调用是入栈出栈，栈是在寄存器之下的速度最快，且占的空间少，而自定义异常是存在堆中，肯定异常的内存开销大！所以B对。


C选项说的是接口包含方法声明和变量声明。
因为接口中方法默认是 abstract public,所以在接口只写函数声明是符合语法规则。
但是变量默认是用public final static 修饰的，意思它是静态常量，常量不管在接口中还是类中必须在声明时初始化！所以C的后半句是错的，必须在声明时并给出初始化！
```



```
2.从内存实现或者反射的角度来看，关于继承的说法正确的是（）。
注：此处的继承不代表能调用
正确答案: A   你的答案: B (错误)
子类将继承父类的所有的数据域和方法
子类将继承父类的其可见的数据域和方法
子类只继承父类public方法和数据域
子类只继承父类的方法，而不继承数据域

只是继承了不一定有权限使用，题目有注明。
```



```
3.设int x=1,float y=2,则表达式x/y的值是：（） 0.5 最大精度说了算

本题的意义在于两点，明白这两点之后题会不会本身就不重要了：
①float x = 1；与float x = 1.0f，这两种对于float类型的变量来说定义的方式都是正确的，也是比较常见的笔试题里面考察类型转换的例子，当第一种情况时，是将低精度int向上转型到float，是由于java的特性导致而不需要进行强制转换，而第二种情况则是比较正式的对于float变量的定义，由于这种类型本身在工作项目中并不常见，常用的带小数的数字我们一般都直接使用double类型，而double类型直接定义是没有问题的：double x = 1.0。而由于float的精度没有double类型高，因此必须对其进行显示的格式书写，如果没有这个f，就默认是double类型了。当然double x = 1.0d也是正确的命名，不信你可以尝试，虽然这是一个令人窒息的操作。

②当多个精度的数字同时进行运算时，最终结果以最高精度为准。在多数情况下，整数和小数的各级混合运算中，一般结果都是double类型的。但就本题而言，结果是float类型的，因为x，y两个数字精度最高的就是float，所以最终结果是0.5，并且这个0.5是float类型的。为什么说不是double类型呢，当然如果你这样处理：double m = x/y，当然m是double类型的，也不会报错，而如果你写成int m = x/y，编译器报错提示的时候就会让你转换成float或者进行强制转换成int，他是不会提示你转换成double的，尽管这么写并没有报错，原因就是①
中所说的向上强转。float转换成double不需要任何提示。

1.0默认是double
float t = (float) 1.0;
float t1 =  1.0f;
```



```java
4.这个不会啊
class C {
    C() {
        System.out.print("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.print("A");
    }

    A(String s) {
        System.out.print(s);
    }
}

class Test extends A {
    Test() {
        super("B");
        System.out.print("B");
    }

    public static void main(String[] args) {
        new Test();
    }
}
```

```
初始化过程是这样的： 
1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化； 
2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化； 
3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法； 
 
（1）初始化父类的普通成员变量和代码块，执行 C c = new C(); 输出C 
（2）super("B"); 表示调用父类的构造方法，不调用父类的无参构造函数，输出B 
（3） System.out.print("B"); 
 所以输出CBB
```



#### 8.21

```
1.
A，接口中方法的默认修饰符时public abstract，抽象方法可是没有方法体的，没有大括号{}
B，JDK8中，接口中的方法可以被default和static修饰，但是！！！被修饰的方法必须有方法体。
C，注意一下，接口是可以多继承的。整个没毛病，和A选项一样，抽象方法不能有方法体
接口中的方法默认为public abstract，属性默认为public static final。
```



```java
2.假设如下代码中，若t1线程在t2线程启动之前已经完成启动。代码的输出是（Thread 2 sent notify.Thread 1 wake up.）
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

执行obj.wait();时已释放了锁，所以t2可以再次获得锁，然后发消息通知t1执行，但这时t2还没有释放锁，所以肯定是执行t2，然后释放锁，之后t1才有机会执行。
```

```
线程间协作：wait、notify、notifyAll
在 Java 中，可以通过配合调用 Object 对象的 wait() 方法和 notify()方法或 notifyAll() 方法来实现线程间的通信。在线程中调用 wait() 方法，将阻塞等待其他线程的通知（其他线程调用 notify() 方法或 notifyAll() 方法），在线程中调用 notify() 方法或 notifyAll() 方法，将通知其他线程从 wait() 方法处返回。

Object 是所有类的超类，它有 5 个方法组成了等待/通知机制的核心：notify()、notifyAll()、wait()、wait(long)和 wait(long，int)。在 Java 中，所有的类都从 Object 继承而来，因此，所有的类都拥有这些共有方法可供使用。而且，由于他们都被声明为 final，因此在子类中不能覆写任何一个方法。

这里详细说明一下各个方法在使用中需要注意的几点。

wait()
public final void wait() throws InterruptedException,IllegalMonitorStateException
该方法用来将当前线程置入休眠状态，直到接到通知或被中断为止。在调用 wait()之前，线程必须要获得该对象的对象级别锁，即只能在同步方法或同步块中调用 wait()方法。进入 wait()方法后，当前线程释放锁。在从 wait()返回前，线程与其他线程竞争重新获得锁。如果调用 wait()时，没有持有适当的锁，则抛出 IllegalMonitorStateException，它是 RuntimeException 的一个子类，因此，不需要 try-catch 结构。

notify()
public final native void notify() throws IllegalMonitorStateException
该方法也要在同步方法或同步块中调用，即在调用前，线程也必须要获得该对象的对象级别锁，的如果调用 notify()时没有持有适当的锁，也会抛出 IllegalMonitorStateException。

该方法用来通知那些可能等待该对象的对象锁的其他线程。如果有多个线程等待，则线程规划器任意挑选出其中一个 wait()状态的线程来发出通知，并使它等待获取该对象的对象锁（notify 后，当前线程不会马上释放该对象锁，wait 所在的线程并不能马上获取该对象锁，要等到程序退出 synchronized 代码块后，当前线程才会释放锁，wait所在的线程也才可以获取该对象锁），但不惊动其他同样在等待被该对象notify的线程们。当第一个获得了该对象锁的 wait 线程运行完毕以后，它会释放掉该对象锁，此时如果该对象没有再次使用 notify 语句，则即便该对象已经空闲，其他 wait 状态等待的线程由于没有得到该对象的通知，会继续阻塞在 wait 状态，直到这个对象发出一个 notify 或 notifyAll。这里需要注意：它们等待的是被 notify 或 notifyAll，而不是锁。这与下面的 notifyAll()方法执行后的情况不同。

notifyAll()
public final native void notifyAll() throws IllegalMonitorStateException
该方法与 notify ()方法的工作方式相同，重要的一点差异是：

notifyAll 使所有原来在该对象上 wait 的线程统统退出 wait 的状态（即全部被唤醒，不再等待 notify 或 notifyAll，但由于此时还没有获取到该对象锁，因此还不能继续往下执行），变成等待获取该对象上的锁，一旦该对象锁被释放（notifyAll 线程退出调用了 notifyAll 的 synchronized 代码块的时候），他们就会去竞争。如果其中一个线程获得了该对象锁，它就会继续往下执行，在它退出 synchronized 代码块，释放锁后，其他的已经被唤醒的线程将会继续竞争获取该锁，一直进行下去，直到所有被唤醒的线程都执行完毕。

深入理解
如果线程调用了对象的 wait()方法，那么线程便会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁。

当有线程调用了对象的 notifyAll()方法（唤醒所有 wait 线程）或 notify()方法（只随机唤醒一个 wait 线程），被唤醒的的线程便会进入该对象的锁池中，锁池中的线程会去竞争该对象锁。

优先级高的线程竞争到对象锁的概率大，假若某线程没有竞争到该对象锁，它还会留在锁池中，唯有线程再次调用 wait()方法，它才会重新回到等待池中。而竞争到对象锁的线程则继续往下执行，直到执行完了 synchronized 代码块，它会释放掉该对象锁，这时锁池中的线程会继续竞争该对象锁。
```



```java
3.输出P is init<br />123
public class P {
    public static int abc = 123;
    static{
    	System.out.println("P is init");
    }
}
public class S extends P {
    static{
    	System.out.println("S is init");
    }
}
public class Test {
    public static void main(String[] args) {
    	System.out.println(S.abc);
    }
}

属于被动引用不会出发子类初始化 
 1.子类引用父类的静态字段，只会触发子类的加载、父类的初始化，不会导致子类初始化 
 2.通过数组定义来引用类，不会触发此类的初始化 
 3.常量在编译阶段会进行常量优化，将常量存入调用类的常量池中， 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
```



```
5.What results from the following code fragment?
int i = 5;
int j = 10;
System.out.println(i + ~j);

答案：-6  int 4个字节也就是32bit
10原码：0000000000000000,0000000000001010；
~10： 1111111111111111,1111111111110101  变为负数，计算机用补码存储
~10反码：10000000000000000,0000000000001010
~10补码：10000000000000000,0000000000001011，等于 -11
故程序结果-6
```



#### 8.22

```
1.
  	String str = "";
    System.out.println(str.split(",").length);
    for (String s : str.split(",")) {
    System.out.println("数组里面是"+s+"--");
    
    1：String获取长度用的是length（）方法，而数组类型我们直接用属性length获取长度，所以String[]数组类型我们应该用length获取长度；
    2：总结来说，因为原字符串不包含分隔符，所以直接返回原字符串，分割出来只有一个空的字符串数组，所以结果是1.（注意，虽然原字符串为空，存到字符串数组为空，但是这个空也会算一个元素。）
    split返回的是一个数组
```



#### 8.25

```java
1.输出 1.0  1
public static void main(String[] args) {
    Object o1 = true ? new Integer(1) : new Double(2.0);
    Object o2;
    if (true) {
        o2 = new Integer(1);
    } else {
        o2 = new Double(2.0);
    }
    System.out.print(o1);
    System.out.print(" ");
    System.out.print(o2);
}

三元操作符类型的转换规则：
1.若两个操作数不可转换，则不做转换，返回值为Object类型
2.若两个操作数是明确类型的表达式（比如变量），则按照正常的二进制数字来转换，int类型转换为long类型，long类型转换为float类型等。
3.若两个操作数中有一个是数字S,另外一个是表达式，且其类型标示为T，那么，若数字S在T的范围内，则转换为T类型；若S超出了T类型的范围，则T转换为S类型。
4.若两个操作数都是直接量数字，则返回值类型为范围较大者

符合4，所以选D.
```



```java
2.脑子瓦特了
  基本数据类型均可任意互相转换。
    
布尔值怎么转换？
还有强转，会丢失数据
```



```java
3.java语言的下面几种数组复制方法中，哪个效率最高？
正确答案: B   你的答案: D (错误)
for 循环逐一复制
System.arraycopy
Array.copyOf
使用clone方法
    
    复制的效率System.arraycopy>clone>Arrays.copyOf>for循环，这个有兴趣自己测试一下就知道了。这里面在System类源码中给出了arraycopy的方法，是native方法，也就是本地方法，肯定是最快的。而Arrays.copyOf(注意是Arrays类，不是Array)的实现，在源码中是调用System.copyOf的，多了一个步骤，肯定就不是最快的。前面几个说System.copyOf的不要看，System类底层根本没有这个方法，自己看看源码就全知道了。
```



#### 8.29

```
1.下面哪些情况下需要使用抽象类？
正确答案: A B D   你的答案: A B D (正确)
当一个类的一个或多个方法是抽象方法时
当类是一个抽象类的子类，并且不能为任何抽象方法提供任何实现细节或方法体时
当一个类实现多个接口时（可以实现里面的方法吗没说）
当一个类实现一个接口，并且不能为任何抽象方法提供实现细节或方法体时

主要是C选项
C：普通类本来就可以实现多个接口，接口可以多实现，但是类不能多继承，除了接口本身可以多继承接口，接口也不能被多继承，抽象类也不可以！！
```



```
2.以下哪一个正则表达式不能与字符串“https://www.tensorflow.org/”（不含引号）匹配？（）

正确答案: B   你的答案: C (错误)
+ 是一个或多个
？是0个或一个
[]是不能重复的

[a-z]+://[a-z.]+/
https[://]www[.]tensorflow[.]org[/]
[htps]+://www.tensorflow.org/
[a-zA-Z.:/]+

```



#### 装箱

**为什么要有装箱，因为java很多地方要使用对象，而不是基本数据类型，比如在集合类中，我们无法将int,double 等类型放进去的，因为集合的容器要求的元素是Object类型的，这也就是为什么会有包装类型的原因。**

**具有对象的特点，增加了属性和方法，丰富了基本类型的操作；**

Integer 包装类型的话大小-128~127是存放在常量池的。

Double是都是new Double()也就是都在堆里。

```
// 不会装箱
Integer i = new Integer(1);
System.out.println(i);

// 自动装箱 valueOf(int)
Integer i1 = 1;
System.out.println(i1);

System.out.println(i == i1); // false
```

|   **int 4字节**   |  **Integer**  |
| :---------------: | :-----------: |
|  **byte 1字节**   |   **Byte**    |
|  **short 2字节**  |   **Short**   |
|  **long 8字节**   |   **Long**    |
|  **float 4字节**  |   **Float**   |
| **double 8字节**  |  **Double**   |
|  **char 2字节**   | **Character** |
| **boolean 1字节** |  **Boolean**  |



#### 8.30

```java
1.java7后关键字 switch 支不支持字符串作为条件：（）

正确答案: A   你的答案: A (正确)
支持
不支持
    
switch(exp)，在JDK7之前，只能是byte、short、char、int或者对应的包装类，或者枚举常量（内部也是由整型或字符类型实现）。
为什么必须是这些呢，因为其实exp只是对int型支持的，其他都是因为可以自动拆卸或者自动向上转型到int，所以才可以。
到了JDK7的时候，String被引入了，为什么String能被引入呢？
其实本质上还是对int类型值得匹配。
原理如下，通过对case后面得String对象调用hashCode方法，得到一个int类型得hash值，然后用这个hash值来唯一标识这个case。那么当匹配时，首先调用exp的hashCode，得到exp的hash值，用这个hash值来匹配所有case，如果没有匹配成功，就说明不存在；如果匹配成功了，接着会调用字符串的equals方法进行匹配。（hash值一致，equals可不一定返回的就是true）。
所以，exp不能为null，cas子句使用的字符串也不能为null，不然会出现空指针异常。
```



```
2.Math.round(11.5) 等于多少 (). Math.round(-11.5) 等于多少 (  ).
正确答案: C   你的答案: C (正确)
11 ,-11
11 ,-12
12 ,-11
12 ,-12

floor ： 意为地板，指向下取整，返回不大于它的最大整数 
ceil ： 意为天花板，指向上取整，返回不小于它的最小整数 
round ： 意为大约，表示“四舍五入”，而四舍五入是往大数方向入。
Math.round(11.5)的结果为12，
Math.round(-11.5)的结果为-11而不是-12。
```



```
3.以下表达式中，正确的是（）
正确答案: C D   你的答案: D (错误)
byte i=128
boolean i=null
long i=0xfffL
double i=0.9239d
```

一个字节是8位，最高位是符号位，最高位为0则是正数。最高位为1则是负数

如果一个数是正数，最大数则为：01111111，转为十进制为127，

如果一个数是负数，按照一般人都会觉得是11111111，转为十进制为-127，

**但是**：一个+0表示为：00000000，一个-0表示为：1000000，因为符号位不算在里面，所以就会有两个0，所以从一开始发明二进制的时候，就把-0规定为-128，如此二进制的补码就刚好在计算机中运作中吻合。（这是国内教材中的解释）

公式：计算一个数据类型的数据大小范围：-2^（字节数*8-1）~2^(字节数*8-1)-1



```
复习复习JVM GC
1，新生代：
（1）所有对象创建在新生代的Eden区，当Eden区满后触发新生代的Minor GC，将Eden区和非空闲Survivor区存活的对象复制到另外一个空闲的Survivor区中。
（2）保证一个Survivor区是空的，新生代Minor GC就是在两个Survivor区之间相互复制存活对象，直到Survivor区满为止。

2，老年代：当Survivor区也满了之后就通过Minor GC将对象复制到老年代。老年代也满了的话，就将触发Full GC，针对整个堆（包括新生代、老年代、持久代）进行垃圾回收。

3，持久代：持久代如果满了，将触发Full GC。
```



```
4.以下不是修饰符final的作用的是( )。

正确答案: C   你的答案: A (错误)
修饰常量
修饰不可被继承的类
修饰不可变类
修饰不可覆盖的方法

基本类型变量只赋值一次，也就是常量。
final的作用：
    1. 修饰变量，变量的引用地址不可变，但是地址中的内容可以变。
    2. 修饰方法，方法不可被重写，但是还是可以重载
    3. 修饰类，类不可继承。
    
什么是不可变类，说的是一个类一旦被实例化，就不可改变自身的状态。常见的比如String和基本数据类型的包装类，对于这种不可变类，一旦在进行引用传递的时候，形参一开始就和实际参数指向的不是一个地址，所以在方法中对形参的改变，并不会影响实际参数。
```



#### 8.31

八月的尾巴抓不住了... 希望下半年身体好点

```
1.下列方法中哪个是线程执行的方法？ （）
正确答案: A   你的答案: A B C D (错误)
run（）
start（）
sleep（）
suspend（）
```



```
2.
is-a   表示继承：Gadget is-a Widget就表示Gadget 继承 Widget；
has-a表示从属：Gadget has-a Sprocket就表示Gadget中有Sprocket的引用，Sprocket是Gadget的组成部分；
like-a表示组合：如果A like-a B，那么B就是A的接口
```



```
3.
Java语言中，下面哪个语句是创建数组的正确语句？(     )
正确答案: A B D E   你的答案: A D (错误)
float f[][] = new float[6][6];
float []f[] = new float[6][6];
float f[][] = new float[][6];
float [][]f = new float[6][6];
float [][]f = new float[6][];

出乎意料的是B选项，这也可以吗？还真的没试过。
第一个小框框必须要有值，如果没有就不行。
```



```
4.
下面的switch语句中，x可以是哪些类型的数据：()
switch(x)
{
	default:
	System.out.println("Hello");
}

正确答案: B D   你的答案: A B C D E (错误)
long
char
float
byte
double
Object

以java8为准，switch支持10种类型 
基本类型：byte char short int 
对于包装类 ：Byte,Short,Character,Integer String enum 
2、实际只支持int类型 Java实际只能支持int类型的switch语句，那其他的类型时如何支持的 
a、基本类型byte char short 原因：这些基本数字类型可自动向上转为int, 实际还是用的int。 
b、基本类型包装类Byte,Short,Character,Integer 原因：java的自动拆箱机制 可看这些对象自动转为基本类型 
c、String 类型 原因：实际switch比较的string.hashCode值，它是一个int类型 如何实现的，网上例子很多。此处不表。 
d、enum类型 原因 ：实际比较的是enum的ordinal值（表示枚举值的顺序），它也是一个int类型 所以也可以说 switch语句只支持int类型
```



```
5.下面哪个标识符是合法的？
正确答案: D   你的答案: A (错误)
"9HelloWorld"
"_Hello World"
"Hello*World"
"Hello$World"

标识符是字母开头，数字和_和$ 组成，不能有空格，不能有其他符号，只能以_或者字母开头。
```



```
6.关于Java中的数组，下面的一些描述，哪些描述是准确的：（    ）
正确答案: A C F   你的答案: C D F (错误)
数组是一个对象，不同类型的数组具有不同的类
数组长度是可以动态调整的  不可以的
数组是一个连续的存储结构
一个固定长度的数组可类似这样定义: int array[100]  应该是int[] array = new int[100];
两个数组用equals方法比较时，会逐个便利其中的元素，对每个元素进行比较  没有重写，所以只是比较地址
可以二维数组，且可以有多维数组，都是在Java中合法的
```

Object.equals()比较的是两个数组的地址，相当于==的作用，如果是遍历数组中的元素，进行一一比较，应该选择Arrays.equals()



```java
7.list是一个ArrayList的对象，哪个选项的代码填到//todo delete处，可以在Iterator遍历的过程中正确并安全的删除一个list中保存的对象？（）

Iterator it = list.iterator();
int index = 0;
while (it.hasNext())
{
    Object obj = it.next();
    if (needDelete(obj))  //needDelete返回boolean，决定是否要删除
    {
        //todo delete
    }
    index ++;
}

正确答案: A   你的答案: C (错误)
it.remove();
list.remove(obj);
list.remove(index);
list.remove(obj,index);

A
Iterator  支持从源集合中安全地删除对象，只需在 Iterator 上调用 remove() 即可。这样做的好处是可以避免 ConcurrentModifiedException ，当打开 Iterator 迭代集合时，同时又在对集合进行修改。有些集合不允许在迭代时删除或添加元素，但是调用 Iterator 的remove() 方法是个安全的做法。
    
源码是这么描述的：ArrayList 继承了 AbstractList， 其中AbstractList 中有个modCount 代表了集合修改的次数。在ArrayList的iterator方法中会判断 expectedModCount与 modCount是否相等，如果相等继续执行，不相等报错，只有iterator的remove方***在调用自身的remove之后让 expectedModCount与modCount再相等，所以是安全的。
    
不能连续两次remove()
```



### 9月

> 这个月开始为期半年的实习，不知道路会变得怎么样，但是不管怎么样，先加把劲把工作先完成好啊！
>
> 其次就是继续准备明年的春招，或者其他招聘，反正除了搞项目的时间，其他就努力研究基础知识呀！

#### 9.1

```
1.下列整型常量 i 的定义中，正确的是(  )
正确答案: C   你的答案: B (错误)
final i;
static int i;
static final int  i=234;
final float i=3.14f;

整型 常量....
```



```java
2.
public class test1 {
    static String s;
    public static void main(String[] args) {
        String s1;
        System.out.println(s);
        //System.out.println(s1);

    }
}

s可以不用初始化也能使用，直接就是null
但是s1就不行，你最多只能先声明，但是使用的时候一定要初始化。
```



```java
3.皇上作为对象，太监作为IOC容器，当皇上要挑选妃子晚上睡觉的时候，不用管，只要到床上即可。太监则根据皇上喜好(找到对应依赖或其他对象)，找到对应的妃子送到皇上榻上。
```





#### 9.6

```
1.有关线程的叙述正确的是()
正确答案: C D   你的答案: A C (错误)
A.可以获得对任何对象的互斥锁定  ||  你能获得没有访问权限的吗？？？
B.通过继承Thread类或实现Runnable接口，可以获得对类中方法的互斥锁定  || 只是创建线程哦
C.线程通过使用synchronized关键字可获得对象的互斥锁定
D.线程调度算法是平台独立的  || 线程调度分为协同式调度和抢占式调度，java是抢占式，也就是由操作系统来分配时间（协同式调度就是由线程本身来决定。）
```



```
2.关于volatile关键字，下列描述不正确的是？
正确答案: B D   你的答案: B C D (错误)
用volatile修饰的变量，每次更新对其他线程都是立即可见的。
对volatile变量的操作是原子性的。
对volatile变量的操作不会造成阻塞。
不依赖其他锁机制，多线程环境下的计数器可用volatile实现。

回顾一下：volatile就是变量线程可见以及禁止指令重排序！但是没有原子性
C我确实不太知道，有时volatile的操作不会被保存，说明不会造成阻塞。
```



```
3.当编译并运行下面程序时会发生什么结果（D）
public class Bground extends Thread{
    public static void main(String argv[]){
        Bground b = new Bground();
        b.run();
    }
    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("Value of i = "+i);
        }
    }
}

正确答案: D   你的答案: A (错误)
编译错误，指明run方法没有定义
运行错误，只鞥呢run方法没有定义
编译通过并输出0到9
编译通过，但无输出

这里只继承了但是没有重写，所以还是thread里面的空run()方法。
```



```
4.执行下列代码的输出结果是( 30 )
public class Demo{
　public static void main(String args[]){
　　　int num = 10;
　　　System.out.println(test(num));
}
public static int test(int b){
　　　try
　　　{
　　　　b += 10;
　　　　return b;
　　　}
　　　catch(RuntimeException e)
　　　{
　　　}
　　　catch(Exception e2)
　　　{
　　　}
　　　finally
　　　{
　　　　b += 10;
　　　　return b;
　　　}
　　}
}

结论一：

return语句并不是函数的最终出口，如果有finally语句，这在return之后还会执行finally（return的值会暂存在栈里面，等待finally执行后再返回）
结论二：

finally里面不建议放return语句，根据需要，return语句可以放在try和catch里面和函数的最后。可行的做法有四：
（1）return语句只在函数最后出现一次。
（2）return语句仅在try和catch里面都出现。
（3）return语句仅在try和函数的最后都出现。
（4）return语句仅在catch和函数的最后都出现。
注意，除此之外的其他做法都是不可行的，编译器会报错
```





### 11月

#### 11.11

```java
1.对于构造方法，下列叙述正确的是（ ）。
正确答案: A C D   你的答案: C D (错误)
构造方法的优先级一般比代码块低。
构造方法的返回类型只能是void型。 没有返回值
构造方法的主要作用是完成对类的对象的初始化工作。 
一般在创建新对象时，系统会自动调用构造方法。
    
A 静态成员变量或静态代码块>main方法>非静态成员变量或非静态代码块>构造方法
  构造方法的作用是创建对象的时候给属性赋初值
  静态代码块是每次加载类执行一次，实例代码块或者叫非静态代码块就每次创建对象都执行一次。
```



```
1.bootstrap classloader －引导（也称为原始）类加载器，它负责加载Java的核心类。 
2.extension classloader －扩展类加载器，它负责加载JRE的扩展目录（JAVA_HOME/jre/lib/ext或者由java.ext.dirs系统属性指定的）中JAR的类包。 
3.system classloader －系统（也称为应用）类加载器，它负责在JVM被启动时，加载来自在命令java中的-classpath或者java.class.path系统属性或者 CLASSPATH 作系统属性所指定的JAR类包和类路径。
4.User Custom ClassLoader/用户自定义类加载器(java.lang.ClassLoader的子类)
在程序运行期间, 通过java.lang.ClassLoader的子类动态加载class文件, 体现java动态实时类装入特性
```



```
-Xmx10240m：代表最大堆
 -Xms10240m：代表最小堆
 -Xmn5120m：代表新生代
 -XXSurvivorRatio=3：代表Eden:Survivor = 3    根据Generation-Collection算法(目前大部分JVM采用的算法)，一般根据对象的生存周期将堆内存分为若干不同的区域，一般情况将新生代分为Eden ，两块Survivor；    计算Survivor大小， Eden:Survivor = 3，总大小为5120,3x+x+x=5120  x=1024
新生代大部分要回收，采用Copying算法，快！
老年代 大部分不需要回收，采用Mark-Compact算法
```



```
while（）中表达式的判断，在C语言中大于0的int值都会被认为是true，而java中没有这个机制，必须是boolean类型的。
```



```
finally一定会在return之前执行，但是如果finally使用了return或者throw语句，将会使trycatch中的return或者throw失效
```



#### 11.13

![img](https://uploadfiles.nowcoder.com/images/20200209/5571214_1581249080981_849A4BAB861AC41B9E77D6F856A5E22E)

![img](https://uploadfiles.nowcoder.com/images/20190109/242025553_1547012774538_BA9669C5826A238ACEC0BD86755FA5DB)

```java
1.数据类型的转换，分为自动转换和强制转换。自动转换是程序在执行过程中 “ 悄然 ” 进行的转换，不需要用户提前声明，一般是从位数低的类型向位数高的类型转换；强制类型转换则必须在代码中声明，转换顺序不受限制。

自动数据类型转换

自动转换按从低到高的顺序转换。不同类型数据间的优先关系如下：
低 ---------------------------------------------> 高
byte,short,char-> int -> long(8字节) -> float(4字节) -> double
    
float占4个字节为什么比long占8个字节大呢，因为底层的实现方式不同。
浮点数的32位并不是简单直接表示大小，而是按照一定标准分配的。
第1位，符号位，即S
接下来8位，指数域，即E。
剩下23位，小数域，即M，取值范围为[1 ,2 ) 或[0 , 1)
然后按照公式： V=(-1)^s * M * 2^E
也就是说浮点数在内存中的32位不是简单地转换为十进制，而是通过公式来计算而来，通过这个公式虽然，只有4个字节，但浮点数最大值要比长整型的范围要大。
```



```java
2.以下哪一个正则表达式不能与字符串“https://www.tensorflow.org/”（不含引号）匹配？（）

正确答案: B   你的答案: B (正确)
[a-z]+://[a-z.]+/
https[://]www[.]tensorflow[.]org[/]
[htps]+://www.tensorflow.org/
[a-zA-Z.:/]+
      
看着每个答案都没问题，但是第二个答案有个小坑，就是【这里】不能包含相同的的元素，也就是说[://]== [:/]      
```



```java
3.会输出什么？
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
加载类B的时候，有遇到又想加载B的，那第二次加载的就会以为静态域已经加载了（静态域指的是静态代码块静态变量静态方法。）
```



#### 11.14

```java
1.ResultSet中记录行的第一列索引为？ 你用你那个猪脑，人家为什么要考这道题
正确答案: C   你的答案: B (错误)
-1
0
1
以上都不是
```



```java
2.下列关于Java语言中String和char的说法，正确的是（）

正确答案: C   你的答案: C (正确)
String是Java定义的一种基本数据类型。no
String是以“\0”结尾的char类型的数组char[]。 no 不需要\0
使用equals()方法比较两个String是否内容一样（即字符串中的各个字符都一样）。yes
Char类型在Java语言里面存储的是ASCII码。Unicode编码占2个字节 16位 可以存一个汉字
```



重点https://www.nowcoder.com/test/question/done?tid=39382302&qid=373279#summary

```java
3.Java1.8版本之前的前提，Java特性中,abstract class和interface有什么区别（）
正确答案: A B D   你的答案: B D (错误)
抽象类可以有构造方法，接口中不能有构造方法
抽象类中可以有普通成员变量，接口中没有普通成员变量
抽象类中不可以包含静态方法，接口中可以包含静态方法
一个类可以实现多个接口，但只能继承一个抽象类。
```



#### 11.15

```java
编译看左边，运行看右边
1.instanceof运算符能够用来判断一个对象是否为:
正确答案: C   你的答案: C (正确)
一个类的实例
一个实现指定接口的类的实例
全部正确
一个子类的实例
    
instance是java的二元运算符，用来判断他左边的对象是否为右面类（接口，抽象类，父类）的实例
```



```java
2.运行结果是什么？
Integer a = 1;
Integer b = 1;
Integer c = 500;
Integer d = 500;
System.out.print(a == b); true
System.out.print(c == d); false
   
Integer类型在-128-->127范围之间是被缓存了的，也就是每个对象的内存地址是相同的，赋值就直接从缓存中取，不会有新的对象产生，而大于这个范围，将会重新创建一个Integer对象，也就是new一个对象出来，当然地址就不同了，也就！=；
```



```java
3.final、finally和finalize的区别中，下述说法正确的有？
正确答案: A B   你的答案: A B C (错误)
final用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。
finally是异常处理语句结构的一部分，表示总是执行。
finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源的回收，例如关闭文件等。// 这个方法只执行一次，心脏复苏也不能一直这么搞吧
引用变量被final修饰之后，不能再指向其他对象，它指向的对象的内容也是不可变的。
    
final的地址不能变，但是指向的对象内容是可变的。
```



```
finally表示总是执行。但是其实finally也有不执行的时候，但是这个题不要扣字眼。
1. 在try中调用System.exit(0)，强制退出了程序，finally块不执行。
2. 在进入try块前，出现了异常，finally块不执行。
```



#### 11.16

```java
public class test3{
    public void add(Byte b){
        b = b++;
    }
    @Test
    public void test(){
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");  // -128  符号位变为1了 而且是int强转为byte再装箱
        add(b);
        System.out.print(b + "");  // 127
    }
}
```



编译与反编译指令

javac xxx.java

javap -v xxx.class



#### 11.17

```java
1.下面关于JAVA的垃圾回收机制，正确的是（ ）
正确答案: B   你的答案: A (错误)
当调用“System.gc()”来强制回收时，系统会立即回收垃圾 // 只是建议
垃圾回收不能确定具体的回收时间  // 对的
程序可明确地标识某个局部变量的引用不再被使用 // 局部变量分为引用变量(引用在栈)和基本类型变量(栈)
程序可以显式地立即释放对象占有的内存 // 不行的咯
    
一般局部变量都是随着方法执行结束而释放。
```



```java
2.关于Java中参数传递的说法，哪个是错误的？
正确答案: D   你的答案: B (错误)
在方法中，修改一个基础类型的参数不会影响原始参数值
在方法中，改变一个对象参数的引用不会影响到原始引用
在方法中，修改一个对象的属性会影响原始对象参数
在方法中，修改集合和Maps的元素不会影响原始集合参数
```

重点

```java
3.关于运行时常量池，下列哪个说法是正确的
正确答案: B C D   你的答案: B C D (正确)
运行时常量池大小受栈区大小的影响
运行时常量池大小受方法区大小的影响
存放了编译时期生成的各种字面量
存放编译时期生成的符号引用
    
    
在JDK1.8之前运行时常量池被放在方法区,属于线程共享,JDK1.8之后,元空间取代了方法区,运行时常量池被也被放在元空间中,运行时常池主要存放, class文件元信息描述,编译后的代码，引用类型数据，类文件常量池。
    所谓的运行时常量池其实就是将编译后的类信息放入运行时的一个区域中，用来动态获取类信息。运行时常量池是在类加载完成之后，将每个class常量池中的符号引用值转存到运行时常量池中，也就是说，每个class都有一个运行时常量池，类在解析之后，将符号引用替换成直接引用，与全局常量池中的引用值保持一致。
运行时常量池是方法区的一部分。Class 文件中除了有类的版本、字段、方法、接口等描述信息外，还有常量池信息（用于存放编译期生成的各种字面量和符号引用）
```



#### 11.18

```java
1.哪个有问题？
byte b1=1,b2=2,b3,b6,b8;
final byte b4=4,b5=6,b7;
b3=(b1+b2);  /*语句1*/
b6=b4+b5;    /*语句2*/
b8=(b1+b4);  /*语句3*/
b7=(b2+b5);  /*语句4*/
System.out.println(b3+b6);
下列代码片段中，存在编译错误的语句是()
    
1，3，4都有问题
--------------------------------------------------------------------------------
Java表达式转型规则由低到高转换：
1、所有的byte,short,char型的值将被提升为int型；
2、如果有一个操作数是long型，计算结果是long型；

3、如果有一个操作数是float型，计算结果是float型；

4、如果有一个操作数是double型，计算结果是double型；
5、被fianl修饰的变量不会自动改变类型，当2个final修饰相操作时，结果会根据左边变量的类型而转化。
--------------------------------------------------------------------------------
语句1错误：b3=(b1+b2);自动转为int，所以正确写法为b3=(byte)(b1+b2);或者将b3定义为int；
语句2正确：b6=b4+b5;b4、b5为final类型，不会自动提升，所以和的类型视左边变量类型而定，即b6可以是任意数值类型；
语句3错误：b8=(b1+b4);虽然b4不会自动提升，但b1仍会自动提升，所以结果需要强转，b8=(byte)(b1+b4);
语句4错误：b7=(b2+b5); 同上。同时注意b7是final修饰，即只可赋值一次，便不可再改变。
```



```java
原子性：事务是一组不可分割的操作单元，这组单元要么同时成功要么同时失败（由DBMS的事务管理子系统来实现）；
一致性：事务前后的数据完整性要保持一致（由DBMS的完整性子系统执行测试任务）；
隔离性:多个用户的事务之间不要相互影响，要相互隔离（由DBMS的并发控制子系统实现）；
持久性:一个事务一旦提交，那么它对数据库产生的影响就是永久的不可逆的，如果后面再回滚或者出异常，都不会影响已提交的事务（由DBMS的恢复管理子系统实现的）
```



```java
2.jdk1.8版本之前的前提下，接口和抽象类描述正确的有（ ）
正确答案: B C   你的答案: 空 (错误)
抽象类没有构造函数
接口没有构造函数
抽象类不允许多继承
接口中的方法可以有方法体
```



#### 11.19

重点

```java
1.what is the result of the following code?

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

	
Ans:Compiles fine and output is prints”It is a account type”thrice followed by”FIXED”
编译成功并输出三次 It is a account type然后接着输出FIXED
```

```java
枚举类在后台实现时，实际上是转化为一个继承了java.lang.Enum类的实体类，原先的枚举类型变成对应的实体类型，上例中AccountType变成了个class AccountType，并且会生成一个新的构造函数，若原来有构造函数，则在此基础上添加两个参数，生成新的构造函数，如上例子中：
    
    private AccountType(){ System.out.println(“It is a account type”); }
							|
    private AccountType(String s, int i){
    super(s,i); System.out.println(“It is a account type”); }

	并添加这些
    public static final AccountType SAVING;
    public static final AccountType FIXED;
    public static final AccountType CURRENT;

	static{
    SAVING = new AccountType("SAVING", 0);
    ...  CURRENT = new AccountType("CURRENT", 0);
   $VALUES = new AccountType[]{
         SAVING, FIXED, CURRENT
    } }

	以此来初始化枚举中的每个具体类型。（并将所有具体类型放到一个$VALUE数组中，以便用序号访问具体类型）
在初始化过程中new AccountType构造函数被调用了三次，所以Enum中定义的构造函数中的打印代码被执行了3遍。
        
    简单来说，所有的枚举值都是类静态常量，在初始化时会对所有的枚举值对象进行第一次初始化。

```



```java
2.类方法中可以直接调用对象变量。（ ）

正确答案: B   你的答案: A (错误)
正确
错误
    
你这么记：我静态域在类初始化时就调用在后面 实例初始化的对象，你说怎么调用啊
```



```java
3.StringBuffer s = new StringBuffer(x);  x为初始化容量长度
s.append("Y"); "Y"表示长度为y的字符串
length始终返回当前长度即y；
对于s.capacity()：
1.当y<x时，值为x
以下情况，容器容量需要扩展
2.当x<y<2*x+2时，值为 2*x+2
3.当y>2*x+2时，值为y
```





















## 数据库

### 8.5

```
1.A表字段a 类型int中有100条记录，值分别为1至100。如下语句 
SELECT a FROM A WHERE a BETWEEN 1 AND 50 OR (a IN (25,70,95) AND a BETWEEN 25 AND 75)  
则如下哪个值在这个sql语句返回的结果集中?

答案：SELECT a FROM A WHERE a BETWEEN 1 AND 50 OR (a IN (25,70,95) AND a BETWEEN 25 AND 75)
1.  BETWEEN 1 AND 50   
    a的值在 1 到 50 区间，条件则成立
2.  a IN (25,70,95) AND a BETWEEN 25 AND 75
    a的值在 25 到 75 区间且a的值为25,70,95其中一个，条件则成立
    显然，在第一个条件不成立的情况下，这里第二个条件只有70满足条件。

所以，满足上述选择条件的结果集包括 1 到 50，和 70
```



```
2.数据的独立性是数据库系统的最基本的特征之一 。数据独立性是指应用程序和数据结构之间相互独立, 互不影响。
```



```
3.数据库事务四大特性:

    1、原子性（Atomicity）

    原子性是指事务包含的所有操作要么全部成功，要么全部失败回滚，因此事务的操作如果成功就必须要完全应用到数据库，如果操作失败则不能对数据库有任何影响。

    2、 一致性（Consistency）

    一致性是指事务必须使数据库从一个一致性状态变换到另一个一致性状态，也就是说一个事务执行之前和执行之后都必须处于一致性状态。

    拿转账来说，假设用户A和用户B两者的钱加起来一共是5000，那么不管A和B之间如何转账，转几次账，事务结束后两个用户的钱相加起来应该还得是5000，这就是事务的一致性。

    3、隔离性（Isolation）

    隔离性是当多个用户并发访问数据库时，比如操作同一张表时，数据库为每一个用户开启的事务，不能被其他事务的操作所干扰，多个并发事务之间要相互隔离。

    即要达到这么一种效果：对于任意两个并发的事务T1和T2，在事务T1看来，T2要么在T1开始之前就已经结束，要么在T1结束之后才开始，这样每个事务都感觉不到有其他事务在并发地执行。

    4、持久性（Durability）

    持久性是指一个事务一旦被提交了，那么对数据库中的数据的改变就是永久性的，即便是在数据库系统遇到故障的情况下也不会丢失提交事务的操作
```



```
1.1 第一范式（1NF）无重复的列
        所谓第一范式（1NF）是指数据库表的每一列都是不可分割的基本数据项，同一列中不能有多个值，即实体中的某个属性不能有多个值或者不能有重复的属性。如果出现重复的属性，就可能需要定义一个新的实体，新的实体由重复的属性构成，新实体与原实体之间为一对多关系。在第一范式（1NF）中表的每一行只包含一个实例的信息。简而言之，第一范式就是无重复的列。

    说明：在任何一个关系数据库中，第一范式（1NF）是对关系模式的基本要求，不满足第一范式（1NF）的数据库就不是关系数据库。

    数据库表中的字段都是单一属性的，不可再分。这个单一属性由基本类型构成，包括整型、实数、字符型、逻辑型、日期型等。很显然，在当前的任何关系数据库管理系统（DBMS）中，傻瓜也不可能做出不符合第一范式的数据库，因为这些DBMS不允许你把数据库表的一列再分成二列或多列。因此，你想在现有的DBMS中设计出不符合第一范式的数据库都是不可能的。

1.2 第二范式（2NF）属性完全依赖于主键 [ 消除部分子函数依赖 ]
    如果关系模式R为第一范式，并且R中每一个非主属性完全函数依赖于R的某个候选键， 则称为第二范式模式。
    第二范式（2NF）是在第一范式（1NF）的基础上建立起来的，即满足第二范式（2NF）必须先满足第一范式（1NF）。第二范式（2NF）要求数据库表中的每个实例或行必须可以被惟一地区分。为实现区分通常需要为表加上一个列，以存储各个实例的惟一标识。这个惟一属性列被称为主关键字或主键、主码。
    例如员工信息表中加上了员工编号（emp_id）列，因为每个员工的员工编号是惟一的，因此每个员工可以被惟一区分。
    简而言之，第二范式（2NF）就是非主属性完全依赖于主关键字。
    所谓完全依赖是指不能存在仅依赖主关键字一部分的属性（设有函数依赖W→A，若存在XW，有X→A成立，那么称W→A是局部依赖，否则就称W→A是完全函数依赖）。如果存在，那么这个属性和主关键字的这一部分应该分离出来形成一个新的实体，新实体与原实体之间是一对多的关系。
    假定选课关系表为SelectCourse(学号, 姓名, 年龄, 课程名称, 成绩, 学分)，关键字为组合关键字(学号, 课程名称)，因为存在如下决定关系：
    (学号, 课程名称) → (姓名, 年龄, 成绩, 学分)
    这个数据库表不满足第二范式，因为存在如下决定关系：
    (课程名称) → (学分)
    (学号) → (姓名, 年龄)
    即存在组合关键字中的字段决定非关键字的情况。
    由于不符合2NF，这个选课关系表会存在如下问题：
    (1) 数据冗余：
    同一门课程由n个学生选修，"学分"就重复n-1次；同一个学生选修了m门课程，姓名和年龄就重复了m-1次。
    (2) 更新异常：
    若调整了某门课程的学分，数据表中所有行的"学分"值都要更新，否则会出现同一门课程学分不同的情况。
    (3) 插入异常：
    假设要开设一门新的课程，暂时还没有人选修。这样，由于还没有"学号"关键字，课程名称和学分也无法记录入数据库。

    (4) 删除异常：
    假设一批学生已经完成课程的选修，这些选修记录就应该从数据库表中删除。但是，与此同时，课程名称和学分信息也被删除了。很显然，这也会导致插入异常。
    把选课关系表SelectCourse改为如下三个表：
    学生：Student(学号, 姓名, 年龄)；
    课程：Course(课程名称, 学分)；
    选课关系：SelectCourse(学号, 课程名称, 成绩)。
    这样的数据库表是符合第二范式的， 消除了数据冗余、更新异常、插入异常和删除异常。
    另外，所有单关键字的数据库表都符合第二范式，因为不可能存在组合关键字。

1.3 第三范式（3NF）属性不依赖于其它非主属性 [ 消除传递依赖 ]
    如果关系模式R是第二范式，且每个非主属性都不传递依赖于R的候选键，则称R为第三范式模式。
    满足第三范式（3NF）必须先满足第二范式（2NF）。第三范式（3NF）要求一个数据库表中不包含已在其它表中已包含的非主关键字信息。
    例如，存在一个部门信息表，其中每个部门有部门编号（dept_id）、部门名称、部门简介等信息。那么在的员工信息表中列出部门编号后就不能再将部门名称、部门简介等与部门有关的信息再加入员工信息表中。如果不存在部门信息表，则根据第三范式（3NF）也应该构建它，否则就会有大量的数据冗余。
    第三范式（3NF）：在第二范式的基础上，数据表中如果不存在非关键字段对任一候选关键字段的传递函数依赖则符合第三范式。简而言之，第三范式就是属性不依赖于其它非主属性。
    所谓传递函数依赖，指的是如果存在"A → B → C"的决定关系，则C传递函数依赖于A。
    因此，满足第三范式的数据库表应该不存在如下依赖关系：
    关键字段 → 非关键字段x → 非关键字段y
    假定学生关系表为Student(学号, 姓名, 年龄, 所在学院, 学院地点, 学院电话)，关键字为单一关键字"学号"，因为存在如下决定关系：
    (学号) → (姓名, 年龄, 所在学院, 学院地点, 学院电话)
    这个数据库是符合2NF的，但是不符合3NF，因为存在如下决定关系：
    (学号) → (所在学院) → (学院地点, 学院电话)
    即存在非关键字段"学院地点"、"学院电话"对关键字段"学号"的传递函数依赖。
    它也会存在数据冗余、更新异常、插入异常和删除异常的情况，读者可自行分析得知。
    把学生关系表分为如下两个表：
    学生：(学号, 姓名, 年龄, 所在学院)；
    学院：(学院, 地点, 电话)。
    这样的数据库表是符合第三范式的，消除了数据冗余、更新异常、插入异常和删除异常。

1.4 鲍依斯-科得范式（BCNF是3NF的改进形式）
    若关系模式R是第一范式，且每个属性都不传递依赖于R的候选键。这种关系模式就是BCNF模式。即在第三范式的基础上，数据库表中如果不存在任何字段对任一候选关键字段的传递函数依赖则符合鲍依斯-科得范式。
    假设仓库管理关系表为StorehouseManage(仓库ID, 存储物品ID, 管理员ID, 数量)，且有一个管理员只在一个仓库工作；一个仓库可以存储多种物品。这个数据库表中存在如下决定关系：
    (仓库ID, 存储物品ID) →(管理员ID, 数量)
    (管理员ID, 存储物品ID) → (仓库ID, 数量)
    所以，(仓库ID, 存储物品ID)和(管理员ID, 存储物品ID)都是StorehouseManage的候选关键字，表中的唯一非关键字段为数量，它是符合第三范式的。但是，由于存在如下决定关系：
    (仓库ID) → (管理员ID)
    (管理员ID) → (仓库ID)
    即存在关键字段决定关键字段的情况，所以其不符合BCNF范式。它会出现如下异常情况：

    (1) 删除异常：
    当仓库被清空后，所有"存储物品ID"和"数量"信息被删除的同时，"仓库ID"和"管理员ID"信息也被删除了。

    (2) 插入异常：
    当仓库没有存储任何物品时，无法给仓库分配管理员。

    (3) 更新异常：
    如果仓库换了管理员，则表中所有行的管理员ID都要修改。
    把仓库管理关系表分解为二个关系表：
    仓库管理：StorehouseManage(仓库ID, 管理员ID)；
    仓库：Storehouse(仓库ID, 存储物品ID, 数量)。
    这样的数据库表是符合BCNF范式的，消除了删除异常、插入异常和更新异常。
```



```
4.Mysql 选择合适的数据类型 ，说法正确的是（      ）
正确答案: A B D   你的答案: A B C D (错误)
MyISAM引擎的数据表，最好使用固定长度的数据列代替可变长度的数据列。
对于InnoDB引擎数据表，内部的行存储格式没有区分固定长度和可变长度列，字符型数据建议使用VARCHAR类型
对于字段长度要求超过 128个的情况下，MySQL 提供了 TEXT 和 BLOB 两种类型。根据存储数据的大小，它们都有不同的子类型。这些大型的数据用于存储文本块或图像、声音文件等二进制数据类型。
对货币等精度敏感的数据，应该用定点数表示或存储。

在保存较大文本时， 通常会选择使用 TEXT 或者 BLOB，二者之间的主要差别是 BLOB保存二进制数据，比如照片；而 TEXT 只能保存字符数据，比如一篇文章等等。
```







## Python









## 操作系统



## -----------------

## 二级标题为分类

## 三级分类为月份

## 四级分类为日期