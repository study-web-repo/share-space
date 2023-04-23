package com.org.webrepo.sharespaceproject.repository;

import com.org.webrepo.sharespaceproject.config.JpaConfig;
import com.org.webrepo.sharespaceproject.domain.Space;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    @Autowired final private SpaceRepository spaceRepository;

    @Autowired final private ContentRepository contentRepository;

    @Autowired final private ReviewRepository reviewRepository;

    public JpaRepositoryTest(
            @Autowired SpaceRepository spaceRepository,
            @Autowired ContentRepository contentRepository,
            @Autowired ReviewRepository reviewRepository
    ){
        this.spaceRepository = spaceRepository;
        this.contentRepository = contentRepository;
        this.reviewRepository = reviewRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_when_then(){
        //Given

        //When
        List<Space> spaces = spaceRepository.findAll();

        //Then
        assertThat(spaces)
                .isNotNull()
                .hasSize(1000);

    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine(){
        long previousCount = spaceRepository.count();
        Space savedSpace = spaceRepository.save(Space.of("hello2","","he",300,3,"wlkefn","efknef"));
        assertThat(spaceRepository.count()).isEqualTo(previousCount+1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        //Given
        Space space = spaceRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        space.setHashtag(updatedHashtag);
        //when
        Space savedSpace = spaceRepository.saveAndFlush(space);
        //then
        assertThat(savedSpace).hasFieldOrPropertyWithValue("hashtag",updatedHashtag);


    }
}