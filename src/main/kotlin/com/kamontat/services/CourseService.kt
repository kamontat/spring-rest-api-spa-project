package com.kamontat.services

import com.kamontat.models.Course
import com.kamontat.repositorys.CoursesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseService {

    @Autowired
    private lateinit var courseRepository: CoursesRepository

    @Autowired
    private lateinit var topicService: TopicService

    // private var topics: List<Course> = FakeCourseCreator.getList(20)

    fun getAllCourse(topicID: String): List<Course> {
        // return topics
        return courseRepository.findAll().filter { it.topic?.id == topicID }
    }

    fun getCourseID(topicID: String, courseID: String): Course? {
        // return topics.firstOrNull { it.id == id }
        return getAllCourse(topicID).firstOrNull { it.id == courseID }
    }

    fun addCourse(topicID: String, course: Course) {
        // topics = topics.plus(topic)
        course.dependOn(topicService.getTopicID(topicID))
        courseRepository.save(course)
    }

    fun updateCourse(topicID: String, courseID: String, course: Course) {
        // topics = topics.map {
        //     if (it.id == id) topic else it
        // }
        deleteCourse(courseID)
        addCourse(topicID, course)
    }

    fun deleteCourse(courseID: String) {
        // topics = topics.minus(Course(id))
        courseRepository.deleteById(courseID)
    }
}
