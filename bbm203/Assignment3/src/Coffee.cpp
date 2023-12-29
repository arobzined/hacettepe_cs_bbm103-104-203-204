//
// Created by deniz on 1.12.2022.
//

#include "sstream"
#include "Coffee.h"
#include "fstream"

void Coffee::read_input(string inputtxt,string outputtxt) {
    ifstream *txt = new ifstream(inputtxt);
    string input_str = "";
    string output_str;
    int casier_numberr;
    int barista_numberr;
    int costumer_number;
    if(!txt->is_open()){
        cout << "No such file...";
    }
    else{
        int i = 0;
        int v = 0;
        Node* tempcostmr = this->costumer_head;
        while(getline(*txt,input_str)) {
            if (!input_str.empty() && input_str[input_str.size() - 1] == '\r')
                input_str.erase(input_str.size()-1);
            if(i == 0){
                int casier_number = stoi(input_str);
                casier_numberr = casier_number;
                int barista_number = (casier_number / 3);
                barista_numberr = barista_number;
                int j = 0;
                Node * temphead = this->casier_head;
                while(j < casier_number){
                    Node * newcasier = new Node(j+1,1);
                    temphead->next_casier = newcasier;
                    newcasier->point_barista_head = this->barista_head;
                    j++;
                    temphead = temphead->next_casier;

                }
                j = 0;
                Node * tempbaristahead = this->barista_head;
                while(j < barista_number){
                    Node * newbarista = new Node(j+1,1,1);
                    tempbaristahead->next_barista = newbarista;
                    j++;
                    tempbaristahead = tempbaristahead->next_barista;
                }

            }
            else if(i == 1){
                costumer_number = stoi(input_str);
            }
            else{
                double inputarr[4];
                stringstream stringg(input_str);
                string x = "";
                auto *y = " ";
                int z = 0;
                while(getline(stringg,x,*y)){
                    inputarr[z] = stod(x);
                    z++;
                }
                Node * new_costumer = new Node(v+1,inputarr[0],inputarr[1],inputarr[2],inputarr[3],0,0);
                v++;
                tempcostmr->next_costumer = new_costumer;
                tempcostmr = tempcostmr->next_costumer;
            }
            i++;
        }
    }
    this->implement_orders(casier_numberr,costumer_number);
    this->implement_coffees(barista_numberr,costumer_number);
    this->implement_coffees2(barista_numberr,costumer_number);
    this->output_writer(outputtxt);
}

void Coffee::implement_orders(int casier_numberr,int costumer_number) {
    Node * tempcost = this->costumer_head->next_costumer;
    while(tempcost != nullptr){
        double time = tempcost->arrival_time;
        Node * tempcasy = this->casier_head->next_casier;
        while(tempcasy!= nullptr){
            if(tempcasy->work_time <= time){
                tempcasy->is_empty = 1;
            }
            tempcasy = tempcasy->next_casier;
        }
        tempcasy = this->casier_head->next_casier;
        Node * tempwaiters = this->costumer_waiting_head;
        int count = 0;
        while(tempcasy!= nullptr){
            if(tempcasy->is_empty == 1){
                if(tempwaiters->next_waiting_costumer != nullptr){
                    Node * popelement = tempwaiters->next_waiting_costumer;
                    tempwaiters->next_waiting_costumer = popelement->next_waiting_costumer;
                    popelement->next_waiting_costumer = nullptr;
                    tempcasy->work_time += popelement->order_time;
                    tempcasy->busy_time += popelement->order_time;
                    popelement->when_order_completed += tempcasy->work_time;
                    popelement->casier_number = tempcasy->id;
                    tempcasy->is_empty = 0;
                }
            }
            tempcasy = tempcasy->next_casier;
        }
        tempcasy = this->casier_head->next_casier;

        while(tempcasy!= nullptr){
            if(tempcasy->is_empty == 1){
                count++;
                tempcasy->work_time += (time - tempcasy->work_time) + tempcost->order_time;
                tempcasy->busy_time += tempcost->order_time;
                tempcasy->is_empty = 0;
                tempcost->when_order_completed += tempcasy->work_time;
                tempcost->casier_number = tempcasy->id;
                break;
            }
            tempcasy = tempcasy->next_casier;
        }


        int i = 0;
        if(count == 0){
            Node * temphead = this->costumer_waiting_head;
            Node * new_elm = tempcost;
            while(temphead->next_waiting_costumer != nullptr){
                i++;
                temphead = temphead->next_waiting_costumer;
            }
            temphead->next_waiting_costumer = new_elm;
            new_elm->next_waiting_costumer = nullptr;
            i++;
        }
        tempcasy = this->casier_head->next_casier;
        if(tempcasy->casier_waiters_max_lenght < i){
            tempcasy->casier_waiters_max_lenght = i;
        }

        tempcost = tempcost->next_costumer;
    }

    Node * temphead = this->costumer_head->next_costumer;
    Node * newhead = this->costumer_head2;
    while(temphead!= nullptr){
        newhead->next_costumer = new Node(temphead->id,temphead->arrival_time,temphead->order_time,temphead->making_time,temphead->price,temphead->when_order_completed,0);
        newhead->next_costumer->casier_number = temphead->casier_number;
        temphead->casier_number = -1;
        newhead = newhead->next_costumer;
        temphead = temphead->next_costumer;
    }
}

