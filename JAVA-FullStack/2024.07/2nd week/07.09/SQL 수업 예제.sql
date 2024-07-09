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
); -- 오류 (parent key not found)

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
); -- 오류 (parent key not found)

INSERT INTO emp06 VALUES (
    7988,
    'JERRY',
    'CEO',
    10
);

--- 4교시
CREATE TABLE emp08 (
    empno  NUMBER(4) PRIMARY KEY,
    ename  VARCHAR2(10) NOT NULL,
    job    VARCHAR2(9),
    deptno NUMBER(4),
    CONSTRAINT emp08_deptno_fk FOREIGN KEY ( deptno )
        REFERENCES dept02 ( deptno )
); -- 오류 

CREATE TABLE emp08 (
    empno NUMBER(4) PRIMARY KEY,
    ename VARCHAR2(10) NOT NULL,
    job   VARCHAR2(9),
    dno   NUMBER(4),
    dnm   VARCHAR2(15),
    CONSTRAINT emp08_deptno_fk FOREIGN KEY ( dno,
                                             dnm )
        REFERENCES dept02 ( deptno,
                            dname )
);

-- 테이블 제거
DROP TABLE dept01; -- 오류(unique/primary keys in table referenced by foreign keys)

DROP TABLE emp06;
DROP TABLE dept01;

-- DEPT02 -- EMP08
DROP TABLE dept02 CASCADE CONSTRAINTS;

CREATE TABLE dept01 (
    deptno NUMBER(2) PRIMARY KEY,
    dname  VARCHAR2(20) NOT NULL,
    loc    VARCHAR2(50) DEFAULT '서울'
);

INSERT INTO dept01 VALUES (
    10,
    '인사',
    NULL
); -- loc에 NULL이 들어감.

INSERT INTO dept01 (
    deptno,
    dname
) VALUES (
    20,
    '인사'
); -- loc에 '서울'이 들어감.

CREATE TABLE dept02 (
    deptno NUMBER(2)
);

ALTER TABLE dept02
ADD CONSTRAINT dept02_deptno_pk PRIMARY KEY ( deptno );

-- 기본키가 이미 존재하기 때문에 에러
-- ALTER TABLE dept02 MODIFY (
--     deptno
--         CONSTRAINT dept02_deptno_pk PRIMARY KEY
-- );

ALTER TABLE dept02 ADD (
    dname VARCHAR2(50)
);


--- 5교시
-- 사용할 수 없는 방식
-- ALTER TABLE dept02
-- ADD CONSTRAINT dept02_deptno_nn NOT NULL ( dname );

-- 위 코드 개선
ALTER TABLE dept02 ADD (
    dname VARCHAR(50) NOT NULL
);

-- ALTER TABLE dept02
-- ADD dname VARCHAR2(50)CONSTRAINT dept02_deptno_nn NOT NULL;

ALTER TABLE dept02 MODIFY (
    dname
        CONSTRAINT dept02_dname_nn NOT NULL
);

-- ALTER TABLE dept02
-- DROP CONSTRAINT dept02_deptno_pk;

-- ALTER TABLE dept02
-- DROP COLUMN dname;

-- 이름을 큰따옴표로 저장시
CREATE TABLE "Dept03" (
    "DeptNo" NUMBER(3)
);

INSERT INTO dept03 ( deptno ) VALUES ( 100 ); -- 오류

INSERT INTO "Dept03" ( "DeptNo" ) VALUES ( 100 );

DROP TABLE "Dept03";

--- 6교시
-- scott계정에서 dept 테이블을 복제하여 dept01테이블을 생성하세요.
CREATE TABLE detp01
    AS
        SELECT
            *
        FROM
            dept;

-- scott계정에서 dept 테이블을 복제하여 dept01테이블을 생성하세요.
CREATE TABLE dept01
    AS
        SELECT
            *
        FROM
            scott.dept
        WHERE
            1 = 0;

/*
10 ACCOUNTING   NEW YORK
SAVEPOINT C1;

20 RESEARCH     DALLAS
SAVEPOINT C2;

30 SALES    CHICAGO
SAVEPOINT C3;

40 OPERATIONS   BOSTON
*/
INSERT INTO dept01 VALUES (
    10,
    'ACCOUNTING',
    'NEW YORK'
);

SAVEPOINT c1;

INSERT INTO dept01 VALUES (
    20,
    'RESEARCH',
    'DALLAS'
);

