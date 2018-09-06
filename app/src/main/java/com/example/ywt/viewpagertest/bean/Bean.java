package com.example.ywt.viewpagertest.bean;

import java.util.List;

/**
 * Created by ywt on 2018/9/6.
 */

public class Bean  {
    private int img;
    private String title;

    public Bean() {
    }

    public Bean(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "img=" + img +
                ", title='" + title + '\'' +
                '}';
    }
}
