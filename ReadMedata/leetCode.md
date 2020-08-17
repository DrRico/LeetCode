###  基础知识

- Java获取数据长度：

  - Java中`.length`属性是对于`数组`来说的，当用到数组长度时，则用到length;

  - Java中`.length()`是对于`String`来说的，如果想看字符串的长度，则用length()方法；

  - Java中`.size()`方法是对于`泛型集合`来说的，如果想知道泛型有多少元素调用此方法查看。

- Java中对List集合的常用操作：

  - 添加方法是：.add(e)
  - 获取方法是：.get(index)　
  - 按照索引删除：.remove(index)
  - 按照元素内容删除：.remove(Object o)
  - 是否包含某个元素：.contains(Object o)
  - .set(index, element);   //将element放到list中索引为index的位置，替换
  - .add(index, element);   //将element放到list中索引为index的位置，原来位置的后移一位
  - .indexOf(element)和.lastIndexOf(element)：获取element的索引
  - .isEmpty() 判断list是否为空，空则返回true，非空则返回false
  - .iterator() 返回Iterator集合对象；
  - .toString() 将集合转换为字符串；
  - .toArray()  将集合转换为数组；

- Java中对字符串的常用操作：在Java中，处理字符串、文本的时候，一般常用一下三种类String、StringBuffer、StringBuilder
  - 字符串中的一些常用函数：连接.concat()、提取.substring()、取某一索引的字符.charAt()、获取长度.length()、判断内容是否相等.equals()、.equalsIgnoreCase()等等

  - 把String字符串转换为数字：

    ```java	
    String s = "123.456 ";  
    double d = Double.parseDouble(s); 
    float f = Float.parseFloat(s);
    int i = Integer.parseInt(str);	//str待转换的字符串
    ```

  - str.indexOf(',')，表示在整个str字符串中检索','
  - int n3 = str.indexOf(',',n); 表示从n开始检索','

- StringBuffer支持以下几种操作函数：append（）、insert（）、replace（）、delete（）、reserve（）等等。

  - .append(String s)：将指定的字符串s追加到此字符序列。
  - .insert（int index，String str）：在index前插入字符串str。
  - .replace(int start, int end, String str)：使用给定的字符串替换此序列的子字符串中的字符。
  - .delete(int start, int end)：移除此序列的子字符串中的字符。（从start开始，包含start，到end结束，不包含end）
  - .reverse()：将此字符序列用其反转形式取代。

- Java中HashMap 是一个散列表，它存储的内容是键值对(key-value)映射，遍历的方式：

  - 1、通过keySet()获取键，再利用hashmap里面的.get(key)方法通过键获取值

  - 2、通过Map.entry()获取键值对，可以同时利用迭代器直接遍历

  - 3、通过父类Collection获取值

```java
//方式一: 通过keyset获取键 在通过HashMap.get(key)方法通过键获取值
Set<String> set=hashMap.keySet();
for (String string : set) {
    System.out.println(string+" "+hashMap.get(string));
}

//方式二: 通过Map.entry()方法获取键值对
Set<Entry<String, Character>> entrySet = hashMap.entrySet();
for (Entry<String, Character> entry : entrySet) {
    System.out.println(entry);
}

//方式三: 通过迭代器与Map.entry()方法获取键值对
Iterator<Entry<String, Character>> iterator = hashMap.entrySet().iterator();
for (Entry<String, Character> entry : entrySet) {
    System.out.println(entry);
}
```



ASCII码表须记住的：`阿拉伯数字1:49`、`大写字母A：65`、`小写字母a:97`

正在表达式：

```java
return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");

以下对正则进行解释:
[\\+\\-]?      -> 正或负符号出现与否
\\d*         -> 整数部分是否出现，如-.34 或 +3.34均符合
(\\.\\d+)?      -> 如果出现小数点，那么小数点后面必须有数字；否则一起不出现
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
            ``紧接着必须跟着整数；或者整个部分都不出现

```

常用的正则表达式

