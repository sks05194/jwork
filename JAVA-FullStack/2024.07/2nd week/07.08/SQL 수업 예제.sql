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
select * from tab;

-- 확정 저장
commit;

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

-- DEPT01 테이블에 부서번호 40, 부서명 : 'OPERATIONS', LOC : null인 데이터를 추가하세요.
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
    substr(hiredate, 0, 2) = '82';

UPDATE emp01
SET
    hiredate = sysdate
WHERE
    hiredate BETWEEN '1982/01/01' AND '1982/12/31';

UPDATE emp01
SET
    hiredate = sysdate
WHERE
        hiredate >= '1982/01/01'
    AND hiredate <= '1982/12/31';

-- EMP01 테이블에서 JAMES의 부서번호는 20번, 직급은 MANAGER로 수정
UPDATE emp01
SET
    deptno = 20,
    job = 'MANAGER'
WHERE
    ename = 'JAMES';

    