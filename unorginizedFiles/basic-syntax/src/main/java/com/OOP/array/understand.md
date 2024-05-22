### 封裝、繼承、多態的理解
1. 封裝：就是把一個object的property, method都寫在一起，方便管理
2. 繼承： **就是把多個子類相同的property or method抽取出來，放到父類，這樣子類九只需要額外再寫自己需要的property or method**
3. abstract抽象類：多個子類都有相同的method,但method具體的做法不一樣，如果直接在父類定義method,而寫子類的人不去進行修改，那就會出錯；因此有了abstract,也就是在abstract parent class
   (super class)當中不具體寫method body,只是說有這個method；然後子類(child class)(sub class)繼承的時候就一定要@override．
    abstract的補充： 在abstract class當中，只有method會用到abstract keyword, property不需要，因為property會使用setter or 
   parameter的方式進行assign,因此不需要abstract
    但abstract class 同樣有construction function, 用意一樣是抽取多個子類共同的property,然後child class會在其construction function 當中透過super 來assign 
     abstract parent class
4. 多態：多態其實就是指繼承parent class後，@override method 而已
