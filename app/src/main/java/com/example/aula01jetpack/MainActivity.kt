package com.example.aula01jetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aula01jetpack.ui.theme.Aula01JetpackTheme
import com.example.aula01jetpack.ui.theme.DarkPurple
import com.example.aula01jetpack.ui.theme.DebugButtonColors
import com.example.aula01jetpack.ui.theme.ErrorButtonColors
import com.example.aula01jetpack.ui.theme.InfoButtonColors
import com.example.aula01jetpack.ui.theme.Lavender
import com.example.aula01jetpack.ui.theme.WarningButtonColors

const val TAG = "LogButtons"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aula01JetpackTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }

}

@Composable
private fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkPurple
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting("Buttons App")
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors()
            ) {
                Log.d(TAG, "App: Clicou em Debug")
            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors()
            ) {
                Log.i(TAG, "App: Clicou em Info")
            }
            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors()
            ) {
                Log.w(TAG, "App: Clicou em Warning")
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors()
            ) {
                throw RuntimeException("Clicou em Error")
                Log.e(TAG, "App: Clicou em Error")
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit
) {

    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors
    ) {

        Text(text = text)
        
    }
    
}

@Composable
fun Greeting(name: String) {
        Text(
            text = "Welcome to $name!",
            color = Lavender,
            modifier = Modifier
        )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Aula01JetpackTheme {
        Greeting("Buttons App")
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun AppPreview() {

    Aula01JetpackTheme {
        App()
    }
    
}

@Preview(showBackground = true, widthDp = 320, heightDp = 480)
@Composable
fun ActionButtonPreview() {

    ActionButton(text = "Action", ) {
        
    }
    
}