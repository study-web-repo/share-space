package com.org.webrepo.sharespaceproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "reserveDate"),
        @Index(columnList = "closedDays")
})
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter @Column(nullable = false) private String content;
    @Setter @Column(nullable = false) private int openingHour;
    @Setter @Column(nullable = false) private String closedDays;
    @Setter @Column(nullable = false) private String notice;
    @Setter @Column(nullable = false) private String refundPolicy;
    @CreatedBy @Column(nullable = false) private String createdBy;
    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt;
    @Setter @Column(nullable = false) private String facilityInformation;
    @Setter @Column(nullable = false) private LocalDateTime reserveDate;

    protected Content() {
    }

    private Content(String content, int openingHour, String closedDays, String notice, String refundPolicy, String facilityInformation, LocalDateTime reserveDate) {
        this.content = content;
        this.openingHour = openingHour;
        this.closedDays = closedDays;
        this.notice = notice;
        this.refundPolicy = refundPolicy;
        this.facilityInformation = facilityInformation;
        this.reserveDate = reserveDate;
    }

    public static Content of(String content, int openingHour, String closedDays, String notice, String refundPolicy, String facilityInformation, LocalDateTime reserveDate){
        return new Content(content, openingHour, closedDays, notice, refundPolicy, facilityInformation, reserveDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content content)) return false;
        return id != null && Objects.equals(id, content.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
