package com.jbc7ag.navigation.screens.course

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jbc7ag.navigation.R
import com.jbc7ag.navigation.navigation.Screens


@Composable
fun CourseScreen(navController: NavController) {
    Column() {
        val im = painterResource(id = R.drawable.analyst)
        Image(painter = im, contentDescription = "image")
        Surface(color = Color.Yellow, modifier = Modifier.fillMaxWidth()  ) {
            Text(
                text = "Submit your credit transfer grievance", modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(20.dp),
                color = Color(84, 94, 161),
                fontWeight = FontWeight.Bold
            )
        }
        Column( modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(top=10.dp)) {

            Text(text = "Learn anytime...", color = Color.Blue , fontWeight = FontWeight.Bold , fontSize = 35.sp)
            Text(text = "anywhere!!!" , modifier = Modifier.padding(start = 20.dp) , color = Color.Blue , fontWeight = FontWeight.Bold , fontSize = 35.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Explore 1200+ courses from the" , modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally),
                color = Color.Gray,
                fontSize = 15.sp
            )


            Card(modifier = Modifier
                .height(60.dp)
                .width(280.dp)
                .clickable { navController.navigate(Screens.Home.route)
                },
                backgroundColor = Color(84, 94, 161),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically ) {
                    Surface(color = Color(31, 37, 77) , modifier =  Modifier.height(80.dp)
                        .width(40.dp)) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "menu",tint = Color.White)
                    }

                    Text("Course Catalog", modifier = Modifier.fillMaxHeight()  .wrapContentSize(
                        Alignment.Center) .padding(start=10.dp), color = Color.White , fontWeight = FontWeight.Bold)

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Search from catalog with the" , color = Color.Gray , fontSize = 15.sp)
            Card(modifier = Modifier
                .height(60.dp)
                .width(280.dp)
                .clickable { navController.navigate(Screens.Home.route) },
                backgroundColor = Color(84, 94, 161),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically ) {
                    Surface(color = Color(31, 37, 77) , modifier =  Modifier.height(80.dp)
                        .width(40.dp) , ) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "menu" ,tint = Color.White)
                    }

                    Text("Course Search",modifier = Modifier.fillMaxHeight() .wrapContentSize(
                        Alignment.Center) .padding(start=10.dp) ,fontWeight = FontWeight.Bold, color = Color.White  )


                }
            }
        }
    }
}
