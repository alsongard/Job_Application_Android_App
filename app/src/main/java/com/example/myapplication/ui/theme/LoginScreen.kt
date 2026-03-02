package com.example.myapplication.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.R



@Composable
fun GetUserInfo( // COMPOSABLE FOR TEXTFIELDS
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

@Composable // SIGNIN & SIGNOUT FORM
fun LoginAppLayout(
    userEmail:String,
    userPasswd:String,
    userConfirmPasswd:String,
    signLoginBool: Boolean,
    viewModel: JobViewModel,
    onNextView: ()->Unit,
    modifier: Modifier = Modifier
)
{

    Column(modifier = Modifier
        .fillMaxSize()
        ,horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
    {

        Spacer(modifier = Modifier.padding(vertical = 100.dp))
        Card( Modifier
            .fillMaxWidth(0.9f)
            .padding(10.dp))
        {
            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                if (signLoginBool) "Signup" else "Login",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            GetUserInfo(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally) ,
                value = userEmail,
                onValueChange = {viewModel.onChangeEmailPass("email", it )},
                leadingIcon = R.drawable.icons8_user_48,
                label = R.string.email_label,
            )

            Spacer(modifier = Modifier.padding(16.dp))
            GetUserInfo(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally) ,
                value = userPasswd,
                onValueChange = {viewModel.onChangeEmailPass("password",it)},
                leadingIcon = R.drawable.icons8_password_48_1_,
                label = R.string.password_label,
            )
            Spacer(modifier = Modifier.padding(16.dp))
            if (signLoginBool)
            {
                GetUserInfo(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    value = userConfirmPasswd,
                    onValueChange = {viewModel.onChangeEmailPass("confirmPasswd", it)},
                    leadingIcon = R.drawable.icons8_password_48_1_,
                    label = R.string.confirm_label,
                )
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Column(modifier
                //            .shape = RoundedCornerShape(10.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .padding(vertical = 10.dp, horizontal = 20.dp) // this acts as padding when applied after background
                , Arrangement.Center)
            {
                if (signLoginBool) // default value is: true
                {
                    Button(onClick = {
                        viewModel.addUser()
                        onNextView()
                    })
                    {
                        Text(text="Signup")
                    }
                    Text("Click to login if you already have an account",modifier = Modifier.clickable{viewModel.toggleForm(signLoginBool)})
                }
                else
                {
                    Button(onClick = {
                        viewModel.loginUser()
                        onNextView()
                    })
                    {
                        Text(text="Login")
                    }
                    Text("Forgot password")
                    Text("Click to signup if you already have an account", modifier = Modifier.clickable{viewModel.toggleForm(signLoginBool)})
                }
//                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            }


        }




    }
}