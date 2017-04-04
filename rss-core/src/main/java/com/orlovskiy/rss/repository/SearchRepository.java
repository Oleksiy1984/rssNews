package com.orlovskiy.rss.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orlovskiy.rss.entity.RssFeedEntryEntity;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<RssFeedEntryEntity, Long> {
    List<RssFeedEntryEntity> findByTitleContaining(String title, Sort sort);

}
