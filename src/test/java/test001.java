import java.util.Arrays;

public class test001 {
    public static void main(String[] args) {

    int [] arr = {4,1,2,5,6,3};
        insertSort(arr);
    }


//1. 直接插入排序
public static void insertSort(int[] array) {
    for (int i = 1; i < array.length; i++) {             //{4,1,2,5,6,3}
        int temp = array[i];//1
        int j = i - 1;//0
        for (; j >= 0 && array[j] > temp; j--) {
        //将大于temp的值整体后移一个单位
        array[j + 1] = array[j];
        System.out.println("sss    "+Arrays.toString(array));
        //{4,4,2,5,6,3}
        }
        array[j + 1] = temp;
    }
    System.out.println(Arrays.toString(array) + " insertSort");
    }
}
