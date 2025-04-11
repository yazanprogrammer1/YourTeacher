package com.example.yourteacher.domain.model

data class TeacherUiModel(
    val id: String,
    val name: String,
    val subject: String,
    val grade: String,
    val price: String?, // ممكن تكون null
    val schedule: String,
    val location: String,
    val imageUrl: String?
)
