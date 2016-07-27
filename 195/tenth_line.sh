# Read from the file file.txt and output the tenth line to stdout.

i=1

while read line
do
    if [ "$i" == 10 ];then
        echo "$line"
    fi
    i=$((i+1))
done < file.txt
