%{
#include<stdio.h>
int yywrap();
int yylex();
int yyerror(char *c);
int error = 0;
%}

%token ID NUMBER
%left '+' '-'
%left '*' '/'

%%
stmt:expr
    ;
expr: expr '+' expr
    | expr '-' expr
    | expr '*' expr
    | expr '/' expr
    | '(' expr ')'
    | NUMBER
    | ID
    ;
%%

void main() {

  printf("\nEnter Arithmetic Expressions: ");
  yyparse();
  if(!error)
    printf("\nArithmetic Expressions is Valid\n");
  return;
}

int yyerror(char *c){

  printf("\nArithmetic Expressions is Not Valid...!!!\n");
  error = 1;
  return 0;
}

int yywrap(){
    return(1);
}
