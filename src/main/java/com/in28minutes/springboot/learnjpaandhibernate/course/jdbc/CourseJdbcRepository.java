package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created By dhhaval thakkar on 2023-10-24
 */
@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY =
            """
                insert into course (id, name, author)
                values(?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
                delete from course where id=?;
            """;

    private static final String SELECT_QUERY =
            """
                select * from course where id=?;
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        // ResultSet to Bean Mapping -> Row Mapper
        return jdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }
}
