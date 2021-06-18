package cz.hynek.notes.note;

import cz.hynek.notes.todo.Todo;
import cz.hynek.notes.todo.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class NoteConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoteRepository noteRepository, TodoRepository todoRepository){
      return args -> {
          Note n1 = new Note(
                "Complete Note Project",
                1,
                  true
          );
          Note n2 = new Note(
                  "Plan Holidays",
                  1
          );
          Note n3 = new Note(
                  "Gain 5 kilos",
                  1
          );
          Todo t1 = new Todo(
                  "Finish Note Project, and upload it to github",
                  9,
                  LocalDateTime.of(2021, Month.SEPTEMBER,15,0,0),
                  n1
          );
          Todo t2 = new Todo(
                  "Plan road trip to Austria",
                  7,
                  LocalDateTime.of(2021, Month.JULY,31,0,0),
                  n2
          );
          Todo t3 = new Todo(
                  "Eat more healthy and gain 5 kilograms of muscles",
                  8,
                  LocalDateTime.of(2021, Month.JUNE,30,0,0),
                  n3
          );

        noteRepository.saveAll(List.of(n1,n2,n3));
        todoRepository.saveAll(List.of(t1,t2,t3));
      };
    }


}
