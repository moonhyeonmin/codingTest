//  일곱 난쟁이

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> res = new ArrayList<>();
        int[] people = new int[9];
        for (int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += people[i];
        }

        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - people[i] - people[j] == 100) {
                    idx1 = i;
                    idx2 = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != idx1 && i != idx2) {
                res.add(people[i]);
            }
        }

        Collections.sort(res);


        for (int i : res) {
            System.out.println(i);
        }
    }
}