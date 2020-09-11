#include <stdio.h>
#include <iostream>
#include <string.h>
#include <stack>
#define rowSize 20
#define colSize 20
using namespace std;

char epsilon = '#';

// Functions for creating  first set
void Find_First(char[], char);
void Array_MainpulationByFirst(char[], char);

// Functions for creating  follow set
void find_first(char ch);
void find_follow(char ch);
void Array_MainpulationByFollow(char ch);

// Function for creating predictive table or LL(1) table
void createTable();
void printLLOneTable();
void parseString();

// Utility function
void setArray();
void showArray(char [rowSize][colSize]);
int findIndexByNonTerminal(char);
int findIndexByTerminal(char);
int isTerminal(char);
void displayStack(stack<char>);

int totalProduction,totalTerminal,totalNonTerminal;
int x = 0;

char production[rowSize][colSize],array[rowSize];
char first[rowSize][colSize];
char follow[rowSize][colSize];
char table[rowSize][colSize];
char terminal[rowSize],nonTerminal[rowSize];

int main(){

        setArray();
        char firstArray[rowSize];


        // Input of Terminal
        printf("Number of terminal: ");
        scanf("%d",&totalTerminal);
        totalTerminal++;

        for(int i=0; i<(totalTerminal-1); i++) {
                printf("Enter %d terminal : ",i+1);
                fflush(stdin);
                scanf("%c",&terminal[i]);
        }
        terminal[totalTerminal-1] = '$';

        // Input of Non-terminal
        printf("\nNumber of Non-terminal: ");
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
                scanf("%s", production[i]);
        }

        printf("\nInput Grammar\n");
        for(int i = 0; i < totalProduction; i++)
                printf("\n%d.%s",i,production[i]);
        printf("\n");


        // Create First Set
        for(int index=0; index<totalNonTerminal; index++) {

                int j=1;
                first[index][0] = nonTerminal[index];

                Find_First(firstArray,nonTerminal[index]);

                for(int count = 0; firstArray[count] != '\0'; count++)
                        first[index][j++] = firstArray[count];
        }

        // Create Follow Set
        for(int index=0; index<totalNonTerminal; index++) {

                for(int i=0; i<rowSize; i++)
                        array[i] = '!';
                x = 0;
                int j=1;

                follow[index][0] = nonTerminal[index];

                find_follow(nonTerminal[index]);

                for(int count = 0; count < x; count++)
                        follow[index][j++] = array[count];


        }

        createTable();
        printf("\nLL(1) Parsing Table :\n\n");
        printLLOneTable();
        char c;
        do{
                parseString();
                printf("\nPress Y to continue : ");
                fflush(stdin);
                scanf("%c",&c);

        }while(c == 'y' || c == 'Y');

        return 0;
}

// Start First Function
void Find_First(char* firstArray, char ch){

        int count, j, k, x;
        char temporary_result[20];
        temporary_result[0] = '\0';
        firstArray[0] = '\0';

        if(!(isupper(ch))) {
                Array_MainpulationByFirst(firstArray, ch);
                return;
        }
        for(count = 0; count < totalProduction; count++) {
                if(production[count][0] == ch) {
                        if(production[count][2] == epsilon)
                                Array_MainpulationByFirst(firstArray, epsilon);
                        else{
                                j = 2;
                                while(production[count][j] != '\0') {
                                        x = 0;
                                        Find_First(temporary_result, production[count][j]);
                                        for(k = 0; temporary_result[k] != '\0'; k++)
                                                Array_MainpulationByFirst(firstArray,temporary_result[k]);
                                        for(k = 0; temporary_result[k] != '\0'; k++)
                                                if(temporary_result[k] == epsilon) {
                                                        x = 1;
                                                        break;
                                                }
                                        if(!x)
                                                break;
                                        j++;
                                }
                        }
                }
        }
        return;
}

void Array_MainpulationByFirst(char firstArray[], char value){

        int temp;
        for(temp = 0; firstArray[temp] != '\0'; temp++)
                if(firstArray[temp] == value)
                        return;
        firstArray[temp] = value;
        firstArray[temp + 1] = '\0';
}
// End First Function

// Start follow Function
void find_follow(char ch) {

        int i, j;
        if(production[0][0] == ch)
                Array_MainpulationByFollow('$');

        for(i = 0; i < totalProduction; i++) {
                int length = strlen(production[i]);
                for(j = 2; j < length; j++) {
                        if(production[i][j] == ch) {
                                if(production[i][j + 1] != '\0')
                                        find_first(production[i][j + 1]);
                                if(production[i][j + 1] == '\0' && ch != production[i][0])
                                        find_follow(production[i][0]);
                        }
                }
        }
}

void find_first(char ch) {

        int i, k;
        if(!(isupper(ch)))
                Array_MainpulationByFollow(ch);

        for(k = 0; k < totalProduction; k++) {
                if(production[k][0] == ch) {
                        if(production[k][2] == epsilon) {
                                find_follow(production[k][0]);
                        }
                        else if(islower(production[k][2])) {
                                Array_MainpulationByFollow(production[k][2]);
                        }
                        else{
                                find_first(production[k][2]);
                        }
                }
        }
}

void Array_MainpulationByFollow(char ch){

        int count;
        for(count = 0; count <= x; count++) {
                if(array[count] == ch)
                        return;
        }
        array[x++] = ch;
}
// End Follow Function

