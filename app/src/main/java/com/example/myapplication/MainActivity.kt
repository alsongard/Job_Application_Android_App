package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.DataSource
import com.example.myapplication.model.JobInfo
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier= Modifier.fillMaxSize())
                {
                    MainAppLayout()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobAppTopBar(
    textFieldStat: TextFieldState,
    onSearch: (String)->Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
)
{
    var expanded by rememberSaveable { mutableStateOf(false)}

        SearchBar(
            modifier = modifier,
            inputField = {
                SearchBarDefaults.InputField(
                    query = textFieldStat.text.toString(),
                    onQueryChange = { textFieldStat.edit { replace(0, length, it) } },
                    onSearch = {
                        onSearch(textFieldStat.text.toString())

                    },

                    expanded = expanded,
                    onExpandedChange = {expanded = it},
                    placeholder = { "Search" },
                    leadingIcon = {}
                )
            },

            expanded = expanded,
            onExpandedChange = { expanded = it },
        )
        {
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

@Composable // SIGNIN & SIGNOUT FORM
fun LoginAppLayout(modifier: Modifier = Modifier)
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







@Composable
fun MiniCardJobView(jobInfo: JobInfo, expanded: Boolean, modifier: Modifier = Modifier, onClick: ()-> Unit)
{
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface))
    {
        if (expanded)
            Row(modifier = Modifier.fillMaxWidth().padding(5.dp), verticalAlignment = Alignment.Top)
            {
                // here we benefit the use of classes: specifically the data class
                Image(
                    painter = painterResource(jobInfo.jobCompanyLogo),
                    contentDescription = stringResource(R.string.job_description_1),
                    Modifier.height(50.dp).width(50.dp).clip(CircleShape)
                )
                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(stringResource(jobInfo.jobCategory)) /// title
                    Text(stringResource(jobInfo.jobCompanyName)) //company name
                    Text(stringResource(jobInfo.jobLocation)) // Location
                    Text("2025-02-12") // date of posting
                }
                IconButton(onClick = onClick) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.ExpandMore else Icons.Default.ExpandLess,
                        contentDescription = null
                    )
                }

            }

        else 
            Column(
                modifier = modifier
                    .padding(horizontal = 16.dp, 16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            )
            {
                // Company Logo
                Row(
                    verticalAlignment = Alignment.Top
                )
                {
                    Image(
                        painter = painterResource(jobInfo.jobCompanyLogo),
                        contentDescription = "Company Logo",
                        modifier = Modifier
                            //                    .size(100.dp)
                            .height(120.dp)
                            .weight(2f)
//                            .fillMaxWidth(1f)
//                            .align(Alignment.CenterHorizontally)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(onClick = onClick) {
                        Icon(
                            imageVector = if (expanded) Icons.Default.ExpandMore else Icons.Default.ExpandLess,
                            contentDescription = null
                        )
                    }
                    
                }

                // Company Name
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Company: ",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobCompanyName),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Mission
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Mission:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobCompanyMission),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                //
                //            // Website
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Website: ",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobCompanyWebsite),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                // Category
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Category: ",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobCategory),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Type
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Type: ",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobType),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Experience Level
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Experience: ",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobExperience),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Location
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Location: ",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobLocation),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    color = MaterialTheme.colorScheme.outlineVariant
                )

                // Job Description
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Description:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = stringResource(jobInfo.jobDescription),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                // Requirements
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "Requirements:",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    stringArrayResource(R.array.job_requirements_1).forEach { requirement ->
                        Row(
                            modifier = Modifier.padding(start = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "•",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Text(
                                text = requirement,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
                Button(onClick={/**/}, modifier.fillMaxWidth()) {
                    Text(text="Apply")
                }
                //            Spacer(modifier.padding(vertical = 10.dp))
            }
    }

}

@Composable
fun JobCardView(modifier: Modifier = Modifier, jobInfo: JobInfo) {
    var expanded by remember { mutableStateOf(true) }
    Card(
        modifier = modifier.padding(vertical = 20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    )
    {
        MiniCardJobView(jobInfo, expanded = expanded, onClick = {expanded = !expanded})
    }
}

@Composable
fun MainAppLayout()
{
    var textFieldStat  = rememberTextFieldState()
    var items = listOf(
        "Tech", "Medicine"
    )
    Scaffold(
        topBar = {

            Row(modifier = Modifier.padding(horizontal = 2.dp), verticalAlignment = Alignment.CenterVertically){
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                JobAppTopBar(
                    textFieldStat = textFieldStat,
                    onSearch =  {/**/},
                    searchResults = items,

                    )
            }

        }
    ) {
        LazyColumn(contentPadding = it) { //verticalArrangement = Arrangement.spacedBy(40.dp),
            items(DataSource().loadJobInfo()) { job->
                JobCardView(
                    jobInfo = job
                )
            }
        }
    }
}

@Preview
@Composable
fun MainAppPreview(modifier: Modifier = Modifier)
{
    MyApplicationTheme(darkTheme = false) {
        MainAppLayout()
    }
}


// dark preview
@Preview
@Composable
fun MainDarkPreview()
{
    MyApplicationTheme(darkTheme = true)
    {
        MainAppLayout()
    }
}

@Composable // this is for lazyloading
fun JobListsView(jobInfoLists: List<JobInfo>, modifier: Modifier = Modifier)
{
    LazyColumn(modifier ,verticalArrangement = Arrangement.spacedBy(40.dp)) {
        items(jobInfoLists) { job -> // if what am receiving are objects in this then to access a property of object i use dot notation: object.property
            JobCardView(
//                modifier = Modifier.fillMaxWidth(),
                jobInfo = job
            )


        }
    }
}