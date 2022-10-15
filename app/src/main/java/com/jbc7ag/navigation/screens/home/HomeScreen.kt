package com.jbc7ag.navigation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jbc7ag.navigation.navigation.Screens
import com.jbc7ag.navigation.R

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController)},
        content = {
            CourseList(navController)
        }
    )
}




@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "Courses")
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screens.Login.route)
            }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )

}


@ExperimentalFoundationApi
@Composable
fun CourseList(navController: NavController){
    val list = listOf<String>("Engineering" , "Medical" , "Bussiness" , "Architechure" , "Teacher" , "Law" , "School" , "Health Sciences")

    LazyVerticalGrid(

        cells = GridCells.Fixed(3),
        // content padding
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->
                Card(

                    backgroundColor = Color.White,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .clickable { navController.navigate(Screens.Detail.route) }
                    ,
                    elevation = 0.dp,

                    ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally ) {
                        Image(painter = painterResource(id = com.jbc7ag.navigation.R.drawable.online_course), contentDescription = "1" )
                        Text(text = list[index])



                    }
                }
            }
        }
    )
}
@ExperimentalFoundationApi
@Composable
@Preview
fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}