package com.kamontat.repositorys

import com.kamontat.models.Course
import com.kamontat.models.Topic
import org.springframework.data.repository.CrudRepository

interface CoursesRepository : CrudRepository<Course, String> {

}