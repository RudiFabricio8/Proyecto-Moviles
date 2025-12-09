package com.example.proyecto.domain.model

data class UserProfile(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val isTalent: Boolean = true,
    val photoUrl: String? = null,
    val description: String? = null
)

data class Opportunity(
    val id: String = "",
    val title: String = "",
    val company: String = "",
    val status: String = "Open",
    val datePosted: String = ""
)
