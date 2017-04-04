package com.orlovskiy.rss.service;

import com.orlovskiy.rss.exception.RSSException;
import com.orlovskiy.rss.entity.RssFeedEntryEntity;

import java.io.File;
import java.util.List;


public interface IRssService {

    List<RssFeedEntryEntity> getItems(File file) throws RSSException;

    List<RssFeedEntryEntity> getItems(String url) throws RSSException;

}
