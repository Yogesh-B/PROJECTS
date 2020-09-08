%{
#define yywrap() 1
#include<stdio.h>
int vowels=0,consonants=0;
%}

%%
[aeiouAEIOU] {vowels++;}
[a-zA-Z] {consonants++;}
%%

int main() {

    printf("Enter the String: ");
    yylex();
    printf("The number of vowels are:  %d\n",vowels);
    printf("The number of consonants are:  %d\n",consonants);

    return 0;
}
