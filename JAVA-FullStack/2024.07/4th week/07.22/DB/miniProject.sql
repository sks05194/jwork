--------------------------------------------------------
--  파일이 생성됨 - 월요일-7월-22-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table TEST
--------------------------------------------------------

  CREATE TABLE "LMS"."TEST" 
   (	"TY" NUMBER(4,0) DEFAULT '2024', 
	"TS" NUMBER(1,0), 
	"TN" NUMBER(2,0), 
	"TQ" VARCHAR2(200 BYTE), 
	"TA" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ANSWER
--------------------------------------------------------

  CREATE TABLE "LMS"."ANSWER" 
   (	"SNO" NUMBER(9,0), 
	"TY" NUMBER(4,0), 
	"TS" NUMBER(1,0), 
	"TN" NUMBER(2,0), 
	"ANS" VARCHAR2(1 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table STUDENT
--------------------------------------------------------

  CREATE TABLE "LMS"."STUDENT" 
   (	"SNO" NUMBER(9,0), 
	"SNM" VARCHAR2(30 BYTE), 
	"SID" VARCHAR2(20 BYTE), 
	"SPW" VARCHAR2(20 BYTE), 
	"SDATE" DATE DEFAULT '24/03/02', 
	"SLMS" VARCHAR2(1 BYTE) DEFAULT 'N'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ADMIN
--------------------------------------------------------

  CREATE TABLE "LMS"."ADMIN" 
   (	"AID" VARCHAR2(20 BYTE), 
	"APWD" VARCHAR2(20 BYTE), 
	"ANM" VARCHAR2(30 BYTE), 
	"AROLE" VARCHAR2(5 BYTE) DEFAULT 'SUB', 
	"APS" VARCHAR2(1 BYTE) DEFAULT 'N'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into LMS.TEST
SET DEFINE OFF;
REM INSERTING into LMS.ANSWER
SET DEFINE OFF;
REM INSERTING into LMS.STUDENT
SET DEFINE OFF;
Insert into LMS.STUDENT (SNO,SNM,SID,SPW,SDATE,SLMS) values (20241001,'홍길동','hgd1234','hgd1234',to_date('24/03/02','RR/MM/DD'),'Y');
REM INSERTING into LMS.ADMIN
SET DEFINE OFF;
Insert into LMS.ADMIN (AID,APWD,ANM,AROLE,APS) values ('admin','admin','관리자','SUPER','Y');
Insert into LMS.ADMIN (AID,APWD,ANM,AROLE,APS) values ('test1','test1','테스트2','SUPER','N');
Insert into LMS.ADMIN (AID,APWD,ANM,AROLE,APS) values ('test1234','test1234','테스트','SUPER','Y');
--------------------------------------------------------
--  DDL for Index TEST_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LMS"."TEST_PK" ON "LMS"."TEST" ("TY", "TS", "TN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ANSWER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LMS"."ANSWER_PK" ON "LMS"."ANSWER" ("SNO", "TY", "TS", "TN") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007133
--------------------------------------------------------

  CREATE UNIQUE INDEX "LMS"."SYS_C007133" ON "LMS"."STUDENT" ("SNO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007134
--------------------------------------------------------

  CREATE UNIQUE INDEX "LMS"."SYS_C007134" ON "LMS"."STUDENT" ("SID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index SYS_C007147
--------------------------------------------------------

  CREATE UNIQUE INDEX "LMS"."SYS_C007147" ON "LMS"."ADMIN" ("AID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table TEST
--------------------------------------------------------

  ALTER TABLE "LMS"."TEST" ADD CONSTRAINT "TEST_PK" PRIMARY KEY ("TY", "TS", "TN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LMS"."TEST" ADD CHECK (ts in (1,2)) ENABLE;
  ALTER TABLE "LMS"."TEST" MODIFY ("TA" NOT NULL ENABLE);
  ALTER TABLE "LMS"."TEST" MODIFY ("TQ" NOT NULL ENABLE);
  ALTER TABLE "LMS"."TEST" MODIFY ("TN" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ANSWER
--------------------------------------------------------

  ALTER TABLE "LMS"."ANSWER" ADD CONSTRAINT "ANSWER_PK" PRIMARY KEY ("SNO", "TY", "TS", "TN")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LMS"."ANSWER" ADD CHECK (ans in ('O', 'X')) ENABLE;
--------------------------------------------------------
--  Constraints for Table STUDENT
--------------------------------------------------------

  ALTER TABLE "LMS"."STUDENT" ADD UNIQUE ("SID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LMS"."STUDENT" ADD PRIMARY KEY ("SNO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LMS"."STUDENT" ADD CHECK (slms in('Y', 'N')) ENABLE;
  ALTER TABLE "LMS"."STUDENT" MODIFY ("SNM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table ADMIN
--------------------------------------------------------

  ALTER TABLE "LMS"."ADMIN" ADD PRIMARY KEY ("AID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "LMS"."ADMIN" ADD CHECK (aps in ('Y', 'N')) ENABLE;
  ALTER TABLE "LMS"."ADMIN" ADD CHECK (arole in ('SUPER', 'SUB')) ENABLE;
  ALTER TABLE "LMS"."ADMIN" MODIFY ("ANM" NOT NULL ENABLE);
  ALTER TABLE "LMS"."ADMIN" MODIFY ("APWD" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ANSWER
--------------------------------------------------------

  ALTER TABLE "LMS"."ANSWER" ADD CONSTRAINT "ANSWER_SNO_FK" FOREIGN KEY ("SNO")
	  REFERENCES "LMS"."STUDENT" ("SNO") ENABLE;
  ALTER TABLE "LMS"."ANSWER" ADD CONSTRAINT "ANSWER_TEST_FK" FOREIGN KEY ("TY", "TS", "TN")
	  REFERENCES "LMS"."TEST" ("TY", "TS", "TN") ENABLE;
