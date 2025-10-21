import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private int id;
    private String title;
    private String desc;
    private LocalDate date;
    private int priority;
    private boolean done;

    public Task(int id, String title, String desc, LocalDate date, int priority) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.priority = priority;
        this.done = false;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDesc() {
        return desc;
    }
    public LocalDate getDate() {
        return date;
    }
    public int getPriority() {
        return priority; 
    }
    public boolean isDone() {
        return done;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | Срок: %s | Приоритет: %d | Статус: %s",
                id, title, desc, date, priority, done ? " Выполнена" : " В процессе");
    }
}

