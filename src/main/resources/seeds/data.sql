-- 사용자 sample(password: somoim1! - $2a$10$Ts3sJwz1Kb6SthoCCQ56Cu7T7fG6vho0DBxoCBr0kdZcAg.Y.Cb.6)
INSERT INTO somoim.user(id, email, password, name, birth, gender, city_code1, city_code2, image_id, create_at, modify_at, disband)
VALUES(1, 'user1@example.com', '$2a$10$Ts3sJwz1Kb6SthoCCQ56Cu7T7fG6vho0DBxoCBr0kdZcAg.Y.Cb.6', NULL, NULL, NULL, NULL, NULL, NULL, SYSDATE(), SYSDATE(), false);
INSERT INTO somoim.user(id, email, password, name, birth, gender, city_code1, city_code2, image_id, create_at, modify_at, disband)
VALUES(2, 'user2@example.com', '$2a$10$Ts3sJwz1Kb6SthoCCQ56Cu7T7fG6vho0DBxoCBr0kdZcAg.Y.Cb.6', NULL, NULL, NULL, NULL, NULL, NULL, SYSDATE(), SYSDATE(), false);
INSERT INTO somoim.user(id, email, password, name, birth, gender, city_code1, city_code2, image_id, create_at, modify_at, disband)
VALUES(3, 'user3@example.com', '$2a$10$Ts3sJwz1Kb6SthoCCQ56Cu7T7fG6vho0DBxoCBr0kdZcAg.Y.Cb.6', NULL, NULL, NULL, NULL, NULL, NULL, SYSDATE(), SYSDATE(), false);
INSERT INTO somoim.user(id, email, password, name, birth, gender, city_code1, city_code2, image_id, create_at, modify_at, disband)
VALUES(4, 'user4@example.com', '$2a$10$Ts3sJwz1Kb6SthoCCQ56Cu7T7fG6vho0DBxoCBr0kdZcAg.Y.Cb.6', NULL, NULL, NULL, NULL, NULL, NULL, SYSDATE(), SYSDATE(), false);
INSERT INTO somoim.user(id, email, password, name, birth, gender, city_code1, city_code2, image_id, create_at, modify_at, disband)
VALUES(5, 'user5@example.com', '$2a$10$Ts3sJwz1Kb6SthoCCQ56Cu7T7fG6vho0DBxoCBr0kdZcAg.Y.Cb.6', NULL, NULL, NULL, NULL, NULL, NULL, SYSDATE(), SYSDATE(), false);

-- 관심사 대분류 sample
INSERT INTO somoim.category(id, level, parent, name) VALUES (1, 0, 0, 'IT');
INSERT INTO somoim.category(id, level, parent, name) VALUES (2, 0, 0, '외국어');
INSERT INTO somoim.category(id, level, parent, name) VALUES (3, 0, 0, '운동');

-- 관심사 상세 분류 sample
INSERT INTO somoim.category(id, level, parent, name) VALUES (4, 1, 1, '개발');
INSERT INTO somoim.category(id, level, parent, name) VALUES (5, 1, 1, '인프라');
INSERT INTO somoim.category(id, level, parent, name) VALUES (6, 1, 2, '영어');
INSERT INTO somoim.category(id, level, parent, name) VALUES (7, 1, 2, '독일어');
INSERT INTO somoim.category(id, level, parent, name) VALUES (8, 1, 3, '달리기');
INSERT INTO somoim.category(id, level, parent, name) VALUES (9, 1, 3, '구기 종목');

INSERT INTO somoim.category(id, level, parent, name) VALUES (10, 2, 4, '백엔드');
INSERT INTO somoim.category(id, level, parent, name) VALUES (11, 2, 9, '축구');
INSERT INTO somoim.category(id, level, parent, name) VALUES (12, 2, 9, '야구');

-- 그룹 sample
INSERT INTO somoim.group(id, category_id, image_id, city_code1, city_code2, name, detail, create_at, modify_at, disband)
VALUES (1, 10, NULL, 0, 0, 'group01', '백엔드 개발자 모임입니다.', SYSDATE(), SYSDATE(), false);
INSERT INTO somoim.group(id, category_id, image_id, city_code1, city_code2, name, detail, create_at, modify_at, disband)
VALUES (2, 6, NULL, 0, 0, 'group02', '영어 모임입니다.', SYSDATE(), SYSDATE(), false);
INSERT INTO somoim.group(id, category_id, image_id, city_code1, city_code2, name, detail, create_at, modify_at, disband)
VALUES (3, 11, NULL, 0, 0, 'group03', '축구 모임입니다.', SYSDATE(), SYSDATE(), false);

-- 모임 멤버 sample
INSERT INTO somoim.member(id, user_id, group_id, role, create_at, modify_at, disband)
VALUES (1, 1, 1, 'MANAGER', SYSDATE(), SYSDATE(), false); -- user1은 group01의 매니저
INSERT INTO somoim.member(id, user_id, group_id, role, create_at, modify_at, disband)
VALUES (2, 2, 2, 'MANAGER', SYSDATE(), SYSDATE(), false); -- user2는 group02의 매니저
INSERT INTO somoim.member(id, user_id, group_id, role, create_at, modify_at, disband)
VALUES (3, 3, 3, 'MANAGER', SYSDATE(), SYSDATE(), false); -- user3은 group03의 매니저
INSERT INTO somoim.member(id, user_id, group_id, role, create_at, modify_at, disband)
VALUES (4, 4, 1, 'MEMBER', SYSDATE(), SYSDATE(), false); -- user4는 group01의 멤버
INSERT INTO somoim.member(id, user_id, group_id, role, create_at, modify_at, disband)
VALUES (5, 5, 2, 'MEMBER', SYSDATE(), SYSDATE(), false); -- user5는 group02의 멤버