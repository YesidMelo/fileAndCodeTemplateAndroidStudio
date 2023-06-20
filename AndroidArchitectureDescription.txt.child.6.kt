package ${PACKAGE_NAME}.ui.navigation

//file name: ui/navigation/NavigationHandler

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ${PACKAGE_NAME}.ui.views.loginView.LoginView
import ${PACKAGE_NAME}.ui.views.splashView.SplashView

@Composable
fun NavigationHandler(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RoutesNav.SPLASH.getRoute()) {
        composable(route = RoutesNav.LOGIN.getRoute()){ LoginView(navigateToHome = {}) }

        composable(route = RoutesNav.SPLASH.getRoute()){ SplashView(navigateToLogin = {
            navController.navigate(RoutesNav.LOGIN.getRoute())
        })}
    }
}