---- 3교시
--- INDEX
-- 속도비교
SELECT *
FROM customers
WHERE cust_id = 4141;

SELECT *
FROM ct
WHERE cust_id = 4141;

SELECT *
FROM customers
WHERE cust_id = 23697;

SELECT *
FROM ct
WHERE cust_id = 23697;

SELECT *
FROM customers
WHERE cust_id = 11252;

SELECT *
FROM ct
WHERE cust_id = 11252;
--> 인덱스를 생성한 customers가 더 빠르게 실행된다.

-- 이름 변경
ALTER INDEX customers_cust_id_pk RENAME TO ct_custid_index;

-- 인덱스 생성
CREATE INDEX ct_cust_id_idx ON ct(cust_id);

-- 인덱스 삭제
DROP INDEX ct_cust_id_idx;

-- 복합 생성
CREATE INDEX ct_cust_id_name_idx ON ct(cust_id, cust_name);

-- 인덱스 보기
SELECT * FROM all_indexes;
SELECT * FROM dba_indexes;
SELECT * FROM user_indexes;

-- 인덱스 삭제
drop index ct_cust_id_name_idx;

--
CREATE UNIQUE INDEX ct_index_nm_main ON ct ( cust_email ); -- 오류(중복된 값 발견됨)
CREATE UNIQUE INDEX ct_index_nm_main ON ct ( cust_id );
DROP INDEX ct_index_nm_main;

-- 인덱스 탭에 UNIQUENESS 확인하기
CREATE INDEX ct_index_id ON ct ( cust_id );
DROP INDEX ct_index_id;

---- 4교시
--- 인덱스 리빌드
ALTER INDEX ct_cust_id_idx REBUILD;

--- 서브쿼리 문제
-- 테이블 : EMPLOYEES, DEPARTMENTS, COUNTRIES, LOCATIONS, JOBS, JOB_HISTORY
-- ( = 조인, 서브쿼리 등을 이용)
-- 1. 부서가 할당되지 않은 사원을 검색하세요.
SELECT *
FROM employees
WHERE department_id IS NULL;

-- 답 : 안티조인
SELECT *
FROM employees e
WHERE NOT EXISTS (SELECT * FROM departments d WHERE e.department_id = d.department_id);

-- 2. Roma 지역에 있는 부서들의 부서정보를 검색하세요.
-- 서브 쿼리
SELECT *
FROM departments
WHERE location_id IN (
    SELECT location_id
    FROM locations
    WHERE city = 'Roma'
);

-- JOIN
SELECT *
FROM departments d, locations l
WHERE d.location_id = l.location_id AND city = 'Southlake';

-- ANSI JOIN
SELECT *
FROM departments d
JOIN locations l
ON d.location_id = l.location_id
WHERE city = 'Southlake';

-- USING
SELECT *
FROM departments
JOIN locations
USING (location_id)
WHERE city = 'Southlake';

-- 3. Accounting Manager 직책을 가진 사원을 검색하세요.
-- 서브 쿼리
SELECT *
FROM employees
WHERE job_id = (
    SELECT job_id
    FROM jobs
    WHERE job_title = 'Accounting Manager'
);

-- 조인
SELECT *
FROM employees e, jobs j
WHERE e.job_id = j.job_id AND job_title = 'Accounting Manager';

-- ANSI
SELECT *
FROM employees e
JOIN jobs j
ON e.job_id = j.job_id
WHERE job_title = 'Accounting Manager';

-- USING
SELECT *
FROM employees e
JOIN jobs j
USING (job_id)
WHERE job_title = 'Accounting Manager';

-- 4. Payam Kaufling이 받을 수 있는 최소연봉과 최대연봉을 검색하세요.
-- 서브 쿼리
SELECT min_salary, max_salary
FROM jobs
WHERE job_id = (
    SELECT job_id
    FROM employees
    WHERE  first_name || ' ' || last_name = 'Payam Kaufling'
);

-- 조인
SELECT min_salary, max_salary
FROM jobs j, employees e
WHERE j.job_id = e.job_id AND first_name || ' ' || last_name = 'Payam Kaufling';