// Utility function start
void createTable(){

        for(int i=1; i<(totalTerminal+1); i++)
                table[0][i] = terminal[i-1];

        for(int i=1; i<(totalNonTerminal+1); i++)
                table[i][0] = nonTerminal[i-1];

        for(int i=0; i<totalProduction; i++) {

                int flag = 0;
                char startSymbol = production[i][0];
                char firstSymbol = production[i][2];

                int symbolNumber = findIndexByNonTerminal(startSymbol);
                int firstNumber = findIndexByNonTerminal(firstSymbol);
                int len  = strlen(production[i]);

                for(int count = 2; count<len; count++) {
                        if(isupper(production[i][count])) {
                                flag = 0;
                                for(int j=1; first[firstNumber][j] != '!'; j++) {
                                        if(first[firstNumber][j] != epsilon) {
                                                int terminalNumber = findIndexByTerminal(first[firstNumber][j]);
                                                table[symbolNumber+1][terminalNumber+1] = i + '0';
                                        }
                                        else
                                                flag = 1;

                                }
                                if(flag == 1) {
                                        if((count+1)==len) {
                                                for(int j=1; follow[symbolNumber][j] != '!'; j++) {
                                                        int terminalNumber = findIndexByTerminal(follow[symbolNumber][j]);
                                                        table[symbolNumber+1][terminalNumber+1] = i + '0';
                                                }
                                        }
                                        else
                                                continue;

                                }
                                else
                                        break;
                        }
                        else if(isTerminal(production[i][count])) {
                                int terminalNumber = findIndexByTerminal(production[i][count]);
                                table[symbolNumber+1][terminalNumber+1] = i + '0';
                                break;
                        }
                        else if(production[i][count] == epsilon) {
                                for(int j=1; follow[symbolNumber][j] != '!'; j++) {
                                        int terminalNumber = findIndexByTerminal(follow[symbolNumber][j]);
                                        table[symbolNumber+1][terminalNumber+1] = i + '0';
                                }
                                break;
                        }
                        else{
                                printf("Error in Production %s\n",production[i]);
                                exit(0);
                        }
                }
        }
}

void parseString(){

        string input;

        printf("\nEnter input string : ");
        cin>>input;

        input.push_back('$');
        stack<char> Stack;
        Stack.push('$');
        Stack.push(production[0][0]);

        printf("\t\tStack\t\t\tInput\t\t\tAction\n");
        displayStack(Stack);
        cout<<"\t\t\t"<<input<<endl;

        bool accepted = true;

        while(!Stack.empty() && !input.empty()) {

                if(input[0] == Stack.top()) {
                        Stack.pop();
                        input.erase(0, 1);
                        displayStack(Stack);
                        cout<<"\t\t\t"<<input<<"\t\t\tPOP"<<endl;
                }
                else if(!isupper(Stack.top())) {
                        printf("\t\t\tUnmatched terminal found\n");
                        accepted = false;
                        break;
                }
                else {
                        char stack_top = Stack.top();
                        int row = findIndexByNonTerminal(stack_top);
                        int col = findIndexByTerminal(input[0]);
                        int productionIndex = (table[row+1][col+1] - '0');
                        if(productionIndex < 0 || productionIndex > totalProduction) {
                                printf("\t\t\tNo production found in parse table\n");
                                accepted = false;
                                break;
                        }

                        Stack.pop();
                        string RHS = production[productionIndex];
                        RHS.erase(0,2);
                        if(RHS[0] == epsilon) {
                                displayStack(Stack);
                                cout<<"\t\t\t"<<input<<"\t\t\t"<<production[productionIndex]<<endl;
                                continue;
                        }

                        for(auto ch = RHS.rbegin(); ch != RHS.rend(); ++ch)
                                Stack.push(*ch);

                        displayStack(Stack);
                        cout<<"\t\t\t"<<input<<"\t\t\t"<<production[productionIndex]<<endl;
                }
        }

        if(accepted)
                printf("Input string is accepted\n");
        else
                printf("Input string is rejected\n");
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

int isTerminal(char c){

        for(int i=0; i<totalTerminal; i++)
                if(c == terminal[i])
                        return 1;
        return 0;

}

void setArray(){
        for(int i=0; i<rowSize; i++)
                for(int j=0; j<colSize; j++) {
                        first[i][j] = '!';
                        follow[i][j] = '!';
                        production[i][j] = '!';
                        table[i][j] = '!';
                }
        table[0][0] = ' ';
}

void showArray(char data[rowSize][colSize]) {

        int row = 0,col = 0;
        for(; data[row][col] != '!'; row++) {
                for( ; data[row][col]!= '!'; col++) {
                        printf("%c ",data[row][col]);
                }
                col = 0;
                printf("\n");
        }
}

void printLLOneTable(){

        for(int i=0; i<(totalNonTerminal+1); i++) {
                for(int j=0; j<(totalTerminal+1); j++) {
                        if(i==0)
                                printf("%c\t",table[i][j]);
                        else if(j==0)
                                printf("%c\t",table[i][j]);
                        else if(table[i][j] == '!')
                                printf("\t");
                        else
                                printf("%d\t",table[i][j]-'0');
                }
                printf("\n");
        }
}
// Utility function end



void displayStack(stack<char> data){

        stack<char> temp;
        printf("\t\t");

        while(!data.empty()) {
                printf("%c",data.top());
                temp.push(data.top());
                data.pop();
        }
        while(!temp.empty()) {
                data.push(temp.top());
                temp.pop();
        }
}
