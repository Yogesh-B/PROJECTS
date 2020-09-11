//practical 9 ... recursive descent parser for mini language....if language changed, functions needs to be changed accordingly...!!!

/*grammar given below*/

//E->TE'
//E'->+TE' | NULL
//T->FT'
//T'->*FT' | NULL
//F->(E) | id

#include <stdio.h>
#include <string.h>

//declarations
void E();
void Es();
void T();
void Ts();
void F();

char checkString[100];
int i,error;

int main(){
    
    printf("Enter input string to check : ");
    scnaf("%s",checkString);
    
    E();  //calling first/root function  
    
    return 0;
}


void E(){
    T();
    Es();
}

void Es(){
    if(checkString[i]=='+'){
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
    if(checkString[i]=='*'){
        i++;
        F();
        Ts();
    }
}

void F(){
    if(islower(checkString[i])){
        i++;
    }
    else if(checkString[i]=='('){
        i++;
        
    }
}


//https://www.youtube.com/watch?v=jZqhh3kj3xU