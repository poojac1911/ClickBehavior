package com.example.clickbehavior

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehavior.ui.theme.ClickBehaviorTheme
import com.example.clickbehavior.ui.theme.green30

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickBehaviorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}
@Composable
fun WelcomeScreen(name: String, onStartClicked: () -> Unit) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
            ){
        Text(text = "Welcome $name!", fontSize = 40.sp)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onStartClicked
        ) {
            Text("Start")
        }
    }
}


@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        when (currentStep) {
            0 -> {
                val start = { currentStep = 1 }
                WelcomeScreen("Pooja", start )
            }
            1 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = "1",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 2
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text( text = stringResource(id = R.string.lemon_tree))
            }
            2 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = "2",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 3
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text( text = stringResource(id = R.string.lemon_squeeze))
            }
            3 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = "3",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 4
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text( text = stringResource(id = R.string.lemon_drink))
            }
            4 -> {
                Image(
                    painter = painterResource(id = R.drawable.lemon_restart),
                    contentDescription = "4",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 0
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text( text = stringResource(id = R.string.lemon_empty_glass))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClickBehaviorTheme {
        LemonApp()
    }
}