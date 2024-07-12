-- 문제

-- 1. 사원의 급여에 12를 곱한 결과만 출력되도록 수식을 적용하고,
--    수식의 별칭을 "연봉" 으로 표시하시오.
SELECT salary * 12 AS "연봉"
FROM employ;

-- 2. 업무가 '세일즈' 인 사원의 이름, 업무, 부서아이디를 검색하시오.
SELECT name, job, deptid
FROM employ
WHERE job = '세일즈';

-- 3. 입사일이 '2001년 12월 3일' 인 사원을 검색하시오.
SELECT *
FROM employ
WHERE hiredate = '01/12/03';

-- 4. 부서아이디가 200 인 사원의 이름, 업무, 입사일, 부서아이디를 검색하시오.
SELECT name, job, hiredate, deptid
FROM employ
WHERE deptid = 200;

-- 5. 급여가 3000 이상이고 5000 이하인 사원의 이름, 급여를 검색하시오.
SELECT name, salary
FROM employ
WHERE salary BETWEEN 3000 AND 5000;

SELECT name, salary
FROM employ
WHERE salary >= 3000 AND salary <= 5000;

-- 6. 관리자아이디가 6311, 6361, 6351 중에서 해당하는 경우의 사원아이디, 관리자아이디, 이름, 부서아이디를 검색하시오.
SELECT empid, mgrid, name, deptid
FROM employ
WHERE mgrid IN ( 6311, 6361, 6351 );

-- 7. 업무가 '사무직' 이거나 '경리' 인 사원을 검색하시오.
SELECT *
FROM employ
WHERE job IN ( '사무직', '경리' );

-- 8. 급여가 3000 이상이고 업무가 '부장' 인 사원을 검색하시오.
SELECT *
FROM employ
WHERE salary >= 3000 AND job = '부장';

-- 9. 업무가 ( '세일즈' 이거나 '사무직' ) 이 아닌 사원을 검색하시오.
SELECT *
FROM employ
WHERE job NOT IN ( '세일즈', '사무직' );

-- 10. 급여가 1500 ~ 2500 사이가 아닌 사원을 검색하시오.
SELECT *
FROM employ
WHERE NOT salary BETWEEN 1500 AND 2500;

-- 11. 업무가 '경리' 이거나 '부장' 이고, 급여가 3000 이 넘는 사원을 검색하시오.
SELECT *
FROM employ
WHERE job IN ('경리', '부장') AND salary > 3000;

-- 12. 입사일이 2000년 이후인 사원을 검색하시오.
SELECT *
FROM employ
WHERE to_char(hiredate, 'YYYY') >= '2000';

SELECT *
FROM employ
WHERE TO_DATE(to_char(hiredate, 'YYYY/MM/DD'), 'YYYY/MM/DD') >= '2000/01/01';

SELECT *
FROM employ
WHERE hiredate >= '2000/1/1';

-- 13. 이름에 '철' 이라는 문자를 포함하는 경우의 사원을 검색하시오.
SELECT *
FROM employ
WHERE name LIKE '%철%';

-- 14. 보너스를 받지 않는(보너스가 null인) 사원을 검색하시오.
SELECT *
FROM employ
WHERE nvl(bonus, 0) = 0;

-- 15. 입사일이 1999년도인 사원을 검색하시오.
SELECT *
FROM employ
WHERE to_char(hiredate, 'YYYY') = '1999';

-- 16. 급여가 3000 이상인 사원만 급여를 10% 인상하시오.
UPDATE employ
SET salary = salary * 1.1
WHERE salary >= 3000;

-- 17. 2001년 이후에 입사한 사원을 삭제하시오.
DELETE FROM employ
WHERE hiredate >= '2001/01/01';