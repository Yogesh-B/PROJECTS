#include <stdio.h>
#include <regex.h>

int main(){
	regex_t regex;
	int return_value;
	return_value = regcomp(&regex,"[:lower:]",0);
        if (return_value == 0){
        	printf("Regular expression compiled successfully.");
	}
	else{
		printf("Compilation error.");
	}
	return 0;
}
