# 1.

number = int(input('\nEnter a number :'))

if number % 4 == 0:
    print('\nThe number {} is multiple of 4.'.format(number))
elif number % 2 == 0:
    print('\nThe number {} is even.'.format(number))
else:
    print('\nThe number {} is odd.'.format(number))

# 2.

num = int(input('\nEnter a number to check :'))
check = int(input('\nEnter a number to divide by :'))

if num % check == 0:
    print('\n{} divide evenly by {}.'.format(num,check))
else:
    print('\n{} does not divide evenly by {}.'.format(num,check))
