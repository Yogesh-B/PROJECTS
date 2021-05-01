class Complex:
    def __init__(self,real,imaginary):
        self.Real  = real
        self.Imaginary  = imaginary

    def __str__(self):
        output = '{} + {}i'\
        .format(self.Real,self.Imaginary)
        return output

    def __add__(self,other):
        temp = Complex(0,0)
        temp.Real = self.Real + other.Real
        temp.Imaginary = self.Imaginary + other.Imaginary
        return temp

c1 = Complex(2,3)
c2 = Complex(5,-1)

print('\nFirst Number : ',c1)
print('Second Number : ',c2)
print('After Adding : ',c1+c2)
