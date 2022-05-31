package com.monkeyking.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class LoginViewModel :ViewModel(){

    val obMobile = ObservableField<String>()
    val obPassword = ObservableField<String>()

    fun goLogin(){

    }
}