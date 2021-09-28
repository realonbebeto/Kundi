
package com.kampuni.liber.v1.services

import com.kampuni.liber.models.dtos.TitleDTO
import com.kampuni.liber.models.dtos.toTitleDTO
import com.kampuni.liber.models.entities.Title
import com.kampuni.liber.models.requests.CreateUpdateTitleRequest
import com.kampuni.liber.models.requests.toTitleEntity
import com.kampuni.liber.repositories.TitleRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TitleService(private val titleRepo: TitleRepo,
                   private val deptService: DeptService) {

    fun findTitleById(titleId: Long): TitleDTO? = titleRepo.findByIdOrNull(titleId)?.toTitleDTO()

    fun findAllTitle(pageable:Pageable): Page<TitleDTO> = titleRepo.findAll(pageable).map(Title::toTitleDTO)

    fun createTitle(createUpdateTitleRequest: CreateUpdateTitleRequest){
        titleRepo.save(createUpdateTitleRequest.toTitleEntity(deptService))
    }

    fun updateDeptById(titleId:Long, createUpdateTitleRequest: CreateUpdateTitleRequest){
        if(titleRepo.existsById(titleId)){
            titleRepo.save(
                Title(
                    titleName = createUpdateTitleRequest.titleName,
                    titleDesc = createUpdateTitleRequest.titleDesc,
                    deptUnder = deptService.findDeptTitleReq(createUpdateTitleRequest.deptUnder)
                )
            )
        } else throw IllegalStateException("Title of $titleId not found")

    }

    fun deleteTitleById(titleId: Long){
        if(titleRepo.existsById(titleId)){
            titleRepo.deleteById(titleId)
        } else throw IllegalStateException("Title of $titleId not found")
    }
}