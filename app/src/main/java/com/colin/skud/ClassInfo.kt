package com.colin.skud

import com.google.gson.annotations.SerializedName


data class ClassInfo (
    @SerializedName("classroomName") val classroomName: String?,
    @SerializedName("classroomType") val classroomType: String?
)
