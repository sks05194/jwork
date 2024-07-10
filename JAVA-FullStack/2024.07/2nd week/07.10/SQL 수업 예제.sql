---- 1교시
--- 문제
-- 평균 급여보다 더 많은 급여를 받는 사원을 나타내되 급여를 많이 받는 사람 순으로 출력
SELECT
    *
FROM
    emp
WHERE
    sal > (
        SELECT
            AVG(sal)
        FROM
            emp
    )
ORDER BY
    sal DESC;

-- 부서번호가 10번인 사원 중에서 최대 급여를 받는 사원의 사원 번호와 사원명
SELECT
    empno,
    ename
FROM
    emp
WHERE
        sal = (
            SELECT
                MAX(sal)
            FROM
                emp
            WHERE
                deptno = 10
        )
    AND deptno = 10;

SELECT
    ename,
    sal
FROM
    emp
WHERE
    deptno = 30
ORDER BY
    sal DESC;

--- 다중 행 서브 쿼리 예시
-- 부서번호가 할당된 직원의 정보를 가져오세요.
SELECT
    *
FROM
    emp
WHERE
    deptno IN (
        SELECT
            deptno
        FROM
            dept
    );

--- 문제
-- 직원이 배속되지 않은 부서의 부서번호, 부서명, 위치를 출력하세요.
SELECT
    deptno,
    dname,
    loc
FROM
    dept
WHERE
    deptno NOT IN (
        SELECT DISTINCT
            deptno
        FROM
            emp
        WHERE
            deptno IS NOT NULL
    );

-- 급여를 3000이상 받는 사원과 동일한 부서에서 일하는 사원들의 사원명과 급여, 부서번호를 출력
SELECT
    ename,
    sal,
    deptno
FROM
    emp
WHERE
    deptno IN (
        SELECT
            deptno
        FROM
            emp
        WHERE
            sal >= 3000
    );

-- 각 부서별 최소 연봉을 받는 사람들과 동일한 급여를 받는 사원의 사원명, 급여, 부서번호를 출력하세요.
SELECT
    ename,
    sal,
    deptno
FROM
    emp
WHERE
    sal IN (
        SELECT
            MIN(sal)
        FROM
            emp
        GROUP BY
            deptno
    );

---- 2교시
--- ALL
SELECT
    *
FROM
    emp
WHERE
    sal < ALL ( 1000,
                2000,
                3000 )
ORDER BY
    sal;

SELECT
    *
FROM
    emp
WHERE
    sal > ALL ( 1000,
                2000,
                3000 )
ORDER BY
    sal;

SELECT
    ename,
    sal
FROM
    emp
WHERE
    sal > ALL (
        SELECT
            sal
        FROM
            emp
        WHERE
            deptno = 30
    );

--- 문제
-- 부서번호가 30번인 사원들의 급여 중 가장 작은 값(950)보다 적은 급여를 받는 사람의 이름, 급여, 부서번호를 출력
-- = SALES 부서에서 근무하는 사원의 최소 급여를 받는 사원보다 더 적은 급여를 받는 사원의 이름, 급여, 부서번호를 출력
SELECT
    ename,
    sal,
    deptno
FROM
    emp
WHERE
    sal < ALL (
        SELECT
            sal
        FROM
            emp
        WHERE
            deptno = 30
    );

-- (위 문제 변형)SALES 부서에서 근무하는 사원의 최소 급여를 받는 사원보다 더 적은 급여를 받는 사원의 이름, 급여, 부서번호를 출력
SELECT
    ename,
    sal,
    deptno
FROM
    emp
WHERE
    sal < ALL (
        SELECT
            sal
        FROM
            emp
        WHERE
            deptno = (
                SELECT
                    deptno
                FROM
                    dept
                WHERE
                    dname = 'SALES'
            )
    );

-- 부서별 평균 연봉 중 최대 평균연봉보다 더 큰 연봉을 받는 사원의 사번, 이름, 직책, 연봉을 출력하세요.
SELECT
    empno,
    ename,
    job,
    sal
FROM
    emp
