-- 집계함수 사용 예시(COUNT)
SELECT
    COUNT(*)
FROM
    emp;

-- 집계함수 사용 예시(SUM)
SELECT
    SUM(sal)
FROM
    emp;

-- 집계함수 사용 예시(AVG)
SELECT
    AVG(sal)
FROM
    emp;

-- 집계함수 사용 예시(MAX, MIN)
SELECT
    MAX(sal),
    MIN(sal)
FROM
    emp;

-- NUll이 있는 데이터의 집계함수 사용 예시(COUNT)
SELECT
    COUNT(comm)
FROM
    emp;

/* GROUP BY */
-- GROUP BY 사용 예시
SELECT
    deptno
FROM
    emp
GROUP BY
    deptno;

-- 해당 조건에 맞는 인원수 세기
SELECT
    deptno,
    COUNT(deptno)
FROM
    emp
GROUP BY
    deptno;

-- 해당 조건에 맞는 인원의 급여 합산
SELECT
    deptno,
    SUM(sal)
FROM
    emp
GROUP BY
    deptno;

/* GROUP BY 연습 */
--  GROUP BY 연습 1
SELECT
    deptno,
    SUM(sal),
    AVG(sal)
FROM
    emp
GROUP BY
    deptno;

--  GROUP BY 연습 2
SELECT
    deptno,
    MAX(sal),
    MIN(sal)
FROM
    emp
GROUP BY
    deptno;

--  GROUP BY 연습 3
SELECT
    comm,
    COUNT(comm)
FROM
    emp
GROUP BY
    comm;
    
--  GROUP BY 연습 4
SELECT
    comm,
    COUNT(*)
FROM
    emp
GROUP BY
    comm;

-- HAVING 사용 예시
SELECT
    deptno,
    AVG(sal)
FROM
    emp
GROUP BY
    deptno
HAVING
    AVG(sal) >= 2000;

/* 문제 */
-- 부서별로 급여의 최대값이 2900을 초과하는 경우 부서별 최대값과 최소값 자료만 산출
SELECT
    MAX(sal),
    MIN(sal)
FROM
    emp
GROUP BY
    deptno
HAVING
    MAX(sal) > 2900;

-- 테이블에서 1000 이상의 급여를 가지고 있는 사람들에 대해서만 부서별로 평균을 구한 후
-- 구해진 부서별 평균 급여가 2000 이상인 부서 번호와 부서별 평균 급여를 부서의 오름차순으로 출력하세요.
SELECT
    deptno,
    AVG(sal)
FROM
    emp
WHERE
    sal >= 1000
GROUP BY
    deptno
HAVING
    AVG(sal) >= 2000
ORDER BY
    deptno ASC;

-- 직종별, 부서별 급여의 합과 인원수를 구한 후 20번 부서의 내용만 출력하세요.
SELECT
    job,
    SUM(sal),
    COUNT(*)
FROM
    emp
WHERE
    deptno = 20
GROUP BY
    job;

-- 부서별 급여의 평균과 합을 구한 후 각 부서별 인원이 5명 이상인 부서들만 출력
SELECT
    deptno,
    AVG(sal),
    SUM(sal)
FROM
    emp
GROUP BY
    deptno
HAVING
    COUNT(*) >= 5;

/* 데이터에 문자열 넣기 */
SELECT
    ename, ' is a ', job
FROM
    emp;

-- 컬럼명에 별칭 붙이기
SELECT
    ename, ' is a ' AS " IS A ", job
FROM
    emp;

-- 각 부서별, 직책 종류가 어떻게 되는지 검색하세요.
SELECT DISTINCT
    deptno,
    job
FROM
    emp
ORDER BY
    deptno,
    job;

-- ORDER BY가 여러개 올 경우
SELECT
    deptno,
    empno,
    ename
FROM
    emp
ORDER BY
    deptno,
    empno;

-- DUAL 테이블
SELECT
    50 * 50
FROM
    dual;

/* 숫자 함수 */
-- CEIL(실수값)
SELECT
    ceil(34.5678)
FROM
    dual;

-- FLOOR(실수값)
SELECT
    floor(34.5678)
FROM
    dual;

-- ROUND(실수값)
SELECT
    round(34.5678)
FROM
    dual;

