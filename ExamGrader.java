import java.util.Scanner;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher matcher = pattern.matcher(line);
            String[] fields = new String[5];
            int index = 0;

            while (matcher.find() && index < 5) {
                fields[index++] = matcher.group(1) != null
                        ? matcher.group(1) : matcher.group(2);
            }

            if (index < 5) {
                continue;
            }

            String type = fields[0].toUpperCase();
            String correct = fields[2];
            String answer = fields[3];
            double points = Double.parseDouble(fields[4]);
            double score = 0;

            if (type.equals("MCQ") || type.equals("TF")) {
                if (answer.equals(correct)) {
                    score = points;
                }
            } else if (type.equals("ESSAY")) {
                String[] keywords = correct.split(",");
                int matches = 0;

                for (String keyword : keywords) {
                    if (answer.toLowerCase(Locale.ROOT)
                            .contains(keyword.trim()
                                    .toLowerCase(Locale.ROOT))) {
                        matches++;
                    }
                }

                if (matches >= 2) {
                    score = points * 0.75;
                } else if (matches == 1) {
                    score = points * 0.50;
                }
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, score);
            total += score;
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        sc.close();
    }
}
