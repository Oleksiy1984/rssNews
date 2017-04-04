package com.orlovskiy.rss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orlovskiy.rss.entity.UserRoleEntity;


public interface RoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(String name);

}