-- ROUND(실수값, 소수점자리수)
SELECT
    round(34.5678, 2)
FROM
    dual;

-- MOD(피젯수, 젯수)
SELECT
    mod(34, 2),
    mod(34, 5),
    mod(34, 7)
FROM
    dual;

/* 문제 */
-- 사번이 짝수인 사원들의 empno, ename, job을 출력
SELECT
    empno,
    ename,
    job
FROM
    emp
WHERE
    mod(empno, 2) = 0;

/* ROUND의 2번째 매개변수에 따른 차이 */
-- ROUND(양수)
SELECT
    round(345.678, 2)
FROM
    dual;

-- ROUND(0)
SELECT
    round(345.678, 0)
FROM
    dual;

-- ROUND(미포함)
SELECT
    round(345.678)
FROM
    dual;

-- ROUND(음수)
SELECT
    round(345.678, -1)
FROM
    dual;

/* 문자 함수 */
-- LOWER 사용 예시(문자열)
SELECT
    'DataBase',
    lower('DataBase')
FROM
    dual;

-- LOWER 사용 예시(컬럼)
SELECT
    ename,
    lower(ename)
FROM
    emp
WHERE
    deptno = 10;

-- UPPER 사용 예시(문자열)
SELECT
    'DataBase',
    upper('DataBase')
FROM
    dual;

-- UPPER 사용 예시(컬럼)
SELECT
    empno,
    ename,
    job
FROM
    emp
WHERE
    job = upper('manager');


-- LOWER 사용 예제(소문자로 대문자 데이터 찾아오기)
SELECT
    *
FROM
    emp
WHERE
    lower(ename) = 'smith';

-- CONCAT 사용 예시
SELECT
    concat('Data', 'Base')
FROM
    dual;

-- CONCAT 중첩 예시
SELECT
    concat(concat(ename, ', '),
           job)
FROM
    emp;


-- DISTINCT 키워드, 함수 내 사용 예시
SELECT
    COUNT(DISTINCT deptno)
FROM
    emp;


-- LENGTH 1
SELECT
    length('DATA'),
    length('오라클')
FROM
    dual;

-- LENGTH 2
SELECT
    deptno,
    empno,
    ename,
    length(ename)
FROM
    emp
WHERE
    deptno = 10;

-- LENGTH 3
SELECT
    *
FROM
    emp
WHERE
    length(ename) <= 4;

-- SUBSTR
SELECT
    substr('DatatBase', 2, 3)
FROM
    dual;

SELECT
    substr('DatatBase', -4, 3)
FROM
    dual;

/* 예제 */
-- 입사년도 추출
SELECT
    ename,
    substr(hiredate, 1, 2)
FROM
    emp
WHERE
    deptno = 20;

-- 82년도에 입사한 사원 1
SELECT
    ename,
    hiredate
FROM
    emp
WHERE
    substr(hiredate, 1, 2) = '82';

-- 82년도에 입사한 사원 2
SELECT
    ename,
    hiredate
FROM
    emp
WHERE
    hiredate BETWEEN '81/01/01' AND '81/12/31';

-- 이름이 S로 끝나는 사원 1
SELECT
    ename
FROM
    emp
WHERE
    substr(ename, - 1, 1) = 'S';

-- 이름이 S로 끝나는 사원 2
SELECT
    ename
FROM
    emp
WHERE
    ename LIKE '%S';

-- INSTR
SELECT
    instr('DataBase', 'B')
FROM
    dual;

SELECT
    deptno,
    ename,
    instr(ename, 'E')
FROM
    emp
WHERE
    deptno = 30;

/* 예제 */
-- 3번째부터 검색해 첫 번째 발견된 글자의 위치
SELECT
    instr('DataBase', 'a', 3, 1)
FROM
    dual;

-- 3번째부터 검색해 두 번째 발견된 글자의 위치
SELECT
    instr('DataBase', 'a', - 5, 2)
FROM
    dual;

SELECT
    instr('데이터베이스', '이', 3, 1)
FROM
    dual;


-- LPAD, RPAD (특정 기호로 채우기)
SELECT
    lpad('DataBase', 20, '$')
FROM
    dual;

SELECT
    rpad('DataBase', 20, '$')
FROM
    dual;

-- 주문번호
SELECT
    '240705'
    || lpad('1', 4, '0')
