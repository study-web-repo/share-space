package com.org.webrepo.sharespaceproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "name"),
        @Index(columnList = "category"),
        @Index(columnList = "location"),
        @Index(columnList = "hashtag"),
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter @Column(nullable = false) private String name;
    @Setter private String hashtag;

    @Setter @Column(nullable = false) private String category;
    @Setter @Column(nullable = false) private String location;
    @Setter @Column(nullable = false) private long price;
    @Setter @Column(nullable = false) private long people;
    @Setter @Column(nullable = false) private String imageURL;

    @OneToOne @JoinColumn(name = "contentId") private Content content;

    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL)
    private final Set<Review> review = new LinkedHashSet<>();

    protected Space() {
    }

    private Space(String name, String hashtag, String location, long price, long people, String imageURL, String category) {
        this.name = name;
        this.hashtag = hashtag;
        this.location = location;
        this.price = price;
        this.people = people;
        this.imageURL = imageURL;
        this.category = category;
    }

    public static Space of (String name, String hashtag, String location, long price, long people, String imageURL, String category) {
        return new Space(name, hashtag, location, price, people, imageURL,category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Space space)) return false;
        return id != null && id == space.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


