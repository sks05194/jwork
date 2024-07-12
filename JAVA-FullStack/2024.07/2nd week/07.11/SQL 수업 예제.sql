---- 1교시
--- 셀프조인 예제
-- 사원 이름 및 사원 번호를 해당 관리자 이름 및 관리자 번호와 함께 표시
-- 열 머리글을 각각 사원 이름, 사원 번호, 관리자 이름, 관리자 번호로 표시
SELECT
    e.empno 사원이름,
    e.ename 사원번호,
    d.ename 관리자이름,
    d.empno 관리자번호
FROM
    emp e,
    emp d
WHERE
    e.mgr = d.empno;
-- ANSI로도 바꿔보세요.
SELECT
    e.empno 사원이름,
    e.ename 사원번호,
    d.ename 관리자이름,
    d.empno 관리자번호
FROM
    emp e
INNER JOIN
    emp d
ON
    e.mgr = d.empno;

--- 문제
-- 특정 사원을 담당하는 매니저 사원의 이름을 출력한다.
-- WORK(사원 테이블)과 MANAGER(매니저 테이블)로 별칭을 부여한다.
-- 출력 예시 : 'SMITH의 매니저는 FORD입니다.'
SELECT
    work.ename || '의 매니저는 ' || manager.ename || '입니다.'
FROM
    emp work, emp manager
WHERE
    work.mgr = manager.empno;

-- ANSI
SELECT
    work.ename || '의 매니저는 ' || manager.ename || '입니다.'
FROM
    emp work
INNER JOIN
    emp manager
ON
    work.mgr = manager.empno;

--- ???
CREATE TABLE test1 (
    id NUMBER(2) CONSTRAINT test1_id_pk PRIMARY KEY,
    name VARCHAR2(10),
    age NUMBER(2)
);

CREATE TABLE test2 (
    id NUMBER(2) CONSTRAINT test2_id_fk REFERENCES test1(id),
    job VARCHAR2(20)
);

INSERT INTO test1 VALUES(1, '장희빈', 10);
INSERT INTO test1 VALUES(2, '이효리', 25);
INSERT INTO test1 VALUES(3, '이나영', 40);
INSERT INTO test1 VALUES(5, '이혜리', 35);
INSERT INTO test1 VALUES(6, '주진모', 15);

INSERT INTO test2 VALUES(1, '한국사');
INSERT INTO test2 VALUES(3, '대중가요');
INSERT INTO test2 VALUES(5, '연기');
INSERT INTO test2 VALUES(3, '뮤지컬');
INSERT INTO test2 VALUES(4, '연구'); -- 오류

---- 2교시
--- 문제
-- test1과 test2 테이블을 INNER JOIN한 결과를 출력하시오.
SELECT *
FROM test1, test2
WHERE test1.id = test2.id;

-- ANSI
SELECT *
FROM test1
JOIN test2
ON test1.id = test2.id;

--- ???
-- DEPT 테이블의 LOC 컬럼을 복사해서 이 데이터를 가지고 LNO 테이블 생성
CREATE TABLE lno
AS SELECT loc FROM dept;

-- LNO 테이블에 LNUM (VARCHAR2(5)) 컬럼 생성
ALTER TABLE lno
ADD lnum VARCHAR2(5);

/*
LNUM 컬럼에 값 넣기
NEW YORK => '001'
DALLAS => '002'
CHICAGO => '003'
BOSTON => '004'
*/
UPDATE lno
SET lnum = '001'
WHERE loc = 'NEW YORK';

UPDATE lno
SET lnum = '002'
WHERE loc = 'DALLAS';

UPDATE lno
SET lnum = '003'
WHERE loc = 'CHICAGO';

UPDATE lno
SET lnum = '004'
WHERE loc = 'BOSTON';

COMMIT;

-- 사원번호, 사원이름, 부서번호, 부서명, 위치, 위치번호가 출력이 되도록 처리하세요.
SELECT empno, ename, e.deptno, dname, d.loc, lnum
FROM emp e, dept d, lno l
WHERE e.deptno = d.deptno AND d.loc = l.loc;

