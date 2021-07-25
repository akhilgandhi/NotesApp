package com.notes.notesapp.service;

import com.notes.notesapp.exception.NoteNotFoundException;
import com.notes.notesapp.model.Note;

import java.util.List;

public interface NoteService {

    Note getNote(String noteId) throws NoteNotFoundException;

    List<Note> getAllNotes();

    void saveNote(Note note);

    void updateNote(Note note);

    void deleteNote(String noteId);
}
