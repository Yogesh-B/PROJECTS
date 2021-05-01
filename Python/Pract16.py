class Student:
    def __init__(self,rollNumber,name,age,totalMarks):
        self.RollNumber = rollNumber
        self.Name = name
        self.Age = age
        self.Marks = totalMarks

    def __eq__(self,other):
        return self.Marks == other.Marks

    def __str__(self):
        output = '\nRollNumber : {}\nName : {}\nAge : {}\nMarks : {}\n'\
        .format(self.RollNumber,self.Name,self.Age,self.Marks)

        return output

s1 = Student(1,'Hulk',18,700)
s2 = Student(2,'Ironman',20,700)
s3 = Student(3,'Captain America',60,699)
s4 = Student(4,'Thor',70,500)

if(s1 == s2):
    print(s1,s2)
