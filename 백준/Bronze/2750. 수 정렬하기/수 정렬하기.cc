// hello.cpp

#include <iostream>

using namespace std;

void swap(int* a,int* b);

void quicksort(int arr[],int start,int end)
{
    if(start>=end)
    {
        return;
    }

    int pivot=arr[end];

    int less=start;
    
    for(int i=start;i<end;i++)
    {
        if(arr[i]<pivot)
        {
            swap(&arr[less++],&arr[i]);
        }
    }
    swap(&arr[less],&arr[end]);



    quicksort(arr,start,less-1);
    quicksort(arr,less+1,end);
}

void swap(int* a, int* b)
{
    // cout<<*a<<" " <<*b<<endl;
    if(a==b)
        return;
    int temp=*a;
    *a=*b;
    *b=temp;

    // cout<<"res: "<<*a<<" " <<*b<<endl;
}

int main(void)
{
    int N;

    cin >> N;

    int arr[N];

    for(int i=0;i<N;i++)
    {
        int input;
        cin >> input;
        arr[i]=input;
    }
    quicksort(arr,0,N-1);

    for(int i=0;i<N;i++)
        cout << arr[i] << endl;
}