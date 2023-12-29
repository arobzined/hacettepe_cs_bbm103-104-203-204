//
// Created by deniz on 25.10.2022.
//

using namespace std;

class Game {
private:
    int *mtrxprt;
    int *keyptr;
    int keySize;
    int rowSize;
    int columnSize;
public:
    void inInput(string mapinput,string keyinput,int startRow,int startCol);
    void searchfunc(int* mtrxptr,int* keyptr,int startRow, int startCol);
    void setKeySize(int number);
    int getKeySize();
    void setRowSize(int number);
    int getRowSize();
    void setColumnSize(int number);
    int getColumnSize();
    int* getMatrixPtr();
    int* getKeyPtr();
    void setMatrixPtr(int* ptr);
    void setKeyPtr(int* ptr);
};

