public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '0';
            }
        }

        int[] minePos = new int[k];
        int count = 0;
        while (count < k) {
            int pos = (int) (Math.random() * (m * n));
            if (grid[pos / n][pos % n] != '*') {
                grid[pos / n][pos % n] = '*';
                minePos[count++] = pos;
            }
        }

        for (int i = 0; i < k; i++) {
            int pr = minePos[i] / n - 1;
            int pc = minePos[i] % n - 1;
            int nr = minePos[i] / n + 1;
            int nc = minePos[i] % n + 1;
            for (int p = pr; p <= nr; p++) {
                for (int q = pc; q <= nc; q++) {
                    if (!((p == -1 || p == m || q == -1 || q == n) || (p == pr + 1 && q == pc + 1))) {
                        if (grid[p][q] != '*') grid[p][q]++;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
