package com.springfirst.taskmanager.TaskManager.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
    private String title;
    private String description;
    private String deadline;
}
