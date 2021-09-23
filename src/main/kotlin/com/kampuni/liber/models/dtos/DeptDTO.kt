package com.kampuni.liber.models.dtos

import com.kampuni.liber.models.entities.Title

data class DeptDTO(
    val deptName: String,
    val desc: String,
    val titles: List<Title>?
)
