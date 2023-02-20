package com.omeryildizce.jetcomposetasarim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omeryildizce.jetcomposetasarim.ui.theme.JetComposeTasarimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetComposeTasarimTheme {
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
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.textYazi), fontSize = 50.sp)
        Button(onClick = { }) {
            Text(text = stringResource(id = R.string.butonYazi), fontSize = 24.sp)
        }

    }

}

@Composable
fun Yazi(s: String) {
    Text(text = "Message: $s", fontSize = 50.sp)
}

@Composable
fun KirmiziKare() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
    )
}

@Composable
fun YesilKare() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
    )
}

@Composable
fun MaviKare() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
    )
}

@Preview(showBackground = true )
@Composable
fun DefaultPreview() {
    JetComposeTasarimTheme {
        Sayfa()
    }
}