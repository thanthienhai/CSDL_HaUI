#include <bits/stdc++.h>

using namespace std;

void selectionSort(int x[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int m = i;
        for (int j = i + 1; j < n; j++)
        {
            if (x[j] < x[m])
                m = j;
        }
        int temp = x[m];
        x[m] = x[i];
        x[i] = temp;
    }
}
int a[15] = {50, 8, 34, 6, 98, 17, 83, 25, 66, 42, 21, 59, 63, 71, 85};
int main()
{
    cout << "Day truoc khi sap xep la: ";
        for (int i = 0 ; i < 14; i++)
            cout << a[i] << " ";
        selectionSort(a, 14);
        cout << "\nDay sau khi sap xep la: ";
        for (int i = 0 ; i < 14; i++)
            cout << a[i] << " ";
}
