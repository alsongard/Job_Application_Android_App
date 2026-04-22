package com.example.myapplication.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.data.DataSource
import com.example.myapplication.ui.theme.JobViewModel
import com.example.myapplication.model.JobInfo
import kotlinx.coroutines.Job


@Composable
fun MainJobView(modifier: Modifier = Modifier, jobInfo: JobInfo) {
    var expanded by remember { mutableStateOf(true) }
    Card(
        modifier = modifier.padding(vertical = 20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    )
    {
        JobCardView(jobInfo, expanded = expanded, onClick = { expanded = !expanded })
    }
}


@Composable
fun JobCardView(jobInfo: JobInfo, expanded: Boolean, modifier: Modifier = Modifier, onClick: ()-> Unit)
{
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface))
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), verticalAlignment = Alignment.Top)
        {
            // here we benefit the use of classes: specifically the data class
            Image(
                painter = painterResource(jobInfo.jobCompanyLogo),
                contentDescription = stringResource(R.string.job_description_1),
                Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(stringResource(jobInfo.jobCategory),
                    style = MaterialTheme.typography.headlineSmall
                ) /// title
                Text(stringResource(jobInfo.jobCompanyName), style = MaterialTheme.typography.titleLarge) //company name
                Text(stringResource(jobInfo.jobLocation), style=MaterialTheme.typography.bodyMedium) // Location
                Text("2025-02-12", style=MaterialTheme.typography.bodyMedium) // date of posting
            }
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = if (expanded) Icons.Default.ExpandMore else Icons.Default.ExpandLess,
                    contentDescription = null
                )
            }

        }

        if (!expanded)
            Column(
                modifier = modifier
                    .padding(horizontal = 16.dp, 16.dp)
                    .fillMaxWidth()
                    .animateContentSize(
                        spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            Spring.StiffnessHigh
                        )
                    ),

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
                    stringArrayResource(jobInfo.jobRequirement).forEach { requirement ->
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobAppTopBar(
    textFieldStat: TextFieldState,
    onSearch: (String)->Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier
)
{
    var searchExpanded by rememberSaveable { mutableStateOf(false)}

    SearchBar(
        modifier = modifier,
        inputField = {
            SearchBarDefaults.InputField(
                query = textFieldStat.text.toString(),
                onQueryChange = { textFieldStat.edit { replace(0, length, it) } },
                onSearch = {
                    onSearch(textFieldStat.text.toString())

                },

                expanded = searchExpanded,
                onExpandedChange = {searchExpanded = it},
                placeholder = { "Search" },
                leadingIcon = {}
            )
        },

        expanded = searchExpanded,
        onExpandedChange = { searchExpanded = it },
    )
    {
    }
}

@Preview
//@PreviewParameter
@Composable
fun MainAppPreviewLayout(
    jobUiState: JobUiState = JobUiState.Loading
)
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
                MainJobView(
                    jobInfo = job
                )
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier)
{
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "loading",
        modifier.size(200.dp)
    )
}

@Composable
fun ErrorScreen(modifier: Modifier)
{
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error),
            contentDescription = ""
        )
        Text("Error loading job info")
    }
}

@Composable
fun JobInfoScreen(modifier: Modifier)
{

}
@Composable
fun JobAppLayout(
    jobUiState: JobUiState
)
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
    )
    {
        innerPadding  ->
        Box (modifier =  Modifier.padding(innerPadding))
        {
            // when using is be carefull to check the types and not the data itself
            when (jobUiState) {
                is JobUiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxWidth())
                is JobUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxWidth())
                is JobUiState.Success -> {
                    LazyColumn() { //verticalArrangement = Arrangement.spacedBy(40.dp),
                        items(DataSource().loadJobInfo()) { job->
                            MainJobView(
                                jobInfo = job
                            )
                        }
                    }
                }
            }
        }

    }
}
