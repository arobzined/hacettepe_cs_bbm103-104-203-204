//
// Created by deniz on 19.11.2022.
//

#include "Street.h"
#include <fstream>
#include <sstream>

using namespace std;

void Street::readInput(std::string txt_name,string output_name) {
    ifstream *txt = new ifstream(txt_name);
    string input_str = "";
    string output_str;
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
            string inputarray[5];
            int i = 0;
            while(getline(temps,tempinp, *x)){
                inputarray[i] = tempinp;
                i++;
            }

            if(inputarray[0] == "add_apartment"){
                this->add_apartment(inputarray);
            }
            if(inputarray[0] == "add_flat"){
                this->add_flat(inputarray);

            }
            if(inputarray[0] == "remove_apartment"){
                this->remove_apartment(inputarray);

            }
            if(inputarray[0] == "make_flat_empty"){
                this->make_flat_empty(inputarray);

            }
            if(inputarray[0] == "find_sum_of_max_bandwidths"){
                output_str += this->find_sum_of_max_bandwidths();

            }
            if(inputarray[0] == "merge_two_apartments"){
                this->merge_two_apartments(inputarray);

            }
            if(inputarray[0] == "relocate_flats_to_same_apartment"){
                this->relocate_flats_to(inputarray);

            }
            if(inputarray[0] == "list_apartments"){
                output_str += this->list_apartments();
            }
        }
    }
    ofstream MyFile(output_name);
    // Write to the file
    MyFile << output_str;
    // Close the file
    MyFile.close();

}

void Street::add_apartment(string inputlst[]) {
    //checking if its head
    if(inputlst[2] == "head"){
        int data = stoi(inputlst[3]);
        string name = inputlst[1];
        Node * tempapt = new Node(data,name);
        Node * temphead = this->head;
        if(temphead->next_apt == nullptr){
            tempapt->next_apt = nullptr;
            temphead->next_apt = tempapt;
        }
        else{
            Node * temp = temphead->next_apt;
            tempapt->next_apt = temp;
            temphead->next_apt = tempapt;
        }
    }
    //after and before cases.
    else{
        //node implementation
        int data = stoi(inputlst[3]);
        string name = inputlst[1];
        Node * tempapt = new Node(data,name);
        stringstream temps(inputlst[2]);
        string s = "";
        auto* x = "_";
        string list[2];
        int j = 0;
        while(getline(temps,s,*x)){
            list[j] = s;
            j++;
        }

        if(list[0] == "after"){
            Node * temphead = this->head;
            while(temphead->next_apt!= nullptr){
                if(temphead->name == list[1]){
                    tempapt->next_apt = temphead->next_apt;
                    temphead->next_apt = tempapt;
                    break;
                }
                temphead = temphead->next_apt;
            }
            if(temphead->next_apt == nullptr){
                if(temphead->name==list[1]){
                    tempapt->next_apt = nullptr;
                    tempapt->last_to_first = this->head;
                    temphead->next_apt = tempapt;
                }
            }
        }

        else if(list[0] == "before"){
            Node * temphead = this->head;
            while(temphead->next_apt!= nullptr){
                if(temphead->next_apt->name == list[1]){
                    tempapt->next_apt = temphead->next_apt;
                    temphead->next_apt = tempapt;
                    break;
                }
                temphead = temphead->next_apt;
            }
            if(temphead->next_apt == nullptr){
                if(temphead->next_apt->name == list[1]) {
                    tempapt->next_apt = temphead->next_apt;
                    temphead->next_apt = tempapt;
                }
            }

            while(temphead->next_apt!= nullptr){
                temphead = temphead->next_apt;
            }
        }
    }
    //circular part. last node points first node.
    Node * tempheadx = this->head;
    while(tempheadx->next_apt!= nullptr){
        tempheadx = tempheadx->next_apt;
    }
    tempheadx->last_to_first = this->head;

}

