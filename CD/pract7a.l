%{
#define yywrap() 1
#include <stdio.h>
int count=0;
FILE *file;
%}

%%
[0-9]+ {count++; printf("%s\t",yytext);}
.  ;
%%

int main()
{
    printf("\n\nReading data from input2.txt file...!!!\n");
    file = fopen("input2.txt", "r");
    if (file == NULL)
    {
      printf("\nUnable to open file.\n");
      printf("File input2.txt missing or not having read permission .\n");
      exit(EXIT_FAILURE);
    }
    
    yyin=file;
    yylex();
	printf("\nTotal numbers  :  %d\n\n", count);
    
return 0;

}