FROM
    dual;

-- TRIM
SELECT
    ltrim('aaaaDataBase Programingaaaa', 'a'),
    rtrim('aaaaDataBase Programingaaaa', 'a'),
    TRIM('a' FROM 'aaaaDataBase Programingaaaa')
FROM
    dual;

-- NVL 사용 예시 1
SELECT
    ename,
    sal,
    nvl(comm, 0),
    job
FROM
    emp;

SELECT
    AVG(nvl(comm, 0)) AS avg
FROM
    emp;

SELECT
    AVG(comm) AS avg
FROM
    emp;

-- NVL 사용 예시 2
SELECT
    ename,
    sal,
    comm,
    sal * 12 + comm TOT
FROM
    emp;

SELECT
    ename,
    sal,
    comm,
    sal * 12 + nvl(comm, 0)
FROM
    emp;

SELECT
    COUNT(comm)
FROM
    emp;
    
SELECT
    COUNT(nvl(comm, 0))
FROM
    emp;

SELECT
    COUNT(*)
FROM
    emp
WHERE
    comm >= 0;

SELECT
    COUNT(*)
FROM
    emp
WHERE
    nvl(comm, 0) >= 0;

-- NVL2(해당컬럼, Null이 아닐때 돌려줄 값, Null일때 돌려줄 값)
SELECT
    ename,
    mgr,
    sal,
    comm,
    nvl2(comm, sal * 0.05, sal * 0.1)
FROM
    emp;

--  COALESCE(데이터, 데이터, ... ) : 데이터가 null이 아닌 것의 첫번째 값을 반환
SELECT
    empno,
    comm,
    mgr,
    sal,
    coalesce(comm, mgr, sal)
FROM
    emp;

SELECT
    empno,
    comm,
    sal,
    coalesce(comm, sal * 0.1)
FROM
    emp;

SELECT
    empno,
    comm,
    sal,
    nvl(comm, sal * 0.1)
FROM
    emp;

-- POWER, SQRT
SELECT
    power(5, 3),
    round(sqrt(2), 4)
FROM
    dual;

-- 시간 함수
SELECT
    sysdate,
    systimestamp
FROM
    dual;

SELECT
    sysdate - 1 어제,
    sysdate     오늘,
    sysdate + 1 내일
FROM
    dual;

SELECT
    systimestamp - 1 어제,
    systimestamp     오늘,
    systimestamp + 1 내일
FROM
    dual;

SELECT
    ename,
    sysdate,
    hiredate,
    sysdate - hiredate
FROM
    emp
WHERE
    deptno = 10;

/* 예제 */
-- 월의 16일을 기준으로 반올림
SELECT
    hiredate,
    round(hiredate, 'MONTH')
FROM
    emp
WHERE
    deptno = 10;

-- 년의 7월 1일부터 반올림
SELECT
    hiredate,
    round(hiredate, 'YEAR')
FROM
    emp
WHERE
    deptno = 10;

-- TRUNC 함수
SELECT
    hiredate,
    trunc(hiredate, 'MONTH')
FROM
    emp
WHERE
    deptno = 10;
    
-- TO_CHAR(날짜)
SELECT
    sysdate,
    to_char(sysdate, 'YYYY-MM-DD HH12:MI:SS AM DAY')
FROM
    dual;

SELECT
    systimestamp,
    to_char(systimestamp, 'YYYY-MM-DD HH12:MI:SS.FF3 AM DAY')
FROM
    dual;

SELECT
    to_char(hiredate, 'YYYY/MM/DD DAY') startday
FROM
    emp
WHERE
    deptno = 10;

SELECT
    to_char(sysdate, 'YYYY/MM/DD AM') startday
FROM
    dual;

SELECT
    to_char(sysdate, 'AM', 'NLS_DATE_LANGUAGE=AMERICAN') AS american,
    to_char(sysdate, 'AM', 'nls_date_language=korean')   AS american
FROM
    dual;

SELECT
    to_char(sysdate, 'yyyy/mm/dd AM', 'NLS_DATE_LANGUAGE=AMERICAN') AS american,
    to_char(sysdate, 'AM', 'nls_date_language=korean')   AS american
FROM
    dual;

