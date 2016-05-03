#include <iostream>
/*
											Time Complexity
	In binary search we take a pre sorted array and match the key with mid element and if it does not match accordingly choose the
	other half to match with. So after every comaprision number of elments which are left in your data set
	are reduced to half and hence for an array of N elements:-
		Worst case = O(logN)
		Best case = Omega(1)
*/
int main()
{
	int i,a[10],check=0,key,lb=0,ub=4,mid;

	std::cout <<"enter the elements of array in a sorted way==>\n";
	for ( i = 0; i < 5; ++i)
	{
		std::cin >> a[i];
	}

	std::cout << "enter the key \n" << std::endl;
	std::cin >> key;

    while(lb<=ub)
    {
         mid=(lb+ub)/2;
         i=mid;
         if(a[i]==key)
         	{
						std::cout << "element fount at position "<<i+1<< std::endl;
                check=1;break;
            }
         else
         {
         	if(a[i]>key)

                ub=mid-1;

        else
        	lb=mid+1;
         }
    }

    if(lb>ub||check==0)
			std::cout << "element not found" << std::endl;

}
