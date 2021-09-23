package com.kampuni.liber.models.dtos

import com.kampuni.liber.models.entities.Dept

data class TitleDTO(
    val titleName: String,
    val titleDesc: String,
    val deptUnder: Dept
)
