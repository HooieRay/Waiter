package com.monkeyking.common.widget

import android.view.Menu
import android.view.MenuItem
import androidx.core.view.forEachIndexed
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView


/**
 * TabLayoutMediator 仿写
 * 封装bottomNavigationView和Viewpager2的联动
 */
class BnvVp2Mediator(
    private val bottomNavigationView: BottomNavigationView,
    private val viewPager2: ViewPager2,
    private val config :((BottomNavigationView,ViewPager2)->Unit) ?= null //以函数的形式作为参数入参，传递进来
) {

    //存储BottomNavigationView中menu的item和其自身position的映射关系
    private val map = mutableMapOf<MenuItem,Int>()

    init {
        //初始化BottomNavigationView的item和index映射关系
        bottomNavigationView.menu.forEachIndexed { index, item ->
            map.put(item,index)
        }
    }

    /**
     * 关联BottomNavigationView和ViewPager2的选择关系，联动
     */
    fun attach(){

        config ?.invoke(bottomNavigationView,viewPager2)//调用配置

        viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigationView.selectedItemId = bottomNavigationView.menu.get(position).itemId
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener { currentFragment ->
            viewPager2.currentItem =
                map.get(currentFragment) ?: error("bottomNavigationView的Id${currentFragment.itemId}没有对应的viewpager2元素")
            true
        }
    }
}