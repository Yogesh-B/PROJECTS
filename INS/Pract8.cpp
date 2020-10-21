//practical 8 Implement Diffi-Hellmen Key exchange Method.
#include <iostream>
using namespace std;

int compute(int, int, int);

int main()
{
    int prime, root;
    int privateKeyA, privateKeyB;
    int A, B;
    cout << endl
         << "Implement Diffi-Hellmen Key exchange Method" << endl;
    cout << endl
         << "Enter Prime Number : ";
    cin >> prime;
    cout << endl
         << "Enter Root : ";
    cin >> root;
    cout << endl
         << "Enter Private Key of User A : ";
    cin >> privateKeyA;
    cout << endl
         << "Enter Private Key of User B : ";
    cin >> privateKeyB;
    A = compute(root, privateKeyA, prime);
    B = compute(root, privateKeyB, prime);
    int keyA = compute(B, privateKeyA, prime);
    int keyB = compute(A, privateKeyB, prime);
    cout << endl;
    cout << "A's Secret Key is " << keyA << endl
         << "B's Secret Key is " << keyB;
    cout << endl;
    return 0;
}

int compute(int a, int m, int n)
{
    int r;
    int y = 1;
    while (m > 0)
    {
        r = m % 2;
        if (r == 1)
            y = (y * a) % n;
        a = a * a % n;
        m = m / 2;
    }
    return y;
}