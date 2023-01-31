package com.org.webrepo.sharespaceproject.domain;

import java.time.LocalDateTime;

public class Review {

    private long id;
    private long space_id;
    private String imageUrl;
    private String conent;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;


}
