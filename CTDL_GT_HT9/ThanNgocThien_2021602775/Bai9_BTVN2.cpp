#include <bits/stdc++.h>

using namespace std;

struct Name
{
    string Ten;
};

typedef struct Name nm;

void nhap(nm x[], int n)
{
    for (int i = 0; i < n; i++)
    {
        getline(cin, x[i].Ten);
    }
}
void xuat(nm x[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << x[i].Ten << " ";
    }
}
void selectionSort(nm x[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int m = i;
        for (int j = i + 1; j < n; j++)
        {
            if (x[j].Ten < x[m].Ten)
                m = j;
        }
        nm temp = x[m];
        x[m] = x[i];
        x[i] = temp;
    }
    xuat(x, n);
}

int main()
{
    nm *x;
    int n = 9;
    x = new nm[9];
    x[0] = {"John"};
    x[1] = {"Cool"};
    x[2] = {"Bee"};
    x[3] = {"Try"};
    x[4] = {"Thor"};
    x[5] = {"Zil"};
    x[6] = {"Adam"};
    x[7] = {"Dany"};
    x[8] = {"Milk"};
    //nhap(x, n);
    cout << "\nDanh sach truoc khi sap xep: \n";
    xuat(x, n);
    cout << "\n-------------------------------";
    cout << "\nDanh sach truoc khi sap xep: \n";
    selectionSort(x, n);
}

