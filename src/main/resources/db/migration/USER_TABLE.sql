CREATE TABLE USER (
    USER_ID VARCHAR(20) NOT NULL PRIMARY KEY
    , USER_NAME VARCHAR(50)
    , MAIL_ADDRESS VARCHAR(225) NOT NULL
    , REGISTRATION_STATUS VARCHAR(20) NOT NULL
    , AUTHORIZATION_TYPE VARCHAR(50) NOT NULL
    , ERROR_COUNT DECIMAL(2, 0)
    , LOCKED_FLG VARCHAR(1) NOT NULL
    , DELETE_FLG VARCHAR(1) NOT NULL
    , INPUT_USER_ID VARCHAR(20) NOT NULL
    , INPUT_DATETIME DATETIME NOT NULL
    , UPDATE_USER_ID VARCHAR(20) NOT NULL
    , UPDATE_DATETIME DATETIME NOT NULL
    , VERSION DECIMAL(18, 0) NOT NULL
);