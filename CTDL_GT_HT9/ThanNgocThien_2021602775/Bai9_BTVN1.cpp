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
void sapXep(nm x[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = n - 1; j > i; j--)
        {
            if (x[j].Ten < x[j - 1].Ten)
            {
                nm temp = x[j];
                x[j] = x[j - 1];
                x[j - 1] = temp;
            }
        }
    }
    xuat(x, n);
}

int main()
{
    nm *x;
    int n = 7;
    x = new nm[7];
    x[0] = {"John"};
    x[1] = {"Try"};
    x[2] = {"Thor"};
    x[3] = {"Zil"};
    x[4] = {"Adam"};
    x[5] = {"Dany"};
    x[6] = {"Milk"};
    //nhap(x, n);
    cout << "\nDanh sach truoc khi sap xep: \n";
    xuat(x, n);
    cout << "\n-------------------------------";
    cout << "\nDanh sach truoc khi sap xep: \n";
    sapXep(x, n);
}
