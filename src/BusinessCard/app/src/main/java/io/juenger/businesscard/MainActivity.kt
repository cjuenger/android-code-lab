package io.juenger.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.juenger.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun Profile(name: String, jobTitle: String, modifier: Modifier = Modifier) {

    val painter = painterResource(R.drawable.cjuenger_avatar)

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth())

        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = jobTitle,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun ContactInfo(imageVector: ImageVector, contentDescriptor: String, contactInfo: String, modifier: Modifier){

    Column(modifier = modifier) {

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Gray)
        )

        Row(modifier = Modifier.padding(top = 5.dp)) {

            Icon(
                imageVector = imageVector,
                contentDescription = contentDescriptor,
                tint = Color.White,
                modifier = Modifier
                    .weight(1.0f)
                    .fillMaxWidth()
            )

            Text(
                text = contactInfo,
                color = Color.White,
                modifier = Modifier
                    .weight(2.0f)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun BusinessCard() {

    val myAppIcons = Icons.Rounded

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF4c03eb))
        .padding(10.dp, bottom = 24.dp)) {

        Profile(name = "cjuenger", jobTitle = "Software Engineer", Modifier.weight(1.0f))

        Column {

            ContactInfo(
                imageVector = myAppIcons.Phone,
                contentDescriptor = "Phone",
                contactInfo = "+49 (0228) 123 456",
                Modifier.padding(bottom = 5.dp)
            )

            ContactInfo(
                imageVector = myAppIcons.Share,
                contentDescriptor = "Social Media",
                contactInfo = "@instagram",
                Modifier.padding(bottom = 5.dp)
            )

            ContactInfo(
                imageVector = myAppIcons.Email,
                contentDescriptor = "E-Mail",
                contactInfo = "cjuenger@email.com",
                Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme(darkTheme = false) {
        BusinessCard()
    }
}