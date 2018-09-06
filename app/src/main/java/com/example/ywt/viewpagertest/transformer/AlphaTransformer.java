package com.example.ywt.viewpagertest.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 页面上正中间的item是正常的，两边的item都有一点透明度
 * Created by ywt on 2018/9/6.
 */

public class AlphaTransformer implements ViewPager.PageTransformer {
    private float MINALPHA = 0.5f;

    /**
     * position取值特点：
     * 假设页面从0～1，则：
     * 第一个页面position变化为[0,-1]
     * 第二个页面position变化为[1,0]
     *
     * @param page
     * @param position
     */
    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {
            page.setAlpha(MINALPHA);
        } else {
            //不透明->半透明
            if (position < 0) {//[0,-1]
                page.setAlpha(MINALPHA + (1 + position) * (1 - MINALPHA));
            } else {//[1,0]
                //半透明->不透明
                page.setAlpha(MINALPHA + (1 - position) * (1 - MINALPHA));
            }
        }
    }

}
