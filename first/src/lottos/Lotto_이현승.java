package lottos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lotto_이현승 {

    public static void main(String[] args) {
        System.out.print("제 777회 로또 번호: ");
        int[] a = new int[6];
        Set<Integer> arrysSet = new HashSet<>();

        while (arrysSet.size() < 6) {
            int arrys = (int) (Math.random() * 45) + 1;
            arrysSet.add(arrys);
        }

        int i = 0;
        for (int num : arrysSet) {
            a[i++] = num;
        }

        Arrays.sort(a);
        System.out.print(Arrays.toString(a));

        int b;
            b = (int) (Math.random() * 45) + 1;
   
        System.out.println(" + [ 보너스 번호: " + b + " ]");
    }
}