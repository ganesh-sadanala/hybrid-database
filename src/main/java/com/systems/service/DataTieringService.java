package com.systems.service;

import com.systems.model.Post;
import com.systems.model.PostMongo;
import com.systems.repo.PostMongoRepository;
import com.systems.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTieringService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMongoRepository postMongoRepository;

    // Method to analyze access patterns and move data between databases
    public void analyzeAndMoveData() {
        // Example: Move frequently accessed posts to MongoDB
        List<Post> frequentlyAccessedPosts = postRepository.findFrequentlyAccessedPosts();
        for (Post post : frequentlyAccessedPosts) {
            postMongoRepository.save(new PostMongo(post.getId(), post.getTitle(), post.getContent()));
            postRepository.delete(post);
        }
    }
}
