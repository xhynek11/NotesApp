package cz.hynek.notes.note;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class Note {

    @Id
    @SequenceGenerator(
            name="note_sequence",
            sequenceName = "note_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "note_sequence"
    )
    private Long id;
    private String name;
    private Integer version;
    @Column(nullable = false)
    private boolean completed;

    public Note() {
        this.completed=false;
    }

    public Note(String name, Integer version) {
        this.name = name;
        this.version = version;
        this.completed=false;
    }

    public Note(String name, Integer version, boolean completed) {
        this.name = name;
        this.version = version;
        this.completed = completed;
    }
}
