package br.com.eduardo.smartroutine.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import br.com.eduardo.smartroutine.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.dp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val selectedColor = Color(android.graphics.Color.parseColor("#3D1365"))
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo_2_removebg_preview),
                            contentDescription = "SmartRoutine TopApp Logo",
                            modifier = Modifier.scale(0.8f)
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("create_task")
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Floating button icon",
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    NavigationBarItem(
                        modifier = Modifier.scale(1.3f),
                        icon = {
                            if (selectedItem == 0) {
                                Icon(
                                    Icons.Default.Home,
                                    contentDescription = "Home",
                                    tint = selectedColor
                                )
                            } else {
                                Icon(Icons.Default.Home, contentDescription = "Home")
                            }
                        },
                        label = {
                            if (selectedItem == 0) {
                                Text("Home", color = selectedColor)
                            } else {
                                Text("Home")
                            }
                        },
                        selected = selectedItem == 0,
                        onClick = { selectedItem = 0 }
                    )
                    NavigationBarItem(
                        modifier = Modifier.scale(1.3f),
                        icon = {
                            if (selectedItem == 1) {
                                Icon(
                                    Icons.Default.Done,
                                    contentDescription = "Done",
                                    tint = selectedColor
                                )
                            } else {
                                Icon(Icons.Default.Done, contentDescription = "Profile")
                            }
                        },
                        label = {
                            if (selectedItem == 1) {
                                Text("Done", color = selectedColor)
                            } else {
                                Text("Done")
                            }
                        },
                        selected = selectedItem == 1,
                        onClick = { selectedItem = 1 }
                    )
                    NavigationBarItem(
                        modifier = Modifier.scale(1.3f),
                        icon = {
                            if (selectedItem == 2) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Trash",
                                    tint = selectedColor
                                )
                            } else {
                                Icon(Icons.Default.Delete, contentDescription = "Delete")
                            }
                        },
                        label = {
                            if (selectedItem == 2) {
                                Text("Delete", color = selectedColor)
                            } else {
                                Text("Delete")
                            }
                        },
                        selected = selectedItem == 2,
                        onClick = { selectedItem = 2 }
                    ) }
            }
        }
    ) { paddingValues ->
        Column(
            Modifier.fillMaxSize().padding(
                vertical = paddingValues.calculateTopPadding(),
                horizontal = 16.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}