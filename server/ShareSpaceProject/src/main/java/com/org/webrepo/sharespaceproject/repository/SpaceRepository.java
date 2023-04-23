package com.org.webrepo.sharespaceproject.repository;

import com.org.webrepo.sharespaceproject.domain.Space;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceRepository extends JpaRepository<Space, Long> {
}