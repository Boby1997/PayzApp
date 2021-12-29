# android-appimum-framework

## Run tests on Android
 mvn clean verify -DtestEnvironment=android
 
 ## Run tests on IOS
 mvn clean verify -DtestEnvironment=ios

 ## Run Single Test case using command
mvn clean verify -DtestEnvironment=android "-Dcucumber.options=--tags @loop"


