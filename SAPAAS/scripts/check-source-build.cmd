@echo off
setlocal

set "ROOT_DIR=%~dp0..\.."
call ant -f "%ROOT_DIR%\SAPAAS\resources\classes\build.xml" verify-source
exit /b %ERRORLEVEL%
