## HashMap

**1.关于HashMap的数据结构与算法**

- 数组 
- 链表
- 红黑树（自平衡的二叉查找树)
- 哈希算法

- **2.JDK 8 源码分析**

原理：HashMap采用哈希算法实现，底层采用了哈希表（数组+链表+红黑树）存储数据，键不能重复，如果发生重复，新的会替换旧的，数组中的每个元素都是链表，由 Node 内部类（实现 Map.Entry接口）实现，HashMap 通过 put & get 方法存储和获取。

特点：HashMap在查找、删除、修改方面都有非常高的效率。

![img](https://mmbiz.qpic.cn/mmbiz_png/0SQf4xMzia7blE8J0b6aMNWlUpQtMhxiaYUZjk5DVWWZY3bOiasuJRqianrnPDegGz9sEMb2xBETic9AhAEu1dGClqg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)



**table是否为空？为什么会有这种情况？**

 // 这里初始化就为16

Map<String, String> map = new HashMap<String, String>();

// 这里就为空了

Map<String, String> map = null;

转换成红黑树要满足两个条件：

- 链表长度>8
- 数组size>64



**存储对象时，将K/V传给put()方法：**

- 调用hash(K) 计算hash值，得到数组索引 i
- 调整数组大小（当容器中的元素个数大于 Capacity * LoadFactor =12时，容器会进行扩容resize 为 2n）；
- 如果 K 的 hash 值在 HashMap 中不存在，则执行插入，若存在，则发生碰撞；
- 如果 K 的 hash 值在 HashMap 中存在，且它们两者 equals 返回 true，则更新键值对；
- 如果 K 的 hash 值在 HashMap 中存在，且它们两者 equals 返回 false，则插入链表的尾部（尾插法）或者红黑树中（树的添加方式）。

  （JDK 1.7 之前使用头插法、JDK 1.8 使用尾插法）

什么时候链表转换成红黑树？

***\*Node实现的是Entry接口，当链表长度超过8个 且 数组长度超过64，就会转换成红黑树。JDK7是entry，JDK8是Node\****

![img](https://mmbiz.qpic.cn/mmbiz_png/0SQf4xMzia7blE8J0b6aMNWlUpQtMhxiaY0VCkwnibSmA5Gse75X8Rz0VlibUxJuLAVIgHIesV3wT5NnaOgibrUuXdg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

***\*获取对象时，将key传给get()方法：
\****

- 调用hash(K) 计算hash值，得到数组索引 i  定位
- 顺序遍历链表，equals() 方法逐一与所有节点的 key比较，返回对应的Value

![img](https://mmbiz.qpic.cn/mmbiz_png/0SQf4xMzia7blE8J0b6aMNWlUpQtMhxiaY42A7D7F0BF2fia7hY9j31pB2UmdDLbnBQ11ia9ek9KAkpZib4oiaE0FfBA/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

**扩容resize()：非常耗时**

创建新的数组，容量为原来数组的两倍，并重新计算原数组中新存储位置。

节点在新数组中的位置只有两种，原下标的位置或者原下标+原数组的大小。

![img](https://mmbiz.qpic.cn/mmbiz_png/0SQf4xMzia7blE8J0b6aMNWlUpQtMhxiaYia8CGhC3mXOBib8To5ArlswNDKghCSyI6icpWgtPxibR6Yj8bwygfqic5jw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

**3.JDK7与JDK8有什么区别？**

![img](https://mmbiz.qpic.cn/mmbiz_png/0SQf4xMzia7blE8J0b6aMNWlUpQtMhxiaYXlwQWKP3MkBCDdtDS8rNGrsaTjXzqcaHmOqhibMZI9PDlAA6GGJhd7w/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

![img](https://mmbiz.qpic.cn/mmbiz_png/0SQf4xMzia7blE8J0b6aMNWlUpQtMhxiaYjsTYQAmbhtxem24YiawRcVdT8BadnBkfYjLrPmLwbjgt27NL2Y0wkcw/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

- 在java 1.8中，如果链表的长度超过了8，且数组size>64时，那么链表将转换为红黑树。（数组size小于64的时候只会扩容）
- 发生hash碰撞时，java 1.7 会在链表的头部插入，而java 1.8会在链表的尾部插入
- 在java 1.8中，Entry被Node替代

**[    这篇文章有很多面试题：HashMap 夺命二十一问](http://mp.weixin.qq.com/s?__biz=Mzg4ODEzMDA5NQ==&mid=2247486229&idx=1&sn=74366e178352ea62b17bce57660d56b1&chksm=cffe9455f8891d43b58c6e5185f0f9b928bd8704885dc2a1afec771b45930c0644bdb3e82e88&scene=21#wechat_redirect) ！！！！！！！！！**