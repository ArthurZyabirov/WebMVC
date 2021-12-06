package ru.netology.repository;

import ru.netology.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
  final private Map<Long, Post> map = new ConcurrentHashMap<>();
  final private AtomicLong idLong = new AtomicLong(0);

  public Map<Long, Post> all() {
    return map;
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(map.get(id));
  }

  public Post save(Post post) {
    if (map.containsKey(post.getId())) {
      map.put(post.getId(), post);
    } else if (post.getId() == 0) {
      long newId = idLong.incrementAndGet();
      map.put(newId, post);
    }
    return post;
  }

  public void removeById(long id) {
    map.remove(id);
  }
}
