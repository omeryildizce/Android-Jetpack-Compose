package com.omeryildizce.materialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.omeryildizce.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SayfaGecisleri()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialDesignTheme {
        SayfaGecisleri()
    }

}
@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "sayfa"){
        composable("sayfa"){
            SayfaDinamikListeleme(navController = navController)
        }
        composable("detay_sayfa/{ulke}", arguments = listOf(
            navArgument("ulke"){
                type = NavType.StringType
            }
        )){
            val ulke = it.arguments?.getString("ulke")
            DetaySayfa(ulkeAdi = ulke ?: "Türkiye")
        }
    }
}

@Composable
fun SayfaDinamikListeleme(navController: NavController) {
    val ulkeListesi = remember {
        mutableStateListOf(
            "Türkiye",
            "Almanya",
            "Bolivya",
            "Cezayir",
            "Çad",
            "Danimarka",
            "Estonya",
            "Fransa",
            "Galler",
            "Hırvatistan",
            "Irak",
            "İran",
            "Japonya",
            "Kazakistan",
            "Lübnan",
            "Moritanya",
            "Nepal",
            "Orta Afrika Cumhuriyeti",
            "Özbekistan",
            "Polonya",
            "Rusya",
            "Sudan",
            "Şili",
            "Tayvan",
            "Uganda",
            "Ürdün",
            "Venezuela",
            "Yeni Zelanda",
            "Zimbabve"
        )

    }
    LazyRow {
        items(
            count = ulkeListesi.count(),
            itemContent = {
                val ulke = ulkeListesi[it]
                Card(
                    modifier = Modifier
                        .padding(all = 5.dp)
                ) {
                    Row(modifier = Modifier.clickable {
                        navController.navigate("detay_sayfa/$ulke")
                    }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(all = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = ulke, modifier = Modifier
                                .padding(all = 5.dp)
                                .clickable {

                                })
                            OutlinedButton(onClick = {

                            }) {
                                Text(text = "Ülke Seç")
                            }
                        }
                    }
                }
            }
        )
    }
}

@Composable
fun SayfaSabitListeleme() {
    LazyRow {
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(100.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {

                    }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gunes_resim_24),
                            contentDescription = "gunes"
                        )
                        Text(text = "Güneş", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(all = 5.dp)
                    .size(100.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {

                    }) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(all = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ay_resim_24),
                            contentDescription = "ay"
                        )
                        Text(text = "Ay", modifier = Modifier.padding(all = 5.dp))
                    }
                }
            }
        }

    }
}

@Composable
fun SayfaCard() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Card(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
            elevation = 10.dp,
            backgroundColor = Color.Magenta,
            shape = RoundedCornerShape(corner = CornerSize(16.dp)),
            border = BorderStroke(2.dp, Color.Blue)
        ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.clickable { }) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(all = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gunes_resim),
                        contentDescription = "Güneş Resmi"
                    )
                    Text(text = "Güneş", color = Color.White, fontSize = 36.sp)
                }
            }
        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SayfaTopAppBarArama() {
    val aramaYapiliyorMu = remember {
        mutableStateOf(false)
    }
    val tf = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (aramaYapiliyorMu.value) {
                        TextField(
                            value = tf.value,
                            onValueChange = {
                                tf.value = it
                            },
                            label = { Text(text = "Ara") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                    } else {
                        Text(text = "Başlık")
                    }
                },
                actions = {
                    if (aramaYapiliyorMu.value) {
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = false
                            tf.value = ""
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.kapat_resim),
                                contentDescription = "info"
                            )

                        }
                    } else {
                        IconButton(onClick = {
                            aramaYapiliyorMu.value = true

                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arama_resim),
                                contentDescription = "info"
                            )

                        }
                    }
                }
            )

        },
        content = {

        }
    )


}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SayfaTopAppBar() {
    val menuAcilis = remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = "Başlık")
                        Text(text = "Alt Başlık", fontSize = 12.sp)
                    }
                },
                backgroundColor = colorResource(id = R.color.anarenk),
                contentColor = colorResource(id = R.color.white),
                actions = {
                    Text(text = "Topbar", modifier = Modifier.clickable {
                        Log.e("Çıkış", "SayfaTopAppBar: Çıkış")
                    })
                    IconButton(onClick = {
                        Log.e("Topbar", "SayfaTopAppBar: Info")
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.info_resim),
                            contentDescription = "info"
                        )
                    }
                    IconButton(onClick = {
                        menuAcilis.value = true
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.more_resim),
                            contentDescription = "info"
                        )
                    }
                    DropdownMenu(
                        expanded = menuAcilis.value,
                        onDismissRequest = { menuAcilis.value = false }
                    ) {
                        DropdownMenuItem(onClick = { menuAcilis.value = false }) {
                            Text(text = "Sil")
                        }
                        DropdownMenuItem(onClick = { menuAcilis.value = false }) {
                            Text(text = "Güncelle")
                        }
                    }
                }

            )

        },
        content = {

        }
    )


}
