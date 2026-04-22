package com.example.myapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


//@Composable
//fun GetUserInfo( // COMPOSABLE FOR TEXTFIELDS
//    modifier:Modifier = Modifier,
//    value:String,
//    onValueChange:(String)-> Unit,
//    @DrawableRes leadingIcon: Int,
//    @StringRes label:Int
//)
//{
//    TextField(
//        onValueChange = onValueChange,
//        value = value,
//        label = {Text(stringResource(label))},
//        modifier = modifier,
//        leadingIcon  = { Icon(painter= painterResource(leadingIcon), null) }
//    )
//}

//@Composable // SIGNIN & SIGNOUT FORM
//fun LoginAppLayout(
//    userEmail:String,
//    userPasswd:String,
//    userConfirmPasswd:String,
//    signLoginBool: Boolean,
//    viewModel: JobViewModel,
//    modifier: Modifier = Modifier
//)
//{
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        ,horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top)
//    {
//
//        Spacer(modifier = Modifier.padding(vertical = 100.dp))
//        Card( Modifier
//            .fillMaxWidth(0.9f)
//            .padding(10.dp))
//        {
//            Spacer(modifier = Modifier.padding(vertical = 8.dp))
//
//            Text(
//                if (signLoginBool) "Signup" else "Login",
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center,
//                style = MaterialTheme.typography.titleLarge
//            )
//            GetUserInfo(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(10.dp))
//                    .fillMaxWidth()
//                    .align(Alignment.CenterHorizontally) ,
//                value = userEmail,
//                onValueChange = {viewModel.onChangeEmailPass("email", it )},
//                leadingIcon = R.drawable.icons8_user_48,
//                label = R.string.email_label,
//            )
//
//            Spacer(modifier = Modifier.padding(16.dp))
//            GetUserInfo(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(10.dp))
//                    .fillMaxWidth()
//                    .align(Alignment.CenterHorizontally) ,
//                value = userPasswd,
//                onValueChange = {viewModel.onChangeEmailPass("password",it)},
//                leadingIcon = R.drawable.icons8_password_48_1_,
//                label = R.string.password_label,
//            )
//            Spacer(modifier = Modifier.padding(16.dp))
//            if (signLoginBool)
//            {
//                GetUserInfo(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(10.dp))
//                        .fillMaxWidth()
//                        .align(Alignment.CenterHorizontally),
//                    value = userConfirmPasswd,
//                    onValueChange = {viewModel.onChangeEmailPass("confirmPasswd", it)},
//                    leadingIcon = R.drawable.icons8_password_48_1_,
//                    label = R.string.confirm_label,
//                )
//            }
//
//            Spacer(modifier = Modifier.padding(5.dp))
//
//            Column(modifier
//                //            .shape = RoundedCornerShape(10.dp)
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(10.dp))
//                .padding(vertical = 10.dp, horizontal = 20.dp) // this acts as padding when applied after background
//                , Arrangement.Center)
//            {
//                if (signLoginBool) // default value is: true
//                {
//                    Button(onClick = {viewModel.addUser()})
//                    {
//                        Text(text="Signup")
//                    }
//                    Text("Click to login if you already have an account",modifier = Modifier.clickable{viewModel.toggleForm(signLoginBool)})
//                }
//                else
//                {
//                    Button(onClick = {viewModel.loginUser()})
//                    {
//                        Text(text="Login")
//                    }
//                    Text("Forgot password")
//                    Text("Click to signup if you already have an account", modifier = Modifier.clickable{viewModel.toggleForm(signLoginBool)})
//                }
////                Spacer(modifier = Modifier.padding(horizontal = 10.dp))
//            }
//
//
//        }
//
//
//
//
//    }
//}



