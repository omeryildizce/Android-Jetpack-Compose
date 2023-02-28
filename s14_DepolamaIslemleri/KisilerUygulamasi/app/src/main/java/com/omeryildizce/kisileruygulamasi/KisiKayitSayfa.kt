package com.omeryildizce.kisileruygulamasi

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.omeryildizce.kisileruygulamasi.viewmodel.AnasayfaViewModel
import com.omeryildizce.kisileruygulamasi.viewmodel.KisiDetaySayfaViewModel
import com.omeryildizce.kisileruygulamasi.viewmodel.KisiKayitSayfaViewModel
import com.omeryildizce.kisileruygulamasi.viewmodelfactory.AnasayfaViewModelFactory
import com.omeryildizce.kisileruygulamasi.viewmodelfactory.KisiKayitSayfaViewModelFactory


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun KisiKayitSayfa() {
    val tfKisi = remember {
        mutableStateOf("")
    }
    val tfKisiTel = remember {
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    val context: Context = LocalContext.current
    val viewModel: KisiKayitSayfaViewModel = viewModel(
        factory =  KisiKayitSayfaViewModelFactory(context.applicationContext as Application)
    )
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Kişi Kayıt")
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
                    viewModel.kayit(kisi_ad,kisi_tel)
                    localFocusManager.clearFocus()
                },
                modifier = Modifier.size(250.dp, 50.dp)
                    ) {
                    Text(text = "Kaydet")
                }
            }
        }

    )
}
