package dp.zonbi.twooter.screens.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dp.zonbi.twooter.utils.titleCase
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: Screens.Home.route
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var currentIndex by rememberSaveable { mutableIntStateOf(0) }

    val screens = listOf(
        Screens.Home,
        Screens.Search,
        Screens.Settings
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Content of the drawer
            ModalDrawerSheet {
                DrawerHeader()
                HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))

                screens.forEachIndexed { index, screen ->
                    NavigationDrawerItem(
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                        label = { Text(screen.title) },
                        selected = index == currentIndex,
                        icon = {
                            Icon(
                                imageVector = if (index == currentIndex) screen.selectedIcon else screen.unselectedIcon,
                                contentDescription = screen.title
                            )
                        },
                        onClick = {
                            currentIndex = index
                            navController.navigate(screen.route) {
                                launchSingleTop = true
                            }
                            coroutineScope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        // Content of the page
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(
                        text = currentRoute.titleCase(),
                        fontFamily = FontFamily.Serif
                    ) },
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Open navigation drawer")
                        }
                    }
                )
            }
        ) { contentPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
            ) {
                NavigationStack(navController = navController)
            }
        }
    }
}

@Composable
fun DrawerHeader() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(
            text = "twooter",
            fontWeight = FontWeight.W200,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp
        )
    }
}