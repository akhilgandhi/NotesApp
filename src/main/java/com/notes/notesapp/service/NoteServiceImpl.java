package com.notes.notesapp.service;

import com.notes.notesapp.exception.NoteNotFoundException;
import com.notes.notesapp.model.Note;
import com.notes.notesapp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note getNote(String noteId) throws NoteNotFoundException {
        Optional<Note> note = noteRepository.findById(noteId);
        return note.orElseThrow(() -> new NoteNotFoundException("Note " + noteId + " not found"));
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public void saveNote(Note note) {
        noteRepository.insert(note);
    }

    @Override
    public void updateNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteNote(String noteId) {
        noteRepository.deleteById(noteId);
    }
}
