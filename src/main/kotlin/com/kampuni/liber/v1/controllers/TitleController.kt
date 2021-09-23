package com.kampuni.liber.v1.controllers

import com.kampuni.liber.models.dtos.TitleDTO
import com.kampuni.liber.models.entities.Title
import com.kampuni.liber.models.requests.CreateUpdateTitleRequest
import com.kampuni.liber.v1.services.TitleService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/title")
class TitleController(private val titleService: TitleService) {

    @GetMapping("/{titleId}")
    fun getTitleById(@RequestParam titleId: Long): ResponseEntity<TitleDTO?>{
        val titleDTO = titleService.findTitleById(titleId)
        return ResponseEntity.status(HttpStatus.OK).body(titleDTO)
    }

    @GetMapping("/all")
    fun getAllTitle(pageable: Pageable): ResponseEntity<Page<TitleDTO>>{
        return ResponseEntity.ok(titleService.findAllTitle(pageable))
    }

    @PostMapping
    fun createTitle(@RequestBody createUpdateTitleRequest: CreateUpdateTitleRequest){
        titleService.createTitle(createUpdateTitleRequest)
    }

    @PutMapping
    fun updateTitleById(@RequestParam titleId: Long, @RequestBody createUpdateTitleRequest: CreateUpdateTitleRequest){
        titleService.updateDeptById(titleId, createUpdateTitleRequest)
    }

    @DeleteMapping
    fun deleteTitleById(@RequestParam titleId: Long){
        titleService.deleteTitleById(titleId)
    }
}