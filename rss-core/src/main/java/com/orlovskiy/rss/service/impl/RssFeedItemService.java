package com.orlovskiy.rss.service.impl;

import com.orlovskiy.rss.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.orlovskiy.rss.entity.RssFeedEntryEntity;
import com.orlovskiy.rss.service.IRssFeedItemService;

import java.util.List;

/**
 * Author: Daniel
 */
@Service
public class RssFeedItemService implements IRssFeedItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<RssFeedEntryEntity> findAll() {
        return itemRepository.findAll();
    }

    public List<RssFeedEntryEntity> find20NewestEntries() {
        PageRequest pageRequest = new PageRequest(0, 20, Sort.Direction.DESC, "publishedDate");
        return itemRepository.findAll(pageRequest).getContent();
    }




}
