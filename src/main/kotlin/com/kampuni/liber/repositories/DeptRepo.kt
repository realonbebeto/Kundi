package com.kampuni.liber.repositories

import com.kampuni.liber.models.entities.Dept
import org.springframework.data.jpa.repository.JpaRepository

interface DeptRepo: JpaRepository<Dept, Long> {
}