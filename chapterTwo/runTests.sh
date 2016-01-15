#!/bin/bash
javac *.java
java -cp . org.junit.runner.JUnitCore ChapterTwoTest
rm *.class