-- TO_CHAR(숫자)
SELECT
    to_char(123456, '000,000,000'),
    to_char(123456, '999,999,999'),
    to_char(- 123456, '000,000,000'),
    to_char(- 123456, '999,999,999')
FROM
    dual;


SELECT
    ename,
    nvl(to_char(mgr, ''), 'CEO')
FROM
    emp
WHERE
    mgr IS NULL;

SELECT
    mgr,
    nvl(to_char(mgr, '9999'), 'CEO')
FROM
    emp;


-- TO_DATE
SELECT
    ename,
    hiredate
FROM
    emp
WHERE
    hiredate = TO_DATE('19810220', 'YYYYMMDD');

SELECT
    trunc((sysdate - TO_DATE('2011-01-01', 'YYYY/MM/DD')) / 365)
FROM
    dual;

--  D : 요일을 숫자로 반환 1-일요일, 2-월요일, ...
SELECT
    to_char(TO_DATE('2014/1/2'),
            'D')
FROM
    dual;

--NEXT_DAY
SELECT
    next_day(sysdate, '토요일')
FROM
    dual;

SELECT
    next_day(sysdate, '금')
FROM
    dual;

SELECT
    next_day(sysdate, 7)
FROM
    dual;

SELECT
    next_day(sysdate - 8, '토요일')
FROM
    dual;

--TO_NUMBER(데이터, '출력형식')
SELECT
    TO_NUMBER('1234567'),
    TO_NUMBER('10,000.123', '999,999.999')
FROM
    dual;

SELECT
    TO_NUMBER('10,000', '999,999'),
    TO_NUMBER('20,000', '999,999,999')
FROM
    dual;

SELECT
    TO_NUMBER('10,000', '999,999') + TO_NUMBER('20,000', '999,999,999') AS sum
FROM
    dual;

SELECT
    TO_NUMBER('10,000', '999,999,999'),
    TO_NUMBER('20,000', '999,999,999')
FROM
    dual;

-- 조건문
SELECT
    ename,
    deptno,
    decode(deptno, 10, 'ACCOUNTING', 20, 'RESEARCH',
           'ETC') AS dname
FROM
    emp;

-- 사원정보 테이블에서 ename을 "직원성명"이라는 컬럼으로, job컬럼을 "직책"이라는 컬럼으로 출력하고,
-- 해당 사원의 직책이 'SALESMAN'인 경우는 'O'라고 출력이 되도록, 'SALESMAN'이 아닌 경우 'X'로 출력이 되도록 한 뒤
-- 해당 컬럼을 "세일즈맨 여부"로 나오도록 처리하세요.
SELECT
    ename                             "직원성명",
    job                               "직책",
    decode(job, 'SALESMAN', 'O', 'X') "세일즈맨 여부"
FROM
    emp;

-- 사원정보 테이블에서
-- 사원명, 직책, 연봉을 출력하고
-- 만약 직책이 'ANALYST'인 경우는 급여의 5% 인상된 금액으로 출력,
-- 직책이 'SALESMAN'인 경우는 급여의 10% 인상된 금액으로 출력,
-- 직책이 'MANAGER'인 경우는 급여의 15% 인상된 금액으로 출력,
-- 직책이 'CLERK'인 경우는 급여의 20% 인상된 금액으로 출력하도록 처리하세요.
SELECT
    ename,
    job,
    sal,
    decode(job, 'ANALYST', sal * 1.05, 'SALESMAN', sal * 1.1,
           'MANAGER', sal * 1.15, 'CLERK', sal * 1.2, sal) AS "연상된 급여"
FROM
    emp;


/* 문제 */
-- 사원정보테이블에서 이름, 연봉을 출력하고,
-- 연봉이 1500 이상이면 'MID'로 출력을
-- 연봉이 3000 이상이면 'HI'로 출력을
-- 연봉이 5000 이상이면 'TOP'으로 출력을
-- 1500 미만이면 'LOW'로 출력이 되도록  처리하세요.
-- 해당 케이스에 대한 컬럼명은 '비고'로 나오도록 처리해주세요.
SELECT
    ename,
    sal,
    CASE
        WHEN sal >= 5000 THEN
            'TOP'
        WHEN sal >= 3000 THEN
            'HI'
        WHEN sal >= 1500 THEN
            'MID'
        ELSE
            'LOW'
    END AS "비고"
FROM
    emp;