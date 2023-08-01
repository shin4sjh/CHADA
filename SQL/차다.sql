DROP TABLE "TB_CART";
DROP TABLE "TB_WISH";
DROP TABLE "TB_POINT";
DROP TABLE "TB_ORDER";
DROP TABLE "TB_COUPON";
DROP TABLE "TB_NOTICE";
DROP TABLE "ORDER_LIST";
DROP TABLE "TB_SELL";
DROP TABLE "TB_PRICE";
DROP TABLE "TB_BEAN";
DROP TABLE "TB_MERCHANDISE";
DROP TABLE "TB_BAKERY";
DROP TABLE "TB_DRINK";
DROP TABLE "TB_INFO";
DROP TABLE "TB_BEAN_FLAOVR";
DROP TABLE "TB_FLAVOR";
DROP TABLE "ARTICLE_LIKE";
DROP TABLE "ARTICLE_COUNT";
DROP TABLE "TB_ARTICLE";
DROP TABLE "BOARD_LIKE";
DROP TABLE "BOARD_COUNT";
DROP TABLE "REPLY";
DROP TABLE "TB_BOARD";
DROP TABLE "TB_KEYWORD";
DROP TABLE "TB_TAG";
DROP TABLE "TB_MEMBER";

CREATE TABLE "TB_MEMBER" (
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL,
	"MEMBER_ID"	VARCHAR2(100)		NOT NULL,
	"MEMBER_PASSWORD"	VARCHAR2(100)		NOT NULL,
	"MEMBER_RANK"	VARCHAR2(30)		NULL,
	"MEMBER_PHONE_NUMBER"	VARCHAR2(20)		NULL,
	"MEMBER_PHONE_NUMBER2"	VARCHAR2(20)		NULL,
	"MEMBER_EMAIL"	VARCHAR2(100)		NULL,
	"MEMBER_EMAIL2"	VARCHAR2(100)		NULL,
	"MEMBER_SIGN_DATE"	DATE		NULL,
	"MEMBER_NAME"	VARCHAR2(50)		NULL,
	"MEMBER_GENDER"	NUMBER		NULL,
	"MEMBER_BIRTH"	DATE		NULL,
	"MEMBER_ADDRESS"	VARCHAR2(300)		NULL,
	"MEMBER_ADDRESS2"	VARCHAR2(300)		NULL
);

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_ID" IS '로그인아이디';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_PASSWORD" IS '로그인비밀번호';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_RANK" IS '등급';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_PHONE_NUMBER" IS '전화번호';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_PHONE_NUMBER2" IS '전화번호2';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_EMAIL" IS '이메일';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_EMAIL2" IS '이메일2';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_SIGN_DATE" IS '가입일자';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_NAME" IS '닉네임';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_GENDER" IS '성별 (1,2,3)';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_BIRTH" IS '생년월일';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_ADDRESS" IS '주소';

COMMENT ON COLUMN "TB_MEMBER"."MEMBER_ADDRESS2" IS '주소2';

ALTER TABLE "TB_MEMBER" ADD CONSTRAINT "PK_TB_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

CREATE TABLE "TB_TAG" (
	"TAG_NO"	NUMBER		NOT NULL,
	"TAG_NAME"	VARCHAR2(50)		NOT NULL,
	"TAG_NAME2"	VARCHAR2(50)		NULL,
	"TAG_NAME3"	VARCHAR2(50)		NULL
);

ALTER TABLE "TB_TAG" ADD CONSTRAINT "PK_TB_TAG" PRIMARY KEY (
	"TAG_NO"
);

CREATE TABLE "TB_KEYWORD" (
	"KEYWORD_CODE"	VARCHAR2(10)		NOT NULL,
	"KEYWORD_NAME"	VARCHAR2(30)		NOT NULL
);

ALTER TABLE "TB_KEYWORD" ADD CONSTRAINT "PK_TB_KEYWORD" PRIMARY KEY (
	"KEYWORD_CODE"
);

