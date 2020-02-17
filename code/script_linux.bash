#!/bin/sh

echo "Insert test set: "
read test_set

echo "Compiling 'setlog_generator.cpp' ..."
g++ -Wall -Wextra setlog_generator.cpp -o setlog_generator

echo "Executing 'setlog_generator' ..."
./setlog_generator $test_set

echo "Launching swipl ..."
swipl -s setlog/setlog496-5c.pl ${test_set}/${test_set}_prolog_cases.pl 

echo "Compiling 'jsetl_generator.cpp' ..."
g++ -Wall -Wextra jsetl_generator.cpp -o jsetl_generator

echo "Executing 'jsetl_generator' ..."
./jsetl_generator $test_set

echo "Test generation completed."

rm setlog_generator jsetl_generator
