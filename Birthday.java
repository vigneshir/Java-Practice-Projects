public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // no. of days in sample space
        long trials = (long) Integer.parseInt(args[1]); // no. of test cases

        long[] freqCases = new long[n+1]; // no. of cases where i+1 th person caused repeat

        for (int trialNum = 0; trialNum < trials; trialNum++) {
            boolean[] presentDays = new boolean[n];
            int newDay, i = 0; // no. of persons entered (1 <= i <= n+1)
            boolean flag = true;
            while (flag) {
                newDay = (int) (Math.random() * n);
                if (presentDays[newDay]) flag = false;
                else presentDays[newDay] = true;
                i++;
            }
            freqCases[i-1]++;
        }

        double fraction = 0.0;
        for (int caseType = 1; fraction < 0.5; caseType++) {
            long sum = 0;
            for (int temp = 0; temp < caseType; temp++) {
                sum += freqCases[temp];
            }
            fraction = (double) sum / trials;
            // System.out.printf("%-7ld %-7ld %f\n", caseType, freqCases[caseType-1], fraction);
            System.out.println(caseType + "  " + freqCases[caseType-1] + "  " + fraction);
        }
    }
}