package com.kampuni.liber.v1.services

import com.kampuni.liber.models.dtos.DeptDTO
import com.kampuni.liber.models.dtos.toDepartmentDTO
import com.kampuni.liber.models.entities.Dept
import com.kampuni.liber.models.requests.CreateUpdateDeptRequest
import com.kampuni.liber.models.requests.toDepartmentEntity
import com.kampuni.liber.repositories.DeptRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DepartmentService(private val deptRepo: DeptRepo, private val deptService: DeptService) {

    fun findDeptById(id: Long): DeptDTO? = deptRepo.findByIdOrNull(id)?.toDepartmentDTO()

    fun findAllDept(pageable: Pageable): Page<DeptDTO> = deptRepo.findAll(pageable).map(Dept::toDepartmentDTO)

    fun createDept(createUpdateDeptRequest: CreateUpdateDeptRequest){
        deptRepo.save(createUpdateDeptRequest.toDepartmentEntity(deptService))

    }
    fun updateDeptById(deptId: Long, createUpdateDeptRequest: CreateUpdateDeptRequest){
        if (deptRepo.existsById(deptId)){
            deptRepo.save(
                Dept(
                    deptName = createUpdateDeptRequest.deptName,
                    deptDesc = createUpdateDeptRequest.deptDesc,
                    parentDept = deptService.findDeptTitleReq(createUpdateDeptRequest.parentDept)
                )
            )
        } else {
            throw IllegalStateException("Department of $deptId not found")
        }
    }

    fun deleteDeptById(deptId: Long){
        if (deptRepo.existsById(deptId)){
            deptRepo.deleteById(deptId)
        } else{
            throw IllegalStateException("Department of $deptId not found")
        }
    }
    fun findDeptByIdReq(id: Long): Dept? = deptRepo.findByIdOrNull(id)

}

@Service
class DeptService(private val deptRepo: DeptRepo){
    fun findDeptByIdReq(id: Long): Dept? = deptRepo.findByIdOrNull(id)

    fun findDeptTitleReq(deptId: Long): Dept{
        val dept = deptRepo.findById(deptId).orElseThrow{
            IllegalStateException("Department of $deptId not found")
        }
        return dept
    }
}
