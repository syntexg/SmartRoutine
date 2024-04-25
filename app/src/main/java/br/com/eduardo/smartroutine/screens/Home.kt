package br.com.eduardo.smartroutine.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.eduardo.smartroutine.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(){
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(stringResource(R.string.title_login_screen))
                    }

                )
            }
        ) {

        }
    }
}