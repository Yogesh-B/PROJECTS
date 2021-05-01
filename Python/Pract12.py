# Using Function
def isPrime(num):
    print('\nUsing Function')
    flag = False
    if num > 1:
        for i in range(2, num):
            if (num % i) == 0:
                flag = True
                break
    return flag

def printMessage(number,result):
    if result:
        print(number, "is not a Prime Number.")
    else:
        print(number, "is a Prime Number.")

number = int(input('Enter Number : '))
modNumber = abs(number);

type = 3

if(type == 1):
    printMessage(number,isPrime(modNumber))
elif type == 2 :
    print('\nWithout Function')
    flag = False
    if modNumber > 1:
        for index in range(2,modNumber):
            if modNumber % index == 0:
                flag = True
                break
    printMessage(number,flag)
else:
    print('\nList Comprehensions')
    primes = [index for index in range(2,modNumber) if modNumber % index == 0]
    if len(primes) == 0 :
        printMessage(number,False)
    else:
        printMessage(number,True)
