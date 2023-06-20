package ${PACKAGE_NAME}.ui.navigation

//file name: ui/navigation/RoutesNav

enum class RoutesNav constructor(private val route: String) {
    LOGIN(route = "login"),
    SPLASH(route = "splash"),
    ;
    fun getRoute() = route
}