-- ANSI
SELECT min_salary, max_salary
FROM jobs j
JOIN employees e
ON j.job_id = e.job_id
WHERE first_name || ' ' || last_name = 'Payam Kaufling';

-- USING
SELECT min_salary, max_salary
FROM jobs
JOIN employees
USING (job_id)
WHERE first_name || ' ' || last_name = 'Payam Kaufling';

-- 5. Canada 국가에 속해있는 부서의 정보를 검색하세요.
-- 서브 쿼리
SELECT *
FROM departments
WHERE location_id IN (
    SELECT location_id
    FROM locations
    WHERE country_id = (
        SELECT country_id
        FROM countries
        WHERE country_name = 'Canada'
    )
);

-- JOIN + 서브쿼리
SELECT *
FROM departments d, locations l
WHERE l.country_id = (
    SELECT c.country_id
    FROM countries c
    WHERE country_name = 'Canada'
);

SELECT * FROM countries WHERE = country_name = 'Canada';

SELECT * FROM locations WHERE country_id;

-- 날짜 구분자
SELECT * FROM employ WHERE hiredate = '01/05/01';
SELECT * FROM employ WHERE hiredate = '01/05/01';
-- ...


---- 5교시
-- DEPARTMENTS에서 LOCATION_ID값이 2500, 2700을 포함하고 있는 나라명을 출력하세요.
-- 서브 쿼리문 중첩
SELECT country_name
FROM countries
WHERE country_id IN (
    SELECT country_id
    FROM locations
    WHERE location_id IN (
        SELECT location_id
        FROM departments
        WHERE location_id IN (2500, 2700)
    )
);

-- JOIN문
SELECT country_name
FROM countries c, locations l, departments d
WHERE c.country_id = l.country_id
AND l.location_id = d.location_id
AND d.location_id IN (2500, 2700);

---- 6교시
--- 시퀀스
-- INT자료형 ( = NUMBER(38)과 동일) : 음수, 0, 양수만 표현
CREATE TABLE board (
    no INT PRIMARY KEY,
    subject VARCHAR2(30),
    content VARCHAR2(50),
    w_date DATE
);

-- board의 no 컬럼에 사용할 시퀀스 생성
CREATE SEQUENCE seq_no NOCACHE;

-- 데이터 삽입
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java1', 'java', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '자바', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java3', 수업, sysdate ); -- 오류
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java3', '수업', sysdate );

SELECT seq_no.CURRVAL FROM dual;

SELECT seq_no.NEXTVAL FROM dual;
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '영어', sysdate );

SELECT * FROM dba_sequences;
SELECT * FROM all_sequences;
SELECT * FROM user_sequences;

ROLLBACK;

INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java1', 'java', sysdate );

DROP SEQUENCE seq_no;

TRUNCATE TABLE board;

CREATE SEQUENCE seq_no
START WITH 5 -- 이 부분은 생략 가능.
INCREMENT BY - 2
MAXVALUE 5 -- 이 부분은 생략불가, START값이 MAX보다 크면 안됨
NOCACHE; -- 이 부분은 생략 가능. 디폴트가 NOCACHE

INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java1', 'java', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '자바', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java3', '수업', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '영어', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '국어', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '고어', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '수학', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '한문', sysdate );

DROP SEQUENCE seq_no;
TRUNCATE TABLE board;

-- 오류
CREATE SEQUENCE seq_no
INCREMENT BY 2
MAXVALUE 5
CYCLE CACHE 4;

CREATE SEQUENCE seq_no
INCREMENT BY 2
MAXVALUE 5
CYCLE CACHE 2;

INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java1', 'java', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '자바', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java3', '수업', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '영어', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '국어', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '고어', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '수학', sysdate );
INSERT INTO board VALUES ( seq_no.NEXTVAL, 'java2', '한문', sysdate );

---- 7교시(이어서)
ALTER TABLE board
DROP CONSTRAINT sys_c007089;

DROP SEQUENCE seq_no;
DROP TABLE board;