| 规则                                  | 正则表达式语法                                               |
| ------------------------------------- | ------------------------------------------------------------ |
| 一个或多个汉字                        | ^[\u0391-\uFFE5]+$                                           |
| 邮政编码                              | ^[1-9]\d{5}$                                                 |
| QQ号码                                | ^[1-9]\d{4,10}$                                              |
| 邮箱                                  | ^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$ |
| 用户名（字母开头 + 数字/字母/下划线） | ^[A-Za-z][A-Za-z1-9_-]+$                                     |
| 手机号码                              | ^1[3\|4\|5\|8][0-9]\d{8}$                                    |
| URL                                   | ^((http\|https)://)?([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$       |
| 18位身份证号                          | ^(\d{6})(18\|19\|20)?(\d{2})([01]\d)([0123]\d)(\d{3})(\d\|X\|x)?$ |

```java
[正则表达式]文本框输入内容控制
整数或者小数：^[0-9]+\.{0,1}[0-9]{0,2}$
只能输入数字："^[0-9]*$"。
只能输入n位的数字："^\d{n}$"。
只能输入至少n位的数字："^\d{n,}$"。
只能输入m~n位的数字：。"^\d{m,n}$"
只能输入零和非零开头的数字："^(0|[1-9][0-9]*)$"。
只能输入有两位小数的正实数："^[0-9]+(.[0-9]{2})?$"。
只能输入有1~3位小数的正实数："^[0-9]+(.[0-9]{1,3})?$"。
只能输入非零的正整数："^\+?[1-9][0-9]*$"。
只能输入非零的负整数："^\-[1-9][]0-9"*$。
只能输入长度为3的字符："^.{3}$"。
只能输入由26个英文字母组成的字符串："^[A-Za-z]+$"。
只能输入由26个大写英文字母组成的字符串："^[A-Z]+$"。
只能输入由26个小写英文字母组成的字符串："^[a-z]+$"。
只能输入由数字和26个英文字母组成的字符串："^[A-Za-z0-9]+$"。
只能输入由数字、26个英文字母或者下划线组成的字符串："^\w+$"。
验证用户密码："^[a-zA-Z]\w{5,17}$"正确格式为：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。
验证是否含有^%&',;=?$\"等字符："[^%&',;=?$\x22]+"。
只能输入汉字："^[\u4e00-\u9fa5]{0,}$"
验证Email地址："^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$"。
验证InternetURL："^http://([\w-]+\.)+[\w-]+(/[\w-./?%&=]*)?$"。
验证电话号码："^(\(\d{3,4}-)|\d{3.4}-)?\d{7,8}$"正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。
验证身份证号（15位或18位数字）："^\d{15}|\d{18}$"。
验证一年的12个月："^(0?[1-9]|1[0-2])$"正确格式为："01"～"09"和"1"～"12"。
验证一个月的31天："^((0?[1-9])|((1|2)[0-9])|30|31)$"正确格式为；"01"～"09"和"1"～"31"。
匹配中文字符的正则表达式： [\u4e00-\u9fa5]
匹配双字节字符(包括汉字在内)：[^\x00-\xff]
应用：计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）
String.prototype.len=function(){return this.replace(/[^\x00-\xff]/g,"aa").length;}
匹配空行的正则表达式：\n[\s| ]*\r
匹配html标签的正则表达式：<(.*)>(.*)<\/(.*)>|<(.*)\/>
匹配首尾空格的正则表达式：(^\s*)|(\s*$)
```

正则表达式语法

| 元字符       | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| \            | 将下一个字符标记符、或一个向后引用、或一个八进制转义符。例如，“\\n”匹配\n。“\n”匹配换行符。序列“\\”匹配“\”而“\(”则匹配“(”。即相当于多种编程语言中都有的“转义字符”的概念。 |
| ^            | 匹配输入字符串的开始位置。如果设置了RegExp对象的Multiline属性，^也匹配“\n”或“\r”之后的位置。 |
| $            | 匹配输入字符串的结束位置。如果设置了RegExp对象的Multiline属性，$也匹配“\n”或“\r”之前的位置。 |
| *            | 匹配前面的子表达式任意次。例如，zo*能匹配“z”，“zo”以及“zoo”。*等价于{0,}。 |
| +            | 匹配前面的子表达式一次或多次(大于等于1次）。例如，“zo+”能匹配“zo”以及“zoo”，但不能匹配“z”。+等价于{1,}。 |
| ?            | 匹配前面的子表达式零次或一次。例如，“do(es)?”可以匹配“do”或“does”中的“do”。?等价于{0,1}。 |
| {n}          | n是一个非负整数。匹配确定的n次。例如，“o{2}”不能匹配“Bob”中的“o”，但是能匹配“food”中的两个o。 |
| {n,}         | n是一个非负整数。至少匹配n次。例如，“o{2,}”不能匹配“Bob”中的“o”，但能匹配“foooood”中的所有o。“o{1,}”等价于“o+”。“o{0,}”则等价于“o*”。 |
| {n,m}        | m和n均为非负整数，其中n<=m。最少匹配n次且最多匹配m次。例如，“o{1,3}”将匹配“fooooood”中的前三个o。“o{0,1}”等价于“o?”。请注意在逗号和两个数之间不能有空格。 |
| ?            | 当该字符紧跟在任何一个其他限制符（*,+,?，{n}，{n,}，{n,m}）后面时，匹配模式是非贪婪的。非贪婪模式尽可能少的匹配所搜索的字符串，而默认的贪婪模式则尽可能多的匹配所搜索的字符串。例如，对于字符串“oooo”，“o+?”将匹配单个“o”，而“o+”将匹配所有“o”。 |
| .点          | 匹配除“\r\n”之外的任何单个字符。要匹配包括“\r\n”在内的任何字符，请使用像“[\s\S]”的模式。 |
| (pattern)    | 匹配pattern并获取这一匹配。所获取的匹配可以从产生的Matches集合得到，在VBScript中使用SubMatches集合，在JScript中则使用$0…$9属性。要匹配圆括号字符，请使用“\(”或“\)”。 |
| (?:pattern)  | 匹配pattern但不获取匹配结果，也就是说这是一个非获取匹配，不进行存储供以后使用。这在使用或字符“(\|)”来组合一个模式的各个部分是很有用。例如“industr(?:y\|ies)”就是一个比“industry\|industries”更简略的表达式。 |
| (?=pattern)  | 正向肯定预查，在任何匹配pattern的字符串开始处匹配查找字符串。这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。例如，“Windows(?=95\|98\|NT\|2000)”能匹配“Windows2000”中的“Windows”，但不能匹配“Windows3.1”中的“Windows”。预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。 |
| (?!pattern)  | 正向否定预查，在任何不匹配pattern的字符串开始处匹配查找字符串。这是一个非获取匹配，也就是说，该匹配不需要获取供以后使用。例如“Windows(?!95\|98\|NT\|2000)”能匹配“Windows3.1”中的“Windows”，但不能匹配“Windows2000”中的“Windows”。 |
| (?<=pattern) | 反向肯定预查，与正向肯定预查类似，只是方向相反。例如，“(?<=95\|98\|NT\|2000)Windows”能匹配“2000Windows”中的“Windows”，但不能匹配“3.1Windows”中的“Windows”。 |
| (?<!pattern) | 反向否定预查，与正向否定预查类似，只是方向相反。例如“(?<!95\|98\|NT\|2000)Windows”能匹配“3.1Windows”中的“Windows”，但不能匹配“2000Windows”中的“Windows”。 |
| x\|y         | 匹配x或y。例如，“z\|food”能匹配“z”或“food”或"zood"(此处请谨慎)。“(z\|f)ood”则匹配“zood”或“food”。 |
| [xyz]        | 字符集合。匹配所包含的任意一个字符。例如，“[abc]”可以匹配“plain”中的“a”。 |
| [^xyz]       | 负值字符集合。匹配未包含的任意字符。例如，“[^abc]”可以匹配“plain”中的“plin”。 |
| [a-z]        | 字符范围。匹配指定范围内的任意字符。例如，“[a-z]”可以匹配“a”到“z”范围内的任意小写字母字符。注意:只有连字符在字符组内部时,并且出现在两个字符之间时,才能表示字符的范围; 如果出字符组的开头,则只能表示连字符本身. |
| [^a-z]       | 负值字符范围。匹配任何不在指定范围内的任意字符。例如，“[^a-z]”可以匹配任何不在“a”到“z”范围内的任意字符。 |
| \b           | 匹配一个单词边界，也就是指单词和空格间的位置（即正则表达式的“匹配”有两种概念，一种是匹配字符，一种是匹配位置，这里的\b就是匹配位置的）。例如，“er\b”可以匹配“never”中的“er”，但不能匹配“verb”中的“er”。 |
| \B           | 匹配非单词边界。“er\B”能匹配“verb”中的“er”，但不能匹配“never”中的“er”。 |
| \cx          | 匹配由x指明的控制字符。例如，\cM匹配一个Control-M或回车符。x的值必须为A-Z或a-z之一。否则，将c视为一个原义的“c”字符。 |
| \d           | 匹配一个数字字符。等价于[0-9]。                              |
| \D           | 匹配一个非数字字符。等价于[^0-9]。                           |
| \f           | 匹配一个换页符。等价于\x0c和\cL。                            |
| \g           | 表示正则表达式使用的global（全局）的状态。使用 global 标志表明在被查找的字符串中搜索操作将查找所有符合的项，而不仅仅是第一个。 |
| \n           | 匹配一个换行符。等价于\x0a和\cJ。                            |
| \Q \E        | 这个方法可以帮你把一段字符串自动转义                         |
| \r           | 匹配一个回车符。等价于\x0d和\cM。                            |
| \s           | 匹配任何不可见字符，包括空格、制表符、换页符等等。等价于[ \f\n\r\t\v]。 |
| \S           | 匹配任何可见字符。等价于[^ \f\n\r\t\v]。                     |
| \t           | 匹配一个制表符。等价于\x09和\cI。                            |
| \v           | 匹配一个垂直制表符。等价于\x0b和\cK。                        |
| \w           | 匹配包括下划线的任何单词字符。类似但不等价于“[A-Za-z0-9_]”，这里的"单词"字符使用Unicode字符集。 |
| \W           | 匹配任何非单词字符。等价于“[^A-Za-z0-9_]”。                  |
| \xn          | 匹配n，其中n为十六进制转义值。十六进制转义值必须为确定的两个数字长。例如，“\x41”匹配“A”。“\x041”则等价于“\x04&1”。正则表达式中可以使用ASCII编码。 |
| \num         | 匹配num，其中num是一个正整数。对所获取的匹配的引用。例如，“(.)\1”匹配两个连续的相同字符。 |
| \n           | 标识一个八进制转义值或一个向后引用。如果\n之前至少n个获取的子表达式，则n为向后引用。否则，如果n为八进制数字（0-7），则n为一个八进制转义值。 |
| \nm          | 标识一个八进制转义值或一个向后引用。如果\nm之前至少有nm个获得子表达式，则nm为向后引用。如果\nm之前至少有n个获取，则n为一个后跟文字m的向后引用。如果前面的条件都不满足，若n和m均为八进制数字（0-7），则\nm将匹配八进制转义值nm。 |
| \nml         | 如果n为八进制数字（0-7），且m和l均为八进制数字（0-7），则匹配八进制转义值nml。 |
| \un          | 匹配n，其中n是一个用四个十六进制数字表示的Unicode字符。例如，\u00A9匹配版权符号（&copy;）。 |
| \< \>        | 匹配词（word）的开始（\<）和结束（\>）。例如正则表达式\<the\>能够匹配字符串"for the wise"中的"the"，但是不能匹配字符串"otherwise"中的"the"。注意：这个元字符不是所有的软件都支持的。 |
| \( \)        | 将 \( 和 \) 之间的表达式定义为“组”（group），并且将匹配这个表达式的字符保存到一个临时区域（一个正则表达式中最多可以保存9个），它们可以用 \1 到\9 的符号来引用。 |
| \|           | 将两个匹配条件进行逻辑“或”（Or）运算。例如正则表达式(him\|her) 匹配"it belongs to him"和"it belongs to her"，但是不能匹配"it belongs to them."。注意：这个元字符不是所有的软件都支持的。 |
| +            | 匹配1或多个正好在它之前的那个字符。例如正则表达式9+匹配9、99、999等。注意：这个元字符不是所有的软件都支持的。 |
| ?            | 匹配0或1个正好在它之前的那个字符。注意：这个元字符不是所有的软件都支持的。 |
| {i} {i,j}    | 匹配指定数目的字符，这些字符是在它之前的表达式定义的。例如正则表达式A[0-9]{3} 能够匹配字符"A"后面跟着正好3个数字字符的串，例如A123、A348等，但是不匹配A1234。而正则表达式[0-9]{4,6} 匹配连续的任意4个、5个或者6个数字 |



### 1、回文数

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

```java
示例 1:
输入: 121
输出: true
示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
```

📖文字题解
方法一：反转一半数字
思路

映入脑海的第一个想法是将数字转换为字符串，并检查字符串是否为回文。但是，这需要额外的非常量空间来创建问题描述中所不允许的字符串。

第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
但是，如果反转后的数字大于int.MAX,我们将遇到整数溢出问题。

按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转int数字的一半？毕竟，如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。

例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。

算法

首先，我们应该处理一些临界情况。所有负数都不可能是回文，例如：-123 不是回文，因为 - 不等于 3。所以我们可以对所有负数返回 false。除了 0 以外，所有个位是 0 的数字不可能是回文，因为最高位不等于 0。所以我们可以对所有大于 0 且个位是 0 的数字返回 false。

现在，让我们来考虑如何反转后半部分的数字。

对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。

现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？

由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，所以，当原始数字小于或等于反转后的数字时，就意味着我们已经处理了一半位数的数字了。

```java
class Solution {
    public boolean isPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

// 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
// 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
// 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}

```

### 3. 无重复字符的最长子串

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
		int len = s.length();//定义长度，作为遍历的边界
		int ans = 0;
		int start = 0;
		int end;
		Map<Character, Integer> map = new HashMap<>();//使用字符作为map的key，因为map不允许key重复。
		for(end = 0; end < len; end ++){   //开始遍历
			char temp = s.charAt(end);     //取字符串中的元素
			if(map.containsKey(temp)){     //判断是否在map的键中是否有键重复
				start = Math.max(start,map.get(temp)); //若是，则更新start，即窗口的左边，并赋值为（这时重复元素的下标）（end+1）
			}
			ans = Math.max(ans, end - start + 1);//风险ans最长子串
			map.put(s.charAt(end),end + 1);	//将窗口右边的值和对应的下标插入map
		}
		return ans;//返回结果
    }
}
```

```java
class Solution {
	public int lengthOfLongestSubstring(String s) {
		int i = 0;
		int flag = 0;
		int length = 0;
		int result = 0;
		while (i < s.length()) {
			int pos = s.indexOf(s.charAt(i),flag);
			if (pos < i) {
				if (length > result) {
					result = length;
				}
				if (result >= s.length() - pos - 1) {
					return result;
				}
				length = i - pos - 1;
				flag = pos + 1;
			}
			length++;
			i++;
		}
		return length;
	}
}
```



### 14、第一个只出现一次的字符

- 题目：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）

有很多种解法，那就一个个来讲解吧~

1、首先想到的是使用HashMap或者LinkedHashMap的方式，不过都使用两个循环。HashMap的方式：第一个循环，key记录字符，value记录对应字符出现的次数，然后用一个字符数组ArrayList去记录出现的顺序。第二个循环，遍历ArrayList的元素，作为key去取value，若value==1，return key的index即可，遍历完没发现符合条件的则返回-1即可。

```java
import java.util.*;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap();
        ArrayList<Character> list = new ArrayList();
        int len = str.length();
        for(int i=0;i<len;i++){
            char s = str.charAt(i);
            if(map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }else{
                map.put(s,1);
                list.add(s);
            }
        }
        for(char c : list){
            if(map.get(c) == 1){
                return str.indexOf(c);
            }
        }
        return -1;
    }
}
```

方法二：可以遍历使用indexOf == lastIndexOf的方式，
遍历取字符串中的每个字符，判断第一次出现的下标索引和最后一次出现的下标索引一样，则返回此下标即可。

```java
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        for(int i = 0;i < len; i ++){
            char s = str.charAt(i);
            if(str.indexOf(s) == str.lastIndexOf(s)){
                return str.indexOf(s);
            }
        }
        return -1;
    }
}
```

方法三：使用一个58长度的数组来存储每个字母出现的次数，为什么是58呢，主要是由于A-Z对应的ASCII码为65-90，a-z对应的ASCII码值为97-122，而每个字母的index=int(word)-65，比如g=103-65=38，而数组中具体记录的内容是该字母出现的次数，最终遍历一遍字符串，找出第一个数组内容为1的字母就可以了，时间复杂度为O(n)。==因为遍历的时候，顺序还是以str的字符顺序来的，这点请弄清楚就会想明白了。==

```java
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int[] res = new int[58];
        int len = str.length();
        for(int i = 0;i < len; i ++){
            res[(int)str.charAt(i) - (int)'A']+=1;
        }
        for(int i = 0;i < len; i ++){
            if(res[(int)str.charAt(i) - (int)'A'] == 1){
                return i;
            } 
        }
        return -1;
    }
}
```

### 15、表示数字的字符串

- 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

参考某大佬的代码，记录一下：

```java
public class Solution {
    private int index = 0;
    
