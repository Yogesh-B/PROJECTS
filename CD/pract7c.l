%{
#define yywrap() 1
#include <stdio.h>
FILE *fin;      //,*fout;
int line_number = 1;
%}

%%
\n {}
.*  {
        printf("%5d %s\n", line_number, yytext);
        //fprintf(yyout,"%5d %s\n",line_number,yytext); //for output file
        line_number++;
	}
%%

int main(){

		printf("Source file input1.txt  \n");
		//printf("Destination file output1.txt: ");
		
		
		fin = fopen("input1.txt", "r");
		//fout = fopen("output1.txt","w");

		if (fin == NULL){
			printf("\nUnable to open file.\n");
			exit(EXIT_FAILURE);
			}
		printf("Output:\n\n");
		yyin = fin;
		                    //yyout = fout;
		yylex();
		fclose(fin);
		
		return 0;

}