void Street::add_flat(string inputlst[]) {
    //implement flat info
    Node * temphead = this->head;
    Node * tempsearch = this->head;
    int initial_bandwidth = 0;
    int max_bandwidth = 0;
    //bandwidth case
    while(tempsearch!= nullptr){
        if(tempsearch->name == inputlst[1]){
            max_bandwidth = tempsearch->data;
            Node * tempx = tempsearch->next_flat;
            while(tempx!= nullptr){
                initial_bandwidth += tempx->data;
                tempx = tempx->next_flat;
            }
        }
        tempsearch = tempsearch->next_apt;
    }
    //searching apartment and add flat for special cases
    while(temphead!=nullptr){
        if(temphead->name==inputlst[1]){
            int index = stoi(inputlst[2]);
            int bandwidth = stoi(inputlst[3]);
            if(bandwidth >= max_bandwidth - initial_bandwidth){
                bandwidth = max_bandwidth - initial_bandwidth;
            }
            string flat_id = inputlst[4];
            Node * tempflat = new Node(bandwidth,flat_id,0);
            int flat_size_count = 0;
            //if it has no flat
            if(temphead->next_flat==nullptr){
                temphead->next_flat = tempflat;
                break;
            }
            //otherwise , double linkedlist using here
            else{
                Node * temparound = temphead;
                while(temparound->next_flat!= nullptr){
                    if(flat_size_count==index){
                        if(temparound->next_flat!=nullptr){
                            if(index==0){
                                temparound->next_flat->prev_flat = tempflat;
                                tempflat->next_flat = temparound->next_flat;
                                temparound->next_flat = tempflat;
                                break;
                            }
                            else{
                                temparound->next_flat->prev_flat = tempflat;
                                tempflat->next_flat = temparound->next_flat;
                                temparound->next_flat = tempflat;
                                tempflat->prev_flat = temparound;
                                break;
                            }
                        }
                    }
                    temparound = temparound->next_flat;
                    flat_size_count++;
                }
                if(temparound->next_flat== nullptr){
                    if(flat_size_count==index){
                        temparound->next_flat = tempflat;
                        tempflat -> prev_flat = temparound;
                        break;
                    }
                }
            }
        }
        temphead = temphead->next_apt;
    }
}