    public boolean isNumeric(char[] str) {
        if (str.length==0) return false;
        boolean flag = scanInteger(str);
        
        // 如果出现'.'，接下来是数字的小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            // 下面一行代码用||的原因：
            // 1. 小数可以没有整数部分，例如.123等于0.123；
            // 2. 小数点后面可以没有数字，例如233.等于233.0；
            // 3. 当然小数点前面和后面可以有数字，例如233.666
            flag = scanUnsignedInteger(str) || flag;
        }
        
        // 如果出现'e'或者'E'，接下来跟着的是数字的指数部分
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            flag = flag && scanInteger(str);
        }
        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);
    }
    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        // 当str中存在若干0-9的数字时，返回true
        return start < index; 
    }
}
```

或者使用正则表达式来实现：

```java
public class Solution {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}

/*
[\\+\\-]?            -> 正或负符号出现与否
[\\+-]?

\\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
[0-9]*

(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
(\\.[0-9]*)?            否则一起不出现
                        
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
([eE][\\+-]?[0-9]+)?    紧接着必须跟着整数；或者整个部分都不出现

*/
```

### 16、替换空格

- 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

思路：

- 1、问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换

- 2、问题2：在当前字符串替换，怎么替换才更有效率（不考虑Java里现有的replace方法）。
    - 从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
    - 从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。

具体做法，循环遍历原字符串，统计出现空格的次数，设为spaceNum，若spaceNum = 2；则新数组还需额外的spaceNum * 2 的长度，因为每个空格替换成“%20”，即1个空间变成3个空间，多出2个空间。

故给新str扩容后得到newLen = oldLen + spaceNum*2的长度，则开始从后往前开始遍历旧串（原本的元素），当遇到不是空格的时候，放到新串后边，当遇到空格的时候，就把'0'、'2'、'%'分别放在新串后面，直到遍历完所有原本的元素。遍历完成之后返回str.toString()即可。

```java
public class Solution {
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        int oldLen = str.length();
        for(int i=0;i<oldLen;i++){
            if(str.charAt(i) == ' '){
                spaceNum ++;
            }
        }
        int newLen = oldLen + spaceNum*2;
        int newindex = newLen - 1;
        int oldindex = oldLen - 1;
        str.setLength(newLen);
        for(;oldindex >= 0;oldindex--){
            if(str.charAt(oldindex)==' '){
                str.setCharAt(newindex--,'0');
                str.setCharAt(newindex--,'2');
                str.setCharAt(newindex--,'%');
            }else{
                str.setCharAt(newindex--,str.charAt(oldindex));
            }
        }
        return str.toString();
    }
}
```

### 17、扑克牌顺子

- LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

```java
import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length != 5){//根据题目要求，要是数组长度不为5则返回false
            return false;
        }
        //零的个数，即王的个数
        int zeroNum = 0;
        //排序后元素之间的差值
        int gapNum = 0;
        //数组排序 
        Arrays.sort(numbers);
        //遍历数组 
        for(int i=0;i<numbers.length-1;i++){
            //统计王的个数，统计到一个就重新循环，因为不需要参与后面的差值计算
            //也不需要对比是不是顺子
            if(numbers[i] == 0){
                zeroNum++;	
                continue;
            }
            //不是王，并且还是对子，那肯定不是顺子了
            if(numbers[i] == numbers[i+1]){
                return false;
            }
            //不是王，计算一下两两的差值，最后与王的个数做比较
            gapNum += numbers[i+1] - numbers[i] - 1;
        }
        //差值小于王的个数，说明可以用王来构成顺子
        if(gapNum <= zeroNum){
            return true;
        }
        return false;
    }
}
```



### 18、字符串的排列

- 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

```
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
```

```java
import java.util.*;
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str.equals("") || str.length()==0)return res;
        StringBuilder s = new StringBuilder(str);
        dfs(s,0,new StringBuilder(),res);
        return res;
    }
    void dfs(StringBuilder s,int index, StringBuilder sb, ArrayList<String> res){
        //判断
        if(s.length() == index){
            if(!res.contains(sb.toString())){
                res.append(sb.add(sb.toString()));
            }
            return;
        }
        for(int i = 0; i < s.length(); i ++){	//候选元素
            char c = s.charAt(i);
            if(c != '0'){		//判断是否被访问过
                s.setCharAt(i, '0');
                sb.a(c);
                dfs(s, index + 1, sb, res);
                sb.deleteCharAt(sb.length()-1);
                s.setCharAt(i, c);   
            }   
        }   
    }
}
```



### 19、数组中只出现一次的数字

> 题型一：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。



使用hashmap的键来保存数组元素，值来保存出现对应的次数 

```java
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i < array.length; i++){
            if(map.containsKey(array[i])){
                map.put(array[i],2);
            }else{
                map.put(array[i],1);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                res[i++] = entry.getKey();
            }
        }
        num2[0] = res[0];
        num1[0] = res[1];
    }
}
```

 或者更高级点的，使用异或法，具体做法： 

  1、判断非法输入，比如具体的array的长度为2时，直接赋值给两个num。 

  2、遍历array中所有的值，每个值进行异或，得到bitRes。 

  3、bitRes必定不为0，因为题目告诉我们有两个数不一样且只出现一次，而其他的数都是成对出现的，所以获取bitRes中最低位不为0的index，也就是转换成二进制后，右起第一个1的下标index。 

  4、得到index的值后，我们就可以将array的值再遍历一遍，判断元素值右移index位后，最低位为1还是0，这样子就可以将array分成两组，同时对这两组的元素值异或后，就能找出单个出现的值。（两个相同的数异或之后为0，并且一个数与0异或还是他本身） 

```java
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
        }
        int bitRes = 0;
        for(int i = 0; i < array.length; i++){
            bitRes ^= array[i];
        }
        int index = getFirstOne(bitRes); 
        for(int i = 0; i < array.length; i++){
            if (isBitOne(index,array[i])){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    public boolean isBitOne(int index,int i){
        return ((i>>index) & 1) == 1;
    }
    public int getFirstOne(int bitRes){
        int index = 0;
        while((bitRes & 1) != 1){
            bitRes = bitRes >> 1;
            index ++;
        }
        return index;
    }
}

```

> 题型二：输入一组未排序的整数，其中一个数字只出现一次，剩下的所有数字都出现了三次。找出这个只出现一次的数字。例如输入: [1,2,2,2,3,3,3]，输出为1

- 输入描述:

```
输入包含两行:
 第一行有一个整数n(1 ≤ n ≤ 100000),表示数组数字个数n,个数满足题意。 第二行为n个整数,范围均在32位整数,以空格分隔,保证输入数据合法
```

- 输出描述:

```
出现一次的那个数字
```

示例1

- 输入

```
7 1 2 2 2 3 3 3
```

- 输出

```
1
```

```java
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            //查看32个位置上面的数字为1的个数是否是3的倍数多1
            int bit = 1 << i;
            int count = 0;
            for(int j = 0; j < n; j ++){
				if(((array[j] >> i) & 1) == 1){ 
             //可以变成if((array[j] & bit) != 0)
                    count ++;
             //但是不能用==1 的方式，因为当bit = 2,array[i]=2,位与之后就是2了。
                }
            }            
            if(count%3 == 1)
                //代表单独出现的那个数字在 1<<i这个位置上有出现1，故将其相加
                res = res | bit;
        }
        System.out.println(res);
    }
}
```

### 20 、重建二叉树

- 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序**（根-左-右）**遍历序列{1,2,4,7,3,5,6,8}和中序遍历**（左-根-右**）序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

递归构建二叉树，分析：

根据中序遍历和前序遍历可以确定二叉树，具体过程为：

1. 根据前序序列第一个结点确定根结点 
2. 根据根结点在中序序列中的位置分割出左右两个子序列 
3. 对左子树和右子树分别递归使用同样的方法继续分解

例如：

>  前序序列{1,2,4,7,3,5,6,8} = pre

> 中序序列{4,7,2,1,5,3,8,6} = in

1. 根据当前前序序列的第一个结点确定根结点，为 1 
2. 找到 1 在中序遍历序列中的位置，为 in[3] 
3. 切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树 
4. 则切割后的**左子树前序序列**为：{2,4,7}，切割后的**左子树中序序列**为：{4,7,2}；切割后的**右子树前序序列**为：{3,5,6,8}，切割后的**右子树中序序列**为：{5,3,8,6} 
5. 对子树分别使用同样的方法分解

**Java代码：**

```JAVA
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { 
 *	       val = x; 
 *	   }
 * }
 */
