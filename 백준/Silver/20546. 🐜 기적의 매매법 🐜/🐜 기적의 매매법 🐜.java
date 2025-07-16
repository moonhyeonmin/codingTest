import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int[] price = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int jun_money = money, jun_stock = 0;
        int sung_money = money, sung_stock = 0;

        for (int i = 0; i < 14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
            
            // 준현이: 매일 살 수 있는 만큼 매수
            if (jun_money >= price[i]) {
                int buy = jun_money / price[i];
                jun_stock += buy;
                jun_money -= buy * price[i];
            }

            // 성민이: 3일 연속 전일 대비 상승/하락 확인 (4일째부터 가능)
            if (i >= 3) {
                // 3일 연속 상승 확인: (i-3 < i-2) && (i-2 < i-1) && (i-1 < i)
                boolean threeUp = (price[i-3] < price[i-2]) && 
                                  (price[i-2] < price[i-1]) && 
                                  (price[i-1] < price[i]);
                
                // 3일 연속 하락 확인: (i-3 > i-2) && (i-2 > i-1) && (i-1 > i)
                boolean threeDown = (price[i-3] > price[i-2]) && 
                                    (price[i-2] > price[i-1]) && 
                                    (price[i-1] > price[i]);
                
                // 3일 연속 상승 -> 전량 매도
                if (threeUp && sung_stock > 0) {
                    sung_money += sung_stock * price[i];
                    sung_stock = 0;
                }
                
                // 3일 연속 하락 -> 전량 매수
                if (threeDown && sung_money >= price[i]) {
                    int buy = sung_money / price[i];
                    sung_stock += buy;
                    sung_money -= buy * price[i];
                }
            }
        }

        // 최종 자산 계산
        int jun_total = jun_money + jun_stock * price[13];
        int sung_total = sung_money + sung_stock * price[13];

        if (jun_total > sung_total) {
            System.out.println("BNP");
        } else if (jun_total < sung_total) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}

/*
예제 1 분석:
가격: 10 20 23 34 55 30 22 19 12 45 23 44 34 38

전일 대비 변화:
1→2일: 10→20 (상승)
2→3일: 20→23 (상승)  
3→4일: 23→34 (상승) → 3일 연속 상승! 4일째에 매도
4→5일: 34→55 (상승)
5→6일: 55→30 (하락)
6→7일: 30→22 (하락)
7→8일: 22→19 (하락) → 3일 연속 하락! 8일째에 매수
8→9일: 19→12 (하락)
...

성민이는 4일째에 매도, 8일째에 매수가 예상됩니다.
*/