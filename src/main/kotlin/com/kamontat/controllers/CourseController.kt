package com.kamontat.controllers

import com.kamontat.models.Course
import com.kamontat.services.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CourseController {
    @Autowired
    private lateinit var courseService: CourseService

    @RequestMapping("/topic/{id}/courses")
    fun getAllCourse(@PathVariable id: String): List<Course> {
        return courseService.getAllCourse(id)
    }

    @RequestMapping("/topic/{id}/courses/count")
    fun getCountCourse(@PathVariable id: String): Int {
        return courseService.getAllCourse(id).count()
    }

    @RequestMapping("/topic/{topicID}/course/{courseID}")
    fun getCourse(@PathVariable topicID: String, @PathVariable courseID: String): Course? {
        return courseService.getCourseID(topicID, courseID)
    }

    @RequestMapping("/topic/{topicID}/course", method = [RequestMethod.POST])
    fun addCourse(@PathVariable topicID: String, @RequestBody course: Course) {
        courseService.addCourse(topicID, course)
    }

    @RequestMapping("/topic/{topicID}/course/{id}", method = [RequestMethod.PUT])
    fun updateCourse(@PathVariable topicID: String, @PathVariable id: String, @RequestBody course: Course) {
        courseService.updateCourse(topicID, id, course)
    }

    @RequestMapping("/topic/{topicID}/course/{id}", method = [RequestMethod.DELETE])
    fun deleteCourse(@PathVariable id: String) {
        courseService.deleteCourse(id)
    }
}