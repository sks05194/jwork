-- sqlplus TEST/1111 : rmd에서 sql 실행하기

--- 1교시
-- 테이블의 구조를 확인하는 명령문
desc emp;

-- 테이블 생성
CREATE TABLE dept01 (
    deptno NUMBER(2, 0),
    dname  VARCHAR2(14),
    loc    VARCHAR2(13)
);

-- 10번 부서의 데이터를 추가
INSERT INTO dept01 (
    deptno,
    dname,
    loc
) VALUES (
    10,
    'ACCOUNTING',
    'NEW WORK'
);

-- 유저명 출력
show user;

-- 현재 존재하는 모든 테이블 출력
SELECT * FROM tab;

-- 확정 저장
COMMIT;

INSERT INTO dept01 (
    deptno,
    dname
) VALUES (
    10,
    'ACCOUNTING'
);


-- 단축형식
INSERT INTO dept01 VALUES (
    20,
    'RESERACH',
    'DALLAS'
);

--- 2교시
-- 문제
-- DEPT01 테이블에 부서번호 30, 부서명이 'SALES'인 데이터를 추가하세요.
INSERT INTO dept01 (
    deptno,
    dname
) VALUES (
    30,
    'SALES'
);

-- DEPT01 테이블에 부서번호 40, 부서명 : 'OPERATIONS', LOC : NULL인 데이터를 추가하세요.
INSERT INTO dept01 (
    deptno,
    dname
) VALUES (
    40,
    'OPERATIONS'
);

-- DEPT01 테이블에 부서번호 50, 부서명 : '', 위치가 'CHICAGO'인 데이터를 추가하세요.
INSERT INTO dept01 (
    deptno,
    loc
) VALUES (
    50,
    'CHICAGO'
);

COMMIT;

-- 업데이트
UPDATE dept01
SET
    deptno = 90,
    dname = 'TEST';

ROLLBACK;

-- 10번 부서이면서 위치가 없는 부서 정보 변경
UPDATE dept01
SET
    deptno = 90,
    dname = 'TEST'
WHERE
        deptno = 10
    AND loc IS NULL;

-- EMP 테이블의 구조와 데이터를 복사해 EMP01 테이블 생성
CREATE TABLE emp01
    AS
        SELECT
            *
        FROM
            emp;

-- 문제
-- EMP01 테이블에서 모든 사원의 부서번호를 30번으로 수정
UPDATE emp01
SET
    deptno = 30;

-- EMP01 테이블에서 모든 사원의 급여를 10% 인상하세요.
UPDATE emp01
SET
    sal = sal * 1.1;

-- EMP01 테이블에서 입사일을 오늘로 수정하세요.
UPDATE emp01
SET
    hiredate = sysdate;


-- EMP01 테이블에서 부서번호가 10번인 사원의 부서번호를 30번으로 수정
UPDATE emp01
SET
    deptno = 30
WHERE
    deptno = 10;

-- EMP01 테이블에서 급여가 3000 이상인 사원만 급여를 10% 인상
UPDATE emp01
SET
    sal = sal * 1.1
WHERE
    sal >= 3000;

-- EMP01 테이블에서 1982년에 입사한 사원의 입사일을 오늘로 수정
UPDATE emp01
SET
    hiredate = sysdate
WHERE
--    substr(hiredate, 0, 2) = '82';
--    hiredate BETWEEN '1982/01/01' AND '1982/12/31';
        hiredate >= '1982/01/01'
    AND hiredate <= '1982/12/31';

-- EMP01 테이블에서 JAMES의 부서번호는 20번, 직급은 MANAGER로 수정
UPDATE emp01
SET
    deptno = 20,
    job = 'MANAGER'
WHERE
    ename = 'JAMES';

-- 3교시
-- 기존 데이터 모두 ROLLBACK한 뒤 진행하세요.
ROLLBACK;

-- EMP01 테이블에서 80년도에 입사한 사원의 입사일자를 1991년 5월 6일 17:56:04초로 변경하세요.
UPDATE emp01
SET
    hiredate = TO_DATE('1991/05/06 17:56:04', 'YYYY/MM/DD HH24:MI:SS')
WHERE
    hiredate BETWEEN '1980/01/01' AND '1980/12/31';

-- EMP01 테이블에서 모든 부서의 사원을 삭제하세요.
DELETE FROM emp01;

-- 문제
-- EMP01 테이블에서 30번 부서의 사원들을 삭제하세요.
DELETE FROM emp01
WHERE
    deptno = 30;

-- 1985년 이후에 입사한 모든 직원을 삭제
DELETE FROM emp01
WHERE
    hiredate >= '1985/01/01';

-- DEPT01 테이블에 아래 내용을 추가하세요
-- 1. 부서번호가 11, 부서명이 경리부, 지역이 서울
INSERT INTO dept01 VALUES (
    11,
    '경리부',
    '서울'
);

-- 2. 부서번호가 12, 부서명이 인사부, 지역이 인천
INSERT INTO dept01 VALUES (
    12,
    '인사부',
    '인천'
);