void Coffee::implement_coffees(int barista_numberr,int costumer_number) {

    Node * tempsearch= this->costumer_head->next_costumer;
    Node * tempsearch2 = this->costumer_head->next_costumer;
    double time1 = tempsearch->when_order_completed;
    Node * tempcont;
    Node * tempcont2;
    double time2;
    double time3;
    while(tempsearch != nullptr){
        if(tempsearch->when_order_completed <= time1){
            time1 = tempsearch->when_order_completed;
            tempcont = tempsearch;}
        tempsearch = tempsearch->next_costumer;
    }
    tempcont2 = tempcont;
    tempcont = this->costumer_head->next_costumer;
    while(tempcont != nullptr){
        Node * tempbarista = this->barista_head->next_barista;
        while(tempbarista!= nullptr){
            if((tempbarista->when_next_coffee_finish) <= time1){
                tempbarista->is_empty = 1;

            }
            tempbarista = tempbarista->next_barista;
        }
        tempbarista = this->barista_head->next_barista;
        Node * tempwaiters = this->costumer_waiting_head;

        while(tempbarista!= nullptr){
            if(tempbarista->is_empty == 1){
                if(tempwaiters->next_waiting_costumer != nullptr){
                    Node * popelement = tempwaiters->next_waiting_costumer;
                    tempwaiters->next_waiting_costumer = popelement->next_waiting_costumer;
                    popelement->next_waiting_costumer = nullptr;
                    tempbarista->work_time += popelement->making_time;
                    popelement->when_coffee_completed = tempbarista->when_next_coffee_finish + popelement->making_time;
                    tempbarista->when_next_coffee_finish += popelement->making_time;

                    tempbarista->is_empty = 0;
                }
            }
            tempbarista = tempbarista->next_barista;
        }
        tempbarista = this->barista_head->next_barista;
        int count = 0;
        while(tempbarista!= nullptr){
            if(tempbarista->is_empty == 1){
                count++;
                tempbarista->work_time += tempcont2->making_time;
                tempcont2->when_coffee_completed = time1 + tempcont2->making_time;
                tempbarista->when_next_coffee_finish = time1 + tempcont2->making_time;
                tempbarista->is_empty = 0;
                break;
            }
            tempbarista = tempbarista->next_barista;
        }

        if(count == 0) {
            Node *temphead = this->costumer_waiting_head;
            Node *new_elm = tempcont2;
            if (temphead->next_waiting_costumer == nullptr) {
                temphead->next_waiting_costumer = new_elm;
            }
            else {
                while (temphead->next_waiting_costumer != nullptr) {
                    if (temphead->next_waiting_costumer->price > new_elm->price){
                        temphead = temphead->next_waiting_costumer;}
                    else
                        break;
                }
                new_elm->next_waiting_costumer = temphead->next_waiting_costumer;
                temphead->next_waiting_costumer = new_elm;
            }
        }

        int k = 0;
        Node * waitingsearch = this->costumer_waiting_head;
        if(waitingsearch->next_waiting_costumer != nullptr){
            while(waitingsearch->next_waiting_costumer!= nullptr){
                k++;
                waitingsearch = waitingsearch->next_waiting_costumer;
            }
        }

        Node * tempbaristaa = this->barista_head->next_barista;
        while(tempbaristaa != nullptr){
            if(tempbaristaa->barista_waiters_max_lenght < k){
                tempbaristaa->barista_waiters_max_lenght = k;
            }
            tempbaristaa = tempbaristaa->next_barista;
        }


        tempsearch = this->costumer_head->next_costumer;
        tempsearch2 = this->costumer_head->next_costumer;

        while(tempsearch!= nullptr){
            if(tempsearch->when_order_completed > time1){
                time2 = tempsearch->when_order_completed;
                while(tempsearch2!= nullptr){
                    if(tempsearch2->when_order_completed <= time2 && tempsearch2->when_order_completed > time1){
                        time2 = tempsearch2->when_order_completed;
                        tempcont2 = tempsearch2;
                    }
                    tempsearch2 = tempsearch2->next_costumer;
                }
                time1 = time2;
                break;
            }
            tempsearch = tempsearch->next_costumer;
        }
        tempcont = tempcont->next_costumer;
    }

    Node * temphead = this->costumer_waiting_head->next_waiting_costumer;

    Node * tempbarista = this->barista_head->next_barista;



    while(temphead!= nullptr){
        Node * baristacont = this->barista_head->next_barista;
        tempbarista = this->barista_head->next_barista;
        double time = tempbarista->when_next_coffee_finish;

        while(tempbarista!= nullptr){
            if(tempbarista->when_next_coffee_finish < time){
                baristacont = tempbarista;
                time = tempbarista->when_next_coffee_finish;
            }
            tempbarista = tempbarista->next_barista;
        }


        Node * popelement = temphead;

        baristacont->work_time += popelement->making_time;
        popelement->when_coffee_completed = time + popelement->making_time;
        baristacont->when_next_coffee_finish += popelement->making_time;

        temphead = temphead->next_waiting_costumer;
    }

    tempbarista = this->barista_head->next_barista;
    while(tempbarista!= nullptr){
        tempbarista->is_empty = 1;
        tempbarista = tempbarista->next_barista;
    }

}

