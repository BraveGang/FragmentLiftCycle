package com.wangshijia.www.fragmentliftcycle.inner;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.wangshijia.www.fragmentliftcycle.LazyLoadBaseFragment;
import com.wangshijia.www.fragmentliftcycle.R;

/**
 * 当 FragmentAdapter 嵌套的 Fragment 中仍有 FragmentAdapter ，当承载内部 Adapter 的 Fragment 走生命周期函数的时候
 * 内部Fragment 也将会紧跟外部的 Fragment 生命周期函数调用自己的 Fragment 生命周期函数
 * 如 外部 TestFragment2 承载了 FragmentAdapter Activity 初始化外部 TestFragment1 完成后，TestFragment2将被预加载，
 * 而TestFragment2中的InnerTestFragment1 将
 */
public class Bottom1InnerFragment1 extends LazyLoadBaseFragment {


    public static Bottom1InnerFragment1 newInstance(String params) {
        Bottom1InnerFragment1 fragment = new Bottom1InnerFragment1();
        Bundle args = new Bundle();
        args.putString("params", params);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initView(View rootView) {
        FragmentManager fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.innerFragment, ThirdInnerFragment.newInstance("trrrr")).commit();
    }
}
