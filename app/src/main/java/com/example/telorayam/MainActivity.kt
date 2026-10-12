package com.example.telorayam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.telorayam.ui.theme.TelorayamTheme
import com.example.telorayam.ui.theme.TelorayamTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TelorayamTheme() {
                TelurCeplokApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelurCeplokApp() {

    var tahap by remember { mutableStateOf(1) }

    var jumlahKlik by remember { mutableStateOf(0) }

    var targetKlik by remember { mutableStateOf((2..4).random()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Membuat Telur Ceplok",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFD54F))
            )
        },
        modifier = Modifier.fillMaxSize()

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            when (tahap) {

                1 -> {

                    Text(
                        text = "Ayam",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.induk_ayam),
                        contentDescription = "Ayam",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {
                                tahap = 2
                            }
                    )

                    Text(
                        text = "Klik ayam",
                        fontSize = 18.sp
                    )
                }


                2 -> {

                    Text(
                        text = "Telur",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.telor),
                        contentDescription = "Telur",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {
                                tahap = 3
                            }
                    )

                    Text(
                        text = "Klik telur",
                        fontSize = 18.sp
                    )
                }


                3 -> {

                    Text(
                        text = "Ayam sedang mengerami telur",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.ayam_telor),
                        contentDescription = "Ayam mengerami telur",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {

                                jumlahKlik++

                                if (jumlahKlik >= targetKlik) {
                                    tahap = 4
                                }
                            }
                    )

                    Text(
                        text = "Klik: $jumlahKlik / $targetKlik",
                        fontSize = 18.sp
                    )
                }


                4 -> {

                    Text(
                        text = "Ambil Telur",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.telor),
                        contentDescription = "Ambil telur",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {
                                tahap = 5
                            }
                    )

                    Text(
                        text = "Klik telur untuk mengambilnya",
                        fontSize = 18.sp
                    )
                }


                5 -> {

                    Text(
                        text = "Pecahkan Telur",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.telor_pecah),
                        contentDescription = "Memecahkan telur",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {
                                tahap = 6
                            }
                    )

                    Text(
                        text = "Klik untuk memecahkan telur",
                        fontSize = 18.sp
                    )
                }


                6 -> {

                    Text(
                        text = "Masak Telur",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.telor_di_panci),
                        contentDescription = "Memasak telur",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {
                                tahap = 7
                            }
                    )

                    Text(
                        text = "Klik untuk memasak telur",
                        fontSize = 18.sp
                    )
                }


                7 -> {

                    Text(
                        text = "Telur Ceplok!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(R.drawable.telor_ceplok),
                        contentDescription = "Telur ceplok",

                        modifier = Modifier
                            .size(250.dp)
                            .clickable {

                                tahap = 1
                                jumlahKlik = 0
                                targetKlik = (2..4).random()
                            }
                    )

                    Text(
                        text = "Telur ceplok sudah jadi!",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TelorayamTheme() {
        TelurCeplokApp()
    }
}