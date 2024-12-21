package dp.zonbi.twooter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dp.zonbi.twooter.screens.navigation.NavDrawer
import dp.zonbi.twooter.ui.theme.TwooterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwooterTheme {
                NavDrawer()
            }
        }
    }
}