package kr.couchcoding.onlinememodemo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    Category category;

    @Column(length = 100)
    String name;

    @Column(columnDefinition = "TEXT")
    String content;

    @Builder
    public Memo(Long id, String name, String content, Category category){
        this.id = id;
        this.name = name;
        this.content = content;
        this.category = category;
    }

    public Memo() {

    }
}
