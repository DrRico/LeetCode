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

```java
class Person{
    protected String name;
 
    public Person(String name) {
        this.name = name;
    }
 
}
 
class Student extends Person{
    private String name;
 
    public Student(String name, String name1) {
        super(name);
        this.name = name1;
    }
 
    public void getInfo(){
        System.out.println(this.name);      //Child
        System.out.println(super.name);     //Father
    }
 
}

public class Test {
    public static void main(String[] args) {
       Student s1 = new Student("Father","Child");
       s1.getInfo();
 
    }
}
```

- 3.引用父类构造函数
  -  super（参数）：调用父类中的某一个构造函数（应该为构造函数中的第一条语句）。
  -  this（参数）：调用本类中另一种形式的构造函数（应该为构造函数中的第一条语句）。

#### 2.8  this与super的区别

- **super:　它引用当前对象的直接父类中的成员**（用来访问直接父类中被隐藏的父类中成员数据或函数，基类与派生类中有相同成员定义时如：super.变量名 super.成员函数据名（实参）
- **this：它代表当前对象名**（在程序中易产生二义性之处，应使用this来指明当前对象；如果函数的形参与类中的成员数据同名，这时需用this来指明成员变量名）
- super()和this()类似，区别是，super()在子类中调用**父类**的构造方法，this()在本类内调用**本类**的其它构造方法。
- super()和this()均**需放在构造方法内第一行**。
- 尽管可以用this调用一个构造器，但却不能调用两个。
- this和super**不能同时出现在一个构造函数里面**，因为this必然会调用其它的构造函数，其它的构造函数必然也会有super语句的存在，所以在同一个构造函数里面有相同的语句，就失去了语句的意义，编译器也不会通过。
- this()和super()**都指的是对象**，所以，均**不可以在static环境中使用**。包括：static变量,static方法，static语句块。
- 从本质上讲，**this是一个指向本对象的指针**, 然而**super是一个Java关键字**。

#### 2.9 static 存在的主要意义

- static的主要意义是在于创建**独立于具体对象**的域变量或者方法。**以致于即使没有创建对象，也能使用属性和调用方法**！

- static关键字还有一个比较关键的作用就是 **用来形成静态代码块以优化程序性能**。static块可以置于类中的任何地方，类中可以有多个static块。在类**初次被加载**的时候，会按照**static块的顺序**来执行每个static块，并且**只会执行一次**。

- 为什么说static块可以用来优化程序性能，是因为它的特性:**只会在类加载的时候执行一次**。因此，很多时候会将一些只需要进行一次的初始化操作都放在static代码块中进行。

#### 2.10  static的独特之处

- 1、被static修饰的变量或者方法是独立于该类的任何对象，也就是说，这些变量和方法**不属于任何一个实例对象，而是被类的实例对象所共享**。
  - 怎么理解 “被类的实例对象所共享” 这句话呢？就是说，一个类的静态成员，它是属于大伙的【大伙指的是这个类的**多个对象实例**，我们都知道一个类可以创建多个实例！】，所有的类对象共享的，不像成员变量是自个的【自个指的是这个类的单个实例对象】…我觉得我已经讲的很通俗了，你明白了咩？

- 2、在该类被第一次加载的时候，就会去加载被static修饰的部分，而且只在类第一次使用时加载并进行初始化，注意这是第一次用就要初始化，后面根据需要是可以再次赋值的。

- 3、static变量值在**类加载的时候分配空间**，以后**创建类对象的时候不会重新分配**。赋值的话，是可以任意赋值的！

- 4、**被static修饰的变量或者方法是优先于对象存在的**，也就是说当一个类加载完毕之后，即便没有创建对象，也可以去访问。

#### 2.11  static应用场景

- 因为static是被类的实例对象所共享，因此如果**某个成员变量是被所有对象所共享的，那么这个成员变量就应该定义为静态变量**。因此比较常见的static应用场景有：
  -  1、修饰成员变量 
  - 2、修饰成员方法 
  - 3、静态代码块
  -  4、修饰类【只能修饰内部类也就是静态内部类】
  -  5、静态导包

- static注意事项
  - 1、静态只能访问静态。 
  - 2、非静态既可以访问非静态的，也可以访问静态的。

#### 2.12  流程控制语句 break ,continue ,return 的区别及作用

- break 跳出总上一层循环，不再执行循环(结束当前的循环体)
- continue 跳出本次循环，继续执行下次循环(结束正在执行的循环 进入下一个循环条件)

- return 程序返回，不再执行下面的代码(结束当前的方法 直接返回)

### 3、 题目3：  面向对象

#### 3.1  面向对象和面向过程的区别

