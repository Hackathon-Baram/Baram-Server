package com.hackathon.baram.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hackathon.baram.domain.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", unique = true, nullable = false)
    private Long idx;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post")
    @JsonBackReference
    private List<LikeEntity> likeEntities = new ArrayList<>();

    public PostEntity(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }
}
