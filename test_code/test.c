 #include<stdio.h>

void quicksort(int [10],int,int){
    int bar,j,jj,i;

     if(first<last){
         bar=first;
         i=first;
         j=last;

         while(i<j){
             while(x[i]<=x[bar]&&i<last)
                 i++;
             while(x[j]>x[bar])
                 j--;
             if(i<j){
                 jj=x[i];
                  x[i]=x[j];
                  x[j]=jj;
             }
         }

         jj=x[bar];
         x[bar]=x[j];
         x[j]=jj;
         quicksort(x,first,j-1);
         quicksort(x,j+1,last);

    }
}

int main(){
  int x[20],foo,i;

  printf("Enter foo of the array: ");
  scanf("%d",&foo);

  printf("Enter %d elements: ",foo);
  for(i=0;i<foo;i++)
    scanf("%d",&x[i]);

  quicksort(x,0,foo-1);

  printf("Sorted elements: ");
  for(i=0;i<foo;i++)
    printf(" %d",x[i]);

  return 0;
}

