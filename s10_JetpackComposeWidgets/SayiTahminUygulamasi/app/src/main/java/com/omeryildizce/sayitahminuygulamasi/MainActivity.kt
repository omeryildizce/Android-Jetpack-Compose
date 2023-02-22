package com.omeryildizce.sayitahminuygulamasi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        composable("anasayfa") {
            AnaSayfa(navController = navController)
        }
        composable("tahmin_ekrani") {
            TahminEkrani(navController = navController)
        }
        composable("sonuc_ekrani/{sonuc}", arguments = listOf(
            navArgument("sonuc"){type = NavType.BoolType}
        )) {
            val sonuc = it.arguments?.getBoolean("sonuc") ?: false
            SonucEkrani(sonuc = sonuc)
        }
    }
}

@Composable
fun AnaSayfa(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tahmin Oyunu", fontSize = 36.sp)
        Image(
            painter = painterResource(id = R.drawable.zar_resim),
            contentDescription = "zar resmi"
        )
        Button(
            onClick = {
                navController.navigate("tahmin_ekrani")
            },
            modifier = Modifier.size(250.dp, 50.dp)
        ) {
            Text(text = "Oyuna Başla")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SayiTahminUygulamasiTheme {
        SayfaGecisleri()
    }
}