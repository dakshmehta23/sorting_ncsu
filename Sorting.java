public class Sorting {

    int comparisonCount;
    int[] sortingArray;
    
    Sorting(int[] input)
    {
        sortingArray = input;
        comparisonCount = 0;
    }

    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums1 = new int[]{1,2,3,4};
        Sorting obj = new Sorting(nums1);
        // obj.mergeSort(0, nums1.length-1);
        // obj.heapify(nums1.length);
        obj.heapSort();
        for(int i : obj.sortingArray){
            System.out.println(i);
        }
        System.out.println("comparisons = "+obj.comparisonCount);
    }
    
    public void merge(int p, int mid, int r){
        int i,j,k;
        int[] arr= new int [100];
        i=p;
        j=mid+1;
        k=p;
        while(i<=mid&&j<=r){
            if(sortingArray[i]<=sortingArray[j]){
                arr[k++]=sortingArray[i++];
                comparisonCount++;
            }
            else{
                arr[k++]=sortingArray[j++];
                comparisonCount++;
            }
        }
        for(;i<=mid;i++){
            arr[k++]=sortingArray[i];
        }
        for(;j<=r;j++){
            arr[k++]=sortingArray[j];
        }
        for(i=p;i<=r;i++){
            sortingArray[i]=arr[i];
        }

    }

    public void mergeSort(int p, int r) {
        int mid;
        if(p<r){
            mid=(p+r)/2;
            mergeSort(p, mid);
            mergeSort(mid+1, r);
            merge(p,mid,r);
        }
    }
    
    public void insertionSort() {
        // TODO

        int j;
        for(int i=1;i<sortingArray.length;i++){
            j=i-1;
            int temp=sortingArray[i];
            if(j>-1){
                if(sortingArray[j]<=temp){
                    comparisonCount++;
                }
            }
            while(j>-1 && sortingArray[j]>temp){
                    comparisonCount++;
                    sortingArray[j+1]=sortingArray[j];
                    j--;   
            }
            sortingArray[j+1]=temp;
        }
    }

    
    // public void heapify(int n){
    //     for(int i=(n/2)-1;i>=0;i--){
    //         int j=2*i+1;
    //         while(j<n-1){
    //             if(sortingArray[j]<sortingArray[j+1]){
    //                 j=j+1;
    //             }
    //             if(sortingArray[i]<sortingArray[j]){
    //                 int temp=sortingArray[i];
    //                 sortingArray[i]=sortingArray[j];
    //                 sortingArray[j]=temp;
    //                 i=j;
    //                 j=2*i+1;
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //     }
    // }

    public void max_heapify(int i, int n){
        int root=i;
        int l=2*i+1;
        int r=2*i+2;
        // if(l<n && sortingArray[l]>sortingArray[root]){
        //     root=l;
        // }

        if(l<n){
            if(sortingArray[l]>sortingArray[root]){
                root=l;
                comparisonCount++;
            }
            else{
                comparisonCount++;
            }
        }

        // if(r<n && sortingArray[r]>sortingArray[root]){
        //     root=r;
        // }

        if(r<n){
            if(sortingArray[r]>sortingArray[root]){
                root=r;
                comparisonCount++;
            }
            else{
                comparisonCount++;
            }
            
        }

        if(root!=i){
            int temp=sortingArray[i];
            sortingArray[i]=sortingArray[root];
            sortingArray[root]=temp;
            max_heapify(root, n);
        }
    }

    public  void heapSort()  {
        int n=sortingArray.length;
        for(int i=n/2-1;i>=0;i--){
            max_heapify(i, n);
        }
        for(int i=n-1;i>=0;i--){
            int temp=sortingArray[0];
            sortingArray[0]=sortingArray[i];
            sortingArray[i]=temp;
            max_heapify(0, i);
        }
    }
    
}
