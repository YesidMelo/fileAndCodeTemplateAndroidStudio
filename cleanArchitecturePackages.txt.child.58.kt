package ${PACKAGE_NAME}.di.ui.builders.activities

import ${PACKAGE_NAME}.logic.componentsUI.mainComponent.MainComponentUI
import ${PACKAGE_NAME}.ui.activities.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityViewModelModule {

    @Provides
    fun providesMainViewModel(mainComponentUI: MainComponentUI) = MainViewModel(mainComponentUI = mainComponentUI)
}