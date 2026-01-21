package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier= Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    MainAppLayout()
                }
            }
        }
    }
}

@Composable
fun GetUserInfo(
    modifier:Modifier = Modifier,
    value:String,
    onValueChange:(String)-> Unit,
    @DrawableRes leadingIcon: Int,
    @StringRes label:Int
)
{
    TextField(
        onValueChange = onValueChange,
        value = value,
        label = {Text(stringResource(label))},
        modifier = modifier,
        leadingIcon  = { Icon(painter= painterResource(leadingIcon), null) }
    )
}
@Composable
fun MainAppLayout(modifier: Modifier = Modifier)
{
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    // Gradient background
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
//            Color.hsl(183f, 91f, 23f), // 0xFF056B70
            Color(0xFF056B70),  // Blue #056B70
            Color(0xFF056B70),  // Light Blue
            Color(0xFF056B70),  // Very Light Blue/White
        ),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(gradientBrush), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
        Text(
            text = "The Job Application",
            style = MaterialTheme.typography.headlineMedium,
//            color = Color(0xFF94DFE3),
            color = Color.Black,
            textAlign = TextAlign.Center,

            modifier = Modifier
                .background(color = Color(0XFFC6EEF0))
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )

        Spacer(modifier = Modifier.padding(vertical = 100.dp))
        GetUserInfo(
            modifier = Modifier.clip(RoundedCornerShape(10.dp)),
            value = email,
            onValueChange = {email = it},
            leadingIcon = R.drawable.icons8_user_48,
            label = R.string.email_label,
        )
//        TextField(
//            value = email,
//            onValueChange = {email = it},
//            label = {Text("Email")},
//            modifier = Modifier
//                .clip(RoundedCornerShape(10.dp))
//        )
        Spacer(modifier = Modifier.padding(16.dp))
        GetUserInfo(
            modifier = Modifier.clip(RoundedCornerShape(10.dp)),
            value = password,
            onValueChange = {password = it},
            leadingIcon = R.drawable.icons8_password_48_1_,
            label = R.string.password_label,
        )

//        TextField(
//            value = password,
//            onValueChange = {password = it},
//            label = {Text("Password")},
//            modifier = Modifier
//                    .clip(RoundedCornerShape(10.dp))
//        )


        Spacer(modifier = Modifier.padding(16.dp))

        Row(modifier
//            .shape = RoundedCornerShape(10.dp)
            .clip(RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp, horizontal = 20.dp) // this acts as padding when applied after background
            , Arrangement.Center)
        {
            Button(onClick = {/**/})
            {
                Text(text="signup")
            }
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Button(onClick = {/**/})
            {
                Text(text="login")
            }
        }
    }
}


@Preview
@Composable
fun MainAppPreview(modifier: Modifier = Modifier)
{
    MyApplicationTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainAppLayout()
        }
    }

}

