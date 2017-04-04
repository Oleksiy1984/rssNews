package com.orlovskiy.rss.service;

import com.orlovskiy.rss.entity.RssFeedEntity;


public interface IRssFeedService {

    void save(RssFeedEntity rssFeedEntity, String name);

    void saveAll(RssFeedEntity rssFeedEntity);

    void reloadChannels();

    RssFeedEntity findOne(Long id);

    void delete(RssFeedEntity rssFeedEntity);
}
