

#include "Webstore.h"
#include <fstream>
#include "sstream"

//giving level attributes to nodes

void printfu2(Node * temppoint,int levely){
    if(temppoint == nullptr){
        return;
    }
    temppoint->level = levely;
    //cout<<temppoint->thing_name<<" "<<temppoint->price<<" "<<temppoint->level<<endl;
    printfu2(temppoint->right_child_node,levely + 1);
    printfu2(temppoint->left_child_node,levely + 1);
}

//usd for printfu2

void printfu(Node * temppoint,int levelx){
    if(temppoint == nullptr){
        return;
    }
    temppoint->level = levelx;
    printfu2(temppoint->second_tree_head,1);
    printfu(temppoint->right_node,levelx + 1);
    printfu(temppoint->left_node,levelx + 1);
}

//i used this func for determining the balance of the tree

int maxA(int a,int b){
    if(a > b)
        return a;
    return b;
}

//determining the balance of tree with height attributes , height of subtrees of a node

int height(Node * a){
    if(a == nullptr)
        return 0;
    return a->height;
}

//used for making the balance if we delete node with two children nodes

Node * Webstore::right_smallest(Node * some_node){
    if(some_node->left_child_node == nullptr){
        return some_node;
    }
    this->right_smallest(some_node->left_child_node);

}

//comparing the heights , this says us that tree has to be modified or not.

int getBalance(Node * tempnode){
    return height(tempnode->left_child_node) - height(tempnode->right_child_node);
}

//choose the primitive head of the removing tree

Node * choose_prim(string input[],Node * head) {
    if(input[1] < head->key_name){
        choose_prim(input,head->left_node);
    }
    else if(input[1] > head->key_name){
        choose_prim(input,head->right_node);
    }
    else{
        return head;
    }
}

//i stored my data to this string , then i directly write it to output txt file.
string outputt = "";
//storing some node
Node * head_t;

//reading the inputs , and determining the functions.
void Webstore::read_input(string inputtxt,string outputtxt) {
    ifstream *txt = new ifstream(inputtxt);
    string input_str = "";
    if(!txt->is_open()){
        cout << "No such file...";
    }
    else{
        while(getline(*txt,input_str)) {
            if (!input_str.empty() && input_str[input_str.size() - 1] == '\r')
                input_str.erase(input_str.size()-1);
            stringstream temps(input_str);
            string tempinp = "";
            auto x = "\t";
            string inputarray[4];
            int i = 0;
            while(getline(temps,tempinp, *x)){
                inputarray[i] = tempinp;
                i++;
            }
            head_t = this->primary_head;

            /*for(string item: inputarray){
                cout << item << endl;
            }
            cout<<"**********"<<endl;*/
            Node * temphead = this->primary_head;
            Node * headd = this->primary_head;
            if(inputarray[0] == "insert"){
                this->insert_avl(temphead,inputarray);
                //this->insert_rbt();
            }
            if(inputarray[0] == "remove"){
                Node * head = choose_prim(inputarray,headd);
                this->remove_avl(inputarray,head->second_tree_head,head,head->second_tree_head);
                //this->remove_avl(inputarray);
                //this->remove_rbt();
            }
            if(inputarray[0] == "printAllItems"){
                Node * temphead_all = this->primary_head;
                printfu(temphead_all,1);
                outputt += "command:printAllItems\n{\n";
                this->print_items(1,head_t);
                outputt += "}\n";

            }
            if(inputarray[0] == "printAllItemsInCategory"){
                Node * temphead_all = this->primary_head;
                outputt += "command:printAllItemsInCategory\n{\n";
                this->print_the_categorie(inputarray,temphead_all);
                outputt += "}\n";

            }
            if(inputarray[0] == "printItem"){
                Node * temphead_all = this->primary_head;
                outputt += "command:printItem " + inputarray[1] + " " + inputarray[2] + "\n{";
                this->print_the_item(inputarray,temphead_all);
                outputt += "}\n";

            }
            if(inputarray[0] == "find"){
                Node * temphead_all = this->primary_head;
                outputt += "command:find " + inputarray[1] + " " + inputarray[2] + "\n{";
                this->print_the_item(inputarray,temphead_all);
                outputt += "}\n";
            }
            if(inputarray[0] == "updateData"){
                Node * temphead_all = this->primary_head;
                this->update_data(inputarray,temphead_all);

            }
            
        }
        ofstream out(outputtxt);
        out << outputt;
        out.close();

    }
}


