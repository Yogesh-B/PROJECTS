#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define Size 20

char input[Size];
int i,error;

void E();
void T();
void Es();
void Ts();
void F();

int main(){

        printf("Input Grammar\n\n");
        printf("0.E -> TE'\n");
        printf("1.E'-> +TE'\n");
        printf("2.E'-> #\n");
        printf("3.T -> FT'\n");
        printf("4.T'-> *FT'\n");
        printf("5.T'-> #\n");
        printf("6.F -> (E)\n");
        printf("7.F -> id\n\n");
        i=0;
        error=0;
        printf("Enter an arithmetic expression:  ");
        gets(input);
        E();
        if(strlen(input)==i&&error==0)
                printf("\nString is Accepted..!!!\n");
        else
                printf("\nString is Rejected..!!!\n");
        return 0;
}

void E(){
        T();
        Es();
}

void Es(){
        if(input[i]=='+') {
                i++;
                T();
                Es();
        }
}

void T(){
        F();
        Ts();
}

void Ts(){
        if(input[i]=='*') {
                i++;
                F();
                Ts();
        }
}

void F(){
        if(isalnum(input[i]))
                i++;
        else if(input[i]=='(') {
                i++;
                E();
                if(input[i]==')')
                        i++;
                else
                        error=1;
        }
        else
                error=1;
}
 