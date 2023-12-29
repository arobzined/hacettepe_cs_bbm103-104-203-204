#include <iostream>

#include "Street.h"


int main(int argc,char* argv[]) {
    Street street1;
    string inputtxt = argv[1];
    string outputtxt = argv[2];
    street1.readInput(argv[1],argv[2]);
}
