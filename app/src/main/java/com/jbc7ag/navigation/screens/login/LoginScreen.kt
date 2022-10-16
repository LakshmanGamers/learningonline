package com.jbc7ag.navigation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jbc7ag.navigation.R
import com.jbc7ag.navigation.navigation.Screens
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(navController: NavController) {
Login(navController)
}

@Composable
fun  Login(navController: NavController){

    Box(){
        val im = painterResource(id = R.drawable.analyst)
        Image(painter = im, contentDescription =null  , modifier = Modifier.fillMaxSize() , contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var uid by rememberSaveable{
                mutableStateOf("")
            }
            var pwd by rememberSaveable {
                 mutableStateOf("")
            }

            TextField(value = uid , onValueChange = {uid = it} , label = {Text("username")} , colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White)
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextField(value = pwd , onValueChange = {pwd = it} , label = {Text("password")},colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {  navController.navigate(Screens.Course.route)  } , shape = RoundedCornerShape(20.dp) , modifier = Modifier
                .height(50.dp)
                .width(200.dp)) {
                Text("LOGIN ")
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {  navController.navigate(Screens.Course.route)  } , shape = RoundedCornerShape(20.dp), modifier = Modifier
                .height(50.dp)
                .width(200.dp)) {
                Text("CONTINUE AS GUEST")
            }
        }
    }


}


@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)

}
