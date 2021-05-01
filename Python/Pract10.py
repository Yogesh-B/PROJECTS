import random
MAX_VALUE = 1000

sizeOfList = int(input('\nEnter List Length : '))

oldList = []
for item in range(0,sizeOfList):
    oldList.append(random.randint(0,MAX_VALUE))

newList = [item for item in oldList if item % 2 == 0]

oldList.sort()
newList.sort()

print('\nOriginal List(Sorted Order) : ',*oldList)
print('\nNew List(Sorted Order)',*newList)
