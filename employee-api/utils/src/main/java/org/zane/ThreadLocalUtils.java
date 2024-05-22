package org.zane;


/*
Design this Utils 是要把interceptor 解析token 之後的value 應用到 service裡面，in service would create an Employee object, and assign the token value to the Employee Object and then pass to database(for the employee table, create_user and update_user column)

為了要取得token parse value, 其實也可以直接從request 當中使用getHeader取得token, 只是這樣需要額外再parse一次，所以改成直接從interceptor取得parse token value
 */

/*
原本課堂給的code 是只限定Long type, 我覺得這樣設定很不wisely, 所以我改成generic type
 */

/*
您在 ThreadLocalUtils 類上添加了泛型 <T>，但實際上類的泛型與您的靜態方法是分開的。所以，您在靜態方法上又用了另一個 <T>，這有點混淆。實際上，由於這是一個工具類，不需要實例化，所以不需要在類級別上使用泛型。
您應該只在方法級別上使用泛型。

當您在類上定義泛型時，主要的目的是允許用戶在實例化該類時指定一個或多個類型參數。
 */
public class ThreadLocalUtils {

    /*
    threadLocal是一個static屬性。這意味著，不論有多少BaseContext的實例，它們都將共享同一個threadLocal參考。但記住，儘管threadLocal是static的，ThreadLocal的特性確保每個執行緒都有它自己的獨特值。

    然後因為ThreadLocal 基本上不會被instantiated, 所以就代表在同一個thread當中 都會共用同一個threadLocal
     */
    public static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static <T> void setCurrentValue(T value) {

        // 因為threadLocal is public, 所以不需要使用this.threadLocal
        threadLocal.set(value);
    }

    /*
    1. 我前面instantiate ThreadLocal 的時候，限定了他的generic type是Object, 所以ThreadLocal.get() return type 是Object
    但是這個method 要求return T type, 所以要用type casting(類型轉換)

    2.但是直接type casting 會有 unchecked casting warning, 所以要用 @SuppressWarnings("unchecked") 來忽略這個warning
     */
    @SuppressWarnings("unchecked")
    public static <T> T getCurrentValue() {
        return (T) threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }
}
