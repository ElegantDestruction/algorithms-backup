#!/bin/zsh

javac *.java -d ../bin
cd ../bin
java SearchNSortDriver
cd ../src
