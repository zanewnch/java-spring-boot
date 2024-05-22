package com.zanewnch.GUI.test;

import com.zanewnch.GUI.Game;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class gameTest1 {
    public static void main(String[] args) {
//      貪吃蛇遊戲
        Game game = new Game();
//        game.launch();

//      get current time data
        // 创建当前时间的 Date 对象
        Date currentTime = new Date();

        List<Integer> dateList = new ArrayList<>();

        // 创建日期格式化对象，指定日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        // 使用格式化对象将 Date 对象格式化为字符串
        String currentTimeString = sdf.format(currentTime);

        String[] addressdate = currentTimeString.split(":");

        for (String data: addressdate
             ) {
            dateList.add(Integer.parseInt(data));
        }

        for (Integer data: dateList
             ) {
            data = data.intValue();
        }

//        while (true){
//            dateList.set(0,dateList.get(0)+1);
//            dateList.set(1,dateList.get(1)+1);
//            dateList.set(2,dateList.get(2)+1);
//        }


//        顯示時鐘
        DigitalClock digitalClock = new DigitalClock();
        digitalClock.printTime(dateList.get(0),dateList.get(1),dateList.get(2));
    }
}