//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun JobAppTopBar(
//    textFieldStat: TextFieldState,
//    onSearch: (String)->Unit,
//    searchResults: List<String>,
//    modifier: Modifier = Modifier
//)
//{
//    var searchExpanded by rememberSaveable { mutableStateOf(false)}
//
//    SearchBar(
//        modifier = modifier,
//        inputField = {
//            SearchBarDefaults.InputField(
//                query = textFieldStat.text.toString(),
//                onQueryChange = { textFieldStat.edit { replace(0, length, it) } },
//                onSearch = {
//                    onSearch(textFieldStat.text.toString())
//
//                },
//
//                expanded = searchExpanded,
//                onExpandedChange = {searchExpanded = it},
//                placeholder = { "Search" },
//                leadingIcon = {}
//            )
//        },
//
//        expanded = searchExpanded,
//        onExpandedChange = { searchExpanded = it },
//    )
//    {
//    }
//}

//@Composable
//fun MainJobView(modifier: Modifier = Modifier, jobInfo: JobInfo) {
//    var expanded by remember { mutableStateOf(true) }
//    Card(
//        modifier = modifier.padding(vertical = 20.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
//    )
//    {
//        JobCardView(jobInfo, expanded = expanded, onClick = { expanded = !expanded })
//    }
//}



