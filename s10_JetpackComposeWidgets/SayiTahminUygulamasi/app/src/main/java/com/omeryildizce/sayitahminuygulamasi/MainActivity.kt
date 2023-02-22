package com.omeryildizce.sayitahminuygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.omeryildizce.sayitahminuygulamasi.ui.theme.SayiTahminUygulamasiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayiTahminUygulamasiTheme {
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

@Composable
fun AnaSayfa() {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SayiTahminUygulamasiTheme {
        AnaSayfa()
    }
}