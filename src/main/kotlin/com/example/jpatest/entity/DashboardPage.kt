package com.example.jpatest.entity

import jakarta.persistence.*

@Entity
@Table(name = "dashboard_page")
class DashboardPage(
//    @Column(name = "dashboard_id")
//    val dashboardId: Long,
//
//    @Column(name = "title")
//    var title: String? = null,
//
//    @Column(name = "description")
//    var description: String? = null,
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "del_yn")
//    var delYn: StateYn = StateYn.N
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    var id: Long = 0L
}