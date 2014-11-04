::==============
::  1st aleternative 

::@echo off 

::cd  /d E:\exadel_projects\TouchtunesAutomation\TouchtunesAndroidSideTestsGitHubRepo\TanjarineTabletTests   >testResults.txt
::call android.bat create uitest-project -n TanjarineTabletTests -t 17 -p .    
::call ant build 
::adb  push ./bin/TanjarineTabletTests.jar /data/local/tmp  
::adb shell uiautomator runtest TanjarineTabletTests.jar -c com.exadel.tanjarine.android.tests.NavigationTests  >>testResults.txt
::==============


:: outPut commands attempts: 
::dir | batchTee testResults.txt
::dir >  testResults.txt
::dir > testResults.txt | type testResults.txt
::dir > testResults.txt && type testResults.txt


::2nd alternative using batchTee approach from here:   http://stackoverflow.com/questions/11239924/windows-batch-tee-command
cd  /d E:\exadel_projects\TouchtunesAutomation\TouchtunesAndroidSideTestsGitHubRepo\TanjarineTabletTests   | batchTee testResults.txt
call android.bat create uitest-project -n TanjarineTabletTests -t 17 -p .   
call ant build  
adb  push ./bin/TanjarineTabletTests.jar /data/local/tmp    | batchTee testResults.txt + 
echo ======1st suite: Navigation tests ===============   | batchTee testResults.txt + 
adb shell uiautomator runtest TanjarineTabletTests.jar -c com.exadel.tanjarine.android.tests.NavigationTests  | batchTee testResults.txt +
echo ======2nd suite: Carousel,drink section tests ===============   | batchTee testResults.txt +
adb shell uiautomator runtest TanjarineTabletTests.jar -c com.exadel.tanjarine.android.tests.DrinksCarouselTests  | batchTee testResults.txt +
echo ======test suites execution finished! ===============   | batchTee testResults.txt +

pause