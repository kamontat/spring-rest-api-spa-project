package com.kamontat.utils

import com.kamontat.models.Topic
import java.util.*

class FakeTopicCreator {
    companion object {
        private val rand = RandomImp()
        fun get(): Topic {
            return Topic(rand.getString(), rand.getString(), rand.getString(50, 200))
        }

        fun getArray(number: Int): Array<Topic> {
            return Array(number, { get() })
        }

        fun getList(number: Int): List<Topic> {
            return List(number, { get() })
        }
    }
}
