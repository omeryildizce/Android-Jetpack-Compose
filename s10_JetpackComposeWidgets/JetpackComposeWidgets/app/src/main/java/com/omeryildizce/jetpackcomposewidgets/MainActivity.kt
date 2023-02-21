package com.omeryildizce.jetpackcomposewidgets

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omeryildizce.jetpackcomposewidgets.ui.theme.JetpackComposeWidgetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeWidgetsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //SayfaButtonTextField()
                    SayfaFab()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SayfaFab() {
    Scaffold(content = {

    },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    Log.e("Fab", "SayfaFab: ")
                },
                text = {
                       Text(text = "Ekle",color= Color.White)
                },
                backgroundColor = Color.Red,
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ekle_resim),
                        contentDescription = "icon",
                        tint = Color.White
                    )
                }
            )
        })
}

@Composable
fun SayfaButtonTextField() {
    val tf = remember {
        mutableStateOf("")
    }
    val tfOutline = remember {
        mutableStateOf("")
    }
    val alinanVeri = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gelen veri : ${alinanVeri.value}",
            color = Color.Magenta,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                background = Color.Cyan,

                )


        )
        TextField(
            value = tf.value,
            onValueChange = { tf.value = it },
            label = { Text(text = "Veri giriniz") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Red, unfocusedIndicatorColor = Color.Magenta,
                textColor = Color.Magenta,
                focusedLabelColor = Color.Red
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

        )
        Button(
            onClick = {
                alinanVeri.value = tf.value
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Brush.linearGradient(listOf(Color.Blue, Color.Cyan))),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Veriyi Al")

        }

        OutlinedTextField(
            value = tfOutline.value,
            onValueChange = { tfOutline.value = it },
            label = { Text(text = "Veri giriniz") }
        )

        OutlinedButton(
            onClick = {
                alinanVeri.value = tfOutline.value
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
            border = BorderStroke(1.dp, Brush.linearGradient(listOf(Color.Blue, Color.Cyan))),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Veriyi Al")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeWidgetsTheme {
        //SayfaButtonTextField()
        SayfaFab()
    }
}
