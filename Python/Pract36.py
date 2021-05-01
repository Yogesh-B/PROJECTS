from tkinter import *
from random import choice

root = Tk()
root.geometry("500x500")

root.title("GTU Pyhton Pratical-36")

canvas=Canvas(root, height=500, width=500)

buttonRed = Button(root, text = "Red", anchor = W, command=lambda:canvas.configure(bg="red"))
buttonRed.configure(width=10,activebackground="red",relief=FLAT)

buttonBlue = Button(root, text = "Blue", anchor = W, command=lambda:canvas.configure(bg="blue"))
buttonBlue.configure(width=10,activebackground="blue",relief=FLAT)

buttonGreen = Button(root, text = "Green", anchor = W, command=lambda:canvas.configure(bg="green"))
buttonGreen.configure(width=10,activebackground="green",relief=FLAT)


btn1 = canvas.create_window(100,10,anchor=NW,window=buttonRed)
btn2 = canvas.create_window(200,10,anchor=NW,window=buttonBlue)
btn3 = canvas.create_window(300,10,anchor=NW,window=buttonGreen)

canvas.pack()
root.mainloop()
