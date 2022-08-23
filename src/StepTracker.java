import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    int[][] monthToData = new int[12][30];
    int goalBySteps = 10000;

    void printStat(int numberOfMonth) {
        int sum = 0;
        int max = monthToData[0][0];
        int currentSeries = 0;
        int bestSeries = 0;
        Converter converter = new Converter();

        for (int i = 0; i < monthToData[numberOfMonth].length; i++) {
            System.out.print(i + 1 + " день: " + monthToData[numberOfMonth - 1][i] + ", ");//печать шагов по дням
        }
        System.out.println();
        for (int i = 0; i < monthToData[numberOfMonth].length; i++) {//считаем сумму шагов за месяц
            sum += monthToData[numberOfMonth - 1][i];
        }
        for (int i = 0; i < monthToData[numberOfMonth].length; i++) {//поиск максимума по пройденным за один день
            if (max < monthToData[numberOfMonth - 1][i]) {
                max = monthToData[numberOfMonth - 1][i];
            }
        }
        for (int i = 0; i < monthToData[numberOfMonth].length; i++) {//поиск лучшей серии по достижению цели
            if (monthToData[numberOfMonth - 1][i] >= goalBySteps) {
                currentSeries++;
            } else {
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                } else {
                    currentSeries = 0;
                }
            }
        }// печатаем статистику
        System.out.println("Общее количество шагов за месяц: " + sum);
        System.out.println("Максимальное пройденное количество шагов за один день: " + max);
        System.out.println("Среднее количество шагов в день: " + sum / 30);
        System.out.println("Пройденная дистанция: " + converter.getKilometers(sum) + " км");
        System.out.println("Количество сожжённых килокалорий: " + converter.getKilocalories(sum));
        System.out.println("Достигли цели дней подряд: " + bestSeries);

    }

    void setSteps(int numberOfMonth, int numberOfDay, int steps) {
        if (steps > 0) {
            monthToData[numberOfMonth - 1][numberOfDay - 1] = steps;
            System.out.println("Значение сохранено");
        } else if (steps <= 0) {
            System.out.println("Значение не может быть ноль или отрицательным");
        }
    }

    void setGoalBySteps() {
        System.out.println("Введите новую цель по колчеству шагов в день: ");
        if (goalBySteps > 0) {
            goalBySteps = scanner.nextInt();
            System.out.println("Ваша новая цель: " + goalBySteps + " шагов в день.");
        } else if (goalBySteps <= 0) {
            System.out.println("Значение не может быть ноль или отрицательным");
        }
    }
}

