package org.zane.recursion;

public class ReverseString {

    public static void reverse(String data, int index){
        if(index == data.length()){
            return;
        }
        /*
        當 index == data.length() -1 的時候，他的method content 裡面的reverse() 才會結束，才會執行下面的sout, 所以第一個被print出來的char會是最深層的那個，然後才一個一個迴出來
        所以順序會是 d c b a
         */
        reverse(data,index+1);
        System.out.println("reverse : "+data.charAt(index));

    }

    public static void main(String[] args) {
        String data = "abcd";

        for (int i = 0; i < data.length(); i++){
            System.out.println("original : "+data.charAt(i));
        }

        reverse(data,0);
    }
}
