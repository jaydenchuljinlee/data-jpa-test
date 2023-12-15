package com.example.jpatest.entity

import jakarta.persistence.*

@Entity
@Table(name = "dashboard_share_info")
class DashboardShareInfo(
    @Column(name = "dashboard_id")
    val dashboardId: Long,

    @Column(name = "tenant_no")
    val tenantNo: Long,

    @Column(name = "user_no")
    val userNo: Long,

    @Column(name = "user_no_sb")
    val userNoSb: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "del_yn")
    private var delYn: StateYn = StateYn.N
): BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    val id: Long = 0L

    fun setDelYn(stateYn: StateYn) {
        this.delYn = stateYn
    }
}