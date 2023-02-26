package com.omeryildizce.kisileruygulamasi

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.omeryildizce.kisileruygulamasi.entity.Kisiler


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun KisiDetaySayfa(gelenKisi:Kisiler) {
    val tfKisi = remember {
        mutableStateOf("")
    }
    val tfKisiTel = remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    LaunchedEffect(key1 = true){
        tfKisi.value = gelenKisi.kisi_ad
        tfKisiTel.value = gelenKisi.kisi_tel
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Kişi Detay")
            })
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = tfKisi.value, onValueChange = { tfKisi.value = it }, label = {
                    Text(
                        text = "Kişi Adı"
                    )
                })
                TextField(value = tfKisiTel.value, onValueChange = { tfKisiTel.value = it }, label = {
                    Text(text = "Kişi Telefon")
                })
                Button(onClick = {
                    val kisi_ad = tfKisi.value
                    val kisi_tel = tfKisiTel.value
                    localFocusManager.clearFocus()
                },
                    modifier = Modifier.size(250.dp, 50.dp)
                ) {
                    Text(text = "Güncelle")
                }
            }
        }

    )
}
