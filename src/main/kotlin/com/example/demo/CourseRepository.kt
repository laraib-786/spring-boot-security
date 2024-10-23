package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course,Int>