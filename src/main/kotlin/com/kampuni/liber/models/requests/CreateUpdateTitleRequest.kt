package com.kampuni.liber.models.requests

import java.util.*

data class CreateUpdateTitleRequest(
    val titleName: String,
    val titleDesc: String,
    val deptUnder: Long
)
