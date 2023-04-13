// C++ program to sort strings using bubble sort.
#include<iostream>
#include<string.h>

using namespace std;

int main() {
    // Create a character array "Name" of size 10 and character value 15.

    // Create another array “arr” of data type string, and the value of '10' is set as a character value.
    char Name[10][15], arr[10];

    // User inputs x and y.
    int x, y;
    cout << "Enter Names: ";
    for (x = 0; x < 10; x++) {
        cin >> Name[x];
    }
    for (x = 1; x < 10; x++) {
        for (y = 1; y < 10; y++) {
            if (strcmp(Name[y - 1], Name[y]) > 0) {
                strcpy(arr, Name[y - 1]);
                strcpy(Name[y - 1], Name[y]);
                strcpy(Name[y], arr);
            }

        }
    }
    cout << "\nAlphabetical order of Names :\n";
    for (x = 0; x < 10; x++)
        cout << Name[x] << endl;
    cout << endl;
    return 0;
}
