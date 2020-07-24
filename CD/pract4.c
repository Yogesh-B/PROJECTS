/*practical 4
determine whether operator is valid or not
*/
#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <regex.h>

//void operator_check(char[]);
int main(){
	
	regex_t regex1;
	int out1;
	out1=regcomp(&regex1,"[:lower:]",0);

	if ( out1==1 ){
		printf("success\n");
	}
	else{
		printf("failure\n");
	}
	
	
	getch();
	return 0;
}