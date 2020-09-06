#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

int main()
{
    char s[10];

    printf("Enter operator : ");
    scanf("%s",s);

    switch(s[0])
    {
        case '+':
            if(s[1]=='=')
                printf("\nShorthand Addition Operator\n");
            else if(s[1]=='+')
                printf("\nIncrement Operator\n");
            else
                printf("\nAddition Operator\n");
            break;
        case '-':
            if(s[1]=='=')
                printf("\nShorthand Subtraction Operator\n");
            else if(s[1]=='+')
                printf("\nDecrement Operator\n");
            else
                printf("\nSubtraction Operator\n");
            break;
        case '*':
            if(s[1]=='=')
                printf("\nShorthand Multiplication Operator\n");
            else
                printf("\nMultiplication Operator\n");
            break;
        case '/':
            if(s[1]=='=')
                printf("\nShorthand Division Operator\n");
            else
                printf("\nDivision Operator\n");
            break;
        case '%':
            if(s[1]=='=')
                printf("\nShorthand Modulus Operator\n");
            else
                printf("\nModulus Operator\n");
            break;
        case '=':
            if(s[1]=='=')
                printf("\nRelational Equal Operator\n");
            else
                printf("\nAssignment Operator\n");
            break;
        case '!':
            if(s[1]=='=')
                printf("\nRelational NOT Equal Operator\n");
            else
                printf("\nLogical NOT Operator\n");
            break;
        case '|':
            if(s[1]=='|')
                printf("\nLogical OR Opertator\n");
            else
                printf("\nBitwise OR Operator\n");
            break;
        case '&':
            if(s[1]=='&')
                printf("\nLogical AND Operator\n");
            else
                printf("\nBitwise AND Operator\n");
            break;
        case '<':
            if(s[1]=='=')
                printf("\nRelational Less or Equal Operator\n");
            else if(s[1]=='<')
            {
                if(s[2]=='=')
                    printf("\nShorthand Bitwise Left Shift Operator\n");
                else
                    printf("\nBitwise Left Shift Operator\n");
            }
            else
                printf("\nRelational Less Than Operator\n");
            break;
        case '>':
            if(s[1]=='=')
                printf("\nRelational Greater or Equal Operator\n");
            else if(s[1]=='>')
            {
                if(s[2]=='=')
                    printf("\nShorthand Bitwise Right Shift Operator\n");
                else
                    printf("\nBitwise Right Shift Operator\n");
            }
            else
                printf("\nRelational Greater Than Operator\n");
            break;
        case '~':
            printf("\nBitwise Complement Operator\n");
            break;
        case '^':
            printf("\nBitwise XOR Operation\n");
            break;
        default:
            printf("\nInvalid Input!!!\n");
            break;

    }




return 0;
}
