import java.util.Scanner;
import java.util.Locale;

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double fee;

            switch (type) {
                case "STANDARD":
                    fee = 5 + 0.50 * weight
                            + 0.10 * distance;
                    break;

                case "EXPRESS":
                    fee = 15 + 1.00 * weight
                            + 0.20 * distance;
                    break;

                case "INTERNATIONAL":
                    double customsFee = sc.nextDouble();
                    fee = 25 + 2.00 * weight
                            + 0.50 * distance + customsFee;
                    break;

                default:
                    continue;
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
