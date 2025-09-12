import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);


    }

    static void bfs(int root) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(root);
        parent[root] = root;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i : tree[curr]) {
                if (parent[i] == 0) {
                    parent[i] = curr;
                    queue.offer(i);
            }

            }
        }
    }
}