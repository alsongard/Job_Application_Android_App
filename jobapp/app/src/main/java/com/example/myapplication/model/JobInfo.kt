package com.example.myapplication.model

import androidx.annotation.ArrayRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class JobInfo(
    @StringRes val jobCategory: Int,
    @StringRes val jobType:Int,
    @StringRes val jobExperience:Int,
//    @StringRes val jobLocation:Int?,
    @StringRes val jobLocation:Int,
    @StringRes val jobApplicationDeadline: Int,
    @StringRes val jobCompanyName:Int,
    @StringRes val jobCompanyWebsite:Int,
    @StringRes val jobCompanyMission:Int,
    @StringRes val jobDescription: Int,
    @ArrayRes val jobRequirement: Int,
    @DrawableRes val jobCompanyLogo :Int
)
