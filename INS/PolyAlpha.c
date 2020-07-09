#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char a = 'a';
    char arr[26][26];
    int i,j;


    //generating poly matrix and printing on screen
    printf("__");
    for ( i=0; i<26; i++ ){
        printf("%c_",'A'+i);
    }
    printf("\n");

    for ( i=0; i<26; i++ ){
        for ( j=0; j<26; j++ ){
            printf("%c ",'a'+(i+j)%26);
            arr[i][j] = 'a' + (i+j)%26;
        }
        printf("\n");
    }

    for (i=0; i<26; i++){
        for ( j=0; j<26; j++){
            printf("%c ", arr[i][j]);
        }
        printf("\n");
    }
    return 0;
}
