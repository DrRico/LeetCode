## 第1讲 | 谈谈你对Java平台的理解？

- Java特性:

- 面向对象（封装，继承，多态）

- 平台无关性（JVM运行.class文件）

- 语言（泛型，Lambda）

- 类库（集合，并发，网络，IO/NIO）

- JRE（Java运行环境，JVM，类库）

- JDK（Java开发工具，包括JRE，javac，诊断工具）

- Java是解析运行吗？不正确！

  - 1，Java源代码经过Javac编译成.class文件

  - 2，.class文件经JVM解析或编译运行。

    - （1）解析:.class文件经过JVM内嵌的解析器解析执行。
    - （2）编译:存在JIT编译器（Just In Time Compile 即时编译器）把经常运行的代码作为"热点代码"编译与本地平台相关的机器码，并进行各种层次的优化。
    - （3）AOT编译器: Java 9提供的直接将所有代码编译成机器码执行。

    ![在这里插入图片描述](https://img-blog.csdnimg.cn/2019040819285627.png)

- **解释执行**和**编译执行**有何区别：类比一下，一个是**同声传译**，一个是**放录音**





### **1、题目1：JVM、JRE和JDK的关系** [来自CSDN](https://blog.csdn.net/ThinkWon/article/details/104390612)

- JVM
  Java Virtual Machine是Java虚拟机，Java程序需要运行在虚拟机上，不同的平台有自己的虚拟机，因此Java语言可以实现跨平台。
- JRE
  Java Runtime Environment包括Java虚拟机和Java程序所需的核心类库等。核心类库主要是java.lang包：包含了运行Java程序必不可少的系统类，如**基本数据类型、基本数学函数、字符串处理、线程、异常处理类**等，系统缺省加载这个包如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。
- JDK
  Java Development Kit是提供给Java开发人员使用的，其中包含了Java的开发工具，也包括了JRE。所以安装了JDK，就无需再单独安装JRE了。其中的开发工具：编译工具(javac.exe)，打包工具(jar.exe)等

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9yYXcuZ2l0aHVidXNlcmNvbnRlbnQuY29tL0pvdXJXb24vaW1hZ2UvbWFzdGVyL0phdmElRTclQUUlODAlRTQlQkIlOEIvSlZNJkpSRSZKREslRTUlODUlQjMlRTclQjMlQkIlRTUlOUIlQkUucG5n?x-oss-process=image/format,png)

#### 题目1.1、什么是跨平台性？原理是什么

- 所谓跨平台性，是指java语言编写的程序，一次编译后，可以在多个系统平台上运行。
- 实现原理：Java程序是通过java虚拟机在系统平台上运行的，只要该系统可以安装相应的java虚拟机，该系统就可以运行java程序。

- Java源代码---->编译器---->jvm可执行的Java字节码.class文件(即虚拟指令)---->jvm---->jvm中解释器----->机器可执行的二进制机器码---->程序运行。

#### 题目1.2、Java和C++的区别

我知道很多人没学过C++，但是面试官就是没事喜欢拿咱们Java和C++比呀！没办法！！！就算没学过C++，也要记下来！

- 都是面向对象的语言，都支持封装、继承和多态
- Java不提供指针来直接访问内存，程序内存更加安全
- Java的类是单继承的，C++支持多重继承；虽然Java的类不可以多继承，但是接口可以多继承。
- Java有自动内存管理机制，不需要程序员手动释放无用内存

###2、 题目2：基础语法

####2.1、 Java有哪些数据类型

**定义**：Java语言是强类型语言，对于每一种数据都定义了明确的具体的数据类型，在内存中分配了不同大小的内存空间。

**分类**

- 基本数据类型
  - 数值型
    - 整数类型(byte,   	short,	int,	long)
    - 浮点类型(float,      double)
  - 字符型(char)
  - 布尔型(boolean)
- 引用数据类型
  - 类(class)
  - 接口(interface)
  - 数组([])

