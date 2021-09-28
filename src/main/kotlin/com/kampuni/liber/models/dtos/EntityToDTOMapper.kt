package com.kampuni.liber.models.dtos

import com.kampuni.liber.models.entities.Dept
import com.kampuni.liber.models.entities.Title

fun Dept.toDepartmentDTO(): DeptDTO = DeptDTO(
    deptName = this.deptName,
    desc = this.deptDesc,
    titles = this.titles,
    parentDept = this.parentDept,
    linkedDepts = this.linkedDepts
)

fun Title.toTitleDTO(): TitleDTO = TitleDTO(
    titleName = this.titleName,
    titleDesc = this.titleDesc,
    deptUnder = this.deptUnder
)