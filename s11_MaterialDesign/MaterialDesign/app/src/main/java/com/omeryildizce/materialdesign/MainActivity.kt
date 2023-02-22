package com.omeryildizce.materialdesign

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
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
                    SayfaTopAppBar()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialDesignTheme {
        SayfaTopAppBar()
    }
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
