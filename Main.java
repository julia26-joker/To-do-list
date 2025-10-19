import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager m = new TaskManager();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Показать все задачи");
            System.out.println("2. Добавить задачу");
            System.out.println("3. Редактировать задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Отметить как выполненную");
            System.out.println("6. Сортировать по дате");
            System.out.println("7. Поиск по слову");
            System.out.println("0. Выйти");
            System.out.print("Выберите действие: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> m.showAll();
                case 2 -> {
                    System.out.print("Название: ");
                    String title = sc.nextLine();
                    System.out.print("Описание: ");
                    String desc = sc.nextLine();
                    System.out.print("Срок (гггг-мм-дд): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    System.out.print("Приоритет (1-5): ");
                    int pr = sc.nextInt();
                    m.add(title, desc, date, pr);
                }
                case 3 -> {
                    System.out.print("ID задачи: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Новое название: ");
                    String title = sc.nextLine();
                    System.out.print("Новое описание: ");
                    String desc = sc.nextLine();
                    System.out.print("Новая дата (гггг-мм-дд): ");
                    LocalDate date = LocalDate.parse(sc.nextLine());
                    System.out.print("Новый приоритет (1-5): ");
                    int pr = sc.nextInt();
                    m.edit(id, title, desc, date, pr);
                }
                case 4 -> {
                    System.out.print("ID задачи: ");
                    int id = sc.nextInt();
                    m.delete(id);
                }
                case 5 -> {
                    System.out.print("ID задачи: ");
                    int id = sc.nextInt();
                    m.complete(id);
                }
                case 6 -> m.sortByDate();
                case 7 -> {
                    System.out.print("Введите слово: ");
                    String w = sc.nextLine();
                    m.find(w);
                }
                case 0 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }
}
