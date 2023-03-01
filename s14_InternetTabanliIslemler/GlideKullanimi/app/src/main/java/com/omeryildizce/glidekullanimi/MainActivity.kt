package com.omeryildizce.glidekullanimi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.omeryildizce.glidekullanimi.ui.theme.GlideKullanimiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlideKullanimiTheme {
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Sayfa() {
    val url = "https://images.pexels.com/photos/13147620/pexels-photo-13147620.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(model = url, contentDescription = "", modifier = Modifier.size(256.dp, 256.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text ="Resim 1" )
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text ="Resim 2" )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GlideKullanimiTheme {
        Sayfa()
    }
}