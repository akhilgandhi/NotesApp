package com.notes.notesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    private String id;
    private String noteDescription;
    private LocalDateTime noteCreatedDate;
    private LocalDateTime noteUpdatedDate;
}
