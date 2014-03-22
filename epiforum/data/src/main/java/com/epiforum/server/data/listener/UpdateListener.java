package com.epiforum.server.data.listener;

import java.util.Date;

import javax.persistence.PreUpdate;

public class UpdateListener {

	@PreUpdate
	public void onPreUpdate(Object o) {
		if (o instanceof IUpdateListener) {
			IUpdateListener record = (IUpdateListener) o;
			record.setModified(new Date());
		}
	}
}
