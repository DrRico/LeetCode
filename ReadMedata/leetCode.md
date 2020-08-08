## 基础知识

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

```jav
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

链接：https://www.nowcoder.com/questionTerminal/e02fdb54d7524710a7d664d082bb7811?f=discussion
来源：牛客网



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









