import java.util.Arrays;
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
// 可以参考{2,4,7}在前序序列和{4,7,2}在中序序列的位置得出copyOfRange的参数
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
// 可以参考{3,5,6,8}在前序序列和{5,3,8,6} 在中序序列的位置推算得copyOfRange的参数
                break;
            }
        }
        return root;
    }
}
```



### 21 、二叉树的下一个节点

> 分析一： 

分析二叉树的下一个节点，一共有以下情况：![img](https://uploadfiles.nowcoder.com/files/20171225/773262_1514198075109_20151104234034251) 

结合图，我们可发现分成两大类：1、有右子树的，那么下个结点就是右子树最左边的点；（如：D，B，E，A，C，G）     2、没有右子树的，也可以分成两类，a)是父节点左孩子（如：N，I，L） ，那么父节点就是下一个节点 ； b)是父节点的右孩子（如：H，J，K，M）找他的父节点的父节点的父节点...直到当前结点是其父节点的左孩子位置。如果没有如：M，那么他就是尾节点。

>  分析二

![img](https://uploadfiles.nowcoder.com/images/20160918/422268_1474209184699_6D102E3BC36C82693915644B401E210B)

思路：  

- 1、若该节点存在右子树：则下一个节点为右子树最左子节点（如图节点B）  

- 2、若该节点不存在右子树：这时分两种情况：  

  - 2.1、该节点为父节点的左子节点，则下一个节点为其父节点（如图节点D）  

  - 2.2、该节点为父节点的右子节点，则沿着父节点向上遍历，知道找到一个节点的父节点的左子节点为该节点，则该节点的父节点下一个节点（如图节点I ，沿着父节点一直向上查找找到B（B 为其父节点的左子节点），则B的父节点A为下一个节点）

    

>  java代码如下：


```java
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            return pNode;
        }
        if (pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        } else if (pNode.next != null && pNode ==  pNode.next.left){
            return pNode.next;
        } else if (pNode.next != null && pNode ==  pNode.next.right){
            while(pNode.next != null && pNode !=  pNode.next.left){
                pNode = pNode.next;
            }
            return pNode.next;
        } else {
            return pNode.next;
        }
    }
}

