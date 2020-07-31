# 牛客网刷题整理

## Java

### 7.31

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



### 8.1







## Python









## 操作系统





## 二级标题为分类，三级分类为日期