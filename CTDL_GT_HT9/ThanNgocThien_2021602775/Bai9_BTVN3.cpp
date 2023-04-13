
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
void insertSort(nm x[], int n)
{
    for (int i = 1; i < n; i++)
    {
        string tam = x[i].Ten;
        int j = i - 1;
        while (j > -1 && x[j].Ten > tam)
        {
            x[j + 1].Ten = x[j].Ten;
            j--;
        }
        x[j + 1].Ten = tam;
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
    insertSort(x, n);
}
