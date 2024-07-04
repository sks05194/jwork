-- 1. 이름이 J로 시작하는 사원의 이름, 사번, 입사일자를 출력하세요.
SELECT
    ename,
    empno,
    hiredate
FROM
    emp
WHERE
    ename LIKE 'J%';

-- 2. 이름이 N으로 끝나는 사원의 이름, 사번, 연봉을 출력하되 이름을 오름차순으로 출력하세요.
SELECT
    ename,
    empno,
    sal
FROM
    emp
WHERE
    ename LIKE '%N'
ORDER BY
    ename;

-- 3. 이름에 A자가 들어가는 사원의 정보를 출력하되, 입사일자가 내림차순으로 되도록 출력하세요.
SELECT
    *
FROM
    emp
WHERE
    ename LIKE '%A%'
ORDER BY
    hiredate DESC;

-- 4. 이름의 두번째 글자가 A로 시작되는 사원의 정보를 모두 출력하세요.
SELECT
    *
FROM
    emp
WHERE
    ename LIKE '_A%';

-- 5. 이름의 두번째 글자가 L, 네번째 글자가 R로 시작하는 사원의 이름, 사번, 상위관리자 사번를 출력하세요.
SELECT
    ename,
    empno,
    mgr
FROM
    emp
WHERE
    ename LIKE '_L_R%';

-- 6. 이름이 4글자이면서 D로 끝나는 사원을 출력하세요
SELECT
    *
FROM
    emp
WHERE
    ename LIKE '___D';

-- 7. 이름에 A글자가 포함되지 않은 사원의 사번, 이름을 출력하세요.
SELECT
    empno,
    ename
FROM
    emp
WHERE
    NOT ename LIKE '%A%';