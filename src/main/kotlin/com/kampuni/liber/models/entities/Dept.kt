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
class Dept(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @NotNull
    @Column
    var deptName: String,

    @Column
    var deptDesc: String,

    @JsonManagedReference
    @OneToMany(mappedBy = "deptUnder", fetch = FetchType.LAZY)
    val titles: List<Title>? = null,

    @JsonBackReference
    @ManyToOne(cascade=[CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name="parentDept")
    var parentDept: Dept? = null,

    @OneToMany(mappedBy="parentDept", fetch = FetchType.LAZY)
    val linkedDepts: MutableSet<Dept> = HashSet<Dept>(),

    @DateTimeFormat
    val createdAt: LocalDateTime = LocalDateTime.now().plusHours(3),

    @DateTimeFormat
    val updatedAt: LocalDateTime = LocalDateTime.now().plusHours(2),
)