-- ANSI
SELECT empno, ename, e.deptno, dname, d.loc, lnum
FROM emp e
JOIN dept d
ON e.deptno = d.deptno
JOIN lno l
ON d.loc = l.loc;
    
-- ???
SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno;

SELECT *
FROM emp
JOIN dept
USING (deptno);

SELECT *
FROM emp
JOIN dept
USING (deptno)
WHERE ename = 'SMITH';

---- 3교시
--- OUTER JOIN
INSERT INTO emp (empno, ename) VALUES (8000, 'TEST');

-- 사원번호, 사원명, 부서번호, 부서명을 출력하는데, 부서가 할당되지 않은 사원까지 출력을 해주세요.
-- LEFT OUTER JOIN, RIGHT OUTER JOIN으로 표현해주세요.
-- left
SELECT empno, ename, d.deptno, dname
FROM emp e, dept d
WHERE e.deptno = d.deptno(+);
-- ansi left
SELECT empno, ename, d.deptno, dname
FROM emp e
LEFT OUTER JOIN dept d
USING (deptno);
-- right
SELECT empno, ename, d.deptno, dname
FROM dept d, emp e
WHERE d.deptno(+) = e.deptno;
-- ansi right
SELECT empno, ename, deptno, dname
FROM dept
RIGHT OUTER JOIN emp
USING (deptno);

-- 사원번호, 사원명, 부서번호, 부서명을 출력하는데,
-- 부서가 할당되지 않은 사원정보와
-- 사원이 할당되지 않은 부서의 정보까지 출력을 해주세요.
SELECT empno, ename, deptno, dname
FROM dept
FULL OUTER JOIN emp
USING (deptno);

--- 문제
-- 테이블 : EMPLOYEES, DEPARTMENTS
-- 1. 사원번호 , 사원명 별칭 NAME , 부서번호, 부서명이 출력되도록 처리해주세요.
SELECT
    employee_id, first_name || ' ' || last_name name,
    d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- ANSI
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    d.department_id, d.department_name
FROM employees e
JOIN departments d
ON e.department_id = d.department_id;

-- 2. 사원번호, 부서번호, 부서명, 상위부서명을 출력하는데, 부서를 할당받지 못한 인턴사원까지 출력해주세요.
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    d.department_id, d.department_name,
    (
        SELECT d2.department_name
        FROM departments d2
        WHERE d2.department_id = d.manager_id
    ) mgr_nm
FROM employees e, departments d
WHERE e.department_id = d.department_id (+);

-- ANSI
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    d.department_id, d.department_name,
    (
        SELECT d2.department_name
        FROM departments d2
        WHERE d2.department_id = d.manager_id
    ) mgr_nm
FROM employees e
LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- 3. 사원번호, 사원명 별칭 NAME, 부서번호, 부서명을 출력하는데, 사원이 할당되지 않은 부서에 대해서도 출력해주세요.
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    d.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id (+) = d.department_id;

-- ANSI
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    d.department_id, d.department_name
FROM employees   e
RIGHT OUTER JOIN departments d
ON e.department_id = d.department_id;

-- 4. 테이블: EMPLOYEES , JOB_HISTORY , JOBS
-- JOB_HISTORY 테이블의 START_DATE (해당 직책이 시작된 일자), END_DATE(해당 직책이 종료된 일자)
-- JOBS :  JOB_ID : 직책아이디,  JOB_TITLE : 직책명
-- 직책이 변경된 직원의 사원번호, 사원명 별칭 NAME, 부서번호, 부서명, 직책명, 해당 직책이 시작된 일자,  해당 직책이 종료된 일자를 출력해주세요.
-- (사번 오름차순, 시작일자 오름차순으로 정렬해주세요.)
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    j.job_title, jh.start_date, jh.end_date
FROM employees e, job_history jh, jobs j
WHERE e.employee_id = jh.employee_id
    AND jh.job_id = j.job_id
ORDER BY e.employee_id, start_date;

-- ANSI
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name name,
    j.job_title, jh.start_date, jh.end_date
FROM employees e
JOIN job_history jh
ON e.employee_id = jh.employee_id
JOIN jobs j
ON jh.job_id = j.job_id
ORDER BY e.employee_id, start_date;


