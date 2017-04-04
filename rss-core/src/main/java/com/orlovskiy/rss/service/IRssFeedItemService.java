package com.orlovskiy.rss.service;

import com.orlovskiy.rss.entity.RssFeedEntryEntity;

import java.util.List;


public interface IRssFeedItemService  {

    public List<RssFeedEntryEntity> findAll();

    public List<RssFeedEntryEntity> find20NewestEntries();





}