```



### 22、机器人的运动范围

- 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

| （0，0） |      |      |      |      |             |
| :------: | ---- | ---- | ---- | ---- | :---------: |
|          |      |      |      |      |             |
|          |      |      |      |      |             |
|          |      |      |      |      |             |
|          |      |      |      |      |             |
|          |      |      |      |      | （m-1,n-1） |

> 分析：

矩阵路径的求解方法可以归结为图或树的遍历/搜索方法，而图的通用搜索算法就是BFS(广度优先搜索)和DFS(优先搜索)。

1.深度优先算法

DFS遍历节点时，满足本题条件则计数符加1，并设置该节点标志为true，同时判断该节点的子节点是否也满足本题条件，进行递归操作。

> Java代码实现如下：

```java
public class Solution {
    public int movingCount(int threshold, int rows, int cols){
        //定义一个标志位二维数组
        boolean[][] isVisted = new boolean[rows][cols];
        //定义一个计数结果变量,定义为数组型才可以
        int[] count = new int[1];
        //进行DFS
        dfs(threshold, rows, cols, 0, 0,count, isVisted);
        //返回结果
        return count[0];
    }
   void dfs(int k, int m, int n, int i, int j, int[] count, boolean[][] isVisted){
       // 判断行坐标和列坐标的数位之和是否大于k
        if (sum(i) + sum(j) <= k){
       // 满足要求，则处理标志位和计数结果变量
        count[0] ++;
        isVisted[i][j] = true;
       // 继续判断并且向下遍历，当i + 1 < m 且 isVisted[i + 1][j]不为true时则继续
        if(i + 1 < m && isVisted[i + 1][j] != true){
            dfs(k, m, n, i + 1, j, count, isVisted);
        }
       // 继续判断并且向右遍历，当j + 1 < n 且 isVisted[i][j + 1]不为true时则继续
        if(j + 1 < n && isVisted[i][j + 1] != true){
            dfs(k, m, n, i, j + 1, count, isVisted);
        }
       }
   }
    int sum(int i){
        int sum = 0;
        while(i > 0){
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}
```

2.广度优先算法

BFS算法使用队列实现，当队列不为空，即取出队列的队首节点，并计数符加1，同时判断该节点的子节点是否满足题目条件，如果满足则push到队列的队尾，循环继续。本题从(0,0)开始，所以只需考虑向右(x+1,y)和向下(x,y+1)。

> java实现如下：

```java
import java.util.*;
public class Solution {
    // 使用宽度优先遍历，BFS，基于队列实现
    public int movingCount(int threshold, int rows, int cols){
        // 定义队列和标志二维数组以及结果
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisted = new boolean[rows][cols];
        int[] count = new int[1];
        // 非法输入的判断
        if(threshold < 0 || rows < 0 || cols < 0){
            return count[0];
        }
        // 现将坐标原点放入队列中
        queue.add(new int[]{0,0});
        // 进行宽度优先遍历
        bfs(threshold, rows, cols, count, queue, isVisted);
        // 返回结果
        return count[0];
    }
    void bfs(int k, int m, int n, int[] count, Queue<int[]> queue,boolean[][] isVisted){
        int [] node;
        int i , j;
        // 若队列非空，则继续进行循环
        while(!queue.isEmpty()){
            // 将队列头部的值取出，并赋值,并且对计数的结果加1
            node = queue.poll();
            i = node[0];
            j = node[1];
            count[0] ++;
            // 判断i + 1是否满足要求，若满足则添加到队列中来
            if(i + 1 < m && isVisted[i + 1][j] != true && (sum(i + 1) + sum(j) <= k)){
                isVisted[i + 1][j] = true;
                queue.add(new int[]{i + 1,j});
            }
            // 判断j + 1是否满足要求，若满足则添加到队列中来
            if(j + 1 < n && isVisted[i][j + 1] != true && (sum(i) + sum(j + 1) <= k)){
                isVisted[i][j + 1] = true;
                queue.add(new int[]{i,j + 1});
            }
        }
    }
     int sum(int i){
         int res = 0;
         while(i > 0){
             res += i % 10;
             i /= 10;
         }
         return res;
     }
}
```

### 23、从上往下打印二叉树

- 从上往下打印出二叉树的每个节点，同层节点从左至右打印。

> 思路 (宽搜思想)



- 思路是用arraylist模拟一个队列来存储相应的TreeNode,每一次打印一个节点的时候，如果该节点有子节点，则把该节点的子节点放到一个队列的尾部。接下来到对队列的头部取出最早进入队列的节点放到ArrayList 中，重复前面的操作，直至队列中所有的节点都存到ArrayList中。

  在Java中Queue是和List、Map同等级别的接口，LinkedList中也实现了Queue接口，该接口中的主要函数有：

  - 容量不够或队列为空时不会抛异常：offer（添加队尾元素）、peek（访问队头元素）、poll（访问队头元素并移除）

  - 容量不够或队列为空时抛异常：add、element（访问队列元素）、remove（访问队头元素并移除）

```java
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left != null)queue.add(node.left);
            if(node.right != null)queue.add(node.right);
        }
        return res;
    }
}
```



### 24、把二叉树打印成多行

- 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

>  分析：

和上一题类似，只是把每一层做为一个列表储存，返回一个大的列表。

- 按层次输出二叉树
- 访问根节点，并将根节点入队。
- 当队列不空的时候，重复以下操作。
- 1、弹出一个元素。作为当前的根节点，未保存到小列表的节点数进行 --。
- 2、如果根节点有左孩子，访问左孩子，并将左孩子入队，（下层节点数）++。
- 3、如果根节点有右孩子，访问右孩子，并将右孩子入队，（下层节点数）++。
- 4、当（未保存到小列表的节点数toSave） ==  （下层节点数nextLevel），则将当前小列表添加到大列表当中去。

- 其中用两个变量，变量toSave表示还未保存到小列表的节点数，nextLevel表示下一层节点数

  */

```java
import java.util.*;
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        queue.add(pRoot);
        int toSave = 1;
        int nextLevel = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null){
                queue.add(node.left);
                nextLevel ++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevel ++;
            }
            toSave --;
            if(toSave == 0){
                toSave = nextLevel;
                nextLevel = 0;
                res.add(new ArrayList(list));
                list.clear();
            }
        }
        return res;
    }
}
```



### 25、按之字型顺序打印二叉树

> 题目：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

思路，根据23、24题的思路，主要是24题的思路，只需加入个翻转标志位的判断，应该不难~

- 我来放一个招面试官鄙视的写法，都能想得到就是使用一个队列来实现：和牛客中[把二叉树打印成多行](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&&tqId=11213&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking),思路是一样的，只是多了个翻转而已，所以我们只需要设置标志位，在偶数层进行翻转，基数层正常输出即可，代码如下：

> java代码如下：



```java
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();//需要返回的结果
        if (pRoot == null) return res;//返回非法输入
        ArrayList<Integer> list = new ArrayList<Integer>();//保存每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();//队列
        queue.add(pRoot);    //先把队首添加进队列
        int toSave = 1, nodeNum = 0; //判断什么时候保存每一层的节点，以及每一层节点的个数
        boolean reverseFlag = false;    //翻转的标志位
        while(!queue.isEmpty()){//进行遍历，队列非空则循环
            TreeNode node = queue.poll();//将队首的节点取出，做进一步的处理
            list.add(node.val);//将队首节点添加到小列表保存
            if (node.left != null){//判断队首节点是否有左节点，有则放入队列，并且下层节点数+1
                queue.add(node.left);
                nodeNum ++;
            }
            if (node.right != null){//判断队首节点是否有右节点，有则放入队列，并且下层节点数+1
                queue.add(node.right);
                nodeNum ++;
            }
            toSave --;//每取一次队首元素，都要进行-1
            if (toSave == 0){//当减到0之后，则说明这一层遍历完毕，可以保存到最终的结果数组
                toSave = nodeNum;//更新每一层的节点数
                nodeNum = 0; //节点数清零
                if (reverseFlag){ //翻转
                    reverseList(list);
                }
                reverseFlag = !reverseFlag;
                res.add(new ArrayList(list));//添加到结果
                list.clear();// 清零列表，以便进行下一层的操作
            }
        }
        return res;
    }
    void reverseList(ArrayList<Integer> list){//翻转操作函数，时间O(n)，空间O(1)
        int len = list.size();
        for(int i = 0; i < len / 2; i ++){
            int temp = list.get(i);
            list.set(i, list.get(len - i - 1));
            list.set(len - i - 1,temp);
        }
    }
}
```



> ==这个是推荐的解法：==

- 使用两个栈来实现：栈1放奇数层的节点，并且先放右节点，栈2存放偶数层的节点，并且先存放左节点。（想要先打印某个节点，就得让他最后入栈，反之想最后再打印某个节点，就得让他最先入栈）这样根据栈先进后出的特点，就能在遍历的时候，奇数层是从左往右输出节点，偶数层的从右往左输出节点的了

```java
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // 返回参数
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) return res;// 非法判断
        ArrayList<Integer> list = new ArrayList<Integer>();// 保存每一层的节点值
        Stack<TreeNode> s1 = new Stack<>();// 建立两个栈来分别保存奇数和偶数层的节点
        Stack<TreeNode> s2 = new Stack<>();// 并且奇数层先保存右节点，偶数层先保存左节点
        s1.add(pRoot);    // 将根节点添加，从这步可以看出来，s1存放的是奇，s2存放偶
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                TreeNode node = s1.pop();// 取出s1的节点，去获取s1的下一层，为偶数
                list.add(node.val);
                if(node.left != null)s2.add(node.left);// 所以这里拿s2来保存偶数的节点，
                if(node.right != null)s2.add(node.right);// 并且是先保存left
            }
            if(!list.isEmpty()){
                // 当遍历完本层之后，可以将本层节点值添加到list中，并且将下层的节点添加到另外的栈中去了
                res.add(new ArrayList(list));// 保存本层节点值到结果中
                list.clear();
            }
            while(!s2.isEmpty()){// 开始进行另外一个栈的遍历，偶数层节点的遍历
                TreeNode node = s2.pop();// 取出栈顶节点，去获取s2的下一层，为奇数
                list.add(node.val);
                if(node.right != null)s1.add(node.right);// 所以这里拿s2来保存奇数的节点，
                if(node.left != null)s1.add(node.left);// 并且是先保存right
            }
            if(!list.isEmpty()){// 当遍历完本层之后，可以将本层节点值添加到list中
                res.add(new ArrayList(list));
                list.clear();
            }
        }
        return res;
    }
}
```



### 26、平衡二叉树

> 题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树

- 概念：（来源于百度[文章](https://baijiahao.baidu.com/s?id=1651427207567199156&wfr=spider&for=pc)）（1）它的左子树和右子树的深度之差(平衡因子)的绝对值不超过1，（2）它的左子树和右子树都是一颗平衡二叉树。也就是说以上两条规则，只要破坏了一个就不是平衡二叉树了。比如说下面这张图：

![img](https://pics5.baidu.com/feed/d788d43f8794a4c2696f07a51979cad0ac6e3906.jpeg?token=cbf10bf2bf0a14a27bd58ac71d04425c&s=8DB4EC128F304D805AC1A8DA000070B3)

上面这张图就是破坏了二叉查找树这一条规则。当然了还有一条规则。也就是他的高度只差不能超过1、下面这张45节点左右子树深度差超过1，故不是平衡二叉树。



![img](https://pics4.baidu.com/feed/4a36acaf2edda3cc1ea6a67c1b64e804203f92ba.jpeg?token=a32a91b0d4c0785f833639a41c4d06ba&s=C6B4AC621BD45DC042D1D8DA0000A0B1)



- 平衡二叉树的定义是左右子树高度差不超过1，同时左右子树也是平衡二叉树，于是代码逻辑可以如下
  - 1、判断树是否为空，空则返回true
  - 2、判断左右子树深度差，其中，求树深度的函数在上一题中“二叉树的深度中”已实现，差超过1，返回false
  - 3、若通过2的判断，对左右子树也判断是否都是平衡二叉树，判断函数为函数自身，递归调用

```java
public class Solution {
    
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null)return 1;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
```

> 或者思路二：上述做法的缺点是，当在某个子树不满足条件，被判断不是平衡二叉树后，还会进行很多次计算，直到计算到根节点的最大深度为止。这是因为上面的做法需要遍历所有的节点。因此使用剪枝。
> 给出大佬的写法,思路就是进行剪枝。其实就是多加两个判断，不符合条件的，直接一直向上返回，没必要还去计算深度

- 使用后续遍历的方式遍历整颗二叉树。在遍历某个节点的左、右节点之后，我们可以根据他的左、右节点的深度去判断他是不是平衡的，并且得到当前节点的深度，当最后遍历到数的根节点时，也就判断了整颗二叉树是不是平衡二叉树

```java
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    public int getDepth(TreeNode root){
        if(root == null)return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
//根据定义，左子树不是AVLTree或右子树不是AVLTree或自己本身就算不是AVLTree,直接返回-1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + (left > right ? left : right);
    }
}
```

### 27、二叉数中和为某一值的路径

> 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

- 思路一：利用前序遍历的思想去做，即==（根-左-右）==的方式去遍历二叉树，当每当遍历一个节点，先将节点添加到小列表当中去，然后再用target减去当前节点的值，当遍历到叶子节点时并且target刚好为0，则说明路径，满足要求，就将小列表添加到结果当中，并且回退到上一个节点继续遍历（即前序遍历）即可

```java
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();//定义一个结果
        if(root == null)return res;// 对空树的判断
        int cSum = 0;		//定义当前路径的和
        dfs(root,target,cSum,new ArrayList<Integer>(),res);//开始计算
        return res;			//返回结果
    }
    void dfs(TreeNode root,int target, int cSum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        cSum += root.val;//对当前节点走过的路径节点值进行累加
        list.add(root.val);//将节点放入到小列表中
        if(cSum == target && root.left ==null && root.right == null){
            res.add(new ArrayList(list));//要是到叶子节点并且和刚刚满足则添加进结果
        }
        if(root.left != null){
            dfs(root.left,target,cSum,list,res);//进行左子树判断
        }
        if(root.right != null){
            dfs(root.right,target,cSum,list,res);//进行右子树判断
        }
//无论当前路径是否加出了target，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null        
        list.remove(list.size() - 1);//最后不满足的节点要从末尾删除，才能进行另外节点的计算，前序遍历
    }
}
```

这两种差差不多，只是少了一个参数：

```java
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)return res;
        loop(root, target, new ArrayList<Integer>(), res);
        return res;
    }
    void loop(TreeNode root, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        target -= root.val;    
        list.add(root.val);
        if(root.left == null && root.right == null && target == 0){
            res.add(new ArrayList(list));
        }
        
        if(root.left != null){
            loop(root.left, target, list, res);
        }
        if(root.right != null){
            loop(root.right, target, list, res);
        }
        list.remove(list.size() - 1);
    }
}
```

### 28、反转链表

> 输入一个链表，反转链表后，输出新链表的表头。

思路：可以有很多种方法，比如使用栈实现，新建一个链表实现。但主要要考察的还是以下这种：

- 1、当只有一个节点的时候，直接返回当前节点

- 2、当当前节点不为空时，我们可以设置使用两个变量保存当前节点和当前节点的下一节点，记录为curNode 和 nextNode

- 3、循环遍历，条件是当nextNode不为空时，使用第三个中间变量tempNode来记录nextNode的下一个节点nextNode.next，接着便进行反转操作，反转之后，curNode 和 nextNode继续往下一位移动，直到nextNode为空，此时curNode 便是反转链表的表头

- 4、需要注意的是，此时headNode为反转链表的最后一个节点，但是headNode.next为反转链表的倒数第二个节点，而反转链表的倒数第二个节点又为headNode。故造成环形，此时只要将headNode.next指向null即可，最后返回curNode完成反转。

  > java代码如下：

```java
/*
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curNode = head;
        ListNode nextNode = head.next;
        while(nextNode != null){
            ListNode tempNode = nextNode.next;//；利用中间变量保存下下个节点，防止断链
            nextNode.next = curNode; //将下一节点指向当前节点，完成反转操作；
            curNode = nextNode;//这两步是移位操作，继续遍历链表后面的节点
            nextNode = tempNode;
        }
        head.next = null;	//如上边第四步所说的，防止成环的操作
        return curNode;
    }
}
```

![img](https://uploadfiles.nowcoder.com/images/20200812/35674416_1597241925374_7A90CCA2048080AA97B9FACCFE29DF2C)

- 法二：

```java
headNodepublic class Solution {
    public ListNode ReverseList(ListNode head) {
      
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
    	ListNode pre = null;
        ListNode next = null;
        //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
        //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
        //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
        //所以需要用到pre和next两个节点
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
            //如此就可以做到反转链表的效果
            //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
            next = head.next;
            //保存完next，就可以让head从指向next变成指向pre了，代码如下
            head.next = pre;
            //head指向pre后，就继续依次反转下一个节点
            //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
            pre = head;
            head = next;
        }
        //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
        //直接输出pre就是我们想要得到的反转后的链表
        return pre;
    }
}
```



法三：使用栈：



```java
import java.util.*;
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode nextNode = stack.pop(); // 创建新的链表，需要创建一个新的引用
        ListNode ans = nextNode;
        nextNode.next = null;		// 初始化
        while(!stack.isEmpty()){
            ListNode x = stack.pop(); // 取出栈顶节点元素，然后初始化节点元素的next值
            x.next = null;
            nextNode.next = x; // 指向下一节点，
            nextNode = x; // 并且进行更新
        }
        return ans;
    }
}
```

### 29、两个链表的第一个公共结点

> 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）

- 思路，用两个指针，分别去遍历两个链表；比如指针一遍历链表一后，再去遍历链表二，指针二遍历链表二后再去遍历链表一；当指针一等于指针二后，循环结束，此时两个指针都在公共节点上了；

![](https://uploadfiles.nowcoder.com/images/20200813/35674416_1597281432325_69C3CC4ED42377F5BC92344711C9A867)

> java实现

```java
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p = pHead1,q = pHead2; // 创立俩指针
        while(p != q){ // 当俩指针不相等时，循环继续，即没有指向同一节点
            if(p != null)p = p.next; // 当没有遍历完链表1时，继续遍历
            else p = pHead2;		 // 遍历完链表1，则遍历链表2
            
            if(q != null)q = q.next; // 当没有遍历完链表2时，继续遍历
            else q = pHead1; 		 // 遍历完链表2，则遍历链表1
// 所以这while循环必然能找到当p 和 q都指向同一个节点的情况，故能找到答案
        }
        return q;// 最后返回q或者p都可以
    }
}
```



### 30、链表中环的入口结点

> 题目：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

==**方法一**==

- 我的思路，遍历一遍链表，要是链表p的下一节点为null则返回null，即不存在环，遍历的时候吧节点添加到HashMap里边，要是出现重复的直接返回该节点。

**java实现：**

```java
import java.util.*;
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null && pHead.next == null) return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode p = pHead;
        while (p != null){
            if(map.containsKey(p.val)){	// 要是一条链上有两个相同的节点，说明有环
                return p;// 直接返回该节点即可
            }else{
                map.put(p.val,1);
            }
            p = p.next;	// 链表后移
        }
        return null;// 当循环结束了，说明链表最后一个指针为null，没有环，则返回null
    }
}
```



==**方法二：**==

- 以上思路可以是可以，但是花费了额外的空间，不是面试官想要的，新思路：
  - 使用两个指针，一快一慢，即快指针p1一次走两步，满指针p2一次走一步，并使慢指针指向pHead，使快指针指向pHead.next。当快指针p1到null还没有赶上p2，则链表无环；当快指针p1赶上p2，即在某个循环中有p1 == p2，则链表有环，我们记这里使用的循环次数为count；
  - 循环次数为count有什么用呢？这是因为我们在开始令慢指针指向pHead，使快指针指向pHead.next，满指针p2一次走一步，快指针p1一次走两步，当他们相遇的时候，p2走过的步数肯定为count，而此p2肯定在环中，这里很关键，在下一步中，我们又借助两个指针，这时让他们的速度是一样的，每次走一步，但是得先让一个指针走count + 1步，先入环；接着两个指针同时走，当他们相遇的时候所在的节点就是环的入口节点了。

![](https://uploadfiles.nowcoder.com/images/20200813/35674416_1597303628334_0B9439C52CFBF2E21D4D1424EA99208A)

java代码如下：

```java
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)return null;//对空链表的判断
        ListNode p = pHead, q = pHead.next;// 借助这两个指针进行
        int count = 0;// 计数变量，记录循环的次数
        while(q != p){// 当p不等于q时，则继续执行
            count ++; // 计数 + 1
            if(q.next == null || q.next.next == null)return null;// 要是为null则说明wu环，返回null
            q = q.next.next;// q为快指针，走两步
            if(p.next == null)return null;// 要是为null则说明wu环，返回null
            p = p.next;// p为慢指针，走一步
        }
        // 当以上循环结束，说明有环存在，此时我们得到循环的次数count变量，故再借助两个指针，让一个指针先走count+1步，另一个指针不动，接着让两个指针循环，每次走一步，当两个指针指向同一个节点时，此节点就是环入口。
        p = pHead;// 指针p清零，指向链表头
        q = pHead;// 指针q清零，指向链表头
        while(count-- >= 0){// 让指针q先走count+1步
            q = q.next;
        }
        while(q != p){  // 当q和p指向不同的指针，则循环
            p = p.next; // 以相同的速度遍历
            q = q.next;
        }
        // 当循环结束，则两个指针都指向环入口节点，返回其中一个指针即可
        return q;
    }
}
```



### 31、 链表中倒数第k个结点

>  输入一个链表，输出该链表中倒数第k个结点。

**==方法一：==**

- 思路：先遍历一遍得到链表的长度n，之后第二次遍历n - k次得到倒数第k个节点

java代码如下：

```java
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || head.next == null) return head;
        int n = 0;
        ListNode p = head;
        while(p != null){// 计算链表的长度
            n ++;
            p = p.next;
        }
        if(n < k)return null;// 要是长度小于k，出入非法，则返回null
        p = head;
        int i = n - k;// 倒数第k个，正着数就是第n-k个，n就是长度，
        while(i-- > 0){
            p = p.next; // 取值
        }
        return p;
    }
}
```

****



**==方法二：==**

> 面试官要求我们只遍历一遍，就能得到答案。这个时候得借助两个指针去进行了

- 思路：定义两个指针，先让指针1走k-1步，接着指针2再从头和指针1一起遍历，当指针一遍历到尾部的时候，指针2的位置就是倒数第k个节点的位置了、（注意对非法输入的判断）

java代码实现如下：

```java
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) return null;// 对非法输入的判断，当k=0时也认为不合法，因为书上说是从1开始计数的
        ListNode p = head, q = head;
        int i = k - 1;
        while (i-- > 0){// 先让p指针走k-1步
            if(p.next == null) return null;// 防止k的值大于链表长度的情况，要是大于直接返回null即可
            p = p.next;
        }
        while(p.next != null){// 接着再一起遍历，当p指针遍历到尾部的时候，此时q指针的位置就是倒数第k个节点的位置了，因为他们的相对距离就是k - 1（从1开始计数）
            p = p.next;
            q = q.next;
        }
        return q;// 返回q即可
    }
}
```



### 32、包含min函数的栈

> 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

- **思路： 看到这个问题, 我们最开始可能会想, 添加一个成员变量用于保存最小元素, 每次压栈时如果压栈元素比当前最小元素更小, 就更新最小元素.  但是这样会有一个问题, 如果最小元素被弹出了呢, 如何获得下一个最小元素呢? 分析到这里可以发现, 仅仅添加一个成员变量存放最小元素是不够的, 我们需要在最小元素弹出后还能得到次小元素, 次小的弹出后, 还要能得到次次小的.  因此, 用另一个栈来保存这些元素是再合适不过的了. 我们叫它最小元素栈.   每次压栈操作时, 如果压栈元素比当前最小元素更小, 就把这个元素压入最小元素栈, 原本的最小元素就成了次小元素. 同理, 弹栈时, 如果弹出的元素和最小元素栈的栈顶元素相等, 就把最小元素的栈顶弹出.**

> java实现

```java
import java.util.Stack;

public class Solution {
    // 定义两个栈，一个栈s用来正常存取数据，另一个栈sMin用来存取最小元素
    Stack<Integer> s = new Stack<>();
    Stack<Integer> sMin = new Stack<>();

    // 这个push比较关键
    public void push(int node) {
        s.push(node); // 对于s栈来说，正常的push即可；
        if (sMin.isEmpty()){ // 对于最小元素栈sMin，当为空时，存入第一个元素
            sMin.push(node);
        } else if (node <= sMin.peek()){ // 当发现有比当前栈顶元素小的时候，这个再把此元素压入栈顶，此时栈顶元素变成最小的元素，所以无论何时，sMin的栈顶元素就是最小值
            sMin.push(node);
        }
    }
    
    public void pop() {// 当出栈的时候，要是s中的最小元素弹出去了，我们也得相应的更新sMin栈的栈顶，即弹出sMIn的栈顶元素，让次小值成为栈顶元素，以此类推即可
        if (s.peek() == sMin.peek())sMin.pop();
        s.pop();// 对于s，正常的弹出即可；
    }
    
    public int top() {
        return s.peek();// 返回s栈的栈顶
    }
    
    public int min() {
        return sMin.peek(); // 直接返回最小元素栈的栈顶，即找到最小元素。
    }
}
```

### 33、简单的变换

> 给你一个正整数n，重复进行以下操作： 
>
> 1.如果n是奇数，令n=n−3n=n-3n=n−3  
>
> 2.如果n是偶数，令n=n/2n=n/2n=n/2
>
>   重复上述直至n=0停止，请输出进行操作的次数，如果n永远无法变成零，输出-1

示例1

输入

```
2
```

输出

```
-1
```

说明

```
1:2->1(2/2=1)
2:1->-2(1-3=-2)
3:-2->-1((-2)/2=(-1))
4.-1->-4(-1-3=-4)
5.-4->-2((-4)/2=(-2))
6.-2->-1((-2)/2=(-1))
.......开始进入第三步操作到第五步操作的循环，n永远无法等于0，所以返回-1。
```

示例2

输入

```
9
```

输出

```
3
```

说明

```
1.9->6(9-3=6)
2.6->3(6/2=3)
3.3->0(3-3=0)
三步操作后n变为0，所以返回3。
```

备注:

```
对于30%30\%30%的数据，1≤n≤1e61\leq n\leq 1e61≤n≤1e6

对于100%100\%100%的数据，1≤n≤1e181\leq n\leq 1e181≤n≤1e18
请返回最少操作数或者-1
```

- 思路：



```java
import java.util.*;

public class Solution {
    /**
     * 
     * @param n long长整型 
     * @return int整型
     */
    public int Numberofoperations (long n) {
        int count = 0;
        if (n < 0)return -1;
        if (n == 0)return 0;
        while(n != 0){
            count ++;
            if(n % 2 == 0){ // 偶数
               n = n >> 1;
            } else {     // 奇数
                n -= 3;
            }
            if (n == 1 || n == 2 || n == -2)return -1;// 遇到这几种情况肯定是不能得到0的了，故直接返回-1即可、
        }
        return count;
    }
}
```



### 34、牛牛的01游戏

> 牛牛最近迷上了小游戏，于是他也想对他的01字符串进行一些操作，01字符串上的0和0相邻时会变成1，而1和1相邻时会在字符串上消失，而0和1相邻时什么都不会发生，牛牛现在把初始的字符串给你，你能告诉牛牛这个字符串最后会变成什么样吗。[题目链接](https://ac.nowcoder.com/acm/contest/6911/B)

 输入

```
"00110001"
```

输出

```
"01"
```

说明

```
00110001→1110001→10001→1101→01
```

备注:

```
1≤∣str∣≤1061\leq |str|\leq10^61≤∣str∣≤106，字符串上的合并消失应优先与左边进行，例如000，中间的0优先与左边的0合并变为10，消失同理
```

------------



- 思路：使用栈来实现就好

```java
import java.util.*;
public class Solution {
    /**
     * 
     * @param str string字符串 初始字符串
     * @return string字符串
     */
    public String solve (String str) {
        // write code here
        Stack<Character> stack = new Stack<Character>();// 创建一个栈
        for(char c : str.toCharArray()){ // 开始遍历
            if(!stack.isEmpty() && stack.peek() == '0' && c == '0'){//00->1
                stack.pop();
                if(!stack.isEmpty() && stack.peek() == '1'){// 要是此时的栈顶元素为1则与上边00得到的1相互抵消，直接pop即可
                    stack.pop();
                }else{// 要是不是1，则将00得到的1压入栈
                    stack.push('1');
                }
            }else if (!stack.isEmpty() && stack.peek() == '1' && c == '1'){
                stack.pop();// 要是栈顶元素和遍历到的元素都为1，则直接将栈顶元素pop
            }else{
                stack.push(c); // 要是以上都不符合，则将此元素压入栈即可
            }
        }
        StringBuilder sb = new StringBuilder();// 创建一个sb去接收
        while(!stack.isEmpty()){	// 循环遍历栈，取出元素
            sb.append(stack.pop());
        }
        return sb.reverse().toString();// 栈的先进后出，所以得翻转再输出。
    }
}
```

### 35、新集合

> - 题意
>
>   集合 s 中有整数 111 到 nnn，牛牛想从中挑几个整数组成一个新的集合。 
>
>   现在牛妹给牛牛加了 mmm 个限制 ，每个限制包含两个整数 uuu 和 vvv ( u≠vu\neq vu=v)，且 uuu 和 vvv 不能同时出现在新集合中 。 
>
>   请问牛牛能组成的新集合多少种。 
>
>   *可以选 0 个数* 
>
> -  输入
>
>   第一个参数为 nnn。 
>
>   第二个参数为 mmm 。 
>
>   第三个参数为 mmm 对 (u, v) 。 
>
>   1<n≤20  1≤m≤400  1≤u,v≤n1 < n \leq 20 \quad 1\leq m \leq 400\quad 1 \leq u, v\leq n1<n≤201≤m≤4001≤u,v≤n  
>
>   返回 
>
>   一个整数，即新集合的种类数。
>
> 
>
> 示例1
>
> - 输入
>
> ```
> 3,2,[(1,2),(2,3)]
> ```
>
> - 输出
>
> ```
> 5
> ```
>
> - 说明
>
> ```
> 当 n = 3 时，共有 8 个子集，当加上限制 (1, 2), (2, 3) 后，合法的自己有 [], [1], [2], [3], [1, 3] 共 5 个
> ```



-------



```java
import java.util.*;

