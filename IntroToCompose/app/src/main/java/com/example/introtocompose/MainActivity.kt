package com.example.introtocompose


import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}
@Composable
fun MyApp(){

    var moneyCounter   by remember {
        mutableStateOf(9)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$moneyCounter ", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter=moneyCounter) {newValue->
                moneyCounter = newValue + 1
            }
        }
    }
}

@Composable
fun CreateCircle(moneyCounter:Int, updateMoneyCounter:(Int)->Unit){


       Card(modifier = Modifier
           .padding(all = 10.dp)
           .size(100.dp)
           .width(100.dp)
           .clickable {
               updateMoneyCounter(moneyCounter)
           }, shape = CircleShape, backgroundColor = MaterialTheme.colors.primary )

       {
           Box(contentAlignment = Alignment.Center){
               Text(text = "Tap", textAlign = TextAlign.Center)

       }
   }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}