//rotating to the right side , to make it balanced tree

Node * Webstore::right_rotate(Node * point_node,Node * head) {
    Node * temp_point = point_node;

    Node * left_one = temp_point->left_child_node;
    Node * lefts_right = left_one->right_child_node;

    left_one->right_child_node = temp_point;
    temp_point->left_child_node = lefts_right;

    temp_point->height = maxA(height(temp_point->left_child_node), height(temp_point->right_child_node)) + 1;
    left_one->height = maxA(height(temp_point->left_child_node), height(temp_point->right_child_node)) + 1;

    if(head->second_tree_head->thing_name == left_one->right_child_node->thing_name){
        head->second_tree_head = left_one;
    }

    return left_one;
}

//same as right rotate , but different direction :D

Node* Webstore::left_rotate(Node * point_node,Node * head) {
    Node * temp_point = point_node;

    Node * right_one = temp_point->right_child_node;
    Node * rights_left = temp_point->right_child_node->left_child_node;

    right_one->left_child_node = temp_point;
    temp_point->right_child_node = rights_left;

    temp_point->height = maxA(height(temp_point->left_child_node), height(temp_point->right_child_node)) + 1;
    right_one->height = maxA(height(right_one->left_child_node), height(right_one->right_child_node)) + 1;

    if(head->second_tree_head->thing_name == right_one->left_child_node->thing_name){
        head->second_tree_head = right_one;
    }

    return right_one;
}

//creating the primitive tree , the main keys are located here.

void Webstore::insert_avl(Node * tempnode,string inputarr[]) {
    if(tempnode->key_name.empty()){
        *tempnode = Node(inputarr[1]);
        Node * tempheadsec = tempnode->second_tree_head;
        this->insert_avl_sec(tempheadsec,inputarr,tempnode);
        return;
    }
    else{
        if(tempnode->key_name > inputarr[1]){
            if(tempnode->left_node == nullptr){
                tempnode->left_node = new Node(inputarr[1]);
                Node * tempheadx = tempnode->left_node;
                Node * tempheadsec = tempnode->left_node->second_tree_head;
                this->insert_avl_sec(tempheadsec,inputarr,tempheadx);
                return;
            }
            this->insert_avl(tempnode->left_node,inputarr);
        }
        else if(tempnode->key_name < inputarr[1]){
            if(tempnode->right_node == nullptr){
                tempnode->right_node = new Node(inputarr[1]);
                Node * tempheadx = tempnode->right_node;
                Node * tempheadsec = tempnode->right_node->second_tree_head;
                this->insert_avl_sec(tempheadsec,inputarr,tempnode->right_node);
                return;
            }
            this->insert_avl(tempnode->right_node,inputarr);
        }
        else{
            Node * tempheadsec = tempnode->second_tree_head;
            this->insert_avl_sec(tempheadsec,inputarr,tempnode);
        }
    }
}

//creating secondary trees , all the modifications are happened also in here

