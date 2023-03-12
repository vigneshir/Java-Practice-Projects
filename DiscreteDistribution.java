/*

Write a program DiscreteDistribution.java that takes an integer command-line argument m, followed by a sequence of positive integer
command-line arguments a1,a2,…,an, and prints m random indices (separated by whitespace), choosing each index i with probability proportional to ai.

To generate a random index i with probability proportional to ai:
Define the cumulative sums Si=a1+a2+…+ai, with S0=0.
Pick a random integer r uniformly between 0 and Sn−1.
Find the unique index i between 1 and n such that Si−1≤r<Si.

Geometrically, this subdivides the interval [0,Sn) into n subintervals [Si−1,Si), with the length of subinterval i proportional to ai.
For example, if the discrete distribution is defined by
(a1,a2,a3,a4,a5,a6)=(10,10,10,10,10,50), then the cumulative sums are
(S1,S2,S3,S4,S5,S6)=(10,20,30,40,50,100)

*/

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
