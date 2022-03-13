package com.example.myapplication

import androidx.annotation.StringRes

sealed class Screen(val route:String, @StringRes val resourceId: Int ){
    object Main : Screen ("main", R.string.Main)
    object Second : Screen ("second", R.string.Second)
}