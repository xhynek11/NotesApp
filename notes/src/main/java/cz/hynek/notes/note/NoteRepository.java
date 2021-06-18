package cz.hynek.notes.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT s FROM Note s WHERE s.id = ?1")
    List<Note> findNodeById(Long id);

    @Query("SELECT s FROM Note s WHERE s.completed=false")
    List<Note> findNodesByCompleted();
}
