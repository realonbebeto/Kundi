package com.kampuni.liber.models.requests

data class CreateUpdateDeptRequest(
    val deptName: String,
    val deptDesc: String,
    val parentDept: Long
)