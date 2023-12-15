package com.example.jpatest.repository

import com.example.jpatest.entity.DashboardList
import com.example.jpatest.entity.StateYn
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface DashboardListDao: JpaRepository<DashboardList, Long> {
    fun findByIdAndTenantNoAndDelYn(id: Long, tenantNo: Long, delYn: StateYn = StateYn.N): Optional<DashboardList>
    fun findByIdAndTenantNoAndUserNoAndDelYn(id: Long, tenantNo: Long, userNo: Long, delYn: StateYn = StateYn.N): Optional<DashboardList>
    fun existsByIdAndTenantNoAndUserNoAndDelYn(id: Long, tenantNo: Long, userNo: Long, delYn: StateYn = StateYn.N): Boolean
    fun existsByTenantNoAndUserNoAndTitleAndDelYn(tenantNo: Long, userNo: Long, title: String, delYn: StateYn = StateYn.N): Boolean
    fun existsByIdNotAndTenantNoAndUserNoAndTitleAndDelYn(id: Long, tenantNo: Long, userNo: Long, title: String, delYn: StateYn = StateYn.N): Boolean
}