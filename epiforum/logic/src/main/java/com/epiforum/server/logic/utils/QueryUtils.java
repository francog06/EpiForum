package com.epiforum.server.logic.utils;


import java.util.List;

import javax.persistence.Query;

public class QueryUtils {

	@SuppressWarnings("unchecked")
	public static <T> T getSingleResultOrNull(Query query) {
		query.setMaxResults(1);
		List<T> list = query.getResultList();
		if (list == null || list.size() == 0)
			return null;

		return list.get(0);
	}
}
