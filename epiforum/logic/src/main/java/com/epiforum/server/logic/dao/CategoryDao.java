package com.epiforum.server.logic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoryDao {

	@PersistenceContext(unitName="epiforum")
	protected EntityManager	em;
}