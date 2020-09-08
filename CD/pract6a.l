%{

#define yywrap() 1
#include<stdio.h>
int lines=0,words=0,characters=0;
FILE *file;

%}

%%
\n          {words++; lines++;}
[\t ]    words++;
[a-zA-Z0-9] characters++;
.   ;
%%

int main() {

    printf("Reading data from input1.txt file \n");
    file = fopen("input1.txt", "r");

    if (file == NULL){
      printf("\nUnable to open file.\n");
      printf("File input1.txt missing or not having read permission .\n");
      exit(EXIT_FAILURE);
      }

      yyin = file;
      yylex();
      printf("\n");
      printf("Total characters = %d\n", characters);
      printf("Total words      = %d\n", words);
      printf("Total lines      = %d\n", lines);

    return 0;

}
