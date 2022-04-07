package com.example.Volonter.RF.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.Volonter.RF.R
import com.example.Volonter.RF.ui.theme.MainPurple

@Composable
@Preview(showBackground = true)
fun AccountPage(navController: NavHostController = rememberNavController()){
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {
        AccountPageBody()
    }
}
@Composable
fun AccountPageBody(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(R.drawable.photo_example), contentDescription = "desc",
            modifier = Modifier.clip(RoundedCornerShape(100)).size(150.dp))
        Text("Владислав Павловский", fontWeight = FontWeight.Bold, fontSize = 30.sp)
        Text("Волонтер с 7 апреля 2022 года", color = Color.LightGray)
    }
}