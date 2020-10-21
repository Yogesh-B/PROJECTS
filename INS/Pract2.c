// practical 2 Implement Monoalphabetic cipher encryption-decryption
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <conio.h>


void encryption(char*,char*);
void decryption(char*,char*);
char PT[50],CT[50],K[26];

int main(){
    
    int i;
    
	/*.................Encryption................*/
    printf("\n...Encryption process...\n");
    printf("Enter Plain text : ");
    scanf("%s",PT);
    printf("\nEnter mapping for a to z : \n");
    printf("abcdefghijklmnopqrstuvwxyz\n");
	scanf("%s",K);
	printf("\n");
	
    encryption(PT,K); 
    printf("Encrypted text is : %s\n\n\n",CT);
    
    /*.................Decryption................*/
    printf("\n...Decryption process...\n");
    printf("Enter Cipher text : ");
    scanf("%s",CT);
    printf("\nEnter mapping for a to z : \n");
    printf("abcdefghijklmnopqrstuvwxyz\n");
	scanf("%s",K);
    printf("\n");
	
    decryption(CT,K);
    printf("Decrypted text is : %s\n\n",PT);
    
    return 0;
}


void encryption(char* str,char* k){
    int i,l,c;
	l=strlen(str);
	
	for(i=0;i<l;i++){
		c=PT[i]-97;
		CT[i]=k[c];
	}
}

void decryption(char* str,char* k){
    int i,l,c;
	l=strlen(str);
	
	for(i=0;i<l;i++){
		c=PT[i]-97;
		CT[i]=k[c];
	}
}



	
	
	
 // }
 // for(i = 0; i < strlen(pt); i++) {
 // index = pt[i] - 97;
 // ct[i] = c[index];
 // }
 // cout<<endl<<endl<<"Cipher Text is : ";
 // for(i = 0; i < strlen(pt); i++)
 // cout<<ct[i];
// }