import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    private List<Task> list;
    private static final String FILE = "tasks.txt";

    public TaskManager() {
        list = new ArrayList<>();
        load();
    }

    public void add(String title, String desc, LocalDate date, int pr) {
        int id = list.size() + 1;
        list.add(new Task(id, title, desc, date, pr));
        save();
    }

    public void edit(int id, String title, String desc, LocalDate date, int pr) {
        for (Task t : list) {
            if (t.getId() == id) {
                t.setTitle(title);
                t.setDesc(desc);
                t.setDate(date);
                t.setPriority(pr);
                save();
                return;
            }
        }
        System.out.println("Задача с таким ID не найдена!");
    }

    public void delete(int id) {
        list.removeIf(t -> t.getId() == id);
        save();
    }

    public void complete(int id) {
        for (Task t : list) {
            if (t.getId() == id) {
                t.setDone(true);
                save();
                return;
            }
        }
        System.out.println("Задача с таким ID не найдена!");
    }

    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            list.forEach(System.out::println);
        }
    }

    public void sortByDate() {
        list.sort(Comparator.comparing(Task::getDate));
        list.forEach(System.out::println);
    }

    public void find(String word) {
        list.stream()
                .filter(t -> t.getTitle().toLowerCase().contains(word.toLowerCase())
                        || t.getDesc().toLowerCase().contains(word.toLowerCase()))
                .forEach(System.out::println);
    }

    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void load() {
        File f = new File(FILE);
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
            list = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
        }
    }
}