WHERE
    sal > ALL (
        SELECT
            AVG(sal)
        FROM
            emp
        GROUP BY
            deptno
    );

--- ANY
SELECT
    *
FROM
    emp
WHERE
    sal < ANY ( 1000,
                2000,
                3000 )
ORDER BY
    sal;

SELECT
    *
FROM
    emp
WHERE
    sal > ANY ( 1000,
                2000,
                3000 )
ORDER BY
    sal;

--- 예제
-- SALES 부서에 근무하는 사원들의 최소연봉보다 큰 연봉을 받는 사원의 사번, 이름, 부서번호, 연봉을 출력하세요.
SELECT
    empno,
    ename,
    deptno,
    sal
FROM
    emp
WHERE
    sal > ANY (
        SELECT
            sal
        FROM
            emp
        WHERE
            deptno = (
                SELECT
                    deptno
                FROM
                    dept
                WHERE
                    dname = 'SALES'
            )
    );

-- (단, SALES 부서에 근무하는 사원이 아닌 사원들만 출력하세요.)
SELECT
    empno,
    ename,
    deptno,
    sal
FROM
    emp
WHERE
        deptno != (
            SELECT
                deptno
            FROM
                dept
            WHERE
                dname = 'SALES'
        )
    AND sal > ANY (
        SELECT
            sal
        FROM
            emp
        WHERE
            deptno = (
                SELECT
                    deptno
                FROM
                    dept
                WHERE
                    dname = 'SALES'
            )
    );

---- 3교시
--- 문제
-- 'CLERK' 직책이 아니면서, 'CLERK'이 받는 최고 급여보다 더 적은 급여를 받는 사원을 출력하세요.
SELECT
    *
FROM
    emp
WHERE
        job <> 'CLERK'
    AND sal < ANY (
        SELECT
            sal
        FROM
            emp
        WHERE
            job = 'CLERK'
    );

-- EMP 테이블을 복사하여 EMP01 테이블을 생성하세요.
CREATE TABLE emp01
    AS
        SELECT
            *
        FROM
            emp;

-- EMP 테이블의 구조만 복사하여 EMP01 테이블을 생성하세요.
CREATE TABLE emp01
    AS
        SELECT
            *
        FROM
            emp
        WHERE
            1 = 0;

-- EMP 테이블 구조만 복사해 EMP04, EMP05 테이블 생성
CREATE TABLE emp04
    AS
        SELECT
            *
        FROM
            emp
        WHERE
            1 = 0;

CREATE TABLE emp05
    AS
        SELECT
            *
        FROM
            emp
        WHERE
            1 = 0;

--- INSERT
INSERT ALL INTO emp04 VALUES (
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno
) SELECT
      *
  FROM
      emp;

INSERT ALL INTO emp04 (
    empno,
    ename,
    deptno
) VALUES (
    empno,
    ename,
    deptno
) SELECT -- *로 바꾸어도 동일하게 동작한다.
      empno,
      ename,
      deptno
  FROM
      emp;

INSERT ALL
    INTO emp04
INTO emp05 VALUES (
    empno,
    ename,
    job,
    mgr,
    hiredate,
    sal,
    comm,
    deptno
) SELECT
      *
  FROM
      emp;

---- 4교시
-- EMP04테이블은 컬럼 EMPNO, ENAME, JOB만,
-- EMP05는 컬럼 EMPNO, ENAME, MGR, JOB만 남기기
ALTER TABLE emp04 DROP ( mgr,
                         hiredate,
                         sal,
                         comm,
                         deptno );

ALTER TABLE emp05 DROP ( hiredate,
                         sal,
                         comm,
                         deptno );

--
INSERT ALL INTO emp04 VALUES (
    empno,
    ename,
    job
) INTO emp05 VALUES (
    empno,
    ename,
    job,
    mgr
) SELECT
      empno,
      ename,
      job,
      mgr,
      hiredate,
      sal,
      comm,
      deptno
  FROM
      emp;

