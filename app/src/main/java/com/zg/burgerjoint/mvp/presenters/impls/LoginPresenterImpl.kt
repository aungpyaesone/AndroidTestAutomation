package com.zg.burgerjoint.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.zg.burgerjoint.mvp.presenters.LoginPresenter
import com.zg.burgerjoint.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter,BaseAppPresenterImpl<LoginView>() {
    override fun onTapLogin(userName: String, password: String) {
        if(userName.isNotEmpty() || password.isNotEmpty()){
            mView.navigateToMainScreen()
        } else {
            mView.showErrorMessage("Username and Password should not be empty")
        }
    }

    override fun onUIReady(owner: LifecycleOwner) {

    }
}