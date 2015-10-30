wget -nd -r -P /home/kupluk/IMG/ -A jpeg,jpg http://www.itb.ac.id/
# You may have to change "kupluk" to your username
# You may change /IMG/ to any directory

rsync -r /home/kupluk/IMG/ /home/kupluk/Backup/
# /home/kupluk/IMG/ --> Main directory to be backed-up
# /home/kupluk/Backup/ --> Backup directory
