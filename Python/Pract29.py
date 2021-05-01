import random
import array
import string

while True:
    MAX_LEN = int(input('\nEnter Random Password Length : '))
    if MAX_LEN > 4:
        break
    else:
        print('\nPassword Length should be greater than 4.Try Again...!!!')

DIGITS = list(string.digits)

LOCASE_CHARACTERS = list(string.ascii_letters)[:26]

UPCASE_CHARACTERS = list(string.ascii_letters)[26:]

SYMBOLS = list(string.punctuation)

COMBINED_LIST = DIGITS + UPCASE_CHARACTERS + LOCASE_CHARACTERS + SYMBOLS

rand_digit = random.choice(DIGITS)
rand_upper = random.choice(UPCASE_CHARACTERS)
rand_lower = random.choice(LOCASE_CHARACTERS)
rand_symbol = random.choice(SYMBOLS)

temp_pass = rand_digit + rand_upper + rand_lower + rand_symbol

for x in range(MAX_LEN - 4):
	temp_pass = temp_pass + random.choice(COMBINED_LIST)
	temp_pass_list = array.array('u', temp_pass)
	random.shuffle(temp_pass_list)

password = ""
for x in temp_pass_list:
		password += x

print('\nAuto-Generated-Password is : ',password)
