package cz.hynek.notes.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {

    Optional<Todo> findById(Long id);

    @Query("SELECT s FROM Todo s WHERE s.id = ?1")
    List<Todo> findTodoById(Long id);
}
