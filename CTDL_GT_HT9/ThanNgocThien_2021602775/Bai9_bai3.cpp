#include <bits/stdc++.h>

using namespace std;

void insertSort(int x[], int n)
{
    for (int i = 1; i < n; i++)
    {
        int tam = x[i];
        int j = i - 1;
        while (j > -1 && x[j] > tam)
        {
            x[j + 1] = x[j];
            j--;
        }
        x[j + 1] = tam;
    }
}
int a[9] = {34, 14, 24, 54, 84, 64, 94, 74, 4};
int main()
{
    cout << "Day truoc khi sap xep la: ";
        for (int i = 0 ; i < 9; i++)
            cout << a[i] << " ";
        insertSort(a, 9);
        cout << "\nDay sau khi sap xep la: ";
        for (int i = 0 ; i < 9; i++)
            cout << a[i] << " ";
}
