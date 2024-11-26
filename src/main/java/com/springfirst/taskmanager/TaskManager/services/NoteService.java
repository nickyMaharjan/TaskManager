package com.springfirst.taskmanager.TaskManager.services;


import com.springfirst.taskmanager.TaskManager.entities.NoteEntity;
import com.springfirst.taskmanager.TaskManager.entities.TaskEntity;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NoteService {

    private TaskService taskService;
    private HashMap<Integer, TaskNoteHolder> taskNotesHolders = new HashMap<>();


    public NoteService(TaskService taskService) {
        this.taskService = taskService;
    }

    class TaskNoteHolder {
        protected int noteId = 1;
        protected ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getNoteforTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(taskNotesHolders.get(taskId)== null){
            taskNotesHolders.put(taskId, new TaskNoteHolder());
        }
        return taskNotesHolders.get(taskId).notes;
    }

    public NoteEntity addNoteforTask(int taskId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task==null){
            return null;
        }
        if(taskNotesHolders.get(taskId)== null){
            taskNotesHolders.put(taskId, new TaskNoteHolder());
        }
        TaskNoteHolder taskNotesHolder = taskNotesHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.noteId++;
        return note;
    }
}