//@Composable
//fun JobCardView(jobInfo: JobInfo, expanded: Boolean, modifier: Modifier = Modifier, onClick: ()-> Unit)
//{
//    Card(
//        modifier = modifier,
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface))
//    {
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .padding(5.dp), verticalAlignment = Alignment.Top)
//        {
//            // here we benefit the use of classes: specifically the data class
//            Image(
//                painter = painterResource(jobInfo.jobCompanyLogo),
//                contentDescription = stringResource(R.string.job_description_1),
//                Modifier
//                    .height(50.dp)
//                    .width(50.dp)
//                    .clip(CircleShape)
//            )
//            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
//            Column(modifier = Modifier.weight(1f)) {
//                Text(stringResource(jobInfo.jobCategory),
//                    style = MaterialTheme.typography.headlineSmall
//                ) /// title
//                Text(stringResource(jobInfo.jobCompanyName), style = MaterialTheme.typography.titleLarge) //company name
//                Text(stringResource(jobInfo.jobLocation), style=MaterialTheme.typography.bodyMedium) // Location
//                Text("2025-02-12", style=MaterialTheme.typography.bodyMedium) // date of posting
//            }
//            IconButton(onClick = onClick) {
//                Icon(
//                    imageVector = if (expanded) Icons.Default.ExpandMore else Icons.Default.ExpandLess,
//                    contentDescription = null
//                )
//            }
//
//        }
//
//        if (!expanded)
//            Column(
//                modifier = modifier
//                    .padding(horizontal = 16.dp, 16.dp)
//                    .fillMaxWidth()
//                    .animateContentSize(
//                        spring(
//                            dampingRatio = Spring.DampingRatioNoBouncy,
//                            Spring.StiffnessHigh
//                        )
//                    ),
//
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            )
//            {
//                // Company Logo
//                Row(
//                    verticalAlignment = Alignment.Top
//                )
//                {
//                    Image(
//                        painter = painterResource(jobInfo.jobCompanyLogo),
//                        contentDescription = "Company Logo",
//                        modifier = Modifier
//                            //                    .size(100.dp)
//                            .height(120.dp)
//                            .weight(2f)
////                            .fillMaxWidth(1f)
////                            .align(Alignment.CenterHorizontally)
//                            .clip(RoundedCornerShape(8.dp)),
//                        contentScale = ContentScale.Crop
//                    )
//
//
//                }
//
//                // Company Name
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "Company: ",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobCompanyName),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                // Mission
//                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
//                    Text(
//                        text = "Mission:",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobCompanyMission),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//                //
//                //            // Website
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "Website: ",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobCompanyWebsite),
//                        style = MaterialTheme.typography.bodyMedium,
//                        color = MaterialTheme.colorScheme.primary
//                    )
//                }
//
//                // Category
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "Category: ",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobCategory),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                // Type
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "Type: ",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobType),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                // Experience Level
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "Experience: ",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobExperience),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                // Location
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(
//                        text = "Location: ",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobLocation),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                HorizontalDivider(
//                    modifier = Modifier.padding(vertical = 8.dp),
//                    color = MaterialTheme.colorScheme.outlineVariant
//                )
//
//                // Job Description
//                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
//                    Text(
//                        text = "Description:",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    Text(
//                        text = stringResource(jobInfo.jobDescription),
//                        style = MaterialTheme.typography.bodyMedium
//                    )
//                }
//
//                // Requirements
//                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
//                    Text(
//                        text = "Requirements:",
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurfaceVariant
//                    )
//                    stringArrayResource(jobInfo.jobRequirement).forEach { requirement ->
//                        Row(
//                            modifier = Modifier.padding(start = 8.dp),
//                            horizontalArrangement = Arrangement.spacedBy(8.dp)
//                        ) {
//                            Text(
//                                text = "•",
//                                style = MaterialTheme.typography.bodyMedium
//                            )
//                            Text(
//                                text = requirement,
//                                style = MaterialTheme.typography.bodyMedium
//                            )
//                        }
//                    }
//                }
//                Button(onClick={/**/}, modifier.fillMaxWidth()) {
//                    Text(text="Apply")
//                }
//                //            Spacer(modifier.padding(vertical = 10.dp))
//            }
//    }
//}

//@Composable
//fun MainAppLayout()
//{
//    var textFieldStat  = rememberTextFieldState()
//    var items = listOf(
//        "Tech", "Medicine"
//    )
//    Scaffold(
//        topBar = {
//            Row(modifier = Modifier.padding(horizontal = 2.dp), verticalAlignment = Alignment.CenterVertically){
//                Icon(
//                    imageVector = Icons.Default.Menu,
//                    contentDescription = "Menu",
//                )
//                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
//                JobAppTopBar(
//                    textFieldStat = textFieldStat,
//                    onSearch =  {/**/},
//                    searchResults = items,
//
//                    )
//            }
//
//        }
//    ) {
//        LazyColumn(contentPadding = it) { //verticalArrangement = Arrangement.spacedBy(40.dp),
//            items(DataSource().loadJobInfo()) { job->
//                MainJobView(
//                    jobInfo = job
//                )
//            }
//        }
//    }
//}

//@Preview
//@Composable
//fun JobScreenPreview(
//    viewModel : JobViewModel = viewModel()
//)
//{
//    // access the variables in viewModel
//    val userEmail by viewModel::userEmail
//    val userPasswd by viewModel::userPasswd
//    val userConfirmPasswd by viewModel::userConfirmPasswd
//    val signLoginBool by viewModel::signUpLogin
//
//
//    MyApplicationTheme(darkTheme = true) {
//        LoginAppLayout(userEmail, userPasswd, userConfirmPasswd, signLoginBool, viewModel)
//    }
//}

// for my routes am going to be using only 2:
enum class JobRoutes{
    LOGIN,
    JOBVIEW
}

@Composable
fun JobAPP(
    viewModel : JobViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
)
{
    // access the variables in viewModel
    val userEmail by viewModel::userEmail
    val userPasswd by viewModel::userPasswd
    val userConfirmPasswd by viewModel::userConfirmPasswd
    val toggleSignLoginBool by viewModel::signUpLogin
    val jobUiState by viewModel::jobUiState

    NavHost(
        navController = navController,
        startDestination = JobRoutes.LOGIN.name, //  Enum classes in Kotlin have a name property that returns a string with the property name.
        modifier = Modifier
    ) {
        composable(route = JobRoutes.LOGIN.name) {
            LoginAppLayout(
                userEmail,
                userPasswd,
                userConfirmPasswd,
                toggleSignLoginBool,
                viewModel,
                {
                    navController.navigate(
                JobRoutes.JOBVIEW.name)
                },
                modifier=Modifier
            )
        }
        composable(route = JobRoutes.JOBVIEW.name){
            JobAppLayout(
                jobUiState = jobUiState
            )
        }
    }


}

