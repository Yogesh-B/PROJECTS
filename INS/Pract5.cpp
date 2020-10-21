//practical 5 Implement Hill cipher encryption-decryption. 
#include <iostream>
using namespace std;

void getKeyMatrix(string, int [][3]);
void encrypt(int [][1], int [][3], int [][1]);
void HillCipher(string , string );

int main()
{
    string message, key;
    cout << endl
         << "Hill cipher Encryption-Decryption.";
    cout << endl
         << endl
         << "Enter Key : ";
    cin >> key;
    cout << endl
         << "Enter Plain Text : ";
    cin >> message;
    HillCipher(message, key);
    return 0;
}

void getKeyMatrix(string key, int keyMatrix[][3])
{
    int k = 0;
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            keyMatrix[i][j] = key[k] - '0';
            k++;
        }
    }
}

void encrypt(int cipherMatrix[][1], int keyMatrix[][3], int messageVector[][1])
{
    int x, i, j;
    for (i = 0; i < 3; i++)
    {
        for (j = 0; j < 1; j++)
        {
            cipherMatrix[i][j] = 0;
            for (x = 0; x < 3; x++)
            {
                cipherMatrix[i][j] += keyMatrix[i][x] *
                                      messageVector[x][j];
            }
            cipherMatrix[i][j] =
                cipherMatrix[i][j] % 26;
        }
    }
}

void HillCipher(string message, string key)
{
    int keyMatrix[3][3], cipherMatrix[3][1];
    getKeyMatrix(key, keyMatrix);
    int messageVector[3][1];
    for (int i = 0; i < 3; i++)
        messageVector[i][0] = (message[i]) % 65;
    encrypt(cipherMatrix, keyMatrix, messageVector);
    string CipherText;
    for (int i = 0; i < 3; i++)
        CipherText += cipherMatrix[i][0] + 65;
    cout << endl
         << "Cipher Text:" << CipherText << endl;
}

