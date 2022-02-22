package com.monkeyking.waiter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.monkeyking.canteen.CanteenFragment
import com.monkeyking.common.base.BaseActivity
import com.monkeyking.common.widget.BnvVp2Mediator
import com.monkeyking.home.HomeFragment
import com.monkeyking.mine.MineFragment
import com.monkeyking.order.OrderFragment
import com.monkeyking.waiter.databinding.ActivityMainBinding


class MainActivity : BaseActivity<ActivityMainBinding>(){

    override fun getLayoutRes() = R.layout.activity_main

    //实例化得到新的对象
    private val fragments:Map<Int,ReFragment> = mapOf<Int,ReFragment>(
        INDEX_HOME to {HomeFragment()},
        INDEX_CANTEEN to {CanteenFragment()},
        INDEX_ORDER to {OrderFragment()},
        INDEX_MINE to {MineFragment()}
    )

    //不需要实例的写法
//    private val fragments:Map<Int,Fragment> = mapOf<Int,Fragment>(
//        INDEX_HOME to HomeFragment(),
//        INDEX_CANTEEN to CanteenFragment(),
//        INDEX_ORDER to OrderFragment(),
//        INDEX_MINE to MineFragment()
//    )

    override fun initConfig() {
        super.initConfig()
    }

    override fun initView() {
        super.initView()
        mBinding.apply {
            vp2Main.adapter = MainViewPagerAdapter(this@MainActivity,fragments)

            BnvVp2Mediator(bnvMain,vp2Main) { bnv,vp2 ->
                vp2Main.isUserInputEnabled = false
            }.attach()

        }
    }

    override fun initData() {
        super.initData()
    }

    companion object {
        const val INDEX_HOME = 0 //首页home对应的索引
        const val INDEX_CANTEEN = 1 //餐厅canteen对应的索引
        const val INDEX_ORDER = 2 //订单order对应的索引
        const val INDEX_MINE = 3 //我的mine对应的索引
    }

}

/**
 *
 */
class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val fragments:Map<Int,ReFragment>
): FragmentStateAdapter(fragmentActivity){

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
       return fragments[position]?.invoke() ?: error("请确保fragment数据源和viewpager2的index匹配")
        //不需要实例化
        //return fragments[position] ?: error("请确保fragment数据源和viewpager2的index匹配")
    }
}

//类型别名定义
typealias ReFragment = () -> Fragment