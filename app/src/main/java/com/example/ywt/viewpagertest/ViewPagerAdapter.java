package com.example.ywt.viewpagertest;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ywt.viewpagertest.bean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ywt on 2018/9/6.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private List<Bean> list;
    private Context mContext;

    public ViewPagerAdapter(List<Bean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    /**
     * 返回list长度
     *
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 判断instantiateItem(ViewGroup container, int position)返回的要加载的pager对象是不是view视图，
     * 是则返回true并显示，不是返回false不显示。
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * @param container 用来装填list的ViewPager对象
     * @param position  装填过程中给每个list的下标
     * @return 返回的对象就是当前填充进去的list对象
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_viewpager, container, false);
        //获取图片与标题id
        ImageView imageView = view.findViewById(R.id.img);
        TextView tv_title = view.findViewById(R.id.tv_title);

        Bean bean = list.get(position);

        imageView.setImageResource(bean.getImg());
        tv_title.setText(bean.getTitle());

        container.addView(view);
        return view;
    }

    /**
     * 销毁多余3个的pager对象。
     *
     * @param container vp对象
     * @param position  vp对象的下标
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}















