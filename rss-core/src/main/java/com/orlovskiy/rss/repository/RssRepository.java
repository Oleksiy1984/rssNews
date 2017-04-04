package com.orlovskiy.rss.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orlovskiy.rss.entity.RssFeedEntryEntity;

@Repository
public interface RssRepository extends JpaRepository<RssFeedEntryEntity, Long> {
    Page<RssFeedEntryEntity> findAll(Pageable pageable);

}
