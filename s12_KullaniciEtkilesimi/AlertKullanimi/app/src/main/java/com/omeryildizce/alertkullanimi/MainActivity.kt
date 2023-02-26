package com.omeryildizce.alertkullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omeryildizce.alertkullanimi.ui.theme.AlertKullanimiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlertKullanimiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}

@Composable
fun Sayfa() {
    val acilisKontrolVarsayilan = remember {
        mutableStateOf(false)
    }
    val acilisKontrolOzel = remember {
        mutableStateOf(false)
    }
    val tf = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            acilisKontrolVarsayilan.value = true
        }) {
            Text(text = "Varsayılan")
        }

        if (acilisKontrolVarsayilan.value) {
            AlertDialog(
                onDismissRequest = {
                    acilisKontrolVarsayilan.value = false
                },
                title = {
                    Text(text = "Başlık")

                },
                text = { Text(text = "Mesaj") },
                confirmButton = {
                    Text(
                        text = "Tamam",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            acilisKontrolVarsayilan.value = false
                        })
                },
                dismissButton = {
                    Text(
                        text = "İptal",
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            acilisKontrolVarsayilan.value = false
                        })
                }
            )


        }
        Button(onClick = {
            acilisKontrolOzel.value = true
        }) {
            Text(text = "Özel")
        }
        if (acilisKontrolOzel.value) {
            AlertDialog(
                onDismissRequest = {
                    acilisKontrolOzel.value = false
                },
                title = {
                    Text(text = "Başlık", color = Color.White)

                },
                text = {
                    TextField(value = tf.value,
                        onValueChange = { tf.value = it },
                        label = {
                            Text(
                                text = "Veri",
                                color = Color.White
                            )
                        } )
                },
                confirmButton = {
                    Text(
                        text = "Tamam",
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp).clickable {
                            acilisKontrolOzel.value = false
                            tf.value = ""
                        })
                },
                dismissButton = {
                    Text(
                        text = "İptal",
                        color = Color.Yellow,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp).clickable {
                            acilisKontrolOzel.value = false
                            tf.value = ""
                        })
                },
                backgroundColor = Color.Magenta
            )


        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AlertKullanimiTheme {
        Sayfa()
    }
}