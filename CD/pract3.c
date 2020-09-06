#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <stdlib.h>


int main()
{
    char str[25];
    char keywords[32][10]={"break","case","char","const","continue","default","do","else","enum","extern","float","for","goto","if","long","register","return","short","signed","sizeof","static","switch","typedef","union","unsigned","void","volatile","while"};
    int flag=0;
    int i,j;

    printf("Enter a identifier name : ");
    scanf("%s",str);

    //check for keyword
    for(i=0; i<strlen(keywords);i++)
    {
        if(strcmp(keywords[i],str)==0)
        {
            flag=2;
        }
    }

    //checking for first character if not keyword
    if(flag!=2)
    {
        if( (isalpha(str[0])!=0) || (str[0]=='_') )
        {
            flag = 1;
        }
    }

    //checking for remaining characters  if first letter is valid
    if(flag == 1)
    {
        for(i=1; i<strlen(str); i++)
        {
            if( isalnum(str[i])==0 && str[i]!='_')
            {
                flag=0;
                break;
            }
        }
    }



    //final result
    if(flag==1)
        printf("Valid Identifier...!!!\n\n");
    else if(flag==2)
        printf("It is a Keyword...!!!\n\n");
    else
        printf("Invalid Identifier...!!!\n\n");

    return 0;
}
