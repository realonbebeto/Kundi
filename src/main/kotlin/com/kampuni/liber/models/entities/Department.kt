package com.kampuni.liber.models.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.jetbrains.annotations.NotNull
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name="departments")
data class Department(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @Column
    val deptName: String,

    @Column
    val deptDesc: String,

    @JsonManagedReference
    @OneToMany(mappedBy = "deptUnder", fetch = FetchType.LAZY)
    val titles: List<Title>? =null,

    @JsonBackReference
    @ManyToOne(cascade=[CascadeType.ALL])
    @JoinColumn(name="parentDepartment")
    val parentDept: Department,

    @OneToMany(mappedBy="parentDept")
    val linkedDepts: MutableSet<Department> = HashSet<Department>(),

    @DateTimeFormat
    val createdAt: LocalDateTime = LocalDateTime.now().plusHours(3),

    @DateTimeFormat
    val updatedAt: LocalDateTime = LocalDateTime.now().plusHours(2)

)
