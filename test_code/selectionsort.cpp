/*                Time Complexity

Worst Case =Best Case= O(n^2)
    It take n comparision to find the smallest element then one swap to place it on its right position
    and then same process is repeted on rest of the n-1 elements i.e
    T(n) = n+(n-1)+(n-2)+(n-3)+(n-4)+........+1
    which comes out to be order of n^2

*/

#include <iostream>
using namespace std;

void selection_sort (int *array);

//Driver Function
int main ()
{
  int array[10];
  cout << "enter elements \n";
  for (int i = 0; i < 10; i++) {
    cin >> array[i];
  }

  cout << "array intially" << std::endl;
  for (int i = 0; i < 10; i++) {
    cout << array[i]<<" ";
  }

  selection_sort(&array[0]);
  cout << "\nArray after selection sort : \n";
  for (int i = 0; i < 10; i++) {
    cout << array[i]<<" ";
  }
  return 0;
}

// Selection Sort
void selection_sort (int *array)
{
  int min_location;
  for (int i = 0; i < 9; ++i)
  {
    min_location = i;

    for (int j = i + 1; j < 10; ++j)
    {
      if (array[j] < array[min_location])
      {
        min_location = j;
      }
    }

    swap(array[i], array[min_location]);
  }
}
