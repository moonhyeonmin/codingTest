//  곱셈

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int origin = num2;
        List<Integer> num = new ArrayList<>();
        while (num2 > 0) {
            num.add(num2 % 10);
            num2 /= 10;
        }

        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            System.out.println(num1 * num.get(i));
        }
        System.out.println(num1 * origin);
    }
}