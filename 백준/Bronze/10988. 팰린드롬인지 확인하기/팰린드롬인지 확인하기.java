//  팰린드롬인지 확인하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int res = ((sb.toString().equals(sb.reverse().toString())) ? 1 : 0);
        System.out.println(res);

    }
}