SAVEPOINT c2;

INSERT INTO dept01 VALUES (
    30,
    'SALES',
    'CHICAGO'
);

SAVEPOINT c3;

INSERT INTO dept01 VALUES (
    40,
    'OPERATIONS',
    'BOSTON'
);

ROLLBACK TO c3;

---7교시
SELECT
    *
FROM
    emp
WHERE
    deptno > (
        SELECT
            deptno
        FROM
            dept
        WHERE
            deptno = 10
    );

-- 사원 이름이 'JONES'인 사원의 부서명 출력
SELECT
    dname
FROM
    dept
WHERE
    deptno = (
        SELECT
            deptno
        FROM
            emp
        WHERE
            ename = 'JONES'
    );

-- 문제
-- SMITH와 같은 부서에서 근무하는 사원의 정보를 출력

-- 메인쿼리 : 사원의 정보를 출력 => EMP
SELECT
    *
FROM
    emp
WHERE
        deptno = (
            -- 서브쿼리 : SMITH와 같은 부서에서 근무 => EMP
            SELECT
                deptno
            FROM
                emp
            WHERE
                ename = 'SMITH'
        )
    AND ename != 'SMITH';


-- OPERATIONS 부서에서 근무하는 사원의 사번, 이름, 직책, 부서번호를 출력하세요.
SELECT
    empno,
    ename,
    job,
    deptno
FROM
    emp
WHERE
    deptno = (
        SELECT
            deptno
        FROM
            dept
        WHERE
            dname = 'OPERATIONS'
    );

-- BLAKE가 담당하는 후임직원의 사번, 이름, 직책, 부서번호를 출력하세요.
SELECT
    empno,
    ename,
    job,
    deptno
FROM
    emp
WHERE
    mgr = (
        SELECT
            empno
        FROM
            emp
        WHERE
            ename = 'BLAKE'
    );

-- 'CHICAGO' 지역에서 근무하는 사원의 사번, 이름, 부서번호를 출력하세요.
SELECT
    empno,
    ename,
    deptno
FROM
    emp
WHERE
    deptno = (
        SELECT
            deptno
        FROM
            dept
        WHERE
            loc = 'CHICAGO'
    );

-- 'ALLEN'과 동일한 년도에 입사한 사원의 사번, 이름, 입사일자를 출력하세요.
-- substr 사용
SELECT
    empno,
    ename,
    hiredate
FROM
    emp
WHERE
    substr(hiredate, 1, 2) = (
        SELECT
            substr(hiredate, 1, 2)
        FROM
            emp
        WHERE
            ename = 'ALLEN'
    );

-- trunc 사용
SELECT
    empno,
    ename,
    hiredate
FROM
    emp
WHERE
    trunc(hiredate, 'YEAR') = trunc((
        SELECT
            hiredate
        FROM
            emp
        WHERE
            ename = 'ALLEN'
    ), 'YEAR');

-- to_char 사용
SELECT
    empno,
    ename,
    hiredate
FROM
    emp
WHERE
    to_char(hiredate, 'YYYY') = (
        SELECT
            to_char(hiredate, 'YYYY')
        FROM
            emp
        WHERE
            ename = 'ALLEN'
    );

-- WARD보다 더 많은 연봉을 받는 사원의 사번, 이름, 연봉을 출력하세요.
SELECT
    empno,
    ename,
    sal
FROM
    emp
WHERE
    sal > (
        SELECT
            sal
        FROM
            emp
        WHERE
            ename = 'WARD'
    );

-- 'RESEARCH' 부서가 아닌 다른 부서에서 근무하는 사원의 사번, 이름, 부서번호를 출력하세요.

-- NOT 사용
SELECT
    empno,
    ename,
    deptno
FROM
    emp
WHERE
    NOT deptno = (
        SELECT
            deptno
        FROM
            dept
        WHERE
            dname = 'RESEARCH'
    );

-- IN 사용
SELECT
    empno,
    ename,
    deptno
FROM
    emp
WHERE
    deptno IN (
        SELECT
            deptno
        FROM
            dept
        WHERE
            dname != 'RESEARCH'
    );

-- <> 사용
SELECT
    empno,
    ename,
    deptno
FROM
    emp
WHERE
    deptno <> (
        SELECT
            deptno
        FROM
            dept
        WHERE
            dname = 'RESEARCH'
    );