-- 5. 테이블: EMPLOYEES, JOBS
-- JOBS테이블의 JOB_ID : 직책아이디, JOB_TITLE : 직책명, MIN_SALARY : 최소 연봉, MAX_SALARY: 최대연봉
-- 'Nancy Greenberg'가 받을 수 있는 사원번호, 사원명, 최대연봉과 최소 연봉, 직책아이디, 직책명을 사원번호 오름차순으로 출력하세요.
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name,
    j.max_salary, j.min_salary, j.job_id, j.job_title
FROM employees e, jobs j
WHERE e.job_id = j.job_id
    AND ( e.first_name || ' ' || e.last_name ) = 'Nancy Greenberg';

-- ANSI
SELECT
    e.employee_id, e.first_name || ' ' || e.last_name,
    j.max_salary, j.min_salary, j.job_id, j.job_title
FROM employees e
JOIN jobs j
ON e.job_id = j.job_id
WHERE ( e.first_name || ' ' || e.last_name ) = 'Nancy Greenberg';

---- 5교시
--- VIEW
CREATE TABLE emp01
AS SELECT * FROM emp;

CREATE VIEW view_emp01
AS
SELECT empno, ename, sal, deptno
FROM emp01
WHERE deptno = 10;

DESC view_emp01;
SELECT * FROM view_emp01;

-- 뷰의 원본 테이블에도 영향을 끼침
INSERT INTO view_emp01
VALUES(8000, 'ANGEL', 7000, 10);

DROP VIEW view_emp01;


---- 6교시
--- 복합뷰
-- 아래의 쿼리문을 이용하여 VIEW_EMP_DEPT 이름의 VIEW를 생성하세요.
SELECT ename, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

CREATE VIEW view_emp_dept
AS
SELECT ename, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

DELETE FROM view_emp_dept WHERE dname = 'ACCOUNTING';
INSERT INTO view_emp_dept (ename, dname) VALUES('MICLE','ARTIST');

-- EMP 테이블의 WARD 이름을 WARDDD로 변경하고 VIEW_EMP_DEPT 뷰의 데이터를 확인하세요.
UPDATE emp
SET ename = 'WARDDD'
WHERE ename = 'WARD';

SELECT * FROM view_emp_dept;

-- EMP 테이블을 삭제한 뒤 VIEW_EMP_DEPT 뷰의 데이터 확인하기 (오류)
DROP TABLE emp;

CREATE TABLE emp
AS SELECT * FROM scott.emp;

DROP VIEW view_emp_dept;

--- 인라인뷰
SELECT * FROM (SELECT 25 / 5 AS result FROM dual);

SELECT * FROM
(
    SELECT ename, dname FROM emp e, dept d
    WHERE e.deptno = d.deptno
);

SELECT imsi.*, 'test' as "test" FROM
(
    SELECT ename, dname FROM emp e, dept d
    WHERE e.deptno = d.deptno
) imsi;

-- 세미 조인
SELECT * FROM dept d
WHERE EXISTS (SELECT * FROM emp e WHERE e.deptno = d.deptno);

SELECT * FROM emp e
WHERE EXISTS (SELECT * FROM dept d WHERE d.deptno = e.deptno);

SELECT * FROM dept d
WHERE d.deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal >= 3000);

-- 안티 조인
SELECT * FROM dept b
WHERE NOT EXISTS (SELECT * FROM emp e WHERE e.deptno = b.deptno);

SELECT * FROM dept b
WHERE b.deptno NOT IN (SELECT DISTINCT deptno FROM emp WHERE sal >= 3000);

----8교시
-- 선수작업1:
-- CUSTOMERS 테이블 생성 cmd 명령어 (원하는 테이블 가져오기)
-- imp userid=TEST/1111@XE tables=customers file=c:\Users\hi\Downloads\expall.dmp fromuser=ora_user touser=test

-- 선수작업2:
CREATE TABLE ct AS SELECT * FROM customers;

-- 선수작업3:
ALTER TABLE customers
ADD CONSTRAINT customers_cust_id_pk PRIMARY KEY(cust_id);