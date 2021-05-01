class Employee:
    def __init__(self,name,department,salary):
        self.Name = name
        self.Department = department
        self.Salary = salary

    def __str__(self):
        output = '\nName : {}\nDepartment : {}\nSalary : {}\n'\
        .format(self.Name,self.Department,self.Salary)

        return output

e1 = Employee('Nick Fury','Computer',5000)
e2 = Employee('Hawk Eye','Civil',10000)
e3 = Employee('Spiderman','Accounting',2000)

print(e1,e2,e3)
