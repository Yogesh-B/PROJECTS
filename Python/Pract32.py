# py -, pip install matplotlib
import matplotlib.pyplot as plt
import numpy as np

# 1. One Line in one Plane
x = [1,2,3]
y = [2,4,1]

plt.plot(x, y)

plt.xlabel('Time')
plt.ylabel('Distance')

plt.title('Speed')
plt.show()

# 2. Two Line in one plane

x1 = [1,2,3]
y1 = [2,4,1]

plt.plot(x1, y1, label = "line 1")

x2 = [1,2,3]
y2 = [4,1,3]
plt.plot(x2, y2, label = "line 2")

plt.xlabel('x - Axis')
plt.ylabel('y - Axis')
plt.title('Two Lines in One Plane.')

plt.legend()
plt.show()

# 3. Bar chart

left = [1, 2, 3, 4, 5]

height = [10, 24, 36, 40, 5]

tick_label = ['one', 'two', 'three', 'four', 'five']

plt.bar(left, height, tick_label = tick_label,
		width = 0.8, color = ['blue', 'green'])

plt.xlabel('x - axis')
plt.ylabel('y - axis')
plt.title('Bar Chart')

plt.show()

# 4. Histogram

ages = [2,5,70,40,30,45,50,45,43,40,44,
		60,7,13,57,18,90,77,32,21,20,40]

range = (0, 100)
bins = 10

plt.hist(ages, bins, range, color = 'blue',
		histtype = 'bar', rwidth = 0.8)

plt.xlabel('Age')
plt.ylabel('No. of people')
plt.title('Histogram')

plt.show()

# 5. Scatter Plot

x = [1,2,3,4,5,6,7,8,9,10]
y = [2,4,5,7,6,8,9,11,12,12]

plt.scatter(x, y, label= "stars", color= "blue",
			marker= "*", s=30)

plt.xlabel('x - axis')
plt.ylabel('y - axis')
plt.title('Scatter Plot')
plt.legend()
plt.show()

# 6. Pie chart

activities = ['Forest', 'Land', 'River', 'Agriculture']

slices = [4, 5, 9, 4]

colors = ['r', 'y', 'g', 'b']

plt.pie(slices, labels = activities, colors=colors,
		startangle=90, shadow = True, explode = (0, 0, 0.1, 0),
		radius = 1.2, autopct = '%1.1f%%')

plt.title('Pie Chart')
plt.show()

# 7. Curves

x = np.arange(0, 2*(np.pi), 0.1)
y = np.sin(x)

plt.plot(x, y)
plt.title('Curves')

plt.show()
