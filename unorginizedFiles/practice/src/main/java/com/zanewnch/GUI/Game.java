package com.zanewnch.GUI;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public void launch(){

        this.setVisible(true);

        this.setSize(600,600);

//        視窗位置
        this.setLocationRelativeTo(null);

        this.setTitle("Snake Game");
    }

    @Override
    public void paint(Graphics g){
//        background color
        g.setColor(Color.GRAY);
        g.fillRect(0,0,600,600);

        //        網格線
        g.setColor(Color.BLACK);
        for (int i = 0; i < 20; i++) {
//            橫線
            g.drawLine(0,i * 30,600,i * 30);
//            豎直線
            g.drawLine(i * 30,0,i * 30,600);
        }


    }


}