--
INSERT ALL INTO emp04 VALUES (
    empno,
    ename,
    job
) INTO emp05 VALUES (
    empno,
    ename,
    job,
    empno
) SELECT
      empno,
      ename,
      job,
      mgr,
      hiredate,
      sal,
      comm,
      deptno
  FROM
      emp;

--- 문제
-- EMP 테이블의 EMPNO, ENAME, SAL 칼럼의 구조만 복사해 EMP01 테이블 생성
CREATE TABLE emp01
    AS
        SELECT
            empno,
            ename,
            sal
        FROM
            emp
        WHERE
            1 = 0;

-- EMP 테이블의 EMPNO, ENAME 컬럼만 구조와 데이터를 복사해 EMP02 테이블 생성
CREATE TABLE emp02
    AS
        SELECT
            empno,
            ename
        FROM
            emp;

-- EMP 테이블에서 부서번호가 20번 이상의 사원들의 데이터를 가져와서
-- EMP01 테이블과 EMP02 테이블에 복사해서 넣으세요.
INSERT ALL INTO emp01 VALUES (
    empno,
    ename,
    sal
) INTO emp02 VALUES (
    empno,
    ename
) SELECT
        *
    FROM
        emp
  WHERE
      deptno >= 20;

-- EMP02 테이블에 COMM(NUMBER(7,2)) 컬럼을 추가하세요.
ALTER TABLE emp02 ADD comm NUMBER(7, 2);

-- EMP 테이블에서 평균급여보다 더 높은 사원의 정보를 가져와서
-- EMP01 테이블에는 사번, 이름, 연봉을 넣고,
-- EMP02 테이블에는 사번, 이름만 넣으세요.
INSERT ALL INTO emp01 (
    empno,
    ename,
    sal
) VALUES (
    empno,
    ename,
    sal
) INTO emp02 (
    empno,
    ename
) VALUES (
    empno,
    ename
) SELECT
        *
    FROM
        emp
  WHERE
      sal > (
          SELECT
              AVG(sal)
          FROM
              emp
      );

-- DEPT 테이블의 구조만 복사해서 DEPT01 테이블 생성
CREATE TABLE dept01
    AS
        SELECT
            *
        FROM
            dept
        WHERE
            1 = 0;

INSERT ALL INTO dept01 VALUES (
    deptno,
    dname,
    loc
) SELECT
      *
  FROM
      dept;

COMMIT;

-- DEPT 테이블에서 40번 부서의 위치를 가져와서 DEPT01 테이블 안의 10번 부서에 해당하는 위치의 값을 변경하세요.
UPDATE dept01
SET
    loc = (
        SELECT
            loc
        FROM
            dept
        WHERE
            deptno = 40
    )
WHERE
    deptno = 10;

---- 5교시
--- 다중컬럼 서브쿼리
SELECT
    *
FROM
    emp
WHERE
    ( empno,
      ename ) = (
        SELECT
            7839,
            'KING'
        FROM
            dual
    );

SELECT
    *
FROM
    emp
WHERE
    ( empno, ename ) IN (
        SELECT
            empno, ename
        FROM
            emp
        WHERE
            deptno = 20
    );

UPDATE dept01
SET
    ( dname,
      loc ) = (
        SELECT
            dname,
            loc
        FROM
            dept
        WHERE
            deptno = 30
    )
WHERE
    deptno = 20;

CREATE TABLE emp01
AS
SELECT * FROM emp;

-- EMP01 테이블에 DNM VARCHAR2(20) 컬럼을 추가하세요.
ALTER TABLE emp01
ADD dnm VARCHAR2(20);

-- DEPT 테이블에서 해당 부서명을 가져와서 EMP01 테이블에 넣으세요
UPDATE emp01 e
SET dnm = (
    SELECT dname
    FROM dept d
    WHERE d.deptno = e.deptno
);

--
UPDATE emp01
SET (empno, ename) = (SELECT 1111, '첫째' FROM dual);

--
DELETE FROM emp01
WHERE deptno = (SELECT deptno FROM dept WHERE dname = 'SALES');

--

---- 6교시
DROP TABLE emp;
DROP TABLE dept;

