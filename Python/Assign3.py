import sys
if len(sys.argv)==1:
	print("Missing required input")
	quit()

K = int(sys.argv[1])

listofnumbers1 = list()
for i in range(2,len(sys.argv)):
	listofnumbers1.append(int(sys.argv[i]))

listofnumbers1.sort()
middle = int(len(listofnumbers1)/2)
median=0

if (len(listofnumbers1)%2)!=0:
#If total numbers are odd
	median = listofnumbers1[middle]
else:
#If total numbers are even
	median = ((listofnumbers1[middle]+listofnumbers1[middle-1])/2)

distancefromMedian = dict()
for num in listofnumbers1:
	if num>median:
#Finding distance
		distancefromMedian[num] = num-median
	else:
#Finding distance
		distancefromMedian[num] = median-num

sortedValues = sorted(distancefromMedian.values())
distancefromMedian1 = dict()
for i in range(0,len(sortedValues)):
	for key in distancefromMedian:
#Matching sorted values with the keys and sorting the keys according to the distance from median 
		if distancefromMedian[key]==sortedValues[i]:
			distancefromMedian1[key] = sortedValues[i]

listofnumbers = list()
listofnumbers1.clear()
for key in distancefromMedian1:
#Storing sorted keys in the list
	listofnumbers.append(key)

for i in range(0,K):
#Fetching first K numbers or fetching K numbers that are nearest to the median
	listofnumbers1.append(listofnumbers[i])		

listofnumbers1.sort()
print(listofnumbers1)


	  
