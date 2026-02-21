package com.example.myapplication.data
import com.example.myapplication.R
import com.example.myapplication.model.JobInfo
import kotlinx.coroutines.Job

class DataSource() {
    fun loadJobInfo(): List<JobInfo> // return type is going to be a list of JobInfo objects/Instances
    {
        return listOf<JobInfo>(
            JobInfo(R.string.job_category_3, R.string.type_3, R.string.experience_level_3,R.string.location_3, R.string.application_deadline_3, R.string.company_name_3, R.string.website_3, R.string.mission_3,R.string.job_description_3, R.array.job_requirements_1,  R.drawable.the_manufacturing_process_of_solar_panels_2656823962),
            JobInfo(R.string.job_category_2, R.string.type_2, R.string.experience_level_2,R.string.location_2, R.string.application_deadline_2, R.string.company_name_2, R.string.website_2, R.string.mission_2,R.string.job_description_2, R.array.job_requirements_2, R.drawable.netflix_mobile_application_logo_free_png),
            JobInfo(R.string.job_category_1, R.string.type_1, R.string.experience_level_1,R.string.location_1, R.string.application_deadline_1, R.string.company_name_1, R.string.website_1, R.string.mission_1,R.string.job_description_1, R.array.job_requirements_3, R.drawable.google_logo),
            JobInfo(R.string.job_category_4, R.string.type_4, R.string.experience_level_4,R.string.location_4, R.string.application_deadline_4, R.string.company_name_4, R.string.website_4, R.string.mission_4,R.string.job_description_4, R.array.job_requirements_4, R.drawable.ux_ui_log),
            JobInfo(R.string.job_category_5, R.string.type_5, R.string.experience_level_5,R.string.location_5, R.string.application_deadline_5, R.string.company_name_5, R.string.website_5, R.string.mission_5,R.string.job_description_5, R.array.job_requirements_5, R.drawable.cybersecurity_logo),
        )
    }
}


/*
* How to create your data class
* within the same package, add new package called, com.example.package.model
* in the model package and a new kotlin class: data class
* add the above
* */