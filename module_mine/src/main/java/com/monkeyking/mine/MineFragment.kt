package com.monkeyking.mine

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.monkeyking.common.base.BaseFragment
import com.monkeyking.mine.databinding.FragmentMineBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MineFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_mine
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentMineBinding.bind(view)
    }
}