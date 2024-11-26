package com.springfirst.taskmanager.TaskManager.DTO;

import com.springfirst.taskmanager.TaskManager.entities.NoteEntity;

import java.util.Date;
import java.util.List;

public class TaskResponseDTO {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean status;

    public TaskResponseDTO() {
    }

    public List<NoteEntity> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteEntity> notes) {
        this.notes = notes;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<NoteEntity> notes;
}
