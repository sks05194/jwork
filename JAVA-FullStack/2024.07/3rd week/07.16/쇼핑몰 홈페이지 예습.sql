-- 쇼핑몰 홈페이지 메뉴 중 회원가입 메뉴를 만들겠습니다.
-- 테이블명 : MEMBER
-- 필요한 정보 : 
-- mid 아이디(영어대소문자, 숫자까지만 가능, 총 20자리)
-- mpw 비밀번호(영어대소문자, 숫자까지만 가능, 총 20자리)
-- mnm 이름(200byte)
-- mph 전화정보
-- mzip 주소(우편번호) maddr (주소)

CREATE TABLE member (
    mid VARCHAR2(20) CONSTRAINT member_mid_pk PRIMARY KEY,
    mpw VARCHAR2(20) NOT NULL,
    mnm VARCHAR2(200) NOT NULL,
    mph VARCHAR2(11) NOT NULL,
    mzip VARCHAR2(7),
    maddr VARCHAR2(200)
);