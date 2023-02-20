package com.omeryildizce.loginuygulama

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omeryildizce.loginuygulama.ui.theme.LoginUygulamaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUygulamaTheme {
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
    Surface(color = MaterialTheme.colors.primary) {
        val tfKullaniciAdi = remember {
            mutableStateOf("")
        }
        val tfSifre = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.house),
                contentDescription = "logo",
                modifier = Modifier
                    .size(100.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            TextField(
                value = tfKullaniciAdi.value,
                onValueChange = { tfKullaniciAdi.value = it },
                label = {
                    Text(
                        text = "Kullanıcı Adı"
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black,
                    focusedIndicatorColor = Color.Red
                )
            )
            TextField(
                value = tfSifre.value, onValueChange = { tfSifre.value = it },
                label = {
                    Text(text = "Şifre")
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    textColor = Color.Black, focusedIndicatorColor = Color.Red
                )

            )
            Button(onClick = { Log.e("Button", "Sayfa: Giriş Yapıldı") },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red,
                    contentColor = Color.White

                ),
            modifier = Modifier.size(250.dp, 50.dp)) {
                Text(text = "Giriş Yap")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginUygulamaTheme {
        Sayfa()
    }
}