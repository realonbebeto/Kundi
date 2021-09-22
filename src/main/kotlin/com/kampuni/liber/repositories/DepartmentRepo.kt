package com.kampuni.liber.repositories

import com.kampuni.liber.models.entities.Department
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DepartmentRepo: JpaRepository<Department, UUID> {
}