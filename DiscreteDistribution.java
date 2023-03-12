public class DiscreteDistribution {
    public static void main(String[] args) {
        long m = (long) Integer.parseInt(args[0]);
        int n = args.length - 1;
        long[] s = new long[n + 1];
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i-1] + Integer.parseInt(args[i]);
        }
        for (long count = 0; count < m; count++) {
            long r = (long) (Math.random() * s[n]);
            int i = 1;
            while (!(r >= s[i - 1] && r < s[i])) {
                i++;
            }
            System.out.print(i + " ");
        }
    }
}
