package com.kampuni.liber.models.dtos

import com.kampuni.liber.models.entities.Department

data class TitleDTO(
    val titleName: String,
    val titleDesc: String,
    val deptUnder: Department
)
