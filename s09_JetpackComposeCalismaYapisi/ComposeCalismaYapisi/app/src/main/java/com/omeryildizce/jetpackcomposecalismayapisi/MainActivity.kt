package com.omeryildizce.jetpackcomposecalismayapisi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.omeryildizce.jetpackcomposecalismayapisi.ui.theme.JetpackComposeCalismaYapisiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCalismaYapisiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SayfaGEcisleri()
                }
            }
        }
    }
}

@Composable
fun SayfaGEcisleri() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa") {
        composable("anasayfa") {
            AnaSayfa(navController = navController)
        }
        composable(
            "sayfa_a/{nesne}",
            arguments = listOf(
                navArgument("nesne") {
                    type = NavType.StringType
                }

            )

        ) {
            val json = it.arguments?.getString("nesne")
            val nesne: Kisiler = Gson().fromJson(json, Kisiler::class.java)
            SayfaA(navController = navController, nesne)
        }
        composable("sayfa_b") {
            SayfaB()
        }
    }
}

@Composable
fun AnaSayfa(navController: NavController) {
    val sayac = remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ana Sayfa", fontSize = 50.sp)
        Button(onClick = {
            var kisiler = Kisiler("Ömer", 12, 1.45f, false)
            var nesne = Gson().toJson(kisiler)
            navController.navigate("sayfa_a/$nesne")
        }) {
            Text(text = "Sayfa A'ya Git ")
        }
        Text(text = "Sayaç : ${sayac.value}")
        Button(onClick = {
            sayac.value++

        }) {
            Text(text = "Tıkla")
        }
    }
    LaunchedEffect(key1 = true) {
        Log.e("Anasayfa", "AnaSayfa: LaunchedEffect")
    }
    SideEffect {
        Log.e("Anasayfa", "AnaSayfa: SideEffect")
    }
    DisposableEffect(Unit) {
        onDispose {
            Log.e("Anasayfa", "AnaSayfa: SideEffect")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCalismaYapisiTheme {

    }
}