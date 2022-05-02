package com.leodev0.workshopmongo.services;

import com.leodev0.workshopmongo.domain.Post;
import com.leodev0.workshopmongo.repository.PostRepository;
import com.leodev0.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Post of id " + id + " not found");
        }
        return post.get();
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }
}
