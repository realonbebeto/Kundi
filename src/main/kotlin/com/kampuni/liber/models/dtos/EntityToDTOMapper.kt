package com.kampuni.liber.models.dtos

import com.kampuni.liber.models.entities.Department
import com.kampuni.liber.models.entities.Title

fun Department.toDepartmentDTO(): DepartmentDTO = DepartmentDTO(
    deptName = this.deptName,
    desc = this.deptDesc,
    titles = this.titles
)

fun Title.toTitleDTO(): TitleDTO = TitleDTO(
    titleName = this.titleName,
    titleDesc = this.titleDesc,
    deptUnder = this.deptUnder
)