void Coffee::implement_coffees2(int barista_numberr, int costumer_number) {
    int i = 1;

    while(i <= barista_numberr){
        Node * temphead = this->temporary_list;
        Node * tempcosthead = this->costumer_head2->next_costumer;
        Node * baristasearch = this->barista_head->next_barista;
        while(tempcosthead!= nullptr){
            if((tempcosthead->casier_number - 1) / 3 == i - 1){
                temphead->next_costumer = new Node(tempcosthead->id,tempcosthead->arrival_time,tempcosthead->order_time,tempcosthead->making_time,tempcosthead->price,tempcosthead->when_order_completed,tempcosthead->when_coffee_completed);
                temphead->next_costumer->casier_number = tempcosthead->casier_number;
                temphead = temphead->next_costumer;
            }
            tempcosthead = tempcosthead->next_costumer;
        }
        temphead = this->temporary_list->next_costumer;
        double time = temphead->when_order_completed;
        while(temphead!= nullptr){
            if(temphead->when_order_completed < time){
                time = temphead->when_order_completed;
            }
            temphead = temphead->next_costumer;
        }

        temphead = this->temporary_list->next_costumer;

        while(baristasearch!= nullptr){
            if(baristasearch->id == i){
                break;
            }
            baristasearch = baristasearch->next_barista;
        }
        baristasearch->work_time2 = 0;



        while(temphead!= nullptr){
            if(baristasearch->is_empty == 1 && temphead->when_order_completed == time){
                baristasearch->work_time2 += temphead->making_time;
                temphead->when_coffee_completed = temphead->when_order_completed + temphead->making_time;
                baristasearch->when_next_coffee_finish = temphead->when_coffee_completed;
                time = temphead->when_coffee_completed;
                baristasearch->is_empty = 0;
                temphead->first = 1;
            }
            tempcosthead = this->costumer_head2->next_costumer;
            while(tempcosthead!= nullptr){
                if(tempcosthead->id == temphead->id){
                    tempcosthead->when_coffee_completed = temphead->when_coffee_completed;
                }
                tempcosthead = tempcosthead->next_costumer;
            }
            temphead = temphead->next_costumer;
        }
        Node * tempsearch = this->temporary_list->next_costumer;
        Node * tempwaiters = this->costumer_waiting_head2->next_waiting_costumer;
        Node * tempwaitershead = this->costumer_waiting_head2;


        temphead = this->temporary_list->next_costumer;
        time = baristasearch->when_next_coffee_finish;
        double downtime = 0;
        int count;

        while(tempsearch!= nullptr){
            count = 0;
            temphead = this->temporary_list->next_costumer;

            while(temphead != nullptr){
                tempwaiters = this->costumer_waiting_head2->next_waiting_costumer;
                tempwaitershead = this->costumer_waiting_head2;
                if(temphead->when_order_completed > downtime && temphead->when_order_completed < time && temphead->first != 1){
                    if(tempwaiters == nullptr){
                        tempwaitershead->next_waiting_costumer = temphead;
                        temphead->next_waiting_costumer = nullptr;
                    }
                    else{
                        while(tempwaiters!= nullptr){
                            if(tempwaiters->price < temphead->price){
                                tempwaitershead->next_waiting_costumer = temphead;
                                temphead->next_waiting_costumer = tempwaiters;
                                break;
                            }
                            tempwaitershead = tempwaitershead->next_waiting_costumer;
                            tempwaiters = tempwaiters->next_waiting_costumer;
                        }
                    }
                }
                temphead = temphead->next_costumer;
            }

            tempwaiters = this->costumer_waiting_head2->next_waiting_costumer;

            Node * waiterssearch = this->costumer_waiting_head2;
            if(waiterssearch->next_waiting_costumer != nullptr){
                while(waiterssearch->next_waiting_costumer != nullptr){
                    count++;
                    waiterssearch = waiterssearch->next_waiting_costumer;
                }
            }


            if(baristasearch->barista_waiters_max_lenght2 < count){
                baristasearch->barista_waiters_max_lenght2 = count;
            }



            tempwaiters = this->costumer_waiting_head2;

            Node * popelement = this->costumer_waiting_head2->next_waiting_costumer;
            Node * tempheadd = this->costumer_head2->next_costumer;
            if(popelement != nullptr){
                downtime = baristasearch->when_next_coffee_finish;
                baristasearch->when_next_coffee_finish += popelement->making_time;
                baristasearch->work_time2 += popelement->making_time;
                time = baristasearch->when_next_coffee_finish;
                popelement->when_coffee_completed = baristasearch->when_next_coffee_finish;
                while(tempheadd!=nullptr){
                    if(tempheadd->id == popelement->id){
                        tempheadd->when_coffee_completed = popelement->when_coffee_completed;
                        break;
                    }
                    tempheadd = tempheadd->next_costumer;
                }

                tempwaiters->next_waiting_costumer = popelement->next_waiting_costumer;
                popelement->next_waiting_costumer = nullptr;
                free(popelement);
            }

            tempsearch = tempsearch->next_costumer;
        }
        i++;
    }

}

