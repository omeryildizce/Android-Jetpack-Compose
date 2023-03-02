package com.omeryildizce.kisileruygulamasi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.omeryildizce.kisileruygulamasi.entity.Kisiler
import com.omeryildizce.kisileruygulamasi.ui.theme.KisilerUygulamasiTheme
import com.omeryildizce.kisileruygulamasi.viewmodel.AnasayfaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KisilerUygulamasiTheme {
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

@Composable
fun SayfaGecisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa")
        {
            AnaSayfa(navController = navController)
        }
        composable("kisi_kayit_sayfa"){
            KisiKayitSayfa()
        }
        composable("kisi_detay_sayfa/{kisi}", arguments = listOf(
            navArgument("kisi"){
                type = NavType.StringType
            }
        )){
            val json = it.arguments?.getString("kisi")
            val nesne = Gson().fromJson(json, Kisiler::class.java)

            KisiDetaySayfa(gelenKisi =  nesne)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnaSayfa(navController: NavController) {
    val aramaYapiliyorMu = remember {
        mutableStateOf(false)
    }
    val tf = remember {
        mutableStateOf("")
    }
    val viewModel: AnasayfaViewModel = viewModel()
    val kisilerListesi = viewModel.kisilerListesi.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(title = {
                if (aramaYapiliyorMu.value) {
                    TextField(

                        value = tf.value, onValueChange = {
                            tf.value = it
                            viewModel.ara(it)

                        },
                        label = {
                            Text(
                                text = "Ara"
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedLabelColor = Color.White,
                            focusedIndicatorColor = Color.White,
                            unfocusedLabelColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        )
                    )
                } else {
                    Text(text = "Kişiler")

                }
            }, actions = {

                if (aramaYapiliyorMu.value) {
                    IconButton(
                        onClick = {
                            aramaYapiliyorMu.value = false
                            tf.value = ""
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.kapat_resim),
                            contentDescription = ""
                        )
                    }
                } else {
                    IconButton(
                        onClick = {
                            aramaYapiliyorMu.value = true

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arama_resim),
                            contentDescription = ""
                        )
                    }
                }
            }
            )
        },
        content = {
            LazyColumn(content = {
                items(
                    count = kisilerListesi.value.count(),
                    itemContent = {
                        val kisi = kisilerListesi.value.get(it)
                        Card(modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .clickable {
                                val kisiJson = Gson().toJson(kisi)
                                navController.navigate("kisi_detay_sayfa/$kisiJson")
                            }) {
                            Row(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "${kisi.kisi_ad} - ${kisi.kisi_tel}")

                                IconButton(onClick = {
                                   viewModel.sil(kisi.kisi_id!!)
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.sil_resim),
                                        contentDescription = "",
                                        tint = Color.Gray
                                    )
                                }
                            }
                        }
                    }
                )
            })
        }, floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("kisi_kayit_sayfa")
            },
                backgroundColor = colorResource(id = R.color.teal_200),
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ekle_resim),
                        contentDescription = "",
                        tint = Color.White
                    )
                })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KisilerUygulamasiTheme {
        SayfaGecisleri()
    }
}