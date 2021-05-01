import turtle

wn = turtle.Screen()

# 1. An equilateral triangle
triangle = turtle.Turtle()
for i in range (3):
    triangle.forward(50)
    triangle.left(120)

# 2. A square
square =turtle.Turtle()
square.up()
square.forward(70)
square.down()
for i in range (4):
    square.forward(50)
    square.left(90)

# 3. Hexgon
hex =turtle.Turtle()
hex.up()
hex.forward(-70)
hex.down()
for i in range (6):
    hex.forward(30)
    hex.left(60)

# 4. An Octagon
oct =turtle.Turtle()
oct.up()
oct.forward(-170)
oct.down()
for i in range (8):
    oct.forward(25)
    oct.left(45)

turtle.exitonclick()
