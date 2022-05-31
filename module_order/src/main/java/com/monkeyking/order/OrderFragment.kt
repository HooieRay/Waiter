package com.monkeyking.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.monkeyking.common.base.BaseFragment
import com.monkeyking.order.databinding.FragmentOrderBinding


/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_order
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
        return FragmentOrderBinding.bind(view)
    }

}