//  비밀번호 발음하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();

            if (input.equals("end")) {
                break;
            }

            boolean isValid = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == 'a' || c == 'e' || c =='o' || c == 'u' || c == 'i') {
                    isValid = true;
                }

                if (i > 0 && input.charAt(i) == input.charAt(i - 1) && c != 'e' && c != 'o') {
                    isValid = false;
                    break;
                }

                if (i > 1 && (checkVowel(input.charAt(i)) && checkVowel(input.charAt(i - 1)) && checkVowel(input.charAt(i - 2)))) {
                    isValid = false;
                    break;
                }

                if (i > 1 && (!checkVowel(input.charAt(i)) && !checkVowel(input.charAt(i - 1)) && !checkVowel(input.charAt(i - 2)))) {
                    isValid = false;
                    break;
                }

            }
            if (isValid) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }

    static boolean checkVowel(char c) {
        if (c =='a' || c == 'e' || c == 'o' || c == 'u' || c == 'i') {
            return true;
        }

        return false;
    }
}