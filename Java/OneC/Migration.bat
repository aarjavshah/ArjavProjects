@echo off
IF "%1"=="" IF "%2"=="" (
echo Invalid Command Issued 
echo Valid Syntax Migration.bat ^<source path^> ^<destination path^> 
echo Please Issue Valid Command
goto label
)

IF "%1" NEQ "" IF "%2" NEQ "" (
python.exe Migrate.py -i %1 -o %2
)
:label
pause