//
// Created by deniz on 1.12.2022.
//


#include "fstream"
#include <iostream>

using namespace std;
class Queue{
public:
    double arrival_time;
    double order_time;
    double making_time;
    double price;
    Queue * next_costumer;

public:
    Queue(){
        this->next_costumer = nullptr;
    }
    Queue(double arrival_time,double order_time,double making_time,double price){
        this->arrival_time = arrival_time;
        this->order_time = order_time;
        this->making_time = making_time;
        this->price = price;
        this->next_costumer = nullptr;

    }
};

class Node {
public:
    int id;
    int casier_number;

    //costumer
    double arrival_time;
    double order_time;
    double making_time;
    double price;
    double when_order_completed;
    double when_coffee_completed;
    int first;

    double work_time;
    double work_time2;
    double busy_time;

    double when_order_delivered;
    double coffee_making;
    double when_next_coffee_finish;
    //casier and barista
    int is_empty;
    int is_barista;

    int casier_waiters_max_lenght;
    int barista_waiters_max_lenght;
    int barista_waiters_max_lenght2;


    //casier
    Node * next_casier;
    Node * point_barista_head;
    //barista
    Node * next_barista;
    Node * next_costumer;
    Node * next_waiting_costumer;

    Node(){
        this->next_costumer = nullptr;
        this->next_casier = nullptr;
        this->point_barista_head = nullptr;
        this->next_barista = nullptr;
    }
    // Coffee Constructor
    Node(int id,double arrival_time,double order_time,double making_time,double price,double when_order_completed,double when_coffee_completed)
    {
        this->id = id;
        this->arrival_time = arrival_time;
        this->order_time = order_time;
        this->making_time = making_time;
        this->when_order_completed = when_order_completed;
        this->when_coffee_completed = when_coffee_completed;
        this->price = price;
        this->next_costumer = nullptr;
        this->next_waiting_costumer = nullptr;
        this->casier_number = -1;
        this->first = 0;
    }

    // Parameterised Constructor
    Node(int id,int is_empty)
    {
        this->id = id;
        this->is_empty = 1;
        this->next_casier = nullptr;
        this->point_barista_head = nullptr;
        this->work_time = 0;
        this->casier_waiters_max_lenght = 0;
        this->busy_time = 0;
    }
    Node(int id,int is_empty,int is_barista)
    {
        this->id = id;
        this->is_empty = 1;
        this->is_barista = 1;
        this->next_barista = nullptr;
        this->work_time = 0;
        this->when_order_delivered = 0;
        this->coffee_making = 0;
        this->when_next_coffee_finish = 0;
        this->barista_waiters_max_lenght = 0;
        this->barista_waiters_max_lenght2 = 0;
        this->work_time2 = 0;
    }

};

class Coffee {
    Node* costumer_head;
    Node* costumer_head2;
    Node* temporary_list;
    Node* casier_head;
    Node* barista_head;
    Node* costumer_waiting_head;
    Node* costumer_waiting_head2;
public:
    Coffee(){
        this->costumer_head = new Node();
        this->barista_head = new Node();
        this->casier_head = new Node();
        this->costumer_waiting_head = new Node();
        this->costumer_waiting_head2 = new Node();
        this->costumer_head2 = new Node();
        this->temporary_list = new Node();
    }
    void read_input(string inputtxt,string outputtxt);
    void implement_orders(int casier_numberr,int costumer_number);
    void implement_coffees(int barista_numberr,int costumer_number);
    void implement_coffees2(int barista_numberr,int costumer_number);
    void output_writer(string file_name);
    double float_converter(double number);
    //void select_next_costumer_for_coffee();
};

