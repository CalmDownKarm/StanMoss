#include "iostream"
/*
                  TIME COMPLEXITY
  For quick sort we can consider 3 cases :-
    1. Worst case = array dividing into two parts of 1 and n-1 elements
    2. Best case = array dividing into two equal parts
    3. Average case = array divided into two parts of size i and n-i-1

  1. Worst case
    T(n) = T(n-1)+ Cn       n>1
    T(n-1) = T(n-2)+ C(n-1)
    T(n-2) = T(n-3)+ C(n-2)
    .
    .
    .
    T(2) = T(1)+ C.2

    i.e T(n) = T(1) + Cn+C(n-1)+C(n-2)......C.2
      T(n) = 1+C(n+n-1+n-2+n-2...........2)
      T(n) = 1+C({n(n+1)/2}-1)
      T(n) = O(n^2)

  2. Best Case
      T(n) = 2T(n/2) + C(n)
        using master's th.
        a=2 b=2 k=1 p=0

        a = b^k and p=0
        therefore ϴ(n) = ϴ(n^(log a/log b)*log^(p+1) n)
        which comes out to be ϴ(nlogn)

*/

class test
{
private:
/*data*/
};

class testtest {
private:
/*data*/
};

struct foo {
  /* data */
};

struct foofoo {
  /* data */
};
void quick_sort(int *array,int low,int high);
int partation(int *array,int low,int high);
void swap(int *array,int one,int two);
void try(int sheep1,int sheep2){
// do anything
}
//main function
int main(int argc, char const *argv[]) {
  int array[10];float hitkul;
  int array123[]={1,2,3},shep;
////test code
  float hhhh;
  array[0] = (int)hhhh;
////
  std::cout << "enter elments of the array" << std::endl;
  for (int i = 0; i < 10; i++)
    std::cin >> array[i];

  quick_sort(&array[0],0,10);

  for (int i = 0; i < 10; i++)
    std::cout << array[i] <<" ";
  return 0;
}
//function1
void quick_sort(int *array,int low,int high) {
  int partation_index;
  if(low<=high){
    partation_index = partation(&array[0],low,high);
    quick_sort(&array[0],low,partation_index-1);
    quick_sort(&array[0],partation_index+1,high);
  }
}
//function 2
int partation(int *array,int low,int high){
  int partation_index= low;
  int piviot = array[high];
  for (int i = low; i < high; i++) {
    if(array[i]<=piviot){
      swap(&array[0],i,partation_index);
      partation_index++;
    }
  }
  swap(&array[0],high,partation_index);
  return partation_index;
}

void swap(int *array,int one,int two){
  int temp,temp1;
  temp=array[one];
  array[one]=array[two];
  array[two]=temp;
}
