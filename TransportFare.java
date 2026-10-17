import java.util.Scanner;
import java.util.Locale;

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            double fare;

            switch (type) {
                case "BUS":
                    fare = Math.min(2 + 0.10 * distance, 10);
                    break;

                case "TRAIN":
                    fare = 3 + 0.15 * distance;
                    break;

                case "METRO":
                    double peakHourFactor = sc.nextDouble();
                    fare = (1.50 + 0.20 * distance)
                            * peakHourFactor;
                    break;

                default:
                    continue;
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
