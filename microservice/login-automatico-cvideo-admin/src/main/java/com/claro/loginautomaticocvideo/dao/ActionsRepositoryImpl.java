package com.claro.loginautomaticocvideo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.claro.loginautomaticocvideo.domain.Actions;

public class ActionsRepositoryImpl implements ActionsRepositoryCustom{

	@Autowired
	private MongoOperations mongoOperation;
	
	@Override
	public Actions getActionsForIdRequest(String idRequest) {
		Query query = new Query();
		query.addCriteria(Criteria.where("idRequest").is(idRequest));
		Actions action = mongoOperation.findOne(query, Actions.class);
		return action;
	}

}
