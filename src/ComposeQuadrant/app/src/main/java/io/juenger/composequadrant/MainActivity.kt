package io.juenger.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.juenger.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Quadrants()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, description: String, color: Color, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Quadrants() {

    Column(Modifier.fillMaxWidth()) {

        Row(modifier = Modifier.weight(1.0f)) {
            val titleQ1 = stringResource(R.string.text_composable_title)
            val descriptionQ1 = stringResource(R.string.text_composable_description)
            val colorQ1 = Color.Green
            Quadrant(title = titleQ1, description = descriptionQ1, color = colorQ1, Modifier.weight(1.0f))

            val titleQ2 = stringResource(R.string.image_composable_title)
            val descriptionQ2 = stringResource(R.string.image_composable_description)
            val colorQ2 = Color.Yellow
            Quadrant(title = titleQ2, description = descriptionQ2, color = colorQ2, Modifier.weight(1.0f))
        }

        Row(modifier = Modifier.weight(1.0f)) {
            val titleQ3 = stringResource(R.string.row_composable_title)
            val descriptionQ3 = stringResource(R.string.row_composable_description)
            val colorQ3 = Color.Blue
            Quadrant(title = titleQ3, description = descriptionQ3, color = colorQ3, Modifier.weight(1.0f))

            val titleQ4 = stringResource(R.string.column_composable_title)
            val descriptionQ4 = stringResource(R.string.column_composable_description)
            val colorQ4 = Color.Gray
            Quadrant(title = titleQ4, description = descriptionQ4, color = colorQ4, Modifier.weight(1.0f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        Quadrants()
    }
}