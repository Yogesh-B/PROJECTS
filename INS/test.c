#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <conio.h>

void change(char*);

int main(){

    char str[23];
    char *key=calloc(23,sizeof(char));
    printf("Enter here : ");
    scanf("%s",key);
    str[0] = '\0';
    strcat(str,"hi,");
    strcat(str,key);
    change(str);
    printf("%s",str);   
    
    
    
    return 0;
}
void change(char* str){
    strcat(str,"JI");
}