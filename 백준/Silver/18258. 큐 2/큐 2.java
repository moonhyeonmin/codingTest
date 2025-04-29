//  큐 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static ArrayDeque<Integer> queue = new ArrayDeque<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int tmp = Integer.parseInt(st.nextToken());
                queue.offer(tmp);
            } else if (command.equals("pop")) {
                if (queue.isEmpty())
                    sb.append(-1).append('\n');
                else {
                    sb.append(queue.poll()).append('\n');
                }
            } else if (command.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("front")) {
                if (queue.isEmpty())
                    sb.append(-1).append('\n');
                else
                    sb.append(queue.peek()).append('\n');
            } else if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(queue.peekLast()).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}