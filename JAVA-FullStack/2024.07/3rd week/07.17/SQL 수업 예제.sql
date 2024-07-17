CREATE TABLE tb_member (
    m_seq        NUMBER CONSTRAINT pk_member_seq PRIMARY KEY,
    m_userid     VARCHAR2(20) NOT NULL,
    m_pwd        VARCHAR2(20) NOT NULL,
    m_email      VARCHAR2(50),
    m_hp         VARCHAR2(20),
    m_registdate DATE DEFAULT sysdate,
    m_pont       NUMBER DEFAULT 0
);

CREATE SEQUENCE seq_tb_member;

INSERT INTO tb_member ( m_seq, m_userid, m_pwd, m_email, m_hp )
VALUES ( seq_tb_member.NEXTVAL, 'apple', '1111', 'apple@apple.com', '010-8888-9999' );

COMMIT;