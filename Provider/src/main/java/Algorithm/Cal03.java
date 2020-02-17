package Algorithm;
// 堆排序
public class Cal03 {
    public static void main(String args[]){
        int[] num = new int[]{1,56,7,15,27,39,41,15,25,42,24};
        sort(num);
        for(Integer i:num){
            System.out.print(i + " ,");
        }
    }
    private static void sort(int[] num){
        for(int i=num.length/2-1;i>=0;i--){
            build(num,i,num.length);
        }
        for(int i=num.length-1;i>0;i--){
            int temp = num[0];
            num[0]=num[i];
            num[i]=temp;
            build(num,0,i-1);
        }
    }
    private static void build(int[] num,int cur,int len){
        int temp =num[cur];
        int j=2*cur+1;
        for(;j<=len;){
            if(j<len&&num[j]<num[j+1]){
                j++;
            }
            if(num[j]>temp){
                num[cur] = num[j];
                cur = j;
            }else{
                break;
            }
            j=2*cur+1;
        }
        num[cur] = temp;
    }
}