void Webstore::insert_avl_sec(Node *tempnode, string input_arr[],Node * temphead) {

    //if first node

    if(tempnode->thing_name.empty()){
        *tempnode = Node(input_arr[1],input_arr[2],stoi(input_arr[3]));
        return;
    }

    else{

        //determine where the new nodes come in
        if(tempnode->thing_name > input_arr[2]){
            if(tempnode->left_child_node == nullptr){
                tempnode->left_child_node = new Node(input_arr[1],input_arr[2],stoi(input_arr[3]));
            }
            this->insert_avl_sec(tempnode->left_child_node,input_arr,temphead);
        }
        else if(tempnode->thing_name < input_arr[2]){
            if(tempnode->right_child_node == nullptr){
                tempnode->right_child_node = new Node(input_arr[1],input_arr[2],stoi(input_arr[3]));
            }
            this->insert_avl_sec(tempnode->right_child_node,input_arr,temphead);
        }

        //balance part , first get height params and compare them to make the turns happened.

        tempnode->height = 1 + maxA(height(tempnode->left_child_node), height(tempnode->right_child_node));
        int balance_factor = getBalance(tempnode);

        //left-left

        if (balance_factor > 1 && input_arr[2] < tempnode->left_child_node->thing_name){
            right_rotate(tempnode,temphead);
            return;
        }

        //right-right
        if (balance_factor < -1 && input_arr[2] > tempnode->right_child_node->thing_name){
            left_rotate(tempnode,temphead);
            return;}

        // left-right
        if (balance_factor > 1 && input_arr[2] > tempnode->left_child_node->thing_name)
        {
            tempnode->left_child_node =  left_rotate(tempnode->left_child_node,temphead);
            right_rotate(tempnode,temphead);
            return;
        }

        // right-left
        if (balance_factor < -1 && input_arr[2] < tempnode->right_child_node->thing_name)
        {
            tempnode->right_child_node = right_rotate(tempnode->right_child_node,temphead);
            left_rotate(tempnode,temphead);
            return;
        }
    }
}

//removing part , also balancing is required here

void Webstore::remove_avl(string input_arr[],Node * tempnode,Node * head,Node * parent_head) {
    if (tempnode == nullptr){
        return;
    }

    else if(input_arr[2] < tempnode->thing_name){
        this->remove_avl(input_arr,tempnode->left_child_node,head,tempnode);
    }

    else if(input_arr[2] > tempnode->thing_name){
        this->remove_avl(input_arr,tempnode->right_child_node,head,tempnode);
    }

    else{

        Node * temp = tempnode;
        if(tempnode->left_child_node == nullptr && tempnode->right_child_node == nullptr){
            if(parent_head->left_child_node && parent_head->left_child_node->thing_name == tempnode->thing_name){
                parent_head->left_child_node = nullptr;
            }
            else if(parent_head->right_child_node && parent_head->right_child_node->thing_name == tempnode->thing_name){
                parent_head->right_child_node = nullptr;
            }
            else if(parent_head->thing_name == tempnode->thing_name){
                head->second_tree_head = nullptr;
            }
            temp = tempnode;
            tempnode = nullptr;
            delete temp;

        }
        else if(tempnode->left_child_node == nullptr){
            if(parent_head->left_child_node && parent_head->left_child_node->thing_name == tempnode->thing_name){
                parent_head->left_child_node = tempnode->right_child_node;
            }
            else if(parent_head->right_child_node && parent_head->right_child_node->thing_name == tempnode->thing_name){
                parent_head->right_child_node = tempnode->right_child_node;
            }
            *tempnode = *(temp->right_child_node);
            delete temp;
        }
        else if(tempnode->right_child_node == nullptr){
            if(parent_head->left_child_node && parent_head->left_child_node->thing_name == tempnode->thing_name){
                parent_head->left_child_node = tempnode->left_child_node;
            }
            else if(parent_head->right_child_node && parent_head->right_child_node->thing_name == tempnode->thing_name){
                parent_head->right_child_node = tempnode->left_child_node;
            }
            *tempnode = *(temp->left_child_node);
            delete temp;
        }
        else{
            temp = this->right_smallest(tempnode->right_child_node);

            tempnode->thing_name = temp->thing_name;
            tempnode->key_name = temp->key_name;
            tempnode->price = temp->price;

            input_arr[2] = tempnode->thing_name;

            this->remove_avl(input_arr,temp,head,tempnode);
        }
    }

    if(tempnode == nullptr){
        return;
    }

    tempnode->height = maxA(height(tempnode->left_child_node), height(tempnode->right_child_node)) + 1;
    int balance_factor = getBalance(tempnode);

    if (balance_factor > 1 && getBalance(tempnode->left_child_node) >= 0){
        right_rotate(tempnode,head);
        return;
    }

    if (balance_factor < -1 && getBalance(tempnode->right_child_node) <= 0){
        left_rotate(tempnode,head);
        return;}

    // Left Right Case
    if (balance_factor > 1 && getBalance(tempnode->left_child_node) < 0)
    {
        tempnode->left_child_node =  left_rotate(tempnode->left_child_node,head);
        right_rotate(tempnode,head);
        return;
    }

    // Right Left Case
    if (balance_factor < -1 && getBalance(tempnode->right_child_node) > 0)
    {
        tempnode->right_child_node = right_rotate(tempnode->right_child_node,head);
        left_rotate(tempnode,head);
        return;
    }

}

