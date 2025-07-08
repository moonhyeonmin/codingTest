//  카약

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] rank = new int[9];
        int[] distance = new int[9];

        char[][] arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = C - 1; j >= 0; j--) {
                if (arr[i][j] >= '1' && arr[i][j] <= '9') {
                    int team = arr[i][j] - '0';
                    distance[team - 1] = C - 1- j;
                    break;
                }
            }
        }

        Integer[] sortedDistances = new Integer[9];
        for (int i = 0; i < 9; i++) {
            sortedDistances[i] = distance[i];
        }
        Arrays.sort(sortedDistances);

        // 각 팀의 등수 계산
        for (int i = 0; i < 9; i++) {
            int myDistance = distance[i];
            int currentRank = 1;

            // 나보다 가까운 거리가 몇 개의 서로 다른 값인지 세기
            Set<Integer> betterDistances = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (distance[j] < myDistance) {
                    betterDistances.add(distance[j]);
                }
            }

            rank[i] = betterDistances.size() + 1;
        }



        for (int i = 0; i < 9; i++) {
            System.out.println(rank[i]);
        }
    }
}