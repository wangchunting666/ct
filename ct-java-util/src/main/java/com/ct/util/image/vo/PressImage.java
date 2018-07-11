package com.ct.util.image.vo;

/**
 * Created by Herdsric-M-003 on 2018/7/9.
 */
public class PressImage {
    private String waterImg;
    private String orginImg;
    private String img;
    private int x;
    private int y;
    private int width;
    private int height;
    private float alpha;

    @Override
    public String toString() {
        return "waterImg:"+waterImg+","+
                "orginImg:"+orginImg+","+
                "img:"+img+","+
                "x:"+x+","+
                "y:"+y+","+
                "width:"+width+","+
                "height:"+height+","+
                "alpha:"+alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setOrginImg(String orginImg) {
        this.orginImg = orginImg;
    }

    public void setWaterImg(String waterImg) {
        this.waterImg = waterImg;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getAlpha() {
        return alpha;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImg() {
        return img;
    }

    public String getOrginImg() {
        return orginImg;
    }

    public String getWaterImg() {
        return waterImg;
    }
}
