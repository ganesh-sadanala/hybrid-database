package com.systems.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class PostMongo {
    @Id
    private String id;

    private String title;
    private String content;
}
