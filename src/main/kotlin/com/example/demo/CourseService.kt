package com.example.demo

import org.springframework.stereotype.Service

@Service
class CourseService( val courseRepository: CourseRepository) {

    fun addCourse(courseDTO: CourseDTO): CourseDTO {
         val course = courseDTO.let { courseDTO -> Course(null,courseDTO.name,courseDTO.category) }
        courseRepository.save(course)

        return CourseDTO(course.id,course.name,course.category)
    }
}