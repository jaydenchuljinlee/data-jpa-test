--CREATE TABLE `dashboard_list` (
--  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Unique ID',
--  `tenant_no` bigint NOT NULL COMMENT 'Tenant ID',
--  `user_no` bigint NOT NULL COMMENT '회원 ID',
--  `view_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '레이아웃 타입(L2: 2단, L4: 4단)',
--  `title` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '대시보드 제목',
--  `description` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '대시보드 설명',
--  `del_yn` enum('Y','N') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'N' COMMENT '삭제 여부 (Y/N)',
--  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록 일시',
--  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시',
--  PRIMARY KEY (`id`),
--  KEY `idx_tenant_id_user_id_del_yn` (`tenant_no`,`user_no`,`del_yn`) USING BTREE
--) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='개인 대시보드 목록 관리';
INSERT INTO dashboard_list(tenant_no, user_no, view_type, title, description, del_yn) VALUES(2, 60, 'L2', '대시보드 제목 Init', '대시보드 설명 Init');