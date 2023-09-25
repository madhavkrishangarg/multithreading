#include <pthread.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <unistd.h>
#include <math.h>
#include <time.h>
#include <sched.h>

int arr[] = {1,3,2,5,6,3,7,8};
int temp;

void swap(int *a,int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void *compare(){
    int x = temp;
    temp = temp + 2;
    if ((arr[x] > arr[x + 1]) && (x + 1 < 8)) {
        swap(arr[x], arr[x + 1]);
    }
}

int main(){
    
    pthread_t p[8];
    
    for (int i = 1; i < 8; i++) {
        if (i % 2 == 1) {
            temp = 0;
            for (int j = 0; j < 4; j++)
                pthread_create(&p[j],NULL, compare, NULL);
            for (int j = 0; j < 4; j++)
                pthread_join(p[j],NULL);
        }
        else {
            temp = 1;
  
            // Creating threads
            for (int j = 0; j < 4 - 1; j++)
                pthread_create(&p[j],NULL, compare, NULL);
            for (int j = 0; j < 4 - 1; j++)
                pthread_join(p[j],NULL);
        }
    }

    return 0;
}