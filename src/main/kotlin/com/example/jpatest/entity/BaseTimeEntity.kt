package com.example.jpatest.entity

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.PATTERN_3)
    @Column(name = "created_at", updatable = false)
    lateinit var createdAt: LocalDateTime

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePattern.PATTERN_3)
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
}