package ${PACKAGE_NAME}.application

import ${PACKAGE_NAME}.di.DaggerAplicacionComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CustomApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAplicacionComponent.builder().create(this)

    //region estatico

    companion object {
        private var instance : CustomApplication? = null
        fun getInstance() = instance
    }

    //endregion
}