import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите номер месяца(от 1 до 12): ");
                int numberOfMonth = scanner.nextInt();
                System.out.println("Введите номер дня(от 1 до 30): ");
                int numberOfDay = scanner.nextInt();
                System.out.println("Введите количество шагов за день: ");
                int steps = scanner.nextInt();
                stepTracker.setSteps(numberOfMonth, numberOfDay, steps);
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца(от 1 до 12): ");
                int numberOfMonth = scanner.nextInt();
                stepTracker.printStat(numberOfMonth);
            } else if (userInput == 3) {
                stepTracker.setGoalBySteps();
            } else if (userInput == 0) {
                System.out.println("Выход из программы");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }
    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
