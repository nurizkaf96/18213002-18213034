wget -nd -r -P /home/nurizkaf96/Documents/ii3160/ -A jpeg,jpg,png http://www.km.itb.ac.id/
# nurizkaf96 change to your username
# /Documents/ii3160 just change it anywhere

rsync -r "/home/nurizkaf96/Documents/ii3160/" "home/nurizkaf96/Documents/Progif/"
# /home/nurizkaf96/Documents/ii3160/ --> Main directory
# home/nurizkaf96/Documents/Progif/ --> Backup directory
