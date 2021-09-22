package com.kampuni.liber.models.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name="titles")
data class Title(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @Column
    val titleName: String,

    @Column
    val titleDesc: String,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    val deptUnder: Department,

    @DateTimeFormat
    val createdAt: LocalDateTime = LocalDateTime.now().plusHours(3),

    @DateTimeFormat
    val updatedAt: LocalDateTime = LocalDateTime.now().plusHours(3)

)
