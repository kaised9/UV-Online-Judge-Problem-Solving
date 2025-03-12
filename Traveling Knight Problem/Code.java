import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int Xaxis[] = {2, 2, -2, -2, 1, -1, 1, -1};
    public static int Yaxis[] = {1, -1, 1, -1, 2, 2, -2, -2};
    public static int moves[][] = new int[8][8];
    public static boolean visited[][] = new boolean[8][8];
    public static String start, end;

    public static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void clearVisitedArray() {
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
    }

    public static void findMove(int a, int b, int c, int d) {
        Queue<Pair> q = new LinkedList<>();
        clearVisitedArray();

        q.add(new Pair(a, b));
        visited[a][b] = true;
        moves[a][b] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();

            if (p.x == c && p.y == d) {
                System.out.println("To get from " + start + " to " + end + " takes " + moves[p.x][p.y] + " knight moves.");
                return;
            }

            for (int i = 0; i < 8; i++) {
                int currentX = p.x + Xaxis[i];
                int currentY = p.y + Yaxis[i];

                if ((currentX >= 0 && currentX < 8) && (currentY >= 0 && currentY < 8) && !visited[currentX][currentY]) {
                    q.add(new Pair(currentX, currentY));
                    visited[currentX][currentY] = true;
                    moves[currentX][currentY] = moves[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String x = scanner.nextLine();
            String[] parts = x.split(" ");

            start = parts[0];
            end = parts[1];

            int StartCoordinateX = x.charAt(0) - 97,
                StartCoordinateY = x.charAt(1) - 49,
                EndCoordinateX = x.charAt(3) - 97,
                EndCoordinateY = x.charAt(4) - 49;

            findMove(StartCoordinateX, StartCoordinateY, EndCoordinateX, EndCoordinateY);
        }

        scanner.close();
    }
}
