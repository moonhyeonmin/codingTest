//  🐜 기적의 매매법 🐜

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int[] price = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int jun_money = money, jun_stock = 0, jun_res;
        int sung_money = money, sung_stock = 0, sung_res;

        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            if (jun_money >= price[i]) {
                int buy = jun_money / price[i];
                jun_stock += buy;
                jun_money -= buy * price[i];
            }

            if (i >= 3) {
                if ((price[i - 3] > price[i - 2]) && (price[i - 2] > price[i - 1]) && (price[i - 1] > price[i])) { // 3일 연속 하락
                    int buy = sung_money / price[i];
                    sung_stock += buy;
                    sung_money -= buy * price[i];
                }

                if ((price[i - 3] < price[i - 2]) && (price[i - 2] < price[i - 1]) && (price[i - 1] < price[i])) { // 3일 연속 상승
                    sung_money += sung_stock * price[i];
                    sung_stock = 0;
                }
            }
        }

        jun_res = jun_money + jun_stock * price[13];
        sung_res = sung_money + sung_stock * price[13];


        if (jun_res > sung_res) {
            System.out.println("BNP");
        } else if (jun_res < sung_res) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}