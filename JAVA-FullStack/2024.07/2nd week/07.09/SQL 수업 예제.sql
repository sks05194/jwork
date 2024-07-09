--- 1교시
SELECT
    *
FROM
    user_constraints;

-- 제약조건 정식형식
CREATE TABLE dept01 (
    deptno NUMBER(2)
        CONSTRAINT dept01_detpno_pk PRIMARY KEY, -- 컬럼레벨방식
    dname  VARCHAR2(15),
    loc    VARCHAR2(15)
);

INSERT INTO dept01 VALUES (
    50,
    'RESEARCH',
    '뉴욕'
);

INSERT INTO dept01 (
    deptno,
    dname,
    loc
) VALUES (
    60,
    'RESERACH',
    '뉴욕'
);

INSERT INTO dept01 (
    deptno,
    dname,
    loc
) VALUES (
    50,
    'TEACHER',
    '서울'
); -- 오류

--- 2교시
CREATE TABLE dept02 (
    deptno NUMBER(2),
    dname  VARCHAR2(15),
    loc    VARCHAR2(15),
    CONSTRAINT dept02_dno_dnam_pk PRIMARY KEY ( deptno,
                                                dname )
);

INSERT INTO dept02 VALUES (
    15,
    '영업',
    '서울'
);

INSERT INTO dept02 VALUES (
    15,
    '개발',
    '서울'
);

INSERT INTO dept02 VALUES (
    15,
    '개발',
    '인천'
); -- 오류


-- CHECK
CREATE TABLE emp05 (
    empno  NUMBER(4) PRIMARY KEY,
    ename  VARCHAR2(10) NOT NULL,
    gender VARCHAR2(1) CHECK ( gender IN ( 'M', 'F' ) )
);

INSERT INTO emp05 VALUES (
    7566,
    'JONES',
    'M'
);

INSERT INTO emp05 VALUES (
    7577,
    'LEMON',
    'F'
);

INSERT INTO emp05 VALUES (
    7588,
    'TOMS',
    'A'
); -- 오류

INSERT INTO emp05 VALUES (
    7599,
    'LEMON',
    'f'
); -- 오류


--- 3교시
CREATE TABLE emp07 (
    empno  NUMBER(4) PRIMARY KEY,
    ename  VARCHAR2(10) NOT NULL,
    gender VARCHAR2(1) CHECK ( gender IN ( 'M', 'F' ) ),
    sal    NUMBER(7, 2) CHECK ( sal >= 1000
                             AND sal <= 10000 )
);

INSERT INTO emp07 VALUES (
    1234,
    'TOMS',
    'M',
    1500
);

INSERT INTO emp07 VALUES (
    1234,
    'TOMS',
    'M',
    15000
);

-- dept 테이블을 복사해서 dept01 테이블을 생성하세요.
CREATE TABLE dept01
    AS
        SELECT
            *
        FROM
            dept;

CREATE TABLE emp06 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    job VARCHAR2(9),
    deptno NUMBER(4) REFERENCES dept01(deptno)
);

ALTER TABLE dept01 MODIFY (
    deptno NUMBER(2) PRIMARY KEY
);

INSERT INTO emp06 VALUES (
    7566,
    'JONES',
    'MANAGER',
    50
);

INSERT INTO emp06 VALUES (
    7566,
    'JONES',
    'MANAGER',
    NULL
);

INSERT INTO emp06 VALUES (
    7988,
    'JERRY',
    'CEO',
    90
);

INSERT INTO emp06 VALUES (
    7988,
    'JERRY',
    'CEO',
    10
);