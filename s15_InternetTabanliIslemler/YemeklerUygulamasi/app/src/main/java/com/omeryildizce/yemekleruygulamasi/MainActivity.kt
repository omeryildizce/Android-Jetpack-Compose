package com.omeryildizce.yemekleruygulamasi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.gson.Gson
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler
import com.omeryildizce.yemekleruygulamasi.ui.theme.YemeklerUygulamasiTheme
import com.omeryildizce.yemekleruygulamasi.viewmodel.AnasayfaViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YemeklerUygulamasiTheme {
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
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa" ){
        composable("anasayfa"){
            AnaSayfa(navController = navController)
        }
        composable("detay_sayfa/{yemek}", arguments = listOf(
            navArgument("yemek"){type = NavType.StringType}
        )){
            val json = it.arguments?.getString("yemek")
            val yemek = Gson().fromJson(json, Yemekler::class.java)
            DetaySayfa(yemek = yemek)
        }
    }
}
@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AnaSayfa(navController: NavController) {
    val viewModel:AnasayfaViewModel = viewModel()
    val yemekListesi = viewModel.yemeklerListesi.observeAsState(listOf())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Yemekler") },
                backgroundColor = colorResource(id = R.color.ana_renk),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = {
            LazyColumn {
                items(
                    count = yemekListesi.value.count(),
                    itemContent = {
                        val yemek = yemekListesi.value[it]
                        Card(
                            modifier = Modifier
                                .padding(all = 5.dp)
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.clickable {
                                val yemekJson = Gson().toJson(yemek)
                                navController.navigate("detay_sayfa/$yemekJson")
                            }) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth()
                                ) {
                                    GlideImage(  model = "http://10.0.2.2/yemekler/resimler/${yemek.yemekResimAdi}.png",contentDescription = "", modifier = Modifier.size(100.dp))
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Text(text = yemek.yemekAdi, fontSize = 20.sp)
                                            Spacer(modifier = Modifier.size(30.dp))
                                            Text(text = "${yemek.yemekFiyat} ₺", fontSize = 20.sp, color = Color.Magenta)
                                        }
                                        Icon(painter = painterResource(id = R.drawable.arrow_resim), contentDescription = "")
                                    }
                                }
                            }

                        }
                    }
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YemeklerUygulamasiTheme {
        SayfaGecisleri()
    }
}