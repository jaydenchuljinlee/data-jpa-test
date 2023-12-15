package com.example.jpatest.entity

import jakarta.persistence.*


@Entity
@Table(name = "dashboard_chart")
class DashboardChart(
    @Column(name = "dashboard_id")
    val dashboardId: Long,

    @Column(name = "dashboard_page_id")
    var dashboardPageId: Long,

    @Column(name = "chart_code")
    val chartCode: String,

    @Column(name = "base_date")
    var baseDate: String?,

    @Column(name = "view_x")
    var viewX: Int,

    @Column(name = "view_y")
    var viewY: Int,

    @Column(name = "view_w")
    var viewW: Int,

    @Column(name = "view_h")
    var viewH: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "del_yn")
    var delYn: StateYn = StateYn.N
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    val id: Long = 0L
}