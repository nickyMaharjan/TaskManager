package com.springfirst.taskmanager.TaskManager.DTO;

import com.springfirst.taskmanager.TaskManager.entities.NoteEntity;

public class CreateNoteResponseDTO {
    private Integer taskId;
    private NoteEntity note;

    public Integer getTaskId() {
        return taskId;
    }

    public CreateNoteResponseDTO(Integer taskId, NoteEntity note) {
        this.taskId = taskId;
        this.note = note;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public NoteEntity getNote() {
        return note;
    }

    public void setNote(NoteEntity note) {
        this.note = note;
    }

    public CreateNoteResponseDTO() {
    }
}
