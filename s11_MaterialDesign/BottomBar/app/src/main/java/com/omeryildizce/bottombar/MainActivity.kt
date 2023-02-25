package com.omeryildizce.bottombar

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omeryildizce.bottombar.ui.theme.BottomBarTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnaSayfaDrawer()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnaSayfaDrawer() {
    val secilenItem = remember {
        mutableStateOf(0)
    }
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(title = { Text(text = "Başlık") }, navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.menu_icon),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        scope.launch { scaffoldState.drawerState.open() }
                    }
                )
            })
        },
        content = {
            if (secilenItem.value == 0) {
                SayfaBir()
            }
            if (secilenItem.value == 1) {
                SayfaIki()
            }
        },
        drawerContent = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .background(colorResource(id = R.color.purple_500))) {
                Text(text = "Merhaba", fontSize = 36.sp, color = Color.Yellow)
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 0
                scope.launch { scaffoldState.drawerState.close() }
            }) {
                Text(text = "Sayfa Bir")
            }
            DropdownMenuItem(onClick = {
                secilenItem.value = 1
                scope.launch { scaffoldState.drawerState.close() }
            }) {
                Text(text = "Sayfa İki")
            }
        }
    )
    val activity = LocalContext.current as Activity
    BackHandler(onBack = {
        if (scaffoldState.drawerState.isOpen){
            scope.launch { scaffoldState.drawerState.close() }
        }else{
            activity.finish()
        }
    })
        

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnaSayfa() {
    val secilenItem = remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Başlık") })
        },
        content = {
            if (secilenItem.value == 0) {
                SayfaBir()
            }
            if (secilenItem.value == 1) {
                SayfaIki()
            }
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color.White,
                content = {
                    BottomNavigation(backgroundColor = Color.White) {
                        BottomNavigationItem(
                            selected = secilenItem.value == 0,
                            onClick = {
                                secilenItem.value = 0
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.resim1),
                                    contentDescription = ""
                                )
                            },
                            label = {
                                Text(text = "Bir")
                            },
                            selectedContentColor = Color.Magenta,
                            unselectedContentColor = Color.Gray
                        )
                        BottomNavigationItem(
                            selected = secilenItem.value == 1,
                            onClick = {
                                secilenItem.value = 1
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.resim2),
                                    contentDescription = ""
                                )
                            },
                            label = {
                                Text(text = "İki")
                            },
                            selectedContentColor = Color.Magenta,
                            unselectedContentColor = Color.Gray
                        )
                    }
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BottomBarTheme {
        AnaSayfaDrawer()
    }
}