- **Java基本数据类型图**

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9yYXcuZ2l0aHVidXNlcmNvbnRlbnQuY29tL0pvdXJXb24vaW1hZ2UvbWFzdGVyL0phdmElRTUlOUYlQkElRTclQTElODAlRTglQUYlQUQlRTYlQjMlOTUvSmF2YSVFNSU5RiVCQSVFNiU5QyVBQyVFNiU5NSVCMCVFNiU4RCVBRSVFNyVCMSVCQiVFNSU5RSU4Qi5wbmc?x-oss-process=image/format,png)



#### 2.2、switch 是否能作用在 byte 上、作用在 long 上、作用在 String 上

- 在 Java 5 以前，switch(expr)中，expr 只能是 byte、short、char、int。从 Java5 开始，Java 中引入了枚举类型，expr 也可以是 enum 类型，**从 Java 7 开始，expr 还可以是字符串（String）**，但是长整型（long）在目前所有的版本中都是不可以的。

#### 2.3、访问修饰符 public,  private,  protected,以及不写（默认）时的区别

**定义**：Java中，可以使用访问修饰符来保护对类、变量、方法和构造方法的访问。==Java 支持 **4 种**不同的访问权限==。

**分类：**

- **private** : 在同一类内可见。使用对象：**变量、方法**。 注意：不能修饰类（外部类）
- **default** (即缺省，什么也不写，不使用任何关键字）: 在同一包内可见，不使用任何修饰符。使用对象：**类、接口、变量、方法**。
- **protected** : 对同一包内的类和所有子类可见。使用对象：**变量、方法**。 注意：不能修饰类（外部类）。
- **public :** 对所有类可见。使用对象：**类、接口、变量、方法**

![img](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9yYXcuZ2l0aHVidXNlcmNvbnRlbnQuY29tL0pvdXJXb24vaW1hZ2UvbWFzdGVyL0phdmElRTUlOUYlQkElRTclQTElODAlRTglQUYlQUQlRTYlQjMlOTUvSmF2YSVFOCVBRSVCRiVFOSU5NyVBRSVFNCVCRiVBRSVFOSVBNSVCMCVFNyVBQyVBNi5wbmc?x-oss-process=image/format,png)

#### 2.4、final 有什么用？

用于修饰**类、属性和方法**；

- 被final修饰的**类不可以被继承**
- 被final修饰的**方法不可以被重写**
- 被final修饰的**属性变量不可以被改变**，被final修饰不可变的是**变量的引用**，而不是引用指向的内容，引用指向的**内容是可以改变的**

#### 2.5、final finally finalize区别

- final可以修饰类、变量、方法，修饰类表示该类不能被继承、修饰方法表示该方法不能被重写、修饰变量表示该变量是一个常量不能被重新赋值。
- finally一般作用在try-catch代码块中，在处理异常的时候，通常我们将一定要执行的代码方法finally代码块中，表示不管是否出现异常，该代码块都会执行，一般用来存放一些关闭资源的代码。
- finalize是一个方法，属于Object类的一个方法，而Object类是所有类的父类，该方法一般由垃圾回收器来调用，当我们调用System.gc() 方法的时候，由垃圾回收器调用finalize()，回收垃圾，一个对象是否可回收的最后判断。

#### 2、6 this关键字的用法

this是自身的一个对象，代表对象本身，可以理解为：指向对象本身的一个指针。

this的用法在java中大体可以分为3种：

- 1.普通的直接引用，this相当于是指向当前对象本身。

- 2.形参与成员名字重名，用this来区分： 

```java
public Person(String name, int age) {
    this.name = name;
    this.age = age;
}
```

- 3.引用本类的构造函数

```java
class Person{
    private String name;
    private int age;
    
    public Person() {
    }
 
    public Person(String name) {
        this.name = name;
    }
    public Person(String name, int age) {
        this(name);
        this.age = age;
    }
}
```

#### 2、7 super关键字的用法

super可以理解为是指向自己超（父）类对象的一个指针，而这个超类指的是离自己最近的一个父类。

super也有三种用法：

- 1.普通的直接引用

  与this类似，super相当于是指向当前对象的父类的引用，这样就可以用super.xxx来引用父类的成员。

- 2.子类中的成员变量或方法与父类中的成员变量或方法同名时，用super进行区分