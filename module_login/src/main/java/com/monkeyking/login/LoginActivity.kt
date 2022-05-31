package com.monkeyking.login

import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monkeyking.common.base.BaseActivity
import com.monkeyking.login.databinding.ActivityLoginBinding

class LoginActivity :BaseActivity<ActivityLoginBinding>() {

    //在创建viewModel时，通用的方法是
    //viewModel = ViewModelProvider(this,MainViewModel.MainViewModelFactory()).get(MainViewModel::class.java)

    private val viewModel by viewModels<LoginViewModel> {defaultViewModelProviderFactory}

    override fun getLayoutRes() = R.layout.activity_login

    override fun initView() {
        super.initView()
        mBinding.apply {
            vm = viewModel
        }
    }

    override fun initData() {
        super.initData()
    }

    override fun initConfig() {
        super.initConfig()
    }

    private fun test(){
        //只是为了测试git branch分支

        //再试试暂存
    }

    fun test1() {
        //登录
    }
    
    fun fixBug(){
        //紧急修复bug
    }

    fun fixLogin() {
        //测试说登录提示错误
    }

    fun login(){
        //用户需求加一个验证码登录
    }
}