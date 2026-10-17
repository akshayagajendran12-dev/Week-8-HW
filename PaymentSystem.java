import java.util.Scanner;
import java.util.Locale;

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();
            double adjusted;

            switch (type) {
                case "CARD":
                    adjusted = amount * 1.02;
                    break;
                case "WALLET":
                    adjusted = amount * 1.01;
                    break;
                case "BANKTRANSFER":
                    adjusted = amount;
                    break;
                default:
                    continue;
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, adjusted);
            total += adjusted;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
        sc.close();
    }
}
