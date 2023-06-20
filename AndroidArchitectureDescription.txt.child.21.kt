package ${PACKAGE_NAME}.di.ui

//file name: di/ui/ViewModels

import ${PACKAGE_NAME}.ui.views.loginView.LoginViewModel
import ${PACKAGE_NAME}.ui.views.splashView.SplashViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ViewModels {

    @Provides
    fun provideLoginViewModel() = LoginViewModel()

    @Provides
    fun provideSplashViewModel() = SplashViewModel()
}