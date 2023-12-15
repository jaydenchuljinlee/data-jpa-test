package com.example.jpatest.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Hello(
    @Id
    val a: Long,
)