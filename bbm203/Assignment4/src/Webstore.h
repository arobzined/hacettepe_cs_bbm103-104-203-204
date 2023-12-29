
#include "iostream"

using namespace std;


class Node {
public:

    //for both primary and secondary tree
    string key_name;
    Node * left_node;
    Node * right_node;
    Node * second_tree_head;
    Node * output_next;

    //secondary tree attr.
    string thing_name;
    int price;
    int height;
    int level;
    Node * left_child_node;
    Node * right_child_node;

public:
    Node(){
        this->left_node = nullptr;
        this->right_node = nullptr;
        this->second_tree_head = nullptr;
        this->output_next = nullptr;
    }

    Node(string keyname){
        this->key_name = keyname;
        this->left_node = nullptr;
        this->right_node = nullptr;
        this->second_tree_head = new Node();
        this->level = 1;
    }

    Node(string keyname,string name,int price){
        this->key_name = keyname;
        this->thing_name = name;
        this->price = price;
        this->height = 1;
        this->level = 1;
        this->left_child_node = nullptr;
        this->right_child_node = nullptr;
    }
};


class Webstore{
public:
    Node * primary_head;
    Node * output_head;
    Webstore(){
        this->primary_head = new Node();
        this->output_head = new Node();
    }
    void read_input(string inputtxt,string outputtxt);
    void insert_avl(Node* tempnode,string input_arr[]);
    void insert_avl_sec(Node* tempnode,string input_arr[],Node * headd);
    void insert_rbt(string input_arr[]);
    void remove_avl(string input_arr[],Node * head,Node * tree_head,Node * parent_head);
    void remove_rbt(string input_arr[]);
    void print_the_item(string input_arr[],Node * head);
    void print_items(int x,Node * head);
    void print_items_in(int y,Node * sec_head,Node * before_head);
    void print_the_categorie(string input_arr[],Node * head);
    void update_data(string input_arr[],Node * head);
    void find(string input_arr[]);
    Node * left_rotate(Node*pointnode,Node * head);
    Node * right_rotate(Node*pointnode, Node * head);
    Node * right_smallest(Node * somehead);
    void traverse_tree(Node * head,int y);






};


