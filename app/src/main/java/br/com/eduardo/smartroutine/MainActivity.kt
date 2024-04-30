package br.com.eduardo.smartroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.eduardo.smartroutine.screens.Home
import br.com.eduardo.smartroutine.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme (
                useDarkTheme = true
            ){
                NavHost(
                    navController = navController,
                    startDestination = "Home"
                ){
                    composable("Home"){
                        Home()
                    }
                }
            }
        }
    }
}