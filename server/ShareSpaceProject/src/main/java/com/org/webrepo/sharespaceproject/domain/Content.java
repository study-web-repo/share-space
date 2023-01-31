package com.org.webrepo.sharespaceproject.domain;

import java.time.LocalDateTime;

public class Content {
    private long spaceId;
    private long id;
    private String content;
    private int openingHour;
    private String closedDays;
    private String notice;
    private String refundPolicy;
    private String createdBy;
    private String facilityInformation;

    private LocalDateTime reserveDate;

}