/*
 * public class Point {
 *   int x;
 *   int y;
 * }
 */

public class Solution {
    /**
     * 返回新集合的种类数
     * @param n int整型 集合大小
     * @param m int整型 限制数量
     * @param limit Point类一维数组 不能同时出现的(u,v)集合
     * @return int整型
     */
    int res = 0; boolean[] v;
    public int solve (int n, int m, Point[] limit) {
        // write code here
        v = new boolean[n+1];
        dfs(limit,1,n);
        return res;
    }
    public void dfs(Point[] limit,int x, int n) {
        if(x>n) {
            for(Point lim:limit)
                if(v[lim.x]&&v[lim.y]) return;
            res++;
            return;
        }
        v[x] = true;
        dfs(limit,x+1,n);
        v[x] = false;
        dfs(limit,x+1,n);
    }
}
```

### 36、删除链表中重复的结点

> 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

- 思路：
- 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
  2. 设置 pre ，next指针， pre指针指向当前确定不重复的那个节点，而next指针相当于工作指针，一直往后面搜索。



```java
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null) return pHead;// 非法输入判断
        ListNode node = new ListNode(0);// 创建一个头结点，避免第一个元素就被删除的情况
        node.next = pHead;// 将头结点的下一节点指向输入链表的头
        ListNode pre = node;// 保存不重复的值的指针
        ListNode next = node.next;// 这个指针一直向后移动，用于判断重复的结点元素
        while(next != null){    // 遍历这个链表
            if(next.next != null && next.val == next.next.val){// 要是遇到重复的元素
                while(next.next != null && next.val == next.next.val){
                    next = next.next;// 则跳过当前的重复元素
                }
                next = next.next;// 并且把本身的重复的值也去掉
                pre.next = next; // 更新保存指向不重复值的指针
            } else {// 要是没有遇到重复的值，则往下遍历即可
                next = next.next;
                pre = pre.next;
            }
        }
        return node.next;    // 返回，不能直接返回node，因为node的头结点为0，我们不需要
    }
}
```



### 37、孩子们的游戏(圆圈中最后剩下的数)

> 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
>
> 如果没有小朋友，请返回-1

- 思路：用数组来模拟环

```java
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)return -1;
        int[] arr = new int[n];// 定义一个数组
        int i = -1, step = 0, count = n;
        while(count > 0){
            i++;
            if(i >= n) i = 0;
            if(arr[i] == -1) continue; // 要是已经被遍历过了，则跳过
            step ++; // 步数加1
            if(step == m){ // 刚好等于m时。则说明到达目标
                count --;	// 对目标的数目减1
                step = 0;	// 重新初始化步数
                arr[i] = -1;//设置标志位
            }
        }
        return i; // 返回最后的i
    }
}
```



- 思路二:使用列表list去做：先把节点添加到列表当中，模拟游戏去删除节点，主要是index的计算` index = (m - 1 + index) % list.size()`，因为每删除一个节点，list的大小就会发生改变，而我们要模拟环的话就应该对list.size取余即可。
- java实现如下：

```java
import java.util.*;
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n < 1 || m < 1)return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i ++){// 将节点添加到列表中来
            list.add(i);
        }
        int index = 0;// 设置初始下标
        while (list.size() > 1){// 遍历，条件是当列表只有一个元素就停止
            index = (m - 1 + index) % list.size(); // 这一步最关键
            list.remove(index);
        }
        return list.get(0);// 返回仅剩的元素即可
    }
}
```



### 38、复杂链表的复制

> 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）


- 思路：先将链表的每个节点复制一份再插入到旧节点的后面，再处理ramdon的链接，最后再进行链表的分离就可以得到复制的链表了

```java
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        // 1、进行非法的判断
        if(pHead == null) return null;
        // 2、复制节点
        RandomListNode curNode = pHead;
        while(curNode != null){
            // 复制节点的值
            RandomListNode tempNode = new RandomListNode(curNode.label);
            // 将新节点的值指向源节点的下一个节点
            tempNode.next = curNode.next;
            // 将源节点指向新复制的节点
            curNode.next = tempNode;
            // 继续往下一位遍历
            curNode = tempNode.next;
        }
        // 3、节点ramdon的连接
        curNode = pHead;
        while(curNode != null){
            // 处理新复制节点的ramdon
            curNode.next.random = curNode.random == null ? null : curNode.random.next;
            // 继续往下一位遍历
            curNode = curNode.next.next;
        }
        // 4、拆分链表
        curNode = pHead;
        RandomListNode pResHead = pHead.next;
        while(curNode != null){
            // 保存新节点的头为tempNode
            RandomListNode tempNode = curNode.next;
            // 分离，将curNode指向原来的下一节点
            curNode.next = tempNode.next;
            // 处理新复制节点的下一节点
            tempNode.next = tempNode.next == null ? null : tempNode.next.next;
            // 继续往下一位遍历
            curNode = curNode.next;
        }
        // 5、返回结果
        return pResHead;
    }
}
```



### 39、栈的压入、弹出序列

> 栈的压入和弹出：

- 思路；对压入栈序列进行一个入栈的模拟，然后在模拟的过程当中，判断栈顶元素和出栈序列的相等关系，从而判断出对栈顶元素的操作。
- 提示，代码二较为简洁，代码一理解起来难，建议直接看代码二即可;
- java代码实现一： 

```java
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 对输入数组的初始判断
        if(pushA.length != popA.length) return false;
        // 建立一个栈
        Stack<Integer> stack = new Stack<>();
        // 定义传入参数的两个数组的下标索引
        int pushIndex = 0;
        int popIndex = 0;
        // 当入栈的索引小于数组的长度的时候则循环
        while(pushIndex < pushA.length){
            // 当栈不为空并且栈顶元素等于弹出序列的元素时则执行
            if(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                // 下标自加
                popIndex ++;
                // 弹出栈顶元素
                stack.pop();
            }
            // 要是以上条件不成立，则对压栈序列进行入栈操作
            stack.push(pushA[pushIndex ++]);
        }
        // 为防止以上while循环不能处理最后一个序列时的问题
        while(!stack.isEmpty()){
            if(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                popIndex ++;
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}
```
- Java代码实现二：

```java
import java.util.*;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 对输入数组的初始判断
        if(pushA.length != popA.length) return false;
        // 建立一个栈
        Stack<Integer> stack = new Stack<>();
        // 定义操作弹出序列的下标
        int index = 0;
        // 开始遍历
        for(int i = 0; i < pushA.length; i ++){
            // 对于入栈序列的每个元素进行入栈
            stack.push(pushA[i]);
            // 当栈不为空并且当栈顶元素等于出栈序列的元素值时，则执行
            while(!stack.isEmpty() && stack.peek() == popA[index]){
                // 进入循环说明栈顶元素等于出栈序列的值，此时则需要弹
                // 出栈顶元素，以及出栈序列的后移操作
                stack.pop();
                index ++;
            }
        }
        // 当栈中的元素为空使，说明出栈序列和栈模拟的一样，则返回true，
        // 若栈不为空，则说明出栈序列和栈模拟的不一致，返回false
        return stack.isEmpty();
    }
}
```



###  40、二叉搜索树的后序遍历序列

> 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。

- 思路，因为关键词：**二叉搜索树、后序遍历**。所以能想到的是这颗树的左节点比右节点要小，并且根节点在最后才会输出（左-右-根）。
- 所以我们先从数组那到最后一个数作为root根节点，此时判断有没有左节点，要是索引为0的元素比root大则没有左子树，否则就遍历，找到第一个比root大的节点，作为右子树的开端，在遍历右子树的时候要是出现比根节点小的元素，则直接return false即可，因为不满足搜索二叉树的规则，接着递归将左子树和右子树进行调用即可



> 思路总结：**已知条件**：**后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。**
>
> **1、确定root；**
>
> **2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；**
>
> **3、遍历右子树，若发现有小于root的值，则直接返回false；**
>
> **4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。**



```java
import java.util.*;
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        int root = sequence[sequence.length - 1];
        int i = 0;
        for(;i < sequence.length - 1; i ++){
            // 找到第一个大于root的位置,则该位置左边为左子树，右边为右子树；**
            if(root < sequence[i])break;
        }
        int j = i;
        for(;j < sequence.length - 1; j ++){ // 循环时去除root，因此为len-1
            if(root > sequence[j])return false; // 有一个小于root，则返回false
        }
        boolean left = true;
        boolean right = true;
        if(i > 0)left = VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,i));// copyOfRange，包括0，但是不包括i
        if(i < sequence.length - 1)right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,sequence.length - 1));
        return (left & right);
    }
}
```



### 41、序列化二叉树

> 请实现两个函数，分别用来序列化和反序列化二叉树
>
> 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
>
> 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
>
> 
>
> 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树





- 算法思想：根据**前序遍历**规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
- 依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
- 另外，结点之间的数值用逗号隔开。



```java
public class Solution {
    int index = -1; // 计数变量,字符串数组的角标
    String Serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");//当今节点为空，就添加一个#做标记
            return sb.toString();
        }
        sb.append(root.val + ",");//前序遍历根节点
        sb.append(Serialize(root.left));//然后调用左子树递归
        sb.append(Serialize(root.right));//最后调用右子树递归
        return sb.toString();
    }
    TreeNode Deserialize(String str){
       index++; // 索引每次加一
       // int len = str.length();
       // if(index >= len){
       //     return null;
       // }
        String[] strr = str.split(",");// 将序列化之后的序列用，分隔符转化为数组
        TreeNode node = null;
        if(!strr[index].equals("#")){ // 不是叶子节点 继续走 是叶子节点出递归
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
         
        return node;
    }
}
```



### 42、对称的二叉树

> 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

> 解法一：思路：当两个子树完全对称的时候，左子树的左节点等于右子树的右节点，左子树的右节点等于右子树的左节点，此时可以通过递归来进行下去，请看代码实现：

- java实现

```java
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    boolean isSymmetrical(TreeNode pRoot){
        return Helper(pRoot, pRoot);// 借助这个辅助函数去实现
    }
    boolean Helper(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null)return true;// 要是等于空，则返回true
        if(p1 == null || p2 == null)return false;// 要是只有一个为空则返回false
        if(p1.val != p2.val)return false;// 要是值不相等则返回false
        // 继续进行递归，也就是左子树的左节点等于右子树的右节点，左子树的右节点等于右子树的左节点，才是对称的二叉树
        return (Helper(p1.left,p2.right) && Helper(p1.right,p2.left));
    }
}
```

> 解法二:
>
> //===================**非递归算法，利用DFS和BFS**=============================//
>  /*
>  \* **DFS使用stack**来保存成对的节点
>
>   \* 1.**出栈**的时候也是**成对**成对的 ， 
>
>    1.若都为空，继续；  
>
>    2.一个为空，返回false;  
>
>    3.不为空，比较当前值，值不等，返回false；  
>
>  \* 2.确定入栈顺序，每次**入栈**都是成对**成对**的，如left.left， right.right ;left.rigth,right.left
>  */

- java代码如下：

```java
 boolean isSymmetricalDFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
