%{
#define yywrap() 1
#include <stdio.h>
FILE *file;
%}

%%
[<][^>]*>  {printf("-%s-",yytext);}
.   ;
%%

int main()
{
    printf("\n\nReading data from input3.html file...!!!\n");
    file = fopen("input3.html", "r");
    
    if (file == NULL)
    {
      printf("\nUnable to open file.\n");
      printf("File input3.html missing or not having read permission .\n");
      exit(EXIT_FAILURE);
    }
    
    yyin=file;
    yylex();
    
    return 0;
}