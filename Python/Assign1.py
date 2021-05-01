import math
import sys

def divSum(n) :

	result = 0

	for index in range(2, int(math.sqrt(n)) + 1) :
		if (n % index == 0) :
			if (index == int(n / index)) :
				result = result + index
			else :
				result = result +(index + int(n / index))
	return (result + 1)

def areAmicable(x, y) :

	if (divSum(x) != y) :
		return False

	return (divSum(y) == x)

if((len(sys.argv)) < 3 or (len(sys.argv)) > 3):
	print('Missing required inputs')
	sys.exit()

number1 = int(sys.argv[1])
number2 = int(sys.argv[2])

if (areAmicable(number1,number2)) :
	print ('Numbers are Amicable.')
else :
	print ('Numbers are not Amicable.')
