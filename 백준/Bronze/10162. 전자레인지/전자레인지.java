//  전자레인지

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        int a = 300, b = 60, c = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[3];
        
        arr[0] = t/ a;
        t %= a;
        
        arr[1] = t / b;
        t %= b;
        
        arr[2] = t / c;
        t %= c;
        
        if (t != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}