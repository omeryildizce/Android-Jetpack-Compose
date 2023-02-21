package com.omeryildizce.jetpackcomposecalismayapisi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SayfaA(navController: NavController, gelenNesne:Kisiler) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "SayfaA", fontSize = 50.sp)
        Text(text = gelenNesne.isim)
        Text(text = gelenNesne.yas.toString())
        Text(text = gelenNesne.boy.toString())
        Text(text = gelenNesne.bekarMi.toString())
        Button(onClick = {
            navController.navigate("sayfa_b"){
                popUpTo("sayfa_a"){inclusive = true}
            }
        }) {
            Text(text = "Sayfa B'ye Git ")
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "AnaSayfa")
        }
    }
}