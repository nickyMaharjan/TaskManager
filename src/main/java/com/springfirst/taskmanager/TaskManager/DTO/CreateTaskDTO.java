package com.springfirst.taskmanager.TaskManager.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateTaskDTO {
    private String title;
    private String description;
    private String deadline;

    public CreateTaskDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
