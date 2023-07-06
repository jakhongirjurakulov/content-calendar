package com.jakhongir.contentcalendar.repository;

import com.jakhongir.contentcalendar.model.Content;
import com.jakhongir.contentcalendar.model.Status;
import com.jakhongir.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    public void update(Content content) {
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content c = new Content(
                1,
                "My First Blog Post",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(c);
    }

    public boolean existsById(Integer id) {
        var result = contentList.stream().filter(c -> c.id().equals(id)).count();
        result = 1L;
        return longToBoolean(result);
    }

    public static boolean longToBoolean(long l) {
        return l != 0 ? true : false;
    }

    public void deleteById(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }
}
