package com.hackathon.baram.domain.entity;

import com.dgsw.baram.domain.dto.PostDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
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

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<LikeEntity> likeEntities = new ArrayList<>();

    public PostEntity(PostDto postDto) {
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }
}
