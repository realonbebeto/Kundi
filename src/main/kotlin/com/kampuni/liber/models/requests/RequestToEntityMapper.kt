package com.kampuni.liber.models.requests

import com.kampuni.liber.models.entities.Department

fun CreateUpdateDepartmentRequest.toDepartmentEntity(): Department = Department(
    deptName = this.deptName,
    deptDesc = this.deptDesc,

)