package com.omeryildizce.sayitahminuygulamasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SonucEkrani(sonuc: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (sonuc){
            Text(text = "Kazandınız", fontSize = 36.sp, color = Color.Green)
            Image(
                painter = painterResource(id = R.drawable.mutlu_resim),
                contentDescription = "zar resmi",
                colorFilter = ColorFilter.tint(Color.Green)
            )
        }
        else{
            Text(text = "Kaybettiniz", fontSize = 36.sp, color = Color.Red)
            Image(
                painter = painterResource(id = R.drawable.uzgun_resim),
                contentDescription = "zar resmi",
                colorFilter = ColorFilter.tint(Color.Red)
            )
        }

    }
}
