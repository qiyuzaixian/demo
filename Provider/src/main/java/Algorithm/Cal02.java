package Algorithm;

// 快速排序
public class Cal02 {
    public static void main(String args[]){
        int[] num = new int[]{1,56,7,15,27,39,41,15,25,42,24};
        sort(0,num.length-1,num);
        for(Integer i:num){
            System.out.print(i + " ,");
        }
    }
    private static  void sort(int low,int high,int[] num){
        int l =low;
        int h = high;
        int key  = num[h];
        while(l<h){
            while(num[l]<=key&&l<h) l++;
            if(num[l]>key){
                int temp = num[l];
                num[l] = num[h];
                num[h] = temp;
            }
            while(num[h]>=key&&l<h) h--;
            if(num[h]<key){
                int temp = num[l];
                num[l] = num[h];
                num[h] = temp;
            }
        }
        if(low<l) sort(low,l-1,num);
        if(h<high) sort(h+1,high,num);
    }
}
