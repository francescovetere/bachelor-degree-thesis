@ECHO OFF

SET /P test_set=Insert test set: 

ECHO Compiling 'setlog_generator.cpp' ...
g++ -Wall -Wextra setlog_generator.cpp -o setlog_generator.exe 

ECHO Executing 'setlog_generator.exe' ...
setlog_generator.exe %test_set%

ECHO Launching swipl...
swipl -s setlog/setlog496-5c.pl %test_set%/%test_set%_prolog_cases.pl

ECHO Compiling 'jsetl_generator.cpp' ...
g++ -Wall -Wextra jsetl_generator.cpp -o jsetl_generator.exe

ECHO Executing 'jsetl_generator.exe' ...
jsetl_generator.exe %test_set%

ECHO Test generation completed.

DEL setlog_generator.exe jsetl_generator.exe

PAUSE
