package com.springfirst.taskmanager.TaskManager.controllers;

import com.springfirst.taskmanager.TaskManager.DTO.CreateNoteDTO;
import com.springfirst.taskmanager.TaskManager.DTO.CreateNoteResponseDTO;
import com.springfirst.taskmanager.TaskManager.entities.NoteEntity;
import com.springfirst.taskmanager.TaskManager.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NoteController {
    NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
        var note = noteService.getNoteforTask(taskId);

        return ResponseEntity.ok(note);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponseDTO> addNotes(
            @PathVariable("taskId") Integer taskId,
            @RequestBody CreateNoteDTO body
            ){
        var note = noteService.addNoteforTask(taskId, body.getTitle(),body.getBody());
        return ResponseEntity.ok(new CreateNoteResponseDTO(taskId,note));
    }

}