-- 3. 부서번호가 13, 부서명이 영업부, 지역이 용인
INSERT INTO dept01 VALUES (
    13,
    '영업부',
    '용인'
);

-- 4. 부서번호가 14, 부서명이 전산부, 지역이 수원
INSERT INTO dept01 VALUES (
    14,
    '전산부',
    '수원'
);

-- 오류남(dname 크기 초과 오류)
INSERT INTO dept01 VALUES (
    15,
    '생산관리부',
    '안산'
);

-- EMP01 테이블에 데이터 추가하기
-- 1. 부서번호가 40, 이름이 홍길동, 사번이 9999, 직책이 MANAGER, 급여 800, 커미션 100, 입사일 2022-07-01
INSERT INTO emp01 VALUES (
    9999,
    '홍길동',
    'MANAGER',
    NULL,
    '2022/07/01',
    800,
    100,
    40
);

-- 2. 부서번호가 40, 이름이 고길동, 사번이 1111, 직책이 CEO, 급여 5000, 커미션 2500, 입사일 1980-01-01
INSERT INTO emp01 VALUES (
    1111,
    '고길동',
    'CEO',
    NULL,
    '1980/01/01',
    5000,
    2500,
    40
);

-- 3. 부서번호가 30, 이름이 강영희, 사번이 5555, 직책이 WORKER
INSERT INTO emp01 (
    deptno,
    ename,
    empno,
    job
) VALUES (
    30,
    '강영희',
    5555,
    'WORKER'
);

--- 4교시
-- EMP01테이블의 데이터 수정하기
-- DEPTNO가 10인 데이터의 DEPTNO의 값을 11로 수정하기
UPDATE emp01
SET
    deptno = 11
WHERE
    deptno = 10;
-- DEPTNO가 20인 데이터의 DEPTNO의 값을 12로 수정하기
UPDATE emp01
SET
    deptno = 12
WHERE
    deptno = 20;
-- DEPTNO가 30인 데이터의 DEPTNO의 값을 13으로 수정하기
UPDATE emp01
SET
    deptno = 13
WHERE
    deptno = 30;
-- DEPTNO가 40인 데이터의 DEPTNO의 값을 14로 수정하기
UPDATE emp01
SET
    deptno = 14
WHERE
    deptno = 40;

-- JOB이 CLERK인 사원의 JOB을 점원으로 수정하기
UPDATE emp01
SET
    job = '점원'
WHERE
    job = 'CLERK';
-- JOB이 SALESMAN인 사원의 JOB을 영업사원으로 수정하기
UPDATE emp01
SET
    job = '영업직'
WHERE
    job = 'SALESMAN';
-- JOB이 MANAGER인 사원의 JOB을 관리자로 수정하기
UPDATE emp01
SET
    job = '관리자'
WHERE
    job = 'MANAGER';
-- JOB이 ANALYST인 사원의 JOB을 분석가로 수정하기
UPDATE emp01
SET
    job = '분석가'
WHERE
    job = 'ANALYST';
-- JOB이 PRESIDENT인 사원의 JOB을 회장으로 수정하기
UPDATE emp01
SET
    job = '회장'
WHERE
    job = 'PRESIDENT';
-- JOB이 CEO인 사원의 JOB을 전무로 수정하기
UPDATE emp01
SET
    job = 'CEO'
WHERE
    job = '전무';
-- JOB이 WORKER인 사원의 JOB을 생산자로 수정하기
UPDATE emp01
SET
    job = '생산자'
WHERE
    job = 'WORKER';

-- 사원정보테이블 SQL.sql 참고

--- 5교시
-- EMP01, DEPT01 테이블 삭제
DROP TABLE emp01 PURGE;

DROP TABLE dept01 PURGE;

-- 사원번호, 사원명, 급여 3개의 칼럼으로 구성된 EMP01 테이블 생성
CREATE TABLE emp01 (
    empno NUMBER(4),
    ename VARCHAR2(10CHAR),
    sal   NUMBER(7, 2)
);

--- 6교시
-- DEPT 테이블과 동일한 구조의 테이블을 DEPT01로 생성
CREATE TABLE dept01 (
    deptno NUMBER(2),
    dname  VARCHAR2(14),
    loc    VARCHAR2(13)
);

-- EMP01 테이블에 문자 타입(20)의 직급(JOB) 칼럼을 추가
ALTER TABLE emp01 ADD (
    job VARCHAR2(20)
);

-- DEPT01 테이블에 설립일자 칼럼(CREDATE)을 날짜형으로 추가
ALTER TABLE dept01 ADD (
    credate DATE
);

desc dept01;

-- EMP01 테이블의 직급(JOB) 킬럼 크기를 30으로 변경
ALTER TABLE emp01 MODIFY (
    job VARCHAR2(30)
);

-- EMP 테이블을 복사해서 EMP01 테이블 생성
DROP TABLE emp01 PURGE;

CREATE TABLE emp01
    AS
        SELECT
            *
        FROM
            emp;

