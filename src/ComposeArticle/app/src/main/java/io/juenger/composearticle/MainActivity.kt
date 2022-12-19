package io.juenger.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.juenger.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun BackgroundImage() {
    val painter = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top))
}

@Composable
fun Title(text: String) {
    Text(
        text,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Summary(text: String) {
    Text(
        text,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
fun Details(text: String) {
    Text(
        text,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Page(topic: String, summary: String, details: String) {
    Column {
        BackgroundImage()
        Title(topic)
        Summary(summary)
        Details(details)
    }
}

@Preview(showBackground = true)
@Composable
fun PagePreview() {
    ComposeArticleTheme {

        val topic = stringResource(R.string.topic)
        val summary = stringResource(R.string.summary)
        val details = stringResource(R.string.details)

        Page(topic = topic, summary = summary, details = details)
    }
}