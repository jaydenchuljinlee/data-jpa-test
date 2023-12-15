package com.example.jpatest

import com.example.jpatest.entity.DashboardList
import com.example.jpatest.entity.ViewType
import com.example.jpatest.repository.DashboardListDao
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.PersistenceContext
import jakarta.persistence.PersistenceContextType
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import org.testcontainers.containers.MySQLContainer

// @Sql("/resources/data.sql") // 해당 Annotation 을 사용하게 되면, 모든 메서드에서 쿼리가 날라가게 된다.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@DataJpaTest
class JpaTest {
    @PersistenceContext
    private lateinit var entityManager: EntityManager
    @Autowired
    private lateinit var repository: DashboardListDao

    private final val MYSQL_IMAGE = "mysql:8"
    protected val MYSQL_CONTAINER = MySQLContainer(MYSQL_IMAGE)

    @BeforeAll
    fun before() {
        MYSQL_CONTAINER.start()
    }

    @AfterAll
    fun after() {
        MYSQL_CONTAINER.stop()
    }

    @Autowired
    private lateinit var entityManager_autowired: EntityManager

    @Test
    fun ENTITY_MANAGER를_AUTOWIRED로_선언한다() {
        println("autowired => $entityManager_autowired")
    }

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private lateinit var entityManager_extend: EntityManager
    @PersistenceContext
    private lateinit var entityManager_transaction: EntityManager

    @Test
    fun ENTITY_MANAGER를_ENTENDED로_선언한다() {
        println("EXTENDED => $entityManager_extend")
    }

    @Test
    fun ENTITY_MANAGER를_TRANSACTION으로_선언한다() {
        println("TRANSACTION => $entityManager_transaction")
    }



    @Test
    fun 엔티티_저장_테스트() {
        // given
        val entity_1 = DashboardList(2, 60, ViewType.L2, "대시보드 제목 1", "대시보드 설명 1", )

        entityManager.persist(entity_1)

        val entity_2 = DashboardList(2, 60, ViewType.L2, "대시보드 제목 2", "대시보드 설명 2", )

        entityManager.persist(entity_2)

        val entity_3 = DashboardList(2, 60, ViewType.L2, "대시보드 제목 3", "대시보드 설명 3", )

        entityManager.persist(entity_3)

        // when
        val list = repository.findAll()

        assert(list.size == 3)
        assert(entity_1 == list[0])
    }

    @Test
    fun IDENTITY_전략은_쓰기_지연_없이_바로_INSERT_하여_프린트보다_먼저_찍히게된다() {
        val dashboardList = DashboardList(2, 60, ViewType.L2, "대시보드 제목 1", "대시보드 설명 1", )
        repository.save(dashboardList)
        println("이 메시지는 INSERT 쿼리 로그 뒤에 찍힌다.") // 원래 JPA 는 쓰기 지연을 지원하여 로그가 먼저 찍혀야하지만, IDENTITY 전략은 실제 저장을 해야 식별자를 구별할 수 있기 때문에 insert 쿼리가 즉시 날아간다.
    }

    @Test
    fun UPDATE_쿼리는_트랜잭션이_종료된_후에_발생하여_프린트보다_나중에_찍힌다() {
        val dashboardList = 리파지토리에_등록하고_정보를_가져온다()

        dashboardList.title = "타이틀 수정"

        repository.delete(dashboardList)
        println("이 메시지는 UPDATE 쿼리 로그 앞에 찍힌다.")
        // entityManager.flush() // flush 를 안 해주면 update 쿼리가 나가지 않는데, 그 이유는 조금 더 분석해봐야할 것 같다.
    }

    @Test
    fun 리파지토리에_등록하고_정보를_가져온다(): DashboardList {
        val dashboardList = DashboardList(2, 60, ViewType.L2, "대시보드 제목 1", "대시보드 설명 1", )

        repository.saveAndFlush(dashboardList)
        entityManager.clear()
        val target = repository.findById(dashboardList.id)

        assert(target.isPresent)

        return target.get()
    }

}