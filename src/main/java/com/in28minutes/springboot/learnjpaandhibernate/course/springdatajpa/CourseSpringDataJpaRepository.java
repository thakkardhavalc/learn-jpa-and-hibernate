package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created By dhhaval thakkar on 2023-10-24
 */
@Repository
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
