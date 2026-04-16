@echo off
REM Download Maven if not present
if not exist "C:\tools\maven" (
    echo Downloading Maven...
    mkdir C:\tools
    powershell -Command "Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip' -OutFile 'C:\tools\maven.zip' ; Expand-Archive -Path 'C:\tools\maven.zip' -DestinationPath 'C:\tools\' ; Rename-Item 'C:\tools\apache-maven-3.9.6' -NewName 'maven'"
    setx MAVEN_HOME C:\tools\maven
    setx PATH "%PATH%;C:\tools\maven\bin"
)

echo Maven is ready!
mvn --version
pause
