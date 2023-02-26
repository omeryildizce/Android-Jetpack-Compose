package com.omeryildizce.snackbarkullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omeryildizce.snackbarkullanimi.ui.theme.SnackbarKullanimiTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbarKullanimiTheme {
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
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = {
            SnackbarHost(hostState = it) {
                Snackbar(
                    backgroundColor = Color.White,
                    contentColor = Color.Blue,
                    actionColor = Color.Red,
                    snackbarData = it
                )
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(message = "Merhaba")
                    }
                }) {
                    Text(text = "Varsayılan")
                }
                Button(onClick = {
                    scope.launch {

                        val sb = scaffoldState.snackbarHostState.showSnackbar(
                            message = "Silmek ister misin?",
                            actionLabel = "Evet"
                        )
                        if (sb == SnackbarResult.ActionPerformed) {
                            scaffoldState.snackbarHostState.showSnackbar("Silindi")
                        }
                    }
                }) {
                    Text(text = "Snackbar Action")
                }
                Button(onClick = {
                    scope.launch {
                        val sb = scaffoldState.snackbarHostState.showSnackbar(
                            message = "İnternet bağlantısı yok!",
                            actionLabel = "Tekrar dene"
                        )
                        if (sb == SnackbarResult.ActionPerformed) {
                            scaffoldState.snackbarHostState.showSnackbar("Tekrar denendi")
                        }
                    }
                }) {
                    Text(text = "Snackbar Özel")
                }
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SnackbarKullanimiTheme {
        Sayfa()
    }
}