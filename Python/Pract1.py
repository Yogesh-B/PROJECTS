#Create a program that asks the user to enter their name and their age. Print out a
#message addressed to them that tells them the year that they will turn 100 years
#old.
from datetime import datetime



name = input("Please Enter Your First Name : ")
age = input("Please Enter Your Age At This Moment (In years, INT only) : ")

d1 = datetime.now()
d1 = str(d1).split("-")[0]
finalYear = int(d1) + (100 - int(age))  #age remaining added to current year

print("Hello, ",name," You will turn 100 in year ",finalYear," :)")