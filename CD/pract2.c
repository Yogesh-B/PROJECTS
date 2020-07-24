/*practical 2 
    Write a C program to identify whether a given line is comment or not.
*/

#include <stdio.h>
#include <conio.h>
#include <string.h>

void checker(char[]);

int main(){
    char str[50];
    printf("Enter string : "); 
    scanf("%s",str);
    
    checker(str);

    getch();
    return 0;
}
void checker(char * str){
    if( str[0]=='/'){
        if( str[1]=='/' ){
            printf("It is a comment...!!!");
        }
        else if( str[1]=='*' ){
            if( str[strlen(str)-2]=='*' && str[strlen(str)-1]=='/' ){
                printf("It is a comment...!!!");
            }
        }
        else{
            printf("It is not a comment...!!!");
        }
    }
    else{
            printf("It is not a comment...!!!");
        }
}
