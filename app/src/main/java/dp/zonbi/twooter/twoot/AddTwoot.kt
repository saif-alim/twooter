package dp.zonbi.twooter.twoot

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dp.zonbi.twooter.ui.theme.lightPurple
import dp.zonbi.twooter.ui.theme.veryLightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTwoot(onCloseButtonClick: () -> Unit) {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
    ) {
        IconButton(
            onClick = onCloseButtonClick,
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "close")
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            value = text,
            minLines = 5,
            maxLines = 25,
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.White,
                containerColor = veryLightGrey,
            ),
            onValueChange = { text = it },
            label = {
                Text(
                    text = "What's on your mind?",
                    fontFamily = FontFamily.Serif
                )
            },
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = {
                // post to firebase

                Toast.makeText(context, "twoot posted!", Toast.LENGTH_SHORT).show()
                text = ""
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = lightPurple
            ),
            modifier = Modifier
                .align(Alignment.End)
                .padding(horizontal = 16.dp),
        ) {
            Text(text = "twoot",
                modifier = Modifier.padding(horizontal = 24.dp))
        }
    }
}