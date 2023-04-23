package com.org.webrepo.sharespaceproject.repository;

import com.org.webrepo.sharespaceproject.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content,Long> {
}
