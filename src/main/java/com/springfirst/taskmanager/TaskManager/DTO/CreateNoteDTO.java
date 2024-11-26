package com.springfirst.taskmanager.TaskManager.DTO;

public class CreateNoteDTO {
    String title;
    String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public CreateNoteDTO() {
    }
}
