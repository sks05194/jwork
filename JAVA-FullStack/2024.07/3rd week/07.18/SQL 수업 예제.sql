---- 4교시
-- Score 테이블
CREATE TABLE score (
    hak  VARCHAR2(10),
    name VARCHAR2(20) NOT NULL,
    kor  NUMBER(3),
    eng  NUMBER(3),
    mat  NUMBER(3),
    CONSTRAINT pk_score_hak PRIMARY KEY ( hak )
);

---- 3교시
CREATE TABLE member1 (
    id     VARCHAR2(12),
    passwd VARCHAR2(12),
    name   VARCHAR2(12),
    age    NUMBER(3),
    addr   VARCHAR2(20),
    email  VARCHAR2(20)
);

INSERT INTO member1 VALUES ( 'aaa', 'aaa', '박재영', 32, '서울시', 'a@a.com' );
INSERT INTO member1 VALUES ( 'bbb', 'bbb', '임정혁', 31, '인천시', 'b@b.com' );
INSERT INTO member1 VALUES ( 'ccc', 'ccc', '홍길동', 35, '강원도', 'c@c.com' );
INSERT INTO member1 VALUES ( 'ddd', 'ddd', '마이콜', 33, '제주시', 'd@d.com' );
INSERT INTO member1 VALUES ( 'eee', 'eee', '고영희', 34, '수원시', 'e@e.com' );

COMMIT;
--

---- 5교시
CREATE TABLE board (
    id      NUMBER PRIMARY KEY,
    writer  VARCHAR2(12) NOT NULL,
    passwd  VARCHAR2(12) NOT NULL,
    subject VARCHAR2(50) NOT NULL,
    email   VARCHAR2(25)
);

CREATE SEQUENCE board_seq NOCACHE;

INSERT INTO board VALUES ( board_seq.NEXTVAL, '관리자', '1111', '공지합니다', 'admin@a.b' );

COMMIT;