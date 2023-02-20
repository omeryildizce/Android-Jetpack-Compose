package com.omeryildizce.yemektarifi

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omeryildizce.yemektarifi.ui.theme.YemekTarifiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YemekTarifiTheme {
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Sayfa() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Yazi(icerik = "Yemek Tarifi") },
                backgroundColor = colorResource(id = R.color.ana_renk),
                contentColor = colorResource(id = R.color.white)
            )
        }, content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yemek),
                    contentDescription = "Yemek Resmi",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(50f),
                    contentScale = ContentScale.FillBounds
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { Log.e("Button", "Beğenildi") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.ana_renk),
                            contentColor = colorResource(id = R.color.white),

                            ),
                        modifier = Modifier
                            .weight(50f)
                            .padding(horizontal = 5.dp)
                    ) {
                        Yazi(icerik = "Beğen")
                    }
                    Button(
                        onClick = { Log.e("Button", "Beğenildi") },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = colorResource(id = R.color.alternatif_renk),
                            contentColor = colorResource(id = R.color.white),

                            ),
                        modifier = Modifier
                            .weight(50f)
                            .padding(horizontal = 5.dp)
                    ) {
                        Yazi(icerik = "Yorum Yap")
                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 5.dp)
                ) {
                    Text(
                        text = "Köfte",
                        color = colorResource(id = R.color.alternatif_renk),
                        fontSize = 18.sp,

                        )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Yazi(icerik = "Izgaraya Uygun")
                        Yazi(icerik = "7 Haziran")
                    }
                }
                Text(
                    modifier = Modifier
                        .weight(50f)
                        .padding(all = 10.dp),
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum",
                    textAlign = TextAlign.Justify
                )
            }

        }
    )
}

@Composable
fun Yazi(icerik: String) {
    Text(text = icerik)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YemekTarifiTheme {
        Sayfa()
    }
}