```

> 解法三 ：
>
> /*
>  \* **BFS使用Queue**来保存成对的节点，代码和上面极其相似
>
>   \* 1.**出队的时候也是成对成对**的 
>
>    1.若都为空，继续；  
>
>    2.一个为空，返回false;  
>
>    3.不为空，比较当前值，值不等，返回false；  
>
>  \* 2.确定入队顺序，**每次入队都是成对成对的**，如left.left， right.right ;left.rigth,right.left
>  */ 

- java代码如下：

```java
 boolean isSymmetricalBFS(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while(!s.isEmpty()) {
            TreeNode left= s.poll();//成对取出
            TreeNode right= s.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }
```

### 43、 二叉搜索树的第k个结点

> 题目：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）  中，按结点数值大小顺序第三小结点的值为4。

- 思路：经过观察可知，二叉搜索树的中序遍历可以使节点的值从低往高排列，所以可以先将输入的二叉树中序遍历后保存到队列，利用先进先出的性质输出第k个节点即可。

```java
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
import java.util.*;
public class Solution {
    Queue<TreeNode> queue = new LinkedList<>(); // 队列，用于保存中序遍历的节点
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k == 0) return null;// 非法输入的判断
        MidTraversal(pRoot);// 进行中序遍历
        while(k-- > 0){ // 取出第k个节点，因为队列中节点的值是冲小到大排列的，故第k个就是第k大的值了
            pRoot = queue.poll();
        }
        return pRoot;// 返回这个值即可
    }

    void MidTraversal(TreeNode node){ // 使用递归的方式进行中序遍历（左-根-右）
        if (node == null)return;      // 递归终止的条件 
        MidTraversal(node.left);	// 左节点的遍历
        queue.offer(node);		    // 保存当前节点
        MidTraversal(node.right);	// 右节点的遍历
    }
}
```

