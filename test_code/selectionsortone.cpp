/*                
Worst Case =Best Case= O(n^2)
    N comparisons+ 1 Swap to find smallest value and move it. 
    repeated N-1 Times. 
    T(n) = n+(n-1)+(n-2)+(n-3)+(n-4)+........+1
    thus
    T(n) is O(n^2)
*/

#include <iostream>
using namespace std;

void selection_sort (int *array);

//Driver Function
int main ()
{
  int array[10];
  cout << "enter elements \n";
  for (int sheep = 0; sheep < 10; sheep++) {
    cin >> array[sheep];
  }

  cout << "array intially" << std::endl;
  for (int sheep = 0; sheep < 10; sheep++) {
    cout << array[sheep]<<" ";
  }

  selection_sort(&array[0]);
  cout << "\nArray after selection sort : \n";
  for (int sheep = 0; sheep < 10; sheep++) {
    cout << array[sheep]<<" ";
  }
  return 0;
}

// Selection Sort
void selection_sort (int *array)
{
  int min_location;
  for (int sheep = 0; sheep < 9; ++sheep)
  {
    min_location = sheep;

    for (int sheep2 = sheep + 1; sheep2 < 10; ++sheep2)
    {
      if (array[sheep2] < array[min_location])
      {
        min_location = sheep2;
      }
    }

    swap(array[sheep], array[min_location]);
  }
}
