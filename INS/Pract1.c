//practical 1   Implement Caesar cipher encryption-decryption. 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void encryption(char*,int);
void decryption(char*,int);
char PT[50],CT[50];

int main(){
    
    int k;
        /*.................Encryption................*/
    printf("\n...Encryption process...\n");
    printf("Enter Plain text : ");
    scanf("%s",PT);
    printf("Enter Key : ");
    scanf("%d",&k);
    
    encryption(PT,k); 
    printf("Encrypted text is : %s\n\n",CT);
    
        /*.................Decryption................*/
    printf("\n...Decryption process...\n");
    printf("Enter Cipher text : ");
    scanf("%s",CT);
    printf("Enter Key : ");
    scanf("%d",&k);
    
    decryption(CT,k); 
    printf("Decrypted text is : %s\n\n",PT);
    
    return 0;
}


void encryption(char* str,int k){
    int l,i;
   
    l=strlen(str);
    
    for(i=0; i<l; i++){
        if(isalnum(str[i])){   // we are olny considering alphabets and putting other as it is
            CT[i]=str[i]+k;
        }
        else{
            CT[i]=str[i];
        }
    }
}

void decryption(char* str,int k){
    int l,i;
    
    l=strlen(str);
    
    for(i=0; i<l; i++){         // we are olny considering alphabets and putting other as it is
        if(isalnum(str[i])){
            PT[i]=str[i]-k;
        }
        else{
            PT[i]=str[i];
        }
    }
}






