package com.zanewnch.GUI.entities;

import com.zanewnch.GUI.Game;

import java.awt.*;

public class GameObj {
//    圖片
    private Image img;
    private int x;
    private int y;
    private  int width;
    private int height;
    private Game frame;


    public GameObj() {
    }

    public GameObj(Image img, int x, int y, int width, int height, Game frame) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.frame = frame;
    }

    /**
     * 获取
     * @return img
     */
    public Image getImg() {
        return img;
    }

    /**
     * 设置
     * @param img
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * 获取
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return frame
     */
    public Game getFrame() {
        return frame;
    }

    /**
     * 设置
     * @param frame
     */
    public void setFrame(Game frame) {
        this.frame = frame;
    }

    public String toString() {
        return "GameObj{img = " + img + ", x = " + x + ", y = " + y + ", width = " + width + ", height = " + height + ", frame = " + frame + "}";
    }

    public void paintself(Graphics g){
        g.drawImage(img,x,y,null);
    }
}
