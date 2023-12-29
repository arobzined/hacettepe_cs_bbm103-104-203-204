//
// Created by deniz on 19.11.2022.
//

#include "iostream"

using namespace std;

class Node {
public:
    int data;
    int is_empty;
    string name;
    Node* next_apt;
    Node* next_flat;
    Node* prev_flat;
    Node* last_to_first;


    // Default constructor
    Node()
    {
        data = 0;
        next_apt = nullptr;
        next_flat = nullptr;
        prev_flat = nullptr;
    }

    // Parameterised Constructor
    Node(int data,string name)
    {
        this->data = data;
        this->name = name;
        this->next_apt = nullptr;
        this->next_flat = nullptr;
        this->prev_flat = nullptr;
        this->last_to_first = nullptr;
    }
    Node(int data,string name,int is_empty)
    {
        this->data = data;
        this->name = name;
        this->is_empty = is_empty;
        this->next_apt = nullptr;
        this->next_flat = nullptr;
        this->prev_flat = nullptr;
    }
};
/*
class DNode {
public:
    int data;
    Node* next_flat;
    Node* prev_flat;

    // Default constructor
    DNode()
    {
        data = 0;
        next_flat = NULL;
        prev_flat = NULL;
    }

    // Parameterised Constructor
    DNode(int data)
    {
        this->data = data;
        this->next_flat = NULL;
        this->prev_flat = NULL;
    }
};

class Apartment{
    DNode* head;
public:
    Apartment() { this->head = new DNode(); }
};
*/
// Linked list class to
// implement a linked list.
class Street{
    Node* head;
    string x;

public:
    // Default constructor
    Street() { this->head = new Node();
                this->x = x;}
    void readInput(string txt_name,string output_name);
    void add_apartment(string inputlst[]);
    void add_flat(string inputlst[]);
    void remove_apartment(string inputlst[]);
    void make_flat_empty(string inputlst[]);
    string find_sum_of_max_bandwidths();
    void merge_two_apartments(string inputlst[]);
    void relocate_flats_to(string inputlst[]);
    string list_apartments();

};