CREATE TABLE "TB_BOARD" (
	"BOARD_CODE"	VARCHAR2(10)		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(300)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NULL,
	"BOARD_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_REF"	NUMBER		NOT NULL,
	"BOARD_LEVEL"	NUMBER		NOT NULL,
	"BOARD_STEP"	NUMBER		NOT NULL,
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL,
	"BOARD_CATEGORY"	VARCHAR2(30)	DEFAULT 0     NOT NULL,
	"KEYWORD_CODE"	VARCHAR2(10)		NULL,
	"TAG_NO"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_BOARD"."BOARD_CODE" IS 'SEQ_BOARD_CODE사용';

COMMENT ON COLUMN "TB_BOARD"."BOARD_TITLE" IS '게시판 제목';

COMMENT ON COLUMN "TB_BOARD"."BOARD_CONTENT" IS '게시판 내용';

COMMENT ON COLUMN "TB_BOARD"."BOARD_DATE" IS '작성시간';

COMMENT ON COLUMN "TB_BOARD"."BOARD_REF" IS 'BOARD_CODE-BOARD_REF:원본글 , CODE<>REF답글';

COMMENT ON COLUMN "TB_BOARD"."BOARD_LEVEL" IS '0:원본글 , 1답글,2 답답글';

COMMENT ON COLUMN "TB_BOARD"."BOARD_STEP" IS '0:원본글, 1-N원본글 기준 답글들의 순서';

COMMENT ON COLUMN "TB_BOARD"."MEMBER_NO" IS '회원번호';

ALTER TABLE "TB_BOARD" ADD CONSTRAINT "PK_TB_BOARD" PRIMARY KEY (
	"BOARD_CODE"
);

CREATE TABLE "REPLY" (
	"REPLY_NO"	NUMBER		NOT NULL,
	"BOARD_CODE"	VARCHAR2(10)		NOT NULL,
	"REPLY_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"REPLY_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL,
	"REPLY_LEVEL"	NUMBER	DEFAULT 1	NOT NULL,
	"REPLY_STEP"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "REPLY"."REPLY_NO" IS 'SEQ';

COMMENT ON COLUMN "REPLY"."BOARD_CODE" IS 'SEQ_BOARD_CODE사용';

COMMENT ON COLUMN "REPLY"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "REPLY"."REPLY_LEVEL" IS '1댓글,2대댓글';

COMMENT ON COLUMN "REPLY"."REPLY_STEP" IS '1-N원본글 기준 댓글들의 순서';

ALTER TABLE "REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY (
	"REPLY_NO",
	"BOARD_CODE"
);

CREATE TABLE "BOARD_COUNT" (
	"READ_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_CODE"	VARCHAR2(10)		NOT NULL,
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "BOARD_COUNT"."READ_DATE" IS '조회시간';

COMMENT ON COLUMN "BOARD_COUNT"."BOARD_CODE" IS 'SEQ_BOARD_CODE사용';

COMMENT ON COLUMN "BOARD_COUNT"."MEMBER_NO" IS '회원번호';


CREATE TABLE "BOARD_LIKE" (
	"ALIKE_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"BOARD_CODE"	VARCHAR2(10)		NOT NULL,
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "BOARD_LIKE"."BOARD_CODE" IS 'SEQ_BOARD_CODE사용';

COMMENT ON COLUMN "BOARD_LIKE"."MEMBER_NO" IS '회원번호';


CREATE TABLE "TB_ARTICLE" (
	"ARTICLE_CODE"	NUMBER		NOT NULL,
	"MEMBER_NO"	VARCHAR(10)		NOT NULL,
	"ARTICLE_TITLE"	VARCHAR(50)		NULL,
	"KEYWORD_CODE"	VARCHAR2(10)		NOT NULL,
	"ARTICLE_TIME"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ARTICLE_CONTENT"	VARCHAR2(4000)		NULL
);

COMMENT ON COLUMN "TB_ARTICLE"."MEMBER_NO" IS '회원번호';

ALTER TABLE "TB_ARTICLE" ADD CONSTRAINT "PK_TB_ARTICLE" PRIMARY KEY (
	"ARTICLE_CODE"
);


CREATE TABLE "ARTICLE_COUNT" (
	"READ_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ARTICLE_CODE"	NUMBER		NOT NULL,
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "ARTICLE_COUNT"."READ_DATE" IS '조회시간';

COMMENT ON COLUMN "ARTICLE_COUNT"."MEMBER_NO" IS '회원번호';

CREATE TABLE "ARTICLE_LIKE" (
	"ALIKE_DATE"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"ARTICLE_CODE"	NUMBER		NOT NULL,
	"MEMBER_NO"	VARCHAR(10)		NOT NULL
);

COMMENT ON COLUMN "ARTICLE_LIKE"."MEMBER_NO" IS '회원번호';


CREATE TABLE "TB_FLAVOR" (
	"FLAVOR_NO"	NUMBER		NOT NULL,
	"FLAVOR_NAME"	VARCHAR2(30)		NULL
);

ALTER TABLE "TB_FLAVOR" ADD CONSTRAINT "PK_TB_FLAVOR" PRIMARY KEY (
	"FLAVOR_NO"
);

CREATE TABLE "TB_BEAN_FLAOVR" (
	"FLAVOR_NO"	NUMBER		NOT NULL,
	"BEAN_CODE"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "TB_BEAN_FLAOVR"."BEAN_CODE" IS '원두아이디';


CREATE TABLE "TB_INFO" (
	"INFO_CODE"	VARCHAR2(10)		NOT NULL,
	"COUNTRY"	VARCHAR2(20)		NULL,
	"FARM"	VARCHAR2(50)		NULL,
	"VARIETY"	VARCHAR2(20)		NULL,
	"REGION"	VARCHAR2(50)		NULL,
	"PROCESS"	VARCHAR2(50)		NULL,
	"ALTITUDE"	NUMBER		NULL,
	"PRODUCER"	VARCHAR2(100)		NULL
);

COMMENT ON COLUMN "TB_INFO"."INFO_CODE" IS '생산정보';

COMMENT ON COLUMN "TB_INFO"."COUNTRY" IS '나라정보';

COMMENT ON COLUMN "TB_INFO"."FARM" IS '농장정보';

COMMENT ON COLUMN "TB_INFO"."VARIETY" IS '품종정보';

COMMENT ON COLUMN "TB_INFO"."REGION" IS '지역정보';

COMMENT ON COLUMN "TB_INFO"."PROCESS" IS '가공정보';

COMMENT ON COLUMN "TB_INFO"."ALTITUDE" IS '고도M';

COMMENT ON COLUMN "TB_INFO"."PRODUCER" IS '농부나프로듀서 정보';

ALTER TABLE "TB_INFO" ADD CONSTRAINT "PK_TB_INFO" PRIMARY KEY (
	"INFO_CODE"
);

CREATE TABLE "TB_DRINK" (
	"VARIATION_NO"	VARCHAR2(10)		NOT NULL,
	"VARIATION_NAME"	VARCHAR2(30)		NULL
);

COMMENT ON COLUMN "TB_DRINK"."VARIATION_NO" IS '베리에이션';

ALTER TABLE "TB_DRINK" ADD CONSTRAINT "PK_TB_DRINK" PRIMARY KEY (
	"VARIATION_NO"
);


CREATE TABLE "TB_BAKERY" (
	"BAKERY_NO"	VARCHAR(10)		NOT NULL,
	"BAKERY_NAME"	VARCHAR2(30)		NULL
);

COMMENT ON COLUMN "TB_BAKERY"."BAKERY_NO" IS '다과';

ALTER TABLE "TB_BAKERY" ADD CONSTRAINT "PK_TB_BAKERY" PRIMARY KEY (
	"BAKERY_NO"
);

CREATE TABLE "TB_MERCHANDISE" (
	"MD_NO"	VARCHAR(10)		NOT NULL,
	"MD_NAME"	VARCHAR2(30)		NULL
);

COMMENT ON COLUMN "TB_MERCHANDISE"."MD_NO" IS '기타상품';

ALTER TABLE "TB_MERCHANDISE" ADD CONSTRAINT "PK_TB_MERCHANDISE" PRIMARY KEY (
	"MD_NO"
);

CREATE TABLE "TB_BEAN" (
	"BEAN_CODE"	VARCHAR2(10)		NOT NULL,
	"INFO"	VARCHAR2(10)		NULL,
	"BEAN_CROP"	VARCHAR2(20)		NULL,
	"BEAN_NAME"	VARCHAR2(500)		NULL,
	"BEAN_ROAST"	NUMBER		NULL
);

COMMENT ON COLUMN "TB_BEAN"."BEAN_CODE" IS '원두아이디';

COMMENT ON COLUMN "TB_BEAN"."INFO" IS '생산정보';

COMMENT ON COLUMN "TB_BEAN"."BEAN_CROP" IS '수확년도';

COMMENT ON COLUMN "TB_BEAN"."BEAN_NAME" IS '원두명';

COMMENT ON COLUMN "TB_BEAN"."BEAN_ROAST" IS '1~5,약~강 6-기타';

ALTER TABLE "TB_BEAN" ADD CONSTRAINT "PK_TB_BEAN" PRIMARY KEY (
	"BEAN_CODE"
);


CREATE TABLE "TB_PRICE" (
	"PRICE_CODE"	VARCHAR(10)		NOT NULL,
	"PRICE_CUP"	VARCHAR(255)		NULL,
	"PRICE_POT"	VARCHAR(255)		NULL,
	"PRICE_UNIT"	VARCHAR(255)		NULL,
	"BEAN_CODE"	VARCHAR2(10)		NULL,
	"MD_NO"	VARCHAR2(10)		NULL,
	"BAKERY_NO"	VARCHAR2(10)		NULL,
	"VARIATION_NO"	VARCHAR2(10)		NULL
);

COMMENT ON COLUMN "TB_PRICE"."PRICE_CODE" IS '판매번호';

COMMENT ON COLUMN "TB_PRICE"."PRICE_CUP" IS '한잔';

COMMENT ON COLUMN "TB_PRICE"."PRICE_POT" IS '찻주전자';

COMMENT ON COLUMN "TB_PRICE"."PRICE_UNIT" IS '단위당가격';

COMMENT ON COLUMN "TB_PRICE"."BEAN_CODE" IS '원두아이디';

COMMENT ON COLUMN "TB_PRICE"."MD_NO" IS '기타상품';

COMMENT ON COLUMN "TB_PRICE"."BAKERY_NO" IS '다과';

COMMENT ON COLUMN "TB_PRICE"."VARIATION_NO" IS '베리에이션';

ALTER TABLE "TB_PRICE" ADD CONSTRAINT "PK_TB_PRICE" PRIMARY KEY (
	"PRICE_CODE"
);


CREATE TABLE "TB_SELL" (
	"SELL_NO"	NUMBER		NOT NULL,
	"SELL_NAME"	VARCHAR(50)		NULL,
	"SELL_STOCK"	NUMBER	DEFAULT 0	NOT NULL,
	"PRICE_CODE"	VARCHAR(10)		NOT NULL
);

COMMENT ON COLUMN "TB_SELL"."SELL_NO" IS '판매상품';

COMMENT ON COLUMN "TB_SELL"."PRICE_CODE" IS '판매번호';

ALTER TABLE "TB_SELL" ADD CONSTRAINT "PK_TB_SELL" PRIMARY KEY (
	"SELL_NO"
);


CREATE TABLE "ORDER_LIST" (
	"SELL_NO"	NUMBER		NOT NULL,
	"ORDER_NO"	NUMBER		NOT NULL,
	"CART_AMOUNT"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "ORDER_LIST"."SELL_NO" IS '판매상품';

ALTER TABLE "ORDER_LIST" ADD CONSTRAINT "PK_ORDER_LIST" PRIMARY KEY (
	"SELL_NO",
	"ORDER_NO"
);


CREATE TABLE "TB_NOTICE" (
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL,
	"NOTICE_CONTENT"	VARCHAR2(50)		NULL
);

COMMENT ON COLUMN "TB_NOTICE"."MEMBER_NO" IS '회원번호';


CREATE TABLE "TB_COUPON" (
	"COUPON_CODE"	NUMBER		NOT NULL,
	"COUPON_NAME"	VARCHAR(30)		NULL,
	"COUPON_DR"	NUMBER		NULL,
	"COUPON_DA"	NUMBER		NULL,
	"COUPON_CON"	NUMBER	DEFAULT 0	NOT NULL,
	"COUPON_LIMIT"	DATE		NULL,
	"USER_NO"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "TB_COUPON"."COUPON_DR" IS 'DISCOUNTRATE';

COMMENT ON COLUMN "TB_COUPON"."COUPON_DA" IS 'AMOUNT';

COMMENT ON COLUMN "TB_COUPON"."COUPON_CON" IS 'CONDITION (0,1)';

COMMENT ON COLUMN "TB_COUPON"."USER_NO" IS '회원번호';

ALTER TABLE "TB_COUPON" ADD CONSTRAINT "PK_TB_COUPON" PRIMARY KEY (
	"COUPON_CODE"
);

CREATE TABLE "TB_ORDER" (
	"ORDER_NO"	NUMBER		NOT NULL,
	"ORDER_NAME"	VARCHAR2(50)		NOT NULL,
	"ORDER_ADDRESS"	VARCHAR2(300)		NOT NULL,
	"ORDER_PHONE_NUMBER"	VARCHAR2(20)		NOT NULL,
	"ORDER_REQUEST"	VARCHAR2(500)		NULL,
	"ORDER_PRICE"	NUMBER		NOT NULL,
	"ORDER_TIME"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL,
	"USER_NO"	VARCHAR2(10)		NOT NULL
);

COMMENT ON COLUMN "TB_ORDER"."USER_NO" IS '회원번호';

ALTER TABLE "TB_ORDER" ADD CONSTRAINT "PK_TB_ORDER" PRIMARY KEY (
	"ORDER_NO"
);

CREATE TABLE "TB_POINT" (
	"USER_NO"	VARCHAR2(10)		NOT NULL,
	"USER_POINT"	NUMBER	DEFAULT 0	NOT NULL
);

COMMENT ON COLUMN "TB_POINT"."USER_NO" IS '회원번호';

ALTER TABLE "TB_POINT" ADD CONSTRAINT "PK_TB_POINT" PRIMARY KEY (
	"USER_NO"
);


CREATE TABLE "TB_WISH" (
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL,
	"SELL_NO"	NUMBER		NOT NULL,
	"WISH"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL
);

COMMENT ON COLUMN "TB_WISH"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "TB_WISH"."SELL_NO" IS '판매상품';

ALTER TABLE "TB_WISH" ADD CONSTRAINT "PK_TB_WISH" PRIMARY KEY (
	"MEMBER_NO",
	"SELL_NO"
);


CREATE TABLE "TB_CART" (
	"SELL_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	VARCHAR2(10)		NOT NULL,
	"CART_AMOUNT"	NUMBER	DEFAULT 1	NOT NULL,
	"CART_TIME"	TIMESTAMP	DEFAULT SYSTIMESTAMP	NOT NULL
);

COMMENT ON COLUMN "TB_CART"."SELL_NO" IS '판매상품';

COMMENT ON COLUMN "TB_CART"."MEMBER_NO" IS '회원번호';

--fk

ALTER TABLE "TB_CART" ADD CONSTRAINT "PK_TB_CART" PRIMARY KEY (
	"SELL_NO",
	"MEMBER_NO"
);

ALTER TABLE "TB_BOARD" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_BOARD_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "TB_BOARD" ADD CONSTRAINT "FK_TB_KEYWORD_TO_TB_BOARD_1" FOREIGN KEY (
	"KEYWORD_CODE"
)
REFERENCES "TB_KEYWORD" (
	"KEYWORD_CODE"
);

ALTER TABLE "TB_BOARD" ADD CONSTRAINT "FK_TB_TAG_TO_TB_BOARD_1" FOREIGN KEY (
	"TAG_NO"
)
REFERENCES "TB_TAG" (
	"TAG_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_TB_BOARD_TO_REPLY_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "TB_BOARD" (
	"BOARD_CODE"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_TB_MEMBER_TO_REPLY_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "BOARD_COUNT" ADD CONSTRAINT "FK_TB_BOARD_TO_BOARD_COUNT_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "TB_BOARD" (
	"BOARD_CODE"
);

ALTER TABLE "BOARD_COUNT" ADD CONSTRAINT "FK_TB_MEMBER_TO_BOARD_COUNT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_TB_BOARD_TO_BOARD_LIKE_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "TB_BOARD" (
	"BOARD_CODE"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_TB_MEMBER_TO_BOARD_LIKE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "TB_ARTICLE" ADD CONSTRAINT "FK_TB_KEYWORD_TO_TB_ARTICLE_1" FOREIGN KEY (
	"KEYWORD_CODE"
)
REFERENCES "TB_KEYWORD" (
	"KEYWORD_CODE"
);
ALTER TABLE "ARTICLE_COUNT" ADD CONSTRAINT "FK_TB_ARTICLE_TO_ARTICLE_COUNT_1" FOREIGN KEY (
	"ARTICLE_CODE"
)
REFERENCES "TB_ARTICLE" (
	"ARTICLE_CODE"
);

ALTER TABLE "ARTICLE_COUNT" ADD CONSTRAINT "FK_TB_MEMBER_TO_ARTICLE_COUNT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "ARTICLE_LIKE" ADD CONSTRAINT "FK_TB_ARTICLE_TO_ARTICLE_LIKE_1" FOREIGN KEY (
	"ARTICLE_CODE"
)
REFERENCES "TB_ARTICLE" (
	"ARTICLE_CODE"
);

ALTER TABLE "ARTICLE_LIKE" ADD CONSTRAINT "FK_TB_MEMBER_TO_ARTICLE_LIKE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "TB_BEAN_FLAOVR" ADD CONSTRAINT "FK_TB_FLAVOR_TO_TB_BEAN_FLAOVR_1" FOREIGN KEY (
	"FLAVOR_NO"
)
REFERENCES "TB_FLAVOR" (
	"FLAVOR_NO"
);

ALTER TABLE "TB_BEAN_FLAOVR" ADD CONSTRAINT "FK_TB_BEAN_TO_TB_BEAN_FLAOVR_1" FOREIGN KEY (
	"BEAN_CODE"
)
REFERENCES "TB_BEAN" (
	"BEAN_CODE"
);
ALTER TABLE "TB_BEAN" ADD CONSTRAINT "FK_TB_INFO_TO_TB_BEAN_1" FOREIGN KEY (
	"INFO"
)
REFERENCES "TB_INFO" (
	"INFO_CODE"
);
ALTER TABLE "TB_PRICE" ADD CONSTRAINT "FK_TB_BEAN_TO_TB_PRICE_1" FOREIGN KEY (
	"BEAN_CODE"
)
REFERENCES "TB_BEAN" (
	"BEAN_CODE"
);

ALTER TABLE "TB_PRICE" ADD CONSTRAINT "FK_TB_BAKERY_TO_TB_PRICE_1" FOREIGN KEY (
	"BAKERY_NO"
)
REFERENCES "TB_BAKERY" (
	"BAKERY_NO"
);

ALTER TABLE "TB_PRICE" ADD CONSTRAINT "FK_TB_DRINK_TO_TB_PRICE_1" FOREIGN KEY (
	"VARIATION_NO"
)
REFERENCES "TB_DRINK" (
	"VARIATION_NO"
);
ALTER TABLE "TB_SELL" ADD CONSTRAINT "FK_TB_PRICE_TO_TB_SELL_1" FOREIGN KEY (
	"PRICE_CODE"
)
REFERENCES "TB_PRICE" (
	"PRICE_CODE"
);
ALTER TABLE "ORDER_LIST" ADD CONSTRAINT "FK_TB_SELL_TO_ORDER_LIST_1" FOREIGN KEY (
	"SELL_NO"
)
REFERENCES "TB_SELL" (
	"SELL_NO"
);

ALTER TABLE "ORDER_LIST" ADD CONSTRAINT "FK_TB_ORDER_TO_ORDER_LIST_1" FOREIGN KEY (
	"ORDER_NO"
)
REFERENCES "TB_ORDER" (
	"ORDER_NO"
);
ALTER TABLE "TB_NOTICE" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_NOTICE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "TB_COUPON" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_COUPON_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "TB_ORDER" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_ORDER_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "TB_POINT" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_POINT_1" FOREIGN KEY (
	"USER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "TB_WISH" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_WISH_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);
ALTER TABLE "TB_CART" ADD CONSTRAINT "FK_TB_MEMBER_TO_TB_CART_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "TB_MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "TB_CART" ADD CONSTRAINT "FK_TB_SELL_TO_TB_CART_1" FOREIGN KEY (
	"SELL_NO"
)
REFERENCES "TB_SELL" (
	"SELL_NO"
);