--
CREATE SEQUENCE seq_no NOCACHE;

CREATE TABLE emp07 AS
SELECT seq_no.NEXTVAL empno, ename, deptno, sal, job FROM emp;

CREATE TABLE emp08 AS
SELECT 'test' ename, deptno, sal, job FROM emp;

DROP TABLE emp08;

INSERT INTO emp07 VALUES(seq_no.NEXTVAL,'MARIA',90,6000,'BABO');

UPDATE emp07
SET empno = seq_no.NEXTVAL, deptno = seq_no.NEXTVAL
WHERE empno = 1;

DROP TABLE emp07;
DROP SEQUENCE seq_no;

--
CREATE TABLE boa02 (
    seq NUMBER,
    name VARCHAR2(20) NOT NULL
);

CREATE SEQUENCE bo_se NOCACHE;

-- 값 추가 시 오류에 따른 시퀀스 값 변화 시청

DROP TABLE boa02;
DROP SEQUENCE bo_se;

--- 문제
-- DEPT 테이블의 구조만 복사해서 DEPT01 테이블을 생성하세요.
CREATE TABLE dept01
AS SELECT * FROM dept WHERE 1 = 0;

-- DEPT01 테이블의 DEPTNO 컬럼의 자료형을 NUMBER(4)로 변경하세요.
ALTER TABLE dept01
MODIFY deptno NUMBER(4); -- 오류

-- DEPT_SEQ 이름의 시퀀스 생성 => 옵션 : 시작값 10, 증가값 10, 최대값 30;
CREATE SEQUENCE dept_seq
START WITH 10
INCREMENT BY 10
MAXVALUE 30
NOCACHE;

--- 이하는 삭제를 제외하고는 한 줄씩 실행하며 확인해주세요.
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'RESEARCH', 'DALLAS' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'SALES', 'CHICAGO' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'PRODUCT', 'TAIWAN' );

DROP SEQUENCE dept_seq;
TRUNCATE TABLE dept01;

-- 시작값: 10, 증가값 : 10, 최대값 : 30, 사이클 CACHE
CREATE SEQUENCE dept_seq
START WITH 10
INCREMENT BY 10
MAXVALUE 30
CYCLE CACHE 2;

INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'RESEARCH', 'DALLAS' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'SALES', 'CHICAGO' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'PRODUCT', 'TAIWAN' );

---- 8교시
ALTER SEQUENCE dept_seq
INCREMENT BY 1
MAXVALUE 30
CYCLE CACHE 2;

INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );

ALTER SEQUENCE dept_seq
INCREMENT BY 10
MAXVALUE 30
CYCLE CACHE 2;

INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );
INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );

ALTER SEQUENCE dept_seq
INCREMENT BY 10
MINVALUE 2 -- 오류
MAXVALUE 30
CYCLE CACHE 2;

ALTER SEQUENCE dept_seq
INCREMENT BY 10
MINVALUE 1
MAXVALUE 30
CYCLE CACHE 2;

INSERT INTO dept01 VALUES ( dept_seq.NEXTVAL, 'ACCOUNTING', 'NEW YORK' );

ALTER SEQUENCE dept_seq
INCREMENT BY 10
MINVALUE 2
MAXVALUE 30
CYCLE CACHE 2;

DROP SEQUENCE dept_seq;
DROP TABLE dept01;

--- 동의어(SYNONYM)
CREATE OR REPLACE PUBLIC SYNONYM dept01_sn FOR dept;

SELECT * FROM dept01_sn;

ALTER USER scott IDENTIFIED BY 1111;

-- 비공개동의어
GRANT SELECT ON dept01_sn TO PUBLIC;
SELECT * FROM dept01_sn; -- scott 계정

CREATE OR REPLACE SYNONYM dept01_sn FOR dept;

DROP SYNONYM dept01_sn;
DROP PUBLIC SYNONYM dept01_sn;

CREATE SYNONYM dept01_sn FOR dept;
GRANT SELECT ON dept01_sn TO PUBLIC;

DROP SYNONYM dept01_sn;