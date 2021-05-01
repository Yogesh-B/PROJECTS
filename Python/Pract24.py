import os

print('\nCurrent Working Directory : ',os.getcwd())

print('\nCurrent Directory Content : ')

print(*(os.listdir()),sep='\n')

directory = input('\nEnter Directory Name to be displayed : ')

print(*(os.listdir('./'+directory)),sep='\n')
