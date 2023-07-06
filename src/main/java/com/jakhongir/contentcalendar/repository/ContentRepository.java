package com.jakhongir.contentcalendar.repository;

import com.jakhongir.contentcalendar.model.Content;
import com.jakhongir.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<String> findAllByTitleContains(String keyword);
    @Query("""
        SELECT * FROM Content
        where status =:status
    """)
    List<Content> listByStatus(@Param("status") Status status);
}