-- EMP01 테이블의 직급(JOB) 킬럼 크기를 30으로 변경
ALTER TABLE emp01 MODIFY (
    job VARCHAR2(30)
);

ALTER TABLE emp01 MODIFY (
    deptno NUMBER(4)
);
-- 이하 오류
ALTER TABLE emp01 MODIFY (
    deptno NUMBER(2)
);

-- 이하 오류
ALTER TABLE emp01 MODIFY (
    comm VARCHAR2(10)
);

-- 자료형 변경 오류에 대한 해결방법
UPDATE emp01
SET
    comm = NULL;
COMMIT;
ALTER TABLE emp01 MODIFY (
    comm VARCHAR2(10)
);

-- DEPT01 테이블의 지역명(LOC)칼럼 크기를 20으로 변경
ALTER TABLE dept01 MODIFY (
    loc VARCHAR2(20)
);

--- 7교시
ALTER TABLE emp01 RENAME COLUMN comm TO bonus;
ALTER TABLE emp01 RENAME COLUMN sal TO salary;

-- EMP01 테이블의 직급(JOB) 칼럼 삭제
ALTER TABLE emp01 DROP COLUMN job;
-- DROP (MGR, SALARY)
-- EMP01 테이블의 MGR, SALARY 칼럼 삭제
ALTER TABLE emp01 DROP ( mgr,
                         salary );

-- DEPT01 테이블의 설립일자(CREDATE) 칼럼 삭제
ALTER TABLE dept01 DROP COLUMN credate;

CREATE TABLE emp02
    AS
        SELECT
            *
        FROM
            emp
        WHERE
            deptno = 30;

-- EMP 테이블에서 EMPNO, ENAME, DEPTNO 컬럼을 조회하여 EMP03 테이블을 생성하세요.
CREATE TABLE emp03
    AS
        SELECT
            empno,
            ename,
            deptno
        FROM
            emp;

-- EMP 테이블에서 EMPNO, ENAME, DEPTNO 컬럼을 조회하여 EMP04 테이블을 만드는데, 컬럼명이 사번, 이름, 부서번호로 나오도록 생성하세요.
CREATE TABLE emp04
    AS
        SELECT
            empno as 사번,
            ename as 이름,
            deptno as 부서번호
        FROM
            emp;

CREATE TABLE emp05
    AS
        SELECT
            *
        FROM
            emp
        WHERE
            1 = 0;

-- EMP04 테이블을 EMP07 테이블로 변경하세요.
RENAME emp04 TO emp07;

ALTER TABLE emp04 RENAME TO emp07;

-- 생성했던 테이블을 전부 삭제한다.
DROP TABLE EMP02;
DROP TABLE EMP03;
DROP TABLE EMP05;
DROP TABLE EMP07;

-- EMP01 테이블 내의 모든 데이터를 삭제한다.
DELETE FROM emp01;

ROLLBACK;

-- EMP01 테이블의 모든 ROW를 제거(공간까지 제거)
TRUNCATE TABLE EMP01;
ROLLBACK; -- 제거된 데이터가 복구되지 않음

DROP TABLE EMP01;
DROP TABLE DEPT01;

-- 8교시
CREATE TABLE emp01 (
    empno  NUMBER(4),
    ename  VARCHAR2(10),
    job    VARCHAR2(9),
    deptno NUMBER(4)
);

INSERT INTO emp01 VALUES (
    NULL,
    '',
    'SALESMAN',
    30
);

INSERT INTO emp01 VALUES (
    NULL,
    'TOM',
    'SALESMAN',
    30
);

SELECT
    *
FROM
    emp01;

COMMIT;

CREATE TABLE emp02 (
    empno  NUMBER(4) NOT NULL,
    ename  VARCHAR2(10) NOT NULL,
    job    VARCHAR2(9),
    deptno NUMBER(4)
);

-- 오류
INSERT INTO emp02 VALUES (
    1900,
    NULL,
    'SALESMAN',
    30
);

INSERT INTO emp02 VALUES (
    1401,
    'TOM',
    'SALESMAN',
    30
);

CREATE TABLE emp03 (
    empid  VARCHAR2(20) UNIQUE NOT NULL,
    empno  NUMBER(4) UNIQUE,
    ename  VARCHAR2(10) NOT NULL,
    job    VARCHAR2(9),
    deptno NUMBER(4)
);

INSERT INTO emp03 VALUES (
    'emp03',
    7499,
    'ALLEN',
    'SALESMAN',
    30
);

INSERT INTO emp03 VALUES (
    'emp02',
    7499,
    'JONES',
    'MANAGER',
    20
);

INSERT INTO emp03 VALUES (
    'emp05',
    NULL,
    'JONES',
    'SALESMAN',
    10
);

CREATE TABLE emp04 (
    empid  VARCHAR2(20) PRIMARY KEY,
    empno  NUMBER(4) UNIQUE,
    ename  VARCHAR2(10) NOT NULL,
    job    VARCHAR2(9),
    deptno NUMBER(4)
);