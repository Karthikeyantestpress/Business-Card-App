package com.example.businesscardapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}
@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFBDD4C2))
            .padding(16.dp)
    ) {
        ProfileSection(modifier = Modifier.weight(1f))
        ContactInfoSection()
    }
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.height(16.dp))
        UserName()
        UserCareer()
    }
}

@Composable
fun ProfileImage() {
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(Color(0xFF3e5c57))
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun UserName() {
    Text(
        text = stringResource(R.string.username),
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun UserCareer() {
    Text(
        text = stringResource(R.string.career),
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color(0xFF004D40),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ContactInfoSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ContactInfoRow(
            icon = Icons.Default.Phone,
            text = stringResource(R.string.phone)
        )
        ContactInfoRow(
            icon = Icons.Default.Share,
            text = stringResource(R.string.social)
        )
        ContactInfoRow(
            icon = Icons.Default.Email,
            text = stringResource(R.string.email)
        )
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF004D40)
        )
        Text(
            text = text,
            fontSize = 16.sp
        )
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() {
    BusinessCardAppTheme {
       BusinessCard()
    }
}