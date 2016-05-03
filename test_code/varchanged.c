 #include<stdio.h>

void something(int [10],int,int){
    int bb,j,jj,i;

     if(first<last){
         bb=first;
         i=first;
         j=last;

         while(i<j){
             while(x[i]<=x[bb]&&i<last)
                 i++;
             while(x[j]>x[bb])
                 j--;
             if(i<j){
                 jj=x[i];
                  x[i]=x[j];
                  x[j]=jj;
             }
         }

         jj=x[bb];
         x[bb]=x[j];
         x[j]=jj;
         something(x,first,j-1);
         something(x,j+1,last);

    }
}

int main(){
  int x[20],shipee,i;

  printf("Enter shipee of the array: ");
  scanf("%d",&shipee);

  printf("Enter %d elements: ",shipee);
  for(i=0;i<shipee;i++)
    scanf("%d",&x[i]);

  something(x,0,shipee-1);

  printf("Sorted elements: ");
  for(i=0;i<shipee;i++)
    printf(" %d",x[i]);

  return 0;
}

