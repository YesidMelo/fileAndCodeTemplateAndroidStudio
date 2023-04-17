package ${PACKAGE_NAME}.di.ui.builders.dialog

import ${PACKAGE_NAME}.ui.dialogs.InformativeDialog
import ${PACKAGE_NAME}.ui.dialogs.LoadingDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogBuilder {
    
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeInformativeDialog(): InformativeDialog
    
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeLoadingDialog() : LoadingDialog
}