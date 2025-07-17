//  좋은 단어

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;

        for (int i = 0; i < n; i++) { // 총 단어 개수
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) { // 단어 길이만큼 반복
                char c = line.charAt(j);
                if (stack.isEmpty()) {
                    stack.add(c);
                } else if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.add(c);
                }

            }
            if (stack.isEmpty()) {
                res++;
            }
        }
            System.out.println(res);
    }
}