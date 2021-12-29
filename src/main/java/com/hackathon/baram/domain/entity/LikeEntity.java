package com.hackathon.baram.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Getter
@NoArgsConstructor
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", unique = true, nullable = false)
    private Long idx;

    @Column(name = "author", nullable = false)
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostEntity post;

    public LikeEntity(String author, PostEntity postEntity) {
        this.author = author;
        this.post = postEntity;
    }
}