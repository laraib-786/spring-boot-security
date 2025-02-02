package com.example.demo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "course")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    val id: Int?,

    @Column(name = "name")
    val name: String,

    @Column(name = "category")
    val category: String?
){

}
