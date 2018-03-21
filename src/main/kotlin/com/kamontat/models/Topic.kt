package com.kamontat.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Topic(@Id val id: String = "null", val name: String = "null", val description: String = "null") {
    override fun toString(): String {
        return "Topic(id='$id')"
    }

    override fun equals(other: Any?): Boolean {
        return id == (other as Topic).id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}