package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val items = listOf(
                Screen.Main,
                Screen.Second
            )
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(modifier = Modifier.fillMaxSize(),bottomBar =  {
                    BottomNavigation{
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        items.forEach{ screen ->
                            BottomNavigationItem(
                                icon = {Icon(Icons.Filled.Phone, contentDescription = null)},
                                label = {Text(text = stringResource(id = screen.resourceId))},
                                selected = currentDestination?.hierarchy?.any {it.route == screen.route}== true,
                                onClick ={
                                    navController.navigate(screen.route){
                                        popUpTo(navController.graph.findStartDestination().id){
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            )



                        }
                    }

                     }){
                    NavHost(navController = navController, startDestination = Screen.Main.route ){
                        composable(Screen.Main.route){Main()}
                        composable(Screen.Second.route){Second()}
                }

                }
            }
        }
    }
    }


