# 1. Without Loop

word=input('\nEnter Word : ')
reverseWord=word[::-1]

if word == reverseWord:
    print('\nWithout Loop Output : This String is palindrome')
else:
    print('\nWithout Loop Output : This String is not palindrome')

# 2. With Loop

def reverse(word):
	x = ''
	for i in range(len(word)):
		x += word[len(word)-1-i]
	return x

x = reverse(word)

if word == x:
    print('\nWith Loop Output : This String is palindrome')
else:
    print('\nWith Loop Output : This String is not palindrome')
