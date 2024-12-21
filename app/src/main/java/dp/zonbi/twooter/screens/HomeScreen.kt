package dp.zonbi.twooter.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dp.zonbi.twooter.twoot.AddTwoot
import dp.zonbi.twooter.ui.theme.lightPurple

@Composable
fun HomeScreen() {
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "home screen")

        FloatingActionButton(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomEnd),
            containerColor = lightPurple,
            shape = CircleShape,
            onClick = {
                showDialog = true
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                tint = Color.White,
                contentDescription = "add twoot"
            )
        }
    }

    AnimatedVisibility(
        visible = showDialog,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            shape = RoundedCornerShape(8.dp)
        ) {
            AddTwoot(onCloseButtonClick = { showDialog = false })
        }
    }
}