void Street::remove_apartment(string inputlst[]) {
    //nodes for searching
    Node * temphead = this->head;
    Node * tempsearch = this->head->next_apt;
    //if it is in the head
    if(temphead->name==inputlst[1]){
        Node * deleteApt = temphead;
        this->head = tempsearch;
        deleteApt->next_apt = nullptr;
        free(deleteApt);
    }
    while(tempsearch!= nullptr){
        if(tempsearch->name == inputlst[1]){
            Node * deleteApt = tempsearch;
            temphead->next_apt = deleteApt->next_apt;
            deleteApt->next_apt = nullptr;
            free(deleteApt);
        }
        temphead = tempsearch;
        tempsearch=tempsearch->next_apt;
    }

}
void Street::make_flat_empty(string inputlst[]) {
    //just making number changes.
    Node * temphead = this->head;
    while(temphead!= nullptr){
        if(temphead->name == inputlst[1]){
            Node * tempflat = temphead;
            while(tempflat!= nullptr){
                if(tempflat->name == inputlst[2]){
                    tempflat->data = 0;
                    tempflat->is_empty = 1;
                }
                tempflat = tempflat->next_flat;
            }
        }
        temphead = temphead->next_apt;
    }

}
string Street::find_sum_of_max_bandwidths() {
    //again , just numbers :D
    string x = "";
    Node * temphead = this->head;
    int sum = 0;
    while(temphead!= nullptr){
        sum += temphead->data;
        temphead = temphead->next_apt;
    }
    x += "sum of bandwidth: " + to_string(sum) + "\n\n";
    return x;
}
void Street::merge_two_apartments(string inputlst[]) {
    //a lot going on here
    string apartment_to = inputlst[1];
    string apartment_from = inputlst[2];
    //nodes that i used for searching , moving and deleting.
    Node * prev_temphead_from = this->head;
    Node * temphead_to = this->head;
    Node * temphead_from = this->head;
    //first find apartment to...
    while(temphead_to!= nullptr){
        if(temphead_to->name == apartment_to){
            break;
        }
        temphead_to = temphead_to->next_apt;
    }
    int bandwidth_to = temphead_to->data;
    Node * data_change = temphead_to;
    //find apartment that is going to be deleted
    while(temphead_from!= nullptr){
        if(temphead_from->name == apartment_from){
            break;
        }
        temphead_from = temphead_from->next_apt;
    }
    int bandwidth_from = temphead_from->data;
    //using for deleting that apartment
    while(prev_temphead_from->next_apt!= nullptr){
        if(prev_temphead_from->next_apt->name == apartment_from){
            break;
        }
        prev_temphead_from = prev_temphead_from->next_apt;
    }
    //checking the apartment is empty
    if(temphead_to->next_flat == nullptr){
        if(temphead_from->next_flat == nullptr){
            if(prev_temphead_from == nullptr){
                this->head = temphead_from->next_apt;
            }
            else{
                prev_temphead_from->next_apt = temphead_from->next_apt;
            }
            temphead_from->next_apt = nullptr;
            free(temphead_from);
        }
        else{
            temphead_to->next_flat = temphead_from->next_flat;
            temphead_from->next_flat = nullptr;
            if(prev_temphead_from == nullptr){
                this->head = temphead_from->next_apt;
            }
            else{
                prev_temphead_from->next_apt = temphead_from->next_apt;
            }
            temphead_from->next_apt = nullptr;
            free(temphead_from);
        }
    }
    else{
        while(temphead_to->next_flat != nullptr){
            temphead_to = temphead_to->next_flat;
        }

        if(temphead_from->next_flat == nullptr){
            if(prev_temphead_from == nullptr){
                this->head = temphead_from->next_apt;
            }
            else{
                if(temphead_from->next_apt == nullptr){
                    prev_temphead_from->next_apt = temphead_from->next_apt;
                }
                else{
                    prev_temphead_from->next_apt = temphead_from->next_apt;
                }
            }
            free(temphead_from);
        }

        else{
            temphead_to->next_flat = temphead_from->next_flat;
            temphead_from->next_flat->prev_flat = temphead_to;
            temphead_from->next_flat = nullptr;

            if(prev_temphead_from == nullptr){
                this->head = temphead_from->next_apt;
            }
            else{
                if(temphead_from->next_apt == nullptr){
                    prev_temphead_from->next_apt = nullptr;
                }
                else{
                    prev_temphead_from->next_apt = temphead_from->next_apt;
                }
            }
            temphead_from->next_apt = nullptr;
            free(temphead_from);
        }
    }
    data_change->data = bandwidth_from + bandwidth_to;


}
void Street::relocate_flats_to(string inputlst[]) {
    //implementing the input and nodes
    string apartment_to = inputlst[1];
    string flat_name = inputlst[2];
    stringstream counting(inputlst[3]);
    string temps = "";
    auto *x = ",";
    int count = 0;
    while(getline(counting,temps,*x)){
        count++;
    };
    string names[count];
    string inputs = inputlst[3].substr(1,(inputlst[3].length()-2));
    stringstream inputst(inputs);
    int j = 0;
    string temps2 = "";
    while(getline(inputst,temps2,*x)){
        names[j] = temps2;
        j++;
    }
    //finding the apartment that gets the flats
    Node * apartment_search = this->head;
    Node * position_of_apartment;
    Node * position_of_base_flat;
    Node * apartment_bandwidth;
    while(apartment_search!= nullptr){
        if(apartment_search->name == apartment_to){
            apartment_bandwidth = apartment_search;
            position_of_apartment = apartment_search;
            position_of_base_flat = apartment_search->next_flat;
            while(position_of_base_flat != nullptr) {
                if (position_of_base_flat->name == flat_name) {
                    break;
                }
                position_of_base_flat = position_of_base_flat->next_flat;
            }
            break;
        }
        apartment_search = apartment_search->next_apt;
    }
    //finding the flats and moving them to temporary node
    Node * temp_flat_point;
    Node * temp_flat_store = nullptr;//temp node is this.
    Node * flat_point_hold;
    Node * temp_apart_point = this->head;
    Node * minus_apartment;

    int k = 0;
    while(temp_apart_point!= nullptr){
        minus_apartment = temp_apart_point;
        temp_flat_point = temp_apart_point->next_flat;
        while(temp_flat_point!= nullptr){
            if(k >= j){
                break;
            }
            if(temp_flat_point->name==names[k]){
                minus_apartment->data = minus_apartment->data - temp_flat_point->data;
                apartment_bandwidth->data = apartment_bandwidth->data + temp_flat_point->data;
                if(temp_flat_point->prev_flat == nullptr){
                    temp_apart_point->next_flat = temp_flat_point->next_flat;
                    temp_flat_point->next_flat->prev_flat = nullptr;
                    temp_flat_point->next_flat = nullptr;
                    if(temp_flat_store== nullptr){
                        temp_flat_store = temp_flat_point;
                    }
                    else{
                        while(temp_flat_store!= nullptr){
                            if(temp_flat_store->next_flat== nullptr){
                                temp_flat_store->next_flat = temp_flat_point;
                                temp_flat_point->prev_flat = temp_flat_store;
                                break;
                            }
                            temp_flat_store = temp_flat_store->next_flat;
                        }
                        temp_flat_store->next_flat = temp_flat_point;
                        temp_flat_point->prev_flat = temp_flat_store;
                    }
                    temp_flat_point = temp_apart_point->next_flat;
                }
                else if(temp_flat_point->next_flat == nullptr){
                    Node * temp = temp_flat_point->prev_flat;
                    temp->next_flat = nullptr;
                    temp_flat_point->prev_flat = nullptr;
                    if(temp_flat_store==nullptr){
                        temp_flat_store = temp_flat_point;
                    }
                    else{
                        while(temp_flat_store!= nullptr){
                            if(temp_flat_store->next_flat== nullptr){
                                temp_flat_store->next_flat = temp_flat_point;
                                temp_flat_point->prev_flat = temp_flat_store;
                                break;
                            }
                            temp_flat_store = temp_flat_store->next_flat;
                        }
                        temp_flat_store->next_flat = temp_flat_point;
                        temp_flat_point->prev_flat = temp_flat_store;
                    }
                    temp_flat_point = temp;
                }
                else{
                    Node * temp = temp_flat_point->prev_flat;
                    temp->next_flat = temp_flat_point->next_flat;
                    temp_flat_point->next_flat->prev_flat = temp;
                    temp_flat_point->next_flat = nullptr;
                    temp_flat_point->prev_flat = nullptr;
                    if(temp_flat_store== nullptr){
                        temp_flat_store = temp_flat_point;
                    }
                    else{
                        while(temp_flat_store!= nullptr){
                            if(temp_flat_store->next_flat== nullptr){
                                temp_flat_store->next_flat = temp_flat_point;
                                temp_flat_point->prev_flat = temp_flat_store;
                                break;
                            }
                            temp_flat_store = temp_flat_store->next_flat;
                        }
                        temp_flat_store->next_flat = temp_flat_point;
                        temp_flat_point->prev_flat = temp_flat_store;
                    }
                    temp_flat_point = temp;

                }
                k++;
            }
            temp_flat_point = temp_flat_point->next_flat;
        }
        temp_apart_point = temp_apart_point->next_apt;
    }

    while(temp_flat_store->next_flat!= nullptr){
        temp_flat_store = temp_flat_store->next_flat;
    }

    Node * temp_flat_store_last = temp_flat_store; //points the last node of the temp node

    while(temp_flat_store->prev_flat!= nullptr){
        temp_flat_store = temp_flat_store->prev_flat;
    }

    //connecting to the apartment part
    if(position_of_base_flat->prev_flat == nullptr){

        position_of_base_flat->prev_flat = temp_flat_store_last;
        temp_flat_store_last->next_flat = position_of_base_flat;
        position_of_apartment->next_flat = temp_flat_store;

    }
    else{

        position_of_base_flat->prev_flat->next_flat = temp_flat_store;
        temp_flat_store->prev_flat = position_of_base_flat->prev_flat;
        temp_flat_store_last->next_flat = position_of_base_flat;
        position_of_base_flat->prev_flat = temp_flat_store_last;
    }
}
string Street::list_apartments() {
    //printing ,  again.
    string x = "";
    Node * temphead = this->head->next_apt;
    while(temphead!=nullptr){
        x += temphead->name+"("+ to_string(temphead->data)+")\t";
        Node * tempflat = temphead->next_flat;
        while(tempflat!= nullptr){
            x += "Flat"+tempflat->name+"("+ to_string(tempflat->data)+")\t";
            tempflat = tempflat->next_flat;
        }
        x += "\n";
        temphead = temphead->next_apt;
    }
    x += "\n";
    return x;

}
