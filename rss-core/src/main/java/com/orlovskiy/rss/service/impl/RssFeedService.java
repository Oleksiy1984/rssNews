package com.orlovskiy.rss.service.impl;

import com.orlovskiy.rss.entity.RssFeedEntity;
import com.orlovskiy.rss.exception.RSSException;
import com.orlovskiy.rss.repository.BlogRepository;
import com.orlovskiy.rss.repository.ItemRepository;
import com.orlovskiy.rss.repository.UserRepository;
import com.orlovskiy.rss.service.IRssFeedService;
import com.orlovskiy.rss.util.log.AutowiredLogger;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.orlovskiy.rss.entity.RssFeedEntryEntity;
import com.orlovskiy.rss.entity.UserEntity;

import java.util.Date;
import java.util.List;

/**
 * Author: Daniel
 */
@Service
@Transactional
public class RssFeedService implements IRssFeedService {

    @AutowiredLogger
    private Logger logger;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RssService rssService;

    @Override
    public void save(RssFeedEntity rssFeedEntity, String name) {
        UserEntity userEntity = userRepository.findByName(name);
        rssFeedEntity.setUserEntity(userEntity);
        blogRepository.save(rssFeedEntity);
        saveAll(rssFeedEntity);
    }

    @Override
    public void saveAll(RssFeedEntity rssFeedEntity) {
        try {
            List<RssFeedEntryEntity> itemEntities = rssService.getItems(rssFeedEntity.getUrl());
            itemEntities.forEach(entry -> {
                RssFeedEntryEntity savedRssFeedEntryEntity =
                        itemRepository.findByRssFeedEntityAndLink(rssFeedEntity, entry.getLink());
                if (savedRssFeedEntryEntity == null) {
                    entry.setRssFeedEntity(rssFeedEntity);
                    itemRepository.save(entry);
                }
            });
        } catch (RSSException e) {
            logger.error("Could not save blog", e);
        }
    }

    @Scheduled(cron = "${pl.dmichalski.rss.core.service.scheduleCron}")
    public void reloadChannels() {
        blogRepository.findAll().stream().forEach(this::saveAll);
        System.out.println(new Date()+" call ReloadChenals");
    }

    @Override
    public RssFeedEntity findOne(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    @PreAuthorize("#blog.userEntity.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") RssFeedEntity rssFeedEntity) {
        blogRepository.delete(rssFeedEntity);
    }
}

