package com.example.listaimagenes

sealed class Screen(val route : String){
    object Home : Screen(route = "home_screen")
    object Second : Screen (route = "second_screen/{id}/{titulo}/{url}/{desc}/{temporadas}")

    fun pasarSerie(id: Int, titulo :String, url:String, desc:String, temporadas:Int): String {
        return "second_screen/$id/$titulo/$url/$desc/$temporadas"
    }
}

