package com.kamontat.services

import com.kamontat.models.Topic
import com.kamontat.repositorys.TopicRepository
import com.kamontat.utils.FakeTopicCreator
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*
import kotlin.NoSuchElementException

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestTopicService {
    @MockBean
    private lateinit var topicRepository: TopicRepository

    @Autowired
    private lateinit var topicService: TopicService

    @Before
    fun setUp() {
        Mockito.`when`(topicRepository.findAll()).thenReturn(
                Arrays.asList(
                        Topic("123"),
                        Topic("124"),
                        Topic("125"),
                        Topic("126")
                )
        )

        Mockito.`when`(topicRepository.findById("123")).thenReturn(
                Optional.of(Topic("123"))
        )

        Mockito.`when`(topicRepository.findById("120")).thenReturn(
                Optional.empty()
        )
    }

    @Test
    fun shouldInsertCompleted() {
        Assert.assertEquals(4, topicService.getAllTopic().count())
    }

    @Test(expected = NoSuchElementException::class)
    fun shouldBeEmptyTopic() {
        topicService.getTopicID("120")
    }

    @Test
    fun shouldGetIndvTopic() {
        Assert.assertEquals(Topic("123"), topicService.getTopicID("123"))
    }
}