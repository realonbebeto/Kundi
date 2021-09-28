package com.kampuni.liber.models.requests

import com.kampuni.liber.models.entities.Dept
import com.kampuni.liber.models.entities.Title
import com.kampuni.liber.v1.services.DepartmentService
import com.kampuni.liber.v1.services.DeptService

fun CreateUpdateDeptRequest.toDepartmentEntity(deptService: DeptService): Dept {
    return Dept(
        deptName = this.deptName,
        deptDesc = this.deptDesc,
        parentDept = deptService.findDeptByIdReq(this.parentDept)
    )
}

fun CreateUpdateTitleRequest.toTitleEntity(deptService: DeptService): Title = Title(
    titleName = this.titleName,
    titleDesc = this.titleDesc,
    deptUnder = deptService.findDeptTitleReq(this.deptUnder)
)