package com.omeryildizce.bottombar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.omeryildizce.bottombar.ui.theme.BottomBarTheme

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
                    AnaSayfa()
                }
            }
        }
    }
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
        AnaSayfa()
    }
}