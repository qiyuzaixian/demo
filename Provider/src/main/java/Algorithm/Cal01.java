package Algorithm;

// 归并排序
public class Cal01 {
    public static void main(String args[]){
        int[] num = new int[]{1,56,7,15,27,39,41,15,25,42,24};
        sort(0,num.length-1,num);
        for(Integer i:num){
            System.out.print(i + " ,");
        }
    }
    private static  void sort(int low,int high,int[] num){
        if(high>low){
            int mid = (high+low)/2;
            sort(low,mid,num);
            sort(mid+1,high,num);
            merge(low,mid,high,num);
        }
    }
    private static void merge(int low,int mid,int high,int[] num){
        int i=low;
        int j=mid+1;
        int k=0;
        int[] temp = new int[high-low+1];
        while(i<=mid&&j<=high){
            if(num[i]>num[j]){
                temp[k++] = num[j++];
            }else{
                temp[k++] = num[i++];
            }
        }
        while(i<=mid) temp[k++] = num[i++];
        while(j<=high) temp[k++] = num[j++];
        for(int z=low;z<=high;z++){
            num[z] = temp[z-low];
        }
    }
}
