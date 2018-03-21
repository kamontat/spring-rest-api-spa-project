package com.kamontat.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Course(@Id val id: String = "null", val name: String = "null", val description: String = "null", @ManyToOne var topic: Topic? = null) {
    fun dependOn(topic: Topic) {
        this.topic = topic
    }

    override fun toString(): String {
        return "Course(id='$id')"
    }

    override fun equals(other: Any?): Boolean {
        return id == (other as Course).id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}