- **面向过程**：
  - **面向过程是具体化的，流程化的，解决一个问题，你需要一步一步的分析，一步一步的实现。**
  - 优点：性能比面向对象高，因为类调用时需要实例化，开销比较大，比较消耗资源;比如单片机、嵌入式开发、Linux/Unix等一般采用面向过程开发，性能是最重要的因素。
  - 缺点：没有面向对象易维护、易复用、易扩展

- **面向对象**：
  - **面向对象是模型化的，你只需抽象出一个类，这是一个封闭的盒子，在这里你拥有数据也拥有解决问题的方法。需要什么功能直接使用就可以了，不必去一步一步的实现，至于这个功能是如何实现的，管我们什么事？我们会用就可以了。**
  - 优点：易维护、易复用、易扩展，由于面向对象有封装、继承、多态性的特性，可以设计出低耦合的系统，使系统更加灵活、更加易于维护
  - 缺点：性能比面向过程低

--------------

。。。。。。



#### 3.3  重写与重载

- **构造器（constructor）是否可被重写（override）**
  - 构造器不能被继承，因此不能被重写，但可以被重载。

- **重载（Overload）和重写（Override）的区别。重载的方法能否根据返回类型进行区分？**
  - 方法的重载和重写都是实现多态的方式，区别在于前者实现的是编译时的多态性，而后者实现的是运行时的多态性。
  - **重载：**发生在**同一个类中**，**方法名**==相同==**参数列表**==不同==（参数类型不同、个数不同、顺序不同），与方法返回值和访问修饰符无关，即重载的方法不能根据返回类型进行区分
  - **重写：**发生在**父子类中**，方法名、参数列表必须相同，**返回值小于等于父类**，**抛出的异常小于等于父类**，**访问修饰符大于等于父类**（==里氏代换原则==）；如果父类方法访问修饰符为**private**则子类中就不可以重写。

#### 3.4  == 和 equals 的区别是什么

- **==** : 它的作用是判断两个对象的地址是不是相等。即，判断两个对象是不是同一个对象。(基本数据类型 == 比较的是值，引用数据类型 == 比较的是内存地址)

- **equals()** : 它的作用也是判断两个对象是否相等。但它一般有两种使用情况：
  - 情况1：类没有覆盖 equals() 方法。则通过 equals() 比较该类的两个对象时，等价于通过“==”比较这两个对象。
  - 情况2：类覆盖了 equals() 方法。一般，我们都覆盖 equals() 方法来两个对象的内容相等；若它们的内容相等，则返回 true (即，认为这两个对象相等)。

**说明：**

- String中的equals方法是**被重写过**的，因为object的equals方法是比较的对象的**内存地址**，而String的equals方法比较的是**对象的值**。
- 当创建String类型的对象时，虚拟机会在**常量池**中查找有没有**已经存在的值**和**要创建的值**相同的对象，如果**有就把它赋给当前引用**。如果没有就在常量池中重新**创建一个String对象**。

####  

#### 3.5 hashCode 与 equals (重要)

- 问题
  - HashSet如何检查重复
  - 两个对象的 hashCode() 相同，则 equals() 也一定为 true，对吗？
  - hashCode和equals方法的关系
  - 你重写过 hashcode 和 equals 么，为什么重写equals时必须重写hashCode方法？

- **hashCode()介绍**
  -  hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。hashCode() 定义在JDK的Object.java中，这就意味着Java中的任何类都包含有hashCode()函数。
  -  散列表存储的是键值对(key-value)，它的特点是：能根据“键”快速的检索出对应的“值”。这其中就利用到了散列码！（可以快速找到所需要的对象）

- **为什么要有 hashCode**

- 我们以“**HashSet 如何检查重复**”为例子来说明为什么要有 hashCode：
  - 当你把对象加入 HashSet 时，HashSet 会先计算对象的 **hashcode 值**来判断对象加入的位置，同时也会与其他已经加入的对象的 hashcode 值作比较，如果没有相符的hashcode，HashSet会假设对象没有重复出现。但是如果发现**有相同 hashcode 值的对象**，这时**会调用 equals()方法**来**检查 hashcode 相等的对象是否真的相同**。如果两者相同，HashSet 就不会让其加入操作成功。如果不同的话，就会**重新散列到其他位置**。（摘自我的Java启蒙书《Head first java》第二版）。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。

- **hashCode()与equals()的相关规定：**
  - 如果**两个对象相等**，则**hashcode**一定也是**相同**的
  - 两个**对象相等**，对两个对象分别**调用equals方法都返回true**
  - 两个对象==**有相同的hashcode**==值，它们也==**不一定是相等的**==

- **因此，equals 方法被覆盖过，则 hashCode 方法也必须被覆盖**
  - hashCode() 的默认行为是对堆上的对象产生独特值。如果没有重写 hashCode()，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）



























