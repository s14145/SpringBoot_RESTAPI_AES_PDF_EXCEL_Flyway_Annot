create table if not exists CARD_DETAIL (
 CARD_ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 CARD_NUMBER VARCHAR(16) NOT NULL,
 CVV INT NOT NULL,
 AMOUNT INT NOT NULL,
 IS_ACTIVE BOOLEAN NOT NULL
);