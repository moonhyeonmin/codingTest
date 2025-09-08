
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        arr = new int[8][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        int king_y = king.charAt(0) - 'A';
        int king_x = king.charAt(1) - '0' - 1;
        arr[king_x][king_y] = 1; // 왕 == 1

        String stone = st.nextToken();
        int stone_y = stone.charAt(0) - 'A';
        int stone_x = stone.charAt(1) - '0' - 1;
        arr[stone_x][stone_y] = 2; // 돌 == 2
        int n = Integer.parseInt(st.nextToken());
        String[] move = new String[n];


        for (int i = 0; i < n; i++) {
            move[i] = br.readLine();
            int width = 0;
            int height = 0;
            if (move[i].contains("R")) {
                width++;
            } else if (move[i].contains("L")) {
                width--;
            }

            if (move[i].contains("B")) {
                height--;
            } else if (move[i].contains("T")) {
                height++;
            }

            if (king_x + height >= 8 || king_y + width >= 8 || king_x + height < 0 || king_y + width < 0) {
                continue;
            }

            if (king_x + height == stone_x && king_y + width == stone_y) {
                if (stone_x + height >= 8 || stone_y + width >= 8 || stone_x + height < 0 || stone_y + width < 0) {
                    continue;
                }
                stone_x += height;
                stone_y += width;
                king_x += height;
                king_y += width;
            } else {
                king_x += height;
                king_y += width;
            }
        }

        System.out.println((char)(king_y + 'A') + "" + (king_x + 1));
        System.out.println((char)(stone_y + 'A') + "" + (stone_x + 1));
    }
}