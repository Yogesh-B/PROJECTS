from tkinter import *


root = Tk(className="Pratical-35")
root.geometry("500x500")

def message():
    w = Label(root, text = "Hello World")
    w.pack()

button = Button(root, text = "Click Me!", command = message)
button.place(x=25, y=80)

root.mainloop()