//print part

void Webstore::print_items_in(int y,Node * sec_head,Node * before_head) {
    if(sec_head == nullptr){
        return;
    }
    if(sec_head->level == y){
        outputt.append("\t");
        outputt += '"' + sec_head->thing_name + '"' + ":" + '"' + to_string(sec_head->price) + '"';
        outputt.append("\n");
    }
    if(sec_head->left_child_node){
        outputt += "left node - " + sec_head->thing_name + ": ";
    }
    this->print_items_in(y+1,sec_head->left_child_node,sec_head);
    if(sec_head->right_child_node){
        outputt += "right node - " + sec_head->thing_name + ": ";
    }
    this->print_items_in(y+1,sec_head->right_child_node,sec_head);


}


void Webstore::print_items(int x,Node * head) {
    if(head == nullptr){
        return;
    }
    if(head->level == x){
        outputt += '"' + head->key_name + '"' + ":";
        if(head->second_tree_head == nullptr){
            outputt.append("{}");
            outputt.append("\n");
        }
        else{
            outputt.append("\n");
            this->print_items_in(1,head->second_tree_head,head->second_tree_head);
            outputt += "\n";
        }
    }
    this->print_items(x+1,head->left_node);
    this->print_items(x+1,head->right_node);
}

void Webstore::print_the_categorie(string input_arr[],Node * head) {
    if(head == nullptr){
        return;
    }
    if(head->key_name == input_arr[1]){
        outputt += '"' + head->key_name + '"' + ":";
        if(head->second_tree_head == nullptr){
            outputt.append("{}");
            outputt.append("\n");
        }
        else{
            outputt.append("\n");
            this->print_items_in(1,head->second_tree_head,head->second_tree_head);
            outputt += "\n";
        }
    }
    this->print_the_categorie(input_arr,head->left_node);
    this->print_the_categorie(input_arr,head->right_node);

}

void find_item(Node * head,string name){
    if(head == nullptr){
        return;
    }
    if(head->thing_name == name){
        outputt.append("\t");
        outputt += '"' + head->thing_name + '"' + ":" + '"' + to_string(head->price) + '"';
        outputt.append("\n");
    }
    find_item(head->left_child_node,name);
    find_item(head->right_child_node,name);
}

void Webstore::print_the_item(string input_arr[],Node * head) {
    if(head == nullptr){
        return;
    }
    if(head->key_name == input_arr[1]){
        if(head->second_tree_head == nullptr){
            outputt.append("{}");
            outputt.append("\n");
            return;
        }
        else{
            outputt.append("\n");
            outputt += '"' + head->key_name + '"' + ":";
            outputt.append("\n");
            find_item(head->second_tree_head,input_arr[2]);
        }
    }
    this->print_the_categorie(input_arr,head->left_node);
    this->print_the_categorie(input_arr,head->right_node);
}

void find_and_chance(string input_arr[],Node * head){
    if(head == nullptr){
        return;
    }
    if(head->thing_name == input_arr[2]){
        head->price = stoi(input_arr[3]);
        return;
    }
    find_and_chance(input_arr,head->left_child_node);
    find_and_chance(input_arr,head->right_child_node);

}

void Webstore::update_data(string input_arr[], Node *head) {
    if(head == nullptr){
        return;
    }
    if(head->key_name == input_arr[1]){
        if(head->second_tree_head == nullptr){
            return;
        }
        else{
            find_and_chance(input_arr,head->second_tree_head);
        }
    }
    this->update_data(input_arr,head->left_node);
    this->update_data(input_arr,head->right_node);

}
