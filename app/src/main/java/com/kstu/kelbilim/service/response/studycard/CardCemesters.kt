package com.kstu.kelbilim.service.response.studycard

import com.google.gson.annotations.SerializedName


data class CardCemesters (
    @SerializedName("CemesterID") val cemesterID : Int,
    @SerializedName("CemesterName") val cemesterName : String,
    @SerializedName("StudyYearID") val studyYearID : Int,
    @SerializedName("NoteID") val noteID : Int,
    @SerializedName("Note") val note : String,
    @SerializedName("Diciplines") val diciplines : List<CardDiciplines>
)