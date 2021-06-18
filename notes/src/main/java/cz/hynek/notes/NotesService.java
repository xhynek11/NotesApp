package cz.hynek.notes;

import cz.hynek.notes.note.Note;
import cz.hynek.notes.note.NoteRepository;
import cz.hynek.notes.todo.Todo;
import cz.hynek.notes.todo.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesService {
    private final NoteRepository noteRepository;
    private final TodoRepository todoRepository;


    public NotesService(NoteRepository noteRepository, TodoRepository todoRepository) {
        this.noteRepository = noteRepository;
        this.todoRepository = todoRepository;
    }

    public List<Note> getNotes(){
        return noteRepository.findNodesByCompleted();
    }

    public void addNewNote(String name, int version, String description, int priority, String deadline) {
        Note n1 = new Note(name,version);
        noteRepository.save(n1);
        todoRepository.save(new Todo(description,priority,LocalDateTime.parse(deadline),n1));
    }

    public List<Todo> getNote(Long noteId) {
        return todoRepository.findTodoById(noteId);
    }

    public void updateNotes(Long noteId, String name, Integer version,Boolean completed, String description, Integer priority, String deadline) {
        boolean exists = noteRepository.existsById(noteId);
        if(!exists){
            throw new IllegalStateException("employ with id " + noteId + " does not exists");
        }
        Note note = noteRepository.getById(noteId);
        Todo todo = todoRepository.getById(noteId);

        if(name!=null){
            note.setName(name);
        }
        if(version!=null){
            note.setVersion(version);
        }
        if(completed != null){
            note.setCompleted(completed);
        }
        if(description != null){
            todo.setDescription(description);
        }
        if(priority!=null){
            todo.setPriority(priority);
        }
        if(deadline != null){
            todo.setDeadline(LocalDateTime.parse(deadline));
        }
        noteRepository.save(note);
        todoRepository.save(todo);
    }
}
