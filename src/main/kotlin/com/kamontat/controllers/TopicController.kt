package com.kamontat.controllers

import com.kamontat.models.Topic
import com.kamontat.services.TopicService
import com.kamontat.utils.FakeTopicCreator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TopicController {
    @Autowired
    private lateinit var topicService: TopicService

    @RequestMapping("/topics")
    fun getAllTopic(): List<Topic> {
        return topicService.getAllTopic()
    }

    @RequestMapping("/topics/count")
    fun getCountTopic(): Int {
        return topicService.getAllTopic().count()
    }

    @RequestMapping("/topic/{id}")
    fun getTopic(@PathVariable id: String): Topic? {
        return topicService.getTopicID(id)
    }

    @RequestMapping("/topic", method = [RequestMethod.POST])
    fun addTopic(@RequestBody topic: Topic) {
        topicService.addTopic(topic)
    }

    @RequestMapping("/topic/{id}", method = [RequestMethod.PUT])
    fun updateTopic(@PathVariable id: String, @RequestBody topic: Topic) {
        topicService.updateTopic(id, topic)
    }

    @RequestMapping("/topic/{id}", method = [RequestMethod.DELETE])
    fun deleteTopic(@PathVariable id: String) {
        topicService.deleteTopic(id)
    }
}