#include <bits/stdc++.h>

using namespace std;

struct sinhVien
{
    string hoTen;
    string gioiTinh;
    int namSinh;
    float diemTK;
};

typedef struct sinhVien sv;

void nhap(sv x[], int n)
{
    for (int i = 0; i < n; i++)
    {
        cout << "Nhap thong tin sinh vien thu " << i + 1;
        fflush(stdin);
        cout << "\nHo ten: ";           getline(cin, x[i].hoTen);
        cout << "Gioi tinh: ";        getline(cin, x[i].gioiTinh);
        cout << "Nam sinh: ";         cin >> x[i].namSinh;
        cout << "Diem TK: ";          cin >> x[i].diemTK;
    }
}
void xuat(sv x[], int n)
{
    cout <<
    setw(15) << left << "Ho ten" <<
    setw(10) << left << "Gioi tinh" <<
    setw(10) << left << "Nam sinh" <<
    setw(10) << left << "Diem TK" << "\n";
    for (int i = 0; i < n; i++)
    {
        cout <<
        setw(15) << left << x[i].hoTen <<
        setw(10) << left << x[i].gioiTinh <<
        setw(10) << left << x[i].namSinh <<
        setw(10) << left << x[i].diemTK << "\n";
    }
}
void sapXep(sv x[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        for (int j = n - 1; j > i; j--)
        {
            if (x[j].hoTen < x[j - 1].hoTen)
            {
                sv temp = x[j];
                x[j] = x[j - 1];
                x[j - 1] = temp;
            }
        }
    }
    xuat(x, n);
}
void selectionSort(sv x[], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int m = i;
        for (int j = i + 1; j < n; j++)
        {
            if (x[j].namSinh > x[m].namSinh)
                m = j;
        }
        sv temp = x[m];
        x[m] = x[i];
        x[i] = temp;
    }
    xuat(x, n);
}
void insertSort(sv x[], int n)
{
    for (int i = 1; i < n; i++)
    {
        int tam = x[i].diemTK;
        int j = i - 1;
        while (j > -1 && x[j].diemTK > tam)
        {
            x[j + 1].diemTK = x[j].diemTK;
            j--;
        }
        x[j + 1].diemTK = tam;
    }
    xuat(x, n);
}
int main()
{
    sv *x;
    int n;
    cout << "Nhap so luong sinh vien: ";    cin >> n;
    x = new sv[n];
    nhap(x, n);
    cout << "\nDanh sach truoc khi sap xep: \n";
    xuat(x, n);
    cout << "\n-------------------------------\n";
    cout << "\nDanh sach truoc khi sap xep: \n";
    sapXep(x, n);
    selectionSort(x, n);
    insertSort(x, n);
}
