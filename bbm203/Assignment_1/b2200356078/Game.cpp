//
// Created by deniz on 25.10.2022.
//
#include<iostream>
#include "Game.h"
#include <fstream>
#include <cstring>
#include <sstream>

using namespace std;

void Game::setColumnSize(int number) {
    this->columnSize = number;
};
void Game::setRowSize(int number) {
    this->rowSize=number;
};
void Game::setKeySize(int number) {
    this->keySize = number;
};
int Game::getColumnSize() {
    return this->columnSize;
};
int Game::getRowSize(){
    return this->rowSize;
};
int Game::getKeySize() {
    return this->keySize;
};
int* Game::getMatrixPtr() {
    return this->mtrxprt;
};
int* Game::getKeyPtr() {
    return this->keyptr;
};

void Game::setMatrixPtr(int *ptr) {
    this->mtrxprt = ptr;
};
void Game::setKeyPtr(int *ptr) {
    this->keyptr = ptr;
};

//Just above us we can see the usable funcs and variables.

void Game::inInput(string mapinput,string keyinput,int startRow,int startCol) {
    //Creating ifstream for my txt files so i acn read them
    //while im reading it from txt , I also created pointers for txt files so
    //im using them.
    ifstream* maptxt = new ifstream(mapinput);
    ifstream* keytxt = new ifstream(keyinput);

    string mapstr="";//txts are attached to here.
    string keystr="";

    int maplenght = 0;
    int keysize = 0;
    int maphigh = 0;
    if (!maptxt->is_open()) {
        cout << "No such file.";
    } else {
        string myText1="";
        while (getline(*maptxt, myText1)) {//reading every single line using getLine.
            maplenght++;
            if(maplenght == 1){
                for (char x : myText1)
                {
                    if (x == ' ')
                    {
                        maphigh++;
                    }
                }
                maphigh++;
            };
            mapstr +=  myText1 + "\n";

        };
        this->setRowSize(maplenght);
        this->setColumnSize(maphigh);
        maptxt->close();//closing file and destroying the pointer.
        delete maptxt;

    };
    if (!keytxt->is_open()) {
        cout << "No such file.";
    } else {
        string myText;
        while (getline(*keytxt, myText)) {//reading
            keysize++;
            keystr += myText + "\n";//attaching
        };
        this->setKeySize(keysize);//deleting
        keytxt->close();
        delete keytxt;

    };


    int p[maplenght][maphigh];//creating array for matrix. This is just for beggining :D I will use
    //pointer for this array.
    stringstream inputstream1(mapstr);//getting map string that we got from txt.
    string temps = " ";
    const char *x = "\n";
    const char *y = " ";
    int a = 0;//row number o matrix
    while(getline(inputstream1,temps,*x)){//reading the string using getLine , again.
        stringstream rowinput(temps);
        string temps2 = "";
        int b = 0;//column number of matrix.
        while(getline(rowinput,temps2,*y)){
            stringstream geek(temps2);
            int n = 0;
            geek >> n;
            p[a][b] = n;//attaching the element to the array.
            b++;
        };
        a++;

    };
    int *mtrxprt;//the pointer of matrix.Im gonna use this pointer when i wanna
    //get information or mae change to my array.
    mtrxprt = *p;//pointer points the matrix.

    int p2[keysize][keysize];//same steps for keymatrix too ,
    //i couldnt write an func actually because when i
    //send this two arrays to the function , functions pointer
    //confused about which array did i send so i used that way to
    //dessign it.

    stringstream inputstream2(keystr);
    string temps1 = " ";
    const char *x1 = "\n";
    const char *y1 = " ";
    int a1 = 0;
    while(getline(inputstream2,temps1,*x1)){
        stringstream rowinput(temps1);
        string temps2 = "";
        int b = 0;
        while(getline(rowinput,temps2,*y1)){
            stringstream geek(temps2);
            int n = 0;
            geek >> n;
            p2[a1][b] = n;
            b++;
        };
        a1++;
    };
    int *keyptr;//pointer of keyMatrix.
    keyptr = *p2;

    this->searchfunc(mtrxprt,keyptr,0,0);//Game function we can say , all implementation actually
    //happens in here.


};

void Game::searchfunc(int* matrixptr,int* keyptr,int startRow, int startCol) {
    int size = this->getKeySize();//getting the key size.
    int sum = 0;//this is the sum we are gonna use in our math stuff.
    for (int i=0;i < this->getKeySize();i++){
        for (int j =0;j<this->getKeySize();j++){//loop for the key and matrix pointers
            //when i used my pointers , the arrays we pointed are actually acting like
            //1D array so i have to do some math here too.
            sum += (keyptr[(i*this->getKeySize()) + j]) *
                    (matrixptr[(startRow * (this->getColumnSize()))
                    + (startCol) + (i*(this->getColumnSize())) +
                     (j)]);

        };
    };
    /*cout<<" key value: "<<(keyptr)[(1*this->getKeySize()) + 1]<<" ";
    cout<<" matrix value: "<<(matrixptr)[(startRow * (this->getColumnSize()))
                                         + (startCol) + (startRow*(this->getColumnSize())) +
                                         (startCol)]<<" ";*/
    cout<<(startRow+(int(size/2)))<<","<<(startCol+(int(size/2)))<<":"<<sum<<endl;

    if(sum<0){//checking the sum for if we find treasure or not.
        while(sum >= 0) {
            sum += 5;
        }
    }else{
        switch ( sum % 5) {//this is actually the recursion part.implementing for the
            //calculated result.
            case 0:
                break;
            case 1:
                if(startRow - size < 0){
                    return this->searchfunc(matrixptr,keyptr,startRow+size,startCol);
                }
                else{
                    return this->searchfunc(matrixptr,keyptr,startRow-size,startCol);
                };
            case 2:
                if(startRow + size > this->getRowSize() - 1){
                    return this->searchfunc(matrixptr,keyptr,startRow-size,startCol);
                }
                else{
                    return this->searchfunc(matrixptr,keyptr,startRow+size,startCol);
                };
            case 3:
                if(startCol + size > this->getColumnSize() - 1){
                    return this->searchfunc(matrixptr,keyptr,startRow,startCol-size);
                }
                else{
                    return this->searchfunc(matrixptr,keyptr,startRow,startCol+size);
                };
            case 4:
                if(startCol - size < 0){
                    return this->searchfunc(matrixptr,keyptr,startRow,startCol+size);
                }
                else{
                    return this->searchfunc(matrixptr,keyptr,startRow,startCol-size);
                };

        }
    }
};

