package io.juenger.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.juenger.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun Lemonade() {

    var lemonadeProgress by remember { mutableStateOf(LemonadeProgress.Reap) }
    var squeezeTimes by remember { mutableStateOf((2..4).random()) }

    val imageSource = when(lemonadeProgress) {
        LemonadeProgress.Reap -> R.drawable.lemon_tree
        LemonadeProgress.Squeeze -> R.drawable.lemon_squeeze
        LemonadeProgress.Drink -> R.drawable.lemon_drink
        LemonadeProgress.Drunk -> R.drawable.lemon_restart
    }

    val descriptionStringSource = when(lemonadeProgress) {
        LemonadeProgress.Reap -> R.string.lemon_tree
        LemonadeProgress.Squeeze -> R.string.lemon
        LemonadeProgress.Drink -> R.string.lemonade
        LemonadeProgress.Drunk -> R.string.empty_glass
    }
    
    val instructionStringSource = when(lemonadeProgress) {
        LemonadeProgress.Reap -> R.string.tap_lemon_tree
        LemonadeProgress.Squeeze -> R.string.tap_lemon
        LemonadeProgress.Drink -> R.string.tap_lemonade
        LemonadeProgress.Drunk -> R.string.tap_empty_glass
    }

    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {

        Text(
            text = stringResource(id = instructionStringSource),
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(2.dp, Color(105, 205, 216)),
            shape = RoundedCornerShape(5),
            onClick = {

                if(lemonadeProgress == LemonadeProgress.Squeeze) {
                    squeezeTimes--
                }

                lemonadeProgress = getNextState(lemonadeProgress, squeezeTimes)

                if(lemonadeProgress == LemonadeProgress.Drink) {
                    squeezeTimes = (2..4).random()
                }
            }
        ) {
            Image(
                painter = painterResource(id = imageSource) ,
                contentDescription = stringResource(id = descriptionStringSource
            ))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        Lemonade()
    }
}

fun getNextState(currentState: LemonadeProgress, squeezeTimes: Int) : LemonadeProgress {

    return when (currentState) {
        LemonadeProgress.Reap -> LemonadeProgress.Squeeze
        LemonadeProgress.Squeeze -> {
            if(squeezeTimes == 0) {
                LemonadeProgress.Drink
            }
            else {
                LemonadeProgress.Squeeze
            }
        }
        LemonadeProgress.Drink -> LemonadeProgress.Drunk
        LemonadeProgress.Drunk -> LemonadeProgress.Reap
    }
}

enum class LemonadeProgress {
    Reap,
    Squeeze,
    Drink,
    Drunk
}