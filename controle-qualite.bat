SET MAVEN_HOME=C:\apache-maven-3.8.2
SET JAVA_HOME=C:\Java\jdk-17_windows-x64_bin\jdk-17
SET SONAR_SCANNER_HOME=C:\sonar-scanner-4.6.2.2472-windows
SET PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%SONAR_SCANNER_HOME%\bin;%PATH%

call sonar-scanner.bat;
mvn clean test checkstyle:checkstyle install

