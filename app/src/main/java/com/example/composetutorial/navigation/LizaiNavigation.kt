package com.example.composetutorial.navigation

sealed class LizaiNavigation(protected val route: String) {

    object HomeRoute : NoArgumentsDestination("Home")
    object AccountRoute : NoArgumentsDestination("AccountSreen")
    object Account2Route : NoArgumentsDestination("AccountSreen2")
    object Account3Route : NoArgumentsDestination("AccountSreen3")


    sealed class NoArgumentsDestination(route: String) : LizaiNavigation(route) {
        operator fun invoke(): String = route
    }

}

internal fun setArgument(route: String, vararg params: Any): String {
    val builder = StringBuilder(route)
    params.forEach {
        builder.append("/$it")
    }
    return builder.toString()
}

internal fun setOptionArgument(route: String, nameParam: String, params: Any): String {
    return "$route?$nameParam=$params"
}