package com.kamontat.repositorys

import com.kamontat.models.Topic
import org.springframework.data.repository.CrudRepository

interface TopicRepository : CrudRepository<Topic, String> {

}