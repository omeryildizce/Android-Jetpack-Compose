package com.omeryildizce.jetpackcomposewidgets

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import com.omeryildizce.jetpackcomposewidgets.ui.theme.JetpackComposeWidgetsTheme
import kotlin.math.min

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
                    SayfaDropDownMenu()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeWidgetsTheme {
        //SayfaButtonTextField()
        SayfaDropDownMenu()
    }
}

@Composable
fun SayfaDropDownMenu() {
    val indeks = remember {
        mutableStateOf(0)
    }
    val menu = remember {
        mutableStateOf(false)
    }
    val ulkeListe = listOf<String>(
        "Türkiye",
        "Almanya",
        "İngiltere",
        "İspanya",
        "İtalya",
        "Portekiz",
        "Hollanda",
        "Çin",
        "Japonya",

        )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .size(100.dp, 50.dp)
                    .clickable {
                        menu.value = true
                    }
            ) {
                Text(text = ""+ ulkeListe.get(indeks.value))
                Image(
                    painter = painterResource(id = R.drawable.drop_down_menu_resim),
                    contentDescription ="resim"
                )
            }
            DropdownMenu(expanded = menu.value,
                onDismissRequest = { menu.value = false }) {
                ulkeListe.forEachIndexed { index, ulke ->
                    DropdownMenuItem(onClick = {
                        Log.e("Menu", "SayfaDropDownMenu: $ulke")
                        menu.value = false
                        indeks.value = index
                    }) {
                        Text(text = "$ulke")
                    }
                }

            }

        }
        Button(onClick = {
            Log.e("Ülke", "SayfaDropDownMenu: " + ulkeListe.get(indeks.value) )
        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaImage() {

    Column {
        val activity = LocalContext.current as Activity
        Image(
            bitmap = ImageBitmap.imageResource(
                id =
                activity.resources.getIdentifier("yemek", "drawable", activity.packageName)
            ), contentDescription = "resim"
        )
        Image(
            painter = painterResource(id = R.drawable.resim),
            contentDescription = "resim"
        )

    }
}


@SuppressLint("SetJavaScriptEnabled")
@Composable
fun SayfaWebView() {
    val url = "https://bing.com"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}

@Composable
fun SayfaProgressSlider() {
    val progressDurum = remember {
        mutableStateOf(false)
    }
    val sliderDeger = remember {
        mutableStateOf(0f)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (progressDurum.value) {
            CircularProgressIndicator(color = Color.Magenta)
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                progressDurum.value = true
            }) {
                Text(text = "Başla")
            }
            Button(onClick = {
                progressDurum.value = false
            }) {
                Text(text = "Dur")

            }

        }
        Text(text = "Sonuç: ${sliderDeger.value.toInt()}")
        Slider(
            value = sliderDeger.value,
            onValueChange = {
                sliderDeger.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            valueRange = 0f..100f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Magenta,
                activeTrackColor = Color.Red,
                disabledActiveTrackColor = Color.DarkGray
            )


        )
        Button(onClick = {

        }) {
            Text(text = "Göster")

        }
    }
}

@Composable
fun SayfaRadioButton() {
    val secilenIndex = remember {
        mutableStateOf(0)
    }
    val takimListesi = listOf("Real Madrid", "Barcelona")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            takimListesi.forEachIndexed { indeks, takim ->
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        secilenIndex.value = indeks
                    }) {
                    RadioButton(selected = (
                            takim == takimListesi.get(secilenIndex.value)
                            ), onClick = {
                        secilenIndex.value = indeks
                    }
                    )
                    Text(text = takim)
                }
            }
        }
        Button(onClick = {
            Log.e("Takım", "" + takimListesi[secilenIndex.value])
        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaTiklanma() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Red,
                            Color.Magenta
                        )
                    )
                )
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            Log.e("Tıklama", "SayfaTiklanma: Tek Tıklama")
                        },
                        onDoubleTap = {
                            Log.e("Tıklama", "SayfaTiklanma: Çift Tıklama")

                        },
                        onLongPress = {
                            Log.e("Tıklama", "SayfaTiklanma: Uzun Tıklama")

                        }
                    )
                }
        )
    }
}

@Composable
fun SayfaCheckbox() {
    val checkBoxDurum = remember {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Checkbox(
                checked = checkBoxDurum.value, onCheckedChange = {
                    checkBoxDurum.value = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red
                )
            )
            Text(text = "Jetpack compose", modifier = Modifier.padding(start = 10.dp, top = 10.dp))
        }

        Button(onClick = {

        }) {
            Text(text = "Göster")
        }
    }
}

@Composable
fun SayfaSwitch() {
    val switchDurum = remember {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Switch(
            checked = switchDurum.value,
            onCheckedChange = {
                switchDurum.value = it
            },

            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Red,
                checkedThumbColor = Color.Magenta,
                uncheckedTrackColor = Color.Yellow,
                uncheckedThumbColor = Color.Green
            )
        )

        Button(onClick = {

        }) {
            Text(text = "Göster")
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
                    Text(text = "Ekle", color = Color.White)
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

