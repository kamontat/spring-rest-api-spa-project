package com.kamontat.services

import com.kamontat.models.Topic
import com.kamontat.repositorys.TopicRepository
import com.kamontat.utils.FakeTopicCreator
import com.kamontat.utils.RandomImp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TopicService {

    @Autowired
    private lateinit var topicRepository: TopicRepository

    // private var topics: List<Topic> = FakeTopicCreator.getList(20)

    fun getAllTopic(): List<Topic> {
        // return topics
        return topicRepository.findAll().toList()
    }

    @Throws(NoSuchElementException::class)
    fun getTopicID(id: String): Topic {
        // return topics.firstOrNull { it.id == id }
        return topicRepository.findById(id).get()
    }

    fun addTopic(topic: Topic) {
        // topics = topics.plus(topic)
        topicRepository.save(topic)
    }

    fun updateTopic(id: String, topic: Topic) {
        // topics = topics.map {
        //     if (it.id == id) topic else it
        // }
        deleteTopic(id)
        addTopic(topic)
    }

    fun deleteTopic(id: String) {
        // topics = topics.minus(Topic(id))
        topicRepository.deleteById(id)
    }
}
