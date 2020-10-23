#if defined(_WIN32)
    #define PLATFORM_NAME "windows" // Windows
#elif defined(__linux__)
    #define PLATFORM_NAME "linux" // Debian, Ubuntu, Gentoo, Fedora, openSUSE, RedHat, Centos and other
#elif defined(__unix__)
    #define PLATEFORM_NAME "linux"  //unix/macos
#endif

#include <stdio.h>
#include <stdlib.h>

int main(){
    if(PLATFORM_NAME=="windows"){
        system("netsh wlan show interfaces");
    }
    else if ( PLATFORM_NAME == "linux")
        {
            system("iwconfig ");
        }
        
    
    
}

