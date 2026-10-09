package com.example.myinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myinformation.ui.theme.MyInformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyInformationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyInformationScreen()
                }
            }
        }
    }
}

@Composable
fun MyInformationScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Аватар
        Image(
            painter = painterResource(id = R.drawable.photo_5418107180005059838_y),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        // ФИО
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        // Должность
        Text(
            text = stringResource(R.string.title),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Возраст
        Text(
            text = stringResource(R.string.age_format, 20),
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Телефон
        ContactRow(
            icon = { Icon(Icons.Default.Phone, contentDescription = null) },
            text = stringResource(R.string.phone)
        )

        // Соцсеть
        ContactRow(
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            text = stringResource(R.string.social)
        )

        // Email
        ContactRow(
            icon = { Icon(Icons.Default.Email, contentDescription = null) },
            text = stringResource(R.string.email)
        )
    }
}

@Composable
fun ContactRow(
    icon: @Composable () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MyInformationPreview() {
    MyInformationTheme {
        MyInformationScreen()
    }
}