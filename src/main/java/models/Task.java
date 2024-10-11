package models;

import lombok.Setter;

public class Task {

    @Setter
    private int id;
    @Setter
    private String description;
    @Setter
    private boolean completed;
    @Setter
    private int userId;

    public Task(int id, String description, boolean completed, int userId) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
