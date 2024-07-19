---- 1교시
CREATE TABLE pay (
    memid   VARCHAR2(12) PRIMARY KEY,
    orderid VARCHAR2(12),
    price   NUMBER
);

CREATE TABLE orderlist (
    orderid     VARCHAR2(12) PRIMARY KEY,
    productname VARCHAR2(12)
);