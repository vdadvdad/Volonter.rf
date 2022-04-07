package com.example.Volonter.RF.presentation

import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun AuthPage(navController: NavController) {
    var loginValue = remember{ mutableStateOf("")}
    var passwordValue = remember{ mutableStateOf("")}
    var onMain = false
    lateinit var auth: FirebaseAuth
    auth = Firebase.auth
    val currentUser = auth.currentUser
//    if(currentUser != null) {
//        navController.navigate("MainPage")
//    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ){
        TextField(value = loginValue.value, onValueChange = {txt -> loginValue.value = txt})
        TextField(value = passwordValue.value, onValueChange = {txt -> passwordValue.value = txt})
        Button(onClick = {
            if (!(loginValue.value == "" || passwordValue.value == "")){

                auth.signInWithEmailAndPassword(loginValue.value, passwordValue.value)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("login", "signInWithEmail:success")
                            val user = auth.currentUser
                            if (!onMain){
                                navController.navigate("MainPage")
                                onMain = true
                            }
                        } else {
                            Log.w("login", "signInWithEmail:failure", task.exception)
                        }
                    }
            }
        }){
            Text("Войти")
        }
    }
}