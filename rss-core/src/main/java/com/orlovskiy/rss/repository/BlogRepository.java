package com.orlovskiy.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orlovskiy.rss.entity.RssFeedEntity;
import com.orlovskiy.rss.entity.UserEntity;

import java.util.List;


public interface BlogRepository extends JpaRepository<RssFeedEntity, Long> {

    List<RssFeedEntity> findByUserEntity(UserEntity userEntity);

}
