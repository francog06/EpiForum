package com.epiforum.server.data.listener;

import java.util.Date;

public interface IUpdateListener {

	public Date getModified();

	public void setModified(Date date);
}
