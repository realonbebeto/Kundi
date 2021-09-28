package com.kampuni.liber.models.requests

import com.kampuni.liber.models.entities.Dept
import com.kampuni.liber.models.entities.Title
import com.kampuni.liber.v1.services.DeptService


fun CreateUpdateDeptRequest.toDepartmentEntity(deptService: DeptService): Dept = Dept(
    deptName = this.deptName,
    deptDesc = this.deptDesc,
    parentDept = deptService.findDeptTitleReq(this.parentDept)
)
fun CreateUpdateTitleRequest.toTitleEntity(deptService: DeptService): Title = Title(
    titleName = this.titleName,
    titleDesc = this.titleDesc,
    deptUnder = deptService.findDeptTitleReq(this.deptUnder)
)