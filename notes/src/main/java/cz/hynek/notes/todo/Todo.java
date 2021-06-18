package cz.hynek.notes.todo;

import cz.hynek.notes.note.Note;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @SequenceGenerator(
            name="todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;
    private String description;
    private int priority;

    public Todo(String description, int priority, LocalDateTime deadline, Note note) {
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.note = note;
    }

    @Column(nullable = false)
    private LocalDateTime deadline;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "note_id"
    )
    private Note note;
}
