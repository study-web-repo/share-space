package com.org.webrepo.sharespaceproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private long space_id;
    @Setter private String imageUrl;
    @Setter @Column(nullable = false) private String content;

    @Setter @ManyToOne(optional = false) private Space space;

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt;    //생성일시
    @CreatedBy @Column(nullable = false) private String createdBy;    //생성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
    @LastModifiedBy @Column(nullable = false) private String modifiedBy;  // 수정자

    protected Review() {
    }

    private Review(Space space, String content) {
        this.content = content;
        this.space = space;
    }

    public static Review of(Space space, String content){
        return new Review(space, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;
        return id != null && id.equals(review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
