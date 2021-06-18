package cz.hynek.notes.note;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository=noteRepository;
    }
}
