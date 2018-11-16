package com.claro.loginautomaticocvideo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claro.loginautomaticocvideo.domain.Actions;

@Repository
public interface ActionsRepository extends MongoRepository<Actions, String>, ActionsRepositoryCustom{
	public Actions findById(@Param("id") String id);
}