double Coffee::float_converter(double number) {
    // 37.66666 * 100 =3766.66
    // 3766.66 + .5 =3767.16    for rounding off value
    // then type cast to int so value is 3767
    // then divided by 100 so the value converted into 37.67
    double value = (int)(number * 100 + .5);
    return (float)value / 100;

}

void Coffee::output_writer(string filename) {
    ofstream filewrite(filename);


    //model1
    double total_runtime = 0;
    Node * head1 = this->costumer_head->next_costumer;
    while(head1!= nullptr){
        if(head1->when_coffee_completed > total_runtime){
            total_runtime = head1->when_coffee_completed;
        }
        head1 = head1->next_costumer;
    }
    Node * casier_head1 = this->casier_head->next_casier;
    Node * barista_head = this->barista_head->next_barista;


    filewrite<<total_runtime<<"\n";
    filewrite<<casier_head1->casier_waiters_max_lenght<<"\n";
    filewrite<<barista_head->barista_waiters_max_lenght<<"\n";

    casier_head1 = this->casier_head->next_casier;
    double casier_work;
    while(casier_head1 != nullptr){
        casier_work = this->float_converter(casier_head1->busy_time / total_runtime);
        filewrite<<casier_work<<"\n";
        casier_head1 = casier_head1->next_casier;
    }


    double barista_work;
    while(barista_head!= nullptr){
        barista_work = this->float_converter(barista_head->work_time/total_runtime);
        filewrite<<barista_work<<"\n";
        barista_head = barista_head->next_barista;
    }
    head1 = this->costumer_head->next_costumer;
    while(head1!= nullptr){
        filewrite<<(head1->when_coffee_completed - head1->arrival_time)<<"\n";
        head1 = head1->next_costumer;
    }




    filewrite<<"\n";
    //model2
    double total_runtime2 = 0;
    Node * head2 = this->costumer_head2->next_costumer;
    Node * casier_head2 = this->casier_head->next_casier;
    while(head2!= nullptr){
        if(head2->when_coffee_completed > total_runtime2){
            total_runtime2 = head2->when_coffee_completed;
        }
        head2 = head2->next_costumer;
    }

    filewrite<<total_runtime2<<"\n";
    filewrite<<casier_head2->casier_waiters_max_lenght<<"\n";

    Node * barista_head2 = this->barista_head->next_barista;
    while(barista_head2!= nullptr){
        filewrite<<barista_head2->barista_waiters_max_lenght2<<"\n";
        barista_head2 = barista_head2->next_barista;
    }
    casier_head2 = this->casier_head->next_casier;
    double casier_work2;
    while(casier_head2 != nullptr){
        casier_work2 = this->float_converter(casier_head2->busy_time / total_runtime2);
        filewrite<<casier_work2<<"\n";
        casier_head2 = casier_head2->next_casier;
    }


    barista_head2 = this->barista_head->next_barista;
    double barista_work2;
    while(barista_head2!= nullptr){
        barista_work2 = this->float_converter(barista_head2->work_time2/total_runtime2);
        filewrite<<barista_work2<<"\n";
        barista_head2 = barista_head2->next_barista;
    }

    head2 = this->costumer_head2->next_costumer;
    while(head2!= nullptr){
        filewrite<<(head2->when_coffee_completed - head2->arrival_time)<<"\n";
        head2 = head2->next_costumer;
    }

    filewrite.close();


}
