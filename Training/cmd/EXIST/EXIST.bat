set FILE=TEST.csv
if exist %FILE% (echo OK) else (echo NG)
exit /b -1
