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
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext
import br.com.eduardo.smartroutine.model.Task
import br.com.eduardo.smartroutine.repository.TaskRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTask(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val selectedColor = Color(android.graphics.Color.parseColor("#3D1365"))
    var taskName by remember { mutableStateOf("") }
    var descriptionTask by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val localContext = LocalContext.current
    val successMessage = stringResource(R.string.created_task)

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
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val task = Task(
                        id = null,
                        task = taskName,
                        description = descriptionTask
                    )
                    val repository = TaskRepository(localContext)
                    val id = repository.insert(task)
                    if (id > 0L) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = successMessage,
                                duration = SnackbarDuration.Long,
                                withDismissAction = true
                            )
                        }
                    }
                }
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Floating button icon",
                )
            }
        },
    ) { paddingValues ->
        Column(
            Modifier.fillMaxSize().padding(
                vertical = paddingValues.calculateTopPadding(),
                horizontal = 16.dp
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Task Creator",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 28.sp
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = taskName,
                onValueChange = { value ->
                    taskName = value
                },
                label = {
                    Text(stringResource(R.string.input_task_name))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = descriptionTask,
                onValueChange = { value -> descriptionTask = value },
                label = {
                    Text(stringResource(R.string.input_task_description))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}