%{
#define yywrap() 1
#include <stdio.h>
FILE *fin,*fout;
int count=0;
%}

%%
[/][/].* {count++;}

[/][\*].*[\n]*[\*][/]   {count++;}
%%

int main()
{
	printf("Source file : input4.c\n");
	printf("Output file : output1.c\n");
	
	fin = fopen("input4.c","r");
	fout = fopen("output1.c","w");
	yyin=fin;
	yyout=fout;
	
	yylex();
	fclose(fin);
	fclose(fout);
	
	printf("\n%d comments removed from input4.c and new file is output1.c", count);
	
	return 0;
}