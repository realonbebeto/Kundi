package com.kampuni.liber.models.requests

class CreateUpdateDeptRequest(
    val deptName: String,
    val deptDesc: String,
    var parentDept: Long
)
