package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created By dhhaval thakkar on 2023-10-24
 */
@Slf4j
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

   /* @Autowired
    private CourseJdbcRepository repository;*/

    /*@Autowired
    private CourseJpaRepository repository;*/

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS Now!", "in28minutes"));
        repository.save(new Course(2, "Learn Azure Now!", "in28minutes"));
        repository.save(new Course(3, "Learn GCP Now!", "in28minutes"));

        repository.deleteById(3L);

        log.info(String.valueOf(repository.findById(1L)));
        log.info(String.valueOf(repository.findById(2L)));
        log.info("===");

        log.info(repository.findAll().toString());
        log.info(String.valueOf(repository.count()));
        log.info("===");

        log.info(String.valueOf(repository.findByAuthor("in28minutes")));
        log.info(String.valueOf(repository.findByAuthor("")));
        log.info("===");

        log.info(String.valueOf(repository.findByName("Learn AWS Now!")));
        log.info(String.valueOf(repository.findByName("Learn Azure Now!")));
        log.info("===");

    }
}
