package com.monkeyking.canteen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.ViewDataBinding
import com.monkeyking.canteen.databinding.FragmentCanteenBinding
import com.monkeyking.common.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [CanteenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CanteenFragment : BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_canteen
    }

    override fun bindView(view: View, savedInstanceState: Bundle?): ViewDataBinding {
       return FragmentCanteenBinding.bind(view)
    }

}