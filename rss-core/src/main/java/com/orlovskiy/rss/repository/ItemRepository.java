package com.orlovskiy.rss.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.orlovskiy.rss.entity.RssFeedEntity;
import com.orlovskiy.rss.entity.RssFeedEntryEntity;

import java.util.List;


public interface ItemRepository extends JpaRepository<RssFeedEntryEntity, Long> {

    List<RssFeedEntryEntity> findByRssFeedEntity(RssFeedEntity rssFeedEntity, Pageable pageable);

    RssFeedEntryEntity findByRssFeedEntityAndLink(RssFeedEntity rssFeedEntity, String link);


}
