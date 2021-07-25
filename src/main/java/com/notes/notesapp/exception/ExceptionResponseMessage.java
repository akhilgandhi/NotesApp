package com.notes.notesapp.exception;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ExceptionResponseMessage {

    private String message;
}
