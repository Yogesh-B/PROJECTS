//practical 9 Implement RSA encryption-decryption algorithm.
#include <stdio.h>
#include <iostream>
#include <math.h>
using namespace std;

void encrypt();
void decrypt();
long int multipicative_inverse(long int, long int);
void key_pair(long int , long int , long int );


int main()
{
    int choice;
    cout << endl
         << "RSA encryption-decryption algorithm ... ";
    while (1)
    {
        cout << endl
             << endl;
        cout << "1.Encrypt\t2.Decrypt\t3.Exit" << endl;
        cout << endl
             << "Enter your choice: ";
        cin >> choice;
        switch (choice)
        {
        case 1:
            encrypt();
            break;
        case 2:
            decrypt();
            break;
        case 3:
            exit(0);
        default:
            cout << endl;
            cout << "Invalid choice,Enter valid choice : " << endl;
        }
    }
    return 0;
}

void key_pair(long int e, long int n, long int d)
{
    cout << endl
         << "Encryption key(e,O(n)): (" << e << "," << n << ")" << endl;
    cout << endl
         << "Decryption key(d,O(n)): (" << d << "," << n << ")" << endl;
}

void encrypt()
{
    long int pt, p, q, n, fn, e, temp, d, ct;
    cout << endl
         << "Enter your message to encrypt : ";
    cin >> pt;
    cout << endl
         << "Enter two prime numbers p and q: ";
    cin >> p >> q;
    cout << endl
         << "Enter value of e: ";
    cin >> e;
    n = p * q;
    fn = (p - 1) * (q - 1);
    d = multipicative_inverse(fn, e);
    if (d == 0)
    {
        cout << endl;
        cout << "RSA is not possible for given p and q." << endl;
        exit(0);
    }
    ct = fmod(pow(pt, e), n);
    key_pair(e, fn, d);
    cout << endl
         << "Cipher text: " << ct << endl;
}


void decrypt()
{
    long int pt, d, ct, n;
    cout << endl
         << "Enter message to decrypt: ";
    cin >> ct;
    cout << endl
         << "Enter key pair(d,n): ";
    cin >> d >> n;
    pt = fmod(pow(ct, d), n);
    cout << endl
         << "Plain Text : " << pt << endl;
}


long int multipicative_inverse(long int m, long int b)
{
    long int a1 = 1, a2 = 0, a3 = m, b1 = 0, b2 = 1, b3 = b, t1, t2, t3, q;
top:
    if (b3 == 0)
        return 0;
    else if (b3 == 1)
    {
        if (b2 < 0)
            return (b2 + m);
        else
            return b2;
    }
    q = a3 / b3;
    t1 = b1;
    t2 = b2;
    t3 = b3;
    b1 = a1 - (q * b1);
    b2 = a2 - (q * b2);
    b3 = a3 - (q * b3);
    a1 = t1;
    a2 = t2;
    a3 = t3;
    goto top;
}