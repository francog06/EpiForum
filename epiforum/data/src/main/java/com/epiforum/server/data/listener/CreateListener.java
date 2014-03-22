package com.epiforum.server.data.listener;

import java.util.Date;

import javax.persistence.PrePersist;

public class CreateListener {

	@PrePersist
	public void onPrePersist(Object o) {
		if (o instanceof ICreateListener) {
			ICreateListener record = (ICreateListener) o;
			record.setCreated(new Date());
		}
		if (o instanceof IUpdateListener) {
			IUpdateListener record = (IUpdateListener) o;
			record.setModified(new Date());
		}
	}
}