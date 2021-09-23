package com.kampuni.liber.repositories

import com.kampuni.liber.models.entities.Title
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TitleRepo: JpaRepository<Title, Long> {
}