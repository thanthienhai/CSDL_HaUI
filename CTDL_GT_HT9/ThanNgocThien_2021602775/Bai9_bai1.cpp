#include <bits/stdc++.h>

using namespace std;

void bubbleSort(int x[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = n - 1; j > i; j--)
        {
            if (x[j] < x[j - 1])
            {
                int temp = x[j];
                x[j] = x[j - 1];
                x[j - 1] = temp;
            }
        }
    }
}
int a[6] = {34, 74, 94, 84, 54, 24};
int main()
{
        cout << "Day truoc khi sap xep la: ";
        for (int i = 0 ; i < 5; i++)
            cout << a[i] << " ";
        bubbleSort(a, 5);
        cout << "\nDay sau khi sap xep la: ";
        for (int i = 0 ; i < 5; i++)
            cout << a[i] << " ";
}
