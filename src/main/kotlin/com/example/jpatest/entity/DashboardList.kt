package com.example.jpatest.entity

import jakarta.persistence.*

@Entity
@Table(name = "dashboard_list")
class DashboardList(
    @Column(name = "tenant_no")
    val tenantNo: Long,

    @Column(name = "user_no")
    val userNo: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "view_type")
    var viewType: ViewType,

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "del_yn")
    var delYn: StateYn = StateYn.N
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    val id: Long = 0L
}