import re

regex = '^(\w|\.|\_|\-)+[@](\w|\_|\-|\.)+[.]\w{2,3}$'

def check(email):
	if(re.search(regex, email)):
		print('\nValid Email')
	else:
		print('\n Invalid Email')

email = input('\nEnter Email to be Checked : ')

check(email)
