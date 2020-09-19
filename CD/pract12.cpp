#include <stdio.h>
#include <string.h>
#include <bits/stdc++.h>
#include <iostream>
#define rowSize 20
#define colSize 20
using namespace std;

// LALR Function
void createTable();
void printTable();
void parseLALRString();

// Utility function
string displayStack(stack<string>);
int findIndexByTerminal(char);
int findIndexByNonTerminal(char);

int totalProduction,totalTerminal,totalNonTerminal;
int totalStates;

char production[rowSize][colSize];
char nonTerminal[rowSize];
char terminal[rowSize];

string table[rowSize][colSize];

int main(){

        // Input of Terminal
        printf("Enter Total Number of terminal: ");
        scanf("%d",&totalTerminal);

        for(int i=0; i<totalTerminal; i++) {
                printf("Enter %d terminal : ",i+1);
                fflush(stdin);
                scanf("%c",&terminal[i]);
        }
        terminal[totalTerminal++] = '$';

        // Input of Non-terminal
        printf("\nEnter Total Number of Non-terminal: ");
        scanf("%d",&totalNonTerminal);

        for(int i=0; i<totalNonTerminal; i++) {
                printf("Enter %d Non-Terminal : ",i+1);
                fflush(stdin);
                scanf("%c",&nonTerminal[i]);
        }

        // Input of Production
        printf("\nEnter Total Number of Productions: ");
        scanf("%d", &totalProduction);

        for(int i = 0; i < totalProduction; i++) {
                printf("\nValue of Production Number [%d]: ", i + 1);
                scanf("%s",&production[i]);
        }

        printf("\nEnter Total Number of States: ");
        scanf("%d",&totalStates);
        createTable();

        printf("\nEntered Grammar\n\n");
        for(int i = 0; i < totalProduction; i++)
                printf("%d.%s\n",i,production[i]);
        printf("\n");

        printf("\nEnter Actions For States\n");
        printf("\nIn Format  of (State Number,Terminal,Shift/Reduce Move) and Type exit to exit\n");

        string stateNumber,move;
        char terminalSymbol,nonTerminalSymbol;

        while(cin>>stateNumber) {

                if(stateNumber == "exit")
                        break;
                cin>>terminalSymbol;
                cin>>move;
                int terminalNumber = findIndexByTerminal(terminalSymbol);
                table[stoi(stateNumber)+1][terminalNumber+1] = move;
        }

        printf("\nEnter GoTo For States\n");
        printf("\nIn Format  of (State Number,Non-terminal,Move) and Type exit to exit\n");

        while(cin>>stateNumber) {

                if(stateNumber == "exit")
                        break;
                cin>>nonTerminalSymbol;
                cin>>move;
                int nonTerminalNumber = findIndexByNonTerminal(nonTerminalSymbol);
                int index = (totalTerminal+nonTerminalNumber);
                table[stoi(stateNumber)+1][index+1] = move;
        }
        printf("\n\nLALR  Parsing Table\n\n");
        printTable();

        int p;
        while(1) {
                parseLALRString();
                printf("Enter 0 to exit or Press 1 to continue : ");
                scanf("%d",&p);
                if(p==0)
                        break;
        }
        return 0;
}

void createTable(){

        int countTerminal = 0,countNonTerminal=0;

        for(int i=1; i<(totalTerminal+totalNonTerminal+1); i++)
                if(countTerminal < totalTerminal)
                        table[0][i] = terminal[countTerminal++];
                else
                        table[0][i] = nonTerminal[countNonTerminal++];

        for(int i=1; i<totalStates+1; i++)
                table[i][0] = to_string(i-1);
}

void printTable(){

        int spaceIndex =  totalTerminal;
        for(int i=0; i<totalStates+1; i++) {
                for(int j=0; j<(totalTerminal+totalNonTerminal+1); j++) {
                        if(table[i][j] == "$")
                                cout<<table[i][j]<<"\t\t";
                        else if(j==spaceIndex)
                                cout<<table[i][j]<<"\t\t";

                        else
                                cout<<table[i][j]<<"\t";
                }
                printf("\n");
        }
}

void parseLALRString(){

        string input;

        printf("\n\nEnter input string : ");
        cin>>input;

        input.push_back('$');
        stack<string> Stack;
        Stack.push("$");
        Stack.push("0");
        bool accepted = true;
        int spaceHeading = 25;
        cout<<endl<<endl<<"\t"<<"Stack"<<setw(spaceHeading)<<"Input String"<<setw(spaceHeading)<<"  Action"<<endl;
        vector<string> result;


        while(!Stack.empty() && !input.empty()) {

                int stateNumber = stoi(Stack.top());
                int terminalNumber = findIndexByTerminal(input[0]);
                string entry = table[stateNumber+1][terminalNumber+1];
                string temp;

                if(((entry.at(0)) == 'S') || ((entry.at(0) )=='s')) {

                        Stack.push(string(1,input[0]));
                        string temp(entry);
                        temp.erase(0,1);
                        Stack.push(temp);
                        input.erase(0, 1);
                        temp = displayStack(Stack);

                        result.push_back(temp);
                        result.push_back(input);
                        result.push_back("Shift Move");
                }
                else if(((entry.at(0)) == 'R') || ((entry.at(0)) =='r')) {

                        int productionNumber = stoi(string(1,entry.at(1)));
                        int productionLength = strlen(production[productionNumber-1]) - 2;


                        for(int i=0; i<2*productionLength; i++)
                                Stack.pop();

                        int symbolNumber = findIndexByNonTerminal(production[productionNumber-1][0]);
                        string str = table[stoi(Stack.top())+1][totalTerminal+1+symbolNumber];
                        Stack.push(string(1,production[productionNumber-1][0]));
                        Stack.push(string(str));

                        temp = displayStack(Stack);
                        result.push_back(temp);
                        result.push_back(input);
                        result.push_back("Reduce Move");
                }
                else if(input == "$" && Stack.top() == "1")
                        break;
                else{
                        printf("Something is going wrong");
                        accepted = false;
                        exit(0);
                }

        }

        for(int i=0; i<result.size(); i++) {
                if(i % 3 != 0)
                        cout<<"\t"<<result[i]<<"\t\t";
                else
                        cout<<endl<<"\t"<<result[i]<<"\t\t";
        }

        if(accepted)
                printf("\n\n\t\t\tString is Accepted\n\n");
        else
                printf("\n\n\t\t\tString is Rejected...!!!\n\n");

}

int findIndexByNonTerminal(char c){

        for(int i=0; i<totalNonTerminal; i++) {
                if(c == nonTerminal[i])
                        return i;
        }
        return -1;
}

int findIndexByTerminal(char c){

        for(int i=0; i<totalTerminal; i++)
                if(c == terminal[i])
                        return i;
        return -1;
}

string displayStack(stack<string> data){

        stack<string> temp;
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
