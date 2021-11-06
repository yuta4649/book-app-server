@echo off
echo initData
cd %~dp0
call setting.bat

%SQLPLUS% -e "CREATE SCHEMA IF NOT EXISTS `appdb` DEFAULT CHARACTER SET utf8;"

set DB_SQLPLUS=%SQLPLUS% -D appdb
echo drop tables
%DB_SQLPLUS% < %SQL_DIR%DROP_TABLES.sql

echo create tables
%DB_SQLPLUS% < %SQL_DIR%USER_TABLE.sql

pause
exit
