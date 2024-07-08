-- 사원정보테이블.xlsx을 보고 테이블을 만드세요.
CREATE TABLE employ (
    empid    NUMBER(4, 0),
    name     VARCHAR2(10),
    job      VARCHAR2(10),
    deptid   NUMBER(3, 0),
    salary   NUMBER(4, 0),
    bonus    NUMBER(3, 0),
    mgrid    NUMBER(4, 0),
    hiredate DATE
);

INSERT INTO employ VALUES (
    6200,
    '김철수',
    '이사',
    200,
    5000,
    NULL,
    NULL,
    '1997-12-17'
);

INSERT INTO employ VALUES (
    6311,
    '전우치',
    '부장',
    100,
    3500,
    NULL,
    6200,
    '1998-12-17'
);

INSERT INTO employ VALUES (
    7489,
    '송아지',
    '세일즈',
    400,
    1850,
    200,
    6321,
    '1999-02-27'
);

INSERT INTO employ VALUES (
    7522,
    '오라클',
    '세일즈',
    400,
    1850,
    300,
    6321,
    '1998-02-28'
);

INSERT INTO employ VALUES (
    6321,
    '강아지',
    '부장',
    400,
    3800,
    500,
    6200,
    '1999-04-20'
);

INSERT INTO employ VALUES (
    6351,
    '고구려',
    '부장',
    300,
    2850,
    NULL,
    6200,
    '2001-05-31'
);

INSERT INTO employ VALUES (
    7910,
    '이영희',
    '경리',
    300,
    1000,
    NULL,
    6351,
    '2001-05-01'
);

INSERT INTO employ VALUES (
    6361,
    '이발소',
    '부장',
    200,
    3200,
    NULL,
    6200,
    '2000-06-09'
);

INSERT INTO employ VALUES (
    7878,
    '박수처',
    '연구직',
    200,
    3000,
    NULL,
    6361,
    '2001-06-05'
);

INSERT INTO employ VALUES (
    7854,
    '최우수',
    '세일즈',
    400,
    1500,
    0,
    6321,
    '2001-09-08'
);

INSERT INTO employ VALUES (
    7821,
    '임꺽정',
    '사무직',
    100,
    1500,
    NULL,
    6311,
    '2001-02-12'
);

INSERT INTO employ VALUES (
    7920,
    '김말이',
    '사무직',
    300,
    1050,
    NULL,
    6351,
    '2001-03-18'
);

INSERT INTO employ VALUES (
    7901,
    '정동진',
    '연구직',
    300,
    3000,
    NULL,
    NULL,
    '2001-12-03'
);

INSERT INTO employ VALUES (
    7933,
    '홍길동',
    '사무직',
    200,
    1050,
    NULL,
    6361,
    '2002-01-02'
);

-- 사원정보테이블.xlsx을 보고 아래 결과가 나오도록 코드를 작성하세요.
-- 1. 사원의 급여에 12를 곱한 결과만 출력되도록 수식을 적용하고, 수식의 별칭을 "연봉"으로 표시하시오.
SELECT
    salary * 12 AS "연봉"
FROM
    employ;

-- 2. 업무가 '세일즈'인 사원의 이름, 업무, 부서아이디를 검색하시오.
SELECT
    name,
    job,
    deptid
FROM
    employ
WHERE
    job = '세일즈';

-- 3. 입사일이 '2001년 12월 3일'인 사원을 검색하시오.
SELECT
    *
FROM
    employ
WHERE
    hiredate = '2001/12/03';

-- 4. 급여가 3000 이상이고 5000 이하인 사원의 이름, 급여를 검색하시오.
SELECT
    name,
    salary
FROM
    employ
WHERE
    salary BETWEEN 3000 AND 5000;

-- 5. 업무가 '사무직'이거나 '경리'인 사원을 검색하시오.
SELECT
    *
FROM
    employ
WHERE
    job IN ('사무직', '경리');

-- 6. 급여가 3000 이상이고 업무가 '부장'인 사원을 검색하시오.
SELECT
    *
FROM
    employ
WHERE
        salary >= 3000
    AND job = '부장';

-- 7. 업무가 '세일즈'가 아니거나 '사무직'이 아닌 사원을 검색하시오.
SELECT
    *
FROM
    employ
WHERE
    job NOT IN ( '세일즈', '사무직' );
--        job != '사무직'
--    AND job != '세일즈';
--    NOT ( job != '사무직'
--          OR job != '세일즈' );

-- 8. 이름에 '철'이라는 문자를 포함하는 경우의 사원을 검색하시오.
SELECT
    *
FROM
    employ
WHERE
    name LIKE '%철%';

-- 9. 보너스를 받지 않는 사원을 검색하시오.
SELECT
    *
FROM
    employ
WHERE
    bonus = 0
    OR bonus IS NULL;
--    nvl(bonus, 0) = 0;

-- 10. 2001년 이후에 입사한 사원을 삭제하시오.
DELETE FROM employ
WHERE
    hiredate >= '2001/01/01';