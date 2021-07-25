package com.notes.notesapp.controller;

import com.notes.notesapp.exception.NoteNotFoundException;
import com.notes.notesapp.model.Note;
import com.notes.notesapp.model.NoteDto;
import com.notes.notesapp.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping(path = "/note")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNote(@RequestBody NoteDto noteDto) {
        Note newNote = new Note();
        newNote.setNoteDescription(noteDto.getNoteDescription());
        newNote.setNoteCreatedDate(LocalDateTime.now());
        newNote.setNoteUpdatedDate(LocalDateTime.now());
        noteService.saveNote(newNote);
    }

    @GetMapping(path = "/note/{noteId}")
    public Note getNote(@PathVariable("noteId") String noteId) throws NoteNotFoundException {
        return noteService.getNote(noteId);
    }

    @GetMapping(path = "/note")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PutMapping(path = "/note/{noteId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateNote(@PathVariable("noteId") String noteId,
                           @RequestBody NoteDto noteDto) throws NoteNotFoundException {
        Optional<Note> oldNote = Optional.ofNullable(noteService.getNote(noteId));
        if (oldNote.isPresent()) {
            Note newNote = oldNote.get();
            newNote.setNoteUpdatedDate(LocalDateTime.now());
            newNote.setNoteDescription(noteDto.getNoteDescription());
            noteService.updateNote(newNote);
        }
    }

    @DeleteMapping(path = "/note/{noteId}")
    public void deleteNote(@PathVariable("noteId") String noteId) throws NoteNotFoundException {
        noteService.deleteNote(noteId);
    }
}
