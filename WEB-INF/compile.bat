@echo off
set path1="C:\apache-tomcat-7.0.72\lib\servlet-api.jar;classes"
echo Start ...................... Ok

if exist classes goto start
if not exist classes goto create
:create
MD classes
:start

echo 1) Recompile model
javac -d classes src\com\example\model\JokeExpert.java

echo 2) Recompile test for model
javac -classpath classes -d classes src\com\example\test\testModel.java

echo 4) Recompile developer information class
javac -d classes src\com\example\aboutDeveloper\DeveloperInformation.java

echo 5) Recompile servlet context listener
javac -classpath C:\apache-tomcat-7.0.72\lib\servlet-api.jar;classes -d classes src\com\example\FirstServletContextListener.java

echo 6) Recompile JokeSelect
javac -classpath C:\apache-tomcat-7.0.72\lib\servlet-api.jar;classes -d classes src\com\example\web\JokeSelect.java

echo 7) Recompile servlet_1
javac -classpath C:\apache-tomcat-7.0.72\lib\servlet-api.jar;classes -d classes src\com\example\web\servlet_1.java

echo Complete .................... Ok
pause