package com.example.Volonter.RF

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Volonter.RF.presentation.AccountPage
import com.example.Volonter.RF.presentation.AuthPage
import com.example.Volonter.RF.presentation.CardPage
import com.example.Volonter.RF.presentation.MainPage
import com.example.Volonter.RF.ui.theme.VolonterRFTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolonterRFTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Operator()
                }
            }
        }
    }
}

@Composable
fun Operator(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "AuthPage") {
        composable("AccountPage") {
            AccountPage()
        }
        composable("MainPage") {
            MainPage(navController)
        }
        composable("CardPage") {
            CardPage(navController)
        }
        composable("AuthPage"){
            AuthPage(navController)
        }
    }
}