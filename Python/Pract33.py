def encrypt(text,s):
    result = ""
    for i in range(len(text)):
        char = text[i]

        if (char.isupper()):
            result += chr((ord(char) + s-65) % 26 + 65)
        else:
            result += chr((ord(char) + s - 97) % 26 + 97)
    return result


text  = input('\nEnter Plain Text : ')
shift = int(input('\nEnter Shift Pattern : '))

print('\nPlain Text : ' + text)
print('Shift pattern : ' + str(shift))
print('Cipher Text : ' + encrypt(text,shift))
