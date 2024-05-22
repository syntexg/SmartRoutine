package br.com.eduardo.smartroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.eduardo.smartroutine.screens.CreateTask
import br.com.eduardo.smartroutine.screens.Home
import br.com.eduardo.smartroutine.ui.theme.AppTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppTheme (){
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = "Home"
                    ){
                        composable("Home"){
                            Home(navController)
                        }
                        composable("create_task") {
                            CreateTask(navController)
                        }
                    }
                }

            }

        }
    }
}