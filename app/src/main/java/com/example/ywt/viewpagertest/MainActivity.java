package com.example.ywt.viewpagertest;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.ywt.viewpagertest.bean.Bean;
import com.example.ywt.viewpagertest.transformer.AlphaTransformer;
import com.example.ywt.viewpagertest.transformer.CardTransformer;
import com.example.ywt.viewpagertest.transformer.GalleryTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> list;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new Bean(R.mipmap.img_one, "标题一"));
        list.add(new Bean(R.mipmap.img_two, "标题二"));
        list.add(new Bean(R.mipmap.img_three, "标题三"));

        //设置Page间间距
        viewPager.setPageMargin(20);
        //设置缓存的页面数量
        viewPager.setOffscreenPageLimit(3);
        //设置自定义滑动动画
        //  viewPager.setPageTransformer(false, new GalleryTransformer());

        viewPagerAdapter = new ViewPagerAdapter(list, context);
        viewPager.setAdapter(viewPagerAdapter);

        //由于ViewPager 没有点击事件，可以通过对VIewPager的setOnTouchListener进行监听已达到实现点击事件的效果
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            int flage = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //当屏幕检测到第一个触点按下之后就会触发到这个事件。
                        flage = 0;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //当触点在屏幕上移动时触发，触点在屏幕上停留也是会触发的，主要是由于它的灵敏度很高，而我们的手指又不可能完全静止
                        // （即使我们感觉不到移动，但其实我们的手指也在不停地抖动）。
                        flage = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        //当触点松开时被触发。
                        if (flage == 0) {
                            int item = viewPager.getCurrentItem();
                            if (item == 0) {
                                Toast.makeText(MainActivity.this, "点击1", Toast.LENGTH_SHORT).show();
                            } else if (item == 1) {
                                Toast.makeText(MainActivity.this, "点击2", Toast.LENGTH_SHORT).show();
                            } else if (item == 2) {
                                Toast.makeText(MainActivity.this, "点击3", Toast.LENGTH_SHORT).show();
                            }
                        }
                        break;
                }
                return false;
            }
        });
    }

}















