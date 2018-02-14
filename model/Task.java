package sample.model;

public class Task {

    private long date_created;
    private String description;
    private String task;

    public Task(){
    }

    public Task(long date_created, String description, String task) {
        this.date_created = date_created;
        this.description = description;
        this.task = task;
    }

    public long getDate_created() {
        return date_created;
    }

    public void setDate_created(long date_created) {
        this.date_created = date_created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