CREATE TABLE EMP AS SELECT * FROM SCOTT.EMP;
CREATE TABLE DEPT AS SELECT * FROM SCOTT.DEPT;

-- dept 테이블 deptno => PK(P), dname => nn(C)
ALTER TABLE dept
ADD CONSTRAINT dept_deptno_pk PRIMARY KEY (deptno);

ALTER TABLE dept
MODIFY (dname CONSTRAINT dept_dname_nn NOT NULL);

-- emp 테이블 empno => PK(P), deptno(R => FK)
ALTER TABLE emp
MODIFY (empno CONSTRAINT emp_empno_pk PRIMARY KEY);

ALTER TABLE emp
ADD CONSTRAINT emp_deptno_fk FOREIGN KEY(deptno)REFERENCES dept(deptno);

-- 제약조건 살펴볼것
CREATE TABLE emp01 AS SELECT * FROM emp;
CREATE TABLE dept01 AS SELECT * FROM dept;

DROP TABLE emp01;
DROP TABLE dept01;

-- 오른쪽 - 익스포트 - 찾아보기 - C:\Users\hi\Downloads\TEST_DEPT.sql - 다음 - 다음 - 완료
-- 창 - SQL 워크시트

---- 7교시
-- C:\Users\hi>exp HR/1111@XE file=C:\Users\hi\Downloads\hr.dmp
-- C:\Users\hi>imp userid=TEST/1111@XE file=C:\Users\hi\Downloads\hr.dmp fromuser=HR touser=TEST

-- 제약조건 없애기
ALTER TABLE emp DROP CONSTRAINT emp_deptno_fk;
ALTER TABLE emp DROP CONSTRAINT emp_empno_pk;
ALTER TABLE dept DROP CONSTRAINT dept_deptno_pk;
ALTER TABLE dept DROP CONSTRAINT dept_dname_nn;

--- 8교시
-- 부서번호를 기준으로 같은 값을 가진 사원 테이블과 부서 테이블 결합
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 위 코드 테이블 순서 교체
SELECT * FROM dept, emp
WHERE dept.deptno = emp.deptno;

-- 카다시안 조인
SELECT * FROM emp, dept;

-- ANSI CROSS JOIN
SELECT * FROM dept CROSS JOIN emp;

SELECT
e.ename, d.dname, e.deptno as edno, d.deptno as ddno
FROM emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY ddno;

SELECT
e.ename, d.dname, e.deptno as edno, d.deptno as ddno
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE e.deptno = 20
ORDER BY ddno;

--- 문제
-- emp 테이블과 departments 테이블을 이너조인하여 emp 테이블의 사번, 이름, 부서번호와 departments 테이블의 부서번호, 부서명, 상위부서번호가 출력되도록 하세요.
SELECT empno, ename, deptno, department_id, department_name, manager_id
FROM emp, departments
WHERE deptno = department_id;

-- ANSI
SELECT empno, ename, deptno, department_id, department_name, manager_id
FROM emp e
JOIN departments d
ON deptno = department_id;

-- emp 정보는 전부 출력
SELECT emp.*, department_name, manager_id
FROM emp, departments
WHERE deptno = department_id;

-- 커미션을 받는 모든 사원의 이름, 부서번호, 부서명, 위치를 표시
SELECT e.ename, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno AND nvl(e.comm, 0) > 0;

-- ANSI
SELECT e.ename, e.deptno, d.dname, d.loc
FROM emp e
JOIN dept d
ON e.deptno = d.deptno
WHERE nvl(e.comm, 0) > 0;

-- 이름 A가 들어가는 모든 사원의 이름과 부서명을 표시
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno AND e.ename LIKE '%A%';

-- ANSI
SELECT e.ename, d.dname
FROM emp e
JOIN dept d
ON e.deptno = d.deptno
WHERE e.ename LIKE '%A%';

-- 서브쿼리
SELECT e.ename, (SELECT dname FROM dept d WHERE d.deptno = emp.deptno) dname
FROM emp
WHERE e.ename LIKE '%A%';