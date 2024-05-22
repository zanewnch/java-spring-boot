package com.zanewnch.GUI.test;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;

    @Override
    public void paint(Graphics g){
//        background color
        g.setColor(Color.BLACK);
    }

    private void updateTime(int hours, int minutes, int seconds){
        DecimalFormat df = new DecimalFormat("00");
        String time = df.format(hours)+":"+df.format(minutes)+":"+df.format(seconds);

        timeLabel.setText(time);
    }

    public void printTime(int hours,int minutes, int seconds){

        this.setTitle("Clock");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial",Font.BOLD,80));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        getContentPane().add(timeLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(600,600);

        //        視窗位置
        this.setLocationRelativeTo(null);

        this.setVisible(true);

        updateTime(hours,minutes,seconds);


    }


}
