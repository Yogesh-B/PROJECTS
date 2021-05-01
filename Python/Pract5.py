def getfactors(number):
    return [x for x in range(1,number+1) if number%x == 0]

number = int(input('\nEnter Number : '))
print('\nAnswer : {}'.format(getfactors(number)))
