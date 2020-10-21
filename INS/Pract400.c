// practical 4 Implement Polyalphabetic cipher encryption-decryption.
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <conio.h>
#define SIZE 50
#define N 5


char* generateKey(char *, char *);
char* cipherText(char *, char *);
char* originalText(char *, char *);

int main()
{
    char str[SIZE], keyword[SIZE];
    char *key = (char*)calloc(SIZE,sizeof(char));
    char *cipher_text = (char*)calloc(SIZE,sizeof(char));
    // key[0]='\0';
    // cipher_text[0]='\0';    //those '\0' s are for escaping garbage character added while strcat

    printf("Polyalphabetic Encryption : \n");
    printf("Enter Plaintext : \n");
    scanf("%s",str);
    printf("Enter Keyword : ");
    scanf("%s",keyword);
    key = generateKey(str, keyword);
    cipher_text = cipherText(str, key);
    printf("Encrypted text : %s\n\n\n",cipher_text);
    
   
    printf("Polyalphabetic Decryption : \n");
    printf("Enter Ciphertext : \n");
    scanf("%s",str);
    printf("Enter Keyword : ");
    scanf("%s",keyword);
    key = generateKey(str, keyword);
    cipher_text = cipherText(str, key);
    printf("Encrypted text : %s\n\n\n",cipher_text);


    return 0;
}


char* generateKey(char* str, char* key)
{
    int x,i;
    x = strlen(str);
    for ( i = 0;; i++)
    {
        if (x == i)
            i = 0;
        if (strlen(key) == strlen(str))
            break;
        strcat(key,key[i]);
    }
    return key;
}

char* cipherText(char* str, char* key)
{
    int i;
    char x;
    char *cipher_text = (char*)calloc(SIZE,sizeof(char));
    cipher_text[0]='\0';
    for ( i = 0; i < strlen(str); i++)
    {
        x = (str[i] + key[i]) % 26;
        x += 'A';
        strcat(cipher_text,x);
    }
    return cipher_text;
}

char* originalText(char* cipher_text, char* key)
{
    char* orig_text=(char*)calloc(SIZE,sizeof(char));
    int i;
    char x;
    orig_text[0]='\0';
    for ( i = 0; i < strlen(cipher_text); i++)
    {
        x = (cipher_text[i] - key[i] + 26) % 26;
        x += 'A';
        strcat(orig_text,x);
    }
    return orig_text;
}