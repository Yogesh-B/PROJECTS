#include <stdio.h>
#include <stack>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define rowSize 20
#define colSize 20

void parseString();

void createTable();
void printTable();
string displayStack(stack<char>);
void setArray();
int findIndexByOperator(char);

char operatorList[rowSize];
char table[rowSize][colSize];
int totalOperator;


int main(){

        setArray();

        printf("Enter Total Number of Operator: ");
        scanf("%d",&totalOperator);

        for(int i=0; i<totalOperator; i++) {
                printf("Enter %d operatorList : ",i+1);
                fflush(stdin);
                scanf("%c",&operatorList[i]);
        }
        operatorList[totalOperator++] = '$';

        createTable();
        printf("\nEnter Each operatorList Precedence\n");
        printf("\nIn Format  of (a<b,a>b,a=b) and Type Q to exit\n");

        char terminalNumberOne;
        char terminalNumberTwo;
        char symbol;

        while(cin>>terminalNumberOne) {
                if(terminalNumberOne == 'Q')
                        break;
                cin>>symbol;
                cin>>terminalNumberTwo;
                int t1 = findIndexByOperator(terminalNumberOne);
                int t2 = findIndexByOperator(terminalNumberTwo);
                table[t1+1][t2+1] = symbol;
        }

        printf("\n\nOperator Precedence Table\n\n");
        printTable();
        int p;

        while(1) {
                parseString();
                printf("\nEnter 0 to exit or 1 to continue : ");
                scanf("%d",&p);
                if(p==0)
                        break;
        }
        return 0;
}

void createTable(){

        for(int i =1; i<(totalOperator+1); i++) {
                table[0][i] = operatorList[i-1];
                table[i][0] = operatorList[i-1];
        }

        for(int i=0; i<(totalOperator+1); i++) {
                if(i>0)
                        table[i][totalOperator] = '>';

                for(int j=0; j<(totalOperator+1); j++) {
                        if(j>0)
                                table[totalOperator][j] = '<';

                }
        }
        table[0][0] = ' ';
        table[totalOperator][totalOperator] = 'e';
}

void parseString(){

        string input,temp;
        bool accepted = true;
        stack<char> Stack;

        Stack.push('$');

        printf("\n\nEnter Input String : ");
        cin>>input;
        input.push_back('$');

        printf("Stack\t\tInput String\tAction\n\n");
        temp = displayStack(Stack);
        cout<<temp<<"\t\t"<<input<<endl;

        while(!Stack.empty() && !input.empty()) {

                char a = input[0];
                char b = Stack.top();
                int a1 = findIndexByOperator(a);
                int b1 = findIndexByOperator(b);
                char result = table[a1+1][b1+1];

                if( (a == '$') &&  (b == '$')) {
                        break;
                }
                else if( result == '>' || result == '=') {

                        Stack.push(a);
                        input.erase(0,1);
                        temp = displayStack(Stack);
                        cout<<temp<<"\t\t"<<input<<"\t\t"<<"Shift"<<endl;
                }
                else if(result == '<') {

                        char res;
                        do{
                                Stack.pop();
                                int stp = findIndexByOperator(Stack.top());
                                res = table[a1+1][stp+1];
                        }while(res == '<');
                        if(a != '$') {
                                Stack.push(a);
                                input.erase(0,1);
                        }

                        temp = displayStack(Stack);
                        cout<<temp<<"\t\t"<<input<<"\t\t"<<"Reduce"<<endl;
                }
                else{
                        accepted = false;
                        break;
                }
        }
        if(accepted)
                printf("\n\nString is Accepted\n");
        else
                printf("\n\nString is Rejected...!!!\n");
}

void printTable(){
        for(int i=0; i<(totalOperator+1); i++) {
                for(int j=0; j<(totalOperator+1); j++)
                        cout<<table[i][j]<<" ";
                printf("\n");
        }

}

void setArray(){
        for(int i=0; i<rowSize; i++)
                for(int j=0; j<colSize; j++)
                        table[i][j] = 'e';
}

int findIndexByOperator(char c){

        for(int i=0; i<totalOperator; i++)
                if(c == operatorList[i])
                        return i;
        return -1;
}

string displayStack(stack<char> data){

        stack<char> temp;
        string str;
        while(!data.empty()) {
                str += data.top();
                temp.push(data.top());
                data.pop();
        }

        while(!temp.empty()) {
                data.push(temp.top());
                temp.pop();
        }

        reverse(str.begin(), str.end());
        return str;
}
