-- 커미션 란이 있는 사람의 연봉과 커미션도 총급여 란에 출력해주세요.
SELECT
    empno,
    ename,
    sal,
    comm,
    sal + comm AS 총급여
FROM
    emp
WHERE
    comm IS NOT NULL;

-- 문자열 결합
SELECT
    ename || '의 총 급여는' || (sal + comm) || '입니다.' AS 결과
FROM
    emp
WHERE
    comm IS NOT NULL;

-- 중복값 제외하기
SELECT
    DISTINCT deptno
FROM
    emp;

-- 사원 테이블에서 직책의 종류를 알고 싶다
SELECT
    DISTINCT job
FROM
    emp;

-- 존스라는 사람이 데리고 있는 부하직원을 출력하시오
SELECT
    *
FROM
    emp
WHERE
    mgr = 7566;

-- BLAKE가 관리하는 부하직원을 검색한 뒤 해당 부하직원들의 직책은 어떤 것이 있는지 출력하세요.
SELECT DISTINCT
    job
FROM
    emp
WHERE
    mgr = 7698;