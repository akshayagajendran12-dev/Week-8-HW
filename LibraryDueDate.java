import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');

            String type = line.substring(0, space).toUpperCase();
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            int days;

            switch (type) {
                case "BOOK":
                    days = 14;
                    break;
                case "DVD":
                    days = 7;
                    break;
                case "MAGAZINE":
                    days = 3;
                    break;
                default:
                    continue;
            }

            LocalDate dueDate = currentDate.plusDays(days);
            System.out.println(title + ": " +
                    dueDate.format(formatter));
        }

        sc.close();
    }
}
