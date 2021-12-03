package com.bridgelabz.repository;

import com.bridgelabz.entity.GreetingAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To implement an interface which does the database operations
 *
 * @author SUDIP PANJA
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
public interface GreetingAppRepository extends JpaRepository<GreetingAppEntity, Integer> {
}
