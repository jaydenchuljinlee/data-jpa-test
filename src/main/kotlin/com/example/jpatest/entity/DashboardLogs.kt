package com.example.jpatest.entity

import jakarta.persistence.*

@Entity
@Table(name = "dashboard_logs")
class DashboardLogs(
    @Column(name = "dashboard_id")
    val dashboardId: Long,

    @Column(name = "tenant_no")
    val tenantNo: Long,

    @Column(name = "user_no")
    val userNo: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "log_type")
    val logType: LogType,

    @Column(name = "log_detail")
    val logDetail: String
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    val id: Long = 0L
}