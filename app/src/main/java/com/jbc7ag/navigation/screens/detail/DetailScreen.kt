package com.jbc7ag.navigation.screens.detail

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.google.accompanist.pager.*
import com.jbc7ag.navigation.R
import com.jbc7ag.navigation.navigation.Screens
import kotlinx.coroutines.launch


sealed class DrawerScreens(val title: String) {
    object Home : DrawerScreens("Home")
    object Account : DrawerScreens("Account")
    object Help : DrawerScreens( "Help")
}

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Account,
    DrawerScreens.Help
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(24.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h4
            )
        }
    }
}




@ExperimentalFoundationApi
@OptIn(ExperimentalUnitApi::class)
@ExperimentalPagerApi
@Composable
fun DetailScreen(navController: NavController) {
    Scaffold( topBar = { Topbar(navController)}  , content = {
Course(navController)
    }
    )



}


@ExperimentalFoundationApi
@OptIn(ExperimentalUnitApi::class)
@ExperimentalPagerApi
@Composable
fun Topbar(navController: NavController){
    val mContext = LocalContext.current
    val pagerState = rememberPagerState(pageCount = 2)
    Column() {
        TopAppBar(
            title = {
                Text(text = "Courses")
            },
            navigationIcon = {
                IconButton(onClick = {
           navController.navigate(Screens.Home.route)
                }) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            },
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White,
            elevation = 10.dp,
            actions = {



                IconButton(onClick = {

                }) {
                    Icon(Icons.Filled.Menu, "")
                }


            }

        )

        Tabs(pagerState = pagerState)

        TabsContent(pagerState = pagerState , navController =navController)


    }

}


@ExperimentalPagerApi
@Composable
fun Tabs(pagerState: PagerState) {

    val list = listOf<String>("UPCOMING" , "ONGOING")

    val scope = rememberCoroutineScope()

    TabRow(

        selectedTabIndex = pagerState.currentPage,

        backgroundColor = MaterialTheme.colors.primary,

        // on below line we are specifying content color.
        contentColor = Color.White,

        // on below line we are specifying
        // the indicator for the tab
        indicator = { tabPositions ->
            // on below line we are specifying the styling
            // for tab indicator by specifying height
            // and color for the tab indicator.
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        // on below line we are specifying icon
        // and text for the individual tab item
        list.forEachIndexed { index, _ ->
            // on below line we are creating a tab.
            Tab(
                // on below line we are specifying icon
                // for each tab item and we are calling
                // image from the list which we have created.

                // on below line we are specifying the text for
                // the each tab item and we are calling data
                // from the list which we have created.
                text = {
                    Text(
                        list[index],
                        // on below line we are specifying the text color
                        // for the text in that tab
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                // on below line we are specifying
                // the tab which is selected.
                selected = pagerState.currentPage == index,
                // on below line we are specifying the
                // on click for the tab which is selected.
                onClick = {
                    // on below line we are specifying the scope.
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

// on below line we are creating a tab content method
// in which we will be displaying the individual page of our tab .
@ExperimentalFoundationApi
@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState , navController: NavController) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            // on below line we are calling tab content screen
            // and specifying data as Home Screen.
            0 -> Course(navController)
            // on below line we are calling tab content screen
            // and specifying data as Shopping Screen.
            1 -> Course(navController)

        }
    }
}


@ExperimentalFoundationApi
@Composable
fun Course(navController: NavController){
    val list = listOf<String>("Engineering" , "Medical" , "Bussiness" , "Architechure" , "Teacher" , "Law" , "School" , "Health Sciences")

    LazyVerticalGrid(

        cells = GridCells.Fixed(1),

        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(list.size) { index ->


                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 7.dp)
                    .clickable {   navController.navigate(Screens.Login.route) }
                    , shape = RoundedCornerShape(10.dp) ,


                elevation = 10.dp
                    ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.images__2_),
                            contentDescription = "aicte logo"
                        )
                        Column(modifier = Modifier.padding(start = 10.dp)) {
                            Text(
                                text = list[index],
                                color = Color(135, 19, 255),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = "self paced", fontSize = 14.sp, color = Color.Gray)
                        }
                    }

                }
            }
        }

    )
}

