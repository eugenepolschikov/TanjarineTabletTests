cd  /d E:\exadel_projects\TouchtunesAutomation\TouchtunesAndroidSideTestsGitHubRepo\TanjarineTabletTests
call android.bat create uitest-project -n TanjarineTabletTests -t 17 -p .
call ant build

adb  push ./bin/TanjarineTabletTests.jar /data/local/tmp
adb shell uiautomator runtest TanjarineTabletTests.jar -c com.exadel.tanjarine.android.tests.NavigationTests
pause