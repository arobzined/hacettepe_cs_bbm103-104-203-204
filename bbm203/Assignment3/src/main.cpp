#include <iostream>
#include "Coffee.h"

using namespace std;


int main(int argc,char* argv[]) {
    Coffee costumer1;
    string inputtxt = argv[1];
    string outputtxt = argv[2];
    costumer1.read_input(inputtxt,outputtxt);
}
