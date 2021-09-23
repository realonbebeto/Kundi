package com.kampuni.liber.v1.controllers

import com.kampuni.liber.models.dtos.DeptDTO
import com.kampuni.liber.models.requests.CreateUpdateDeptRequest
import com.kampuni.liber.v1.services.DepartmentService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/dept")
class DeptController(private val departmentService: DepartmentService) {
    @GetMapping("/{deptId}")
    fun getDeptById(@RequestParam deptId: Long): ResponseEntity<DeptDTO?>{
        val deptDTO = departmentService.findDeptById(deptId)

        return ResponseEntity.status(HttpStatus.OK).body(deptDTO)
    }

    @GetMapping("/all")
    fun getAllDept(pageable: Pageable): ResponseEntity<Page<DeptDTO>>{
        return ResponseEntity.ok(departmentService.findAllDept(pageable))
    }

    @PostMapping
    fun createDept(@RequestBody createUpdateDeptRequest: CreateUpdateDeptRequest){
        departmentService.createDept(createUpdateDeptRequest)
    }

    @PutMapping
    fun updateDeptById(@RequestParam deptId: Long, @RequestBody createUpdateDeptRequest: CreateUpdateDeptRequest){
        departmentService.updateDeptById(deptId, createUpdateDeptRequest)
    }

    @DeleteMapping
    fun deleteDeptById(@RequestParam deptId: Long){
        departmentService.deleteDeptById(deptId)
    }
}