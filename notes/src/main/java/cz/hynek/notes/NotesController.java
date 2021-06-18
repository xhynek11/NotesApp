package cz.hynek.notes;

import cz.hynek.notes.note.Note;
import cz.hynek.notes.todo.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "currentnote")
public class NotesController {

    private final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping(path = "{noteId}")
    public List<Todo> getNote(@PathVariable("noteId") Long noteId){
        return notesService.getNote(noteId);
    }

    @GetMapping
    public List<Note> getNotes(){
        return notesService.getNotes();
    }

    @PostMapping
    public void setNote(
            @RequestParam String name,
            @RequestParam int version,
            @RequestParam String description,
            @RequestParam int priority,
            @RequestParam String deadline){

        notesService.addNewNote(name,version,description,priority,deadline);
    }
    @PutMapping(path = "{noteId}")
    public void updateNote(
            @PathVariable("noteId") Long noteId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer version,
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer priority,
            @RequestParam(required = false) String deadline){

        notesService.updateNotes(noteId,name,version,completed,description,priority,deadline);
    }

}
