import re
import datetime

fileName = 'student.txt'

with open(fileName,'r') as reader:
    text = reader.read().splitlines()

finalSet = []
for line in text:
    name = line.split(' ')
    if(len(name) == 2):
        try:
            student = datetime.datetime.strptime(name[1],'%m-%d-%Y')
            finalSet.append(line)
        except ValueError:
            pass

print('\nStudent\'s name with DOB(mm-dd-yyyy)')
for item in finalSet:
    temp = item.split(' ')
    print(temp[0],' ',temp[1])
