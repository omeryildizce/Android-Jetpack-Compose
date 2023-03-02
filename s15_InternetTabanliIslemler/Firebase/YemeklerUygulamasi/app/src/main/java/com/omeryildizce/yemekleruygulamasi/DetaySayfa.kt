package com.omeryildizce.yemekleruygulamasi

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.omeryildizce.yemekleruygulamasi.entity.Yemekler

@OptIn(ExperimentalGlideComposeApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetaySayfa(yemek: Yemekler) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = yemek.yemek_adi!!) },
                backgroundColor = colorResource(id = R.color.ana_renk),
                contentColor = colorResource(id = R.color.white)
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GlideImage(model = "http://10.0.2.2/yemekler/resimler/${yemek.yemek_resim_adi}", contentDescription = "${yemek.yemek_resim_adi}" , modifier = Modifier.size(250.dp))

                Text(text = "${yemek.yemek_fiyat} ₺", color = Color.Magenta, fontSize = 50.sp)
                Button(
                    onClick = {

                    },
                    modifier = Modifier.size(250.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.ana_renk),
                        contentColor = Color.White
                    )
                    ) {
                    Text(text = "Sipariş Ver")
                }

            }
        }
    )
}